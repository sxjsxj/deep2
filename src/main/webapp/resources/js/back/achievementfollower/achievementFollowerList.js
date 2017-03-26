$(document).ready(function() {
	CommonFunction.selectAll('selectAll', 'achievementFollowerQueryTBody');
	initachievementFollowerManager();
});

var queryParam = {};
function initachievementFollowerManager() {
	commonFollowerAction('achievementFollower');
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
	$('#achievementFollowerQueryTBody').html("");
	$('#noResult').html('');
	$('#pagination').html('');
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
			var achievementFollowerQueryTBodyTr = '<tr class="gradeX">'
				+ '<td><input type="checkbox" name="listCheckbox" /></td>'
				+'<td name="achievementId">'+CommonFunction.replaceNull(queryReturnList[i].id.achievementId) +'</td>'
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
			$('#achievementFollowerQueryTBody').append(achievementFollowerQueryTBodyTr);
		}
		if (queryReturnList.length !== 0) {
			CommonFunction.pagination(datas.pagination.sumPage, '#currentPage', '#pagination', that, 'query');
		}
		
	};
	$.ajax(CommonFunction.baseOptions);
	
};

function getData() {
	
	var paramTemp = {};
	var achievementQueryModel={};
	getDefaultQuery('achievement', '5', achievementQueryModel);
	achievementQueryModel['id']=$.trim($("#achievementId").val());
	paramTemp['achievementQueryModel']=achievementQueryModel;
	
	var userQueryModel={};
	getDefaultQuery('user', '5', userQueryModel);
	userQueryModel['id']=$.trim($("#companyUserId").val());
	paramTemp['userQueryModel']=userQueryModel;
	
	var achievementFollowerQueryModel={};
	getDefaultQuery('achievementFollower', '5', achievementFollowerQueryModel);
	setFollowerQueryModel('achievementFollower', achievementFollowerQueryModel);
	achievementFollowerQueryModel['followerType']=$.trim($("#followerTypeId").val());
	achievementFollowerQueryModel['communicateStatus']=$.trim($("#communicateStatusId").val());
	achievementFollowerQueryModel['remark']=$.trim($("#remark").val());
	paramTemp['achievementFollowerQueryModel']=achievementFollowerQueryModel;
	return paramTemp;
};