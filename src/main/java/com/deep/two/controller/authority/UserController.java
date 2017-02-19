package com.deep.two.controller.authority;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.deep.two.authority.model.CurrentUser;
import com.deep.two.authority.model.PasswordModel;
import com.deep.two.authority.model.UserModel;
import com.deep.two.controller.BaseController;
import com.deep.two.controller.TemplateController;
import com.deep.two.controller.basic.BasicUniversityController;
import com.deep.two.dao.util.Pagination;
import com.deep.two.model.ApproveModel;
import com.deep.two.model.CompanyUserModel;
import com.deep.two.model.InvestorUserModel;
import com.deep.two.model.ResearchUserModel;
import com.deep.two.model.query.authority.UserQueryModel;
import com.deep.two.model.result.DMLResultModel;
import com.deep.two.model.result.QueryListReturnVo;
import com.deep.two.orm.BasicUniversity;
import com.deep.two.service.BaseService;
import com.deep.two.service.authority.EmailService;
import com.deep.two.service.authority.UserService;
import com.deep.two.util.JSONUtil;
import com.deep.two.util.ViewException;

@RequestMapping("security/user")
@Controller
public class UserController extends BaseController<UserModel> implements TemplateController<UserModel>{
    
    @Autowired
    private UserService userService;
    @Autowired
    private EmailService emailService;
    
    @Autowired
    private BasicUniversityController basicUniversityController;

    @Override
    @RequestMapping("getBrowsePage")
    public ModelAndView getBrowsePage(@RequestParam(value = "name", required = false)String name) {
        return new ModelAndView("deeptwo.userBrowse");
    }
    
    @RequestMapping("getChangePasswordPage")
    public ModelAndView getChangePasswordPage() {
        return new ModelAndView("user/changePassword");
    }
    
    @Override
    @RequestMapping("getDetailPageForAdd")
    @ResponseBody
    public ModelAndView getDetailPageForAdd() {
        ModelAndView modelAndView = new ModelAndView("deeptwo.userDetail");
        modelAndView.addObject(BaseController.ACTION, BaseController.ADD);
        return modelAndView;
    }

    @Override
    @RequestMapping("getDetailPageForUpdate")
    @ResponseBody
    public ModelAndView getDetailPageForUpdate(@RequestParam("id")String id) {
        ModelAndView modelAndView = new ModelAndView("deeptwo.userDetail");
        modelAndView.addObject(BaseController.ACTION, BaseController.UPDATE);
        modelAndView.addObject("editId", id);
        return modelAndView;
    }

    @Override
    @RequestMapping("add")
    @ResponseBody
    public DMLResultModel add(@RequestParam(value="file", required=false) MultipartFile[] files, @RequestParam("str")String str) {
        DMLResultModel dmlResultModel = new DMLResultModel();
        UserModel model = null;
        try {
            model = JSONUtil.jsonToModel(str, UserModel.class, null);
            dmlResultModel = userService.insert(model, getCurrentUser());
        } catch (ViewException e) {
            LOGGER.error(e.getMessage(), e);
            dmlResultModel = e.getResultModel();
        } 
        return dmlResultModel;
    }
    
    @RequestMapping("addCompanyUser")
    @ResponseBody
    public DMLResultModel addCompanyUser(@RequestParam(value="file", required=false) MultipartFile[] files, @RequestParam("str")String str) {
        DMLResultModel dmlResultModel = new DMLResultModel();
        CompanyUserModel model = null;
        try {
        	model = JSONUtil.jsonToModel(str, CompanyUserModel.class, null);
        	dmlResultModel = userService.insertCompanyUser(model, getCurrentUser());
        } catch (ViewException e) {
            LOGGER.error(e.getMessage(), e);
            dmlResultModel = e.getResultModel();
        } 
        return dmlResultModel;
    }
    
    @RequestMapping("addInvestorUser")
    @ResponseBody
    public DMLResultModel addInvestorUser(@RequestParam(value="file", required=false) MultipartFile[] files, @RequestParam("str")String str) {
        DMLResultModel dmlResultModel = new DMLResultModel();
        InvestorUserModel model = null;
        try {
        	model = JSONUtil.jsonToModel(str, InvestorUserModel.class, null);
        	dmlResultModel = userService.insertInvestorUser(model, getCurrentUser());
        } catch (ViewException e) {
            LOGGER.error(e.getMessage(), e);
            dmlResultModel = e.getResultModel();
        } 
        return dmlResultModel;
    }
    
    @RequestMapping("addResearchUser")
    @ResponseBody
    public DMLResultModel addResearchUser(@RequestParam(value="file", required=false) MultipartFile[] files, @RequestParam("str")String str) {
        DMLResultModel dmlResultModel = new DMLResultModel();
        ResearchUserModel model = null;
        try {
        	model = JSONUtil.jsonToModel(str, ResearchUserModel.class, null);
        	if (model.getResearchUser().getType().equals("0")) {
        		String uniName = model.getResearchUser().getUniName();
        		BasicUniversity bu = basicUniversityController.queryUniversityMap().get(uniName);
        		//设置高校其他信息
        		model.getResearchUser().setUniProvince(bu.getProvince());
        		model.getResearchUser().setUniCity(bu.getCity());
        		model.getResearchUser().setUniDepartment(bu.getDepartment());
        		model.getResearchUser().setUniLevel(bu.getLevel());
        		model.getResearchUser().setUniNationalPriority(bu.getNationalPriority());
        		model.getResearchUser().setUniNature(bu.getNature());
        		model.getResearchUser().setUniProject211(bu.getProject211());
        		model.getResearchUser().setUniProject985(bu.getProject985());
        		model.getResearchUser().setAddress(bu.getAddress());
        		model.getResearchUser().setIntroduction(bu.getIntroduction());
        	}
        	dmlResultModel = userService.insertResearchUser(model, getCurrentUser());
        } catch (ViewException e) {
            LOGGER.error(e.getMessage(), e);
            dmlResultModel = e.getResultModel();
        } 
        return dmlResultModel;
    }
    
    @Override
    @RequestMapping("delete")
    @ResponseBody
    public DMLResultModel delete(@RequestParam("str") String str) {
        DMLResultModel dmlResultModel = new DMLResultModel();
        List<String> list = null;
        try {
            list = JSONUtil.jsonToModel(str, List.class, null);
            dmlResultModel = userService.delete(list);
        } catch (ViewException e) {
            LOGGER.error(e.getMessage());
            dmlResultModel = e.getResultModel();
        } 
        return dmlResultModel;
    }

    @Override
    @RequestMapping("update")
    @ResponseBody
    public DMLResultModel update(@RequestParam(value="file", required=false) MultipartFile[] files, @RequestParam("str")String str) {
        DMLResultModel dmlResultModel = new DMLResultModel();
        UserModel model = null;
        try {
            model = JSONUtil.jsonToModel(str, UserModel.class, null);
            dmlResultModel = userService.update(model, getCurrentUser());
        } catch (ViewException e) {
            LOGGER.error(e.getMessage());
            dmlResultModel = e.getResultModel();
        } 
        return dmlResultModel;
    }
    
    @RequestMapping("updateEmailTel")
    @ResponseBody
    public DMLResultModel updateEmailTel(@RequestParam(value="file", required=false) MultipartFile[] files, @RequestParam("str")String str) {
        DMLResultModel dmlResultModel = new DMLResultModel();
        UserModel model = null;
        try {
            model = JSONUtil.jsonToModel(str, UserModel.class, null);
            dmlResultModel = userService.updateEmailTel(model, getCurrentUser());
        } catch (ViewException e) {
            LOGGER.error(e.getMessage());
            dmlResultModel = e.getResultModel();
        } 
        return dmlResultModel;
    }

    @Override
    @RequestMapping("query")
    @ResponseBody
    public String query(@RequestParam("str") String str,
            @ModelAttribute("com.deep.two.dao.util.Pagination") Pagination pagination) {
        QueryListReturnVo<UserModel> list = null;
        try {
        	UserQueryModel vo = JSONUtil.jsonToModel(str, UserQueryModel.class, null);
            list = userService.query(vo, pagination);
        } catch (ViewException e) {
            LOGGER.error(e.getMessage());
        }
        return JSON.toJSONString(list);
    }

    @Override
    @RequestMapping("getDetail")
    @ResponseBody
    public String getDetail(@RequestParam("id") String id) {
        UserModel model = null;
        try {
            model = userService.getDetail(id);
        } catch (ViewException e) {
            LOGGER.error(e.getMessage());
        }
        return JSON.toJSONString(model);
    }
    
    @RequestMapping("recoveryPassword")
    @ResponseBody
    public DMLResultModel recoveryPassword(@RequestParam("str") String str) {
        DMLResultModel dmlResultModel = new DMLResultModel();
        List<String> list = null;
        try {
            list = JSONUtil.jsonToModel(str, List.class, null);
            dmlResultModel = userService.recoveryPassword(list, getCurrentUser());
        } catch (ViewException e) {
            LOGGER.error(e.getMessage());
            dmlResultModel = e.getResultModel();
        } 
        return dmlResultModel;
    }
    

    @RequestMapping("changePassword")
    @ResponseBody
    public DMLResultModel changePassword(@RequestParam("str") String str) {
        DMLResultModel dmlResultModel = new DMLResultModel();
        PasswordModel model = null;
        try {
            model = JSONUtil.jsonToModel(str, PasswordModel.class, null);
            dmlResultModel = userService.changePassword(model, getCurrentUser());
        } catch (ViewException e) {
            LOGGER.error(e.getMessage());
            dmlResultModel = e.getResultModel();
        } 
        return dmlResultModel;
    }
    
    @Override
	public BaseService<UserModel> getBaseService() {
		return null;
	}
    
    @Override
    @RequestMapping("approve")
    @ResponseBody
    public DMLResultModel approve(@RequestParam("str") String str) {
    	ApproveModel am = null;
        DMLResultModel dm = new DMLResultModel();
        try {
        	am = JSON.parseObject(str, ApproveModel.class);
        	this.userService.approve(am, getCurrentUser());
        } catch (ViewException e) {
            LOGGER.error(e.getMessage());
            dm = e.getResultModel();
        }
        return dm;
    }
    
    @RequestMapping("sendEmail")
    @ResponseBody
    public DMLResultModel sendEmail(@RequestParam("str") String str) {
        DMLResultModel dm = new DMLResultModel();
        boolean flag;
		try {
			flag = emailService.sendEmail(str);
			if (flag) {
	        	dm.setStatus(DMLResultModel.SUCCESS);
	        	dm.getInfoList().add("发送成功！");
	        } else {
	        	dm.setStatus(DMLResultModel.ERROR);
	        	dm.getErrorList().add("发送失败！");
	        }
		} catch (ViewException e) {
			 LOGGER.error(e.getMessage());
	         dm = e.getResultModel();
		}
        return dm;
    }
    
    @RequestMapping("resetPassword")
    @ResponseBody
    public DMLResultModel resetPassword(@RequestParam("str") String str) {
        DMLResultModel dmlResultModel = new DMLResultModel();
        UserModel model = null;
        try {
            model = JSONUtil.jsonToModel(str, UserModel.class, null);
            if (emailService.validateCode(model.getEmail(), model.getValidateCode())) {
            	dmlResultModel = userService.resetPassword(model, getCurrentUser());
            } else {
            	ViewException ve = new ViewException("验证失败！");
		        throw ve;
            }
        } catch (ViewException e) {
            LOGGER.error(e.getMessage());
            dmlResultModel = e.getResultModel();
        } 
        return dmlResultModel;
    }
    
  
}
