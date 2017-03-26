package com.deep.two.controller.companyUser;

import java.io.Serializable;
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
import com.deep.two.controller.BaseController;
import com.deep.two.controller.TemplateController;
import com.deep.two.controller.authority.SecurityController;
import com.deep.two.dao.util.Pagination;
import com.deep.two.model.query.companyUser.CompanyUserCombineQueryModel;
import com.deep.two.model.result.DMLResultModel;
import com.deep.two.model.result.QueryListReturnVo;
import com.deep.two.model.result.ResultModel;
import com.deep.two.model.result.companyUser.CompanyUserResultModel;
import com.deep.two.orm.CompanyUser;
import com.deep.two.service.BaseService;
import com.deep.two.service.companyUser.CompanyUserService;
import com.deep.two.util.CollectionUtil;
import com.deep.two.util.JSONUtil;
import com.deep.two.util.ViewException;

@Controller("companyUserController")
@RequestMapping("/companyUser")
public class CompanyUserController  extends BaseController<CompanyUser> implements TemplateController<CompanyUser>{
    
    @Autowired
    @Qualifier("companyUserService")
    private CompanyUserService companyUserService;
    
    @Autowired
    private SecurityController securityController;
    
    @Override
   	public BaseService<CompanyUser> getBaseService() {
   		return this.companyUserService;
   	}
    
    @Override
    @RequestMapping("/getBrowsePage")
    public ModelAndView getBrowsePage(@RequestParam(value = "name", required = false)String name) {
        return new ModelAndView("");
    }

    @Override
    @RequestMapping("/getDetailPageForAdd")
    public ModelAndView getDetailPageForAdd() {
        return new ModelAndView("companyUser/companyUserDetailBody");
    }

    @Override
    @RequestMapping("/getDetailPageForUpdate")
    public ModelAndView getDetailPageForUpdate(String id) {
        return new ModelAndView("companyUser/companyUserDetailBody");
    }

    @RequestMapping("getChangePasswordPage")
    public ModelAndView getChangePasswordPage() {
        return new ModelAndView("companyUser/updateMyPasswordInfo");
    }
    
    @RequestMapping("/getMyRequirementBrowsePage")
    public ModelAndView getMyRequirementBrowsePage() {
        return new ModelAndView("companyUser/myRequirement");
    }
    
    @RequestMapping("/getMyRecommendAchievementBrowsePage")
    public ModelAndView getMyRecommendBrowsePage() {
        return new ModelAndView("companyUser/myRecommendAchievementList");
    }
    
    @RequestMapping("/getMyCollectionAchievementBrowsePage")
    public ModelAndView getMyCollectionAchievementBrowsePage() {
        return new ModelAndView("companyUser/myCollectionAchievementList");
    }
    
    @RequestMapping("/getMyCollectionResearchGroupBrowsePage")
    public ModelAndView getMyCollectionResearchGroupBrowsePage() {
        return new ModelAndView("companyUser/myCollectionResearchGroupList");
    }
    
    @RequestMapping("/getMyCollectionInvestorBrowsePage")
    public ModelAndView getMyCollectionInvestorBrowsePage() {
        return new ModelAndView("companyUser/myCollectionInvestorList");
    }
    
    @Override
    @RequestMapping("/add")
    @ResponseBody
    public DMLResultModel add(@RequestParam(value="file", required=false) MultipartFile[] files, @RequestParam("str")String str) {
        CompanyUser ru = null;
        DMLResultModel dm = new DMLResultModel();
        try {
            ru = JSONUtil.jsonToModel(str, CompanyUser.class, null);
            companyUserService.add(ru, files, getCurrentUser());
        } catch (ViewException e) {
            LOGGER.error(e.getMessage());
            dm = e.getResultModel();
        }
        return dm;
    }

    @Override
    @RequestMapping("delete")
    @ResponseBody
    public DMLResultModel delete(@RequestParam("str") String str) {
        DMLResultModel dmlResultModel = new DMLResultModel();
        List<Serializable> list = null;
        try {
            list = JSONUtil.jsonToModel(str, List.class, null);
            companyUserService.delete(list, getCurrentUser());
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
        CompanyUser ru = null;
        try {
            ru = JSONUtil.jsonToModel(str, CompanyUser.class, null);
            companyUserService.update(ru, ru.getId(), files, getCurrentUser());
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
        QueryListReturnVo<? extends ResultModel> list = null;
        CompanyUserCombineQueryModel model = null;
        try {
            model = JSONUtil.jsonToModel(str, CompanyUserCombineQueryModel.class, null);
            //model.getCompanyUserQueryModel().setRemoveFlag("0");
            list = companyUserService.combineQueryList(model, pagination, getCurrentUser());
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return JSON.toJSONString(list);
    }

    @Override
    @RequestMapping("getDetail")
    @ResponseBody
    public String getDetail(@RequestParam("id") String id) {
    	ResultModel ru = null;
        try {
            ru = companyUserService.getDDetail(id, getCurrentUser());
        } catch (ViewException e) {
            LOGGER.error(e.getMessage());
        }
        return JSON.toJSONString(ru);
    }
    
    public ResultModel getCompanyUser() {
    	ResultModel cm = new CompanyUserResultModel();
    	CurrentUser cu = securityController.getCurrentUser();
    	if(!CollectionUtil.isEmpty(cu.getCompanyUserModels())) {
    		String id = cu.getCompanyUserModels().get(0).getId();
    		try {
				cm = companyUserService.getDDetail(id, null);
			} catch (ViewException e) {
			}
    	}
    	return cm;
    }
}
