<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <input id="action" type="hidden" value="${action}" />
     <input id="enabled" type="hidden" value="" />
    <!-- 为空 详细js初始不加载查询  有值则加载 -->
    <input id="editId" type="hidden" value="${editId}" />
    <input id="roleDetail" type="hidden" value="${pageContext.request.contextPath}/security/role/getDetail"></input>
    <input type="hidden" id="queryAllAuthority" value="${pageContext.request.contextPath}/security/authority/queryAll"></input>
    
	<div class="route"> 系统管理  » 安全管理   » 新建角色 </div>
	 <!-- main start -->
   	<form id="roleDetailForm">
   	<div class="operationBtnLayout">
		<a class="blueBtn" id="roleSave"
			addUrl="${pageContext.request.contextPath}/security/role/add"
			updateUrl="${pageContext.request.contextPath}/security/role/update">保存</a>
		<a class="lightGrayBtn" id="roleClear">清空</a> 
		<a class="lightGrayBtn left" title="返回" id="roleReturn"
			url="${pageContext.request.contextPath}/security/role/getBrowsePage">返回</a>
		<div class="clear"></div>
	</div>
    
    <div class="mainLayout">		
		<div class="eachEditLayout">
			<span class="editTitle">角色名称</span>
			<div class="left ">
				<input type="text" class="width150" id="roleName"/>
			</div>
			<span class="red bold">*</span>
			<div class="clear"></div>
		</div>
		<div class="eachEditLayout">
			<span class="editTitle">角色描述</span>
			<div class="left ">
				<input type="text" class="width150" id="roleDesc"/>
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
			<span class="editTitle">权限</span>
			<div class="left weekLayout width500" id="authorities">
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
	src="${pageContext.request.contextPath}/resources/scripts/config/roleDetailConfig.js"></script>
