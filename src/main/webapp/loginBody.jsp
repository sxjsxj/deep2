<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>AirTIS航空价格信息系统</title>
    <% request.setCharacterEncoding("UTF-8"); %>
    <% response.setCharacterEncoding("UTF-8"); %>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/scripts/sea-modules/tui/css/tui_global.css"/>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/scripts/sea-modules/tui/css/tui_content.css"/>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/global.css"/>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/scripts/sea-modules/seajs/seajs/2.1.1/sea.js" id="seajsnode"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/scripts/config/globalConfig.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/scripts/config/loginConfig.js"></script>
</head>
<body>
	<input id="sessionError" type="hidden" value="SESSION_TIME_OUT_FAIL"></input>
	<input type="hidden" id="errorFlag" value="${flag }" />
	<input type="hidden" id="getRandomString" value="${pageContext.request.contextPath}/util/getRandomString" />
	<input type="hidden" id="imageURL" value="${pageContext.request.contextPath}/util/getImage" />
	<input type="hidden" id="imageCode" value=<%=session.getAttribute("checkCode") %> />
	
	<!-- userInfo start -->
	<div class="userInfoLayout">
        <div class="userInfo">
            <div class="right">
                <!-- <span><a href="">登录</a></span><span>|</span><span><a href="">我的消息</a></span><span>|</span> -->
                <span><a href="${pageContext.request.contextPath}/security/loginPage">首页</a></span>
                <span>|</span>
                <span><a href="http://www.caac.gov.cn/E1/">服务大厅</a></span>
                <span>|</span>
                <span><a href="${pageContext.request.contextPath}/resources/pagesOnFront/helpAtLoginPage.html">帮助</a></span>
                <div class="clear"></div>
            </div>
            <div class="clear"></div>
        </div>
    </div>
    <!-- userInfo end -->
    
    <!-- logo start -->
    <div class="logoPartLayout">
        <div class="logo left"><img src="${pageContext.request.contextPath}/resources/images/logo1.jpg" title="航班计划管理信息系统" /></div>
        <div class="right" style="margin-top:45px;"><img src="${pageContext.request.contextPath}/resources/images/logo3.jpg" title="中国民航总局" /></div>
        <div class="clear"></div>
    </div>
    <!-- logo end -->
    
    <!-- banner start -->
    <div class="bannerLayout">
    	<ul style="overflow:hidden; text-align:center;">
        	<li><img src="${pageContext.request.contextPath}/resources/images/img-banner01.jpg" height="100%" /></li>
        </ul>
    </div>
    <!-- banner end -->
    <form id="loginForm" action="${pageContext.request.contextPath}/security/login" method="POST">
    <!-- login start -->
    <div class="loginLayout">
	    <div class="loginOutterLayout">
	    	<div class="loginInner">
	    	<div class="loginTips red textCenter bold" id="tips">&nbsp;</div>
	        	<div class="eachLoginInput">
	            	<span class="left width60 textRight">用户名</span>
	                <div class="left">
	                	<input type="text" class="width150 inputNormal" id="j_username" name="j_username" placeholder="请输入用户名" autocomplete="off" />
	                </div>
	                <div class="clear"></div>
	            </div>
	            <div class="eachLoginInput">
	            	<span class="left width60 textRight">密&nbsp;&nbsp;&nbsp;&nbsp;码</span>
	                <div class="left">
	                	<input type="password" class="width150 inputNormal" id="j_password" name="j_password" placeholder="请输入密码" autocomplete="off"/>
	                </div>
	                <div class="clear"></div>
	            </div>
	            <div class="eachLoginInput">
	            	<span class="left width60 textRight">验证码</span>
	                <div class="left">
	                	<input type="text" class="width70 inputNormal" id="inputCode"/>
	                </div>
	                <div class="left">&nbsp;<img id="checkImage" src="" /></div>
	                <div class="clear"></div>
	            </div>
	            <div class="eachLoginInput">
	            	<div class="loginButton" id="loginBtn">登&nbsp;&nbsp;&nbsp;录</div>
	                <div class="clear"></div>
	            </div>
	        </div>        
	    </div>
    </div>
    <!-- login end -->
    </form>
    <div class="homeTextLayout">
     
    <!-- news start -->
    <div class="newsLayout">
    	<div class="left homeBlockLayout">
            <h1><img src="${pageContext.request.contextPath}/resources/images/title-official.png" title="政务公开" /></h1>
            <div class="blockList">
                <a href="${pageContext.request.contextPath}/resources/pagesOnFront/officialPageOne.html" target="_blank">关于扩大中国东方航空武汉有限责任公司经营范围的公示</a>
                <a href="${pageContext.request.contextPath}/resources/pagesOnFront/officialPageTwo.html" target="_blank">关于拟批准多彩贵州航空有限公司筹建的公示</a>
                <a href="${pageContext.request.contextPath}/resources/pagesOnFront/officialPageThree.html" target="_blank">中央第十二巡视组联系方式</a>
                <a href="${pageContext.request.contextPath}/resources/pagesOnFront/officialPageFour.html" target="_blank">关于中国南方航空股份有限公司申请开通广州-迪拜-开罗往返客运航线的公示</a>
                <a href="${pageContext.request.contextPath}/resources/pagesOnFront/officialPageFive.html" target="_blank">关于北京首都航空有限公司申请开通北京-马累往返客运航线的公示</a>
                <div class="clear"></div>
            </div>
        </div>
        <div class="right homeBlockLayout">
            <h1><img src="${pageContext.request.contextPath}/resources/images/title-news.png" title="新闻资讯" /></h1>
            <div class="blockList">
                <a href="${pageContext.request.contextPath}/resources/pagesOnFront/newsPageOne.html" target="_blank">中国民航网络电视正式开播</a>
                <a href="${pageContext.request.contextPath}/resources/pagesOnFront/newsPageTwo.html" target="_blank">民航局通报表彰深圳航空ZH9648航班机组</a>
                <a href="${pageContext.request.contextPath}/resources/pagesOnFront/newsPageThree.html" target="_blank">以成都新机场建设为契机 打造四川经济新增长极</a>
                <a href="${pageContext.request.contextPath}/resources/pagesOnFront/newsPageFour.html" target="_blank">国际民航组织考虑禁止托运电子香烟</a>
                <a href="${pageContext.request.contextPath}/resources/pagesOnFront/newsPageFive.html" target="_blank">空管办组织参加ICAO亚太地区通信导航监视分组会议</a>
                <div class="clear"></div>
            </div>
        </div>
        <div class="clear"></div>
    </div>    
    <!-- news end -->
    
    <!-- manager start -->
    <div class="linksLayout hidden">
    	<h1><img src="${pageContext.request.contextPath}/resources/images/title-manager.png" title="管理局" /></h1>
        <div class="linksInner">
        	<a href="javascript:void(0)">中国民用航空局</a>
            <a href="javascript:void(0)">华北地区管理局</a>
            <a href="javascript:void(0)">东北地区管理局</a>
            <a href="javascript:void(0)">华东地区管理局</a>
            <a href="javascript:void(0)">中南地区管理局</a>
            <a href="javascript:void(0)">西南地区管理局</a>
            <a href="javascript:void(0)">西北地区管理局</a>
            <a href="javascript:void(0)">新疆管理局</a>
            <div class="clear"></div>
        </div>
    </div>
    <!-- manager end -->
    
    </div>
    
    <!-- footer start -->
    <div class="homeFooterLayout">
    	<div class="footerInner">
        	<div class="left"><img src="${pageContext.request.contextPath}/resources/images/logo-caac.jpg" /></div>
            <div class="left homeFooterp" style="width:300px; margin-left:150px;">
            	<p>地址：北京市东城区东四西大街155号(100710)</p>
            	<p>版权所有：中国民用航空局</p>
                <p>网站管理：中国民航局运输司</p>
                <p class="hidden">ICP备案编号：京ICP备05034131</p>
            </div>
            <div class="left homeFooterp hidden">
            	<p>地址：北京市东城区东四西大街155号(100710)</p>
                <p class="hidden">中文域名：中国民用航空局.政务</p>
                <p class="hidden">纠错及联系我们</p>
            </div>
            <div class="right"><img src="${pageContext.request.contextPath}/resources/images/icon-party.jpg" /></div>
            <div class="clear"></div>
        </div>
    </div>
    <!-- footer end -->
</body>
</html>
