$(document).ready(function() {
	initBasicResearchField();
	//初始化省份
	CommonFunction.initSelectProvince("#province");
	//初始化市
	CommonFunction.initSelectCity("#city");
	
	setSelect();
	CommonFunction.selectAll('selectAll', 'requirementQueryTBody');
	$(".domain").click(function() {
		text = $("input:checkbox[name='domain']:checked").map(function(index,elem) {
			return $(elem).val();
		}).get().join(',');
		$("#domainId").val(text);
	});
	initRequirementManager();
});

function setSelect(){
	$("#province").change(function(){
		     $("#province").val($(this).attr("value")); 
		     var province=$(this).attr("value");
		     $("#city").val("请选择市");
			 $("#city").html("");
			 $("#county").val("请选择县");
			 $("#county").html("");
			//根据省查省下市
				var provinceCityMap=CommonFunction.tempProvinceCity();
				var listCity=provinceCityMap[province];
				var dd = '<option value=" " selecetd="selected">请选择市</option>';
				for(var i = 0; i < listCity.length; i++) {	
					dd += '<option value="'+listCity[i]+'">' + listCity[i] + '</option>';
				}
				$("#city").html("");
				$("#city").append(dd);
				$("#city").click(function(){
					 $("#city").val($(this).attr("value")); 
					 var city=$(this).attr("value");
						$("#county").html("");
						//根据市查县
						var cityCountyMap=CommonFunction.tempCityCounty();
						var listCounty=cityCountyMap[city];
						var dd = '<option value=" " selecetd="selected">请选择县</option>';
						for(var i = 0; i < listCounty.length; i++) {	
							dd += '<option value="'+listCounty[i]+'">' + listCounty[i] + '</option>';
						}
						$("#county").html("");
						$("#county").append(dd);
						$("#county").click(function(){
							 $("#county").val($(this).attr("value")); 
						});
				});
	});
}


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

function initRequirementManager() {
	commonAction();
	query(queryParam);
	$('#searchBtn').click(function() {
		queryParam = getData();
		query(queryParam);
	});
};

function query(param) {
	param = getData();
	var that=this;
	// 清空列表
	$('#requirementQueryTBody').html("");
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
			var requirementQueryTBodyTr = '<tr class="gradeX">'
				+ '<td><input type="checkbox" /></td>'
				+'<td name="id" class="hidden">'+CommonFunction.replaceNull(queryReturnList[i].id) +'</td>'
				+'<td name="recommendFlag" class="hidden">'+CommonFunction.replaceNull(queryReturnList[i].recommendFlag) +'</td>'
				+'<td name="seqNum" class="hidden">'+CommonFunction.replaceNull(queryReturnList[i].seqNum) +'</td>'
				+'<td>'+CommonFunction.replaceNull(queryReturnList[i].id) +'</td>'
				+'<td>'+CommonFunction.replaceNull(queryReturnList[i].name) +'</td>'
				+'<td>'+CommonFunction.replaceNull(queryReturnList[i].companyUserResultModel.id) +'</td>'
				+'<td>'+CommonFunction.replaceNull(queryReturnList[i].companyUserResultModel.name) +'</td>'
				+ '<td>'+ CommonFunction.replaceNull(queryReturnList[i].companyUserResultModel.province)+'/'+CommonFunction.replaceNull(queryReturnList[i].companyUserResultModel.city) +'</td>'
				+ '<td>'+ CommonFunction.setStrDomain(queryReturnList[i].domain) +'</td>'
				+ '<td>'+ CommonFunction.replaceNull(queryReturnList[i].contactName) +'</td>'
	            + '<td>'+ CommonFunction.replaceNull(queryReturnList[i].contactTel) +'</td>'
	            + '<td>'+ CommonFunction.replaceNull(queryReturnList[i].contactEmail) +'</td>'
	            + '<td>'+ CommonFunction.replaceNull(queryReturnList[i].projectName) +'</td>'
	            + '<td>'+ CommonFunction.setDetail(queryReturnList[i].projectTeam) +'</td>'
	            + '<td>'+ CommonFunction.setDetail(queryReturnList[i].projectIntro) +'</td>'
	            + '<td>'+ CommonFunction.setStrPhase(queryReturnList[i].projectPhase) +'</td>'
	            + '<td>'+ CommonFunction.setDetail(queryReturnList[i].projectProspect) +'</td>'
	            + '<td>'+ CommonFunction.setStrAmount(queryReturnList[i].amountNeeded) +'</td>'
				+ '<td>'+ CommonFunction.replaceNull(queryReturnList[i].sequenceNumber) +'</td>'
				+ CommonFunction.getAttach(queryReturnList[i])
                + '<td>'+ CommonFunction.setRequirementStatus(queryReturnList[i].status) +'</td>'
                + '<td>'+ CommonFunction.setCommunicateStatus(queryReturnList[i].communicateStatus) +'</td>'
                + '<td>'+ CommonFunction.setDetail(queryReturnList[i].remark) +'</td>'
                + '<td>'+ CommonFunction.replaceNull(queryReturnList[i].concernNumber) +'</td>'
                + '<td>'+ CommonFunction.replaceNull(queryReturnList[i].scanNumber) +'</td>'
                + '<td>'+ CommonFunction.setRemoveFlag(queryReturnList[i].removeFlag) +'</td>'
                + '</tr>';
			$('#requirementQueryTBody').append(requirementQueryTBodyTr);
		}
		if (queryReturnList.length !== 0) {
			CommonFunction.pagination(datas.pagination.sumPage, '#currentPage', '#pagination', that, 'query');
		}
		
	};
	$.ajax(CommonFunction.baseOptions);
	
};

function getData() {
	
	var paramTemp = {};
	var companyUserQueryModel={};
	companyUserQueryModel['id']=$.trim($("#companyId").val());
	companyUserQueryModel['name']=$.trim($("#companyName").val());
	companyUserQueryModel['province']=$.trim($("#province").val());
	companyUserQueryModel['city']=$.trim($("#city").val());
	companyUserQueryModel['county']=$.trim($("#county").val());
	paramTemp['companyUserQueryModel']=companyUserQueryModel;
	
	var fundRequirementQueryModel={};
	fundRequirementQueryModel['id']=$.trim($("#fundRequireId").val());
	fundRequirementQueryModel['sequenceNumber']=$.trim($("#sequenceNumber").val());
	fundRequirementQueryModel['name']=$.trim($("#name").val());
	fundRequirementQueryModel['contactName']=$.trim($("#contactName").val());
	fundRequirementQueryModel['remark']=$.trim($("#remark").val());
	fundRequirementQueryModel['domain']=$.trim($("#domainId").val());
	fundRequirementQueryModel['status']=$.trim($("#statusId").val());
	fundRequirementQueryModel['communicateStatus']=$.trim($("#communicateStatusId").val());
	fundRequirementQueryModel['amountNeeded']=$.trim($("#amountId").val());
	fundRequirementQueryModel['projectPhase']=$.trim($("#projectPhaseId").val());
	paramTemp['fundRequirementQueryModel']=fundRequirementQueryModel;
	return paramTemp;
};