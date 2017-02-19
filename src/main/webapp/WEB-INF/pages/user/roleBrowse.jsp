<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
      
	<input type="hidden" id="sumPage" value="" />
	<input type="hidden" id="currentPage" value="1"></input>

	<div class="route">
    	<span>系统管理</span><span>&nbsp;»&nbsp;</span><span>安全管理</span>
	</div>
	<div class="requireLayout">
		<div class="requireBtnLayout">
			<a href="javascript:void(0)" class="searchButton" id="roleQuery" url="${pageContext.request.contextPath}/security/role/query">查询</a>
		</div>
		<!-- line1 start -->
		<div class="eachRequireLay">
			<div class="left marginRight5">
				<span class="left gray marginRight5">角色名称</span>
				<div class="left ">
					<input type="text" class="width120" id="roleName"/>
				</div>
				<div class="clear"></div>
			</div>
            <div class="left marginRight5">
				<span class="left gray marginRight5">角色描述</span>
				<div class="left ">
					<input type="text" class="width120" id="roleDesc"/>
				</div>
				<div class="clear"></div>
			</div>
		</div>
		<!-- line1 end -->
	</div>
        
    <!-- 结果操作按钮 start -->
    <div class="resultOperationBtn">
    	<div class="left">
            <a href="javascript:void(0)" id="roleAdd" url="${pageContext.request.contextPath}/security/role/getDetailPageForAdd" class="greenBtn">新增</a>
            <a href="javascript:void(0)" class="grayBtn" id="roleEdit" url="${pageContext.request.contextPath}/security/role/getDetailPageForUpdate">编辑</a>
            <a href="javascript:void(0)" class="grayBtn" id="roleDelete" url="${pageContext.request.contextPath}/security/role/delete">删除</a>
            <div class="clear"></div>
        </div>
        <div class="clear"></div>
    </div>
    <!-- 结果操作按钮 end -->
    
    <!-- 结果 table start -->
    <div class="resultTableLayout" >
    	<table cellpadding="0" cellspacing="0">
        	<thead>
                <tr id="roleTh">
                	<th width="50" rowspan="2"><input type="checkbox" id="selectAll" />全选</th>
                	<th>角色名称</th>
                	<th>角色描述</th>
                	<th>状态</th>
                </tr>
            </thead>
            <tbody id="roleBody">
            </tbody>
        </table>
        <div id="noResult" class="red"></div>
    </div>
    <div id="pagination"></div>
    <!-- 结果 table end -->
    
	<link type="text/css" rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/scripts/sea-modules/tui/scripts/tuiValidator/tui_validator.css"/>   
    <!-- main end -->
    <link type="text/css" rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/scripts/sea-modules/tui/scripts/tuiDatepicker/jquery_ui.datepicker-modify.css"/>
    <link type="text/css" rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/scripts/sea-modules/tui/scripts/tuiDialog/tui_dialog.css"/>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/scripts/config/roleBrowseConfig.js"></script>
	
	
	