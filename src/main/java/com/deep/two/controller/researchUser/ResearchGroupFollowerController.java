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
import com.deep.two.model.query.QueryModel;
import com.deep.two.model.query.researchUser.ResearchGroupFollowerCombineQueryModel;
import com.deep.two.model.result.DMLResultModel;
import com.deep.two.model.result.QueryListReturnVo;
import com.deep.two.model.result.ResultModel;
import com.deep.two.orm.FundRequirementFollowerId;
import com.deep.two.orm.ResearchGroupFollower;
import com.deep.two.orm.ResearchGroupFollowerId;
import com.deep.two.service.BaseService;
import com.deep.two.service.researchUser.ResearchGroupFollowerService;
import com.deep.two.util.JSONUtil;
import com.deep.two.util.ViewException;

@Controller("researchGroupFollowerController")
@RequestMapping("/researchGroupFollower")
public class ResearchGroupFollowerController  extends BaseController<ResearchGroupFollower> implements TemplateController<ResearchGroupFollower> {

    @Autowired
    @Qualifier("researchGroupFollowerService")
    private ResearchGroupFollowerService researchGroupFollowerService;
    
    @Override
   	public BaseService<ResearchGroupFollower> getBaseService() {
   		return this.researchGroupFollowerService;
   	}
    
    @Override
    @RequestMapping("/getBrowsePage")
    public ModelAndView getBrowsePage(@RequestParam(value = "name", required = false)String name) {
        return new ModelAndView("deeptwo.researchGroupFollowerBrowse");
    }

    @Override
    @RequestMapping("/getDetailPageForAdd")
    public ModelAndView getDetailPageForAdd() {
        return new ModelAndView("deeptwo.researchGroupFollowerDetail");
    }

    @Override
    @RequestMapping("/getDetailPageForUpdate")
    public ModelAndView getDetailPageForUpdate(String id) {
        return new ModelAndView("deeptwo.researchGroupFollowerDetail");
    }

    @Override
    @RequestMapping("/add")
    @ResponseBody
    public DMLResultModel add(@RequestParam(value="file", required=false) MultipartFile[] files, @RequestParam("str")String str) {
        ResearchGroupFollower ru = null;
        DMLResultModel dm = new DMLResultModel();
        try {
            ru = JSONUtil.jsonToModel(str, ResearchGroupFollower.class, null);
            researchGroupFollowerService.add(ru, files, getCurrentUser());
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
            list = JSON.parseArray(str, ResearchGroupFollowerId.class);
            researchGroupFollowerService.delete(list, getCurrentUser());
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
        ResearchGroupFollower ru = null;
        try {
            ru = JSONUtil.jsonToModel(str, ResearchGroupFollower.class, null);
            researchGroupFollowerService.update(ru, ru.getId(), files, getCurrentUser());
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
        ResearchGroupFollowerCombineQueryModel model = null;
        try {
            model = JSONUtil.jsonToModel(str, ResearchGroupFollowerCombineQueryModel.class, null);
            //model.getResearchGroupFollowerQueryModel().setRemoveFlag("0");
            list = researchGroupFollowerService.combineQueryList(model, pagination, getCurrentUser());
        } catch (ViewException e) {
            LOGGER.error(e.getMessage());
        }
        return JSON.toJSONString(list);
    }

    @Override
    @RequestMapping("getDetail")
    @ResponseBody
    public String getDetail(@RequestParam("id") String id) {
        ResearchGroupFollower ru = null;
        try {
            ru = researchGroupFollowerService.getDetail(id, getCurrentUser());
        } catch (ViewException e) {
            LOGGER.error(e.getMessage());
        }
        return JSON.toJSONString(ru);
    }
}
