<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<meta charset='utf-8' />
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<title>无权限</title>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setCharacterEncoding("UTF-8");
%>
<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/images/front/img/homepage.png" media="screen" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/front/style.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/front/index.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/front/jquery/jquery-1.8.3.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/front/common/common.js"></script>
</head>
<body>
	<%@ include file="/WEB-INF/pages/common/header.jsp"%>
	<div class='cons tuijian'>
		<div class='width1200'>
			<div class='fl right'>
				<div class='title'></div>
				<div class='my_tuijian_con'>
					<div class='my_tuijian_con_title'><font color="blue">你没有权限访问该资源，请联系管理员</font></div>
					<div class='my_tuijian_con_txt'>
						<span><font color="blue">请您联系网站负责人</font></span>
					</div>
				</div>
			</div>
			<div class='clear'></div>
		</div>
	</div>
	<%@ include file="/WEB-INF/pages/common/footer.jsp"%>
</body>