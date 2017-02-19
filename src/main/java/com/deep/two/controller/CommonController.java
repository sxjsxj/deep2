package com.deep.two.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.deep.two.controller.util.FileHelper;
import com.deep.two.util.StringUtil;

@Controller("commonController")
@RequestMapping("/")
public class CommonController {
	
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
			File file = FileHelper.getFile(path);
			response.setCharacterEncoding("UTF-8");
			response.setContentType("multipart/form-data");

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

}
