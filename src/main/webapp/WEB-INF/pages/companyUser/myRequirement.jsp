<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/head.jsp" %>
<title>我的需求</title>
<style type="text/css">
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

	<div class='cons tuijian'>
		<div class='width1200'>
		<jsp:include page="/WEB-INF/pages/common/companyUserLeft.jsp"></jsp:include>


			<!-- version1 点击发布需求弹框start -->
			<%-- <div class="registSuccess" id="alertClick"></div>
			<div class="city" style="margin-top:50px" align="center">
				<div class="top01-city">
					<em class="ok">关闭</em>
				</div>
				<div class="mid01-city">
					<br />
					<br />
					<br /> <font size="5">请您先维护企业信息!</font> <br />
					<br />
					<font align="center" color="blue"><a
						href="${pageContext.request.contextPath}/companyUser/getDetailPageForAdd"><font size="5">现在完善企业信息</font></a></font>
					<br />
				</div>
			</div> --%>
			<!-- version1 点击发布需求弹框end -->


			<!-- version2 点击发布需求弹框start -->
			<div id="altsone" style="display:none">
				<div class='xuqiualert' style="margin-top:-90px;margin-left:-400px;width:740px;font-size: 24px;text-align:center;color:#434343;min-height:280px;">
					<div class='tits'>
						请您先维护企业信息
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
								<font size="5" color="#434343;">您还没有维护企业信息,请先维护企业信息</font>
						  </div>
						  <div>
								<font align="center" color="blue">
								 <a href="${pageContext.request.contextPath}/companyUser/getDetailPageForAdd">
								  <font size="5" color="#349fc4">现在就去完善企业信息>></font>
								  </a>
								  </font>
						  </div>
					</div>

				</div>
			</div>
			<!-- version2 点击发布需求弹框end -->



			 <!--发布需求弹框start  -->
			<div id="alts" style="display:none">
				<div class='xuqiualert'>
					<div class='tits'>
						请选择您的需求类型
						<div class='imgs'>
							<img src='${pageContext.request.contextPath}/resources/images/front/img/close.png' class='img1' />
							<img src='${pageContext.request.contextPath}/resources/images/front/img/close2.png' class='img2' />
						</div>
					</div>
					<ul>
						<li>
							<div class='bg' id="myTechRequire" url="${pageContext.request.contextPath}/techRequirement/getDetailPageForAdd">
								<img src='${pageContext.request.contextPath}/resources/images/front/img/reg3.png' style='margin-top: 55px' class='img1' />
								<img src='${pageContext.request.contextPath}/resources/images/front/img/reg6.png' style='margin-top: 66px' class='img2' />
							</div>
							<div class='tx'>
								<div class='t'>我要发布技术需求</div>
								<div class='f'>我有技术难题需要解决</div>
								<div class='f'>我希望得到最新的技术或者产品</div>
							</div>
						</li>
						<li>
							<div class='bg' id="myFundRequire" url="${pageContext.request.contextPath}/fundRequirement/getDetailPageForAdd">
								<img src='${pageContext.request.contextPath}/resources/images/front/img/reg4.png' style='margin-top: 45px' class='img1' />
								<img src='${pageContext.request.contextPath}/resources/images/front/img/reg2.png' style='margin-top: 55px' class='img2' />
							</div>
							<div class='tx'>
								<div class='t'>我要发布资金需求</div>
								<div class='f'>我有项目  寻求资金</div>
							</div>
						</li>
					</ul>
				</div>
			</div>
           <!--发布需求弹框end  -->

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
			<div id="queryTechRequirement" url="${pageContext.request.contextPath}/techRequirement/query"></div>
			<div id="techRequirementMoreInfo" url="${pageContext.request.contextPath}/techRequirement/getMoreInfoPage"></div>
			<div id="techRequirementDetail" url="${pageContext.request.contextPath}/techRequirement/getDetailPageForUpdate"></div>
			<div id="techRequirementDelete" url="${pageContext.request.contextPath}/techRequirement/delete"></div>


			<div id="queryFundRequirement" url="${pageContext.request.contextPath}/fundRequirement/query"></div>
			<div id="fundRequirementMoreInfo" url="${pageContext.request.contextPath}/fundRequirement/getMoreInfoPage"></div>
		    <div id="fundRequirementDetail" url="${pageContext.request.contextPath}/fundRequirement/getDetailPageForUpdate"></div>
		    <div id="fundRequirementDelete" url="${pageContext.request.contextPath}/fundRequirement/delete"></div>

			<input id="currentPage" type="hidden" value="1"></input>
			<div class='fl right change2' style="margin-left:-50px;">
				<div class='publishmyrequire' id="publishMyRequirement">发布需求</div>
				<div class="clear"></div>
				<ul class='nav'>
				   <input type="hidden" id="tagValue" value="0"/>
					<li class='active' id="techRequire"><div style="font-size:16px;">技术需求</div></li>
					<li id="fundRequire"><div style="font-size:16px;">资金需求</div></li>
					<div class='clear'></div>
				</ul>
				<input id="child0FlagFirst" type="hidden" value="0"/>
				<ul class='nav2'>
				    <input type="hidden" id="childtagValue" value="5"/>
					&nbsp;&nbsp;&nbsp;
					<li id="child0">所有项目(0)</li>
					<li id="child1">待审核(0)</li>
					<li id="child2">征集中(0)</li>
					<li id="child3">洽谈中(0)</li>
					<li id="child4">合作中(0)</li>
					<li id="child5">已完成(0)</li>
					<li id="child6">已拒绝(0)</li>
				</ul>
				<ul class='con' id="requirementListQuery">

				</ul>
				<div id="noResult" class="red"></div>

				<ul style="margin-left:280px;" id="pagination" class='page'>

				</ul>
			</div>
			<div class='clear'></div>
		</div>
	</div>
	<%@ include file="/WEB-INF/pages/common/footer.jsp" %>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/front/companyUser/myRequirement.js"></script>
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
