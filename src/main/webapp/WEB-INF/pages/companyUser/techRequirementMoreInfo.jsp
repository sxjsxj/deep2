<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/head.jsp" %>
<title>技术需求更多信息</title>
</head>
<body>
<%@ include file="/WEB-INF/pages/common/header.jsp" %>
<%@ include file="/WEB-INF/pages/common/dialog.jsp" %>

	<div class='cons'>
	<input type="hidden" id="detailId" value="${id}"/>
	<input type="hidden" id="cooperateFlag" value=""/>
	<input type="hidden" id="collectFlag" value=""/>
	<input type="hidden" id="requireId" value=""/>
	<input type="hidden" id="userId" value=""/>
	  <!-- 寻求合作弹框start -->
	<input id="opeationIdIndex" type="hidden" value=""></input>
	    <div id="techRequirementDetail" url="${pageContext.request.contextPath}/techRequirement/getDetail"></div>
		<div id="addFollowerUrl" url="${pageContext.request.contextPath}/techRequirementFollower/add"></div>
        <div id="cancelFollowerUrl" url="${pageContext.request.contextPath}/techRequirementFollower/delete"></div>
		<div id="loginUrl" url="${pageContext.request.contextPath}/security/loginPage"></div>
		<div class='width1200'>
			<div class='fl delleft'>
				<div class='heads'>
				<div class='tils' id="name"></div>
				<div class='stils'>
					<a id="sequenceNumber"></a>
					<a id="domain"></a>
					<a id="status"></a>
				</div>
				<div class='stils'>
					<a id="scanNumber"></a><img src='${pageContext.request.contextPath}/resources/images/front/img/address.png'/>&nbsp;<a id="province"></a>
				</div>
				<!-- <div class='mortis'><span></span></div> -->
				<div style="margin-left:342px;" class='btns'>
					<div style='margin-right: 20px;font-size:15px;'  id="collect">收藏</div>
					<div style='margin-right:20px;font-size:15px;' id="cancelCollect">取消收藏</div>
					<div style="font-size:15px;" id="cooperate" class="detail">寻求合作</div>
				</div>
				<div style="margin-left:382px;margin-top:-40px;" class="bdsharebuttonbox">
					<a href="#" class="bds_more" data-cmd="more"></a><a href="#"
						class="bds_qzone" data-cmd="qzone"></a><a href="#"
						class="bds_tsina" data-cmd="tsina"></a><a href="#" class="bds_tqq"
						data-cmd="tqq"></a><a href="#" class="bds_renren"
						data-cmd="renren"></a><a href="#" class="bds_weixin"
						data-cmd="weixin"></a>
				</div>
					<div class='clear'></div>
				</div>
				<div class='title'>基本情况</div>
				<div class='txt' id="address"></div>
				<div class='txt' id="domain2"></div>
				<div class='txt' id="amount"></div>
				<div class='txt' id="type"></div>
				<div class='txt' id="duration"></div>
				<div class='txt' id="cooperationType"></div>

				
				<div class='title' style='margin-top:30px'>需求描述</div>
				<div class='txt' id="detail"></div>

				<div id='mores'>
					<div class='title' style='margin-top:30px' id="similarProductTitle">市场类似产品情况</div>
					<div class='txt' id="similarProduct"></div>
				</div>
				<div class='more'>查看更多信息>></div>
			</div>
			<div class='fr'>
				<img src='${pageContext.request.contextPath}/resources/images/front/img/fr_bg3.png'/>
			</div>
			<div class='clear'>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/pages/common/footer.jsp" %>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/front/companyUser/techRequirementMoreInfo.js"></script>
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
	$(".more").click(function(){
		if($(this).hasClass('on')){
			$(this).removeClass("on");
			$("#mores").slideUp(100);
			$(this).text('查看更多信息>>');
		}else{
			$(this).addClass("on");
			$(this).text('收起');
			$("#mores").slideDown(100);
		}
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
