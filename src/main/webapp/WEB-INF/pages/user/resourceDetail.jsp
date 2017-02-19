<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <input id="action" type="hidden" value="${action}" />
     <input id="enabled" type="hidden" value="" />
    <!-- 为空 详细js初始不加载查询  有值则加载 -->
    <input id="editId" type="hidden" value="${editId}" />
    <input id="resourceDetail" type="hidden" value="${pageContext.request.contextPath}/security/resource/getDetail">
    
    
	<div class="route"> 系统管理  » 安全管理   » 资源管理 </div>
	 <!-- main start -->
   	<form id="resourceDetailForm">
   	<div class="operationBtnLayout">
		<a class="blueBtn" id="resourceSave"
			addUrl="${pageContext.request.contextPath}/security/resource/add"
			updateUrl="${pageContext.request.contextPath}/security/resource/update">保存</a>
		<a class="lightGrayBtn" id="resourceClear">清空</a> 
		<a class="lightGrayBtn left" title="返回" id="resourceReturn"
			url="${pageContext.request.contextPath}/security/resource/getBrowsePage">返回</a>
		<div class="clear"></div>
	</div>
    
    <div class="mainLayout">		
		<div class="eachEditLayout">
			<span class="editTitle">资源名称</span>
			<div class="left ">
				<input type="text" class="width250" id="resourceName" maxlength="50"/>
			</div>
			<span class="red bold">*</span>
			<div class="clear"></div>
		</div>
		<div class="eachEditLayout">
			<span class="editTitle">资源描述</span>
			<div class="left ">
				<input type="text" class="width250" id="resourceDesc" maxlength="100"/>
			</div>
			<div class="clear"></div>
		</div>
		<div class="eachEditLayout">
			<span class="editTitle">资源类型</span>
			<div class="left">
				<select id="resourceType" class="width150">
					<option>element</option>
					<option>url</option>
				</select>
			</div>
			<div class="clear"></div>
		</div>
		<div class="eachEditLayout">
			<span class="editTitle">资源路径</span>
			<div class="left ">
				<input type="text" class="width250" id="resourceString" maxlength="200"/>
			</div>
			<span class="red bold">*</span>
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
	src="${pageContext.request.contextPath}/resources/scripts/config/resourceDetailConfig.js"></script>
