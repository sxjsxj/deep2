
/**
 * 获取查询的默认值
 * @param subType 
 * 1 -- 公众查询，仅查询审核通过的。
 * 2 -- 自己查询，查询所有状态的。
 * 3 -- 我的推荐，推荐标识为推荐，状态都是审核通过的。
 * 4 -- 我的收藏/关注，查询审核通过的。。。
 * 5 -- 所有
 * @param queryParam
 */
function getDefaultQuery(type, subType, queryParam) {
	if(type == 'user'){
		if(subType == '1') {
			queryParam['status'] = '1';
			queryParam['removeFlag'] = '0';
		} else if(subType == '2') {
			queryParam['status'] = '0,1,2';
			queryParam['removeFlag'] = '0';
		}else if(subType == '3') {
			queryParam['status'] = '1';
			queryParam['removeFlag'] = '0';
		} else if(subType == '4') {
			queryParam['status'] = '1';
			queryParam['removeFlag'] = '0';
		}else if(subType == '5') {
			queryParam['status'] = '0,1,2';
			queryParam['removeFlag'] = '0,1';
		}
	}
	if(type == 'researchUser'){
		if(subType == '1') {
			queryParam['status'] = '1';
			queryParam['removeFlag'] = '0';
		} else if(subType == '2') {
			queryParam['status'] = '0,1,2';
			queryParam['removeFlag'] = '0';
		}else if(subType == '3') {
			queryParam['status'] = '1';
			queryParam['removeFlag'] = '0';
		} else if(subType == '4') {
			queryParam['status'] = '1';
			queryParam['removeFlag'] = '0';
		}else if(subType == '5') {
			queryParam['status'] = '0,1,2';
			queryParam['removeFlag'] = '0,1';
		}
	} 
	if(type == 'researchGroup'){
		if(subType == '1') {
			queryParam['status'] = '1';
			queryParam['removeFlag'] = '0';
		} else if(subType == '2') {
			queryParam['status'] = '0,1,2';
			queryParam['removeFlag'] = '0';
		}else if(subType == '3') {
			queryParam['status'] = '1';
			queryParam['removeFlag'] = '0';
			//queryParam['recommendFlag'] = '1';
		} else if(subType == '4') {
			queryParam['status'] = '1';
			queryParam['removeFlag'] = '0';
		}else if(subType == '5') {
			queryParam['status'] = '0,1,2';
			queryParam['removeFlag'] = '0,1';
		}
	} 
	if(type == 'achievement'){
		if(subType == '1') {
			queryParam['status'] = '1,2,3,4';
			queryParam['removeFlag'] = '0';
		} else if(subType == '2') {
			queryParam['status'] = '0,1,2,3,4,5';
			queryParam['removeFlag'] = '0';
		}else if(subType == '3') {
			queryParam['status'] = '1,2';
			queryParam['removeFlag'] = '0';
			//queryParam['recommendFlag'] = '1';
		} else if(subType == '4') {
			queryParam['status'] = '1,2,3,4';
			queryParam['removeFlag'] = '0';
		}else if(subType == '5') {
			queryParam['status'] = '0,1,2,3,4,5';
			queryParam['removeFlag'] = '0,1';
		}
	} 
	if(type == 'researchGroupFollower'){
		if(subType == '1') {
			//queryParam['status'] = '1,2,3,4';
			queryParam['removeFlag'] = '0';
		} else if(subType == '2') {
			//queryParam['status'] = '0,1,2,3,4,5';
			queryParam['removeFlag'] = '0';
		}else if(subType == '3') {
			//queryParam['status'] = '1,2,3,4';
			queryParam['removeFlag'] = '0';
		} else if(subType == '4') {
			//queryParam['status'] = '1,2,3,4';
			queryParam['removeFlag'] = '0';
			queryParam['researchGroupFollowerIdQueryModel']=getFollowerId('1');
		}else if(subType == '5') {
			queryParam['removeFlag'] = '0,1';
		}
	} 
	if(type == 'achievementFollower'){
		if(subType == '1') {
			//queryParam['status'] = '1,2,3,4';
			queryParam['removeFlag'] = '0';
		} else if(subType == '2') {
			//queryParam['status'] = '0,1,2,3,4,5';
			queryParam['removeFlag'] = '0';
		}else if(subType == '3') {
			//queryParam['status'] = '1,2,3,4';
			queryParam['removeFlag'] = '0';
		} else if(subType == '4') {
			//queryParam['status'] = '1,2,3,4';
			queryParam['removeFlag'] = '0';
			queryParam['achievementFollowerIdQueryModel']=getFollowerId('1');
		}else if(subType == '5') {
			queryParam['removeFlag'] = '0,1';
		}
	} 
	if(type == 'companyUser'){
		if(subType == '1') {
			queryParam['status'] = '1';
			queryParam['removeFlag'] = '0';
		} else if(subType == '2') {
			queryParam['status'] = '0,1,2';
			queryParam['removeFlag'] = '0';
		}else if(subType == '3') {
			queryParam['status'] = '1';
			queryParam['removeFlag'] = '0';
		} else if(subType == '4') {
			queryParam['status'] = '1';
			queryParam['removeFlag'] = '0';
		}else if(subType == '5') {
			queryParam['status'] = '0,1,2';
			queryParam['removeFlag'] = '0,1';
		}
	} 
	if(type == 'techRequirement'){
		if(subType == '1') {
			queryParam['status'] = '1,2,3,4';
			queryParam['removeFlag'] = '0';
		} else if(subType == '2') {
			queryParam['status'] = '0,1,2,3,4,5';
			queryParam['removeFlag'] = '0';
		}else if(subType == '3') {
			queryParam['status'] = '1,2';
			queryParam['removeFlag'] = '0';
			//queryParam['recommendFlag'] = '1';
		} else if(subType == '4') {
			queryParam['status'] = '1,2,3,4';
			queryParam['removeFlag'] = '0';
		}else if(subType == '5') {
			queryParam['status'] = '0,1,2,3,4,5';
			queryParam['removeFlag'] = '0,1';
		}
	} 
	if(type == 'fundRequirement'){
		if(subType == '1') {
			queryParam['status'] = '1,2,3,4';
			queryParam['removeFlag'] = '0';
		} else if(subType == '2') {
			queryParam['status'] = '0,1,2,3,4,5';
			queryParam['removeFlag'] = '0';
		}else if(subType == '3') {
			queryParam['status'] = '1,2';
			queryParam['removeFlag'] = '0';
			//queryParam['recommendFlag'] = '1';
		} else if(subType == '4') {
			queryParam['status'] = '1,2,3,4';
			queryParam['removeFlag'] = '0';
		}else if(subType == '5') {
			queryParam['status'] = '0,1,2,3,4,5';
			queryParam['removeFlag'] = '0,1';
		}
	} 
	if(type == 'techRequirementFollower'){
		if(subType == '1') {
			//queryParam['status'] = '1,2,3,4';
			queryParam['removeFlag'] = '0';
		} else if(subType == '2') {
			//queryParam['status'] = '0,1,2,3,4,5';
			queryParam['removeFlag'] = '0';
		}else if(subType == '3') {
			//queryParam['status'] = '1,2,3,4';
			queryParam['removeFlag'] = '0';
		} else if(subType == '4') {
			//queryParam['status'] = '1,2,3,4';
			queryParam['removeFlag'] = '0';
			queryParam['techRequirementFollowerIdQueryModel']=getFollowerId('1');
		}else if(subType == '5') {
			queryParam['removeFlag'] = '0,1';
		}
	} 
	if(type == 'fundRequirementFollower'){
		if(subType == '1') {
			//queryParam['status'] = '1,2,3,4';
			queryParam['removeFlag'] = '0';
		} else if(subType == '2') {
			//queryParam['status'] = '0,1,2,3,4,5';
			queryParam['removeFlag'] = '0';
		}else if(subType == '3') {
			//queryParam['status'] = '1,2,3,4';
			queryParam['removeFlag'] = '0';
		} else if(subType == '4') {
			//queryParam['status'] = '1,2,3,4';
			queryParam['removeFlag'] = '0';
			queryParam['fundRequirementFollowerIdQueryModel']=getFollowerId('1');
		}else if(subType == '5') {
			queryParam['removeFlag'] = '0,1';
		}
	} 
	if(type == 'investorUser'){
		if(subType == '1') {
			queryParam['status'] = '1';
			queryParam['removeFlag'] = '0';
		} else if(subType == '2') {
			queryParam['status'] = '0,1,2';
			queryParam['removeFlag'] = '0';
		}else if(subType == '3') {
			queryParam['status'] = '1';
			queryParam['removeFlag'] = '0';
			//queryParam['recommendFlag'] = '1';
		} else if(subType == '4') {
			queryParam['status'] = '1';
			queryParam['removeFlag'] = '0';
		}else if(subType == '5') {
			queryParam['status'] = '0,1,2';
			queryParam['removeFlag'] = '0,1';
		}
	} 
	if(type == 'investorUserFollower'){
		if(subType == '1') {
			//queryParam['status'] = '1,2,3,4';
			queryParam['removeFlag'] = '0';
		} else if(subType == '2') {
			//queryParam['status'] = '0,1,2,3,4,5';
			queryParam['removeFlag'] = '0';
		}else if(subType == '3') {
			//queryParam['status'] = '1,2,3,4';
			queryParam['removeFlag'] = '0';
		} else if(subType == '4') {
			//queryParam['status'] = '1,2,3,4';
			queryParam['removeFlag'] = '0';
			queryParam['investorUserFollowerIdQueryModel']=getFollowerId('1');
		}else if(subType == '5') {
			queryParam['removeFlag'] = '0,1';
		}
	} 
};

/**
 * @param type
 * 0：关注
 * 1：收藏
 * @returns 
 */
function getFollowerId(type) {
	var idQueryModel = {};
	idQueryModel['userId']=$("#commonUserLoginId").val();
    if(type == '0') {
    	idQueryModel['relationType']='0';
    }
    if(type == '1') {
    	idQueryModel['relationType']='1';
    }
    return idQueryModel;
};

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
	if ($('tbody input[name=listCheckbox]:checked').length === 0) {
		$('#noselect-open-modal').click();
		return;
    }
	if ($('tbody input[name=listCheckbox]:checked').length === 1) {
		var tr = $('tbody input[name=listCheckbox]:checked').parent().parent();
		var recommendFlag = tr.find('td[name=recommendFlag]').html();
		var seqNum = tr.find('td[name=seqNum]').html();
		$('input[name=recommendstatus]').each(function() {
			if($(this).val() == recommendFlag) {
				this.checked=true;
			}
		});
		$('#recommendSeq').val(seqNum);
	} else {
		$('#recommendstatus0').click();
	}
	$('#recommend-open-dialog').click();
};

function toReviewinvestorUser(){
	if ($('tbody input[name=listCheckbox]:checked').length === 0) {
		$('#noselect-open-modal').click();
		return;
    }
	if ($('tbody input[name=listCheckbox]:checked').length === 1) {
		var tr = $('tbody input[name=listCheckbox]:checked').parent().parent();
		var status = tr.find('td[name=status]').html();
		var communicateStatus = tr.find('td[name=communicateStatus]').html();
		$('input[name=reviewstatus]').each(function() {
			if($(this).val() == status) {
				this.checked=true;
			}
		});
		$('input[name=reviewcommunicateStatus]').each(function() {
			if($(this).val() == communicateStatus) {
				this.checked=true;
			}
		});
	} else {
		$('#reviewstatus0').click();
		$('#reviewCommunicateStatus0').click();
	}
	$('#review-open-dialog').click();
};
