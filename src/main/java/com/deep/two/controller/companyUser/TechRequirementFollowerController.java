package com.deep.two.controller.companyUser;

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
import com.deep.two.model.query.companyUser.TechRequirementFollowerCombineQueryModel;
import com.deep.two.model.result.DMLResultModel;
import com.deep.two.model.result.QueryListReturnVo;
import com.deep.two.model.result.ResultModel;
import com.deep.two.orm.FundRequirementFollowerId;
import com.deep.two.orm.TechRequirement;
import com.deep.two.orm.TechRequirementFollower;
import com.deep.two.orm.TechRequirementFollowerId;
import com.deep.two.service.BaseService;
import com.deep.two.service.companyUser.TechRequirementFollowerService;
import com.deep.two.util.JSONUtil;
import com.deep.two.util.ViewException;

@Controller("techRequirementFollowerController")
@RequestMapping("/techRequirementFollower")
public class TechRequirementFollowerController  extends BaseController<TechRequirementFollower> implements TemplateController<TechRequirementFollower> {

    @Autowired
    @Qualifier("techRequirementFollowerService")
    private TechRequirementFollowerService TechRequirementFollowerService;
    
    @Override
   	public BaseService<TechRequirementFollower> getBaseService() {
   		return this.TechRequirementFollowerService;
   	}
    
    @Override
    @RequestMapping("/getBrowsePage")
    public ModelAndView getBrowsePage(@RequestParam(value = "name", required = false)String name) {
        return new ModelAndView("deeptwo.requirementFollowerBrowse");
    }

    @Override
    @RequestMapping("/getDetailPageForAdd")
    public ModelAndView getDetailPageForAdd() {
        return new ModelAndView("deeptwo.requirementFollowerDetail");
    }

    @Override
    @RequestMapping("/getDetailPageForUpdate")
    public ModelAndView getDetailPageForUpdate(String id) {
        return new ModelAndView("deeptwo.requirementFollowerDetail");
    }

    @Override
    @RequestMapping("/add")
    @ResponseBody
    public DMLResultModel add(@RequestParam(value="file", required=false) MultipartFile[] files, @RequestParam("str")String str) {
        TechRequirementFollower ru = null;
        DMLResultModel dm = new DMLResultModel();
        try {
            ru = JSONUtil.jsonToModel(str, TechRequirementFollower.class, null);
            TechRequirementFollowerService.add(ru, files, getCurrentUser());
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
            list = JSON.parseArray(str, TechRequirementFollowerId.class);
            TechRequirementFollowerService.delete(list, getCurrentUser());
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
        TechRequirementFollower ru = null;
        try {
            ru = JSONUtil.jsonToModel(str, TechRequirementFollower.class, null);
            TechRequirementFollowerService.update(ru, ru.getId(), files, getCurrentUser());
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
        TechRequirementFollowerCombineQueryModel model = null;
        try {
            model = JSONUtil.jsonToModel(str, TechRequirementFollowerCombineQueryModel.class, null);
            //model.getTechRequirementFollowerQueryModel().setRemoveFlag("0");
            list = TechRequirementFollowerService.combineQueryList(model, pagination, getCurrentUser());
        } catch (ViewException e) {
            LOGGER.error(e.getMessage());
        }
        return JSON.toJSONString(list);
    }

    @Override
    @RequestMapping("getDetail")
    @ResponseBody
    public String getDetail(@RequestParam("id") String id) {
        TechRequirementFollower ru = null;
        try {
            ru = TechRequirementFollowerService.getDetail(id, getCurrentUser());
        } catch (ViewException e) {
            LOGGER.error(e.getMessage());
        }
        return JSON.toJSONString(ru);
    }
}
