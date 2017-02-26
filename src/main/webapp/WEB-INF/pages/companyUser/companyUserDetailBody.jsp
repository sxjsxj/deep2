<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/head.jsp" %>
<title>个人中心-企业-企业信息</title>
</head>
<body>
	<%@ include file="/WEB-INF/pages/common/header.jsp" %>

	<div class='cons'>
		<div class='width1200'>
		<jsp:include page="/WEB-INF/pages/common/companyUserLeft.jsp"></jsp:include>

			<!-- 保存成功弹框 statr -->
			<div id="Button1" onclick="ShowDiv('MyDiv','fade')"></div>
			<div id="fade" class="black_overlay"></div>
			<div id="MyDiv" class="white_content" style="margin-top:200px">
				<div style="text-align: right; cursor: default; height: 40px;">
					<!-- <span style="font-size: 16px;" onclick="CloseDiv('MyDiv','fade')">关闭</span> -->
				</div>
				<div style="margin-top:120px;margin-left:300px">
					<%-- <font size="5">恭喜您,保存成功!</font>
					<br />
					<font size="5">现在您可以发布您的需求&nbsp;&nbsp;</font>
					<font size="5" color="blue"><a href="#" id="publishMyRequirement">现在就去发布我的需求</a></font>
					<br />
					<font size="5">您还可以&nbsp;&nbsp;</font>
                    <font size="5" color="blue">
                    <a href="${pageContext.request.contextPath}/companyUser/getMyRecommendAchievementBrowsePage">暂不发布</a>
                    </font> --%>
						<font size="5" color="#349fc4">恭喜您,保存成功</font>
						<br />
						<div>
							<font size="4" color="#349fc4">
							  <a href="javascript:;" id="publishMyRequirement">现在就去发布我的需求>> </a>
							</font>
							 <br />
							 <br />
                            <font size="4" color="#349fc4"> <a
								href="${pageContext.request.contextPath}/companyUser/getMyRecommendAchievementBrowsePage">暂不发布>>
							</a>
							</font>
						</div>
					</div>
				</div>
			</div>
			<!-- 保存成功弹框 end -->

            <!--发布需求弹框start  -->
			<div id="alts" style="display:none">
				<div class='xuqiualert' style="min-height:550px;">
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
								<div class='f'>我有项目寻求资金</div>
							</div>
						</li>
					</ul>
				</div>
			</div>
           <!--发布需求弹框end  -->

           	<!-- 保存失败start -->
	<div class="registSuccess" id="alertClick"></div>
		<!-- version4 点击发布需求弹框start -->
			<div id="altsthree" style="display:none">
				<div class='xuqiualert' style="margin-top:1px;width:740px;font-size: 24px;text-align:center;color:#434343;min-height:260px;">
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
				<div class='xuqiualert' style="margin-top:1px;width:740px;font-size: 24px;text-align:center;color:#434343;min-height:260px;">
					<div class='tits'>
						<font size="5" color="#349fc4">恭喜您,保存成功</font>
						<%-- <div class='imgs'>
							<img
								src='${pageContext.request.contextPath}/resources/images/front/img/close.png'
								class='img1' /> <img
								src='${pageContext.request.contextPath}/resources/images/front/img/close2.png'
								class='img2' />
						</div> --%>
					</div>
					<div>
						<div>
							<font size="4" color="#349fc4">
							  <a href="#" id="publishMyRequirementnew">现在就去发布我的需求>> </a>
							</font>
							 <br />
							 <br />
                            <font size="4" color="#349fc4"> <a
								href="${pageContext.request.contextPath}/companyUser/getMyRecommendAchievementBrowsePage">暂不发布>>
							</a>
							</font>
						</div>
					</div>
				</div>
			</div>
			<!-- version3 点击发布需求弹框end -->
			<form id="companyUserForm" method="post" enctype="multipart/form-data">
			<input id="str" name="str" type="hidden" value="" />
			<div style="margin-left:-30px;" class='fl right'>
			  <input type="hidden" id="imgPath"/>
				<div class='fengmian' style="width:755px;">
					<div class='fl img'>
						<img class="img-circle" style="width:160px;height:120px;" id="companyLogo" src='${pageContext.request.contextPath}/resources/images/front/img/fengmian_img.png'/>
					</div>
					<div class='fl'>
						<div class='titlena'>企业LOGO</div>
						<div class='remtxt'>图像格式:GIF,JPG,JPEG,PNG 尺寸要求:200*200像素。</div>
						<div style="float:left" class='uploadbtn' onclick="$(this).children()[0].click()">上传图片
							<input type='file' name="file" onchange="showPreview(this);" id="companyImgLogo" style='display:none'/>
						</div>
						<div style="float:left;margin-top:25px;" id="imgTypeCheckResult"></div>
						<input type="hidden" value="" id="imgCheckFlag"/>
					</div>
					<div class='clear'></div>
				</div>
				<div class='xuqiu'>
					<div class='name fl'><span>*</span>公司名称</div>
					<div class='fl'><input type='text' style="width:755px;" id="name" name="name" maxlength="30" value=''/></div>
					<div class='clear'></div>
				</div>
				<div class='xuqiu xuqiu4'>

				    <input name="domain" id="domain" type='hidden' value=''/>
					<div class='lis'>
						<div class='name fl'><span>*</span>所属行业</div>
						<div class='fl input'>
							<input type='text' style="width:250px;" value='请选择行业' style="width:250px;" id="showDomain" readonly/>
							<img src='${pageContext.request.contextPath}/resources/images/front/img/downicon2.png'/>
							<dl id="selectDomain" url="${pageContext.request.contextPath}/basicResearchField/query">
							</dl>
						</div>
						<div id="domainCheckResult" style="display:inline"></div>
						<div class='clear'></div>
					</div>

					<input id="nature" name="nature" type='hidden' value=''/>
					<div class='lis'>
						<div class='name fl'>*公司性质</div>
						<div class='fl input'>
							<input type='text' style="width:300px;" value='请选择公司性质' id="showNature" readonly/>
							<img src='${pageContext.request.contextPath}/resources/images/front/img/downicon2.png'/>
							<dl id="selectNature">
								<dd value="0">国有企业</dd>
								<dd value="1">民营独资</dd>
								<dd value="2">外企独资</dd>
								<dd value="3">中外合资</dd>
								<dd value="4">其他</dd>
							</dl>
						</div>
						<div id="natureCheckResult" style="display:inline"></div>
						<div class='clear'></div>
					</div>
					<div class='clear'></div>
				</div>

				<div class='xuqiu xuqiu4'>
				    <input id="scale" name="scale" type='hidden' value=''/>
					<div class='lis'>
						<div class='name fl'>*规模</div>
						<div class='fl input'>
							<input type='text' style="width:250px;" value='请选择规模' id="showScale" readonly/>
							<img src='${pageContext.request.contextPath}/resources/images/front/img/downicon2.png'/>
							<dl id="selectScale">
								<dd value="0">50人以下</dd>
								<dd value="1">50-100人</dd>
								<dd value="2">100-500人</dd>
								<dd value="3">500-1000人</dd>
								<dd value="4">1000-2000人</dd>
								<dd value="5">2000-5000人</dd>
								<dd value="6">5000人以上</dd>
							</dl>
						</div>
						<div id="scaleCheckResult" style="display:inline"></div>
						<div class='clear'></div>
					</div>
					<input id="productValue" name="productValue" type='hidden' value=''/>
					<div class='lis'>
						<div class='name fl'>*产值</div>
						<div class='fl input'>
							<input type='text' style="width:300px;" value='请选择产值' id="showProductValue" readonly/>
							<img src='${pageContext.request.contextPath}/resources/images/front/img/downicon2.png'/>
							<dl id="selectProductValue">
								<dd value="0">0-100万</dd>
							    <dd value="1">100-500万</dd>
							    <dd value="2">500-1000万</dd>
							    <dd value="3">1000-5000万</dd>
							    <dd value="4">5000万以上</dd>
							</dl>
						</div>
						<div id="productValueCheckResult" style="display:inline"></div>
						<div class='clear'></div>
					</div>
					<div class='clear'></div>
				</div>

				<!-- 省市 start-->
				<div class='xuqiu xuqiu4 xuqiu7'>
				    <input id="province" name="province" type='hidden' value=''/>
					<div class='lis'>
						<div class='name fl'>*所在省/市</div>
						<div class='fl input'>
							<input type='text' style="width:130px;" value='请选择省份' id="showProvince" readonly/>
							<img src='${pageContext.request.contextPath}/resources/images/front/img/downicon2.png'/>
							<dl id="selectProvince" url="${pageContext.request.contextPath}/basicProvince/queryProvinceCity">
							</dl>
						</div>
						<div id="provinceCheckResult" style="display:inline"></div>
						<div class='clear'></div>
					</div>
					<input id="city" name="city" type='hidden' value=''/>
					<div class='lis'>
						<div class='name fl'>*所在市</div>
						<div class='fl input'>
							<input type='text' style="width:130px;" value='请选择市' id="showCity" readonly/>
							<img src='${pageContext.request.contextPath}/resources/images/front/img/downicon2.png'/>
							<dl id="selectCity" url="${pageContext.request.contextPath}/basicProvince/queryCityCounty">
							</dl>
						</div>
						<div id="cityCheckResult" style="display:inline"></div>
						<div class='clear'></div>
					</div>
					<input id="county" name="county" type='hidden' value=''/>
					<div class='lis'>
						<div class='name fl'>*区级</div>
						<div class='fl input'>
							<input type='text' style="width:130px;" value='请选择县' id="showCounty" readonly/>
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
				<div class='xuqiu' style="margin-top:23px;">
					<div class='name fl'>详细地址</div>
					<div class='fl'><input type='text' style="width:755px;" maxlength="50" id="address" name="address"value=''/></div>
					<div class='clear'></div>
				</div>

				<div class='xuqiu xuqiu4'>
					<div class='lis'>
						<div class='name fl'>*联系人</div>
						<div class='fl input'>
							<input type='text'  style="width:280px;" maxlength="10" id="contactName" name="contactName" value=''/>
						</div>
						<div id="contactNameResult" style="display:inline"></div>
						<div class='clear'></div>
					</div>
					<div class='lis'>
						<div class='name fl'>*联系方式</div>
						<div class='fl input'>
							<input type='text' style="width:300px;"  maxlength="25"  id="contactTel" name="contactTel" value=''/>
						</div>
						<div id="contactTelResult" style="display:inline"></div>
						<div class='clear'></div>
					</div>
					<div class='clear'></div>
				</div>
				<div class='xuqiu'>
					<div class='name fl'>职务</div>
					<div class='fl'><input type='text' style="width:755px;" maxlength="20"  id="contactTitle" name="contactTitle" value=''/></div>
					<div class='clear'></div>
				</div>

				<div class='xuqiu xuqiu3'>
					<div class='name fl'>公司简介</div>
					<div class='fl'>
						<textarea name="introduction" style="width:755px;" maxlength="500"  id="introduction"></textarea>
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
					<div style="margin-left:-35px;" class='fl' onclick="$(this).children()[1].click()">
						<div class='uploadFilebtn'>上传附件</div>
						<input type='file' name="file" id="companyFile" style='display:none'/>
					</div>
					<div class='fl txt'>大小限制：5M &nbsp;&nbsp;&nbsp;&nbsp;</div><div style='margin-top:10px;' id="fileTypeCheckResult"></div>
					<div class='clear'></div>
				</div>
				<input type="hidden" value="" id="fileCheckFlag"/>
				<div class='xuqiu xuqiu6'>
					<div class='name fl'></div>
					<div class='fl ris' style='margin-left:118px'>
						<input class='btn fl' type='checkbox' id="agree" name="agree">
						<div class='txt fl'>我承诺以上企业信息属实＊</div>
						<div class='clear'></div>
					</div>
					<div id="notAgree"></div>
					<div class='clear'></div>
				</div>
				<div class='commitbtns' saveUrl="${pageContext.request.contextPath}/companyUser/add" id="saveBtn"><a href="#">提交</a></div>
			    <div detailUrl="${pageContext.request.contextPath}/companyUser/getDetail" id="getDetailUrl"></div>
				<div updateUrl="${pageContext.request.contextPath}/companyUser/update" id="updateUrl"></div>
			</div>
		</form>
			<div class='clear'></div>
		</div>
	</div>
	<%@ include file="/WEB-INF/pages/common/footer.jsp" %>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/front/companyUser/myInfo.js"></script>
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
