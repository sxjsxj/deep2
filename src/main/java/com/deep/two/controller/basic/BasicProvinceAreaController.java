package com.deep.two.controller.basic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import com.deep.two.model.query.basic.BasicProvinceAreaQueryModel;
import com.deep.two.model.result.DMLResultModel;
import com.deep.two.model.result.QueryListReturnVo;
import com.deep.two.orm.BasicProvinceArea;
import com.deep.two.service.BaseService;
import com.deep.two.service.basic.BasicProvinceAreaService;
import com.deep.two.util.JSONUtil;
import com.deep.two.util.ViewException;

@Controller
@RequestMapping("/basicProvinceArea")
public class BasicProvinceAreaController  extends BaseController<BasicProvinceArea> implements TemplateController<BasicProvinceArea>{
    
    @Autowired
    private BasicProvinceAreaService basicProvinceAreaService;
    private static List<BasicProvinceArea> provinceAreaList;
    
    @Override
   	public BaseService<BasicProvinceArea> getBaseService() {
   		return this.basicProvinceAreaService;
   	}
    
    @Override
    @RequestMapping("/getBrowsePage")
    public ModelAndView getBrowsePage(@RequestParam(value = "name", required = false)String name) {
        return new ModelAndView("");
    }

    @Override
    @RequestMapping("/getDetailPageForAdd")
    public ModelAndView getDetailPageForAdd() {
        return new ModelAndView("basic/basicProvinceAreaDetailBody");
    }

    @Override
    @RequestMapping("/getDetailPageForUpdate")
    public ModelAndView getDetailPageForUpdate(String id) {
        return new ModelAndView("basic/basicProvinceAreaDetailBody");
    }

    @Override
    @RequestMapping("/add")
    @ResponseBody
    public DMLResultModel add(@RequestParam(value="file", required=false) MultipartFile[] files, @RequestParam("str")String str) {
        BasicProvinceArea ru = null;
        DMLResultModel dm = new DMLResultModel();
        try {
            ru = JSONUtil.jsonToModel(str, BasicProvinceArea.class, null);
            basicProvinceAreaService.add(ru, files, getCurrentUser());
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
            basicProvinceAreaService.delete(list, getCurrentUser());
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
        BasicProvinceArea ru = null;
        try {
            ru = JSONUtil.jsonToModel(str, BasicProvinceArea.class, null);
            basicProvinceAreaService.update(ru, ru.getId(), files, getCurrentUser());
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
        QueryListReturnVo<BasicProvinceArea> list = null;
        QueryModel model = null;
        try {
            model = JSONUtil.jsonToModel(str, BasicProvinceAreaQueryModel.class, null);
            list = basicProvinceAreaService.queryList(model, pagination, getCurrentUser());
        } catch (ViewException e) {
            LOGGER.error(e.getMessage());
        }
        return JSON.toJSONString(list.getQueryReturnList());
    }
    
    @RequestMapping("queryAreaProvince")
    @ResponseBody
    public String queryAreaProvince() throws ViewException {
    	Map<String, List<String>> map = new HashMap<String, List<String>>();
    	provinceAreaList = basicProvinceAreaService.queryList(null, null, getCurrentUser()).getQueryReturnList();
    	for(BasicProvinceArea bpa : provinceAreaList) {
    		if(bpa.getHot() != null && bpa.getHot().equals("1")){
    			if (map.containsKey("0")) {
        			map.get("0").add(bpa.getProvince());
        		} else {
        			List<String> list = new ArrayList<String>();
        			list.add(bpa.getProvince());
        			map.put("0", list);
        		}
    		}
    		if(bpa.getArea() != null){
    			String area = bpa.getArea();
    			if (map.containsKey(area)) {
        			map.get(area).add(bpa.getProvince());
        		} else {
        			List<String> list = new ArrayList<String>();
        			list.add(bpa.getProvince());
        			map.put(area, list);
        		}
    		}
    	}
        return JSON.toJSONString(map);
    }

    @Override
    @RequestMapping("getDetail")
    @ResponseBody
    public String getDetail(@RequestParam("id") String id) {
        BasicProvinceArea ru = null;
        try {
            ru = basicProvinceAreaService.getDetail(id, getCurrentUser());
        } catch (ViewException e) {
            LOGGER.error(e.getMessage());
        }
        return JSON.toJSONString(ru);
    }
}
