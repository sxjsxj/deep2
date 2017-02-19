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
<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/images/front/img/homepage.png" media="screen" />
</head>
<body>
	<%@ include file="/WEB-INF/pages/common/header.jsp" %>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/front/researchUser/updateMyPasswordInfo.js"></script>
	
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
		<div style="margin-top:-79px;">
		<%@ include file="/WEB-INF/pages/common/researchUserLeft.jsp" %>
         </div>
		<!-- 保存失败start -->
		<div class="registSuccess" id="alertClick"></div>
		<!-- version4 点击发布需求弹框start -->
			<div id="altsthree" style="display:none">
				<div class='xuqiualert' style="margin-top:5px;width:740px;font-size: 24px;text-align:center;color:#434343;min-height:280px;">
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
				<div class='xuqiualert' style="margin-top:5px;width:740px;font-size: 24px;text-align:center;color:#434343;min-height:280px;">
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
					<div>
					     <div>
								<font size="5" color="#349fc4">恭喜您,保存成功</font>
						  </div>
					</div>
				</div>
			</div>
			<!-- version3 点击发布需求弹框end -->
			<div  id="getDetailUrl" url="${pageContext.request.contextPath}/researchUser/getDetail"></div>
			<div style="width:938px;margin-left:-50px;" class='fl right'>
				<ul class='nav'>
					<li class='active' style="font-size:17px;" id="editPassword"><a href="#">修改密码</a></li>
					<li><a href="#" style="font-size:17px;" id="editEmail">修改邮箱/手机号</a></li>
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
