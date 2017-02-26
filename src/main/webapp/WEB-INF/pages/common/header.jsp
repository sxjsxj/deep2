
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<input type="hidden" value="" id="commonUserLoginId"/>
<input type="hidden" value="" id="commonUserType"/>
<input type="hidden" value="" id="commonUserTel"/>

<input type="hidden" value="" id="commonCompanyUserId"/>
<input type="hidden" value="" id="commonResearchUserId"/>
<input type="hidden" value="" id="commonResearchUserType"/>
<input type="hidden" value="" id="commonInvestorUserId"/>
<input type="hidden" value="" id="commonInvestorUserType"/>
<!-- 设置本省市 -->
<input type="hidden" value="" id="commonMySelfProvince"/>
<input type="hidden" value="" id="commonMySelfCity"/>
<input type="hidden" value="" id="commonMySelfDomain"/>

<!-- 投资方信息 -->
<input type="hidden" value="" id="investorDomain"/>
<input type="hidden" value="" id="investorAmount"/>
<input type="hidden" value="" id="investorPhase"/>
<input type="hidden" value="" id="investorProvince"/>
<input type="hidden" value="" id="investorCity"/>

<!-- 402881dc56d07f6c0156d0804e890001 -->
<div id="downFile" url="${pageContext.request.contextPath}/downFile"></div>
<div id="headerSearchAchievement" url="${pageContext.request.contextPath}/achievement/getBrowsePage"></div>
<div id="headerSearchTechRequirement" url="${pageContext.request.contextPath}/techRequirement/getBrowsePage"></div>
<div id="headerSearchFundRequirement" url="${pageContext.request.contextPath}/fundRequirement/getBrowsePage"></div>
<div id="headerSearchResearchGroup" url="${pageContext.request.contextPath}/researchGroup/getBrowsePage"></div>
<div id="headerSearchInvestorUser" url="${pageContext.request.contextPath}/investorUser/getBrowsePage"></div>
<div class='headbg'>
	<div class='width1200'>
		<div class='logo fl'>
		    <a href="${pageContext.request.contextPath}/security/homepage">
			<img style="width:150px;height:30px;margin-top:10px;" src='${pageContext.request.contextPath}/resources/images/front/img/logo.png'/>
			</a>
		</div>
		<ul class='fl nav'>
			<%-- <li><a href="${pageContext.request.contextPath}/security/homePage">首页</a></li> --%>
			<a href="${pageContext.request.contextPath}/achievement/getBrowsePage"><li>找科研成果</li></a>
			<li>
				找企业需求
				<dl>
					<a href="${pageContext.request.contextPath}/techRequirement/getBrowsePage"><dd>技术需求</dd></a>
					<a href="${pageContext.request.contextPath}/fundRequirement/getBrowsePage"><dd>资金需求</dd></a>
				</dl>
			</li>
			<a href="${pageContext.request.contextPath}/researchGroup/getBrowsePage"><li>找科研团队</li></a>
			<a href="${pageContext.request.contextPath}/investorUser/getBrowsePage"><li>找投资资金</li></a>
			<!-- <div class='clear'></div> -->
		</ul>
		<div style="margin-left:4px;"  class='fr right'>
			<div class='input fl'>
				<input type='text' placeholder='' id="searchName" class='fl'/>
				<div class='button fl'>
					<span>科研成果</span><img src='${pageContext.request.contextPath}/resources/images/front/img/downicon.png'/>
					<input id="headerSelectCheck" type='hidden' value='0'/>
					<dl id="headerSelectSearch">
					    <dd value="0">科研成果</dd>
						<dd value="1">技术需求</dd>
						<dd value="2">资金需求</dd>
						<dd value="3">科研团队</dd>
						<dd value="4">投资资金</dd>
					</dl>
				</div>
				<!-- <div class='clear'></div> -->
			</div>
			<div class='fl searbtn'>
				<a href="#" id="headerSerarch">搜索</a>
			</div>
			<div class='fl usericon'><img src='${pageContext.request.contextPath}/resources/images/front/img/usericon.png'/></div>
			<div class='fl loginreg'>
				<a id="login" href="${pageContext.request.contextPath}/security/loginPage">登录</a>
				<a id="register" href="${pageContext.request.contextPath}/security/register">注册</a>
			</div>
			<div class='fl loginreg'>
				<a style="font-size:12px;" id="currentUser" url="${pageContext.request.contextPath}/security/getCurrentUser" hidden></a>
				<a style="font-size:12px;" id="goCenter" href="javascript:;" hidden>个人中心</a>
				<a style="font-size:12px;" id="logout" href="${pageContext.request.contextPath}/logout" hidden>退出</a>
			</div>
			<div class='clear'></div>
		</div>
		<div class='clear'></div>
	</div>
	<div>
		<input style="padding-left:500px;width:100%;height:30px;color:red;" type="text" value="${jspPath}" />
	</div>
</div>
<div id="companyUserCenter" url="${pageContext.request.contextPath}/companyUser/getMyRecommendAchievementBrowsePage"></div>
<div id="researchUserCenter" url="${pageContext.request.contextPath}/researchUser/getMyRecommendTechRequirePage"></div>
<div id="investorUserCenter" url="${pageContext.request.contextPath}/investorUser/getMyRecommendBrowsePage"></div>
<div id="adminUserCenter" url="${pageContext.request.contextPath}/back/index.html"></div>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/front/common/header.js"></script>
