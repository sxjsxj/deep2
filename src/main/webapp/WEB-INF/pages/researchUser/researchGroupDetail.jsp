<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/head.jsp" %>
<title>我的科研团队-新建编辑科研团队</title>
</head>
<body>
	<%@ include file="/WEB-INF/pages/common/header.jsp" %>

	<div class='cons'>
		<div class='width1200'>
		<%@ include file="/WEB-INF/pages/common/researchUserLeft.jsp" %>

			<!-- 保存成功跳转url -->
           <div id="myResearchGrouUrl" url="${pageContext.request.contextPath}/researchGroup/getMyResearchGroupPage"></div>
		<!-- 弹框 statr -->
	<!-- <div class="registSuccess" id="alertClick"></div>
	<div class="city" align="center" style="margin-top: 370px;">
		<div class="top01-city">
			<em class="ok">关闭</em>
		</div>
		<div class="mid01-city">
			<br />
			<br />
			<br /> <font align="center"></font> <br />
			<br /> <font id="errorInfo">&nbsp;&nbsp;</font> <br />
			<br />
		</div>
	</div> -->
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
				<div class='xuqiualert' style="width:740px;margin-left:-370px;font-size: 24px;text-align:center;color:#434343;min-height:280px;">
					<div class='tits'>
						恭喜您,保存成功
						<div class='imgs'>
							<%-- <img
								src='${pageContext.request.contextPath}/resources/images/front/img/close.png'
								class='img1' /> <img
								src='${pageContext.request.contextPath}/resources/images/front/img/close2.png'
								class='img2' /> --%>
						</div>
					</div>
					<div>
						<div>
							<font style="font-size: 18px;"  color="#349fc4">我们会尽快审核您的信息,请您耐心等待结果~</font>
							<br>
							<font style="font-size: 18px;" color="#349fc4">
							<a href="${pageContext.request.contextPath}/achievement/getDetailPageForAdd">现在就去发布我的科研成果>> </a>
							</font>
							<br>
							 <font style="font-size: 18px;" color="#349fc4">
							 <a href="${pageContext.request.contextPath}/researchUser/getMyResearchGroupPage">以后再说>> </a>
							</font>
						</div>
					</div>
				</div>
			</div>
			<!-- version3 点击发布需求弹框end -->

		<!-- 保存成功弹框 statr -->
			<div id="Button1" onclick="ShowDiv('MyDiv','fade')"></div>
			<div id="fade" class="black_overlay"></div>
			<div id="MyDiv" class="white_content" style="margin-top:1800px">
				<div style="text-align: right; cursor: default; height: 40px;">
					<!-- <span style="font-size: 16px;" onclick="CloseDiv('MyDiv','fade')">关闭</span> -->
				</div>
				<div style="margin-top:120px;margin-left:300px">
					<font size="5">恭喜您,保存成功</font>
					<br /><br />
					<font size="5">我们会尽快审核您的信息,请您耐心等待结果~</font>
					<br /><br />
					<font size="5" color="blue"><a href="${pageContext.request.contextPath}/achievement/getDetailPageForAdd">现在就去发布我的科研成果</a></font>
					<br /><br />
                    <font size="5" color="blue">
                    <a href="${pageContext.request.contextPath}/researchUser/getMyResearchGroupPage">以后再说</a>
                    </font>
				</div>
			</div>
			<!-- 保存成功弹框 end -->
			<input type="hidden" value="${id}" id="updateId"/>
		<form id="researchGroupForm" method="post" enctype="multipart/form-data">
		<input id="str" name="str" type="hidden" value="" />
			<div class='fl right'>
				<div class='fengmian'>
					<div class='fl img'>
						<img class="img-circle" style="width:160px;height:120px;"  id="projectLogo" src='${pageContext.request.contextPath}/resources/images/front/img/fengmian_img.png'/>
					</div>
					<div class='fl'>
						<div class='titlena'>封面</div>
						<div class='remtxt'>提示:请上传GIF/JPG/JPEG/PNG格式文件，文件小于2MB</div>
						<div style="float:left" class='uploadbtn' onclick="$(this).children()[0].click()">上传图片
							<input type='file' name="logoFile" onchange="showPreview(this,'projectLogo');" id="companyImgLogo" style='display:none'/>
						</div>
						<div style="float:left;margin-top:25px;" id="imgTypeCheckResult"></div>
						<input type="hidden" value="" id="imgCheckFlag"/>

					</div>
					<div class='clear'></div>
				</div>
				<div class='xuqiu'>
					<div class='name fl'><span>*</span>科研团队名称</div>
					<div class='fl'><input type='text' maxlength="30" id="name" name="name" value=''/></div>
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
						<div id="checkResult3"></div>
						<div class='clear'></div>
					</div>
					<div class='clear'></div>
				</div>

				<div class='xuqiu xuqiu3'>
					<div class='name fl'><span></span>团队简介</div>
					<div class='fl'>
						<textarea name="introduction" maxlength="300" placeholder='请输入团队简介' id="introduction"></textarea>
					</div>
					<div class='clear'></div>
				</div>

				<div class='xuqiu xuqiu3'>
					<div class='name fl'><span>*</span>研究方向</div>
					<div class='fl'>
						<textarea name="field" id="field"></textarea>
					</div>
					<div class='clear'></div>
				</div>

				<div class='xuqiu xuqiu3'>
					<div class='name fl'><span>*</span>研究成果</div>
					<div class='fl'>
						<textarea name="achievement" maxlength="300" placeholder='请输入研究成果' id="achievement"></textarea>
					</div>
					<div id="achievementResult" style="display:inline"></div>
					<div class='clear'></div>
				</div>

				<div class='xuqiu'>
					<div class='name fl'><span></span>团队人数</div>
					<div class='fl'><input type='text' maxlength="5" placeholder='团队人数只能是数字' id="teamSize" name="teamSize" value=''/></div>
					<div class='clear'></div>
				</div>

				<div class='xuqiu xuqiu3'>
					<div class='name fl'><span>*</span>项目经历</div>
					<div class='fl'>
						<textarea name="experience" maxlength="500" id="experience"></textarea>
					</div>
					<div class='clear'></div>
				</div>
				<br/><br/>
				<div class='fengmian' style="width:755px;" >
					<div class='fl img'>
						<img class="img-circle" style="width:160px;height:120px;" id="leaderLogo" src='${pageContext.request.contextPath}/resources/images/front/img/fengmian_img.png'/>
					</div>
					<div class='fl'>
						<div class='titlena'>负责人照片</div>
						<div class='remtxt'>提示:请上传GIF/JPG/JPEG/PNG格式文件，文件小于2MB</div>
						<div style="float:left" class='uploadbtn' onclick="$(this).children()[0].click()">上传图片
							<input type='file'  name="leaderFile" onchange="showPreview(this,'leaderLogo');"  id="leaderImg" style='display:none'/>
						</div>
						<div style="float:left;margin-top:25px;" id="leaderImgTypeCheckResult"></div>
						<input type="hidden" value="" id="leaderImgCheckFlag"/>
					</div>
					<div class='clear'></div>
				</div>

				<div class='xuqiu xuqiu4'>
					<div class='lis'>
						<div class='name fl'>*姓名</div>
						<div class='fl input'>
							<input type='text' maxlength="10" style="width:300px;" id="leaderName" name="leaderName" value=''/>
						</div>
						<div id="leaderNameResult" style="display:inline"></div>
						<div class='clear'></div>
					</div>
					<div class='lis'>
						<div class='name fl'>*联系方式</div>
						<div class='fl input'>
							<input type='text' maxlength="15" style="width:300px;" id="leaderTel" name="leaderTel" value=''/>
						</div>
						<div id="leaderTelResult" style="display:inline"></div>
						<div class='clear'></div>
					</div>
					<div class='clear'></div>
				</div>

				<div class='xuqiu'>
					<div class='name fl'>*高校院系/部门</div>
					<div class='fl'><input style="width:755px;" type='text' id="leaderDepart" name="leaderDepart" value=''/></div>
					<div class='clear'></div>
				</div>

				<div class='xuqiu xuqiu4'>
				    <input id="leaderTitle" name="leaderTitle" type='hidden' value=''/>
					<div class='lis'>
						<div class='name fl'>*职称</div>
						<div class='fl input'>
							<input type='text' style="width:300px;"  value='请选择' id="showLeaderTitle" readonly/>
							<img src='${pageContext.request.contextPath}/resources/images/front/img/downicon2.png'/>
							<dl id="selectLeaderTitle">
								<dd value="0">院士</dd>
								<dd value="1">教授高级工程师</dd>
								<dd value="2">高级工程师</dd>
								<dd value="3">研究员</dd>
								<dd value="4">工程师</dd>
								<dd value="5">教授</dd>
								<dd value="6">副教授</dd>
								<dd value="7">其他</dd>
							</dl>
						</div>
						<div id="leaderTitleResult" style="display:inline"></div>
						<div class='clear'></div>
					</div>
					<div class='lis'>
						<div class='name fl'>*在岗职务</div>
						<div class='fl input'>
							<input type='text' maxlength="20" style="width:300px;"  id="leaderPosition" name="leaderPosition" value=''/>
						</div>
						<div id="leaderPositionResult" style="display:inline"></div>
						<div class='clear'></div>
					</div>
					<div id="checkResult2"></div>
					<div class='clear'></div>
				</div>

				<div class='xuqiu xuqiu3'>
					<div class='name fl'><span></span>个人介绍</div>
					<div class='fl'>
						<textarea name="leaderIntro" maxlength="300" style="width:755px;" id="leaderIntro"></textarea>
					</div>
					<div class='clear'></div>
				</div>

				<div class='xuqiu xuqiu3'>
					<div class='name fl'><span></span>个人主要成就</div>
					<div class='fl'>
						<textarea name="leaderAchieve" maxlength="500" style="width:755px;" id="leaderAchieve"></textarea>
					</div>
					<div class='clear'></div>
				</div>

				<div class='xuqiu xuqiu3'>
					<div class='name fl'><span></span>其他主要成员介绍</div>
					<div class='fl'>
						<textarea name="teamOthers" maxlength="500" style="width:755px;" id="teamOthers"></textarea>
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
						<input type='file' name="attachFile" id="companyFile" style='display:none'/>
					</div>
					<div class='fl txt'>大小限制：5M &nbsp;&nbsp;&nbsp;&nbsp;</div> <div style='margin-top:10px;' id="fileTypeCheckResult"></div>
					<div class='clear'></div>
				</div>
				<input type="hidden" value="" id="fileCheckFlag"/>
				<div class='xuqiu xuqiu6'>
					<div class='name fl'></div>
					<div class='fl ris' style='margin-left:118px'>
						<input class='btn fl' type='checkbox' id="agree" name="agree">
						<div class='txt fl'>我承诺以上科研团队及负责人信息属实＊</div>
						<div class='clear'></div>
					</div>
					<div id="notAgree"></div>
					<div class='clear'></div>
				</div>
				<div class='commitbtns' saveUrl="${pageContext.request.contextPath}/researchGroup/add" id="saveBtn">提交</div>
			    <div detailUrl="${pageContext.request.contextPath}/researchGroup/getDetail" id="getDetailUrl"></div>
				<div updateUrl="${pageContext.request.contextPath}/researchGroup/update" id="updateUrl"></div>
			</div>
		</form>
			<div class='clear'></div>
		</div>
	</div>
	<%@ include file="/WEB-INF/pages/common/footer.jsp" %>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/front/researchUser/researchGroupDetail.js"></script>
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
