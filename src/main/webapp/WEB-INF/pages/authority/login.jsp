<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset='utf-8'/>
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<title>登录页</title>
<% request.setCharacterEncoding("UTF-8");%>
<% response.setCharacterEncoding("UTF-8");%>
<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/images/front/img/homepage.png" media="screen" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/front/style.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/front/jquery/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/front/common/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/front/authority/login.js"></script>
</head>
<input type="hidden" value="${flag}" id="flag"/>
<body>
	<div class='loginbg'>
		<div class='width1200'>
			<div class='topLogo'>
			<a href="${pageContext.request.contextPath}/security/homepage">
			<img  style="width:200px;height:40px;" src='${pageContext.request.contextPath}/resources/images/front/img/logo.png'/>
			</a>
			</div>
			<div class='loginkuang'  style="margin-top:-80px;">
				<div class='fl name'>登录</div>
				<div class='fr reg'><a href="${pageContext.request.contextPath}/security/register" id="toRegist">还没有账号，去注册>></a></div>
				<div class='clear'></div>
				<form id="loginForm" action="${pageContext.request.contextPath}/security/login" method="POST">
				<div id="loginError" style="margin-bottom:-30px;" align="center">&nbsp;</div>
				<div class='username list'>
					<div class='nams fl'>用户名</div>
					<div class='input fl'>
						<input type='text' id="j_username" name="j_username" placeholder='请输入邮箱' value="${j_username}"/>
					</div>
					<div class='clear'></div>
				</div>
				<div class='username userpass list'>
					<div class='nams fl'>密&nbsp;码</div>
					<div class='input fl'>
						<input type='password' id="j_password" name="j_password" placeholder='6-20个大小写英文字母、符号或数字' value="${j_password}"/>
					</div>
					<div class='clear'></div>
				</div>
				<div class='rem'>
					<div class='fl'>
						<input type='checkbox' checked='checked'/>记住密码
					</div>
					<div class='fr'><a href='${pageContext.request.contextPath}/security/findPasswordPage'>忘记密码?</a></div>
					<div class='clear'></div>
				</div>
				<div class='loginbtns anniu'><a href='#' id="login">登录</a></div>
				<!-- <div class='fl anniu_login_submit-btn anniu' style='margin-right:10px'>登录</div> -->

				</form>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/pages/common/footer.jsp" %>
	<%-- <div class='footer'>
		<div class='width1200'>
			<ul>
				<li class='titles'>关于我们</li>
				<li>
					<div><a href=''>公司介绍</a></div>
					<div><a href=''>联系我们</a></div>
					<div><a href=''>加入我们</a></div>
					<div><a href=''>友情链接</a></div>
				</li>
			</ul>
			<ul>
				<li class='titles'>产品功能</li>
				<li>
					<div><a href=''>注册</a></div>
					<div><a href=''>需求解决</a></div>
					<div><a href=''>资源搜索</a></div>
					<div><a href=''>项目对接</a></div>
				</li>
			</ul>
			<ul>
				<li class='titles'>常见问题</li>
				<li>
					<div><a href=''>关于平台</a></div>
					<div><a href=''>关于用户</a></div>
				</li>
			</ul>
			<div class='fl'>
				<div class='logo'>LOGO</div>
				<div class='txt'>联系电话：010-68686868</div>
				<div class='txt'>电子邮箱：12345@123.com</div>
			</div>
			<div class='fr'>
				<div class='fl code'><img src='${pageContext.request.contextPath}/resources/images/front/img/code.png'/></div>
				<div class='fl code'><img src='${pageContext.request.contextPath}/resources/images/front/img/code.png'/></div>
				<div class='clear'></div>
			</div>
			<div class='clear'></div>
		</div>
	</div> --%>
</body>
</html>
