<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/head.jsp" %>
<title>无权限</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/front/index.css" />
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
</html>
