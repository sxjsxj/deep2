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
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/front/style.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/front/jquery/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/front/jquery/jquery.validate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/front/researchgroup/updateMyPasswordInfo.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/front/common/common.js"></script>
</head>
<body>
	<%@ include file="/WEB-INF/pages/common/header.jsp" %>
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
					<li id="researchGroupMyReserachGroup">
					   <a href="${pageContext.request.contextPath}/researchUser/getMyResearchGroupPage">
						<img src='${pageContext.request.contextPath}/resources/images/front/img/my_tuandui.png'/>
						<div class='txt'>我的科研团队</div>
						</a>
					</li>
					<li id="researchGroupMyAchievement">
					<a href="${pageContext.request.contextPath}/researchUser/getMyAchievementPage">
						<img src='${pageContext.request.contextPath}/resources/images/front/img/my_chengguo.png'/>
						<div class='txt'>我的科研成果</div>
						</a>
					</li>
					<li id="researchGroupMyRecommend">
					   <a href="${pageContext.request.contextPath}/researchUser/getMyRecommendTechRequirePage">
						<img src='${pageContext.request.contextPath}/resources/images/front/img/my_tuijian.png' class='img1'/>
						<div class='txt'>我的推荐</div>
						</a>
					</li>
					<li id="researchGroupMyCollectionTechRequirement">
					<a href="${pageContext.request.contextPath}/researchUser/getMyCollectionTechRequirePage">
						<img src='${pageContext.request.contextPath}/resources/images/front/img/my_xuqiu2.png'/>
						<div class='txt'>我收藏的需求</div>
						</a>
					</li>
					<li id="researchGroupMyCollectionInvestor">
					<a href="${pageContext.request.contextPath}/researchUser/getmyCollectionInvestorBrowsePage">
						<img src='${pageContext.request.contextPath}/resources/images/front/img/my_shouzhifang.png'/>
						<div class='txt'>我收藏的投资方</div>
						</a>
					</li>
					<li class='active' id="researchGroupMyInfo">
					<a href="${pageContext.request.contextPath}/researchUser/getMyInfoBrowsePage">
						<img src='${pageContext.request.contextPath}/resources/images/front/img/my_info.png'/>
						<div class='txt'>我的资料</div>
						</a>
					</li>
					<li id="researchGroupUpdateMyPassword">
					<a href="${pageContext.request.contextPath}/user/getChangePasswordPage">
						<img src='${pageContext.request.contextPath}/resources/images/front/img/my_change.png'/>
						<div class='txt'>修改账号信息</div>
						</a>
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
							<input type='text' id="email" name="email" class='fl' placeholder='请输入新邮箱'/>
							<div class='clear'></div>
						</div>
						<div class='list'>
							<div class='name fl'>手机号</div>
							<input type='text' id="telno" name="telno" class='fl' placeholder='请输入新手机号'/>
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
