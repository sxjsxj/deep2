<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset='utf-8'/>
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<title>科研成果列表</title>
<% request.setCharacterEncoding("UTF-8");%>
<% response.setCharacterEncoding("UTF-8");%>
<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/images/front/img/homepage.png" media="screen" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/front/researchUser/achievementList.js"></script>
	
	<div class='banner' style="margin-bottom:-135px;">
		<img style="height:131px;width: 100%;" src='${pageContext.request.contextPath}/resources/images/front/img/banner.png' style="width:100%" height="100%" />
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
	<div class='cons listd'>
		<div class='width1200'>
			<!-- <div class='ts'>没有找到想要的科研成果？现在发布一个需求  >></div>
			<div class='ts2'>我也要发布科研成果，让企业主动找到我！>></div> -->
			<ul class='heads'>
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
				
				<li>
					<div class='fl ti2'></div>
					<div id="checkBoxStatus">
						<div class='fl list'>
							<div class='checkbox fl'>
								<img id="statusCheckBox" src='${pageContext.request.contextPath}/resources/images/front/img/checkbox.png'/>
							</div>
							<div class='fl'><input type="hidden" id="statusCheckBoxValue"/>只查看正在寻求合作的科研成果</div>
							<div class='clear'></div>
						</div>
						<input type="hidden" id="statusId"/>
					</div>
					<div class='clear'></div>
				</li>
				
				<li id="queryAchievement" url="${pageContext.request.contextPath}/achievement/query" class='selectbtn'>查询</li>
			</ul>
			<div id="achievementMoreInfo" url="${pageContext.request.contextPath}/achievement/getMoreInfoPage"></div>
			<div id="addFollowerUrl" url="${pageContext.request.contextPath}/achievementFollower/add"></div>
			<div id="cancelFollowerUrl" url="${pageContext.request.contextPath}/achievementFollower/delete"></div>
			<div id="loginUrl" url="${pageContext.request.contextPath}/security/loginPage"></div> 
			<div class='title2'>
				<%-- <div class='checkbox fl'>
					<img src='${pageContext.request.contextPath}/resources/images/front/img/checkbox.png'/>
				</div> --%>
				<div class='fl'></div>
				<div class='clear'></div>
			</div>
			<div class='fl'>
				<ul class='lis' id="achievementListQuery">
					
				</ul>
				<div id="noResult" class="red"></div>
				
				<div>
					<ul id="pagination" class='page'>
					
					</ul>
				</div>
			</div>
			<div class='fr'>
				<img src='${pageContext.request.contextPath}/resources/images/front/img/fr_bg.png'/>
			</div>
			<div class='clear'></div>
		</div>
	</div>
	<%@ include file="/WEB-INF/pages/common/footer.jsp" %>
	<%-- <div class='footer'>
		<div class='width1200'>
			<ul>
				<li class='titles'>关于我们</li>
				<li>
					<div><a href=''>公司介绍</a></div>
					<div><a href=''>联系我们</a></div>
					<div><a href=''>加入我们</a></div>
					<div><a href=''>友情链接</a></div>
				</li>
			</ul>
			<ul>
				<li class='titles'>产品功能</li>
				<li>
					<div><a href=''>注册</a></div>
					<div><a href=''>需求解决</a></div>
					<div><a href=''>资源搜索</a></div>
					<div><a href=''>项目对接</a></div>
				</li>
			</ul>
			<ul>
				<li class='titles'>常见问题</li>
				<li>
					<div><a href=''>关于平台</a></div>
					<div><a href=''>关于用户</a></div>
				</li>
			</ul>
			<div class='fl'>
				<div class='logo'>LOGO</div>
				<div class='txt'>联系电话：010-68686868</div>
				<div class='txt'>电子邮箱：12345@123.com</div>
			</div>
			<div class='fr'>
				<div class='fl code'><img src='${pageContext.request.contextPath}/resources/images/front/img/code.png'/></div>
				<div class='fl code'><img src='${pageContext.request.contextPath}/resources/images/front/img/code.png'/></div>
				<div class='clear'></div>
			</div>
			<div class='clear'></div>
		</div>
	</div> --%>
	
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
