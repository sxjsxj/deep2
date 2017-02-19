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
import com.deep.two.model.query.researchUser.AchievementFollowerCombineQueryModel;
import com.deep.two.model.result.DMLResultModel;
import com.deep.two.model.result.QueryListReturnVo;
import com.deep.two.model.result.ResultModel;
import com.deep.two.orm.AchievementFollower;
import com.deep.two.orm.AchievementFollowerId;
import com.deep.two.service.BaseService;
import com.deep.two.service.researchUser.AchievementFollowerService;
import com.deep.two.util.JSONUtil;
import com.deep.two.util.ViewException;

@Controller("achievementFollowerController")
@RequestMapping("/achievementFollower")
public class AchievementFollowerController  extends BaseController<AchievementFollower> implements TemplateController<AchievementFollower>{
    @Autowired
    @Qualifier("achievementFollowerService")
    private AchievementFollowerService achievementFollowerService;
    
    @Override
   	public BaseService<AchievementFollower> getBaseService() {
   		return this.achievementFollowerService;
   	}
    
    @Override
    @RequestMapping("/getBrowsePage")
    public ModelAndView getBrowsePage(@RequestParam(value = "name", required = false)String name) {
        return new ModelAndView("deeptwo.achievementFollowerBrowse");
    }

    @Override
    @RequestMapping("/getDetailPageForAdd")
    public ModelAndView getDetailPageForAdd() {
        return new ModelAndView("deeptwo.achievementFollowerDetail");
    }

    @Override
    @RequestMapping("/getDetailPageForUpdate")
    public ModelAndView getDetailPageForUpdate(String id) {
        return new ModelAndView("deeptwo.achievementFollowerDetail");
    }

    @Override
    @RequestMapping("/add")
    @ResponseBody
    public DMLResultModel add(@RequestParam(value="file", required=false) MultipartFile[] files, @RequestParam("str")String str) {
        AchievementFollower ru = null;
        DMLResultModel dm = new DMLResultModel();
        try {
            ru = JSONUtil.jsonToModel(str, AchievementFollower.class, null);
            achievementFollowerService.add(ru, files, getCurrentUser());
        } catch (ViewException e) {
            LOGGER.error(e.getMessage(), e);
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
            list = JSON.parseArray(str, AchievementFollowerId.class);
            achievementFollowerService.delete(list, getCurrentUser());
        } catch (ViewException e) {
            LOGGER.error(e.getMessage(), e);
            dmlResultModel = e.getResultModel();
        } 
        return dmlResultModel;
    }

    @Override
    @RequestMapping("update")
    @ResponseBody
    public DMLResultModel update(@RequestParam(value="file", required=false) MultipartFile[] files, @RequestParam("str")String str) {
        DMLResultModel dmlResultModel = new DMLResultModel();
        AchievementFollower ru = null;
        try {
            ru = JSONUtil.jsonToModel(str, AchievementFollower.class, null);
            achievementFollowerService.update(ru, ru.getId(), files, getCurrentUser());
        } catch (ViewException e) {
            LOGGER.error(e.getMessage(), e);
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
        AchievementFollowerCombineQueryModel model = null;
        try {
            model = JSONUtil.jsonToModel(str, AchievementFollowerCombineQueryModel.class, null);
            //model.getAchievementFollowerQueryModel().setRemoveFlag("0");
            list = achievementFollowerService.combineQueryList(model, pagination, getCurrentUser());
        } catch (ViewException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return JSON.toJSONString(list);
    }

    @Override
    @RequestMapping("getDetail")
    @ResponseBody
    public String getDetail(@RequestParam("id") String id) {
        AchievementFollower ru = null;
        try {
            ru = achievementFollowerService.getDetail(id, getCurrentUser());
        } catch (ViewException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return JSON.toJSONString(ru);
    }
}
