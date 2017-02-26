$(document).ready(function() {
	initUserManager();
	CommonFunction.selectAll('selectAll', 'userQueryTBody');
});
var queryParam = {};

function initUserManager() {
	//公共逻辑注册
	commonAction();
	query(queryParam);
	$('#searchBtn').click(function() {
		queryParam = getData();
		query(queryParam);
	});
};

function query(param) {
	var that=this;
	// 清空列表
	$('#userQueryTBody').html("");
	$('#noResult').html('');
	$('#pagination').html('');
	//$("#title-table-checkbox").remove("checked");
	var url = $('#searchBtn').attr('url');
	CommonFunction.baseOptions['url'] = url;
	if (param === null || jQuery.isEmptyObject(param)) {
		var requestParamTemp = {};
		requestParamTemp['str']="{}";
		requestParamTemp['currentPage'] = $('#currentPage').attr('value');
		requestParamTemp['maxRecordPerPage'] = CommonFunction.maxRecordPerPage;
		CommonFunction.baseOptions['data'] = requestParamTemp;
	} else {
		var jsonStr=JSON.stringify(param);
		var requestParamTemp = {};
		requestParamTemp['str']=jsonStr;
		requestParamTemp['currentPage'] = $('#currentPage').val();
		requestParamTemp['maxRecordPerPage'] = CommonFunction.maxRecordPerPage;
		CommonFunction.baseOptions['data'] = requestParamTemp;
	}
	
	CommonFunction.baseOptions['success'] = function(datas) {
		var queryReturnList = datas.queryReturnList;
		if (queryReturnList === null || queryReturnList.length === 0) {
			$('#noResult').html('未查询到符合条件的记录！');
			return;
		} 
		for(var i = 0; i < queryReturnList.length; i++) {	
			var userQueryTr = '<tr class="gradeX">'
				+ '<td><input type="checkbox" /></td>'
				+'<td name="id">'+CommonFunction.replaceNull(queryReturnList[i].id) +'</td>'
				+'<td name="username">'+CommonFunction.replaceNull(queryReturnList[i].username) +'</td>'
				+ '<td>'+ CommonFunction.replaceNull(queryReturnList[i].email) +'</td>'
				+ '<td>'+ CommonFunction.replaceNull(queryReturnList[i].telno)+'</td>'
				+ '<td>'+ CommonFunction.setUserType(queryReturnList[i].userType) +'</td>'
				+ '<td>'+ CommonFunction.getDate(queryReturnList[i].whenCreate) +'</td>'
				+ '<td>'+ CommonFunction.getDate(queryReturnList[i].whenLastLogin) +'</td>'
				+'<td name="status" class="hidden">'+CommonFunction.replaceNull(queryReturnList[i].status) +'</td>'
				+ '<td>'+ CommonFunction.setStatus(queryReturnList[i].status) +'</td>'
				+'<td name="communicateStatus" class="hidden">'+CommonFunction.replaceNull(queryReturnList[i].communicateStatus) +'</td>'
                + '<td>'+ CommonFunction.setCommunicateStatus(queryReturnList[i].communicateStatus) +'</td>'
                + '<td class="hidden" name="remark">'+ CommonFunction.replaceNull(queryReturnList[i].remark) +'</td>'
                + '<td>'+ CommonFunction.setRemark(queryReturnList[i].remark) +'</td>'
                + '<td>'+ CommonFunction.setRemoveFlag(queryReturnList[i].removeFlag) +'</td>'
                + '</tr>';
			$('#userQueryTBody').append(userQueryTr);
		}
		if (queryReturnList.length !== 0) {
			CommonFunction.pagination(datas.pagination.sumPage, '#currentPage', '#pagination', that, 'query');
		}
		
	};
	$.ajax(CommonFunction.baseOptions);
};

function getData() {
	var email = $("#email").val();
	var telno = $("#telno").val();
	var remark= $("#remark").val();
	var userType= $("#userTypeId").val();//用户类型
	var status= $("#statusId").val();//审核状态
	var communicateStatus= $("#communicateStatusId").val();//沟通状态
	var paramTemp = {};
	paramTemp['email']=email;//用户邮箱
	paramTemp['telno']=telno;//用户手机号
	paramTemp['remark']=remark;//用户备注
	paramTemp['userType']=userType;//用户类型
	paramTemp['status']=status;//审核状态
	paramTemp['communicateStatus']=communicateStatus;//沟通状态
	return paramTemp;
};