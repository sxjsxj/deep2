$(document).ready(function() {
	initBasicResearchField();
	CommonFunction.selectAll('selectAll', 'investorUserQueryTBody');
	//初始化省份
	CommonFunction.initSelectProvince("#province");
	//初始化市
	CommonFunction.initSelectCity("#city");
	
	setSelect();
	initinvestorUserManager();
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
};

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


var queryParam = {};
function initinvestorUserManager() {
	commonAction();
	$(".domain").click(function() {
		text = $("input:checkbox[name='domain']:checked").map(function(index,elem) {
			return $(elem).val();
		}).get().join(',');
		$("#domainId").val(text);
	});
	$('#searchBtn').click(function() {
		queryParam = getData();
		query(queryParam);
	});
	query(queryParam);
};

function query(param) {
	var that=this;
	// 清空列表
	$('#investorUserQueryTBody').html("");
	$('#noResult').html('');
	$('#pagination').html('');
	var url = $('#searchBtn').attr('url');
	CommonFunction.baseOptions['url'] = url;
	if (param === null) {
		var requestParamTemp = {};
		requestParamTemp['str']="";
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
			var investorUserQueryTBodyTr = '<tr class="gradeX">'
				+ '<td><input type="checkbox" /></td>'
				+'<td name="id" class="hidden">'+CommonFunction.replaceNull(queryReturnList[i].id) +'</td>'
				+'<td name="recommendFlag" class="hidden">'+CommonFunction.replaceNull(queryReturnList[i].recommendFlag) +'</td>'
				+'<td name="seqNum" class="hidden">'+CommonFunction.replaceNull(queryReturnList[i].seqNum) +'</td>'
				+'<td>'+CommonFunction.replaceNull(queryReturnList[i].userModel.id) +'</td>'
				+'<td>'+CommonFunction.replaceNull(queryReturnList[i].userModel.email) +'</td>'
				+'<td>'+CommonFunction.replaceNull(queryReturnList[i].userModel.telno) +'</td>'
				+'<td>'+CommonFunction.getDate(queryReturnList[i].userModel.whenCreate) +'</td>'
				+'<td>'+CommonFunction.getDate(queryReturnList[i].userModel.whenLastLogin) +'</td>'
				 +'<td name="status" class="hidden">'+CommonFunction.replaceNull(queryReturnList[i].status) +'</td>'
				+'<td>'+CommonFunction.setStatus(queryReturnList[i].status) +'</td>'
				 +'<td name="communicateStatus" class="hidden">'+CommonFunction.replaceNull(queryReturnList[i].communicateStatus) +'</td>'
				+'<td>'+CommonFunction.setCommunicateStatus(queryReturnList[i].communicateStatus) +'</td>'
				  + '<td class="hidden" name="remark">'+ CommonFunction.replaceNull(queryReturnList[i].userModel.remark) +'</td>'
				+'<td>'+CommonFunction.replaceNull(queryReturnList[i].userModel.remark) +'</td>'
				+ '<td>'+ CommonFunction.replaceNull(queryReturnList[i].name) +'</td>'
				+ '<td>'+ CommonFunction.replaceNull(queryReturnList[i].province) +'</td>'
	            + '<td>'+ CommonFunction.replaceNull(queryReturnList[i].city) +'</td>'
	            + '<td>'+ CommonFunction.replaceNull(queryReturnList[i].county) +'</td>'
	            + '<td>'+ CommonFunction.setScale(queryReturnList[i].scale) +'</td>'
	            + '<td>'+ CommonFunction.setDetail(queryReturnList[i].address) +'</td>'
	            + '<td>'+ CommonFunction.setDetail(queryReturnList[i].introduction) +'</td>'
	            + '<td>'+ CommonFunction.replaceNull(queryReturnList[i].contactName) +'</td>'
	            + '<td>'+ CommonFunction.replaceNull(queryReturnList[i].contactTel) +'</td>'
	            + '<td>'+ CommonFunction.replaceNull(queryReturnList[i].contactEmail) +'</td>'
	            + '<td>'+ CommonFunction.replaceNull(queryReturnList[i].contactTitle) +'</td>'
	            + '<td>'+ CommonFunction.setStrDomain(queryReturnList[i].investDomain) +'</td>'
	            + '<td>'+ CommonFunction.setStrAmount(queryReturnList[i].investAmount) +'</td>'
	            + '<td>'+ CommonFunction.setStrPhase(queryReturnList[i].investPhase) +'</td>'
	            + '<td>'+ CommonFunction.setStrCooperationType(queryReturnList[i].cooperationType) +'</td>'
				+ '<td>'+ CommonFunction.setStrInvestType(queryReturnList[i].investType) +'</td>'
                + '<td>'+ CommonFunction.replaceNull(queryReturnList[i].fundType) +'</td>'
                + '<td>'+ CommonFunction.replaceNull(queryReturnList[i].investArea) +'</td>'
                + '<td>'+ CommonFunction.setDetail(queryReturnList[i].investOutline) +'</td>';
                investorUserQueryTBodyTr += CommonFunction.getAttach(queryReturnList[i]);
				investorUserQueryTBodyTr += '</tr>';
			$('#investorUserQueryTBody').append(investorUserQueryTBodyTr);
		}
		if (queryReturnList.length !== 0) {
			CommonFunction.pagination(datas.pagination.sumPage, '#currentPage', '#pagination', that, 'query');
		}
	};
	$.ajax(CommonFunction.baseOptions);
};

function getData() {
	var paramTemp = {};
	var userQueryModel={};
	userQueryModel['id']=$.trim($("#userId").val());
	userQueryModel['email']=$.trim($("#userEmail").val());
	userQueryModel['telno']=$.trim($("#userTelno").val());
	userQueryModel['remark']=$.trim($("#remark").val());
	userQueryModel['status']=$.trim($("#statusId").val());
	userQueryModel['communicateStatus']=$.trim($("#communicateStatusId").val());
	paramTemp['userQueryModel']=userQueryModel;
	
	var investorUserQueryModel={};
	investorUserQueryModel['type']=$.trim($("#typeId").val());
	investorUserQueryModel['name']=$.trim($("#name").val());
	investorUserQueryModel['contactName']=$.trim($("#contactName").val());
	investorUserQueryModel['investDomain']=$.trim($("#domainId").val());
	investorUserQueryModel['province']=$.trim($("#province").val());
	investorUserQueryModel['city']=$.trim($("#city").val());
	investorUserQueryModel['county']=$.trim($("#county").val());
	investorUserQueryModel['investAmount']=$.trim($("#amountId").val());
	investorUserQueryModel['investPhase']=$.trim($("#phaseId").val());
	investorUserQueryModel['investAmount']=$.trim($("#amountId").val());
	paramTemp['investorUserQueryModel']=investorUserQueryModel;
	return paramTemp;
};
