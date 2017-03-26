$(document).ready(function() {
	CommonFunction.selectAll('selectAll', 'investorFollowerQueryTBody');
	initinvestorFollowerManager();
});

var queryParam = {};

function initinvestorFollowerManager() {
	commonFollowerAction('investorFollower');
	$('#searchBtn').click(function() {
		queryParam = getData();
		query(queryParam);
	});
	query(queryParam);
};

function query(param) {
	var that=this;
	param = getData();
	// 清空列表
	$('#investorFollowerQueryTBody').html("");
	$('#noResult').html('');
	$('#pagination').html('');
	var url = $('#searchBtn').attr('url');
	CommonFunction.baseOptions['url'] = url;
	if (param === null) {
		var requestParamTemp = {};
		requestParamTemp['str']="";
		requestParamTemp['currentPage'] = $('#currentPage').val();
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
			var investorFollowerQueryTBodyTr = '<tr class="gradeX">'
				+ '<td><input type="checkbox" name="listCheckbox" /></td>'
				+'<td name="investorId">'+CommonFunction.replaceNull(queryReturnList[i].id.investorId) +'</td>'
				+'<td name="userId">'+CommonFunction.replaceNull(queryReturnList[i].id.userId) +'</td>'
				+'<td name="relationType" class="hidden">'+ queryReturnList[i].id.relationType +'</td>'
				+'<td>'+ CommonFunction.setRelationType(queryReturnList[i].id.relationType) +'</td>'
				+'<td>'+CommonFunction.setStrInvestorFollowerType(queryReturnList[i].followerType)+'</td>'
				+ '<td>'+ CommonFunction.setDetail(queryReturnList[i].content) +'</td>'
				+ '<td class="hidden" name="communicateStatus">'+ queryReturnList[i].communicateStatus +'</td>'
				+ '<td>'+ CommonFunction.setCommunicateStatus(queryReturnList[i].communicateStatus) +'</td>'
	            + '<td>'+ CommonFunction.setDetail(queryReturnList[i].remark) +'</td>'
                + '<td>'+ CommonFunction.setRemoveFlag(queryReturnList[i].removeFlag) +'</td>'
                + '</tr>';
			$('#investorFollowerQueryTBody').append(investorFollowerQueryTBodyTr);
		}
		if (queryReturnList.length !== 0) {
			CommonFunction.pagination(datas.pagination.sumPage, '#currentPage', '#pagination', that, 'query');
		}
	};
	$.ajax(CommonFunction.baseOptions);
};

function getData() {
	var paramTemp = {};
	var investorUserQueryModel={};
	getDefaultQuery('investorUser', '5', investorUserQueryModel);
	investorUserQueryModel['id']=$.trim($("#investorUserId").val());
	paramTemp['investorUserQueryModel']=investorUserQueryModel;
	
	var userQueryModel={};
	getDefaultQuery('user', '5', userQueryModel);
	userQueryModel['id']=$.trim($("#companyUserId").val());
	paramTemp['userQueryModel']=userQueryModel;
	
	var investorFollowerQueryModel={};
	getDefaultQuery('investorFollower', '5', investorFollowerQueryModel);
	setFollowerQueryModel('investorFollower', investorFollowerQueryModel);
	investorFollowerQueryModel['remark']=$.trim($("#remark").val());
	investorFollowerQueryModel['communicateStatus']=$.trim($("#communicateStatusId").val());
	paramTemp['investorUserFollowerQueryModel']=investorFollowerQueryModel;
	return paramTemp;
};
