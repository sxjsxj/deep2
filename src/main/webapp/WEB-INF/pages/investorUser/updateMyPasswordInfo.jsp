<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/head.jsp" %>
<title>修改账号信息</title>
</head>
<body>
	<%@ include file="/WEB-INF/pages/common/header.jsp" %>

	<div style="margin-top:90px;" class='cons info'>
		<div class='width1200'>
		<jsp:include page="/WEB-INF/pages/common/investorUserLeft.jsp"></jsp:include>

		<!-- 保存失败start -->
		<div class="registSuccess" id="alertClick"></div>
		<!-- version4 点击发布需求弹框start -->
			<div id="altsthree" style="display:none">
				<div class='xuqiualert' style="width:740px;margin-left:-370px;font-size: 24px;text-align:center;color:#434343;min-height:280px;">
					<div class='tits'>
						保存失败
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
			<div id="altstwo" style="display:none">
				<div class='xuqiualert' style="width:309px;margin-top:15px;">
					<div class='tits'>
						保存成功
						<div class='imgs'>
							<img
								src='${pageContext.request.contextPath}/resources/images/front/img/close.png'
								class='img1' /> <img
								src='${pageContext.request.contextPath}/resources/images/front/img/close2.png'
								class='img2' />
						</div>
					</div>
				</div>
			</div>

			<div  id="getDetailUrl" url="${pageContext.request.contextPath}/investorUser/getDetail"></div>

			<!-- version3 点击发布需求弹框end -->
			<div style="margin-left:-50px;" class='fl right'>
				<ul class='nav'>
					<li style="font-size:16px;" class='active' id="editPassword"><a href="#">修改密码</a></li>
					<li style="font-size:16px;"><a href="#" id="editEmail">修改邮箱/手机号</a></li>
					<div class='clear'></div>
				</ul>
				<ul class='conul'>
					<li class='lists'>
					<form id="passwordForm">
						<div class='list'>
							<div class='name fl'>原始密码</div>
							<input type='password' style="color:black" id="oldPassword" name="oldPassword" class='fl' placeholder='请输入当前密码'/>
							<div class='clear'></div>
						</div>
						<div class='list'>
							<div class='name fl'>新密码</div>
							<input type='password' style="color:black" class='fl' id="newPasswordOne" name="newPasswordOne" placeholder='请输入新密码'/>
							<div class='clear'></div>
						</div>
						<div class='list'>
							<div class='name fl'>确认新密码</div>
							<input type='password' style="color:black" class='fl' id="newPasswordTwo" name="newPasswordTwo" placeholder='请再次输入新密码'/>
							<div class='clear'></div>
						</div>
						<div class='updateInfoanniu' id="commit" url="${pageContext.request.contextPath}/security/user/changePassword"><a href="javascript:;">确定</a></div>
					  </form>
					</li>

					<li class='lists'>
					<form id="emailForm">
						<div class='list'>
							<div class='name fl'>邮箱</div>
							<input type='text' style="color:black" id="email" name="email" class='fl' placeholder='请输入新邮箱'/>
							<div class='clear'></div>
						</div>
						<div class='list'>
							<div class='name fl'>手机号</div>
							<input type='text' id="telno" style="color:black" name="telno" class='fl' placeholder='请输入新手机号'/>
							<div class='clear'></div>
						</div>
						<div class='updateInfoanniu' id="save" url="${pageContext.request.contextPath}/security/user/updateEmailTel"><a href="javascript:;">保存</a></div>
					</form>
					</li>
				</ul>
			</div>
			<div class='clear'></div>
		</div>
	</div>
	<%@ include file="/WEB-INF/pages/common/footer.jsp" %>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/front/investorUser/updateMyPasswordInfo.js"></script>
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
