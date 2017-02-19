<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <input id="action" type="hidden" value="${action}" />
     <input id="enabled" type="hidden" value="" />
    <!-- 为空 详细js初始不加载查询  有值则加载 -->
    <input id="editId" type="hidden" value="${editId}" />
    <input id="detailUser" type="hidden" value="${pageContext.request.contextPath}/security/user/getDetail"></input>
    <input type="hidden" id="queryAllRole" value="${pageContext.request.contextPath}/security/role/queryAll"></input>
    <input id="queryUserDept" type="hidden" value="${pageContext.request.contextPath}/commonData/userDept/query"></input>
    
	<div class="route"> 系统管理  » 安全管理   » 新建用户 </div>
	 <!-- main start -->
   	<form id="userDetailForm">
   	<div class="operationBtnLayout">
		<a class="blueBtn" id="userSave"
			addUrl="${pageContext.request.contextPath}/security/user/add"
			updateUrl="${pageContext.request.contextPath}/security/user/update">保存</a>
		<a class="lightGrayBtn" id="userClear">清空</a> 
		<a class="lightGrayBtn left" title="返回" id="userReturn"
			url="${pageContext.request.contextPath}/security/user/getBrowsePage">返回</a>
		<div class="clear"></div>
	</div>
    
    <div class="mainLayout">		
		<div class="eachEditLayout">
			<span class="editTitle">用户名</span>
			<div class="left ">
				<input type="text" class="width150" id="userName" autocomplete="off"/>
			</div>
			<span class="red bold">*</span>
			<div class="clear"></div>
		</div>
		<div class="eachEditLayout">
			<span class="editTitle">昵称</span>
			<div class="left ">
				<input type="text" class="width150" id="userDesc" autocomplete="off"/>
			</div>
			<div class="clear"></div>
		</div>
		<div class="eachEditLayout" id="passwordDiv">
			<span class="editTitle">密码</span>
			<div class="left ">
				<input type="password" class="width150" id="password" autocomplete="off"/>
			</div>
			<span class="red bold">*</span>
			<div class="clear"></div>
		</div>
		<div class="eachEditLayout" id="confirmPasswordDiv">
			<span class="editTitle">确认密码</span>
			<div class="left ">
				<input type="password" class="width150" id="confirmPassword" autocomplete="off"/>
			</div>
			<span class="red bold">*</span>
            <span id="changePWDNotMatch" class="hidden iconError">两次密码输入不一致</span>
			<div class="clear"></div>
		</div>
		<div class="eachEditLayout">
			<span class="editTitle">类型</span>
			<div class="left">	                
                <input type="radio" id="manageDep" name="typeFlag" value="0"/>
                <span>管理局</span>
            </div>
            <div class="left">
                <input type="radio" id="domestic" name="typeFlag" value="1"/>
                <span>国内航空公司</span>
            </div>
            <div class="left">
                <input type="radio" id="international" name="typeFlag" value="2"/>
                <span>国外航空公司</span>
            </div>
            <div class="left">
                <input type="radio" id="hmt" name="typeFlag" value="3"/>
                <span>港澳台航空公司</span>
               </div>
			<div class="clear"></div>
		</div>
		<div class="eachEditLayout">
			<span class="editTitle">单位</span>
			<div class="left">
				<select id="userDepts"></select>
			</div>
			<span class="red bold">*</span>
			<div class="clear"></div>
		</div>
		<div class="eachEditLayout">
			<span class="editTitle">角色</span>
			<div class="left weekLayout width500" id="roles">
			</div>
			<div class="clear"></div>
		</div>
		<div class="eachEditLayout">
			<span class="editTitle">状态</span>
			<div class="left marginRight5">
				<input type="radio" id="enable" checked="checked" name="enabled" value="0">
				<span>可用</span>
			</div>
			<div class="left marginRight5">
				<input type="radio" id="disable" name="enabled" value="0">
				<span>不可用</span>
			</div>
			<div class="clear"></div>
		</div>
		
		<div class="eachEditLayout">
			<span class="editTitle">手机号码</span>
			<div class="left ">
				<input type="text" class="width150" id="mobileTel"/>
			</div>
			<div class="clear"></div>
		</div>
		<div class="eachEditLayout">
			<span class="editTitle">办公电话</span>
			<div class="left ">
				<input type="text" class="width150" id="officeTel"/>
			</div>
			<div class="clear"></div>
		</div>
		<div class="eachEditLayout">
			<span class="editTitle">传真</span>
			<div class="left ">
				<input type="text" class="width150" id="faxNo"/>
			</div>
			<div class="clear"></div>
		</div>
		<div class="eachEditLayout">
			<span class="editTitle">邮箱</span>
			<div class="left ">
				<input type="text" class="width150" id="emailAddr"/>
			</div>
			<div class="clear"></div>
		</div>
		<div class="eachEditLayout">
			<span class="editTitle">通讯地址</span>
			<div class="left ">
				<input type="text" class="width150" id="postAddr"/>
			</div>
			<div class="clear"></div>
		</div>
	</div>
   </form>            
   <!-- main end -->
	
    
	<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/scripts/sea-modules/jqueryui/1.9.0/themes/base/jquery.ui.all.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/scripts/sea-modules/tui/scripts/tuiValidator/tui_validator.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/scripts/sea-modules/tui/scripts/tuiDatepicker/jquery_ui.datepicker-modify.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/scripts/sea-modules/tui/scripts/tuiDialog/tui_dialog.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/scripts/config/userDetailConfig.js"></script>
