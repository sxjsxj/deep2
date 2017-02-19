<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset='utf-8'/>
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<title>注册方式选择页</title>
<% request.setCharacterEncoding("UTF-8");%>
<% response.setCharacterEncoding("UTF-8");%>
<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/images/front/img/homepage.png" media="screen" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/front/style.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/front/jquery/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/front/common/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/front/authority/regchoose.js"></script>
</head>
<body>
	<div class='regchoose'>
		<div class='width1200'>
				<div class='topLogo'>
				<a href="${pageContext.request.contextPath}/security/homepage">
					<img style="width:200px;height:50px;" src='${pageContext.request.contextPath}/resources/images/front/img/logo.png' />
				</a>
				</div>
			
			<div class='topTxt'>请选择您的身份进行注册</div>
			<ul>
				<li>
					<div class='topimg'  id="company" url="${pageContext.request.contextPath}/security/user/companyUserRegistPage">
						<img src='${pageContext.request.contextPath}/resources/images/front/img/reg1.png' style='margin-top:33px' class='img1'/>
						<img src='${pageContext.request.contextPath}/resources/images/front/img/reg5.png' style='margin-top:49px' class='hide img2'/>
					</div>
					<div class='bottomf'>我是企业</div>
					<div class='bottomt'>我有技术难题寻求合作</div>
					<div class='bottomt'>我有项目成果寻求资金</div>
				</li>
				<li>
					<div class='topimg' id="researchGroup" url="${pageContext.request.contextPath}/security/user/researchGroupRegistPage">
						<img src='${pageContext.request.contextPath}/resources/images/front/img/reg4.png' style='margin-top:35px;margin-left:-3px' class='img1'/>
						<img src='${pageContext.request.contextPath}/resources/images/front/img/reg2.png' class='hide img2'/>
					</div>
					<div class='bottomf'>我是科研团队</div>
					<div class='bottomt'>我有科研成果寻求转让</div>
					<div class='bottomt'>我有在研课题寻求合作</div>
				</li>
				<li>
					<div class='topimg' url="${pageContext.request.contextPath}/security/user/investorRegistPage" id="investor">
						<img src='${pageContext.request.contextPath}/resources/images/front/img/reg3.png' class='img1'/>
						<img src='${pageContext.request.contextPath}/resources/images/front/img/reg6.png' style='margin-top:65px' class='hide img2'/>
					</div>
					<div class='bottomf'>我是投资方</div>
					<div class='bottomt'>我有资金</div>
					<div class='bottomt'>寻求合作</div>
				</li>
			</ul>
			<div class='logis'><a href=''>已有帐号，去登录>></a></div>
			<div class='ques'>
				<div class='ts'>如有任何疑问，请您拨打：</div>
				<div class='tss'>400-888-9999</div>
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
<script type="text/javascript">
	$(function(){
		
	})
</script>
</html>
