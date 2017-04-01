<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/head.jsp" %>
<title>个人中心-投资机构-信息&投资方-机构用户</title>
<style type="text/css">
a:hover { text-decoration:underline;}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/pages/common/header.jsp" %>

	<div class='cons'>
		<div class='width1200'>
		<jsp:include page="/WEB-INF/pages/common/investorUserLeft.jsp"></jsp:include>
				<!-- 保存失败start -->
	<div class="registSuccess" id="alertClick"></div>
		<!-- version4 点击发布需求弹框start -->
			<div id="altsthree" style="display:none">
				<div class='xuqiualert' style="margin-top:1050px;width:740px;font-size: 24px;text-align:center;color:#434343;min-height:280px;">
					<div class='tits'>
						保存失败
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
								<font id="errorInfo" size="5" color="#349fc4"></font>
						  </div>
					</div>
				</div>
			</div>
			<!-- version4 点击发布需求弹框end -->
			<!-- version3 点击发布需求弹框start -->
			<div id="altstwo" style="display:none">
				<div class='xuqiualert' style="width:309px;margin-top:15px;">
					<div class='tits'>
						保存成功
						<div class='imgs'>
							<img
								src='${pageContext.request.contextPath}/resources/images/front/img/close.png'
								class='img1' /> <img
								src='${pageContext.request.contextPath}/resources/images/front/img/close2.png'
								class='img2' />
						</div>
					</div>
				</div>
			</div>
			<!-- version3 点击发布需求弹框end -->

			 <!-- 保存成功跳转url -->
           <div id="myRecommendUrl" url="${pageContext.request.contextPath}/investorUser/getMyRecommendBrowsePage"></div>
			<!-- 保存成功弹框 statr -->
			<div id="Button1" onclick="ShowDiv('MyDiv','fade')"></div>

			<div id="fade" class="black_overlay"></div>
			<div id="MyDiv" class="white_content" style="margin-top:900px">
				<div style="text-align: right; cursor: default; height: 40px;">
					<!-- <span style="font-size: 16px;" onclick="CloseDiv('MyDiv','fade')">关闭</span> -->
				</div>
				<div style="margin-top:120px;margin-left:300px"><font size="10">恭喜您,保存成功</font></div>
			</div>
			<!-- 保存成功弹框 end -->
			<form id="investorOrganizationForm" method="post" enctype="multipart/form-data">
			<input id="str" name="str" type="hidden" value="" />
			<div class='fl right'>
				<div class='fengmian' style="width:759px;">
					<div class='fl img'>
						<img class="img-circle" style="width:160px;height:120px;" id="companyLogo" src='${pageContext.request.contextPath}/resources/images/front/img/fengmian_img.png'/>
					</div>
					<div class='fl'>
						<div class='titlena'>LOGO</div>
						<div class='remtxt'>图像格式:GIF，JPG，JPEG，PNG。</div>
						<div style="float:left" class='uploadbtn' onclick="$(this).children()[0].click()">上传头像
							<input type='file' name="file" onchange="showPreview(this);" id="companyImgLogo" style='display:none'/>
						</div>
						<div style="float:left;margin-top:25px;" id="imgTypeCheckResult"></div>
						<input type="hidden" value="" id="imgCheckFlag"/>

					</div>
					<div class='clear'></div>
				</div>
				<div class='xuqiu'>
					<div class='name fl'>*公司/机构名称</div>
					<div class='fl'><input type='text' maxlength="30" style="width:755px;" id="name" name="name" value=''/></div>
					<div id="nameCheckResult"></div>
					<div class='clear'></div>
				</div>

				<!-- 省市 start-->
				<div class='xuqiu xuqiu4 xuqiu7'>
				    <input id="province" name="province" type='hidden' value=''/>
					<div class='lis'>
						<div class='name fl'>*所在省/市</div>
						<div class='fl input'>
							<input type='text' style="width:155px;"  value='请选择省份' id="showProvince" readonly/>
							<img src='${pageContext.request.contextPath}/resources/images/front/img/downicon2.png'/>
							<dl id="selectProvince" url="${pageContext.request.contextPath}/basicProvince/queryProvinceCity">
							</dl>
						</div>
						<div id="provinceCheckResult" style="display:inline"></div>
						<div class='clear'></div>
					</div>
					<input id="city" name="city" type='hidden' value=''/>
					<div class='lis' style="margin-left:-30px;">
						<div class='name fl'>*所在市</div>
						<div class='fl input'>
							<input type='text' style="width:155px;"  value='请选择市' id="showCity" readonly/>
							<img src='${pageContext.request.contextPath}/resources/images/front/img/downicon2.png'/>
							<dl id="selectCity" url="${pageContext.request.contextPath}/basicProvince/queryCityCounty">
							</dl>
						</div>
						<div id="cityCheckResult" style="display:inline"></div>
						<div class='clear'></div>
					</div>
					<input id="county" name="county" type='hidden' value=''/>
					<div class='lis'>
						<div class='name fl'>区级</div>
						<div class='fl input'>
							<input type='text' style="width:155px;"  value='请选择县' id="showCounty" readonly/>
							<img src='${pageContext.request.contextPath}/resources/images/front/img/downicon2.png'/>
							<dl id="selectCounty">
							</dl>
						</div>
						<div id="countyCheckResult" style="display:inline"></div>
						<div class='clear'></div>
					</div>
					<div class='clear'></div>
				</div>
				<!-- 省市 end -->

				<div class='xuqiu' style="margin-top:25px;">
					<div class='name fl'>详细地址</div>
					<div class='fl'><input type='text' maxlength="30" style="width:755px;" id="address" name="address" value=''/></div>
					<div class='clear'></div>
				</div>

				<div class='xuqiu xuqiu4 xuqiu8'>
				    <input name="scale" id="scale" type='hidden' value=''/>
					<div class='lis'>
						<div class='name fl'><span>*</span>规模</div>
						<div class='fl input'>
							<input type='text' style="width:755px;" value='请选择规模' id="showScale" readonly/>
							<img src='${pageContext.request.contextPath}/resources/images/front/img/downicon2.png'/>
							<dl id="selectScale">
							    <dd value="0">50人以下</dd>
								<dd value="1">50-100人</dd>
								<dd value="2">100-500人</dd>
								<dd value="3">500人以上</dd>
							</dl>
						</div>
						<div id="checkResult1"></div>
						<div class='clear'></div>
					</div>
					<div class='clear'></div>
				</div>
				<div class='xuqiu xuqiu6'>
					<div class='name fl'>* 投资方式</div>
					<div id="checkBoxInvestType">
					<div class='fl'>
						<div class='fl txts'>
							<input id="investTypeCheckBox0" class='checkbox fl' type='checkbox'>
							<div class='fl s'><input type="hidden" value="0" id="investTypeCheckBoxValue0"/>股权投资</div>
							<div class='clear'></div>
						</div>
						<div class='fl txts'>
							<input id="investTypeCheckBox1" class='checkbox fl' type='checkbox'>
							<div class='fl s'><input type="hidden" value="1" id="investTypeCheckBoxValue1"/>债券投资</div>
							<div class='clear'></div>
						</div>
						<div class='fl txts'>
							<input id="investTypeCheckBox2" class='checkbox fl' type='checkbox'>
							<div class='fl s'><input type="hidden" value="2" id="investTypeCheckBoxValue2"/>金融投资</div>
							<div class='clear'></div>
						</div>
						<div class='fl txts'>
							<input id="investTypeCheckBox3" class='checkbox fl' type='checkbox'>
							<div class='fl s'><input type="hidden" value="3" id="investTypeCheckBoxValue3"/>bt/bot项目投资</div>
							<div class='clear'></div>
						</div>
						<div class='fl txts'>
							<input id="investTypeCheckBox4" class='checkbox fl' type='checkbox'>
							<div class='fl s'><input type="hidden" value="4" id="investTypeCheckBoxValue4"/>其他投资</div>
							<div class='clear'></div>
						</div>
						<div style="float:left;margin-top:9px;" id="checkResult2"></div>
						<input type="hidden" id="investTypeId"/>
						<div class='clear'></div>
					</div>
					</div>
					<div class='clear'></div>
				</div>

				<div class='xuqiu xuqiu4'>
					<div class='lis'>
						<div class='name fl'>*联系人</div>
						<div class='fl input'>
							<input type='text' maxlength="10" style="width:300px;" id="contactName" name="contactName" value=''/>
						</div>
						<div id="contactNameResult" style="display:inline"></div>
						<div class='clear'></div>
					</div>
					<div class='lis'>
						<div class='name fl'>*联系方式</div>
						<div class='fl input'>
							<input type='text' maxlength="10" style="width:300px;" id="contactTel" name="contactTel" value=''/>
						</div>
						<div id="contactTelResult" style="display:inline"></div>
						<div class='clear'></div>
					</div>
					<div class='clear'></div>
				</div>
				<div class='xuqiu'>
					<div class='name fl'>职务</div>
					<div class='fl'><input type='text' maxlength="30" style="width:755px;" id="contactTitle" name="contactTitle" value=''/></div>
					<div class='clear'></div>
				</div>

				<div class='xuqiu xuqiu3'>
					<div class='name fl'>公司/机构简介</div>
					<div class='fl'>
						<textarea name="introduction" maxlength="500" style="width:755px;" id="introduction"></textarea>
					</div>
					<div class='clear'></div>
				</div>

				<!-- 投资意向start -->
				<div>
					<div  style="margin-left:132px;margin-top:20px;margin-bottom:10px;">&nbsp;&nbsp;&nbsp;&nbsp;<font size="2" color="#666">投资意向若未填写，则意味着您的投资没有任何限制。</font></div>
					<div class='clear'></div>
				</div>

				<div class='xuqiu' style='margin-top: 0px' id="investDomainCheckBox">
					<div class='name fl'>投资领域</div>
					<div class='fl txts'>
						<div class='fl s'>
							<a href="javascript:;" id="investDomainselectAll"><font color="#349fc4">全部选中</font></a>
						</div>
						<div class='clear'></div>
					</div>
					<div id="investDomainCheckBoxUrl"
						url="${pageContext.request.contextPath}/basicResearchField/query">
					</div>
					<div class='clear'></div>
				</div>

				<div class='xuqiu'style='margin-top:0px' id="investAmountCheckBox">
					<div class='name fl'>投资额</div>
						<div class='fl txts'>
							<div class='fl s'>
								<a href="javascript:;" id="investAmountselectAll"><font color="#349fc4">全部选中</font></a>
							</div>
							<div class='clear'></div>
						</div>
						<div class='fl txts'>
						    <div class='fl s'>100万以下</div>
							<input id="investAmount0" value="0" name="investAmount" class='checkbox fl' type='checkbox'>
							<div class='clear'></div>
						</div>
						<div class='fl txts'>
						    <div class='fl s'>100-500万</div>
							<input id="investAmount1" value="1" name="investAmount" class='checkbox fl' type='checkbox'>
							<div class='clear'></div>
						</div>
						<div class='fl txts'>
						    <div class='fl s'>500万-1000万</div>
							<input id="investAmount2" name="investAmount" value="2" class='checkbox fl' type='checkbox'>
							<div class='clear'></div>
						</div>
						<div class='fl txts'>
						    <div class='fl s'>1000万以上</div>
							<input id="investAmount3" name="investAmount" value="3" class='checkbox fl' type='checkbox'>
							<div class='clear'></div>
						</div>
						<div class='fl txts'>
						    <div class='fl s'>面议</div>
							<input id="investAmount4" name="investAmount" value="4" class='checkbox fl' type='checkbox'>
							<div class='clear'></div>
						</div>
						<div class='clear'></div>
				</div>
				<div class='xuqiu'style='margin-top:0px' id="investPhaseCheckBox">
					<div class='name fl'>阶段</div>
						<div class='fl txts'>
							<div class='fl s'>
								<a href="javascript:;" id="investPhaselectAll"><font color="#349fc4">全部选中</font></a>
							</div>
							<div class='clear'></div>
						</div>
						<div class='fl txts'>
						    <div class='fl s'>研发阶段</div>
							<input id="investPhase0" value="0" name="investPhase" class='checkbox fl' type='checkbox'>
							<div class='clear'></div>
						</div>
						<div class='fl txts'>
						    <div class='fl s'>实验室阶段</div>
							<input id="investPhase1" value="1" name="investPhase"  class='checkbox fl' type='checkbox'>
							<div class='clear'></div>
						</div>
						<div class='fl txts'>
						    <div class='fl s'>概念阶段</div>
							<input id="investPhase2" value="2" name="investPhase"  class='checkbox fl' type='checkbox'>
							<div class='clear'></div>
						</div>
						<div class='fl txts'>
						    <div class='fl s'>小批量生产</div>
							<input id="investPhase3" value="3" name="investPhase" class='checkbox fl' type='checkbox'>
							<div class='clear'></div>
						</div>
						<div class='fl txts'>
						    <div class='fl s'>规模化生产阶段</div>
							<input id="investPhase4" name="investPhase"  value="4" class='checkbox fl' type='checkbox'>
							<div class='clear'></div>
						</div>
						<div class='fl txts'>
						    <div class='fl s'>市场推广阶段</div>
							<input id="investPhase5" name="investPhase" value="5"  class='checkbox fl' type='checkbox'>
							<div class='clear'></div>
						</div>
						<div class='clear'></div>
				</div>
				<!-- 投资意向end -->
				<div class='xuqiu xuqiu3'>
					<div class='name fl'>投资概述</div>
					<div class='fl'>
						<textarea name="investOutline" id="investOutline"></textarea>
					</div>
					<div class='clear'></div>
				</div>
				<div class='xuqiu xuqiu5'>
					<div class='name fl'>材料补充</div>
					<!-- <div class='fl input'>
						<input type='text' readonly/>
						<div class='bgs'></div>
						<div class='bgtxt' id='fileName'>选择要上传附件</div>
					</div> -->
					<input type="hidden" id="filePath"/>
					<div style="margin-left:35px;" class='fl' onclick="$(this).children()[1].click()">
						<div style="margin-left:-35px;"class='uploadFilebtn'>上传附件</div>
						<input type='file' name="file" id="companyFile" style='display:none'/>
					</div>
					<div class='fl txt'>大小限制：5M &nbsp;&nbsp;&nbsp;&nbsp;</div> <div style='margin-top:10px;' id="fileTypeCheckResult"></div>
					<div class='clear'></div>
				</div>
				<input type="hidden" value="" id="fileCheckFlag"/>
				<!-- <div class='xuqiu xuqiu6'>
					<div class='name fl'></div>
					<div class='fl ris' style='margin-left:118px'>
						<input class='btn fl' type='checkbox'>
						<div class='txt fl'>我承诺以上企业信息属实＊</div>
						<div class='clear'></div>
					</div>
					<div class='clear'></div>
				</div> -->
				<div class='commitbtns' saveUrl="${pageContext.request.contextPath}/investorUser/add" id="saveBtn">提交</div>
			   <div detailUrl="${pageContext.request.contextPath}/investorUser/getDetail" id="getDetailUrl"></div>
				<div updateUrl="${pageContext.request.contextPath}/investorUser/update" id="updateUrl"></div>

			</div>
			</form>
			<div class='clear'></div>
		</div>
	</div>
	<%@ include file="/WEB-INF/pages/common/footer.jsp" %>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/front/investorUser/investorOrganizationUserDetail.js"></script>
</body>
<script type="text/javascript">

$(document).ready(function() {
	$('#companyFile').change(function() {
		 //文件大小限制
		   var dom = document.getElementById("companyFile");
		   var fileSize = dom.files[0].size;
		   var size=fileSize/(1024*1024); //单位M
		   if(size>5){
			  // $("#fileCheckFlag").val("0");
			   $("#companyFile").val("");
			   $("#fileTypeCheckResult").html('<font color="red">上传文件超过5M,请重新上传。</font>');
			   $('#fileName').html("选择要上传附件");
			   return false;
		   }else{
			   $("#fileCheckFlag").val("");
			   $("#fileTypeCheckResult").html("");
		   }
		$('#fileTypeCheckResult').html("已上传文件:"+$(this).val());
	});

	$(".molist").slideUp(0);
	$("#mores").click(function(){
		if($(this).hasClass('SM')){
			$(this).removeClass("SM");
			$(this).text("更多>>");
			$(".molist").slideUp(100);
		}else{
			$(this).addClass("SM");
			$(this).text("收起");
			$(".molist").slideDown(100);
		}
	})

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
});
</script>
</html>
