package com.deep.two.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.deep.two.authority.model.CurrentUser;
import com.deep.two.dao.util.Pagination;
import com.deep.two.model.ApproveModel;
import com.deep.two.model.RecommendModel;
import com.deep.two.model.result.DMLResultModel;
import com.deep.two.model.result.QueryListReturnVo;
import com.deep.two.util.ViewException;

 /**
 * ClassName: TemplateController <br/>
 * Description: TODO <br/>
 * Date: 2015-7-8 下午3:04:37 <br/>
 * <br/>
 * 
 * @author sunxijin(邮箱)
 * 
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
 * 
 */

public interface TemplateController<T> {
    public static final Logger LOGGER = Logger.getLogger(TemplateController.class);
    
    public ModelAndView getBrowsePage(@RequestParam(value = "name", required = false)String name);
    public ModelAndView getDetailPageForAdd();
    public ModelAndView getDetailPageForUpdate(@RequestParam("id") String id);
    public DMLResultModel add(@RequestParam(value="file", required=false) MultipartFile[] files, @RequestParam("str")String str);
    public DMLResultModel delete(@RequestParam("str") String str);
    public String getDetail(@RequestParam("id") String id);
    public DMLResultModel update(@RequestParam(value="file", required=false) MultipartFile[] files, @RequestParam("str")String str);
    public String query(@RequestParam("str") String str, @ModelAttribute("com.deep.two.dao.util.Pagination") Pagination pagination);
    
    public DMLResultModel recommend(@RequestParam("str") String str);
    public DMLResultModel approve(@RequestParam("str") String str);
}
