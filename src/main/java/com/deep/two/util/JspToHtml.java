package com.deep.two.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class JspToHtml {
	static String fromDir = "D:\\workspace\\DeepTwoWeb\\src\\main\\webapp\\WEB-INF\\pages";
	static String toDir = "D:\\workspace\\DeepTwoWeb\\src\\main\\webapp\\WEB-INF\\htmls";
	public static void main(String[] args)  throws Exception {
		File root = new File(fromDir);
		createFile(root);
	}
	
	public static void createFile(File file) throws Exception {
		if(file.isDirectory()) {
			for(File f : file.listFiles()) {
				createFile(f);
			}
		} else {
			String path = file.getPath();
			path = path.replaceAll("pages", "htmls");
			path = path.replaceAll(".jsp", ".html");
			String filePath = path.substring(0, path.lastIndexOf(File.separator));
			String fileName = path.substring(path.lastIndexOf(File.separator)+1);
			File from = file;
			System.out.println(fileName);
			File to = new File(filePath);
			if(!to.exists()) {
				to.mkdirs();
			}
			File tt = new File(filePath, fileName);
			tt.createNewFile();
			createHtmlByIFrame(from, tt);
			crateHtmlByLink(from, tt);
		}
	}

	private static void crateHtmlByLink(File from, File tt) throws Exception  {
		// TODO Auto-generated method stub
		
	}

	private static void createHtmlByIFrame(File from, File tt) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(from));
		BufferedWriter bw = new BufferedWriter(new FileWriter(tt));
		if(br.ready()) {
			String tmp = null;
			bw.write("<link type=\"text/css\" rel=\"stylesheet\" href=\"../../../resources/css/front/style.css\"/>");
			bw.newLine();
			bw.write("<link type=\"text/css\" rel=\"stylesheet\" href=\"../../../resources/css/front/alert.css\"/>");
			bw.newLine();
			bw.write("<script type=\"text/javascript\" src=\"../../../resources/js/front/jquery/jquery-1.8.3.min.js\"></script>");
			bw.newLine();
			bw.write("<script type=\"text/javascript\" src=\"../../../resources/js/front/jquery/jquery.validate.js\"></script>");
			bw.newLine();
			bw.write("<script type=\"text/javascript\" src=\"../../../resources/js/front/jquery/jquery.serializeJSON.js\"></script>");
			bw.newLine();
			bw.write("<script type=\"text/javascript\" src=\"../../../resources/js/front/jquery/ajaxfileupload.js\"></script>");
			bw.newLine();
			bw.write("<script type=\"text/javascript\" src=\"../../../resources/js/front/common/common.js\"></script>");
			bw.newLine();
			bw.write("<script type=\"text/javascript\" src=\"../../../resources/js/front/common/header.js\"></script>");
			bw.newLine();
			bw.write("<script type=\"text/javascript\" src=\"../../../resources/js/front/common/commonQuery.js\"></script>");
			bw.newLine();
			bw.write("<script type=\"text/javascript\" src=\"../../../resources/js/front/common/commonInit.js\"></script>");
			bw.newLine();
			bw.write("<script type=\"text/javascript\" src=\"../../../resources/js/front/common/cooperateCollectCommon.js\"></script>");
			bw.newLine();
			bw.write("<script type=\"text/javascript\" src=\"../../../resources/js/front/common/cooperateCollectDetailCommon.js\"></script>");
			bw.newLine();
			bw.write("<script type=\"text/javascript\" src=\"../../../resources/js/front/common/myRecommendCommon.js\"></script>");
			bw.newLine();
			bw.write("<script type=\"text/javascript\" src=\"../../../resources/js/front/common/commonActionControl.js\"></script>");
			bw.flush();
			while((tmp = br.readLine()) != null) {
				if(tmp.indexOf("pageContext.request.contextPath") > 0) {
					tmp = tmp.replaceAll("\\$\\{pageContext.request.contextPath\\}", "../../..");
				}
				if(tmp.indexOf("header.jsp") > 0) {
					tmp = tmp.replaceAll("<%@ include file=\"/WEB-INF/pages/common/header.jsp\" %>", "<iframe src=\"../../pages/common/header.html\" width=\"100%\" border=\"0\" frameborder=\"0\" scrolling=\"no\"></iframe>");
				}
				if(tmp.indexOf("footer.jsp") > 0) {
					tmp = tmp.replaceAll("<%@ include file=\"/WEB-INF/pages/common/footer.jsp\" %>", "<iframe src=\"../../pages/common/footer.html\" width=\"100%\" border=\"0\" frameborder=\"0\" scrolling=\"no\"></iframe>");
				}
				if(tmp.indexOf("dialog.jsp") > 0) {
					tmp = tmp.replaceAll("<%@ include file=\"/WEB-INF/pages/common/dialog.jsp\" %>", "<iframe src=\"../../pages/common/dialog.html\" width=\"100%\" border=\"0\" frameborder=\"0\" scrolling=\"no\"></iframe>");
				}
				if(tmp.indexOf("companyUserLeft.jsp") > 0) {
					tmp = tmp.replaceAll("<jsp:include page=\"/WEB-INF/pages/common/companyUserLeft.jsp\"></jsp:include>", "<div class='fl left'><iframe src=\"../../pages/common/companyUserLeft.html\" width=\"100%\" height='1500px' border=\"0\" frameborder=\"0\" scrolling=\"no\"></iframe></div>");
				}
				if(tmp.indexOf("investorUserLeft.jsp") > 0) {
					tmp = tmp.replaceAll("<jsp:include page=\"/WEB-INF/pages/common/investorUserLeft.jsp\"></jsp:include>", "<div class='fl left'><iframe src=\"../../pages/common/investorUserLeft.html\" width=\"100%\" height='1500px' border=\"0\" frameborder=\"0\" scrolling=\"no\"></iframe></div>");
				}
				if(tmp.indexOf("researchUserLeft.jsp") > 0) {
					tmp = tmp.replaceAll("<jsp:include page=\"/WEB-INF/pages/common/researchUserLeft.jsp\"></jsp:include>", "<div class='fl left'><iframe src=\"../../pages/common/researchUserLeft.html\" width=\"100%\" height='1500px' border=\"0\" frameborder=\"0\" scrolling=\"no\"></iframe></div>");
				}
				if(tmp.indexOf("researchUserLeft.jsp") > 0) {
					tmp = tmp.replaceAll("<%@ include file=\"/WEB-INF/pages/common/researchUserLeft.jsp\" %>", "<div class='fl left'><iframe src=\"../../pages/common/researchUserLeft.html\" width=\"100%\" height='1500px' border=\"0\" frameborder=\"0\" scrolling=\"no\"></iframe></div>");
				}
				if(tmp.indexOf("<%") >= 0) {
					tmp = tmp.replaceAll("<%", "<!--<%");
				}
				if(tmp.indexOf("%>") > 0) {
					tmp = tmp.replaceAll("%>", "%>-->");
				}
				if(tmp.indexOf(".jsp") > 0) {
					tmp = tmp.replaceAll(".jsp", ".html");
				}
				bw.write(tmp);
				bw.newLine();
				bw.flush();
			}
		}
		br.close();
		bw.close();
	}
}
