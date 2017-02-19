 
/**
 * 寻求合作、收藏 图标
 * @param param
 * @returns {String}
 */
function setCooperateCollectFlagD(datas) {
	var cooperateFlag=datas.cooperateFlag;
	var collectFlag=datas.collectFlag;
	$("#cooperate").html("寻求合作");
	if(collectFlag==="true"){
		//收藏过
		$("#collect").css('display','none');
		$("#cancelCollect").css('display','');
	}else{
		$("#collect").css('display','');
		$("#cancelCollect").css('display','none');
	}
 };
 
 /**
  * listType: 列表类型- 
  * research:科研成果或科研团
  * company:技术需求或资金需求
  * investor:投资方
  * removeFlag:取消收藏以后，是否移除。
  */
 function cooperateCollectFlagControlD(listType) {
	 var userType = $('#commonUserType').val();
	 //企业
	 if(userType == '0' && (listType == 'fundRequirement' || listType == 'techRequirement')) {
		 $('[id=cooperate]').hide();
		 $('[id=cancelCooperate]').hide();
		 $('[id=collect]').hide();
		 $('[id=cancelCollect]').hide();
	 }
	 //科研机构
	 if(userType == '1' && (listType == 'researchGroup' || listType == 'achievement' || listType == 'fundRequirement')) {
		 $('[id=cooperate]').hide();
		 $('[id=cancelCooperate]').hide();
		 $('[id=collect]').hide();
		 $('[id=cancelCollect]').hide();
	 }
	 //投资方
	 if(userType == '2' && (listType == 'investor' || listType == 'techRequirement')) {
		 $('[id=cooperate]').hide();
		 $('[id=cancelCooperate]').hide();
		 $('[id=collect]').hide();
		 $('[id=cancelCollect]').hide();
	 }
	 //没登录
	 if(userType==""){
		 $('[id=cancelCollect]').hide();
	 }
	 
 };
 /**
  * 收藏、取消合作、取消收藏
 * @param listType
 */
function cooperateCollectActionControlD(listType, dataId) {
	 $('[id=cooperate]').click(function() {
		if(!FrontCommonFunction.isLogin()){
			FrontCommonFunction.loginProcess();
			return;
		}
		$(".altsbg").removeClass('hide');
		$(".altsbg").show();
		$("#cooRemark").val("");
	});
	
	$('.anniu_submit-btn').click(function(){
		if(!FrontCommonFunction.isLogin()){
			FrontCommonFunction.loginProcess();
			return;
		}
		var operateId=$(dataId).val();
		var follower = {};
		var followerId = {};
		setFollowerIdD(followerId, operateId, listType);
		followerId['userId']=$("#commonUserLoginId").val();
		followerId['relationType']='0';
		
		follower['id']=followerId;
		follower['followerType']=getFollowerTypeD();
		follower['remark']=$("#cooRemark").val();
		var reqParam={};
		reqParam['str']=JSON.stringify(follower);
		var url=$('#addFollowerUrl').attr('url');
		cooperationD(reqParam,url);
	});
	 
	$('[id=collect]').click(function() {
		if(!FrontCommonFunction.isLogin()){
			FrontCommonFunction.loginProcess();
			return;
		}
		var operateId=$(dataId).val();
		var follower = {};
		var followerId = {};
		setFollowerIdD(followerId, operateId, listType);
		followerId['userId']=$("#commonUserLoginId").val();
		followerId['relationType']="1";
		follower['id']=followerId;
		follower['followerType']=getFollowerTypeD();
		
		var reqParam={};
		reqParam['str']=JSON.stringify(follower);
		var url=$('#addFollowerUrl').attr('url');
		collectD(reqParam,url);
	});
		
	//取消合作
	$('[id=cancelCooperate]').click(function() {
		if(!FrontCommonFunction.isLogin()){
			FrontCommonFunction.loginProcess();
			return;
		}
		var operateId=$(dataId).val();
		var followerIds = new Array();
		var followerId = {};
		setFollowerIdD(followerId, operateId,listType);
		followerId['userId']=$("#commonUserLoginId").val();
		followerId['relationType']="0";
		
		followerIds[0]=followerId;
		var reqParam={};
		reqParam['str']=JSON.stringify(followerIds);
		var url=$('#cancelFollowerUrl').attr('url');
		cancelD(reqParam, url);
	});
	
	//取消收藏
	$('[id=cancelCollect]').click(function() {
		if(!FrontCommonFunction.isLogin()){
			FrontCommonFunction.loginProcess();
			return;
		}
		var operateId=$(dataId).val();
		var followerIds = new Array();
		var followerId = {};
		setFollowerIdD(followerId, operateId, listType);
		followerId['userId']=$("#commonUserLoginId").val();
		followerId['relationType']="1";
		
		followerIds[0] = followerId;
		var reqParam={};
		reqParam['str']=JSON.stringify(followerIds);
		var url=$('#cancelFollowerUrl').attr('url');
		cancelD(reqParam,url);
	});
 };
 
 function cooperationD(reqParam,url){
	FrontCommonFunction.baseOptions['url'] = url;
	FrontCommonFunction.baseOptions['data'] = reqParam;
	FrontCommonFunction.baseOptions['success'] = function(datas) {
		if(datas.status===0){
			$(".altsubmit").removeClass('hide');
			$(".altsubmit").show();
			$(".altsbg").hide();
			setTimeout(function(){//5秒后隐藏
				$(".altsubmit").hide();
			}, 1500);
		}else{
			$(".altsbg").hide();
			$('#altsthree').removeClass('hide');
			FrontCommonFunction.processResult(datas,"#alertClick","#errorInfo");
		}
	};
	$.ajax(FrontCommonFunction.baseOptions);
};
 
 function collectD(reqParam,url){
	FrontCommonFunction.baseOptions['url'] = url;
	FrontCommonFunction.baseOptions['data'] = reqParam;
	FrontCommonFunction.baseOptions['success'] = function(datas) {
		if(datas.status===0){
			$('#altstwo').removeClass('hide');
			$('#altstwo').show();
			setTimeout(function(){//5秒后隐藏
				$('#altstwo').hide();
			}, 1500);
			$('#collect').css('display','none');
			$('#cancelCollect').css('display','');
		}else{
			FrontCommonFunction.processResult(datas,"#alertClick","#errorInfo");
		}
	};
	$.ajax(FrontCommonFunction.baseOptions);
};

function cancelD(reqParam,url){
	FrontCommonFunction.baseOptions['url'] = url;
	FrontCommonFunction.baseOptions['data'] = reqParam;
	FrontCommonFunction.baseOptions['success'] = function(datas) {
		if(datas.status===0){
			$('#altstwo').removeClass('hide');
			$('#altstwo').show();
			setTimeout(function(){//5秒后隐藏
				$('#altstwo').hide();
			}, 1500);
			$('#cancelCollect').css('display','none');
			$('#collect').css('display','');
		}else{
			FrontCommonFunction.processResult(datas,"#alertClick","#errorInfo");
		}
	};
	$.ajax(FrontCommonFunction.baseOptions);
};


function getFollowerTypeD() {
	if ($('#commonUserType').val() == '2') {
		return "1";
	} else {
		return "0";
	}
 };
 
function setFollowerIdD(followerId, operateId, listType) {
	if(listType == 'researchGroup') {
		followerId['researchId'] = operateId;
	}
	if(listType == 'achievement') {
		followerId['achievementId'] = operateId;
	}
	if(listType == 'techRequirement' || listType == 'fundRequirement') {
		followerId['requirementId']=operateId;
	}
	if(listType == 'investor') {
		followerId['investorId'] = operateId;
	}
};