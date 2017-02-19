<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 
<input id="errorFlag" type="hidden" value="0" />
<input id="currentUserId" type="hidden" value="" />
<input id="currentUserName" type="hidden" value="" />
<input id="currentUserDept" type="hidden" value="" />
<input id="currentUserDeptDesc" type="hidden" value="" />
<input id="currentUserDeptType" type="hidden" value="" />
<input id="getHiddenList" type="hidden" value="${pageContext.request.contextPath}/security/getHiddenList"/>
<input id="getCurrentUser" type="hidden" value="${pageContext.request.contextPath}/security/getCurrentUser"/>
<input id="getMessageCount" type="hidden" value="${pageContext.request.contextPath}/message/messageReciever/queryCount"/>
<audio id="myaudio" src="${pageContext.request.contextPath}/resources/css/251204462511050.mp3" controls="controls" hidden="true"></audio>
<!-- header start -->
   <%--  <div class="headerLayout">
    	<div class="header">
            <div class="logo left"><img src="${pageContext.request.contextPath}/resources/images/logo2.png" title="中国民航总局运输司航班计划统计信息管理" /></div>
            <div class="topText right">
             	<a class="white" href="${pageContext.request.contextPath}/message/messageReciever/getBrowsePage">我的消息</a>&nbsp;<span id="msgNum" class="tipsNum">0</span>&nbsp;&nbsp;<span class="white">|</span>&nbsp;&nbsp;
             	<a id="advice" href="" class="white">提意见</a>&nbsp;&nbsp;<span class="white">|</span>&nbsp;&nbsp;
             	<a class="white">帮助</a>&nbsp;&nbsp;<span class="white">|</span>&nbsp;&nbsp;
             	<a id="exitLogin" href="${pageContext.request.contextPath}/j_spring_security_logout" class="white">退出</a><br/>
                <span id="welcomeLogin" class="gold"></span><span class="white">，欢迎登录</span>
            </div>
          <div class="clear"></div>
      	</div>
        <!-- 导航 start -->
        <div id="menu"><!-- class="menu"-->
            <ul id="webmenu" class="first-menu">
                <li><a href="javascript:void(0)" url="${pageContext.request.contextPath}/security/homepage" class="lastNode">首页</a></li>
                <li><a href="javascript:void(0)">经营许可</a>
                    <ul style="display: none;" class="second-menu">
                        <li><a href="javascript:void(0)" id="dBusinessLicense_md" url="${pageContext.request.contextPath}/domestic/dBusinessLicense/getBrowsePage" class="lastNode">国内/港澳台</a></li>
                        <li><a href="javascript:void(0)" id="iBusinessLicense_md" url="${pageContext.request.contextPath}/international/iBusinessPermit/iBusinessPermitBrowsePage" class="lastNode">国际</a></li>
                    </ul>
                </li>
                <li><a href="javascript:void(0)">航班计划</a>
                    <ul style="display: none;" class="second-menu">
                        <li><a href="javascript:void(0)" id="dFlightPlan_md" url="${pageContext.request.contextPath}/domestic/dFlightPlan/dFlightPlanBrowsePage" class="lastNode">国内/港澳台</a></li>
                        <li><a href="javascript:void(0)" id="iFlightPlan_md" url="${pageContext.request.contextPath}/international/iFlightPlan/iFlightPlanBrowsePage" class="lastNode">国际</a></li>
                        <li><a href="javascript:void(0)" id="iFlightPlan2_md" url="${pageContext.request.contextPath}/domestic/dPreliminaryApproval/dPreliminaryApprovalBrowsePage" class="lastNode">国内航班计划预审</a></li>
                        <li><a href="javascript:void(0)" id="iFlightPlan2_md" url="${pageContext.request.contextPath}/unify/unifiedFlightPlan/unifiedFlightPlanBrowsePage" class="lastNode">综合查询</a></li>
                    </ul>
                </li>
                <li><a href="javascript:void(0)">基础数据</a>
                	<ul style="display: none;" class="second-menu">
                        <li><a href="javascript:void(0)" id="regionalTemplate_md" url="${pageContext.request.contextPath}/regionalTemplate/regionalTemplateBrowse" class="lastNode">区域配置</a></li>
                        <li><a href="javascript:void(0)" id="headerTemplate_md" url="${pageContext.request.contextPath}/commonData/headerTemplate/getBrowsePage" class="lastNode">表头配置</a></li>
                		<li><a href="javascript:void(0)" id="dProtectAirroute_md" url="${pageContext.request.contextPath}/domestic/dProtectAirroute/getBrowsePage" class="lastNode">保护航线</a></li>
                		<li><a href="javascript:void(0)" id="designatedAirroute_md" url="${pageContext.request.contextPath}/commonData/designatedAirroute/getBrowsePage" class="lastNode">指定航线</a></li>
                		<li><a href="javascript:void(0)" id="dExecutionRate_md" url="${pageContext.request.contextPath}/domestic/dExecutionRate/getBrowsePage" class="lastNode">执行率</a></li>
                		<li><a href="javascript:void(0)" class="arrow">客座率</a>
                			<ul class="third-menu">
                                	<li><a id="dSeatRate_md" href="javascript:void(0)" url="${pageContext.request.contextPath}/domestic/dSeatRate/getBrowsePage" class="lastNode">分航线客座率</a></li>
                                	<li><a id="dSeatRateByCarr_md" href="javascript:void(0)" url="${pageContext.request.contextPath}/domestic/dSeatRateByCarr/getBrowsePage" class="lastNode">分航司分航线客座率</a></li>
                			</ul>
                		</li>
                		<li><a href="javascript:void(0)" id="libraryOpenOrClose_md" url="${pageContext.request.contextPath}/commonData/libraryOpenOrClose/libraryOpenOrCloseBrowsePage" class="lastNode">开/关库</a></li>
                		<li><a href="javascript:void(0)" id="libraryOpenOrClose_md" url="${pageContext.request.contextPath}/commonData/libraryOpenOrClose/libraryOpenOrCloseBrowsePage" class="lastNode">机型</a></li>
                		<li><a href="javascript:void(0)" id="libraryOpenOrClose_md" url="${pageContext.request.contextPath}/commonData/basicData/basicDataAirportBrowsePage" class="lastNode">机场</a></li>
                		<li><a href="javascript:void(0)" id="libraryOpenOrClose_md" url="${pageContext.request.contextPath}/commonData/basicData/basicDataCarrCodeBrowsePage" class="lastNode">航空公司</a></li>
                		<li><a href="javascript:void(0)" id="libraryOpenOrClose_md" url="${pageContext.request.contextPath}/commonData/libraryOpenOrClose/libraryOpenOrCloseBrowsePage" class="lastNode">航空公司基地库</a></li>
                	</ul>
                </li>
                <li><a href="javascript:void(0)">统计分析</a>
                	<ul style="display: none;" class="second-menu">
                         <li><a href="javascript:void(0)" id="airrouteFlightCount_md" url="${pageContext.request.contextPath}/statistics/routeCount/getBrowsePage" class="lastNode">航线统计</a></li>
                         <li><a href="javascript:void(0)" id="flightsWeek_md" url="${pageContext.request.contextPath}/statistics/routeFlightCount/getBrowsePage" class="lastNode">班次统计</a></li>
                         <li><a href="javascript:void(0)" id="flightsAnalyse_md" url="${pageContext.request.contextPath}/statistics/routeFlightAnalysis/getBrowsePage" class="lastNode">航线分析</a></li>
                	     <li><a href="javascript:void(0)" id="airportCount_md" url="${pageContext.request.contextPath}/statistics/airportCount/getBrowsePage" class="lastNode">海空军机场</a></li>
                	</ul>
                </li>
                <li><a href="javascript:void(0)">系统管理</a>
                	<ul style="display:none;" class="second-menu">
                		<li><a href="javascript:void(0)" class="arrow">消息管理</a>
                			<ul style="display: none;" class="third-menu">
		                       	<li><a href="javascript:void(0)" id="messageSender_md" url="${pageContext.request.contextPath}/message/messageSender/getBrowsePage" class="lastNode">消息发布</a></li>
                        		<li><a href="javascript:void(0)" id="messageReciever_md" url="${pageContext.request.contextPath}/message/messageReciever/getBrowsePage" class="lastNode">消息查阅</a></li>
		                	</ul>
                		</li>
                		<li><a href="javascript:void(0)" url="${pageContext.request.contextPath}/news/newsSender/getBrowsePage" class="lastNode">公告资讯</a></li>
                		<li><a href="javascript:void(0)" class="arrow">安全管理</a>
                			<ul style="display: none;" class="third-menu">
		                       	<li><a href="javascript:void(0)" id="userManage_md" url="${pageContext.request.contextPath}/security/user/getBrowsePage" class="lastNode">用户管理</a></li>
                        		<li><a href="javascript:void(0)" id="roleManage_md" url="${pageContext.request.contextPath}/security/role/getBrowsePage" class="lastNode">角色管理</a></li>
		                		<li><a href="javascript:void(0)" id="authorityManage_md" url="${pageContext.request.contextPath}/security/authority/getBrowsePage" class="lastNode">权限管理</a></li>
                        		<li><a href="javascript:void(0)" id="resourceManage_md" url="${pageContext.request.contextPath}/security/resource/getBrowsePage" class="lastNode">资源管理</a></li>
		                	</ul>
                		</li>
                		<li><a href="javascript:void(0)" id="changePassword_md" url="${pageContext.request.contextPath}/security/user/getChangePasswordPage" class="lastNode">修改密码</a></li>
                	</ul>                	
                </li>
            </ul>
        </div>
        <!-- 导航 end -->
        <!-- 面包屑 start -->
        <div class="route hidden">
        	<span>首页</span><span>&nbsp;»&nbsp;</span><span>经营许可</span><span>&nbsp;»&nbsp;</span><span>国内</span>
        </div>
        <!-- 面包屑 end -->
    </div> --%>
    <!-- header end -->
    	<link type="text/css" rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/scripts/sea-modules/tui/scripts/tuiValidator/tui_validator.css"/>   
    <!-- main end -->
    <link type="text/css" rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/scripts/sea-modules/tui/scripts/tuiDatepicker/jquery_ui.datepicker-modify.css"/>
    <link type="text/css" rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/scripts/sea-modules/tui/scripts/tuiDialog/tui_dialog.css"/>
<%-- 	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/scripts/config/headerConfig.js"></script> --%>