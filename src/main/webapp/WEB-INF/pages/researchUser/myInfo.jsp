<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/head.jsp" %>
</head>
<body>
	<%@ include file="/WEB-INF/pages/common/header.jsp" %>

	<div class='cons info' style="margin-top:84px;">
		<div class='width1200'>
		<div style="">
		<%@ include file="/WEB-INF/pages/common/researchUserLeft.jsp" %>
		</div>
		<div class="registSuccess" id="alertClick"></div>
		<!-- version4 点击发布需求弹框start -->
			<div id="altsthree" style="display:none">
				<div class='xuqiualert' style="width:740px;margin-left:-370px;font-size: 24px;text-align:center;color:#434343;min-height:280px;">
					<div class='tits'>
						操作失败
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
						操作成功
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
								<font size="5" color="#349fc4">操作成功</font>
						  </div>
					</div>
				</div>
			</div>
			<!-- version3 点击发布需求弹框end -->


			<div style="margin-left:-40px;" class='fl right'>
				<ul class='nav' style="width: 600px;border-bottom:none">
				    <input type="hidden" id="tagCheckValue" value="0"/>
					<li id="shcool" value="0" class='active' style="float: left;margin-left: 1px;">高校</li>
					<li id="organization" class='active' value="1" style="display:none;float: left; margin-right: 1px; margin-left:1px">科研机构</li>
					<li id="personal" class='active' value="2" style="display:none;float: left; margin-right: 1px; ">个人</li>
					<div class='clear'></div>
				</ul>
			<form id="shcoolFormValidate">
			<div id="shcoolForm">
				<div class='xuqiu xuqiu4'>
				   <input type='hidden' id="uniProvince" name="uniProvince" value='' />
					<div class='lis'>
						<div class='name fl'>*所在地址</div>
						<div class='fl input' style="height:120px;">
							<input type='text' style="width:200px;" value='请选择省份' id="showUniProvince" readonly/>
							<img src='${pageContext.request.contextPath}/resources/images/front/img/downicon2.png'/>
							<dl id="selectUniProvince" url="${pageContext.request.contextPath}/basicProvince/queryProvinceCity">
							</dl>
						</div>
						<div id="unRequiredProvinceCheckResult" style="display:inline"></div>
						<div class='clear'></div>
					</div>
					<input type='hidden' id="uniCity" name="uniCity" value="" />
					<div class='lis'>
						<div class='name fl'>&nbsp;&nbsp;</div>
						<div class='fl input' style="height:120px;">
							<input type='text' value='请选择市' style="width:200px;" id="showUniCity" readonly/>
							<img src='${pageContext.request.contextPath}/resources/images/front/img/downicon2.png'/>
							<dl id="selectUniCity" url="${pageContext.request.contextPath}/basicProvince/queryCityCounty">
							</dl>
						</div>
						<div id="unRequiredCityCheckResult" style="display:inline"></div>
						<div class='clear'></div>
					</div>
					<div class='clear'></div>
				</div>
				<div class='xuqiu xuqiu4'>
				   <input type='hidden' id="uniName" name="uniName" value='' />
					<div class='lis'>
						<div class='name fl'>*高校名称</div>
						<div class='fl input' style="height:120px;">
							<input type='text' style="width:300px;" value='请选择' id="showUniName" readonly/>
							<img src='${pageContext.request.contextPath}/resources/images/front/img/downicon2.png'/>
							<dl id="selectUniName" url="${pageContext.request.contextPath}/basicUniversity/queryUniversity">
							</dl>
						</div>
						<div class='clear'></div>
					</div>
					<div style="float:left" id="unNameRequiredFlag"></div>

				</div>
			</div>
			</form>

				<!-- 科研机构 -->
				<form id="organizationFormValidate">
				 <div id="organizationForm">
					<div class='xuqiu'>
						<div class='name fl'>
							<span>*</span>机构名称
						</div>
						<div class='fl'>
							<input type='text' id="orgName" name="orgName" value='' />
						</div>
						<div class='clear'></div>
					</div>
					<div class='xuqiu xuqiu4 xuqiu7'>
						<div class='lis'>
							<div class='name fl'>*所在地址</div>
							<input type='hidden' id="orgProvince" name="orgProvince" value='' />
							<div class='fl input'>
								<input type='text' style="width:150px;" value='请选择省份' id="showOrgProvince" readonly /> <img
									src='${pageContext.request.contextPath}/resources/images/front/img/downicon2.png' />
								<dl id="selectOrgProvince" url="${pageContext.request.contextPath}/basicProvince/queryProvinceCity">
								</dl>
							</div>
							<div id="orgRequiredProvinceCheckResult" style="display:inline"></div>
							<div class='clear'></div>
						</div>
						<div class='lis'>
							<div class='name fl'>&nbsp;&nbsp;</div>
							<input type='hidden' id="orgCity" name="orgCity" value='' />
							<div class='fl input'>
								<input type='text' style="width:150px;" value='请选择市' id="showOrgCity" readonly /> <img
									src='${pageContext.request.contextPath}/resources/images/front/img/downicon2.png' />
								<dl id="selectOrgCity" url="${pageContext.request.contextPath}/basicProvince/queryCityCounty">
								</dl>
							</div>
							<div id="orgRequiredCityCheckResult" style="display:inline"></div>
							<div class='clear'></div>
						</div>
						<div class='lis'>
							<div class='name fl'>&nbsp;&nbsp;</div>
							<input type='hidden' id="orgCounty" name="orgCounty" value='' />
							<div class='fl input'>
								<input type='text' style="width:150px;" value='请选择县' id="showOrgCounty" readonly /> <img
									src='${pageContext.request.contextPath}/resources/images/front/img/downicon2.png' />
								<dl id="selectOrgCounty">
								</dl>
							</div>
							<div id="orgRequiredCountyCheckResult" style="display:inline"></div>
							<div id="orgRequiredFlag"></div>
							<div class='clear'></div>
						</div>
						<div class='clear'></div>
					</div>

					<div class='xuqiu'>
						<div class='name fl'>
							<span>*</span>详细地址
						</div>
						<div class='fl'>
							<input type='text' id="orgAddress" name="orgAddress" value='' />
						</div>
						<div class='clear'></div>
					</div>
				</div>
				</form>

				<!-- 个人 -->
				<form id="personalFormValidate">
					<div id="personalForm">
						<div class='xuqiu'>
						<div class='name fl'>
							<span>*</span>联系人
						</div>
						<div class='fl'>
							<input type='text' id="personalName" name="personalName" value='' />
						</div>
						<div class='clear'></div>
					</div>
					<div class='xuqiu xuqiu4 xuqiu7'>
						<div class='lis'>
							<div class='name fl'>所在地址</div>
							<input type='hidden' id="personalProvince" name="personalProvince" value='' />
							<div class='fl input' style="height:120px;">
								<input type='text' style="width:150px;" value='请选择省份' id="showPersonalProvince" readonly /> <img
									src='${pageContext.request.contextPath}/resources/images/front/img/downicon2.png' />
								<dl id="selectPersonalProvince" url="${pageContext.request.contextPath}/basicProvince/queryProvinceCity">
								</dl>
							</div>
							<div id="personalRequiredProvinceCheckResult" style="display:inline"></div>
							<div class='clear'></div>
						</div>
						<div class='lis'>
							<div class='name fl'>&nbsp;&nbsp;</div>
							<input type='hidden' id="personalCity" name="personalCity" value='' />
							<div class='fl input' style="height:120px;">
								<input type='text' style="width:150px;" value='请选择市' id="showPersonalCity" readonly /> <img
									src='${pageContext.request.contextPath}/resources/images/front/img/downicon2.png' />
								<dl id="selectPersonalCity" url="${pageContext.request.contextPath}/basicProvince/queryCityCounty">
								</dl>
							</div>
							<div id="personalRequiredCityCheckResult" style="display:inline"></div>
							<div class='clear'></div>
						</div>
						<div class='lis'>
							<div class='name fl'>&nbsp;&nbsp;</div>
							<input type='hidden' id="personalCounty" name="personalCounty" value='' />
							<div class='fl input' style="height:120px;">
								<input type='text' style="width:150px;" value='请选择县' id="showPersonalCounty" readonly /> <img
									src='${pageContext.request.contextPath}/resources/images/front/img/downicon2.png' />
								<dl id="selectPersonalCounty">
								</dl>
							</div>
							<div id="personalRequiredCountyCheckResult" style="display:inline"></div>
							<div id="personalRequiredFlag"></div>
							<div class='clear'></div>
						</div>
						<div class='clear'></div>
					</div>

					<div class='xuqiu'>
						<div class='name fl'>
							<span>*</span>详细地址
						</div>
						<div class='fl'>
							<input type='text' id="personalAddress" name="personalAddress" value='' />
						</div>
						<div class='clear'></div>
					</div>
					</div>
				</form>
				<div style="margin-top:150px;"  class='commitbtns' saveUrl="${pageContext.request.contextPath}/researchUser/add" id="saveBtn">保存</div>
				 <div detailUrl="${pageContext.request.contextPath}/researchUser/getDetail" id="getDetailUrl"></div>
				<div updateUrl="${pageContext.request.contextPath}/researchUser/update" id="updateUrl"></div>
			</div>
			<div class='clear'></div>
		</div>
	</div>
	<%@ include file="/WEB-INF/pages/common/footer.jsp" %>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/front/researchUser/myInfo.js"></script>
</body>
<script type="text/javascript">
	$(function(){
		$('.info .right .nav li').click(function(){
			$(this).addClass("active").siblings().removeClass("active");
			$('.info .right .conul li').eq($(this).index()).show().siblings("li").hide();
		})
	})
</script>
<script type="text/javascript">

$(document).ready(function() {
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
