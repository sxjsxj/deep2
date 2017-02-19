<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset='utf-8'/>
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<title>投资方-我收藏的科研团队</title>
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
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/front/investorUser/myCollectionResearchGroupList.js"></script>
	
	<div class='cons tuijian'>
		<div class='width1200'>
		<jsp:include page="/WEB-INF/pages/common/investorUserLeft.jsp"></jsp:include>
			
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
				<div style="margin-top:-40px;font-size:17px;"" class='title'>我收藏的科研团队</div>
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
					<li id="queryResearchGroup" url="${pageContext.request.contextPath}/researchGroupFollower/query" class='myrecomendbtn'>查询</li>
				</ul>
				<div id="addFollowerUrl" url="${pageContext.request.contextPath}/researchGroupFollower/add"></div>
        			<div id="cancelFollowerUrl" url="${pageContext.request.contextPath}/researchGroupFollower/delete"></div>
        
        			<div id="loginUrl" url="${pageContext.request.contextPath}/security/loginPage"></div> 
				<div id="researchGroupMoreInfo" url="${pageContext.request.contextPath}/researchGroup/getMoreInfoPage"></div>
			<div class='title2'>
				<%-- <div class='checkbox fl'>
					<img src='${pageContext.request.contextPath}/resources/images/front/img/checkbox.png'/>
				</div> --%>
				<div class='fl'></div>
				<div class='clear'></div>
			</div>
				<ul class='lis' id="researchGroupListQuery">
					
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
