<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset='utf-8'/>
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<title>修改账号信息</title>
<% request.setCharacterEncoding("UTF-8");%>
<% response.setCharacterEncoding("UTF-8");%>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/front/style.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/front/jquery/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/front/jquery/jquery.validate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/front/authority/changeMyinfo.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/front/common/common.js"></script>
</head>
<body>
	<div class='headbg'>
		<div class='width1200'>
			<div class='logo fl'>
				<img style="width:223px;height:58px;" src='${pageContext.request.contextPath}/resources/images/front/img/logo.png'/>
			</div>
			<ul class='fl nav'>
				<li>首页</li>
				<li class='active'>找科研成果</li>
				<li>
					找企业需求
					<dl>
						<dd>技术需求</dd>
						<dd>资金需求</dd>
					</dl>
				</li>
				<li>找科研团队</li>
				<li>找投资资金</li>
				<div class='clear'></div>
			</ul>
			<div class='fr right'>
				<div class='input fl'>
					<input type='text' placeholder='产业技术' class='fl'/>
					<div class='button fl'>
						<span>科研成果</span><img src='${pageContext.request.contextPath}/resources/images/front/img/downicon.png'/>
						<dl>
							<dd>企业需求</dd>
							<dd>科研团队</dd>
							<dd>投资资金</dd>
						</dl>
					</div>
					<div class='clear'></div>
				</div>
				<div class='fl searbtn'>
					搜索
				</div>
				<div class='fl usericon'><img src='${pageContext.request.contextPath}/resources/images/front/img/usericon.png'/></div>
				<div class='fl loginreg'>
					<a href="">登录</a>
					<a href="">注册</a>
				</div>
				<div class='clear'></div>
			</div>
			<div class='clear'></div>
		</div>
	</div>
	<!-- <div class='banner'>
		<img src='${pageContext.request.contextPath}/resources/images/front/img/banner2.png' style="width:100%" height="100%" />
		<div class='width1200'>
			<div class='hex'>
				<div class='head_img fl'><img src='${pageContext.request.contextPath}/resources/images/front/img/head_img.png'/></div>
				<div class='fl'>
					<div class='hex_t'>中国科学院</div>
					<div class='hex_tx'>备注资料备注资料，备注资料备注资料备注资料备注资料，备注资料备注资料备注资料备注资料备注资料备注资料备注资料备注资料</div>
				</div>
				<div class='clear'></div>
			</div>
			<div class='right'>
				<div class='btn'><a href=''>修改资料</a></div>
				<div class='btn'><a href=''>退出</a></div>
			</div>
		</div>
	</div> -->
	<div class='cons info'>
		<div class='width1200'>
			<div class='fl left'>
				<ul>
					<li>
						<img src='${pageContext.request.contextPath}/resources/images/front/img/my_xuqiu2.png'/>
						<div class='txt'>我的需求</div>
					</li>
					<li>
						<img src='${pageContext.request.contextPath}/resources/images/front/img/my_tuijian.png'/>
						<div class='txt'>我的推荐</div>
					</li>
					<li>
						<img src='${pageContext.request.contextPath}/resources/images/front/img/my_chengguo.png'/>
						<div class='txt'>我收藏的科研成果</div>
					</li>
					<li>
						<img src='${pageContext.request.contextPath}/resources/images/front/img/my_tuandui.png'/>
						<div class='txt'>我收藏的科研团队</div>
					</li>
					<li>
						<img src='${pageContext.request.contextPath}/resources/images/front/img/my_shouzhifang.png'/>
						<div class='txt'>我收藏的投资方</div>
					</li>
					<li>
						<img src='${pageContext.request.contextPath}/resources/images/front/img/my_info.png'/>
						<div class='txt'>我的企业信息</div>
					</li>
					<li class='active'>
						<img src='${pageContext.request.contextPath}/resources/images/front/img/my_change2.png'/>
						<div class='txt'>修改账号信息</div>
					</li>
				</ul>
			</div>
			<div class='fl right'>
				<ul class='nav'>
					<li class='active'>修改密码</li>
					<li>修改邮箱/手机号</li>
					<div class='clear'></div>
				</ul>
				<ul class='conul'>
					<li class='lists'>
					<form id="passwordForm">
						<div class='list'>
							<div class='name fl'>原始密码</div>
							<input type='password' id="oldPassword" name="oldPassword" class='fl' placeholder='请输入当前密码'/>
							<div class='clear'></div>
						</div>
						<div class='list'>
							<div class='name fl'>新密码</div>
							<input type='password' class='fl' id="newPasswordOne" name="newPasswordOne" placeholder='请输入新密码'/>
							<div class='clear'></div>
						</div>
						<div class='list'>
							<div class='name fl'>确认新密码</div>
							<input type='password' class='fl' id="newPasswordTwo" name="newPasswordTwo" placeholder='请再次输入新密码'/>
							<div class='clear'></div>
						</div>
						<div class='anniu' id="commit" url="${pageContext.request.contextPath}/security/user/update">确定</div>
					  </form>
					</li>
				
					<li class='lists hide'>
					<form id="emailForm">
						<div class='list'>
							<div class='name fl'>邮箱</div>
							<input type='text' id="email" name="email" class='fl' placeholder='请输入当前密码'/>
							<div class='clear'></div>
						</div>
						<div class='list'>
							<div class='name fl'>手机号</div>
							<input type='text' id="telno" name="telno" class='fl' placeholder='请输入新密码'/>
							<div class='clear'></div>
						</div>
						<div class='anniu' id="save" url="${pageContext.request.contextPath}/security/user/update">保存</div>
					</form>
					</li>
				</ul>
			</div>
			<div class='clear'></div>
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
		$('.info .right .nav li').click(function(){
			$(this).addClass("active").siblings().removeClass("active");
			$('.info .right .conul li').eq($(this).index()).show().siblings("li").hide();
		})
	})
</script>
</html>
