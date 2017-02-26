<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

	  <div id='alts'>
		<div class='altsbg'>
			<div class='alts_ti'>合作意向说明</div>
			<div class='' >
				<textarea style="width:520px;height:120px;margin-left:65px;" id="cooRemark"></textarea>
			</div>
			<div id="cooperateRemarkIsNull" style="margin-left:65px;color:red;margin-bottom:-30px;">&nbsp;</div>
			<div class='button' style="margin-top:40px;margin-left:202px;">
				<div class='fl anniu_submit-btn anniu' style='margin-right:10px;font-size:15px;width:120px;'>提交</div>
				<div class='fl anniu_cancel-btn anniu' style='font-size:15px;width:120px;'>取消</div>
				<div class='clear'></div>
			</div>
		</div>
		<div style="display:none;margin-top:0px;width:600px;" class='altsubmit'>
			<div class='fr close'><img src='${pageContext.request.contextPath}/resources/images/front/img/close.png'/></div>
			<div class='clear'></div>
			<div class='consa' style="margin-top:-50px;margin-left:70px;">
				<div class='fl'>
					<img src='${pageContext.request.contextPath}/resources/images/front/img/submit.png'/>
				</div>
				<div class='fl txt'>
					<p style='font-size:16px;'>您的合作意向已经发布，我们会尽快和您取得联系。</p>
					<p style='font-size:16px;'>请您耐心等待。</p>
				</div>
				<div class='clear'></div>
			</div>
		</div>
	</div>
	<!-- 寻求合作弹框end -->
	<!-- 注册弹框 statr -->
	<div class="registSuccess" id="alertClick"></div>
	<!-- <div class="city" align="center" style="margin-top:0px;">
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
			<div id="altsthree" class="dialog" style="display:none">
				<div class='xuqiualert' style="width:740px;margin-top:15px;font-size: 24px;text-align:center;color:#434343;min-height:280px;">
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
			<div id="altstwo" class="dialog" style="display:none">
				<div class='xuqiualert' style="width:740px;margin-top:15px;font-size: 24px;text-align:center;color:#434343;min-height:280px;">
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
			<!-- nologin 点击发布需求弹框start -->
			<div id="nologin" class="dialog" style="display:none">
				<div class='xuqiualert' style="width:740px;margin-top:15px;font-size: 24px;text-align:center;color:#434343;min-height:280px;">
					<div class='tits'>
						没有登录
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
								<font size="5" color="#349fc4">请先登录</font>
						  </div>
					</div>
				</div>
			</div>
			<!-- nologin 点击发布需求弹框end -->
