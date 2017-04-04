<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/head.jsp" %>
<title>个人中心-企业-我的推荐列表</title>
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

		<div class='width1200'>
		<jsp:include page="/WEB-INF/pages/common/companyUserLeft.jsp"></jsp:include>


			<!-- 没有维护企业信息跳转url -->
			<div id="notCompanyInfo" url="${pageContext.request.contextPath}/companyUser/getDetailPageForAdd"></div>

			 <!--发布需求弹框start  -->
			<div id="companyAlts">
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
							<div class='bg' id="techRequire" url="${pageContext.request.contextPath}/techRequirement/getDetailPageForAdd">
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
							<div class='bg' id="fundRequire" url="${pageContext.request.contextPath}/fundRequirement/getDetailPageForAdd">
								<img src='${pageContext.request.contextPath}/resources/images/front/img/reg4.png' style='margin-top: 45px' class='img1' />
								<img src='${pageContext.request.contextPath}/resources/images/front/img/reg2.png' style='margin-top: 55px' class='img2' />
							</div>
							<div class='tx'>
								<div class='t'>我要发布资金需求</div>
								<div class='f'>我有项目 寻求资金</div>
							</div>
						</li>
					</ul>
				</div>
			</div>
           <!--发布需求弹框end  -->

			<!-- version2 点击发布需求弹框start -->
			<div id="altsone" style="display:none">
				<div class='xuqiualert' style="margin-top:-90px;margin-left:-370px;width:740px;font-size: 24px;text-align:center;color:#434343;min-height:280px;">
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
			<div style="margin-left:-50px;" class='fl right change2' style="margin-bottom:25px;">
				<div class='publishmyrequire' id="publishRequirement">发布需求</div>
				<div style="margin-top: 4px;margin-left: 19px;color: #999999;font-size: 13px;float: left;">
				 为您的企业做大做强插上腾飞的翅膀！技术问题怎么解决？新产品如何研发？发展资金哪里获得？
				 <br/>
                                         现在填写企业信息、发布您的需求。专业的科研团队、可靠的投资方，将与您携手成功！
				</div>
			</div>
			<div class='fl right' style="margin-left:-50px;">
				<div  style="margin-top:10px;font-size:17px;" class='title'>为您推荐的科研成果</div>
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
				<li>
					<div class='fl ti2' style="font-size:15px;">阶段</div>
					<div id="checkBoxPhase">
						<div class='fl list'>
							<div class='checkbox fl'>
								<img id="phaseCheckBox0" src='${pageContext.request.contextPath}/resources/images/front/img/checkbox.png'/>
							</div>
							<div class='fl'><input type="hidden" value="0" id="phaseCheckBoxValue0"/>研发阶段</div>
							<div class='clear'></div>
						</div>
						<div class='fl list'>
							<div class='checkbox fl'>
								<img id="phaseCheckBox1" src='${pageContext.request.contextPath}/resources/images/front/img/checkbox.png'/>
							</div>
							<div class='fl'><input type="hidden" value="1" id="phaseCheckBoxValue1"/>实验室阶段</div>
							<div class='clear'></div>
						</div>
						<div class='fl list'>
							<div class='checkbox fl'>
								<img id="phaseCheckBox2" src='${pageContext.request.contextPath}/resources/images/front/img/checkbox.png'/>
							</div>
							<div class='fl'><input type="hidden" value="2" id="phaseCheckBoxValue2"/>概念阶段</div>
							<div class='clear'></div>
						</div>
						<div class='fl list'>
							<div class='checkbox fl'>
								<img id="phaseCheckBox3" src='${pageContext.request.contextPath}/resources/images/front/img/checkbox.png'/>
							</div>
							<div class='fl'><input type="hidden" value="3" id="phaseCheckBoxValue3"/>小批量生产阶段</div>
							<div class='clear'></div>
						</div>
						<div class='fl list'>
							<div class='checkbox fl'>
								<img id="phaseCheckBox4" src='${pageContext.request.contextPath}/resources/images/front/img/checkbox.png'/>
							</div>
							<div class='fl'><input type="hidden" value="4" id="phaseCheckBoxValue4"/>规模化生产阶段</div>
							<div class='clear'></div>
						</div>
						<div class='fl list'>
							<div class='checkbox fl'>
								<img id="phaseCheckBox5" src='${pageContext.request.contextPath}/resources/images/front/img/checkbox.png'/>
							</div>
							<div class='fl'><input type="hidden" value="5" id="phaseCheckBoxValue5"/>市场推广阶段</div>
							<div class='clear'></div>
						</div>
						<input type="hidden" id="phaseId"/>
					</div>
					<div class='clear'></div>
				</li>
					<li>
					<div class='fl ti2' style="font-size:15px;">合作方式</div>
					<div id="checkBoxCooperationType">
						<div class='fl list'>
							<div class='checkbox fl'>
								<img id="cooperationTypeCheckBox0" src='${pageContext.request.contextPath}/resources/images/front/img/checkbox.png'/>
							</div>
							<div class='fl'><input type="hidden" value="0" id="cooperationTypeCheckBoxValue0"/>技术入股</div>
							<div class='clear'></div>
						</div>
						<div class='fl list'>
							<div class='checkbox fl'>
								<img id="cooperationTypeCheckBox1" src='${pageContext.request.contextPath}/resources/images/front/img/checkbox.png'/>
							</div>
							<div class='fl'><input type="hidden" value="1" id="cooperationTypeCheckBoxValue1"/>技术转让</div>
							<div class='clear'></div>
						</div>
						<div class='fl list'>
							<div class='checkbox fl'>
								<img id="cooperationTypeCheckBox2" src='${pageContext.request.contextPath}/resources/images/front/img/checkbox.png'/>
							</div>
							<div class='fl'><input type="hidden" value="2" id="cooperationTypeCheckBoxValue2"/>技术许可</div>
							<div class='clear'></div>
						</div>
						<div class='fl list'>
							<div class='checkbox fl'>
								<img id="cooperationTypeCheckBox3" src='${pageContext.request.contextPath}/resources/images/front/img/checkbox.png'/>
							</div>
							<div class='fl'><input type="hidden" value="3" id="cooperationTypeCheckBoxValue3"/>委托开发</div>
							<div class='clear'></div>
						</div>
						<div class='fl list'>
							<div class='checkbox fl'>
								<img id="cooperationTypeCheckBox4" src='${pageContext.request.contextPath}/resources/images/front/img/checkbox.png'/>
							</div>
							<div class='fl'><input type="hidden" value="4" id="cooperationTypeCheckBoxValue4"/>技术服务</div>
							<div class='clear'></div>
						</div>
						<div class='fl list'>
							<div class='checkbox fl'>
								<img id="cooperationTypeCheckBox5" src='${pageContext.request.contextPath}/resources/images/front/img/checkbox.png'/>
							</div>
							<div class='fl'><input type="hidden" value="5" id="cooperationTypeCheckBoxValue5"/>其他</div>
							<div class='clear'></div>
						</div>
						<input type="hidden" id="cooperationTypeId"/>
					</div>
					<div class='clear'></div>
				</li>
					<li id="queryAchievement" url="${pageContext.request.contextPath}/achievement/query" class='myrecomendbtn'>查询</li>
				</ul>
				<div id="achievementMoreInfo" url="${pageContext.request.contextPath}/achievement/getMoreInfoPage"></div>
				<div id="addFollowerUrl" url="${pageContext.request.contextPath}/achievementFollower/add"></div>
                <div id="cancelFollowerUrl" url="${pageContext.request.contextPath}/achievementFollower/delete"></div>
				<div id="loginUrl" url="${pageContext.request.contextPath}/security/loginPage"></div>
				<div class='title2'>
					<div class='checkbox fl'>
						<%-- <img src='${pageContext.request.contextPath}/resources/images/front/img/checkbox.png'/> --%>
					</div>
					<div class='fl'></div>
					<div class='clear'></div>
				</div>
				<ul class='lis' style="margin-top:-15px;" id="achievementListQuery">

				</ul>

				<div id="noResult" class="red"></div>
				<ul style="margin-left:280px;" id="pagination" class='page'>

				</ul>
			</div>
			<div class='clear'></div>
		</div>
	</div>
	<%@ include file="/WEB-INF/pages/common/footer.jsp" %>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/front/companyUser/myRecommendAchievementList.js"></script>
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
