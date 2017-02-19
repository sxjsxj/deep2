package com.deep.two.controller.basic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.deep.two.model.query.basic.BasicUniversityQueryModel;
import com.deep.two.model.result.DMLResultModel;
import com.deep.two.model.result.QueryListReturnVo;
import com.deep.two.orm.BasicProvince;
import com.deep.two.orm.BasicUniversity;
import com.deep.two.service.BaseService;
import com.deep.two.service.basic.BasicUniversityService;
import com.deep.two.util.JSONUtil;
import com.deep.two.util.ViewException;

@Controller
@RequestMapping("/basicUniversity")
public class BasicUniversityController  extends BaseController<BasicUniversity> implements TemplateController<BasicUniversity>{
    
    @Autowired
    private BasicUniversityService basicUniversityService;
    
	private static Map<String, List<BasicUniversity>> universityProvinceMap = new ConcurrentHashMap<String, List<BasicUniversity>>();
	private static Map<String, BasicUniversity> universityNameMap = new ConcurrentHashMap<String, BasicUniversity>();

    
    @Override
   	public BaseService<BasicUniversity> getBaseService() {
   		return this.basicUniversityService;
   	}
    
    @Override
    @RequestMapping("/getBrowsePage")
    public ModelAndView getBrowsePage(@RequestParam(value = "name", required = false)String name) {
        return new ModelAndView("");
    }

    @Override
    @RequestMapping("/getDetailPageForAdd")
    public ModelAndView getDetailPageForAdd() {
        return new ModelAndView("basic/basicUniversityDetailBody");
    }

    @Override
    @RequestMapping("/getDetailPageForUpdate")
    public ModelAndView getDetailPageForUpdate(String id) {
        return new ModelAndView("basic/basicUniversityDetailBody");
    }

    @Override
    @RequestMapping("/add")
    @ResponseBody
    public DMLResultModel add(@RequestParam(value="file", required=false) MultipartFile[] files, @RequestParam("str")String str) {
        BasicUniversity ru = null;
        DMLResultModel dm = new DMLResultModel();
        try {
            ru = JSONUtil.jsonToModel(str, BasicUniversity.class, null);
            basicUniversityService.add(ru, files, getCurrentUser());
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
            basicUniversityService.delete(list, getCurrentUser());
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
        BasicUniversity ru = null;
        try {
            ru = JSONUtil.jsonToModel(str, BasicUniversity.class, null);
            basicUniversityService.update(ru, ru.getId(), files, getCurrentUser());
        } catch (ViewException e) {
            LOGGER.error(e.getMessage());
            dmlResultModel = e.getResultModel();
        } 
        return dmlResultModel;
    }

    @Override
    @RequestMapping("query")
    @ResponseBody
    public String query(@RequestParam(value="str", required=false) String str,
            @ModelAttribute("com.deep.two.dao.util.Pagination") Pagination pagination) {
        QueryListReturnVo<BasicUniversity> list = null;
        QueryModel model = null;
        try {
            model = JSONUtil.jsonToModel(str, BasicUniversityQueryModel.class, null);
            list = basicUniversityService.queryList(model, pagination, getCurrentUser());
        } catch (ViewException e) {
            LOGGER.error(e.getMessage());
        }
        return JSON.toJSONString(list.getQueryReturnList());
    }
    
    @RequestMapping("queryUniversity")
    @ResponseBody
    public String queryUniversity() throws ViewException {
    	if(universityProvinceMap.isEmpty()) {
	    	List<BasicUniversity> univesityList = basicUniversityService.queryList(null, null, getCurrentUser()).getQueryReturnList();
	    	for(BasicUniversity bu : univesityList) {
	    		String key = bu.getProvince()+"_"+bu.getCity();
	    		if (universityProvinceMap.containsKey(key)) {
	    			universityProvinceMap.get(key).add(bu);
	    		} else {
	    			List<BasicUniversity> list = new ArrayList<BasicUniversity>();
	    			list.add(bu);
	    			universityProvinceMap.put(key, list);
	    		}
	    	}
    	}
        return JSON.toJSONString(universityProvinceMap);
    }
    
    @RequestMapping("queryUniversityMap")
    @ResponseBody
    public Map<String, BasicUniversity> queryUniversityMap() throws ViewException {
    	if(universityNameMap.isEmpty()) {
	    	List<BasicUniversity> univesityList = basicUniversityService.queryList(null, null, getCurrentUser()).getQueryReturnList();
	    	for(BasicUniversity bu : univesityList) {
	    		String key = bu.getName();
	    		universityNameMap.put(key, bu);
	    	}
    	}
        return universityNameMap;
    }

    @Override
    @RequestMapping("getDetail")
    @ResponseBody
    public String getDetail(@RequestParam("id") String id) {
        BasicUniversity ru = null;
        try {
            ru = basicUniversityService.getDetail(id, getCurrentUser());
        } catch (ViewException e) {
            LOGGER.error(e.getMessage());
        }
        return JSON.toJSONString(ru);
    }
}
