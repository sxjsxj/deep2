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
import com.deep.two.model.query.QueryModel;
import com.deep.two.model.query.investorUser.InvestorUserFollowerCombineQueryModel;
import com.deep.two.model.result.DMLResultModel;
import com.deep.two.model.result.QueryListReturnVo;
import com.deep.two.model.result.ResultModel;
import com.deep.two.orm.FundRequirementFollowerId;
import com.deep.two.orm.InvestorFollower;
import com.deep.two.orm.InvestorFollowerId;
import com.deep.two.orm.InvestorUser;
import com.deep.two.service.BaseService;
import com.deep.two.service.investorUser.InvestorUserFollowerService;
import com.deep.two.util.JSONUtil;
import com.deep.two.util.ViewException;

@Controller("investorUserFollowerController")
@RequestMapping("/investorUserFollower")
public class InvestorUserFollowerController  extends BaseController<InvestorFollower> implements TemplateController<InvestorFollower>{
    @Autowired
    @Qualifier("investorUserFollowerService")
    private InvestorUserFollowerService investorUserFollowerService;
    
    @Override
   	public BaseService<InvestorFollower> getBaseService() {
   		return this.investorUserFollowerService;
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

    @RequestMapping("/getDetailPageForPersonalAdd")
    public ModelAndView getDetailPageForPersonalAdd() {
        return new ModelAndView("investorUser/investorPersonalUserDetail");
    }
    
    @RequestMapping("/getDetailPageForOrganizationAdd")
    public ModelAndView getDetailPageForOrganizationAdd() {
        return new ModelAndView("investorUser/investorOrganizationUserDetail");
    }

    @Override
    @RequestMapping("/getDetailPageForUpdate")
    public ModelAndView getDetailPageForUpdate(String id) {
        return new ModelAndView("deeptwo.investorUserDetail");
    }
    
    @RequestMapping("/getMyRecommendBrowsePage")
    public ModelAndView getMyRecommendBrowsePage() {
        return new ModelAndView("investorUser/myRecommendList");
    }
    
    @RequestMapping("/getMyRecommendAchievementBrowsePage")
    public ModelAndView getMyRecommendAchievementBrowsePage() {
        return new ModelAndView("investorUser/myRecommendAchievementList");
    }
    
    @RequestMapping("/getMyRecommendFundRequirementBrowsePage")
    public ModelAndView getMyRecommendFundRequirementBrowsePage() {
        return new ModelAndView("investorUser/myRecommendFundRequirementList");
    }
    
    @RequestMapping("/getMyRecommendResearchGroupBrowsePage")
    public ModelAndView getMyRecommendResearchGroupBrowsePage() {
        return new ModelAndView("investorUser/myRecommendResearchGroupList");
    }
    
    @RequestMapping("/getMoreInfoPage")
    public ModelAndView getMoreInfoPage() {
        return new ModelAndView("investorUser/investorMoreInfo");
    }

    @Override
    @RequestMapping("/add")
    @ResponseBody
    public DMLResultModel add(@RequestParam(value="file", required=false) MultipartFile[] files, @RequestParam("str")String str) {
        InvestorFollower ru = null;
        DMLResultModel dm = new DMLResultModel();
        try {
            ru = JSONUtil.jsonToModel(str, InvestorFollower.class, null);
            investorUserFollowerService.add(ru, files, getCurrentUser());
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
        List list = null;
        try {
            list = JSON.parseArray(str, InvestorFollowerId.class);
            investorUserFollowerService.delete(list, getCurrentUser());
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
        InvestorFollower ru = null;
        try {
            ru = JSONUtil.jsonToModel(str, InvestorFollower.class, null);
            investorUserFollowerService.update(ru, ru.getId(), files, getCurrentUser());
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
        InvestorUserFollowerCombineQueryModel model = null;
        try {
            model = JSONUtil.jsonToModel(str, InvestorUserFollowerCombineQueryModel.class, null);
            //model.getInvestorUserFollowerQueryModel().setRemoveFlag("0");
            list = investorUserFollowerService.combineQueryList(model, pagination, getCurrentUser());
        } catch (ViewException e) {
            LOGGER.error(e.getMessage());
        }
		return JSON.toJSONString(list);
    }

    @Override
    @RequestMapping("getDetail")
    @ResponseBody
    public String getDetail(@RequestParam("id") String id) {
        InvestorFollower ru = null;
        try {
            ru = investorUserFollowerService.getDetail(id, getCurrentUser());
        } catch (ViewException e) {
            LOGGER.error(e.getMessage());
        }
        return JSON.toJSONString(ru);
    }
}
