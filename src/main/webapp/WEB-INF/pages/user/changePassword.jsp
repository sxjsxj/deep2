<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<div class="route"> 系统管理 » 修改密码  </div>
	<form id="changePasswordForm">
	<div class="changePwdLayout ">
		<h3 class=" width100 textRight marginBottom10">修改密码</h3>
		<div class="eachEditLayout">
			<span class="left marginRight5 width100 textRight">旧密码</span>
			<div class="left marginRight5">
				<input type="password" class="width150" id="oldPassword" autocomplete="off" placeholder="旧密码"/>
			</div>
            <span id="changePWDError" class="iconError hidden">密码输入有误，请重新输入</span>
			<div class="clear"></div>
		</div>
		<div class="eachEditLayout">
			<span class="left marginRight5 width100 textRight">新密码</span>
			<div class="left marginRight5">
				<input type="password" class="width150" id="newPassword" autocomplete="off" placeholder="新密码"/>
			</div>
            <span id="passwordSame" class="iconError hidden">新密码不能与旧密码相同</span>
			<div class="clear"></div>
		</div>
		<div class="eachEditLayout">
			<span class="left marginRight5 width100 textRight">密码确认</span>
			<div class="left marginRight5">
				<input type="password" class="width150" id="confirmPassword" autocomplete="off" placeholder="密码确认"/>
			</div>
			<div id="changePWDRight" class="tipsLayout hidden">
            	<i class="iconRight"></i>
                <span>正确</span>
                <div class="clear"></div>
            </div>
            <span id="changePWDNotMatch" class="iconError hidden">两次密码输入不一致</span>
			<div class="clear"></div>
		</div>
		<div class="eachEditLayout">
			<span class="left width100 textRight">&nbsp;</span>
			<div class="left operationBtnLayout">
				<a href="javascript:void(0)" id="passwordSave" url="${pageContext.request.contextPath}/security/user/changePassword" class="blueBtn">确定</a>
				<a href="javascript:void(0)" id="passwordClear" class="lightGrayBtn">清空</a>
				<div class="clear"></div>
			</div>
			<div class="clear"></div>
		</div>
	</div>	
    </form>
    
	<link type="text/css" rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/scripts/sea-modules/tui/scripts/tuiValidator/tui_validator.css"/>   
    <link type="text/css" rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/scripts/sea-modules/tui/scripts/tuiDialog/tui_dialog.css"/>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/scripts/config/changePasswordConfig.js"></script>