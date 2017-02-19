<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset='utf-8'/>
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<title>投资方列表</title>
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
	<%@ include file="/WEB-INF/pages/common/dialog.jsp" %>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/front/investorUser/investorList.js"></script>
	
	<div style="margin-bottom:-150px;" class='banner'>
		<img style="height:131px;width: 100%;" src='${pageContext.request.contextPath}/resources/images/front/img/banner.png' style="width:100%" height="100%" />
		<%-- <div class='width1200'>
			<div class='topbtxt'>唯有合作&nbsp;&nbsp;&nbsp;引领未来</div>
			<div class='bottombtxt'>
				<img src='${pageContext.request.contextPath}/resources/images/front/img/tel.png' class='fl'/>
				<a class='fl'>专业服务热线：</a>
				<span class='fl'>400-800-8989</span>
			</div>
		</div> --%>
	</div>
	<input id="currentPage" type="hidden" value="1"></input>
	<input type="hidden" id="searchHeaderName" value="${headerName}"/>
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
	<div class='cons listd listps'>
		<div class='width1200' >
			<ul class='heads' >
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
				<li id="queryInvestor" url="${pageContext.request.contextPath}/investorUser/query" class='selectbtn'>查询</li>
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
			<div class='fl'>
				<ul class='lis' id="investorListQuery">
					
				</ul>
				<div id="noResult" class="red"></div>
				<ul id="pagination" class='page'>
				
				</ul>
			</div>
			
			
			<div class='fr bg_img'>
				<img src='${pageContext.request.contextPath}/resources/images/front/img/fr_bg2.png' height="780" width="281" />
				<%-- <img src='${pageContext.request.contextPath}/resources/images/front/img/fr_bg2.png' height="521" width="281" /> --%>
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

		$(".listd .heads .list .checkbox").click(function(){
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
