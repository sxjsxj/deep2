package com.deep.two.service.authority.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.deep.two.authority.checker.PasswordChecker;
import com.deep.two.authority.helper.Md5Singleton;
import com.deep.two.authority.helper.UserHelper;
import com.deep.two.authority.model.CurrentUser;
import com.deep.two.authority.model.PasswordModel;
import com.deep.two.authority.model.RoleModel;
import com.deep.two.authority.model.UserModel;
import com.deep.two.dao.util.CommonProcessUtil;
import com.deep.two.dao.util.CriterionUnit;
import com.deep.two.dao.util.DaoUtil;
import com.deep.two.dao.util.Operator;
import com.deep.two.dao.util.Pagination;
import com.deep.two.dao.util.StatusProcessUtil;
import com.deep.two.model.ApproveModel;
import com.deep.two.model.CompanyUserModel;
import com.deep.two.model.InvestorUserModel;
import com.deep.two.model.ResearchUserModel;
import com.deep.two.model.query.authority.UserQueryModel;
import com.deep.two.model.result.DMLResultModel;
import com.deep.two.model.result.QueryListReturnVo;
import com.deep.two.orm.Role;
import com.deep.two.orm.User;
import com.deep.two.orm.UserRole;
import com.deep.two.orm.UserRoleId;
import com.deep.two.service.authority.RoleService;
import com.deep.two.service.authority.UserService;
import com.deep.two.service.companyUser.CompanyUserService;
import com.deep.two.service.investorUser.InvestorUserService;
import com.deep.two.service.researchUser.ResearchUserService;
import com.deep.two.util.CopyUtil;
import com.deep.two.util.StringUtil;
import com.deep.two.util.ViewException;

@Service("userService")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
	@Autowired
	@Qualifier("daoUtil")
    private DaoUtil daoUtil;
    private UserHelper helper;
    
    @Autowired
    @Qualifier("researchUserService")
    private ResearchUserService researchUserService; 
    @Autowired
    private InvestorUserService investorUserService; 
    @Autowired
    @Qualifier("companyUserService")
    private CompanyUserService companyUserService; 
    @Autowired
    private RoleService roleService; 
    
    private void insertRole(User orm) {
    	UserRole userrole = new UserRole();
        UserRoleId UserRoleId = new UserRoleId(orm.getId(), orm.getUserType());
        userrole.setId(UserRoleId);
        this.daoUtil.insert(userrole);
    }

    @Override
    public DMLResultModel insert(UserModel model, CurrentUser userExtend) throws ViewException {
        Assert.notNull(model, "model对象不能为空");
        helper = new UserHelper(model, daoUtil);
        helper.check();
        RoleModel roleModel = new RoleModel();
        if (model.getUserType() != null) {
        	roleModel.setId(model.getUserType().trim());
        }
		model.getRoleModels().add(roleModel);
        User orm = helper.modelToOrm(userExtend);
        CommonProcessUtil.setCommon(orm, userExtend);
        this.daoUtil.insert(orm);
        this.insertRole(orm);
        DMLResultModel dm = new DMLResultModel(DMLResultModel.SUCCESS);
        return dm;
    }

    @Override
    public UserModel getDetail(String id) throws ViewException {
        Assert.notNull(id, "id不能为空");
        User user = this.daoUtil.queryById(User.class, id);
        UserModel modelReturn = CopyUtil.copyProperty(user, UserModel.class);
        for (UserRole cur : user.getUserRoles()) {
            RoleModel rm = CopyUtil.copyProperty(cur.getRole(), RoleModel.class);
            modelReturn.getRoleModels().add(rm);
        }
        return modelReturn;
    }

    @Override
    public DMLResultModel update(UserModel model, CurrentUser userExtend) throws ViewException {
        Assert.notNull(model, "model对象不能为空");
        Assert.notNull(model.getId(), "更新时，id不能为空");
        helper = new UserHelper(model, daoUtil);
        helper.check();
        this.daoUtil.getCurrentSession().clear();
        User User = this.daoUtil.queryById(User.class, model.getId());
        for (UserRole cra : User.getUserRoles()) {
            cra.getRole().setUserRoles(null);
            cra.getUser().setUserRoles(null);
            this.daoUtil.delete(cra);
        }
        this.daoUtil.getCurrentSession().flush();
        User orm = helper.modelToOrm(userExtend);
        orm.setPassword(User.getPassword());
        this.daoUtil.updateDBObject(User.class, model.getId(), orm);
        return new DMLResultModel(DMLResultModel.SUCCESS);
    }

    @Override
    public DMLResultModel delete(List<String> idList) throws ViewException {
        for (String id : idList) {
        	if(StringUtil.isEmpty(id)) continue;
            User user = this.daoUtil.queryById(User.class, id);
            if (user == null) {
                continue;
            }
            /*for (UserRole cur : user.getUserRoles()) {
                cur.getRole().setUserRoles(null);
            }
            this.daoUtil.delete(user);*/
            user.setRemoveFlag("1");
            this.daoUtil.update(user);
        }
        return new DMLResultModel(DMLResultModel.SUCCESS);
    }

    @Override
    public QueryListReturnVo<UserModel> query(UserQueryModel model, Pagination pagination) throws ViewException {
        helper = new UserHelper(null, daoUtil);
        return helper.query(model, pagination);
    }

    @Override
    public DMLResultModel changePassword(PasswordModel model, CurrentUser user) throws ViewException {
        PasswordChecker checker = new PasswordChecker(model, daoUtil);
        checker.check();
        this.daoUtil.getCurrentSession().clear();
        User User = this.daoUtil.queryById(User.class, model.getId());
        String md5Password = Md5Singleton.getInstance().encodePassword(model.getNewPassword(), User.getEmail());
        User.setPassword(md5Password);
        return new DMLResultModel(DMLResultModel.SUCCESS);
    }

    @Override
    public User queryById(String id) throws ViewException {
        return this.daoUtil.queryById(User.class, id);
    }

    @Override
    public DMLResultModel recoveryPassword(List<String> idList, CurrentUser userModel) throws ViewException {
        for (String id : idList) {
            User user = this.daoUtil.queryById(User.class, id);
            if (user == null) {
                continue;
            }
            String userName = user.getEmail();
            String password = userName.substring(0).toUpperCase()+userName.substring(1,3) + "123456";
            String md5Password = Md5Singleton.getInstance().encodePassword(password, userName);
            user.setPassword(md5Password);
        }
        return new DMLResultModel(DMLResultModel.SUCCESS);
    }

    @Override
	public DMLResultModel insertCompanyUser(CompanyUserModel model, CurrentUser userExtend) throws ViewException {
		Assert.notNull(model, "model对象不能为空");
        helper = new UserHelper(model.getUserModel(), daoUtil);
        helper.check();
        RoleModel roleModel = new RoleModel();
        if (model.getUserModel().getUserType() != null) {
        	roleModel.setId(model.getUserModel().getUserType().trim());
        }
        model.getUserModel().getRoleModels().add(roleModel);
        User orm = helper.modelToOrm(userExtend);
        CommonProcessUtil.setCommon(orm, userExtend);
        this.daoUtil.insert(orm);
        this.insertRole(orm);
        model.getCompanyUser().setUser(orm);
        companyUserService.add(model.getCompanyUser(), null, userExtend);
        return new DMLResultModel(DMLResultModel.SUCCESS);
	}
    
	@Override
	public DMLResultModel insertResearchUser(ResearchUserModel model, CurrentUser userExtend) throws ViewException {
		Assert.notNull(model, "model对象不能为空");
        helper = new UserHelper(model.getUserModel(), daoUtil);
        helper.check();
        RoleModel roleModel = new RoleModel();
        if (model.getUserModel().getUserType() != null) {
        	roleModel.setId(model.getUserModel().getUserType().trim());
        }
        model.getUserModel().getRoleModels().add(roleModel);
        User orm = helper.modelToOrm(userExtend);
        CommonProcessUtil.setCommon(orm, userExtend);
        this.daoUtil.insert(orm);
        this.insertRole(orm);
        model.getResearchUser().setUser(orm);
        researchUserService.add(model.getResearchUser(), null, userExtend);
        return new DMLResultModel(DMLResultModel.SUCCESS);
	}
	
	@Override
	public DMLResultModel insertInvestorUser(InvestorUserModel model, CurrentUser currentUser) throws ViewException {
		Assert.notNull(model, "model对象不能为空");
        helper = new UserHelper(model.getUserModel(), daoUtil);
        helper.check();
        RoleModel roleModel = new RoleModel();
        if (model.getUserModel().getUserType() != null) {
        	roleModel.setId(model.getUserModel().getUserType().trim());
        }
        model.getUserModel().getRoleModels().add(roleModel);
        User orm = helper.modelToOrm(currentUser);
        CommonProcessUtil.setCommon(orm, currentUser);
        this.daoUtil.insert(orm);
        this.insertRole(orm);
        model.getInvestorUser().setUser(orm);
        investorUserService.add(model.getInvestorUser(), null, currentUser);
        return new DMLResultModel(DMLResultModel.SUCCESS);
	}
	
	@Override
    public void approve(ApproveModel am, CurrentUser currentUser) throws ViewException{
		for (Serializable id : am.getIdList()) {
			if(id==null || id.toString().equals("")) continue;
    		User t = daoUtil.queryById(User.class, id);
    		StatusProcessUtil.setStatus(t, am.getStatus());
    		StatusProcessUtil.setCommunicateStatus(t, am.getCommunicateStatus());
    		StatusProcessUtil.setRemark(t, am.getRemark());
    	}
    }

	@Override
	public DMLResultModel updateEmailTel(UserModel userModel, CurrentUser currentUser) throws ViewException {
		 User user = this.daoUtil.queryById(User.class, userModel.getId());
		 helper = new UserHelper(userModel, daoUtil);
	     helper.check();
		 if (!StringUtil.isEmpty(userModel.getEmail())) {
			 user.setEmail(userModel.getEmail());
		 }
		 if (!StringUtil.isEmpty(userModel.getTelno())) {
			 user.setTelno(userModel.getTelno());
		 }
		 return new DMLResultModel(DMLResultModel.SUCCESS);
	}

	@Override
	public DMLResultModel resetPassword(UserModel model,
			CurrentUser userModel2) throws ViewException {
		List<CriterionUnit> cuList = new ArrayList<CriterionUnit>();
        cuList.add(new CriterionUnit("email", model.getEmail()));
        List<User> list = daoUtil.queryList(cuList, User.class);
        if (list == null || list.isEmpty()) {
        	ViewException ve = new ViewException("该邮箱未注册！");
            throw ve;
        }
        User user = list.get(0);
        String md5Password = Md5Singleton.getInstance().encodePassword(model.getPassword(), user.getEmail());
        user.setPassword(md5Password);
        return new DMLResultModel(DMLResultModel.SUCCESS);
	}

	@Override
	public DMLResultModel insertAdminUser(UserModel model, CurrentUser userExtend) throws ViewException {
		Assert.notNull(model, "model对象不能为空");
        helper = new UserHelper(model, daoUtil);
        helper.check();
        RoleModel roleModel = new RoleModel();
        if (model.getUserType() != null) {
        	roleModel.setId(model.getUserType().trim());
        }
        model.getRoleModels().add(roleModel);
        User orm = helper.modelToOrm(userExtend);
        CommonProcessUtil.setCommon(orm, userExtend);
        this.daoUtil.insert(orm);
        this.insertRole(orm);
        return new DMLResultModel(DMLResultModel.SUCCESS);
	}
}
