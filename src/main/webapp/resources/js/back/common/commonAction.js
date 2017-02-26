function setFollowerQueryModel(type, param) {
	if(type == 'investorFollower') {
		var investorUserFollowerIdQueryModel = {};
		investorUserFollowerIdQueryModel['relationType']=$.trim($("#relationTypeId").val());
		param['investorUserFollowerIdQueryModel']=investorUserFollowerIdQueryModel;
	}
	if(type == 'researchGroupFollower') {
		var researchGroupFollowerIdQueryModel = {};
		researchGroupFollowerIdQueryModel['relationType']=$.trim($("#relationTypeId").val());
		param['researchGroupFollowerIdQueryModel']=researchGroupFollowerIdQueryModel;
	}
	if(type == 'achievementFollower') {
		var achievementFollowerIdQueryModel = {};
		achievementFollowerIdQueryModel['relationType']=$.trim($("#relationTypeId").val());
		param['achievementFollowerIdQueryModel']=achievementFollowerIdQueryModel;
	}
	if(type == 'techRequirementFollower') {
		var techRequirementFollowerIdQueryModel = {};
		techRequirementFollowerIdQueryModel['relationType']=$.trim($("#relationTypeId").val());
		param['techRequirementFollowerIdQueryModel']=techRequirementFollowerIdQueryModel;
	}
	if(type == 'fundRequirementFollower') {
		var fundRequirementFollowerIdQueryModel = {};
		fundRequirementFollowerIdQueryModel['relationType']=$.trim($("#relationTypeId").val());
		param['fundRequirementFollowerIdQueryModel']=fundRequirementFollowerIdQueryModel;
	}
};

function getFollowerId(type, param) {
	var followId = {};
	if(type == 'investorFollower') {
		followId['investorId']=param.find('[name=investorId]').html();
		followId['userId']=param.find('[name=userId]').html();
		followId['relationType']=$(param).find('[name=relationType]').html();
	}
	if(type == 'researchGroupFollower') {
		followId['researchId']=$(param).find('[name=researchId]').html();
		followId['userId']=$(param).find('[name=userId]').html();
		followId['relationType']=$(param).find('[name=relationType]').html();
	}
	if(type == 'achievementFollower') {
		followId['achievementId']=$(param).find('[name=achievementId]').html();
		followId['userId']=$(param).find('[name=userId]').html();
		followId['relationType']=$(param).find('[name=relationType]').html();
	}
	if(type == 'techRequirementFollower') {
		followId['requirementId']=$(param).find('[name=requirementId]').html();
		followId['userId']=$(param).find('[name=userId]').html();
		followId['relationType']=$(param).find('[name=relationType]').html();
	}
	if(type == 'fundRequirementFollower') {
		followId['requirementId']=$(param).find('[name=requirementId]').html();
		followId['userId']=$(param).find('[name=userId]').html();
		followId['relationType']=$(param).find('[name=relationType]').html();
	}
	
	return followId;
};

function commonFollowerAction(type) {
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
	$('#reviewstatus0').click();
	$('#reviewCommunicateStatus0').click();
	
	$('#removeBtn').click(function() {
		deleteinvestorUser();
	});
	$('#reviewBtn').click(function() {
		toReviewinvestorUser();
	});
	
	//删除submit
	$("#confirmDeleteDialog").dialog({
 		autoOpen: false,
 		width: 600,
 		buttons: {
 			"确定": function () {
 				$(this).dialog("close");
 				var idList = [];
 				var i = 0;
 				 $('tbody input:checked').each(function(){ 
 					var userId = $(this).parents('tr').find('[name=userId]').html();
 					if(userId != '' && userId != null) {
 						 idList[i] = getFollowerId(type, $(this).parents('tr'));
 	 					 i++; 
 					 }
 				 });
 				var url = $('#removeBtn').attr('url');
 				var deleteParam = {};
 				deleteParam['str']=JSON.stringify(idList);
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
 				var status = $('input:radio[name="reviewstatus"]:checked').val();
 				var communicateStatus = $('input:radio[name="reviewcommunicateStatus"]:checked').val();
 				var remark = $('#reviewRemark').val();
 				
 				var idList = [];
 			    var i = 0;
 				$('tbody input:checked').each(function() {
 					var userId = $(this).parents('tr').find('[name=userId]').html();
 					if(userId != '' && userId != null) {
 						idList[i] = getFollowerId(type, $(this).parents('tr'));
 					 	i++;
 					}
 				});
 				var url = $('#reviewBtn').attr('url');
 				
 				var reviewParam = {};
 				var param = {};
 				param['idList'] =idList;
 				param['communicateStatus']=communicateStatus;
 				param['remark']=remark;
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

function commonAction() {
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
	//推荐
	$('#recommend-open-dialog').click(function() {
	});
	//调后台返回
	$('#returnInfo-open-modal').click(function() {
	});
	$('#reviewstatus0').click();
	$('#reviewCommunicateStatus0').click();
		
	$('#removeBtn').click(function() {
		deleteinvestorUser();
	});
	$('#reviewBtn').click(function() {
		toReviewinvestorUser();
	});
	$('#recommendBtn').click(function() {
		toRecommendBtn();
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
 					 idArray.push($(this).parents('tr').find('[name=id]').html());
 				 });
 				var url = $('#removeBtn').attr('url');
 				var deleteParam = {};
 				deleteParam['str']=JSON.stringify(idArray);
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
 				var status = $('input:radio[name="reviewstatus"]:checked').val();
 				var communicateStatus = $('input:radio[name="reviewcommunicateStatus"]:checked').val();
 				var remark = $('#reviewRemark').val();
 				
 				var idList = [];
 			    var i = 0;
 				$('tbody input:checked').each(function() {
 					var tmp = $(this).parents('tr').find('[name=id]').html();
 					if(tmp != '' && tmp != null){
 						idList[i] = tmp;
 						i++;
 					}
 				});
 				var url = $('#reviewBtn').attr('url');
 				
 				var reviewParam = {};
 				var param = {};
 				param['idList'] =idList;
 				param['status']=status;
 				param['communicateStatus']=communicateStatus;
 				param['remark']=remark;
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
	
	//推荐submit
	$("#recommendDialog").dialog({
 		autoOpen: false,
 		width: 600,
 		buttons: {
 			"确定": function () {
 				$(this).dialog("close");
 				
 				var reviewParam = {};
 				var param = {};
 				var idList = [];
 			    var i = 0;
 				$('tbody input:checked').each(function() {
 					var tmp = $(this).parents('tr').find('[name=id]').html();
 					if(tmp != '' && tmp != null){
 						idList[i] = tmp;
 						i++;
 					}
 				});
 				var recommendFlag = $('input:radio[name="recommendstatus"]:checked').val();
 				param['idList'] =idList;
 				param['recommendFlag']=recommendFlag;
 				param['seqNum']=$("#recommendSeq").val();
 				var jsonStr=JSON.stringify(param);
 				reviewParam['str']= jsonStr;
 				
 				var url = $('#recommendBtn').attr('url');
 				CommonFunction.baseOptions['url'] = url;
 				CommonFunction.baseOptions['data'] = reviewParam;
 				CommonFunction.baseOptions['success'] = function(datas) {
	 				CommonFunction.processResult('recommend',datas,"#returnInfo-open-modal","#returnInfo");
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

function deleteinvestorUser() {
	if ($('tbody input:checked').length === 0) {
		$('#noselect-open-modal').click();
		return;
    }else{
	 $('#confirm-delete-open-dialog').click();
	}
};

function toRecommendBtn(){
	if ($('tbody input:checked').length === 0) {
		$('#noselect-open-modal').click();
		return;
    }
	$('#recommend-open-dialog').click();
};

function toReviewinvestorUser(){
	if ($('tbody input:checked').length === 0) {
		$('#noselect-open-modal').click();
		return;
    }
	$('#review-open-dialog').click();
};
