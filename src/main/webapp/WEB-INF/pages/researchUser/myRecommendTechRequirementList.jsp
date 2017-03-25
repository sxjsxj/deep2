<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/head.jsp" %>
<title>科研团队-我的推荐技术需求列表</title>
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
	<%@ include file="/WEB-INF/pages/common/dialog.jsp" %>

	<div class='cons tuijian'>
		<div class='width1200'>
			<%@ include file="/WEB-INF/pages/common/researchUserLeft.jsp" %>

			<input id="currentPage" type="hidden" value="1"></input>
			<!-- 提交查询条件时 大区里的值start -->
	<input id="renmenCheckboxResult" type="hidden" value=""></input>
	<input id="huananCheckboxResult" type="hidden" value=""></input>
	<input id="huabeiCheckboxResult" type="hidden" value=""></input>
	<input id="huadongCheckboxResult" type="hidden" value=""></input>
	<input id="huazhongCheckboxResult" type="hidden" value=""></input>
	<input id="xibeiCheckboxResult" type="hidden" value=""></input>
	<input id="dongbeiCheckboxResult" type="hidden" value=""></input>
	<input id="xinanCheckboxResult" type="hidden" value=""></input>
	<input id="gangaotaiCheckboxResult" type="hidden" value=""></input>
	<input id="haiwaiCheckboxResult" type="hidden" value=""></input>
	<!-- 提交查询条件时 大区里的值end -->

	<!-- 寻求合作弹框start -->
	<input id="opeationIdIndex" type="hidden" value=""></input>
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

            <!-- 没有维护科研团队跳转url -->
            <div id="notReserarchGroup" url="${pageContext.request.contextPath}/researchGroup/getDetailPageForAdd"></div>

              <!-- 维护科研团队跳转url -->
            <div id="publishAchievement" url="${pageContext.request.contextPath}/achievement/getDetailPageForAdd"></div>


			<div style="margin-left:-50px;" class='fl right change2' style="margin-bottom:25px;">
				<div class='createResearchBtn_top' id="publishMyAchievement">发布科研成果</div>
			</div>


			<div style="margin-left:-50px;" class='fl right'>
				<div style="margin-top:10px;font-size:17px;" class='title'>为您推荐的技术需求</div>
				<ul style="margin-top:10px;margin-bottom:-10px;" class='heads'>
					<li style='margin-bottom:5px'>
						<div class='fl ti2' style="font-size:15px;">省市地区</div>
						<div class='fl list'>
							<div class='checkbox fl' id="onlySeeLocalCity">
								<img src='${pageContext.request.contextPath}/resources/images/front/img/checkbox.png'/>
							</div>
							<div class='fl'>只查看本省市</div>
							<div class='clear'></div>
						</div>
						<div class='clear'></div>
					</li>
					<div id="region" url="${pageContext.request.contextPath}/basicProvinceArea/queryAreaProvince">

			        </div>

					<li>
					<div class='fl ti2' style="font-size:15px;">研发类型</div>
					<div id="checkBoxType">
						<div class='fl list'>
							<div class='checkbox fl'>
								<img id="typeCheckBox0" src='${pageContext.request.contextPath}/resources/images/front/img/checkbox.png'/>
							</div>
							<div class='fl'><input type="hidden" value="0" id="typeCheckBoxValue0"/>新产品研发</div>
							<div class='clear'></div>
						</div>
						<div class='fl list'>
							<div class='checkbox fl'>
								<img id="typeCheckBox1" src='${pageContext.request.contextPath}/resources/images/front/img/checkbox.png'/>
							</div>
							<div class='fl'><input type="hidden" value="1" id="typeCheckBoxValue1"/>产品技术升级</div>
							<div class='clear'></div>
						</div>
						<div class='fl list'>
							<div class='checkbox fl'>
								<img id="typeCheckBox2" src='${pageContext.request.contextPath}/resources/images/front/img/checkbox.png'/>
							</div>
							<div class='fl'><input type="hidden" value="2" id="typeCheckBoxValue2"/>技术服务</div>
							<div class='clear'></div>
						</div>
						<input type="hidden" id="typeId"/>
					</div>
					<div class='clear'></div>
				</li>
				<li>
					<div class='fl ti2' style="font-size:15px;">研发经费</div>
					<div id="checkBoxAmount">
						<div class='fl list'>
							<div class='checkbox fl'>
								<img id="amountCheckBox0" src='${pageContext.request.contextPath}/resources/images/front/img/checkbox.png'/>
							</div>
							<div class='fl'><input type="hidden" value="0" id="amountCheckBoxValue0"/>100万以下</div>
							<div class='clear'></div>
						</div>
						<div class='fl list'>
							<div class='checkbox fl'>
								<img id="amountCheckBox1" src='${pageContext.request.contextPath}/resources/images/front/img/checkbox.png'/>
							</div>
							<div class='fl'><input type="hidden" value="1" id="amountCheckBoxValue1"/>100-500万</div>
							<div class='clear'></div>
						</div>
						<div class='fl list'>
							<div class='checkbox fl'>
								<img id="amountCheckBox2" src='${pageContext.request.contextPath}/resources/images/front/img/checkbox.png'/>
							</div>
							<div class='fl'><input type="hidden" value="2" id="amountCheckBoxValue2"/>500－1000万</div>
							<div class='clear'></div>
						</div>
						<div class='fl list'>
							<div class='checkbox fl'>
								<img id="amountCheckBox3" src='${pageContext.request.contextPath}/resources/images/front/img/checkbox.png'/>
							</div>
							<div class='fl'><input type="hidden" value="3" id="amountCheckBoxValue3"/>1000万以上</div>
							<div class='clear'></div>
						</div>
						<div class='fl list'>
							<div class='checkbox fl'>
								<img id="amountCheckBox4" src='${pageContext.request.contextPath}/resources/images/front/img/checkbox.png'/>
							</div>
							<div class='fl'><input type="hidden" value="4" id="amountCheckBoxValue4"/>面议</div>
							<div class='clear'></div>
						</div>
						<input type="hidden" id="amountId"/>
					</div>
					<div class='clear'></div>
				</li>
					<li id="queryTechRequirement" url="${pageContext.request.contextPath}/techRequirement/query" class='myrecomendbtn'>查询</li>
				</ul>
			<div id="techRequirementMoreInfo" url="${pageContext.request.contextPath}/techRequirement/getMoreInfoPage"></div>
			<div id="addFollowerUrl" url="${pageContext.request.contextPath}/techRequirementFollower/add"></div>
        	<div id="cancelFollowerUrl" url="${pageContext.request.contextPath}/techRequirementFollower/delete"></div>
			<div id="loginUrl" url="${pageContext.request.contextPath}/security/loginPage"></div>
			
			<!-- 查询科研团队 -->
			<div id="getResearchGroup" url="${pageContext.request.contextPath}/researchGroup/query"></div>
			<!-- 科研成果新增界面 -->
			<div id="addAchieveMentPageUrl" url="${pageContext.request.contextPath}/achievement/getDetailPageForAdd"></div>
			<div class='title2'>
				<%-- <div class='checkbox fl'>
					<img src='${pageContext.request.contextPath}/resources/images/front/img/checkbox.png'/>
				</div> --%>
				<div class='fl'></div>
				<div class='clear'></div>
			</div>
				<ul class='lis' id="techRequirementListQuery">

				</ul>
				<div id="noResult" class="red"></div>

				<ul style="margin-left:280px;" id="pagination" class='page'>

				</ul>
			</div>
			<div class='clear'></div>
		</div>
	</div>
	<%@ include file="/WEB-INF/pages/common/footer.jsp" %>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/front/researchUser/myRecommendTechRequirementList.js"></script>
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

		$(".tuijian .right .heads .list .checkbox").click(function(){
			if($(this).hasClass('on')){
				$(this).removeClass("on");
				$(this).find('img').attr("src",'${pageContext.request.contextPath}/resources/images/front/img/checkbox.png')
			}else{
				$(this).addClass("on");
				$(this).find('img').attr("src",'${pageContext.request.contextPath}/resources/images/front/img/checkbox2.png')
			}

		})

		$(".molist").slideUp(0);
		$("#moresLink").click(function(){
			if($(this).hasClass('SM')){
				$(this).removeClass("SM");
				$(this).empty();
				$(this).append("<a href='#'>更多>></a>");
				$(".molist").slideUp(100);
			}else{
				$(this).addClass("SM");
				$(this).empty();
				$(this).append("<a href='#'>收起</a>");
				$(".molist").slideDown(100);
			}
		})
		$(".listlastmore .heads .list .checkbox").click(function(){
			if($(this).hasClass('on')){
				$(this).removeClass("on");
				$(this).find('img').attr("src",'${pageContext.request.contextPath}/resources/images/front/img/checkbox.png')
			}else{
				$(this).addClass("on");
				$(this).find('img').attr("src",'${pageContext.request.contextPath}/resources/images/front/img/checkbox2.png')
			}

		})
	})
</script>
<script type="text/javascript">
//div随滚动条滚动
$(function () {
  $(window).scroll(function () {
    var top = $(window).scrollTop() + 200;
    var left = $(window).scrollLeft() + 320;
    $("#editInfo1").animate({ "top": top }, 30);
  });

  $(window).scroll(function () {
	    var top = $(window).scrollTop() + 200;
	    var left = $(window).scrollLeft() + 320;
	    $("#editInfo2").animate({ "top": top }, 30);
 });


  $(window).scroll(function () {
	    var top = $(window).scrollTop() + 200;
	    var left = $(window).scrollLeft() + 320;
	    $("#altstwo").animate({ "top": top }, 30);
  });


  $(window).scroll(function () {
	    var top = $(window).scrollTop() + 200;
	    var left = $(window).scrollLeft() + 320;
	    $("#altsthree").animate({ "top": top }, 30);
  });


  $(window).scroll(function () {
	    var top = $(window).scrollTop() + 200;
	    var left = $(window).scrollLeft() + 320;
	    $("#nologin").animate({ "top": top }, 30);
  });

});
</script>
</html>
