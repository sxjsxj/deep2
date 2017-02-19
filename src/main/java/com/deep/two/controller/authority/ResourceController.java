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
import com.deep.two.authority.model.ResourceModel;
import com.deep.two.authority.model.ResourceQueryVO;
import com.deep.two.controller.BaseController;
import com.deep.two.controller.TemplateController;
import com.deep.two.dao.util.Pagination;
import com.deep.two.model.result.DMLResultModel;
import com.deep.two.model.result.QueryListReturnVo;
import com.deep.two.service.BaseService;
import com.deep.two.service.authority.ResourceService;
import com.deep.two.util.JSONUtil;
import com.deep.two.util.ViewException;

@RequestMapping("security/resource")
@Controller
public class ResourceController extends BaseController<ResourceModel> implements TemplateController<ResourceModel> {

    @Autowired
    @Qualifier("resourceService")
    private ResourceService resourceService;
    
   
    
    @Override
    @RequestMapping("getBrowsePage")
    public ModelAndView getBrowsePage(@RequestParam(value = "name", required = false)String name) {
        return new ModelAndView("deeptwo.resourceBrowse");
    }

    @Override
    @RequestMapping("getDetailPageForAdd")
    @ResponseBody
    public ModelAndView getDetailPageForAdd() {
        ModelAndView modelAndView = new ModelAndView("deeptwo.resourceDetail");
        modelAndView.addObject(BaseController.ACTION, BaseController.ADD);
        return modelAndView;
    }

    @Override
    @RequestMapping("getDetailPageForUpdate")
    @ResponseBody
    public ModelAndView getDetailPageForUpdate(@RequestParam("id") String id) {
        ModelAndView modelAndView = new ModelAndView("deeptwo.resourceDetail");
        modelAndView.addObject(BaseController.ACTION, BaseController.UPDATE);
        modelAndView.addObject("editId", id);
        return modelAndView;
    }

    @Override
    @RequestMapping("add")
    @ResponseBody
    public DMLResultModel add(@RequestParam(value="file", required=false) MultipartFile[] files, @RequestParam("str")String str) {
        DMLResultModel dmlReturnVo = null;
        ResourceModel model = null;
        try {
            model = JSONUtil.jsonToModel(str, ResourceModel.class, null);
            dmlReturnVo = resourceService.insert(model, getCurrentUser());
        } catch (ViewException e) {
            LOGGER.error(e.getMessage());
        } 
        return dmlReturnVo;
    }

    @Override
    @RequestMapping("delete")
    @ResponseBody
    public DMLResultModel delete(@RequestParam("str") String str) {
        DMLResultModel dmlReturnVo = null;
        List<String> list = null;
        try {
            list = JSONUtil.jsonToModel(str, List.class, null);
            dmlReturnVo = resourceService.delete(list);
        } catch (ViewException e) {
            LOGGER.error(e.getMessage());
        } 
        return dmlReturnVo;
    }

    @Override
    @RequestMapping("update")
    @ResponseBody
    public DMLResultModel update(@RequestParam(value="file", required=false) MultipartFile[] files, @RequestParam("str")String str) {
        DMLResultModel dmlReturnVo = null;
        ResourceModel model = null;
        try {
            model = JSONUtil.jsonToModel(str, ResourceModel.class, null);
            dmlReturnVo = resourceService.update(model, getCurrentUser());
        } catch (ViewException e) {
            LOGGER.error(e.getMessage());
        } 
        return dmlReturnVo;
    }

    @Override
    @RequestMapping("query")
    @ResponseBody
    public String query(@RequestParam("str") String str,
            @ModelAttribute("com.deep.two.dao.util.Pagination") Pagination pagination) {
        QueryListReturnVo<ResourceModel> list = null;
        try {
            ResourceQueryVO vo = JSONUtil.jsonToModel(str, ResourceQueryVO.class, null);
            list = resourceService.query(vo, pagination);
        } catch (ViewException e) {
            LOGGER.error(e.getMessage());
        }
        return JSON.toJSONString(list);
    }

    @Override
    @RequestMapping("getDetail")
    @ResponseBody
    public String getDetail(@RequestParam("id") String id) {
        ResourceModel model = null;
        try {
            model = resourceService.getDetail(id);
        } catch (ViewException e) {
            LOGGER.error(e.getMessage());
        }
        return JSON.toJSONString(model);
    }
    
    @RequestMapping("queryAll")
    @ResponseBody
    public List<ResourceModel> queryAll() {
        List<ResourceModel> model = null;
        try {
            model = resourceService.queryAll();
        } catch (ViewException e) {
            LOGGER.error(e.getMessage());
        }
        return model;
    }

	@Override
	public BaseService<ResourceModel> getBaseService() {
		return null;
	}
}
