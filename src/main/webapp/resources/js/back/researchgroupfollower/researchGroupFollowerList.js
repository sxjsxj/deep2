$(document).ready(function() {
	CommonFunction.selectAll('selectAll', 'researchGroupFollowerQueryTBody');
	initresearchGroupFollowerManager();
});

var queryParam = {};
function initresearchGroupFollowerManager() {
	commonFollowerAction('researchGroupFollower');
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
	$('#researchGroupFollowerQueryTBody').html("");
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
			var researchGroupFollowerQueryTBodyTr = '<tr class="gradeX">'
				+ '<td><input type="checkbox" name="listCheckbox" /></td>'
				+'<td name="researchId">'+CommonFunction.replaceNull(queryReturnList[i].id.researchId) +'</td>'
				+'<td name="userId">'+CommonFunction.replaceNull(queryReturnList[i].id.userId) +'</td>'
				+'<td name="relationType" class="hidden">'+ queryReturnList[i].id.relationType +'</td>'
				+'<td>'+ CommonFunction.setRelationType(queryReturnList[i].id.relationType) +'</td>'
				+ '<td>'+ CommonFunction.setFollowerType(queryReturnList[i].followerType) +'</td>'
				+ '<td>'+ CommonFunction.setDetail(queryReturnList[i].content) +'</td>'
				+ '<td class="hidden" name="communicateStatus">'+ queryReturnList[i].communicateStatus +'</td>'
				+ '<td>'+ CommonFunction.setCommunicateStatus(queryReturnList[i].communicateStatus) +'</td>'
                + '<td>'+ CommonFunction.setDetail(queryReturnList[i].remark) +'</td>'
                + '<td>'+ CommonFunction.setRemoveFlag(queryReturnList[i].removeFlag) +'</td>'
                + '</tr>';
			$('#researchGroupFollowerQueryTBody').append(researchGroupFollowerQueryTBodyTr);
		}
		if (queryReturnList.length !== 0) {
			CommonFunction.pagination(datas.pagination.sumPage, '#currentPage', '#pagination', that, 'query');
		}
		
	};
	$.ajax(CommonFunction.baseOptions);
	
};

function getData() {
	
	var paramTemp = {};
	var researchGroupQueryModel={};
	getDefaultQuery('researchGroup', '5', researchGroupQueryModel);
	researchGroupQueryModel['id']=$.trim($("#researchGroupId").val());
	paramTemp['researchGroupQueryModel']=researchGroupQueryModel;
	
	var userQueryModel={};
	getDefaultQuery('user', '5', userQueryModel);
	userQueryModel['id']=$.trim($("#companyUserId").val());
	paramTemp['userQueryModel']=userQueryModel;
	
	var researchGroupFollowerQueryModel={};
	getDefaultQuery('researchGroupFollower', '5', researchGroupFollowerQueryModel);
	setFollowerQueryModel('researchGroupFollower', researchGroupFollowerQueryModel);
	researchGroupFollowerQueryModel['followerType']=$.trim($("#followerTypeId").val());
	researchGroupFollowerQueryModel['communicateStatus']=$.trim($("#communicateStatusId").val());
	researchGroupFollowerQueryModel['remark']=$.trim($("#remark").val());
	paramTemp['researchGroupFollowerQueryModel']=researchGroupFollowerQueryModel;
	return paramTemp;
};