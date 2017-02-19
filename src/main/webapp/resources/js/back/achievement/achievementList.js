$(document).ready(function() {
	initBasicResearchField();
	CommonFunction.selectAll('selectAll', 'achievementQueryTBody');
	$(".domain").click(function() {
		text = $("input:checkbox[name='domain']:checked").map(function(index,elem) {
			return $(elem).val();
		}).get().join(',');
		$("#domainId").val(text);
	});
	initachievementManager();
});
var queryParam = {};

function initBasicResearchField(){
	    var reqParam={}
	    var url = $('#searchBasicResearchField').attr('url');
	    CommonFunction.baseOptions['url'] = url;
		CommonFunction.baseOptions['data'] = reqParam;
		CommonFunction.baseOptions['success'] = function(datas) {
			var basicRearchFieldList=datas;
			var domainShow = '';
			for(var i = 0; i < basicRearchFieldList.length; i++) {	
				idIndex="domain"+i
				domainShow+='<input type="checkbox"  name="domain" class="domain" id='+idIndex+' value="'+basicRearchFieldList[i].name+'"  style="width:12px"/>'
				+basicRearchFieldList[i].name+'';
			}
			$("#domainDiv").append(domainShow);
		};
		$.ajax(CommonFunction.baseOptions);
}

function initachievementManager() {
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
	$('#achievementQueryTBody').html("");
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
			var achievementQueryTBodyTr = '<tr class="gradeX">'
				+ '<td><input type="checkbox" /></td>'
				+'<td name="id" class="hidden">'+CommonFunction.replaceNull(queryReturnList[i].id) +'</td>'
				+'<td name="recommendFlag" class="hidden">'+CommonFunction.replaceNull(queryReturnList[i].recommendFlag) +'</td>'
				+'<td name="seqNum" class="hidden">'+CommonFunction.replaceNull(queryReturnList[i].seqNum) +'</td>'
				+ '<td>'+ CommonFunction.replaceNull(queryReturnList[i].researchGroupResultModel.name) +'</td>'
				+ '<td>'+ CommonFunction.replaceNull(queryReturnList[i].logoUrl) +'</td>'
				+'<td>'+CommonFunction.replaceNull(queryReturnList[i].name) +'</td>'
	            + '<td>'+ CommonFunction.setStrDomain(queryReturnList[i].domain) +'</td>'
	            + '<td>'+ CommonFunction.setStrType(queryReturnList[i].type) +'</td>'
				+ '<td>'+ CommonFunction.setPatent(queryReturnList[i].duration) +'</td>'
                + '<td>'+ CommonFunction.replaceNull(queryReturnList[i].patenter) +'</td>'
                + '<td>'+ CommonFunction.setStrAmount(queryReturnList[i].amount) +'</td>'
                + '<td>'+ CommonFunction.setDetail(queryReturnList[i].solution,10) +'</td>'
                + '<td>'+ CommonFunction.setStrPhase(queryReturnList[i].phase) +'</td>'
                + '<td>'+ CommonFunction.replaceNull(queryReturnList[i].applyTo) +'</td>'
                + '<td>'+ CommonFunction.replaceNull(queryReturnList[i].expectedEffect) +'</td>'
                + '<td>'+ CommonFunction.setCaseNum(queryReturnList[i].caseNum) +'</td>'
                + '<td>'+ CommonFunction.setDetail(queryReturnList[i].caseDetail) +'</td>'
                + '<td>'+ CommonFunction.setStrCooperationType(queryReturnList[i].cooperationType) +'</td>';
                achievementQueryTBodyTr += CommonFunction.getAttach(queryReturnList[i]);
                achievementQueryTBodyTr = achievementQueryTBodyTr
                + '<td>'+ CommonFunction.replaceNull(queryReturnList[i].sequenceNumber) +'</td>'
                +'<td name="status" class="hidden">'+CommonFunction.replaceNull(queryReturnList[i].status) +'</td>'
                + '<td>'+ CommonFunction.setRequirementStatus(queryReturnList[i].status) +'</td>'
                +'<td name="communicateStatus" class="hidden">'+CommonFunction.replaceNull(queryReturnList[i].communicateStatus) +'</td>'
                + '<td>'+ CommonFunction.setCommunicateStatus(queryReturnList[i].communicateStatus) +'</td>'
                + '<td class="hidden" name="remark">'+ CommonFunction.replaceNull(queryReturnList[i].remark) +'</td>'
                + '<td>'+ CommonFunction.setDetail(queryReturnList[i].remark) +'</td>'
                + '<td>'+ CommonFunction.replaceNull(queryReturnList[i].concernNumber) +'</td>'
                + '<td>'+ CommonFunction.replaceNull(queryReturnList[i].scanNumber) +'</td>'
                + '</tr>';
			$('#achievementQueryTBody').append(achievementQueryTBodyTr);
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
	researchGroupQueryModel['name']=$.trim($("#groupName").val());
	researchGroupQueryModel['leaderName']=$.trim($("#leaderName").val());
	paramTemp['researchGroupQueryModel']=researchGroupQueryModel;
	
	var achievementQueryModel={};
	achievementQueryModel['sequenceNumber']=$.trim($("#sequenceNumber").val());
	achievementQueryModel['name']=$.trim($("#name").val());
	achievementQueryModel['remark']=$.trim($("#remark").val());
	achievementQueryModel['domain']=$.trim($("#domainId").val());
	achievementQueryModel['amount']=$.trim($("#amountId").val());
	achievementQueryModel['phase']=$.trim($("#phaseId").val());
	achievementQueryModel['status']=$.trim($("#statusId").val());
	achievementQueryModel['communicateStatus']=$.trim($("#communicateStatusId").val());
	paramTemp['achievementQueryModel']=achievementQueryModel;
	return paramTemp;
};