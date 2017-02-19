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
};

function initRequirementManager() {
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
				+'<td>'+CommonFunction.replaceNull(queryReturnList[i].companyUserResultModel.id) +'</td>'
				+'<td>'+CommonFunction.replaceNull(queryReturnList[i].companyUserResultModel.name) +'</td>'
				+ '<td>'+ CommonFunction.replaceNull(queryReturnList[i].companyUserResultModel.province)+'/'+CommonFunction.replaceNull(queryReturnList[i].companyUserResultModel.city) +'</td>'
				+'<td>'+CommonFunction.replaceNull(queryReturnList[i].name) +'</td>'
				+ '<td>'+ CommonFunction.setStrDomain(queryReturnList[i].domain) +'</td>'
				+ '<td>'+ CommonFunction.replaceNull(queryReturnList[i].contactName) +'</td>'
	            + '<td>'+ CommonFunction.replaceNull(queryReturnList[i].contactTel) +'</td>'
	            + '<td>'+ CommonFunction.replaceNull(queryReturnList[i].contactEmail) +'</td>'
	            + '<td>'+ CommonFunction.setStrAmount(queryReturnList[i].amount) +'</td>'
				+ '<td>'+ CommonFunction.setDuration(queryReturnList[i].duration) +'</td>'
				+ '<td>'+ CommonFunction.setStrType(queryReturnList[i].type) +'</td>'
                + '<td>'+ CommonFunction.setDetail(queryReturnList[i].detail) +'</td>'
                + '<td>'+ CommonFunction.setStrCooperationType(queryReturnList[i].cooperationType) +'</td>'
                + '<td>'+ CommonFunction.setDetail(queryReturnList[i].similarProduct) +'</td>'
                + '<td>'+ CommonFunction.replaceNull(queryReturnList[i].sequenceNumber) +'</td>'
                +'<td name="status" class="hidden">'+CommonFunction.replaceNull(queryReturnList[i].status) +'</td>'
                + '<td>'+ CommonFunction.setRequirementStatus(queryReturnList[i].status) +'</td>'
                +'<td name="communicateStatus" class="hidden">'+CommonFunction.replaceNull(queryReturnList[i].communicateStatus) +'</td>'
                + '<td>'+ CommonFunction.setCommunicateStatus(queryReturnList[i].communicateStatus) +'</td>'
                + '<td class="hidden" name="remark">'+ CommonFunction.replaceNull(queryReturnList[i].remark) +'</td>'
                + '<td>'+ CommonFunction.setDetail(queryReturnList[i].remark) +'</td>'
                + '<td>'+ CommonFunction.replaceNull(queryReturnList[i].concernNumber) +'</td>'
                + '<td>'+ CommonFunction.replaceNull(queryReturnList[i].scanNumber) +'</td>';
				requirementQueryTBodyTr += CommonFunction.getAttach(queryReturnList[i].attachUrl);
				requirementQueryTBodyTr += '</tr>';
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
	
	var techRequirementQueryModel={};
	techRequirementQueryModel['sequenceNumber']=$.trim($("#sequenceNumber").val());
	techRequirementQueryModel['name']=$.trim($("#name").val());
	techRequirementQueryModel['contactName']=$.trim($("#contactName").val());
	techRequirementQueryModel['remark']=$.trim($("#remark").val());
	techRequirementQueryModel['domain']=$.trim($("#domainId").val());
	techRequirementQueryModel['status']=$.trim($("#statusId").val());
	techRequirementQueryModel['communicateStatus']=$.trim($("#communicateStatusId").val());
	techRequirementQueryModel['type']=$.trim($("#typeId").val());
	techRequirementQueryModel['amount']=$.trim($("#amountId").val());
	techRequirementQueryModel['cooperationType']=$.trim($("#cooperationTypeId").val());
	paramTemp['techRequirementQueryModel']=techRequirementQueryModel;
	return paramTemp;
};