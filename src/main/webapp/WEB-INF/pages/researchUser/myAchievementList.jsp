<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset='utf-8'/>
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<title>个人中心-我的科研成果</title>
<% request.setCharacterEncoding("UTF-8");%>
<% response.setCharacterEncoding("UTF-8");%>
<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/images/front/img/homepage.png" media="screen" />
<style> 
.mydiv1 {} 
.mydiv2 { 
     box-shadow: 0px 3px 8px #808080;
	-moz-box-shadow:0px 3px 8px #808080;/*firefox*/ 
	-webkit-box-shadow:0px 3px 8px #808080;/*webkit*/ 
} 
</style> 
</head>
<body>
	<%@ include file="/WEB-INF/pages/common/header.jsp" %>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/front/researchUser/myAchievementList.js"></script>
	
	<div class='cons tuijian'>
		<div class='width1200'>
		<jsp:include page="/WEB-INF/pages/common/researchUserLeft.jsp"></jsp:include>
			
			<input type="hidden" id="researchGroupId" value="">
			<input type="hidden" id="hasResearchGroup" value="">
			
			<!-- version2 点击发布需求弹框start -->
			<div id="altsone" style="display:none">
				<div class='xuqiualert' style="margin-top:0px;margin-left:-400px;width:740px;font-size: 24px;text-align:center;color:#434343;min-height:280px;">
					<div class='tits'>
						请您先维护科研团队信息
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
								<font size="5" color="#434343;">请您先维护科研团队信息</font>
						  </div>
						  <div>
								<font align="center" color="blue">
								 <a href="${pageContext.request.contextPath}/researchGroup/getDetailPageForAdd">
								  <font size="5"  color="#349fc4">现在完善科研团队信息>></font>
								  </a>
								  </font>
						  </div>
					</div>
					
				</div>
			</div>
			<!-- version2 点击发布需求弹框end -->
			
			<!-- 编辑删除弹框start -->
    <div class="registSuccess" id="alertClick"></div>
		<!-- version4 点击发布需求弹框start -->
			<div id="altsthree" style="display:none">
				<div class='xuqiualert' style="width:740px;margin-top:15px;font-size: 24px;text-align:center;color:#434343;min-height:280px;">
					<div class='tits'>
						操作失败
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
				<div class='xuqiualert' style="width:740px;margin-top:15px;font-size: 24px;text-align:center;color:#434343;min-height:280px;">
					<div class='tits'>
						删除成功
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
								<font size="5" color="#349fc4">删除成功</font>
						  </div>
					</div>
				</div>
			</div>
			<!-- version3 点击发布需求弹框end -->
<!-- end -->

<div id="altsnotdel" style="display:none">
				<div class='xuqiualert' style="width:740px;margin-top:15px;font-size: 24px;text-align:center;color:#434343;min-height:280px;">
					<div class='tits'>
						删除操作
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
								<font id="errorInfo" size="5" color="#349fc4">不能删除该记录</font>
						  </div>
					</div>
				</div>
			</div>
			
			<div id="queryAchievement" url="${pageContext.request.contextPath}/achievement/query"></div>
			<div id="achievementMoreInfo" url="${pageContext.request.contextPath}/achievement/getMoreInfoPage"></div>
		<div id="achievementDetail" url="${pageContext.request.contextPath}/achievement/getDetailPageForUpdate"></div>
		<div id="achievementDelete" url="${pageContext.request.contextPath}/achievement/delete"></div>
		
		<!-- 查询科研团队 -->
		<div id="getResearchGroup" url="${pageContext.request.contextPath}/researchGroup/query"></div>
			<!-- 科研成果新增界面 -->
			<div id="addAchieveMentPageUrl" url="${pageContext.request.contextPath}/achievement/getDetailPageForAdd"></div>
			<input id="currentPage" type="hidden" value="1"></input>
			<div style="margin-left:-50px;" class='fl right change2'>
				<div style="margin-bottom:25px;" class='createResearchBtn_top' id="publishMyAchievement">发布科研成果</div>
				<!-- <ul class='nav'>
				   <input type="hidden" id="tagValue" value="0"/>
					<li class='active' id="techRequire">技术需求</li>
					<li id="fundRequire">资金需求</li>
					<div class='clear'></div>
				</ul> -->
				<input id="child0FlagFirst" type="hidden" value="0"/>
				<ul class='nav2'>
				    <input type="hidden" id="childtagValue" value="5"/>
					&nbsp;&nbsp;&nbsp;
					<li id="child0"></li>
					<li id="child1"></li>
					<li id="child2"></li>
					<li id="child3"></li>
					<li id="child4"></li>
					<li id="child5"></li>
				</ul>
				<ul class='con lis' id="myAchievementQuery">
					
				</ul>
				<div id="noResult" class="red"></div>
				
				<ul style="margin-left:280px;" id="pagination" class='page'>
				
				</ul>
			</div>
			<div class='clear'></div>
		</div>
	</div>
	<%@ include file="/WEB-INF/pages/common/footer.jsp" %>
</body>
<script type="text/javascript">
	$(function(){
		$('.cons .right .xuqiu4 .input').click(function(){
			if($(this).hasClass('on')){
				$(this).removeClass("on");
				$(this).find("dl").slideUp(100);
			}else{
				$(this).addClass("on");
				$(this).find("dl").slideDown(100);
			}
		});
		$('.cons .right .xuqiu4 .input dd').click(function(){
			$(this).parents(".input").find("input").val($(this).text());
		})

		$(".headbg .input .button").click(function(){
			if($(this).hasClass('on')){
				$(this).removeClass("on");
				$(".headbg .input .button dl").slideUp(100);
			}else{
				$(this).addClass("on");
				$(".headbg .input .button dl").slideDown(100);
			}
		})

		$('.headbg .input .button dd').click(function(){
			$(this).parents(".button").find("span").text($(this).text());
		})
	})
</script>
</html>
