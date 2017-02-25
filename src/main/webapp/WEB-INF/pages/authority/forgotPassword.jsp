<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset='utf-8'/>
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<title>忘记密码</title>
<% request.setCharacterEncoding("UTF-8");%>
<% response.setCharacterEncoding("UTF-8");%>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/front/style.css"/>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/front/alert.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/front/jquery/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/front/jquery/jquery.validate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/front/common/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/front/authority/forgotPassword.js"></script>
</head>
<body>

<!-- 注册成功弹框 statr -->
		<div id="Button1" onclick="ShowDiv('MyDiv','fade')"></div>
			<div id="fade" class="black_overlay"></div>
			<div id="MyDiv" class="white_content" style="margin-top:200px">
				<div style="text-align: right; cursor: default; height: 40px;">
					<!-- <span style="font-size: 16px;" onclick="CloseDiv('MyDiv','fade')">关闭</span> -->
				</div>
				<div style="margin-top:120px;margin-left:300px">
					<font size="5">新密码已经成功发送到您的邮箱请查收!</font>
					<br />
				</div>
			</div>
	<!-- 注册成功弹框 end -->
	
	<!-- 注册弹框 statr -->
	<div class="registSuccess" id="alertClick"></div>
	<!-- <div class="city" align="center" style="margin-top: 370px;">
		<div class="top01-city">
			<em class="ok">关闭</em>
		</div>
		<div class="mid01-city">
			<br />
			<br />
			<br /> <font align="center"></font> <br />
			<br /> <font id="errorInfo">&nbsp;&nbsp;</font> <br />
			<br />
		</div>
	</div> -->
	
		<!-- version4 点击发布需求弹框start -->
			<div id="altsthree">
				<div class='xuqiualert' style="width:740px;margin-top:15px;font-size: 24px;text-align:center;color:#434343;min-height:280px;">
					<div class='tits'>
						发送失败!
						<div class='imgs'>
							<img
								src='${pageContext.request.contextPath}/resources/images/front/img/close.png'
								class='img1' /> <img
								src='${pageContext.request.contextPath}/resources/images/front/img/close2.png'
								class='img2' />
						</div>
					</div>
					<div>
					     <div>
								<font id="errorInfo" size="5" color="#349fc4"></font>
						  </div>
					</div>
				</div>
			</div>
			<!-- version4 点击发布需求弹框end -->
	
	<!-- version3 点击发布需求弹框start -->
			<div id="altstwo">
				<div class='xuqiualert' style="width:740px;margin-top:15px;font-size: 24px;text-align:center;color:#434343;min-height:280px;">
					<div class='tits'>
						发送成功!
						<div class='imgs'>
							<img
								src='${pageContext.request.contextPath}/resources/images/front/img/close.png'
								class='img1' /> <img
								src='${pageContext.request.contextPath}/resources/images/front/img/close2.png'
								class='img2' />
						</div>
					</div>
					<div>
					     <div>
								<font size="5" color="#349fc4">已经发送验证码,请在两小时内查看邮箱并输入验证码!</font>
						  </div>
					</div>
				</div>
			</div>
			<!-- version3 点击发布需求弹框end -->

   <!-- 发送成功后跳转url  start -->
  <div id="toSubmitPasswordPageUrl" url="${pageContext.request.contextPath}/security/submitPasswordPage"></div>
   <!-- 发送成功后跳转url  end -->
   
	<div class='loginbg'>
		<div class='width1200'>
			<div class='topLogo'>
			<a href="${pageContext.request.contextPath}/security/homepage">
			<img style="width:200px;height:40px;" src='${pageContext.request.contextPath}/resources/images/front/img/logo.png'/>
			</a>
			</div>
			<div class='loginkuang' style="margin-top:-80px;">
				<div class='fl name'>找回密码</div>
				<div class='fr reg'><a href='${pageContext.request.contextPath}/security/loginPage' >返回登录界面>></a></div>
				<div class='clear'></div>
				<form id="findPasswordForm">
				<div class='username list'>
					<div class='nams fl'>邮箱</div>	
					<div class='input fl'>
						<input type='text' id="email" name="email" placeholder='请输入邮箱'/>
					</div>
					<div class='clear'></div>
				</div>
				<!-- <div class='username userpass list'>
					<div class='nams fl'>新密码</div>	
					<div class='input fl'>
						<input type='password' id="password" name="password" placeholder='6-20个大小写英文字母、符号或数字'/>
					</div>
					<div class='clear'></div>
				</div> -->
				<div class='rem'>
					<%-- <div class='fl'>
						<div class='fr'><a href='${pageContext.request.contextPath}/security/loginPage'><font color="blue" size="4">返回登录界面</font></a></div>
					</div> --%>
					<div class='fr'><a href=''></a></div>
					<div class='clear'></div>
				</div>
				<div class='loginbtns anniu'><a href='#' url="${pageContext.request.contextPath}/security/user/sendEmail" id="send">发送验证码</a></div>
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
