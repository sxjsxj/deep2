<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset='utf-8'/>
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<title>联科-投资方注册</title>
<% request.setCharacterEncoding("UTF-8");%>
<% response.setCharacterEncoding("UTF-8");%>
<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/images/front/img/homepage.png" media="screen" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/front/style.css"/>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/front/alert.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/front/jquery/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/front/jquery/jquery.validate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/front/common/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/front/authority/investorUserRegister.js"></script>
</head>
<body>
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
				<div class='xuqiualert' style="width:740px;font-size: 24px;margin-top:-10px;margin-left:-370px;text-align:center;color:#434343;min-height:280px;">
					<div class='tits'>
						注册失败
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
				<div class='xuqiualert' style="width:309px;margin-top:15px;">
					<div class='tits'>
						恭喜您，注册成功
					</div>
				</div>
			</div>
			<!-- version3 点击发布需求弹框end -->


	<div class='loginbg loginbg2 loginbg3'>
		<div class='width1200'>
			<div class='topLogo' style="margin-bottom:10px;">
			<a href="${pageContext.request.contextPath}/security/homepage">
			<img style="width:200px;height:40px;" src='${pageContext.request.contextPath}/resources/images/front/img/logo.png'/>
			</a>
			</div>
		<form id="investorRegistorForm">
			<div class='loginkuang keyankuang'>
			   <div id="loginUrl" url="${pageContext.request.contextPath}/security/loginPage"></div>
			   <div id="organizationUserDetailPageForAdd" url="${pageContext.request.contextPath}/investorUser/getOrganizationUserDetailPageForAdd"></div>
			   <div id="personalUserDetailPageForAdd" url="${pageContext.request.contextPath}/investorUser/getPersonalUserDetailPageForAdd"></div>

				<div class='tit' style="font-size:25px;">我是投资方</div>
				<div style="margin-left:25px;">
				<ul class='hes' id="tagSelect">
				    <input type="hidden" id="tagCheckValue" value="0"/>
					<li style="font-size:17px;" class='active' id="organization" value="0">机构</li>
					<li style="font-size:17px;" value="1" id="personnal">个人</li>
				</ul>
				</div>
				<ul class='cons'>
					<li class='list'>
						<div  style="font-size:15px;" class='fl names'>*邮&nbsp;箱</div>
						<div class='input fl'>
							<input id="email" style="color:black" name="email" type='text' placeholder='请输入邮箱'/>
						</div>
						<div class='clear'></div>
					</li>
					<li class='list'>
						<div style="font-size:15px;" class='fl names'>*手机号</div>
						<div class='input fl'>
							<input type='text' style="color:black" id="telno" name="telno" placeholder='请输入手机号'/>
						</div>
						<div class='clear'></div>
					</li>
					<li class='list'>
						<div style="font-size:15px;" class='fl names'>*密&nbsp;码</div>
						<div class='input fl'>
							<input type='password' style="color:black" id="passwordone" name="passwordone" placeholder='6-20个大小写英文字母、符号或数字'/>
						</div>
						<div class='clear'></div>
					</li>
					<li class='list'>
						<div style="font-size:15px;" class='fl names'>*确认密码</div>
						<div class='input fl'>
							<input type='password' style="color:black" id="passwordtwo" name="passwordtwo" placeholder='请再次输入密码'/>
						</div>
						<div class='clear'></div>
					</li>
				</ul>
				<div class='rem'>
					<div class='fl'>
						<input id="agree" checked="checked"  type='checkbox'/>我已阅读并同意《<a style='color:#1faece' href='${pageContext.request.contextPath}/security/registAgreement'  id="registXieyi">linkcc.cn注册协议</a>》
					</div>
					<div id="notAgree"></div>
					<div class='clear'></div>
				</div>
				<div class='loginbtns anniu'><a href='#' url="${pageContext.request.contextPath}/security/user/addInvestorUser" id="registComit">立即注册</a></div>
					<div class='moss'><a href='${pageContext.request.contextPath}/security/loginPage'>已有帐号，去登录>></a></div>
			</div>
		  </form>
		</div>
	</div>
	<%@ include file="/WEB-INF/pages/common/footer.jsp" %>
	<%-- <div class='footer'>
		<div class='width1200'>
			<ul>
				<li style="font-size:16px;" class='titles'>关于我们</li>
				<li>
					<div><a style="font-size:13px; color:#ffffff;"  href=''>公司介绍</a></div>
					<div><a style="font-size:13px; color:#ffffff;" href=''>联系我们</a></div>
					<div><a style="font-size:13px; color:#ffffff;" href=''>加入我们</a></div>
					<div><a style="font-size:13px; color:#ffffff;" href=''>友情链接</a></div>
				</li>
			</ul>
			<ul>
				<li style="font-size:16px;" class='titles'>产品功能</li>
				<li>
					<div><a style="font-size:13px; color:#ffffff;" href=''>注册</a></div>
					<div><a style="font-size:13px; color:#ffffff;" href=''>需求解决</a></div>
					<div><a style="font-size:13px; color:#ffffff;" href=''>资源搜索</a></div>
					<div><a style="font-size:13px; color:#ffffff;" href=''>项目对接</a></div>
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
				<div class='logo'>LOGO</div>
				<div class='txt' style="font-size:12px;">联系电话：010-57207996</div>
				<div class='txt' style="font-size:12px;">电子邮箱：linkcc_service@yeah.net</div>
			</div>
			<div class='fr'>
				<div class='fl code'><img src='${pageContext.request.contextPath}/resources/images/front/img/code.png'/></div>
				<div class='fl code'><img src='${pageContext.request.contextPath}/resources/images/front/img/code.png'/></div>
				<div class='fl code'></div>
				<div class='fl code'></div>
				<div class='clear'></div>
			</div>
			<div class='clear'></div>
		</div>
		<div style="margin-top:20px;font-size:12px; color:#ffffff;text-align:center" ><a href="http://www.miitbeian.gov.cn/">京ICP备16046710号</a>   © 2016-2017 Linkcc.cn，All rights reserved.</div>
	</div> --%>
</body>
<script type="text/javascript">
	$(function(){
		$(' .lis .input').click(function(){
			if($(this).hasClass('on')){
				$(this).removeClass("on");
				$(this).find("dl").slideUp(100);
			}else{
				$(this).addClass("on");
				$(this).find("dl").slideDown(100);
			}
		});
		$('.lis .input dd').click(function(){
			$(this).parents(".input").find("input").val($(this).text());
		})
		$(".hes li").click(function(){
			$(this).addClass("active").siblings().removeClass("active");
		})
	})
</script>
</html>
