<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/head.jsp" %>
<title>科研团队-我收藏的投资方投资方列表</title>
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
		<jsp:include page="/WEB-INF/pages/common/researchUserLeft.jsp"></jsp:include>

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

			<div style="margin-left:-50px;" class='fl right cons listd listps'>
				<div style="margin-top:-40px;font-size:17px;" class='title'>我收藏的投资方</div>
				<ul style="margin-top:10px;margin-bottom:-10px;" class='heads'>
					<li>
					<div class='fl ti2' style="font-size:15px;">学科领域</div>
				    <div id="checkBoxDomain" url="${pageContext.request.contextPath}/basicResearchField/query">

					<input type="hidden" id="domainId"/>
					</div>
					<div class='clear'></div>
				</li>
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
					<div class='fl ti2' style="font-size:15px;">投资额</div>
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
				<li>
					<div class='fl ti2' style="font-size:15px;">投资阶段</div>
					<div id="checkBoxInvestPhase" >
					<div class='fl list'>
						<div class='checkbox fl'>
							<img id="investPhaseCheckBox0" src='${pageContext.request.contextPath}/resources/images/front/img/checkbox.png'/>
						</div>
						<div class='fl'><input type="hidden" value="0" id="investPhaseCheckBoxValue0"/>研发阶段</div>
						<div class='clear'></div>
					</div>
					<div class='fl list'>
						<div class='checkbox fl'>
							<img id="investPhaseCheckBox1" src='${pageContext.request.contextPath}/resources/images/front/img/checkbox.png'/>
						</div>
						<div class='fl'><input type="hidden" value="1" id="investPhaseCheckBoxValue1"/>实验室阶段</div>
						<div class='clear'></div>
					</div>
					<div class='fl list'>
						<div class='checkbox fl'>
							<img id="investPhaseCheckBox2" src='${pageContext.request.contextPath}/resources/images/front/img/checkbox.png'/>
						</div>
						<div class='fl'><input type="hidden" value="2" id="investPhaseCheckBoxValue2"/>概念阶段</div>
						<div class='clear'></div>
					</div>
					<div class='fl list'>
						<div class='checkbox fl'>
							<img id="investPhaseCheckBox3" src='${pageContext.request.contextPath}/resources/images/front/img/checkbox.png'/>
						</div>
						<div class='fl'><input type="hidden" value="3" id="investPhaseCheckBoxValue3"/>小批量生产</div>
						<div class='clear'></div>
					</div>
					<div class='fl list'>
						<div class='checkbox fl'>
							<img id="investPhaseCheckBox4" src='${pageContext.request.contextPath}/resources/images/front/img/checkbox.png'/>
						</div>
						<div class='fl'><input type="hidden" value="4" id="investPhaseCheckBoxValue4"/>规模化生产</div>
						<div class='clear'></div>
					</div>
					<div class='fl list'>
						<div class='checkbox fl'>
							<img id="investPhaseCheckBox5" src='${pageContext.request.contextPath}/resources/images/front/img/checkbox.png'/>
						</div>
						<div class='fl'><input type="hidden" value="5" id="investPhaseCheckBoxValue5"/>市场推广阶段</div>
						<div class='clear'></div>
					</div>
					<input type="hidden" id="investPhaseId"/>
					</div>
					<div class='clear'></div>
				</li>
					<li id="queryInvestor" url="${pageContext.request.contextPath}/investorUserFollower/query" class='myrecomendbtn'>查询</li>
				</ul>
				<div id="investorUserMoreInfo" url="${pageContext.request.contextPath}/investorUser/getMoreInfoPage"></div>

			<div id="addFollowerUrl" url="${pageContext.request.contextPath}/investorUserFollower/add"></div>
        		<div id="cancelFollowerUrl" url="${pageContext.request.contextPath}/investorUserFollower/delete"></div>
        		<div id="loginUrl" url="${pageContext.request.contextPath}/security/loginPage"></div>
			<div class='title2'>
				<%-- <div class='checkbox fl'>
					<img src='${pageContext.request.contextPath}/resources/images/front/img/checkbox.png'/>
				</div> --%>
				<div class='fl'></div>
				<div class='clear'></div>
			</div>
				<ul class='lis' id="investorListQuery">

				</ul>
				<div id="noResult" class="red"></div>
				<ul style="margin-left:280px;" id="pagination" class='page'>

				</ul>
			</div>
			<div class='clear'></div>
		</div>
	</div>
	<%@ include file="/WEB-INF/pages/common/footer.jsp" %>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/front/researchUser/myCollectionInvestorList.js"></script>
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
