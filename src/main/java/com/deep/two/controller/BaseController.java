package com.deep.two.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.deep.two.authority.model.CurrentUser;
import com.deep.two.authority.model.UserExtend;
import com.deep.two.controller.util.FileHelper;
import com.deep.two.model.ApproveModel;
import com.deep.two.model.result.DMLResultModel;
import com.deep.two.model.result.ResultModel;
import com.deep.two.model.result.companyUser.CompanyUserResultModel;
import com.deep.two.service.BaseService;
import com.deep.two.util.AttachConstant;
import com.deep.two.util.CollectionUtil;
import com.deep.two.util.CopyUtil;
import com.deep.two.util.DecodeUtil;
import com.deep.two.util.JSONUtil;
import com.deep.two.util.StringUtil;
import com.deep.two.util.ViewException;

public abstract class BaseController<T> implements TemplateController<T>{
	
	public static final String ACTION = "action";
	public static final String ADD = "add";
	public static final String UPDATE = "update";
	 /**
     * initBinder:属性编辑器
     * @param binder
     *            WebDataBinder对象
     */
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
        binder.registerCustomEditor(Integer.class, new CustomNumberEditor(Integer.class, true));
    }
    
    public CurrentUser getCurrentUser() {
    	CurrentUser model = new CurrentUser();
    	try {
    		Authentication au =  SecurityContextHolder.getContext().getAuthentication();
    		if (au.isAuthenticated()) {
    			Object obj = au.getPrincipal();
    			if (obj != null && obj instanceof String) {
    				model.setUsername(obj.toString());
    			}
    			if (obj != null && obj instanceof UserExtend) {
    				UserExtend user = (UserExtend)au.getPrincipal();
    				model = CopyUtil.copyProperty(user, CurrentUser.class);
    			}
    		}
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }
    
    @Override
    public DMLResultModel recommend(@RequestParam("str") String str) {
    	return null;
    }
    
    @Override
    @RequestMapping("approve")
    @ResponseBody
    public DMLResultModel approve(@RequestParam("str") String str) {
    	ApproveModel am = null;
        DMLResultModel dm = new DMLResultModel();
        try {
        	am = JSON.parseObject(str, ApproveModel.class);
        	if(getBaseService().getClass().getName().indexOf("Follower") > 0) {}
        	getBaseService().approve(am, getCurrentUser());
        } catch (ViewException e) {
            LOGGER.error(e.getMessage());
            dm = e.getResultModel();
        }
        return dm;
    }
    
    @RequestMapping("downFile")
	public void downFile(String path, HttpServletRequest request, HttpServletResponse response) {
    	if(StringUtil.isEmpty(path)) return;
    	try {
			path = new String(path.getBytes("ISO-8859-1"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
    	try {
			//fileName = DecodeUtil.decode(fileName);
			String fileName = "";
			if(path.lastIndexOf("//") > 0){
				fileName = path.substring(path.lastIndexOf("//")+1);
			}
			if(path.lastIndexOf("\\") > 0){
				fileName = path.substring(path.lastIndexOf("\\")+1);
			}
			File file = FileHelper.getFile(path);
			if(!file.exists()) {
				file = new File("");
			}
			response.setCharacterEncoding("UTF-8");
			response.setContentType("multipart/form-data");

			// 设置response方式,使执行此controller时候自动出现下载页面
			response.setHeader("Content-Disposition", "attachment;filename="
					+ new String(fileName.getBytes("UTF-8"), "ISO-8859-1"));
			// 以流的形式下载文件
			OutputStream toClient = new BufferedOutputStream(
					response.getOutputStream());
			toClient.write(FileUtils.readFileToByteArray(file));
			toClient.flush();
			toClient.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public abstract BaseService<T> getBaseService();
	
	@Override
    public DMLResultModel add(@RequestParam(value="file", required=false) MultipartFile[] files, @RequestParam("str")String str){
    	return null;
    }
	
	@Override
    public DMLResultModel update(@RequestParam(value="file", required=false) MultipartFile[] files, @RequestParam("str")String str){
    	return null;
    }
	
	protected Map<String, MultipartFile> getFileMap(MultipartFile logoFile, MultipartFile leaderFile, MultipartFile attachFile) {
		Map<String, MultipartFile> map = new HashMap<String, MultipartFile>();
		if(logoFile != null) {
			map.put(AttachConstant.LOGOFILE, logoFile);
		}
		if(leaderFile != null) {
			map.put(AttachConstant.LEADERFILE, leaderFile);
		}
		if(attachFile != null) {
			map.put(AttachConstant.ATTACHFILE, attachFile);
		}
		return map;
	}
}
