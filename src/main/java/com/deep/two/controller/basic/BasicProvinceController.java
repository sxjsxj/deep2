package com.deep.two.controller.basic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
import com.deep.two.model.query.basic.BasicProvinceQueryModel;
import com.deep.two.model.result.DMLResultModel;
import com.deep.two.model.result.QueryListReturnVo;
import com.deep.two.orm.BasicProvince;
import com.deep.two.service.BaseService;
import com.deep.two.service.basic.BasicProvinceService;
import com.deep.two.util.JSONUtil;
import com.deep.two.util.ViewException;

@Controller
@RequestMapping("/basicProvince")
public class BasicProvinceController  extends BaseController<BasicProvince> implements TemplateController<BasicProvince>{
    
    @Autowired
    private BasicProvinceService basicProvinceService;
    
    private static List<BasicProvince> provinceList;
    
    @Override
   	public BaseService<BasicProvince> getBaseService() {
   		return this.basicProvinceService;
   	}
    
    @Override
    @RequestMapping("/getBrowsePage")
    public ModelAndView getBrowsePage(@RequestParam(value = "name", required = false)String name) {
        return new ModelAndView("");
    }

    @Override
    @RequestMapping("/getDetailPageForAdd")
    public ModelAndView getDetailPageForAdd() {
        return new ModelAndView("basic/basicProvinceDetailBody");
    }

    @Override
    @RequestMapping("/getDetailPageForUpdate")
    public ModelAndView getDetailPageForUpdate(String id) {
        return new ModelAndView("basic/basicProvinceDetailBody");
    }

    @Override
    @RequestMapping("/add")
    @ResponseBody
    public DMLResultModel add(@RequestParam(value="file", required=false) MultipartFile[] files, @RequestParam("str")String str) {
        BasicProvince ru = null;
        DMLResultModel dm = new DMLResultModel();
        try {
            ru = JSONUtil.jsonToModel(str, BasicProvince.class, null);
            basicProvinceService.add(ru, files, getCurrentUser());
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
            basicProvinceService.delete(list, getCurrentUser());
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
        BasicProvince ru = null;
        try {
            ru = JSONUtil.jsonToModel(str, BasicProvince.class, null);
            basicProvinceService.update(ru, ru.getId(), files, getCurrentUser());
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
        QueryListReturnVo<BasicProvince> list = null;
        QueryModel model = null;
        try {
            model = JSONUtil.jsonToModel(str, BasicProvinceQueryModel.class, null);
            list = basicProvinceService.queryList(model, pagination, getCurrentUser());
        } catch (ViewException e) {
            LOGGER.error(e.getMessage());
        }
        return JSON.toJSONString(list.getQueryReturnList());
    }
    
    @RequestMapping("queryProvinceCity")
    @ResponseBody
    public String queryProvinceCity() throws ViewException {
    	Map<String, List<String>> map = new LinkedHashMap<String, List<String>>();
    	provinceList = basicProvinceService.queryList(null, null, getCurrentUser()).getQueryReturnList();
    	for(BasicProvince bp : provinceList) {
    		if (map.containsKey(bp.getProvince())) {
    			List<String> list = map.get(bp.getProvince());
    			if (!list.contains(bp.getCity())) {
    				list.add(bp.getCity());
    			}
    		} else {
    			List<String> list = new ArrayList<String>();
    			list.add(bp.getCity());
    			map.put(bp.getProvince(), list);
    		}
    	}
        return JSON.toJSONString(map);
    }
    
    @RequestMapping("queryCityCounty")
    @ResponseBody
    public String queryCityCounty() throws ViewException {
    	Map<String, List<String>> map = new LinkedHashMap<String, List<String>>();
    	provinceList = basicProvinceService.queryList(null, null, getCurrentUser()).getQueryReturnList();
    	for(BasicProvince bp : provinceList) {
    		if (map.containsKey(bp.getCity())) {
    			List<String> list = map.get(bp.getCity());
    			if (!list.contains(bp.getCounty())) {
    				list.add(bp.getCounty());
    			}
    		} else {
    			List<String> list = new ArrayList<String>();
    			list.add(bp.getCounty());
    			map.put(bp.getCity(), list);
    		}
    	}
        return JSON.toJSONString(map);
    }

    @Override
    @RequestMapping("getDetail")
    @ResponseBody
    public String getDetail(@RequestParam("id") String id) {
        BasicProvince ru = null;
        try {
            ru = basicProvinceService.getDetail(id, getCurrentUser());
        } catch (ViewException e) {
            LOGGER.error(e.getMessage());
        }
        return JSON.toJSONString(ru);
    }
}
