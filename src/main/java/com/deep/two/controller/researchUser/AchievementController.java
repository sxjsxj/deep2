package com.deep.two.controller.researchUser;

import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
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
import com.deep.two.model.query.researchUser.AchievementCombineQueryModel;
import com.deep.two.model.result.DMLResultModel;
import com.deep.two.model.result.QueryListReturnVo;
import com.deep.two.model.result.ResultModel;
import com.deep.two.orm.Achievement;
import com.deep.two.service.BaseService;
import com.deep.two.service.researchUser.AchievementService;
import com.deep.two.util.JSONUtil;
import com.deep.two.util.ViewException;

@Controller("achievementController")
@RequestMapping("/achievement")
public class AchievementController extends BaseController<Achievement> implements TemplateController<Achievement> {
	@Autowired
	@Qualifier("achievementService")
	private AchievementService achievementService;
	
	@Value("${achievementFilePath}")
	private String achievementFilePath;
	
	@Override
   	public BaseService<Achievement> getBaseService() {
   		return this.achievementService;
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
		return new ModelAndView("researchUser/achievementDetail");
	}

	@Override
	@RequestMapping("/getDetailPageForUpdate")
	public ModelAndView getDetailPageForUpdate(String id) {
		  ModelAndView mv = new ModelAndView("researchUser/achievementDetail");
	    mv.addObject("id", id);
		return mv;
	}
	
	@RequestMapping("/getMoreInfoPage")
    public ModelAndView getMoreInfoPage(String id) {
        ModelAndView mv = new ModelAndView("researchUser/achievementMoreInfo");
    	mv.addObject("id", id);
        return mv;
    }

	@Override
	@RequestMapping("/add")
	@ResponseBody
	public DMLResultModel add(@RequestParam(value = "file", required = false) MultipartFile[] files, String str) {
		Achievement ru = null;
		DMLResultModel dm = new DMLResultModel();
		try {
			ru = JSONUtil.jsonToModel(str, Achievement.class, null);
			achievementService.add(ru, files, getCurrentUser());
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
			list = JSON.parseArray(str, Serializable.class);
			achievementService.delete(list, getCurrentUser());
		} catch (ViewException e) {
			LOGGER.error(e.getMessage());
			dmlResultModel = e.getResultModel();
		}
		return dmlResultModel;
	}

	@Override
	@RequestMapping("update")
	@ResponseBody
	public DMLResultModel update(@RequestParam(value = "file", required = false) MultipartFile[] files, @RequestParam("str") String str) {
		DMLResultModel dmlResultModel = new DMLResultModel();
		Achievement ru = null;
		try {
			ru = JSONUtil.jsonToModel(str, Achievement.class, null);
			achievementService.update(ru, ru.getId(), files, getCurrentUser());
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
        AchievementCombineQueryModel model = null;
		try {
			model = JSONUtil.jsonToModel(str, AchievementCombineQueryModel.class, null);
			//model.getAchievementQueryModel().setRemoveFlag("0");
			list = achievementService.combineQueryList(model, pagination, getCurrentUser());
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
			ru = achievementService.getDDetail(id, getCurrentUser());
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
            achievementService.recommend(rm, getCurrentUser());
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
