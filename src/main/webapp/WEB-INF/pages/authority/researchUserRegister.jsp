<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset='utf-8'/>
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<title>联科-科研团队注册</title>
<% request.setCharacterEncoding("UTF-8");%>
<% response.setCharacterEncoding("UTF-8");%>
<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/images/front/img/homepage.png" media="screen" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/front/style.css"/>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/front/alert.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/front/jquery/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/front/jquery/jquery.validate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/front/common/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/front/authority/researchUserRegister.js"></script>
</head>
<body>
	<!-- 注册弹框 statr -->
	<div class="registSuccess" id="alertClick"></div>
	<!-- <div class="city" align="center" style="margin-top: 470px;">
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
		<!-- version4 点击发布需求弹框start -->
			<div id="altsthree">
				<div class='xuqiualert' style="width:740px;font-size:24px;margin-top:-10px;margin-left:-370px;text-align:center;color:#434343;min-height:280px;">
					<div class='tits'>
						注册失败
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

		<div id="loginUrl" url="${pageContext.request.contextPath}/security/loginPage"></div>
		<div id="Button1" onclick="ShowDiv('MyDiv','fade')"></div>
			<div id="fade" class="black_overlay"></div>
			<div id="MyDiv" class="white_content" style="margin-top:200px">
				<div style="text-align: right; cursor: default; height: 40px;">
					<!-- <span style="font-size: 16px;" onclick="CloseDiv('MyDiv','fade')">关闭</span> -->
				</div>
				<div style="margin-top:120px;margin-left:300px">
					<font size="5">恭喜您,您已注册成功,立刻建立科研团队,您就可以发布成功啦!</font>
					<br />
					<font size="5">完善科研团队信息,有助于让更多企业找您&nbsp;&nbsp;</font>
					<font size="5" color="blue"><a href="${pageContext.request.contextPath}/researchGroup/getDetailPageForAdd" >现在建立我的科研团队</a></font>
					<br />
					<font size="5">您还可以&nbsp;&nbsp;</font>
                    <font size="5" color="blue">
                    <a href="${pageContext.request.contextPath}/companyUser/getMyRequirementBrowsePage">查看需求信息</a>
                    </font>
				</div>
			</div>
	<!-- 注册成功弹框 end -->


		<!-- version2 点击发布需求弹框start -->
			<div id="altsone">
				<div class='xuqiualert' style="width:740px;font-size:24px;margin-top:-10px;margin-left:-370px;text-align:center;color:#434343;min-height:280px;">
					<div class='tits'>
						请您先维护企业信息
						<div class='imgs'>
							<img
								src='${pageContext.request.contextPath}/resources/images/front/img/close.png'
								class='img1' /> <img
								src='${pageContext.request.contextPath}/resources/images/front/img/close2.png'
								class='img2' />
						</div>
					</div>
					<div style="margin-top:0.1px;height:5px;">
					     <div style="margin-left:180px;margin-top:20px;">
								<font size="5">您还没有维护企业信息,请先维护企业信息</font>
						  </div>
						  <div style="margin-left:180px;margin-top:20px;">
								<font align="center" color="blue">
								 <a href="${pageContext.request.contextPath}/companyUser/getDetailPageForAdd">
								  <font size="5">现在就去完善企业信息>></font>
								  </a>
								  </font>
						  </div>
					</div>

				</div>
			</div>
			<!-- version2 点击发布需求弹框end -->


				<!-- version3 点击发布需求弹框start -->
			<div id="altstwo">
				<div class='xuqiualert' style="width:740px;font-size:24px;margin-top:-10px;margin-left:-370px;text-align:center;color:#434343;min-height:280px;">
					<div class='tits'>
						注册成功
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
								<font size="5" color="#349fc4">恭喜您注册成功,请登录</font>
						  </div>
					</div>
				</div>
			</div>
			<!-- version3 点击发布需求弹框end -->



	<div class='loginbg loginbg2'>
		<div class='width1200'>
			<div class='topLogo' style="margin-bottom:10px;">
			<a href="${pageContext.request.contextPath}/security/homepage">
			<img style="width:200px;height:40px;" src='${pageContext.request.contextPath}/resources/images/front/img/logo.png'/>
			</a>
			</div>
			<div class='loginkuang keyankuang'>
				<div class='tit' style="font-size:25px;">我是科研团队</div>
				 <input type="hidden" id="tagCheckValue" value="0"/>
				<ul class='hes'>
					<li id="shcool" class='active' value="0" style="font-size:17px;">高校</li>
					<li id="organization" value="1" style="font-size:17px;">科研机构</li>
					<li id="personal" value="2" style="font-size:17px;">个人</li>
				</ul>
				<div class='tit2' style="font-size:15px;">＊科研团队的类型不能修改，请您认真选择</div>

				<ul class='cons'>
				<form id="commonFormValidate">
						<li class='list'>
							<div style="font-size:15px;" class='fl names'>邮&nbsp;箱</div>
							<div class='input fl'>
								<input type='text' id="email" name="email" placeholder='请输入邮箱'/>
							</div>
							<div class='clear'></div>
						</li>
						<li class='list'>
							<div style="font-size:15px;" class='fl names'>手机号</div>
							<div class='input fl'>
								<input type='text' id="telno" name="telno" placeholder='请输入手机号'/>
							</div>
							<div class='clear'></div>
						</li>
						<li class='list'>
							<div style="font-size:15px;" class='fl names'>密&nbsp;码</div>
							<div class='input fl'>
								<input type="password" id="passwordOne" name="passwordOne"  value="" placeholder='6-20个大小写英文字母、符号或数字'/>
							</div>
							<div class='clear'></div>
						</li>
						<li class='list'>
							<div style="font-size:15px;" class='fl names'>确认密码</div>
							<div class='input fl'>
								<input type='password' id="passwordTwo" name="passwordTwo" placeholder='请再次输入密码'/>
							</div>
							<div class='clear'></div>
						</li>
					</form>
				<form id="shcoolFormValidate">
					<div id="shcoolForm">
						<li class='lis'>
							<div style="font-size:15px;" class='fl names'>所在地址</div>
							<input type='hidden' id="uniProvince" name="uniProvince" value='' />
							<div class='fl input'>
								<input type='text' style="width:135px;color: #959595;" value='请选择省份' id="showUniProvince" readonly/>
								 <img src='${pageContext.request.contextPath}/resources/images/front/img/downicon2.png' />
								<dl id="selectUniProvince"  url="${pageContext.request.contextPath}/basicProvince/queryProvinceCity">
								</dl>
							</div>
							<div id="uniProvinceFlag"></div>
							<input type='hidden' id="uniCity" name="uniCity" value="" />
							<div style="float:left;margin-left:16px;" class='fl input'>
								<input type='text' style="width:135px;color: #959595;" value='请选择市' id="showUniCity" readonly/> <img
									src='${pageContext.request.contextPath}/resources/images/front/img/downicon2.png' />
								<dl id="selectUniCity" url="${pageContext.request.contextPath}/basicProvince/queryCityCounty">
								</dl>
							</div>
							<div id="unRequiredFlag"></div>
							<div class='clear'></div>
						</li>

						<li class='lis'>
							<div style="font-size:15px;" class='fl names'>高校名称</div>
							<input type='hidden' id="uniName" name="uniName" value='' />
							<div class='fl input'>
								<input type='text' style="width:300px;color: #959595;" value='请选择高校' id="showUniName" readonly/>
								 <img src='${pageContext.request.contextPath}/resources/images/front/img/downicon2.png' />
								<dl id="selectUniName" url="${pageContext.request.contextPath}/basicUniversity/queryUniversity">
								</dl>
							</div>
							<div id="unNameFlag"></div>
							<div class='clear'></div>
						</li>
					</div>
				</form>
					<!-- 科研机构 -->
				<form id="organizationFormValidate">
					<div id="organizationForm">
					 <li class='list'>
						<div style="font-size:15px;" class='fl names'>机构名称</div>
						<div class='input fl'>
							<input type='text' id="orgName" name="orgName" placeholder='请输入机构名称'/>
						</div>
						<div class='clear'></div>
					</li>
					<li class='lis'>
						<div style="font-size:15px;" class='fl names'>所在地址</div>
						<input type='hidden' id="orgProvince" name="orgProvince" value='' />
						<div class='fl input'>
							<input type='text' style="width:91px;color: #959595;" value='请选择' id="showOrgProvince" readonly />
							<img src='${pageContext.request.contextPath}/resources/images/front/img/downicon2.png'/>
							<dl id="selectOrgProvince" url="${pageContext.request.contextPath}/basicProvince/queryProvinceCity">
							</dl>
						</div>
						<input type='hidden' id="orgCity" name="orgCity" value='' />
						<div class='fl input'>
							<input type='text' style="width:91px;color: #959595;" value="请选择" id="showOrgCity" readonly />
							<img src='${pageContext.request.contextPath}/resources/images/front/img/downicon2.png'/>
							<dl id="selectOrgCity" url="${pageContext.request.contextPath}/basicProvince/queryCityCounty">
							</dl>
						</div>
						<input type='hidden' id="orgCounty" name="orgCounty" value='' />
						<div class='fl input'>
							<input type='text' style="width:91px;color: #959595;" value='请选择' id="showOrgCounty" readonly />
							<img src='${pageContext.request.contextPath}/resources/images/front/img/downicon2.png'/>
							<dl id="selectOrgCounty">
							</dl>
						</div>
						<div id="orgRequiredFlag"></div>
						<div class='clear'></div>
					</li>
					<li class='list'>
						<div style="font-size:15px;" class='fl names'>详细地址</div>
						<div class='input fl'>
							<input type='text' id="orgAddress" name="orgAddress" placeholder='详细地址'/>
						</div>
						<div class='clear'></div>
					</li>
					</div>
				</form>

					<!-- 个人 -->
				<form id="personalFormValidate">
					<div id="personalForm">
					 <li class='list'>
						<div style="font-size:15px;" class='fl names'>联系人</div>
						<div class='input fl'>
							<input type='text' id="personalName" name="personalName" placeholder='请输入联系人姓名'/>
						</div>
						<div class='clear'></div>
					</li>
					<li class='lis'>
						<div style="font-size:15px;" class='fl names'>所在地址</div>
						<input type='hidden' id="personalProvince" name="personalProvince" value='' />
						<div class='fl input'>
							<input type='text' style="width:91px;color: #959595;" value='请选择' id="showPersonalProvince" readonly />
							<img src='${pageContext.request.contextPath}/resources/images/front/img/downicon2.png'/>
							<dl id="selectPersonalProvince" url="${pageContext.request.contextPath}/basicProvince/queryProvinceCity">
							</dl>
						</div>
						<input type='hidden' id="personalCity" name="personalCity" value='' />
						<div class='fl input'>
							<input type='text' style="width:91px;color: #959595;" value='请选择' id="showPersonalCity" readonly />
							<img src='${pageContext.request.contextPath}/resources/images/front/img/downicon2.png'/>
							<dl id="selectPersonalCity" url="${pageContext.request.contextPath}/basicProvince/queryCityCounty">
							</dl>
						</div>
						<input type='hidden' id="personalCounty" name="personalCounty" value='' />
						<div class='fl input'>
							<input type='text' style="width:91px;color: #959595;" value='请选择' id="showPersonalCounty" readonly />
							<img src='${pageContext.request.contextPath}/resources/images/front/img/downicon2.png'/>
							<dl id="selectPersonalCounty">
							</dl>
						</div>
						<div id="personalRequiredFlag"></div>
						<div class='clear'></div>
					</li>
					<li class='list'>
						<div style="font-size:15px;" class='fl names'>详细地址</div>
						<div class='input fl'>
							<input type='text' id="personalAddress" name="personalAddress" placeholder='详细地址'/>
						</div>
						<div class='clear'></div>
					</li>
					</div>
				</form>
				</ul>
				<div class='rem'>
					<div class='fl'>
						<input type='checkbox' checked="checked" id="agree" name="agree" />我已阅读并同意《<a style='color:#1faece' href='${pageContext.request.contextPath}/security/registAgreement'  id="registXieyi">linkcc.cn注册协议</a>》
					</div>
					<div id="notAgree"></div>
					<div class='clear'></div>
				</div>
				<div class='loginbtns anniu'><a href='#' url="${pageContext.request.contextPath}/security/user/addResearchUser" id="registComit">立即注册</a></div>
				<div class='moss'><a href='${pageContext.request.contextPath}/security/loginPage'>已有帐号，去登录>></a></div>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/pages/common/footer.jsp" %>
	<%-- <div class='footer'>
		<div class='width1200'>
			<ul>
				<li style="font-size:16px;" class='titles'>关于我们</li>
				<li>
					<div><a style="font-size:13px; color:#ffffff;"  href=''>公司介绍</a></div>
					<div><a style="font-size:13px; color:#ffffff;" href=''>联系我们</a></div>
					<div><a style="font-size:13px; color:#ffffff;" href=''>加入我们</a></div>
					<div><a style="font-size:13px; color:#ffffff;" href=''>友情链接</a></div>
				</li>
			</ul>
			<ul>
				<li style="font-size:16px;" class='titles'>产品功能</li>
				<li>
					<div><a style="font-size:13px; color:#ffffff;" href=''>注册</a></div>
					<div><a style="font-size:13px; color:#ffffff;" href=''>需求解决</a></div>
					<div><a style="font-size:13px; color:#ffffff;" href=''>资源搜索</a></div>
					<div><a style="font-size:13px; color:#ffffff;" href=''>项目对接</a></div>
				</li>
			</ul>
			<!-- <ul>
				<li style="font-size:16px;" class='titles'>常见问题</li>
				<li>
					<div><a style="font-size:13px; color:#ffffff;" href=''>关于平台</a></div>
					<div><a style="font-size:13px; color:#ffffff;" href=''>关于用户</a></div>
				</li>
			</ul> -->
			<div class='fl'>
				<div class='logo'>LOGO</div>
				<div class='txt' style="font-size:12px;">联系电话：010-57207996</div>
				<div class='txt' style="font-size:12px;">电子邮箱：linkcc_service@yeah.net</div>
			</div>
			<div class='fr'>
				<div class='fl code'><img src='${pageContext.request.contextPath}/resources/images/front/img/code.png'/></div>
				<div class='fl code'><img src='${pageContext.request.contextPath}/resources/images/front/img/code.png'/></div>
				<div class='fl code'></div>
				<div class='fl code'></div>
				<div class='clear'></div>
			</div>
			<div class='clear'></div>
		</div>
		<div style="margin-top:20px;font-size:12px; color:#ffffff;text-align:center" ><a href="http://www.miitbeian.gov.cn/">京ICP备16046710号</a>   © 2016-2017 Linkcc.cn，All rights reserved.</div>
	</div> --%>
</body>
<script type="text/javascript">
	$(function(){
		$(' .lis .input').click(function(){
			if($(this).hasClass('on')){
				$(this).removeClass("on");
				$(this).find("dl").slideUp(100);
			}else{
				$(this).addClass("on");
				$(this).find("dl").slideDown(100);
			}
		});
		$('.lis .input dd').click(function(){
			$(this).parents(".input").find("input").val($(this).text());
		})
		$(".hes li").click(function(){
			$(this).addClass("active").siblings().removeClass("active");
		})
	})
</script>
</html>
