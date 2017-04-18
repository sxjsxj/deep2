package com.deep.two.controller.companyUser;

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
import com.deep.two.model.RecommendModel;
import com.deep.two.model.query.companyUser.FundRequirementCombineQueryModel;
import com.deep.two.model.result.DMLResultModel;
import com.deep.two.model.result.QueryListReturnVo;
import com.deep.two.model.result.ResultModel;
import com.deep.two.orm.FundRequirement;
import com.deep.two.service.BaseService;
import com.deep.two.service.companyUser.FundRequirementService;
import com.deep.two.util.JSONUtil;
import com.deep.two.util.ViewException;

@Controller("fundRequirementController")
@RequestMapping("/fundRequirement")
public class FundRequirementController  extends BaseController<FundRequirement> implements TemplateController<FundRequirement>{
    
    @Autowired
    @Qualifier("fundRequirementService")
    private FundRequirementService FundRequirementService;
    @Autowired
    private CompanyUserController companyUserController;
    
    @Override
   	public BaseService<FundRequirement> getBaseService() {
   		return this.FundRequirementService;
   	}
    
    @Override
    @RequestMapping("/getBrowsePage")
    public ModelAndView getBrowsePage(@RequestParam(value = "name", required = false)String name) {
        ModelAndView model = new ModelAndView("companyUser/fundRequirementList");
		model.addObject("headerName", name);
		return model;
    }

    @Override
    @RequestMapping("/getDetailPageForAdd")
    public ModelAndView getDetailPageForAdd() {
    	ModelAndView mv = new ModelAndView("companyUser/fundRequirementDetail");
    	mv.addObject("companyUser", companyUserController.getCompanyUser());
    	return mv;
    }

    @Override
    @RequestMapping("/getDetailPageForUpdate")
    public ModelAndView getDetailPageForUpdate(String id) {
    	ModelAndView mv = new ModelAndView("companyUser/fundRequirementDetail");
    	mv.addObject("id", id);
        return mv;
    }
    
    @RequestMapping("/getMoreInfoPage")
    public ModelAndView getMoreInfoPage(String id) {
    	ModelAndView mv = new ModelAndView("companyUser/fundRequirementMoreInfo");
    	mv.addObject("id", id);
        return mv;
    }

    @RequestMapping("/add")
    @ResponseBody
    public DMLResultModel add(@RequestParam(value="logoFile", required=false) MultipartFile logoFile, 
    		@RequestParam(value="attachFile", required=false) MultipartFile attachFile, 
    		@RequestParam("str")String str) {
        FundRequirement ru = null;
        DMLResultModel dm = new DMLResultModel();
        try {
            ru = JSONUtil.jsonToModel(str, FundRequirement.class, null);
            FundRequirementService.add(ru, getFileMap(logoFile, null, attachFile), getCurrentUser());
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
            FundRequirementService.delete(list, getCurrentUser());
        } catch (ViewException e) {
            LOGGER.error(e.getMessage());
            dmlResultModel = e.getResultModel();
        } 
        return dmlResultModel;
    }

    @RequestMapping("update")
    @ResponseBody
    public DMLResultModel update(@RequestParam(value="logoFile", required=false) MultipartFile logoFile, 
    		@RequestParam(value="attachFile", required=false) MultipartFile attachFile,
    		@RequestParam("str")String str) {
        DMLResultModel dmlResultModel = new DMLResultModel();
        FundRequirement ru = null;
        try {
            ru = JSONUtil.jsonToModel(str, FundRequirement.class, null);
            FundRequirementService.update(ru, ru.getId(), getFileMap(logoFile, null, attachFile), getCurrentUser());
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
        FundRequirementCombineQueryModel model = null;
        try {
            model = JSONUtil.jsonToModel(str, FundRequirementCombineQueryModel.class, null);
            //model.getFundRequirementQueryModel().setRemoveFlag("0");
            list = FundRequirementService.combineQueryList(model, pagination, getCurrentUser());
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
        	this.updateScanNum(id);
            ru = FundRequirementService.getDDetail(id, getCurrentUser());
        } catch (ViewException e) {
            LOGGER.error(e.getMessage());
        }
        return JSON.toJSONString(ru);
    }
    
    @Override
    @RequestMapping("recommend")
    @ResponseBody
    public DMLResultModel recommend(@RequestParam("str") String str) {
    	RecommendModel rm = null;
        DMLResultModel dm = new DMLResultModel();
        try {
            rm = JSON.parseObject(str, RecommendModel.class);
            FundRequirementService.recommend(rm, getCurrentUser());
        } catch (ViewException e) {
            LOGGER.error(e.getMessage());
            dm = e.getResultModel();
        }
        return dm;
    }
    
    @RequestMapping("updateScanNum")
  	public DMLResultModel updateScanNum(Serializable id) {
          DMLResultModel dm = DMLResultModel.getSucessResultModel();
          try {
          	getBaseService().updateScanNum(id, getCurrentUser());
          } catch (ViewException e) {
              LOGGER.error(e.getMessage());
              dm = e.getResultModel();
          }
          return dm;
  	}
}

