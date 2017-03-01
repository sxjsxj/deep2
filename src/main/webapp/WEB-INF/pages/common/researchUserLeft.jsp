<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset='utf-8' />
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<title>公共头部</title>
<% request.setCharacterEncoding("UTF-8");%>
<% response.setCharacterEncoding("UTF-8");%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/front/common/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/front/common/header.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/front/common/researchUserCommon.js"></script>

</head>
<body>
<div class="cons info" style="margin-top:10px;margin-bottom:0px;width:220px;float:left">
	<div class="width1200" >
	<div class='fl left'>
		<ul id="leftBtns">
			<li id="researchGroupMyReserachGroup">
				<a	href="${pageContext.request.contextPath}/researchUser/getMyResearchGroupPage">
					<img id="myCollectionResearchGroupImg"
					style="width: 64px; height: 56px;"
					src='${pageContext.request.contextPath}/resources/images/front/img/my_tuandui.png' />
					<div class='txt'>我的科研团队</div>
				</a>
			</li>
			<li id="researchGroupMyAchievement"><a
				href="${pageContext.request.contextPath}/researchUser/getMyAchievementPage">
					<img id="myCollectionAchievementImg"
					style="width: 64px; height: 56px;"
					src='${pageContext.request.contextPath}/resources/images/front/img/my_chengguo.png' />
					<div class='txt'>我的科研成果</div>
				</a>
			</li>
			<li id="researchGroupMyRecommend"><a
				href="${pageContext.request.contextPath}/researchUser/getMyRecommendTechRequirePage">
					<img id="myrecommendImg"
					src='${pageContext.request.contextPath}/resources/images/front/img/my_tuijian.png'
					class='img1' />
					<div class='txt'>我的推荐</div>
				</a>
			</li>
			<li id="researchGroupMyCollectionTechRequirement"><a
				href="${pageContext.request.contextPath}/researchUser/getMyCollectionTechRequirePage">
					<img id="myreqImg"
					src='${pageContext.request.contextPath}/resources/images/front/img/my_xuqiu.png' />
					<div class='txt'>我收藏的需求</div>
				</a>
			</li>
			<li id="researchGroupMyCollectionInvestor"><a
				href="${pageContext.request.contextPath}/researchUser/getMyCollectionInvestorBrowsePage">
					<img id="myCollectionInvestorImg"
					style="width: 64px; height: 56px;"
					src='${pageContext.request.contextPath}/resources/images/front/img/my_shouzhifang.png' />
					<div class='txt'>我收藏的投资方</div>
				</a>
			</li>
			<li id="researchGroupMyInfo"><a
				href="${pageContext.request.contextPath}/researchUser/getMyInfoBrowsePage">
					<img id="myCompanyInfoImg" style="width: 64px; height: 56px;"
					src='${pageContext.request.contextPath}/resources/images/front/img/my_info.png' />
					<div class='txt'>我的资料</div>
				</a>
			</li>
			<li id="researchGroupUpdateMyPassword">
				<a	href="${pageContext.request.contextPath}/researchUser/getChangePasswordPage">
					<img id="updateMyPasswordImg"
					src='${pageContext.request.contextPath}/resources/images/front/img/my_change.png' />
					<div class='txt'>修改账号信息</div>
				</a>
			</li>
		</ul>
	</div>
	</div></div>
</body>
</html>
