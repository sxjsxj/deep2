<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/head.jsp" %>
<title>修改账号信息</title>
</head>
<body>
	<%@ include file="/WEB-INF/pages/common/header.jsp" %>

	<div class='cons info'>
		<div class='width1200'>
		<div>
		<%@ include file="/WEB-INF/pages/common/researchUserLeft.jsp" %>
         </div>
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
			<!-- version3 点击发布需求弹框end -->
			<div  id="getDetailUrl" url="${pageContext.request.contextPath}/researchUser/getDetail"></div>
			<div style="width:938px;margin-left:-50px;" class='fl right'>
				<ul class='nav'>
					<li class='active' style="font-size:16px;" id="editPassword"><a href="#">修改密码</a></li>
					<li><a href="#" style="font-size:16px;" id="editEmail">修改邮箱/手机号</a></li>
					<div class='clear'></div>
				</ul>
				<ul class='conul'>
					<li class='lists'>
					<form id="passwordForm">
						<div class='list'>
							<div class='name fl'>原始密码</div>
							<input style="color:black" type='password' id="oldPassword" name="oldPassword" class='fl' placeholder='请输入当前密码'/>
							<div class='clear'></div>
						</div>
						<div class='list'>
							<div class='name fl'>新密码</div>
							<input style="color:black" type='password' class='fl' id="newPasswordOne" name="newPasswordOne" placeholder='请输入新密码'/>
							<div class='clear'></div>
						</div>
						<div class='list'>
							<div class='name fl'>确认新密码</div>
							<input style="color:black" type='password' class='fl' id="newPasswordTwo" name="newPasswordTwo" placeholder='请再次输入新密码'/>
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
							<input type='text' style="color:black" id="telno" name="telno" class='fl' placeholder='请输入新手机号'/>
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
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/front/researchUser/updateMyPasswordInfo.js"></script>
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
