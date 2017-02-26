<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/head.jsp" %>
<title>修改账号信息</title>
</head>
<body>
	<%@ include file="/WEB-INF/pages/common/header.jsp" %>

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
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/front/authority/changeMyinfo.js"></script>
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
