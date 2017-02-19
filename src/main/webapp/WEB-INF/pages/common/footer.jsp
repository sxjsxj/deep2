<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset='utf-8'/>
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<title>公共尾部</title>
<% request.setCharacterEncoding("UTF-8");%>
<% response.setCharacterEncoding("UTF-8");%>
</head>
<div class='footer'>
		<div class='width1200'>
			<ul style="margin-top:81px;">
				<li style="font-size:16px;" class='titles'>关于我们</li>
				<li>
					<div><a style="font-size:13px; color:#ffffff;"  href='${pageContext.request.contextPath}/security/aboutusPage'>公司介绍</a></div>
					<div><a style="font-size:13px; color:#ffffff;" href='${pageContext.request.contextPath}/security/callUs'>联系我们</a></div>
					<div><a style="font-size:13px; color:#ffffff;" href='${pageContext.request.contextPath}/security/infoPublish'>信息发布</a></div>
					<div><a style="font-size:13px; color:#ffffff;" href='${pageContext.request.contextPath}/security/registAgreement'>注册协议</a></div>
				</li>
			</ul>
			<ul style="margin-top:81px;">
				<li style="font-size:16px;" class='titles'>产品功能</li>
				<li>
					<div><a style="font-size:13px; color:#ffffff;">注册</a></div>
					<div><a style="font-size:13px; color:#ffffff;">需求解决</a></div>
					<div><a style="font-size:13px; color:#ffffff;">资源搜索</a></div>
					<div><a style="font-size:13px; color:#ffffff;">项目对接</a></div>
				</li>
			</ul>
			<!-- <ul>
				<li style="font-size:16px;" class='titles'>常见问题</li>
				<li>
					<div><a style="font-size:13px; color:#ffffff;" href=''>关于平台</a></div>
					<div><a style="font-size:13px; color:#ffffff;" href=''>关于用户</a></div>
				</li>
			</ul> -->
			<div class='fl'>
				<div class='logo'>linkcc.cn<%-- <img src='${pageContext.request.contextPath}/resources/images/front/img/logo.png'/> --%></div>
				<div class='txt' style="font-size:12px;">联系电话：010-57207996</div>
				<div class='txt' style="font-size:12px;">电子邮箱：linkcc_service@yeah.net</div>
			</div>
			<div class='fr'>
				<%-- <div class='fl code'><img src='${pageContext.request.contextPath}/resources/images/front/img/code.png'/></div>
				<div class='fl code'><img src='${pageContext.request.contextPath}/resources/images/front/img/code.png'/></div> --%>
				<div class='fl code'></div>
				<div class='fl code'></div>
				<div class='clear'></div>
			</div>
			<div class='clear'></div>
		</div>
		<div style="margin-top:50px;font-size:12px; color:#ffffff;text-align:center" ><a href="http://www.miitbeian.gov.cn/">京ICP备16046710号</a>   © 2016-2017 Linkcc.cn，All rights reserved.</div>
	</div>
	