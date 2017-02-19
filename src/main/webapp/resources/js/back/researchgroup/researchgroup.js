$(document).ready(function() {
	initBasicResearchField();
	
	//初始化省份
	CommonFunction.initSelectProvince("#province");
	//初始化市
	CommonFunction.initSelectCity("#city");
	
	setSelect();
	
	CommonFunction.selectAll('selectAll', 'researchGroupQueryTBody');
	$(".domain").click(function() {
		text = $("input:checkbox[name='domain']:checked").map(function(index,elem) {
			return $(elem).val();
		}).get().join(',');
		$("#domainId").val(text);
	});
	initresearchGroupManager();
});

function setSelect(){
	$("#province").change(function(){
		     $("#province").val($(this).attr("value")); 
		     var province=$(this).attr("value");
		     $("#city").val("请选择市");
			 $("#city").html("");
			//根据省查省下市
				var provinceCityMap=CommonFunction.tempProvinceCity();
				var listCity=provinceCityMap[province];
				var dd = '<option value=" " selecetd="selected">请选择市</option>';
				for(var i = 0; i < listCity.length; i++) {	
					dd += '<option value="'+listCity[i]+'">' + listCity[i] + '</option>';
				}
				$("#city").html("");
				$("#city").append(dd);
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
			//$("input[name=domain]").checkboxradio('refresh');
		};
		$.ajax(CommonFunction.baseOptions);
	
	
}

function initresearchGroupManager() {
	commonAction();
	query(queryParam);
	$('#searchBtn').click(function() {
		queryParam = getData();
		query(queryParam);
	});
};

function query(param) {
	var that=this;
	queryParam = getData();
	// 清空列表
	$('#researchGroupQueryTBody').html("");
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
			var type=queryReturnList[i].researchUserResultModel.type;
			var name="";
			var provinceName="";
			var cityName="";
			 if(type==="0"){
				 name=queryReturnList[i].researchUserResultModel.uniName;
				 provinceName=queryReturnList[i].researchUserResultModel.uniProvince;
				 cityName=queryReturnList[i].researchUserResultModel.uniCity;
				}else if(type==="1"){
					 name=queryReturnList[i].researchUserResultModel.orgName;
					 provinceName=queryReturnList[i].researchUserResultModel.orgProvince;
					 cityName=queryReturnList[i].researchUserResultModel.orgCity;
				}else if(type==="2"){
					name=queryReturnList[i].researchUserResultModel.orgName;
					 provinceName=queryReturnList[i].researchUserResultModel.orgProvince;
					 cityName=queryReturnList[i].researchUserResultModel.orgCity;
				}
			
			var researchGroupQueryTBodyTr = '<tr class="gradeX">'
				+ '<td><input type="checkbox" /></td>'
				+'<td name="id" class="hidden">'+CommonFunction.replaceNull(queryReturnList[i].id) +'</td>'
				+'<td name="recommendFlag" class="hidden">'+CommonFunction.replaceNull(queryReturnList[i].recommendFlag) +'</td>'
				+'<td name="seqNum" class="hidden">'+CommonFunction.replaceNull(queryReturnList[i].seqNum) +'</td>'
				+'<td>'+CommonFunction.replaceNull(queryReturnList[i].name) +'</td>'
				+ '<td>'+ CommonFunction.setStrDomain(queryReturnList[i].domain) +'</td>'
				+ '<td>'+ CommonFunction.setDetail(queryReturnList[i].introduction) +'</td>'
				+ '<td>'+ CommonFunction.replaceNull(queryReturnList[i].teamSize) +'</td>'
				+ '<td>'+ CommonFunction.replaceNull(queryReturnList[i].field) +'</td>'
				+ '<td>'+ CommonFunction.replaceNull(queryReturnList[i].experience) +'</td>'
				+ '<td>'+ CommonFunction.replaceNull(queryReturnList[i].achievement) +'</td>'
				+ '<td>'+ CommonFunction.replaceNull(queryReturnList[i].leaderName) +'</td>'
				+ '<td>'+ CommonFunction.replaceNull(queryReturnList[i].leaderEmail) +'</td>'
				+ '<td>'+ CommonFunction.replaceNull(queryReturnList[i].leaderTel) +'</td>'
				+ '<td>'+ CommonFunction.replaceNull(queryReturnList[i].leaderDepart) +'</td>'
				+ '<td>'+ CommonFunction.setLeaderTitle(queryReturnList[i].leaderTitle) +'</td>'
				+ '<td>'+ CommonFunction.replaceNull(queryReturnList[i].leaderPosition) +'</td>'
				+ '<td>'+ CommonFunction.setDetail(queryReturnList[i].leaderIntro) +'</td>'
				+ '<td>'+ CommonFunction.replaceNull(queryReturnList[i].leaderAchieve) +'</td>'
				+ '<td>'+ CommonFunction.replaceNull(queryReturnList[i].teamOthers) +'</td>';
				researchGroupQueryTBodyTr += CommonFunction.getAttach(queryReturnList[i].attachUrl);
			    researchGroupQueryTBodyTr = researchGroupQueryTBodyTr 
			    + '<td>'+ CommonFunction.replaceNull(queryReturnList[i].concernNumber) +'</td>'
				+ '<td>'+ CommonFunction.replaceNull(queryReturnList[i].scanNumber) +'</td>'
				+'<td name="status" class="hidden">'+CommonFunction.replaceNull(queryReturnList[i].status) +'</td>'
				+ '<td>'+ CommonFunction.setStatus(queryReturnList[i].status) +'</td>'
				 +'<td name="communicateStatus" class="hidden">'+CommonFunction.replaceNull(queryReturnList[i].communicateStatus) +'</td>'
				+ '<td>'+ CommonFunction.setCommunicateStatus(queryReturnList[i].domain) +'</td>'
				+ '<td class="hidden" name="remark">'+ CommonFunction.replaceNull(queryReturnList[i].remark) +'</td>'
				+ '<td>'+ CommonFunction.setDetail(queryReturnList[i].remark) +'</td>'
				+ '<td>'+ name +'</td>'
				+ '<td>'+ provinceName +'</td>'
				+ '<td>'+ cityName +'</td>'
                + '</tr>';
			$('#researchGroupQueryTBody').append(researchGroupQueryTBodyTr);
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
	userQueryModel['id']=$.trim($("#companyId").val());
	userQueryModel['email']=$.trim($("#email").val());
	paramTemp['userQueryModel']=userQueryModel;
	
	var organizationUserQueryModel={};
	organizationUserQueryModel['orgProvince']=$.trim($("#province").val());
	organizationUserQueryModel['orgCity']=$.trim($("#city").val());
	organizationUserQueryModel['orgName']=$.trim($("#orgName").val());
	paramTemp['organizationUserQueryModel']=organizationUserQueryModel;
	
	
	var universityUserQueryModel={};
	universityUserQueryModel['uniProvince']=$.trim($("#province").val());
	universityUserQueryModel['uniCity']=$.trim($("#city").val());
	universityUserQueryModel['uniName']=$.trim($("#uniName").val());
	paramTemp['universityUserQueryModel']=universityUserQueryModel;
	
	var researchGroupQueryModel={};
	researchGroupQueryModel['name']=$.trim($("#teamName").val());
	researchGroupQueryModel['field']=$.trim($("#field").val());
	researchGroupQueryModel['remark']=$.trim($("#remark").val());
	researchGroupQueryModel['leaderName']=$.trim($("#leaderName").val());
	researchGroupQueryModel['domain']=$.trim($("#domainId").val());
	
	researchGroupQueryModel['status']=$.trim($("#statusId").val());
	researchGroupQueryModel['communicateStatus']=$.trim($("#communicateStatusId").val());
	paramTemp['researchGroupQueryModel']=researchGroupQueryModel;
	//reserachUser里面type
	//paramTemp['type']=$.trim($("#typeId").val());
	return paramTemp;
};