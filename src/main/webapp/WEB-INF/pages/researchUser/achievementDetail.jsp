<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/head.jsp" %>
<title>我的科研成果-高校发布科研成果</title>
</head>
<body>
	<%@ include file="/WEB-INF/pages/common/header.jsp" %>

	<div class='cons'>
		<div class='width1200'>
		<jsp:include page="/WEB-INF/pages/common/researchUserLeft.jsp"></jsp:include>

		<!-- 保存失败start -->
		<div class="registSuccess" id="alertClick"></div>
		<!-- version4 点击发布需求弹框start -->
			<div id="altsthree" style="display:none">
				<div class='xuqiualert' style="width:740px;margin-left:-370px;font-size: 24px;text-align:center;color:#434343;min-height:280px;">
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
           <div id="myAchievementUrl" url="${pageContext.request.contextPath}/researchUser/getMyAchievementPage"></div>
           <!-- 保存成功弹框 statr -->
			<div id="Button1" onclick="ShowDiv('MyDiv','fade')"></div>

			<div id="fade" class="black_overlay"></div>
			<div id="MyDiv" class="white_content" style="margin-top:1350px">
				<div style="text-align: right; cursor: default; height: 40px;">
					<!-- <span style="font-size: 16px;" onclick="CloseDiv('MyDiv','fade')">关闭</span> -->
				</div>
				<div style="margin-top:120px;margin-left:300px"><font size="10">恭喜您,保存成功</font></div>
			</div>
			<!-- 保存成功弹框 end -->
			<input type="hidden" value="${id}" id="updateId"/>
		<form id="achievementForm" method="post" enctype="multipart/form-data">
		    <input id="str" name="str" type="hidden" value="" />
			<div class='fl right'>
				<div class='fengmian'>
					<div class='fl img'>
						<img class="img-circle" style="width:160px;height:120px;" id="companyLogo"  src='${pageContext.request.contextPath}/resources/images/front/img/fengmian_img.png'/>
					</div>
					<div class='fl'>
						<div class='titlena'>*项目封面</div>
						<div class='remtxt'>请上传GIF/JPG/JPEG/PNG格式文件，文件小于2MB</div>
						<div style="float:left" class='uploadbtn' onclick="$(this).children()[0].click()">上传图片
							<input type='file' name="logoFile" onchange="showPreview(this);" id="companyImgLogo"  style='display:none'/>
						</div>
						<div style="float:left;margin-top:25px;" id="imgTypeCheckResult"></div>
						<input type="hidden" value="" id="imgCheckFlag"/>
					</div>
					<div class='clear'></div>
				</div>

				<div class='name fl'>
				<font color="blue" size="3">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath}/researchGroup/getDetailPageForAdd"><font color="#349fc4">+新建科研团队</font></a>
				</font>
				</div>
				<div class='xuqiu xuqiu4 xuqiu8'>
				    <input id="researchGroupName" name="researchGroupName" type='hidden' value=''/>
					<input id="researchGroupId" name="researchGroupId" type='hidden' value=''/>
					<div class='lis'>
						<div class='name fl'>*科研团队</div>
						<div class='fl input'>
							<input type='text' value='请选择团队名称' id="showResearchGroupName" readonly/>
							<img src='${pageContext.request.contextPath}/resources/images/front/img/downicon2.png'/>
							<dl id="selectResearchGroupName" url="${pageContext.request.contextPath}/researchGroup/query">
							</dl>
						</div>
						<div id="checkResult1" style="margin-top:10px;"></div>
						<div class='clear'></div>
					</div>
					<div class='clear'></div>
				</div>
				<div class='xuqiu'>
					<div class='name fl'><span>*</span>成果名称</div>
					<div class='fl'><input type='text' id="name"  maxlength="30" name="name" value=''/></div>
					<div class='clear'></div>
				</div>
				<div class='xuqiu xuqiu4 xuqiu8'>
				    <input name="domain" id="domain" type='hidden' value=''/>
					<div class='lis'>
						<div class='name fl'><span>*</span>所属领域</div>
						<div class='fl input'>
							<input type='text' value='请选择领域' id="showDomain" readonly/>
							<img src='${pageContext.request.contextPath}/resources/images/front/img/downicon2.png'/>
							<dl id="selectDomain" url="${pageContext.request.contextPath}/basicResearchField/query">
							</dl>
						</div>
						<div id="checkResult2" style="margin-top:10px;"></div>
						<div class='clear'></div>
					</div>
					<div class='clear'></div>
				</div>

				<div class='xuqiu xuqiu6'>
					<div class='name fl'><span>*</span>成果形式</div>
					<div id="checkBoxType">
					<div class='fl'>
						<div class='fl txts'>
							<input id="typeCheckBox0" class='checkbox fl' type='checkbox'>
							<div class='fl s'><input type="hidden" value="0" id="typeCheckBoxValue0"/>新产品原型</div>
							<div class='clear'></div>
						</div>
						<div class='fl txts'>
							<input id="typeCheckBox1" class='checkbox fl' type='checkbox'>
							<div class='fl s'><input type="hidden" value="1" id="typeCheckBoxValue1"/>新技术</div>
							<div class='clear'></div>
						</div>
						<div class='fl txts'>
							<input id="typeCheckBox2" class='checkbox fl' type='checkbox'>
							<div class='fl s'><input type="hidden" value="2" id="typeCheckBoxValue2"/>带有技术参数的图纸</div>
							<div class='clear'></div>
						</div>
						<div class='fl txts'>
							<input id="typeCheckBox3" class='checkbox fl' type='checkbox'>
							<div class='fl s'><input type="hidden" value="3" id="typeCheckBoxValue3"/>专利</div>
							<div class='clear'></div>
						</div>
						<input type="hidden" id="typeId"/>
						<div id="checkResult6" style="margin-top:10px;"></div>
						<div class='clear'></div>
					</div>
					</div>
					<div class='clear'></div>
				</div>
				<div class='xuqiu xuqiu4 xuqiu8' id="patentDiv" >
				    <input id="patent" name="patent" type='hidden' value=''/>
					<div class='lis'>
						<div class='name fl'>*专利情况</div>
						<div class='fl input'>
							<input type='text' value='请选择专利情况' id="showPatent" readonly/>
							<img src='${pageContext.request.contextPath}/resources/images/front/img/downicon2.png'/>
							<dl id="selectPatent">
								<dd value="0">已申请</dd>
								<dd value="1">已公示</dd>
								<dd value="2">已授权</dd>
							</dl>
						</div>
						<div id="checkResult3"></div>
						<div class='clear'></div>
					</div>
					<div class='clear'></div>
				</div>

				<div class='xuqiu' style="margin-top:15px;" id="patenterDiv" >
					<div class='name fl'><span>*</span>专利权人</div>
					<div class='fl'><input type='text' id="patenter"  maxlength="30" name="patenter" value=''/></div>
					<div id="checkResultpatenter"></div>
					<div class='clear'></div>
				</div>

				<div class='xuqiu xuqiu4 xuqiu8'>
				    <input id="amount" name="amount" type='hidden' value=''/>
					<div class='lis'>
						<div class='name fl'>*所需投资金额</div>
						<div class='fl input'>
							<input type='text' value='请选择投资金额' id="showAmount" readonly/>
							<img src='${pageContext.request.contextPath}/resources/images/front/img/downicon2.png'/>
							<dl id="selectAmount">
								<dd value="0">100万以下</dd>
								<dd value="1">100-500万</dd>
								<dd value="2">500-1000万</dd>
								<dd value="3">1000万以上</dd>
								<dd value="4">面议</dd>
							</dl>
						</div>
						<div id="checkResult4" style="margin-top:10px;"></div>
						<div class='clear'></div>
					</div>
					<div class='clear'></div>
				</div>

				<div class='xuqiu xuqiu3'>
					<div class='name fl'><span>*</span>成果简述</div>
					<div class='fl'>
						<textarea name="solution"  maxlength="300" id="solution"></textarea>
					</div>
					<div class='clear'></div>
				</div>

				<div class='xuqiu xuqiu4 xuqiu8'>
				    <input id="phase" name="phase" type='hidden' value=''/>
					<div class='lis'>
						<div class='name fl'>*项目阶段</div>
						<div class='fl input'>
							<input type='text' value='请选择阶段' id="showPhase" readonly/>
							<img src='${pageContext.request.contextPath}/resources/images/front/img/downicon2.png'/>
							<dl id="selectPhase">
								<dd value="0">研发阶段</dd>
								<dd value="1">实验室阶段</dd>
								<dd value="2">概念阶段</dd>
								<dd value="3">小批量生产阶段</dd>
								<dd value="4">规模化生产阶段</dd>
								<dd value="5">市场推广阶段</dd>
							</dl>
						</div>
						<div id="checkResult5" style="margin-top:10px;"></div>
						<div class='clear'></div>
					</div>
					<div class='clear'></div>
				</div>

				<div class='xuqiu'>
					<div class='name fl'><span>*</span>适用对象</div>
					<div class='fl'><input type='text'  maxlength="30" id="applyTo" name="applyTo" value=''/></div>
					<div class='clear'></div>
				</div>

				<div class='xuqiu xuqiu3'>
					<div class='name fl'><span>*</span>预期效果</div>
					<div class='fl'>
						<textarea name="expectedEffect"  maxlength="300" id="expectedEffect"></textarea>
					</div>
					<div class='clear'></div>
				</div>

				<div class='xuqiu'>
					<div class='name fl'>成果转化案例数</div>
					<div class='fl'><input type='text'  maxlength="5" id="caseNum" name="caseNum" value=''/></div>
					<div class='clear'></div>
				</div>

				<div class='xuqiu xuqiu3'>
					<div class='name fl'>案例详述</div>
					<div class='fl'>
						<textarea name="caseDetail"  maxlength="300" id="caseDetail"></textarea>
					</div>
					<div class='clear'></div>
				</div>

				<div class='xuqiu xuqiu6'>
					<div class='name fl'><span>*</span>寻求合作方式</div>
					<div id="checkBoxCooperationType">
					<div class='fl'>
						<div class='fl txts'>
							<input id="cooperationTypeCheckBox0" class='checkbox fl' type='checkbox'>
							<div class='fl s'><input type="hidden" value="0" id="cooperationTypeCheckBoxValue0"/>技术入股</div>
							<div class='clear'></div>
						</div>
						<div class='fl txts'>
							<input id="cooperationTypeCheckBox1" class='checkbox fl' type='checkbox'>
							<div class='fl s'><input type="hidden" value="1" id="cooperationTypeCheckBoxValue1"/>技术转让</div>
							<div class='clear'></div>
						</div>
						<div class='fl txts'>
							<input id="cooperationTypeCheckBox2" class='checkbox fl' type='checkbox'>
							<div class='fl s'><input type="hidden" value="2" id="cooperationTypeCheckBoxValue2"/>技术许可</div>
							<div class='clear'></div>
						</div>
						<div class='fl txts'>
							<input id="cooperationTypeCheckBox3" class='checkbox fl' type='checkbox'>
							<div class='fl s'><input type="hidden" value="3" id="cooperationTypeCheckBoxValue3"/>委托开发</div>
							<div class='clear'></div>
						</div>
						<div class='fl txts'>
							<input id="cooperationTypeCheckBox4" class='checkbox fl' type='checkbox'>
							<div class='fl s'><input type="hidden" value="4" id="cooperationTypeCheckBoxValue4"/>技术服务</div>
							<div class='clear'></div>
						</div>
						<div class='fl txts'>
							<input id="cooperationTypeCheckBox5" class='checkbox fl' type='checkbox'>
							<div class='fl s'><input type="hidden" value="5" id="cooperationTypeCheckBoxValue5"/>其它</div>
							<div class='clear'></div>
						</div>
						<input type="hidden" id="cooperationTypeId"/>
						<div id="checkResult7" style="margin-top:10px;"></div>
						<div class='clear'></div>
					</div>
					</div>
					<div class='clear'></div>
				</div>

				<div class='xuqiu xuqiu5'>
					<div class='name fl'>材料补充</div>
					<!-- <div class='fl input'>
						<input type='text' readonly/>
						<div class='bgs'></div>
						<div class='bgtxt' id='fileName'>选择上传附件</div>
					</div> -->
					<input type="hidden" id="filePath"/>
					<div class='fl' style="margin-left:-30px;" onclick="$(this).children()[1].click()">
						<div class='uploadFilebtn'>上传附件</div>
						<input type='file' name="attachFile" id="companyFile" style='display:none'/>
					</div>
					<div class='fl txt'>大小限制：5M &nbsp;&nbsp;&nbsp;&nbsp;</div><div style='margin-top:10px;' id="fileTypeCheckResult"></div>
					<div class='clear'></div>
				</div>
				<input type="hidden" value="" id="fileCheckFlag"/>
				<div class='xuqiu xuqiu6'>
					<div class='name fl'></div>
					<div class='fl ris' style='margin-left:118px'>
						<input class='btn fl' type='checkbox' id="agree" name="agree">
						<div class='txt fl'>我承诺以上科研成果信息属实＊</div>
						<div class='clear'></div>
					</div>
					<div id="notAgree"></div>
					<div class='clear'></div>
				</div>
				<div class='commitbtns' saveUrl="${pageContext.request.contextPath}/achievement/add" id="saveBtn">提交</div>
			 <div detailUrl="${pageContext.request.contextPath}/achievement/getDetail" id="getDetailUrl"></div>
				<div updateUrl="${pageContext.request.contextPath}/achievement/update" id="updateUrl"></div>
			</div>
			</form>
			<div class='clear'></div>
		</div>
	</div>
	<%@ include file="/WEB-INF/pages/common/footer.jsp" %>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/front/researchUser/achievementDetail.js"></script>
</body>
<script type="text/javascript">

$(document).ready(function() {
	$('#companyFile').change(function() {
		 //文件大小限制
		   var dom = document.getElementById("companyFile");
		   var fileSize = dom.files[0].size;
		   var size=fileSize/(1024*1024); //单位M
		   if(size>5){
			   $("#fileCheckFlag").val("0");
			   $("#companyFile").val("");
			   $("#fileTypeCheckResult").html('<font style="color:red;">上传文件超过5M,请重新上传。</font>');
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
