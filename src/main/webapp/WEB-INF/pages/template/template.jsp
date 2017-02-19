<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>航班计划信息管理系统</title>
    <% request.setCharacterEncoding("UTF-8"); %>
    <% response.setCharacterEncoding("UTF-8"); %>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/scripts/sea-modules/tui/css/tui_global.css"/>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/scripts/sea-modules/tui/css/tui_content.css"/>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/global.css"/>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/tabber.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/scripts/sea-modules/seajs/seajs/2.1.1/sea.js" id="seajsnode"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/scripts/config/globalConfig.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/scripts/sea-modules/tui/scripts/control.js"></script>
	<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/resources/scripts/sea-modules/tui/scripts/script.js"></script> --%>
</head>
<body>
	<input type="hidden" id="loginPage" url="${pageContext.request.contextPath}/authority/loginPage"></input>
	<input type="hidden" id="moreInfo" url="${pageContext.request.contextPath}/util/getMoreInfo"></input>
	<input type="hidden" id="detailInfo" url="${pageContext.request.contextPath}/util/getDetailInfo"></input>
	<input type="hidden" id="processInfo" url="${pageContext.request.contextPath}/util/processInfo"></input>
	<input type="hidden" id="processDetailInfo" url="${pageContext.request.contextPath}/util/processDetailInfo"></input>

	<tiles:insertAttribute name="header"/>
	<tiles:insertAttribute name="body" />
	<tiles:insertAttribute name="footer"/>
</body>
</html>
