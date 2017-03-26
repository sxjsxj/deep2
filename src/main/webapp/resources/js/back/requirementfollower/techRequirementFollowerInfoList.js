$(document).ready(function() {
	CommonFunction.selectAll('selectAll', 'requirementFollowerQueryTBody');
	initrequirementFollowerManager();
});
var queryParam = {};


function initrequirementFollowerManager() {
	commonFollowerAction('techRequirementFollower');
	query(queryParam);
	$('#searchBtn').click(function() {
		queryParam = getData();
		query(queryParam);
	});
};

function query(param) {
	var that=this;
	param = getData();
	// 清空列表
	$('#requirementFollowerQueryTBody').html("");
	$('#noResult').html('');
	$('#pagination').html('');
	var url = $('#searchBtn').attr('url');
	CommonFunction.baseOptions['url'] = url;
	if (param === null  || jQuery.isEmptyObject(param)) {
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
			var requirementFollowerQueryTBodyTr = '<tr class="gradeX">'
				+ '<td><input type="checkbox" name="listCheckbox" /></td>'
				+'<td name="requirementId">'+CommonFunction.replaceNull(queryReturnList[i].id.requirementId) +'</td>'
				+'<td name="userId">'+CommonFunction.replaceNull(queryReturnList[i].id.userId) +'</td>'
				+ '<td name="relationType" class="hidden">'+ queryReturnList[i].id.relationType +'</td>'
				+ '<td>'+ CommonFunction.setRelationType(queryReturnList[i].id.relationType) +'</td>'
				+ '<td>'+ CommonFunction.setRequirementFollowerType(queryReturnList[i].followerType) +'</td>'
				+'<td>'+CommonFunction.replaceNull(queryReturnList[i].content) +'</td>'
				+ '<td class="hidden" name="communicateStatus">'+ queryReturnList[i].communicateStatus +'</td>'
				+ '<td>'+ CommonFunction.setCommunicateStatus(queryReturnList[i].communicateStatus) +'</td>'
				+ '<td>'+ CommonFunction.replaceNull(queryReturnList[i].remark) +'</td>'
				+ '<td>'+ CommonFunction.setRemoveFlag(queryReturnList[i].removeFlag) +'</td>'
				+ '</tr>';
			$('#requirementFollowerQueryTBody').append(requirementFollowerQueryTBodyTr);
		}
		if (queryReturnList.length !== 0) {
			CommonFunction.pagination(datas.pagination.sumPage, '#currentPage', '#pagination', that, 'query');
		}
		
	};
	$.ajax(CommonFunction.baseOptions);
	
};

function getData() {
	var paramTemp = {};
	var techRequirementQueryModel={};
	getDefaultQuery('techRequirement', '5', techRequirementQueryModel);
	techRequirementQueryModel['id']=$.trim($("#requirementId").val());
	paramTemp['techRequirementQueryModel']=techRequirementQueryModel;
	
	var userQueryModel={};
	getDefaultQuery('user', '5', userQueryModel);
	userQueryModel['id']=$.trim($("#userId").val());
	paramTemp['userQueryModel']=userQueryModel;
	
	var requirementFollowerQueryModel={};
	getDefaultQuery('techRequirementFollower', '5', requirementFollowerQueryModel);
	setFollowerQueryModel('techRequirementFollower', requirementFollowerQueryModel);	
	requirementFollowerQueryModel['remark']=$.trim($("#remark").val());
	requirementFollowerQueryModel['status']=$.trim($("#statusId").val());
	requirementFollowerQueryModel['communicateStatus']=$.trim($("#communicateStatusId").val());
	paramTemp['techRequirementFollowerQueryModel']=requirementFollowerQueryModel;
	
	return paramTemp;
};