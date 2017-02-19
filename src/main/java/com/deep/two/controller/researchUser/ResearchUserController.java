package com.deep.two.controller.researchUser;

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
import com.deep.two.model.query.researchUser.ResearchUserQueryModel;
import com.deep.two.model.result.DMLResultModel;
import com.deep.two.model.result.QueryListReturnVo;
import com.deep.two.model.result.ResultModel;
import com.deep.two.orm.ResearchUser;
import com.deep.two.service.BaseService;
import com.deep.two.service.researchUser.ResearchUserService;
import com.deep.two.util.JSONUtil;
import com.deep.two.util.ViewException;

@Controller("researchUserController")
@RequestMapping("/researchUser")
public class ResearchUserController  extends BaseController<ResearchUser> implements TemplateController<ResearchUser>{
    @Autowired
    @Qualifier("researchUserService")
    private ResearchUserService researchUserService; 
    
    @Override
   	public BaseService<ResearchUser> getBaseService() {
   		return this.researchUserService;
   	}

    @Override
    @RequestMapping("/getBrowsePage")
    public ModelAndView getBrowsePage(@RequestParam(value = "name", required = false)String name) {
        ModelAndView model = new ModelAndView("researchUser/achievementList");
		model.addObject("headerName", name);
		return model;
    }

    @Override
    @RequestMapping("/getDetailPageForAdd")
    public ModelAndView getDetailPageForAdd() {
        return new ModelAndView("deeptwo.researchUserDetail");
    }

    @Override
    @RequestMapping("/getDetailPageForUpdate")
    public ModelAndView getDetailPageForUpdate(String id) {
        return new ModelAndView("deeptwo.researchUserDetail");
    }
    
    @RequestMapping("getChangePasswordPage")
    public ModelAndView getChangePasswordPage() {
        return new ModelAndView("researchUser/updateMyPasswordInfo");
    }
    
    @RequestMapping("/getMyRecommendBrowsePage")
    public ModelAndView getMyRecommendBrowsePage() {
        return new ModelAndView("researchUser/myRecommendTechRequirementList");
    }
    
    @RequestMapping("/getMyResearchGroupPage")
    public ModelAndView getMyResearchGroupPage() {
        return new ModelAndView("researchUser/myResearchGroupList");
    }
    
    @RequestMapping("/getMyAchievementPage")
    public ModelAndView getMyAchievementPage() {
        return new ModelAndView("researchUser/myAchievementList");
    }
    
    @RequestMapping("/getMyRecommendTechRequirePage")
    public ModelAndView getMyRecommendTechRequirePage() {
        return new ModelAndView("researchUser/myRecommendTechRequirementList");
    }
    
    @RequestMapping("/getMyCollectionTechRequirePage")
    public ModelAndView getMyCollectionTechRequirePage() {
        return new ModelAndView("researchUser/myCollectionTechRequirementList");
    }
    
    @RequestMapping("/getMyCollectionInvestorBrowsePage")
    public ModelAndView getMyCollectionInvestorBrowsePage() {
        return new ModelAndView("researchUser/myCollectionInvestorList");
    }
    
    @RequestMapping("/getMyInfoBrowsePage")
    public ModelAndView getMyInfoBrowsePage() {
        return new ModelAndView("researchUser/myInfo");
    }

    @Override
    @RequestMapping("/add")
    @ResponseBody
    public DMLResultModel add(@RequestParam(value="file", required=false) MultipartFile[] files, @RequestParam("str")String str) {
        ResearchUser ru = null;
        DMLResultModel dm = new DMLResultModel();
        try {
            ru = JSONUtil.jsonToModel(str, ResearchUser.class, null);
            researchUserService.add(ru, files, getCurrentUser());
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
            researchUserService.delete(list, getCurrentUser());
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
        ResearchUser ru = null;
        try {
            ru = JSONUtil.jsonToModel(str, ResearchUser.class, null);
            researchUserService.update(ru, ru.getId(), files, getCurrentUser());
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
        ResearchUserQueryModel model = null;
        try {
            model = JSONUtil.jsonToModel(str, ResearchUserQueryModel.class, null);
            //model.getOrganizationUserQueryModel().setRemoveFlag("0");
            //model.getUniversityUserQueryModel().setRemoveFlag("0");
            list = researchUserService.combineQueryList(model, pagination, getCurrentUser());
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
            ru = researchUserService.getDDetail(id, getCurrentUser());
        } catch (ViewException e) {
            LOGGER.error(e.getMessage());
        }
        return JSON.toJSONString(ru);
    }
}
