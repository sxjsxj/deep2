$(document).ready(function() {
	CommonFunction.selectAll('selectAll', 'researchUserQueryTBody');
	//初始化省份
	CommonFunction.initSelectProvince("#province");
	//初始化市
	CommonFunction.initSelectCity("#city");
	setSelect();
	initresearchUserManager();
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


function initresearchUserManager() {
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
	$('#researchUserQueryTBody').html("");
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
			var researchUserQueryTBodyTr = '<tr class="gradeX">'
				+ '<td><input type="checkbox" /></td>'
				+'<td name="id" class="hidden">'+CommonFunction.replaceNull(queryReturnList[i].id) +'</td>'
				+'<td>'+CommonFunction.replaceNull(queryReturnList[i].uniName) +'</td>'
				+ '<td>'+ CommonFunction.replaceNull(queryReturnList[i].uniProvince) +'</td>'
				+ '<td>'+ CommonFunction.replaceNull(queryReturnList[i].uniCity) +'</td>'
				+ '<td>'+ CommonFunction.replaceNull(queryReturnList[i].address) +'</td>'
				+ '<td>'+ CommonFunction.replaceNull(queryReturnList[i].introduction) +'</td>'
				+ '<td>'+ CommonFunction.replaceNull(queryReturnList[i].uniDepartment) +'</td>'
                + '<td>'+ CommonFunction.replaceNull(queryReturnList[i].uniLevel) +'</td>'
                + '<td>'+ CommonFunction.replaceNull(queryReturnList[i].uniNature) +'</td>'
                + '<td>'+ CommonFunction.setDeclare(queryReturnList[i].uniProject211,queryReturnList[i].uniProject985,queryReturnList[i].uniNationalPriority) +'</td>'
                + '<td>'+ CommonFunction.replaceNull(queryReturnList[i].userModel.id) +'</td>'
                + '<td>'+ CommonFunction.replaceNull(queryReturnList[i].userModel.email) +'</td>'
                + '<td>'+ CommonFunction.replaceNull(queryReturnList[i].userModel.telno) +'</td>'
				+ '<td>'+ CommonFunction.setStatus(queryReturnList[i].status) +'</td>'
                + '<td>'+ CommonFunction.setCommunicateStatus(queryReturnList[i].communicateStatus) +'</td>'
                + '<td>'+ CommonFunction.setRemark(queryReturnList[i].userModel.remark) +'</td>'
                + '<td>'+ CommonFunction.getDate(queryReturnList[i].userModel.whenCreate) +'</td>'
                + '<td>'+ CommonFunction.getDate(queryReturnList[i].userModel.whenLastLogin) +'</td>'
                + '<td>'+ CommonFunction.setRemoveFlag(queryReturnList[i].removeFlag) +'</td>'
                + '</tr>';
			$('#researchUserQueryTBody').append(researchUserQueryTBodyTr);
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
	userQueryModel['id']=$.trim($("#id").val());
	userQueryModel['email']=$.trim($("#email").val());
	userQueryModel['telno']=$.trim($("#telno").val());
	userQueryModel['remark']=$.trim($("#remark").val());
	userQueryModel['status']=$("#statusId").val();//审核状态
	userQueryModel['communicateStatus']=$("#communicateStatusId").val();//沟通状态
	paramTemp['userQueryModel']=userQueryModel;
	
	var universityUserQueryModel={};
	universityUserQueryModel['uniName']=$.trim($("#name").val());
	universityUserQueryModel['uniProject211']=$.trim($("#project211Id").val());
	universityUserQueryModel['uniProject985']=$.trim($("#project985Id").val());
	universityUserQueryModel['uniLevel']=$.trim($("#levelId").val());
	
	paramTemp['universityUserQueryModel']=universityUserQueryModel;
	
	var organizationUserQueryModel={};
	organizationUserQueryModel['orgName']=$.trim($("#name").val());
	organizationUserQueryModel['orgProvince']=$.trim($("#province").val());
	organizationUserQueryModel['orgCity']=$.trim($("#city").val());
	paramTemp['organizationUserQueryModel']=organizationUserQueryModel;
	//这个查询model里没有
	//paramTemp['type']=$("#typeId").val();
	return paramTemp;
};