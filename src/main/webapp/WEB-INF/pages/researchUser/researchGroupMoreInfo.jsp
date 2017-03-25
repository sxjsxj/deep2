<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/head.jsp" %>
<title>科研团队更多信息</title>
</head>
<body>
	<%@ include file="/WEB-INF/pages/common/header.jsp" %>
	<%@ include file="/WEB-INF/pages/common/dialog.jsp" %>

	<div class='cons'>
	    <input type="hidden" id="detailId" value="${id}"/>
	    <input type="hidden" id="cooperateFlag" value=""/>
	    <input type="hidden" id="collectFlag" value=""/>
	    <input type="hidden" id="researchId" value=""/>
	    <input type="hidden" id="userId" value=""/>
	    <div id="researchGroupDetail" url="${pageContext.request.contextPath}/researchGroup/getDetail"></div>
	    <div id="addFollowerUrl" url="${pageContext.request.contextPath}/researchGroupFollower/add"></div>
		<div id="cancelFollowerUrl" url="${pageContext.request.contextPath}/researchGroupFollower/delete"></div>
		<div id="researchGroupMoreInfo" url="${pageContext.request.contextPath}/researchGroup/getMoreInfoPage"></div>
		<div id="loginUrl" url="${pageContext.request.contextPath}/security/loginPage"></div>
		<div class='width1200'>
			<div class='fl delleft'>
				<div class='heads'>
					<div class='fl img'>
						<img id="detailImg" data-tag="sharePhoto" style="width:320px;height:240px" src=''/>
					</div>
					<div class='fl rightmore'>
						<div class='tils' id="name"></div>
						<div class='txts' id="domain"></div>
						<div class='txts'></div>
						<div class='stils' style='margin-top:17px'>
							<a id="domain2"></a><img src='${pageContext.request.contextPath}/resources/images/front/img/address.png'/>&nbsp;<a id="provinceName"></a><a id="scanNumber"></a>
						</div>
						<%-- <div class='mortis'><span></span></div> --%>
						<div style="margin-top:17px;" class='btns' >
							<div style='margin-right:20px;font-size:15px;' id="collect">收藏</div>
							<div style='margin-right:20px;font-size:15px;' id="cancelCollect">取消收藏</div>
							<div style="font-size:15px;" id="cooperate" class="detail">寻求合作</div>
						</div>
						<!-- 分享控件start -->
						<div style="margin-top:5px;" class="bdsharebuttonbox">
							<a href="#" class="bds_more" data-cmd="more"></a><a href="#"
								class="bds_qzone" data-cmd="qzone"></a><a href="#"
								class="bds_tsina" data-cmd="tsina"></a><a href="#"
								class="bds_tqq" data-cmd="tqq"></a><a href="#"
								class="bds_renren" data-cmd="renren"></a><a href="#"
								class="bds_weixin" data-cmd="weixin"></a>
						</div>
						<!-- 分享控件end -->
					</div>
					<div class='clear'></div>
				</div>
				<div class='title'>基本情况</div>
				<div class='txt' id="uniOrgName">所在单位：</div>
				<div class='txt' id="uniOrgDepart">主管部门：</div>
				<div class='title' id="introductionTitle" style='margin-top:30px'>团队介绍</div>
				<div class='txt' id="introduction"></div>

				<div class='title' style='margin-top:30px'>研究方向</div>
				<div class='txt' id="field"></div>

				<div class='title' id="achievementTitle" style='margin-top:30px'>研究成果</div>
				<div class='txt' id="achievement"></div>

				<div class='title' id="teamSizeTitle" style='margin-top:30px'>团队人数</div>
				<div class='txt' id="teamSize"></div>

				<div class='title' id="leaderInfoTitle" style='margin-top:30px'>负责人信息</div>
				<div class='txt' id="leaderInfo"></div>

				<%-- <div id='mores'> --%>
					<div class='title' id="leaderAchieveTitle" style='margin-top:30px'>主要成就</div>
					<div class='txt2' id="leaderAchieve"></div>
				<%-- </div> --%>
				<%-- <div class='more'>查看更多信息>></div> --%>
			</div>
			<div class='fr'>
				<img src='${pageContext.request.contextPath}/resources/images/front/img/fr_bg3.png'/>
			</div>
			<div class='clear'>

			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/pages/common/footer.jsp" %>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/front/researchUser/researchGroupMoreInfo.js"></script>
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
})
</script>
<script>
	window._bd_share_config = {
		"common" : {
			"bdSnsKey" : {},
			"bdText" : "",
			"bdMini" : "2",
			"bdPic" : "",
			"bdStyle" : "0",
			"bdSize" : "16"
		},
		"share" : {},
		"image" : {
			"viewList" : [ "qzone", "tsina", "tqq", "renren", "weixin" ],
			"viewText" : "分享到：",
			"viewSize" : "16",
			"tag" : "sharePhoto",
		},
		"selectShare" : {
			"bdContainerClass" : null,
			"bdSelectMiniList" : [ "qzone", "tsina", "tqq", "renren", "weixin" ]
		}
	};
	with (document)
		0[(getElementsByTagName('head')[0] || body)
				.appendChild(createElement('script')).src = 'http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='
				+ ~(-new Date() / 36e5)];
</script>
</html>
