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
import com.deep.two.authority.model.RoleModel;
import com.deep.two.authority.model.RoleQueryVO;
import com.deep.two.controller.BaseController;
import com.deep.two.controller.TemplateController;
import com.deep.two.dao.util.Pagination;
import com.deep.two.model.result.DMLResultModel;
import com.deep.two.model.result.QueryListReturnVo;
import com.deep.two.service.BaseService;
import com.deep.two.service.authority.RoleService;
import com.deep.two.util.JSONUtil;
import com.deep.two.util.ViewException;


@RequestMapping("security/role")
@Controller
public class RoleController extends BaseController<RoleModel> implements TemplateController<RoleModel>{
    
    @Autowired
    @Qualifier("roleService")
    private RoleService roleService;

    @Override
    @RequestMapping("getBrowsePage")
    public ModelAndView getBrowsePage(@RequestParam(value = "name", required = false)String name) {
        return new ModelAndView("deeptwo.roleBrowse");
    }

    @Override
    @RequestMapping("getDetailPageForAdd")
    @ResponseBody
    public ModelAndView getDetailPageForAdd() {
        ModelAndView modelAndView = new ModelAndView("deeptwo.roleDetail");
        modelAndView.addObject(BaseController.ACTION, BaseController.ADD);
        return modelAndView;
    }

    @Override
    @RequestMapping("getDetailPageForUpdate")
    @ResponseBody
    public ModelAndView getDetailPageForUpdate(@RequestParam("id")String id) {
        ModelAndView modelAndView = new ModelAndView("deeptwo.roleDetail");
        modelAndView.addObject(BaseController.ACTION, BaseController.UPDATE);
        modelAndView.addObject("editId", id);
        return modelAndView;
    }

    @Override
    @RequestMapping("add")
    @ResponseBody
    public DMLResultModel add(@RequestParam(value="file", required=false) MultipartFile[] files, @RequestParam("str")String str) {
        DMLResultModel dmlReturnVo = null;
        RoleModel model = null;
        try {
            model = JSONUtil.jsonToModel(str, RoleModel.class, null);
            dmlReturnVo = roleService.insert(model, getCurrentUser());
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
            dmlReturnVo = roleService.delete(list);
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
        RoleModel model = null;
        try {
            model = JSONUtil.jsonToModel(str, RoleModel.class, null);
            dmlReturnVo = roleService.update(model, getCurrentUser());
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
        QueryListReturnVo<RoleModel> list = null;
        try {
            RoleQueryVO vo = JSONUtil.jsonToModel(str, RoleQueryVO.class, null);
            list = roleService.query(vo, pagination);
        } catch (ViewException e) {
            LOGGER.error(e.getMessage());
        }
        return JSON.toJSONString(list);
    }

    @Override
    @RequestMapping("getDetail")
    @ResponseBody
    public String getDetail(@RequestParam("id") String id) {
        RoleModel model = null;
        try {
            model = roleService.getDetail(id);
        } catch (ViewException e) {
            LOGGER.error(e.getMessage());
        }
        return JSON.toJSONString(model);
    }
    
    @RequestMapping("queryAll")
    @ResponseBody
    public List<RoleModel> queryAll() {
        List<RoleModel> model = null;
        try {
            model = roleService.queryAll();
        } catch (ViewException e) {
            LOGGER.error(e.getMessage());
        }
        return model;
    }
    
    @Override
	public BaseService<RoleModel> getBaseService() {
		return null;
	}
}
