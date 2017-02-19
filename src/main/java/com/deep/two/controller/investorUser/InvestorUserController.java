package com.deep.two.controller.investorUser;

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
import com.deep.two.controller.BaseController;
import com.deep.two.controller.TemplateController;
import com.deep.two.dao.util.Pagination;
import com.deep.two.model.RecommendModel;
import com.deep.two.model.query.investorUser.InvestorUserCombineQueryModel;
import com.deep.two.model.result.DMLResultModel;
import com.deep.two.model.result.QueryListReturnVo;
import com.deep.two.model.result.ResultModel;
import com.deep.two.orm.InvestorUser;
import com.deep.two.service.BaseService;
import com.deep.two.service.investorUser.InvestorUserService;
import com.deep.two.util.JSONUtil;
import com.deep.two.util.ViewException;

@Controller("investorUserController")
@RequestMapping("/investorUser")
public class InvestorUserController  extends BaseController<InvestorUser> implements TemplateController<InvestorUser>{
    @Autowired
    @Qualifier("investorUserService")
    private InvestorUserService investorUserService;
    
    @Override
   	public BaseService<InvestorUser> getBaseService() {
   		return this.investorUserService;
   	}
    
    @Override
    @RequestMapping("/getBrowsePage")
    public ModelAndView getBrowsePage(@RequestParam(value = "name", required = false)String name) {
        ModelAndView model = new ModelAndView("investorUser/investorList");
   		model.addObject("headerName", name);
   		return model;
    }
    
    @Override
	public ModelAndView getDetailPageForAdd() {
		return null;
	}

    @RequestMapping("/getPersonalUserDetailPageForAdd")
    public ModelAndView getPersonalUserDetailPageForAdd() {
        return new ModelAndView("investorUser/investorPersonalUserDetail");
    }
    
    @RequestMapping("/getOrganizationUserDetailPageForAdd")
    public ModelAndView getOrganizationUserDetailPageForAdd() {
        return new ModelAndView("investorUser/investorOrganizationUserDetail");
    }

    @Override
    @RequestMapping("/getDetailPageForUpdate")
    public ModelAndView getDetailPageForUpdate(String id) {
        return new ModelAndView("deeptwo.investorUserDetail");
    }
    
    @RequestMapping("getChangePasswordPage")
    public ModelAndView getChangePasswordPage() {
        return new ModelAndView("investorUser/updateMyPasswordInfo");
    }
    
    @RequestMapping("/getMyRecommendBrowsePage")
    public ModelAndView getMyRecommendBrowsePage() {
        return new ModelAndView("investorUser/myRecommendList");
    }
    
    @RequestMapping("/getMyCollectionAchievementBrowsePage")
    public ModelAndView getMyRecommendAchievementBrowsePage() {
        return new ModelAndView("investorUser/myCollectionAchievementList");
    }
    
    @RequestMapping("/getMyCollectionFundRequirementBrowsePage")
    public ModelAndView getMyRecommendFundRequirementBrowsePage() {
        return new ModelAndView("investorUser/myCollectionFundRequirementList");
    }
    
    @RequestMapping("/getMyCollectionResearchGroupBrowsePage")
    public ModelAndView getMyRecommendResearchGroupBrowsePage() {
        return new ModelAndView("investorUser/myCollectionResearchGroupList");
    }
    
    @RequestMapping("/getMoreInfoPage")
    public ModelAndView getMoreInfoPage(String id) {
        ModelAndView mv = new ModelAndView("investorUser/investorMoreInfo");
    	mv.addObject("id", id);
        return mv;
    }

    @Override
    @RequestMapping("/add")
    @ResponseBody
    public DMLResultModel add(@RequestParam(value="file", required=false) MultipartFile[] files, @RequestParam("str")String str) {
        InvestorUser ru = null;
        DMLResultModel dm = new DMLResultModel();
        try {
            ru = JSONUtil.jsonToModel(str, InvestorUser.class, null);
            investorUserService.add(ru, files, getCurrentUser());
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
            investorUserService.delete(list, getCurrentUser());
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
        InvestorUser ru = null;
        try {
            ru = JSONUtil.jsonToModel(str, InvestorUser.class, null);
            investorUserService.update(ru, ru.getId(), files, getCurrentUser());
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
        InvestorUserCombineQueryModel model = null;
        try {
            model = JSONUtil.jsonToModel(str, InvestorUserCombineQueryModel.class, null);
            //model.getInvestorUserQueryModel().setRemoveFlag("0");
            list = investorUserService.combineQueryList(model, pagination, getCurrentUser());
        } catch (ViewException e) {
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
            ru = investorUserService.getDDetail(id, getCurrentUser());
        } catch (ViewException e) {
            LOGGER.error(e.getMessage());
        }
        return JSON.toJSONString(ru);
    }
    
    @Override
    @RequestMapping("recommend")
    @ResponseBody
    public DMLResultModel recommend(@RequestParam("str") String str) {
    	RecommendModel rm = null;
        DMLResultModel dm = new DMLResultModel();
        try {
            rm = JSON.parseObject(str, RecommendModel.class);
            investorUserService.recommend(rm, getCurrentUser());
        } catch (ViewException e) {
            LOGGER.error(e.getMessage());
            dm = e.getResultModel();
        }
        return dm;
    }
}
