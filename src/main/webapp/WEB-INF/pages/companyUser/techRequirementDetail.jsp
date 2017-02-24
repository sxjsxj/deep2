<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset='utf-8'/>
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<title>发布企业需求-技术需求</title>
<% request.setCharacterEncoding("UTF-8");%>
<% response.setCharacterEncoding("UTF-8");%>
<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/images/front/img/homepage.png" media="screen" />
</head>
<body>

   <%@ include file="/WEB-INF/pages/common/header.jsp" %>
   <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/front/companyUser/techRequirementDetail.js"></script>

<%-- 	<div class='banner'>
		<img src='${pageContext.request.contextPath}/resources/images/front/img/banner.jpg' style="width:100%" height="100%" />
		<div class='width1200'>
			<div class='topbtxt'>唯有合作&nbsp;&nbsp;&nbsp;引领未来</div>
			<div class='bottombtxt'>
				<img src='${pageContext.request.contextPath}/resources/images/front/img/tel.png' class='fl'/>
				<a class='fl'>专业服务热线：</a>
				<span class='fl'>400-800-8989</span>
			</div>
		</div>
	</div> --%>
	<div class='cons'>
		<div class='width1200'>
		<jsp:include page="/WEB-INF/pages/common/companyUserLeft.jsp"></jsp:include>

			<!-- <div class="registSuccess" id="alertClick"></div>
			<div class="city" align="center" style="margin-top: 370px;">
				<div class="top01-city">
					<em class="ok">关闭</em>
				</div>
				<div class="mid01-city">
					<br /> <br /> <br /> <font align="center"></font> <br /> <br />
					<font id="errorInfo">&nbsp;&nbsp;</font> <br /> <br />
				</div>
			</div> -->
			<!-- 保存失败start -->
	<div class="registSuccess" id="alertClick"></div>
		<!-- version4 点击发布需求弹框start -->
			<div id="altsthree" style="display:none">
				<div class='xuqiualert' style="margin-top:450px;width:740px;font-size: 24px;text-align:center;color:#434343;min-height:280px;">
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
				<div class='xuqiualert' style="margin-top:450px;width:740px;font-size: 24px;text-align:center;color:#434343;min-height:280px;">
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
					<div>
					     <div>
								<font size="5" color="#349fc4">恭喜您,保存成功</font>
						  </div>
					</div>
				</div>
			</div>
			<!-- version3 点击发布需求弹框end -->

			<!-- 保存成功跳转url -->
           <div id="myRequireUrl" url="${pageContext.request.contextPath}/companyUser/getMyRequirementBrowsePage"></div>
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
			<input type="hidden" value="${id}" id="updateId"/>
			<form id="techRequirementFrom" method="post" enctype="multipart/form-data">
		     <input id="str" name="str" type="hidden" value="" />
			<div class='fl right'>
				<div class='xuqiu'>
					<div class='name fl'><span>*</span>需求名称</div>
					<div class='fl'><input type='text' maxlength="30" style="width:755px;" id="name" name="name" value=''/></div>
					<div class='clear'></div>
				</div>
				<div class='xuqiu xuqiu4 xuqiu7'>
					<div class='lis'>
						<div class='name fl'>*联系人</div>
						<div class='fl input'>
							<input type='text' maxlength="10" style="width:155px;" id="contactName" name="contactName" value='${companyUser.contactName}' />
						</div>
						<div id="contactNameResult" style="display:inline"></div>
						<div class='clear'></div>
					</div>
					<div class='lis' style="margin-left:-28px;">
						<div class='name fl'>*联系方式</div>
						<div class='fl input'>
							<input type='text' maxlength="15" style="width:155px;" id="contactTel" name="contactTel" value='${companyUser.contactTel}' />
						</div>
						<div id="contactTelResult" style="display:inline"></div>
						<div class='clear'></div>
					</div>
					<div class='lis' style="margin-left:-2px;">
						<div class='name fl'>邮箱</div>
						<div class='fl input'>
							<input type='text' maxlength="20" style="width:155px;" id="contactEmail" name="contactEmail" value='${companyUser.userModel.email}'/>
						</div>
						<div id="contactEmailResult" style="display:inline"></div>
						<div class='clear'></div>
					</div>
					<div class='clear'></div>
				</div>
				<div class='xuqiu xuqiu4'>

				    <input name="domain" id="domain" type='hidden' value=''/>
					<div class='lis'>
						<div class='name fl'><span>*</span>所属领域</div>
						<div class='fl input'>
							<input type='text' style="width:300px;" value='请选择领域' id="showDomain" readonly/>
							<img src='${pageContext.request.contextPath}/resources/images/front/img/downicon2.png'/>
							<dl id="selectDomain" url="${pageContext.request.contextPath}/basicResearchField/query" >
							</dl>
						</div>
						<div id="domainCheckResult" style="display:inline"></div>
						<div class='clear'></div>
					</div>
					<input id="amount" name="amount" type='hidden' value=''/>
					<div class='lis'>
						<div class='name fl'>*研发经费</div>
						<div class='fl input'>
							<input type='text' style="width:300px;" value='请选择研发经费' id="showAmount" readonly/>
							<img src='${pageContext.request.contextPath}/resources/images/front/img/downicon2.png'/>
							<dl id="selectAmount">
								<dd value="0">100万以下</dd>
								<dd value="1">100-500万</dd>
								<dd value="2">500-1000万</dd>
								<dd value="3">1000万以上</dd>
								<dd value="4">面议</dd>
							</dl>
						</div>
						<div id="amountCheckResult" style="display:inline"></div>
						<div class='clear'></div>
					</div>
					<div id="checkResult1"></div>
					<div class='clear'></div>
				</div>

				<div class='xuqiu xuqiu4'>
				    <input id="duration" name="duration" type='hidden' value=''/>
					<div class='lis'>
						<div class='name fl'>*研发周期</div>
						<div class='fl input'>
							<input type='text' style="width:300px;" value='请选择周期' id="showDuration" readonly/>
							<img src='${pageContext.request.contextPath}/resources/images/front/img/downicon2.png'/>
							<dl id="selectDuration">
								<dd value="0">1个月</dd>
								<dd value="1">1-3个月</dd>
								<dd value="2">3-6个月</dd>
								<dd value="3">6-12个月</dd>
								<dd value="4">12-24个月</dd>
								<dd value="5">24个月以上</dd>
							</dl>
						</div>
						<div id="durationCheckResult" style="display:inline"></div>
						<div class='clear'></div>
					</div>
					<input id="type" name="type" type='hidden' value=''/>
					<div class='lis'>
						<div class='name fl'>*需求类型</div>
						<div class='fl input'>
							<input type='text' style="width:300px;" value='请选择需求类型' id="showType" readonly/>
							<img src='${pageContext.request.contextPath}/resources/images/front/img/downicon2.png'/>
							<dl id="selectType">
								<dd value="0">新产品研发&nbsp;<font color="CFCFCF">全新技术研发</font></dd>
							    <dd value="1">产品技术升级&nbsp;<font color="CFCFCF">现有产品、技术的升级完善</font></dd>
							    <dd value="2">技术服务&nbsp;<font color="CFCFCF">租赁设备,咨询,协助做实验等服务</font></dd>
							</dl>
						</div>
						<div id="typeCheckResult" style="display:inline"></div>
						<div class='clear'></div>
					</div>
					<div class='clear'></div>
				</div>

				<div class='xuqiu xuqiu6'>
					<div class='name fl'>*合作方式</div>
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
						<div class='clear'></div>
					</div>
					</div>
					<div id="cooperationTypeCheckResult"></div>
					<div class='clear'></div>
				</div>
				<div class='xuqiu xuqiu3'>
					<div class='name fl'>*需求详述</div>
					<div class='fl'>
						<textarea name="detail"  maxlength="500" style="width:755px;" id="detail"></textarea>
					</div>
					<div class='clear'></div>
				</div>
				<div class='xuqiu xuqiu3'>
					<div class='name fl'>市场类似产品情况</div>
					<div class='fl'>
						<textarea name="similarProduct"  maxlength="500" style="width:755px;" id="similarProduct"></textarea>
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
					<div style="margin-left:-35px;" class='fl' onclick="$(this).children()[1].click()">
						<div class='uploadFilebtn'>上传附件</div>
						<input type='file'   name="file" id="techRequireFile" style='display:none'/>
					</div>
					<div class='fl txt'>大小限制：5M &nbsp;&nbsp;&nbsp;&nbsp;</div><div style='margin-top:10px;'  id="fileTypeCheckResult"></div>
					<div class='clear'></div>
				</div>
				<input type="hidden" value="" id="fileCheckFlag"/>
				<div class='xuqiu xuqiu6'>
					<div class='name fl'></div>
					<div class='fl ris' style='margin-left:118px'>
						<input class='btn fl' type='checkbox' id="agree" name="agree">
						<div class='txt fl'>我承诺以上企业需求属实＊</div>
						<div class='clear'></div>
					</div>
					<div id="notAgree"></div>
					<div class='clear'></div>
				</div>
				<div class='commitbtns' saveUrl="${pageContext.request.contextPath}/techRequirement/add" id="saveBtn">提交</div>
			    <div detailUrl="${pageContext.request.contextPath}/techRequirement/getDetail" id="getDetailUrl"></div>
				<div updateUrl="${pageContext.request.contextPath}/techRequirement/update" id="updateUrl"></div>
			</div>
		</form>
			<div class='clear'></div>
		</div>
	</div>
	<%@ include file="/WEB-INF/pages/common/footer.jsp" %>
</body>
<script type="text/javascript">

$(document).ready(function() {
	$('#techRequireFile').change(function() {
		 //文件大小限制
		   var dom = document.getElementById("techRequireFile");
		   var fileSize = dom.files[0].size;
		   var size=fileSize/(1024*1024); //单位M
		   if(size>5){
			   //$("#fileCheckFlag").val("0");
			   $("#techRequireFile").val("");
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
