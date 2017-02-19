<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset='utf-8'/>
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<title>公共头部</title>
<% request.setCharacterEncoding("UTF-8");%>
<% response.setCharacterEncoding("UTF-8");%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/front/common/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/front/common/header.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/front/common/investorUserCommon.js"></script>
</head>
<body>
<div class="cons info" style="margin-top:10px;margin-bottom:0px;">
	<div class="width1200" >
		<div class='fl left'>
				<ul id="leftBtns">
					<li  id="investorMyRecommend">
					   <a href="${pageContext.request.contextPath}/investorUser/getMyRecommendBrowsePage">
						<img id="myrecommendImg"  src='${pageContext.request.contextPath}/resources/images/front/img/my_tuijian.png'/>
						<div class='txt'>我的推荐</div>
						</a>
					</li>
					<li id="investorMyRecommendAchievement">
					     <a href="${pageContext.request.contextPath}/investorUser/getMyCollectionAchievementBrowsePage">
						<img id="myCollectionAchievementImg" style="width:64px;height:56px;" src='${pageContext.request.contextPath}/resources/images/front/img/my_chengguo.png'/>
						<div class='txt'>我收藏的科研成果</div>
						</a>
					</li>
					<li id="investorMyRecommendFundRequire">
					    <a href="${pageContext.request.contextPath}/investorUser/getMyCollectionFundRequirementBrowsePage">
						<img id="myCompanyInfoImg" style="width:64px;height:56px;" src='${pageContext.request.contextPath}/resources/images/front/img/my_project.png'/>
						<div class='txt'>我收藏的企业项目</div>
						</a>
					</li>
					<li id="investorMyRecommendResearchGroup">
					   <a href="${pageContext.request.contextPath}/investorUser/getMyCollectionResearchGroupBrowsePage">
						<img id="myCollectionResearchGroupImg" style="width:64px;height:56px;" src='${pageContext.request.contextPath}/resources/images/front/img/my_tuandui.png'/>
						<div class='txt'>我收藏的科研团队</div>
						</a>
					</li>
					<li id="researchGroupMyCollectionInvestor">
						<input id="orgUrl" type="hidden" value="${pageContext.request.contextPath}/investorUser/getOrganizationUserDetailPageForAdd" />
						<input id="perUrl" type="hidden" value="${pageContext.request.contextPath}/investorUser/getPersonalUserDetailPageForAdd" />
					  	<a id="myInvestorInfo_a" href="">
							<img id="myCollectionInvestorImg" style="width:64px;height:56px;" src='${pageContext.request.contextPath}/resources/images/front/img/my_shouzhifang.png'/>
							<div class='txt'>我的投资意向</div>
						</a>
					</li>
					<li id="investorUpdateMyPassword">
					   <a href="${pageContext.request.contextPath}/investorUser/getChangePasswordPage">
						<img  id="updateMyPasswordImg" src='${pageContext.request.contextPath}/resources/images/front/img/my_change.png'/>
						<div class='txt'>修改账号信息</div>
						</a>
					</li>
				</ul>
			</div>
		</div>
	</div>
</body>