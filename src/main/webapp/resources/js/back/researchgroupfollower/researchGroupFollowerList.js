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
				+ '<td><input type="checkbox" /></td>'
				+'<td name="userId">'+CommonFunction.replaceNull(queryReturnList[i].id.userId) +'</td>'
				+'<td name="researchId">'+CommonFunction.replaceNull(queryReturnList[i].id.researchId) +'</td>'
				+'<td name="relationType" class="hidden">'+ queryReturnList[i].id.relationType +'</td>'
				+'<td>'+ CommonFunction.setRelationType(queryReturnList[i].id.relationType) +'</td>'
				+ '<td>'+ CommonFunction.setFollowerType(queryReturnList[i].followerType) +'</td>'
				+ '<td>'+ CommonFunction.setDetail(queryReturnList[i].content) +'</td>'
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
	researchGroupQueryModel['id']=$.trim($("#researchGroupId").val());
	paramTemp['researchGroupQueryModel']=researchGroupQueryModel;
	
	var userQueryModel={};
	userQueryModel['id']=$.trim($("#companyUserId").val());
	paramTemp['userQueryModel']=userQueryModel;
	
	var researchGroupFollowerQueryModel={};
	setFollowerQueryModel('researchGroupFollower', researchGroupFollowerQueryModel);
	researchGroupFollowerQueryModel['followerType']=$.trim($("#followerTypeId").val());
	researchGroupFollowerQueryModel['communicateStatus']=$.trim($("#communicateStatusId").val());
	researchGroupFollowerQueryModel['remark']=$.trim($("#remark").val());
	paramTemp['researchGroupFollowerQueryModel']=researchGroupFollowerQueryModel;
	return paramTemp;
};

function modalDialogInitDiv() {
	//没有勾选复选框
	$('#noselect-open-modal').click(function() {
	});
	//只能选一条记录
	$('#onlyoneselect-open-modal').click(function() {
	});
	//删除确认复选框
	$('#confirm-delete-open-dialog').click(function() {
	});
	//审核dialogform
	$('#review-open-dialog').click(function() {
	});
	//调后台返回
	$('#returnInfo-open-modal').click(function() {
	});
	
	//删除submit
	$("#confirmDeleteDialog").dialog({
 		autoOpen: false,
 		width: 600,
 		buttons: {
 			"确定": function () {
 				$(this).dialog("close");
 				var idArray = [];
 				 $('tbody input:checked').each(function(){  
 					var userId=$(this).parents('tr').find('[name=userId]').html();
 					var researchId=$(this).parents('tr').find('[name=researchId]').html();
 					 idArray.push("{userId:"+userId+","+"researchId:"+researchId+"}");
 				 });
 				var url = $('#removeBtn').attr('url');
 				var deleteParam = {};
 				deleteParam['str']=idArray.join(",").replace(",,","");
 				CommonFunction.baseOptions['url'] = url;
 				CommonFunction.baseOptions['data'] = deleteParam;
 				CommonFunction.baseOptions['success'] = function(datas) {
 				    CommonFunction.processResult('delete',datas,"#returnInfo-open-modal","#returnInfo");
	 				CommonFunction.reQuery(datas, 'tbody input:checked', '#searchBtn');
 				};
 				$.ajax(CommonFunction.baseOptions);
 				
 			},
 			"取消": function () {
 				$(this).dialog("close");
 				return;
 			}
 		}
 	});
	
	//审核submit
	$("#reviewDialog").dialog({
 		autoOpen: false,
 		width: 600,
 		buttons: {
 			"确定": function () {
 				$(this).dialog("close");
 				var userId=$('tbody input:checked').eq(0).parents('tr').find('[name=userId]').html();
 				var researchId=$('tbody input:checked').eq(0).parents('tr').find('[name=researchId]').html();
 				var url = $('#reviewBtn').attr('url');
 				var reviewParam = {};
 				var param = {};
 				var idList = [];
 				var pkParam = {};
 				pkParam['userId']=userId;
 				pkParam['researchId']=researchId;
 				idList[0]=pkParam;
 				param['idList'] =idList;
 				param['status']=$("#reviewStatusId").val();
 				param['communicateStatus']=$("#reviewCommunicateStatusId").val();
 				param['remark']=$('#reviewRemark').val();
 				var jsonStr=JSON.stringify(param);
 				reviewParam['str']= jsonStr;
 				CommonFunction.baseOptions['url'] = url;
 				CommonFunction.baseOptions['data'] = reviewParam;
 				CommonFunction.baseOptions['success'] = function(datas) {
	 				CommonFunction.processResult('review',datas,"#returnInfo-open-modal","#returnInfo");
	 				CommonFunction.reQuery(datas, 'tbody input:checked', '#searchBtn');
 				};
 				$.ajax(CommonFunction.baseOptions);
 				
 			},
 			"取消": function () {
 				$(this).dialog("close");
 				return;
 			}
 		}
 	});
	
};

function deleteresearchGroupFollower() {
	var userId=$('tbody input:checked').eq(0).parents('tr').find('[name=userId]').html();
	var researchId=$('tbody input:checked').eq(0).parents('tr').find('[name=researchId]').html();
	if ($('tbody input:checked').length === 0||userId===null || userId===""||researchId===null || researchId==="") {
		$('#noselect-open-modal').click();
		return;
    }else{
	 $('#confirm-delete-open-dialog').click();
	}
};

function toUpdateresearchGroupFollower(){
	
	var id=$('tbody input:checked').eq(0).parents('tr').find('[name=id]').html();
	if ($('tbody input:checked').length === 0||id===null || id==="") {
		$('#noselect-open-modal').click();
		return;
    }
    window.location.href='researchGroupFollowerUpdate.html?id='+id;
}

function toReviewresearchGroupFollower(){
	var userId=$('tbody input:checked').eq(0).parents('tr').find('[name=userId]').html();
	var researchId=$('tbody input:checked').eq(0).parents('tr').find('[name=researchId]').html();
	if ($('tbody input:checked').length === 0||userId===null || userId===""||researchId===null || researchId==="") {
		$('#noselect-open-modal').click();
		return;
    }
	var status=$('tbody input:checked').eq(0).parents('tr').find('[name=status]').html();
	var communicateStatus=$('tbody input:checked').eq(0).parents('tr').find('[name=communicateStatus]').html();
	var remark=$('tbody input:checked').eq(0).parents('tr').find('[name=remark]').html();
	$('#review-open-dialog').click();
	//重新赋值前把上一次清空
	$("#reviewstatus0").attr("checked", false);
	$("#reviewstatus1").attr("checked", false);
	$("#reviewstatus2").attr("checked", false);
	
	$("#reviewCommunicateStatus0").attr("checked", false);
	$("#reviewCommunicateStatus1").attr("checked", false);
	$("#reviewCommunicateStatus2").attr("checked", false);
	$("#reviewCommunicateStatus3").attr("checked", false);
	$("#reviewCommunicateStatus4").attr("checked", false);
	$('#reviewRemark').val("");
	
	//审核状态
	if(status==="0"){
		$('#reviewStatusId').val("0");
		$("#reviewstatus0").attr("checked", true);
	 }else if(status==="1"){
		 $('#reviewStatusId').val("1");
		 $("#reviewstatus1").attr("checked", true);
	 }else if(status==="2"){
		 $('#reviewStatusId').val("2");
		 $("#reviewstatus2").attr("checked", true);
	 } 
	
	
	//沟通状态
	 if(communicateStatus==="0"){
		 $("#reviewCommunicateStatus0").attr("checked", true);
		 $('#reviewCommunicateStatusId').val("0");
	 }else if(communicateStatus==="1"){
		 $("#reviewCommunicateStatus1").attr("checked", true);
		 $('#reviewCommunicateStatusId').val("1");
	 }else if(communicateStatus==="2"){
		 $("#reviewCommunicateStatus2").attr("checked", true);
		 $('#reviewCommunicateStatusId').val("2");
	 }else if(communicateStatus==="3"){
		 $("#reviewCommunicateStatus3").attr("checked", true);
		 $('#reviewCommunicateStatusId').val("3");
	 }else if(communicateStatus==="4"){
		 $("#reviewCommunicateStatus4").attr("checked", true);
		 $('#reviewCommunicateStatusId').val("4");
	 }
	$('#reviewRemark').val(remark);
	
}
