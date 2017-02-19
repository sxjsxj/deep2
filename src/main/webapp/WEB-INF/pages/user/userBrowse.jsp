<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
	<input type="hidden" id="sumPage" value="" />
	<input type="hidden" id="currentPage" value="1"></input>
	<div class="route">
    	<span>系统管理</span><span>&nbsp;»&nbsp;</span><span>安全管理</span>
	</div>
	<div class="requireLayout">
		<div class="requireBtnLayout">
			<a href="javascript:void(0)" class="searchButton" id="userQuery" url="${pageContext.request.contextPath}/security/user/query">查询</a>
		</div>
		<!-- line1 start -->
		<div class="eachRequireLay">
			<div class="left marginRight5">
				<span class="left gray marginRight5">用户名</span>
				<div class="left ">
					<input type="text" class="width120" id="userName"/>
				</div>
				<div class="clear"></div>
			</div>
            <div class="left marginRight5">
				<span class="left gray marginRight5">昵称</span>
				<div class="left ">
					<input type="text" class="width120" id="userDesc"/>
				</div>
				<div class="clear"></div>
			</div>
		</div>
	</div>
        
    <!-- 结果操作按钮 start -->
    <div class="resultOperationBtn">
    	<div class="left">
            <a href="javascript:void(0)" id="userAdd" url="${pageContext.request.contextPath}/security/user/getDetailPageForAdd" class="greenBtn">新增</a>
            <a href="javascript:void(0)" class="grayBtn" id="userEdit" url="${pageContext.request.contextPath}/security/user/getDetailPageForUpdate">编辑</a>
            <a href="javascript:void(0)" class="grayBtn" id="userDelete" url="${pageContext.request.contextPath}/security/user/delete">删除</a>
            <a href="javascript:void(0)" class="grayBtn" id="resetPassword" url="${pageContext.request.contextPath}/security/user/resetPassword">重置密码</a>
            <div class="clear"></div>
        </div>
        <div class="clear"></div>
    </div>
    <!-- 结果操作按钮 end -->
    
    <!-- 结果 table start -->
    <div class="resultTableLayout" >
    	<table cellpadding="0" cellspacing="0">
        	<thead>
                <tr id="dBusinessLicenseTh">
                	<th width="50" rowspan="2"><input type="checkbox" id="selectAll" />全选</th>
                	<th>用户名</th>
                	<th>昵称</th>
                	<th>单位</th>
                	<th>状态</th>
                	<th>手机号码</th>
                	<th>办公电话</th>
                	<th>传真</th>
                	<th>邮箱</th>
                	<th>通讯地址</th>
                </tr>
            </thead>
            <tbody id="userBody">
            </tbody>
        </table>
    </div>
    <div id="noResult" class="red" style="margin-left:20px;"></div>
    <div id="pagination"></div>
    <!-- 结果 table end -->
    
	<link type="text/css" rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/scripts/sea-modules/tui/scripts/tuiValidator/tui_validator.css"/>   
    <!-- main end -->
    <link type="text/css" rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/scripts/sea-modules/tui/scripts/tuiDatepicker/jquery_ui.datepicker-modify.css"/>
    <link type="text/css" rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/scripts/sea-modules/tui/scripts/tuiDialog/tui_dialog.css"/>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/scripts/config/userBrowseConfig.js"></script>
	
	
	