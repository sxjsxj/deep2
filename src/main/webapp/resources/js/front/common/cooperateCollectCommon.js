 
/**
 * 寻求合作、收藏 图标
 * @param param
 * @returns {String}
 */
function cooperateCollectFlagDiv(param, i) {
	var collectFlag = param.collectFlag;
	var cooperli='<div id="cooperate'+i+'"  style="font-size:15px;" class="listbtn">寻求合作</div>&nbsp;&nbsp;';
	var collectli="";
	var cancelCollectli="";
	if(collectFlag == "true"){
		cancelCollectli='<div id="cancelCollect'+i+'"  style="font-size:15px;" class="listbtn_cancel">取消收藏</div>';
		collectli='<div id="collect'+i+'"  style="font-size:15px; display:none;" class="listbtn">收藏</div>';
	}else{
		cancelCollectli='<div id="cancelCollect'+i+'"  style="font-size:15px; display:none;" class="listbtn_cancel">取消收藏</div>';
		collectli='<div id="collect'+i+'"  style="font-size:15px;" class="listbtn">收藏</div>';
	}
	return cooperli+collectli+cancelCollectli;
 }
 
 /**
  * listType: 列表类型- 
  * research:科研成果或科研团
  * company:技术需求或资金需求
  * investor:投资方
  * removeFlag:取消收藏以后，是否移除。
  */
 function cooperateCollectFlagControl(listType) {
	 var userType = $('#commonUserType').val();
	 //企业
	 if(userType == '0' && (listType == 'fundRequirement' || listType == 'techRequirement')) {
		 $('[id^=cooperate]').hide();
		 $('[id^=cancelCooperate]').hide();
		 $('[id^=collect]').hide();
		 $('[id^=cancelCollect]').hide();
	 }
	 //科研机构
	 if(userType == '1' && (listType == 'researchGroup' || listType == 'achievement')) {
		 $('[id^=cooperate]').hide();
		 $('[id^=cancelCooperate]').hide();
		 $('[id^=collect]').hide();
		 $('[id^=cancelCollect]').hide();
	 }
	 //投资方
	 if(userType == '2' && listType == 'investor') {
		 $('[id^=cooperate]').hide();
		 $('[id^=cancelCooperate]').hide();
		 $('[id^=collect]').hide();
		 $('[id^=cancelCollect]').hide();
	 }
 };
 
 /**
  * 收藏、取消合作、取消收藏
 * @param listType
 */
function cooperateCollectActionControl(listType, addUrlId, cancelUrlId, ifRequery, queryId) {
	 $('[id^=cooperate]').click(function() {
		if(!FrontCommonFunction.isLogin()){
			FrontCommonFunction.loginProcess();
			return;
		}
		//cooperate固定长度9
		$(".altsbg").show();
		var idIndex=$(this).attr("id").substring(9);
		$("#opeationIdIndex").val(idIndex);
		$("#cooRemark").val("");
	});
	 
	$('.anniu_submit-btn').unbind('click');
	$('.anniu_submit-btn').click(function(){
		if(!FrontCommonFunction.isLogin()){
			FrontCommonFunction.loginProcess();
			return;
		}
		//cooperate固定长度9
		var idIndex=$("#opeationIdIndex").val();
		var operateId=$("#operateId"+idIndex).val();
		var follower = {};
		var followerId = {};
		setFollowerId(followerId, operateId, listType);
		followerId['userId']=$("#commonUserLoginId").val();
		followerId['relationType']='0';
		
		follower['id']=followerId;
		follower['followerType']=getFollowerType();
		follower['remark']=$("#cooRemark").val();
		var reqParam={};
		reqParam['str']=JSON.stringify(follower);
		var url= '';
		if(addUrlId ){
			url=$(addUrlId).attr('url');
		} else {
			url=$('#addFollowerUrl').attr('url');
		}
		if($("#cooRemark").val()==""){
			$('#cooperateRemarkIsNull').html("合作意向说明不能为空");
		} else {
			cooperation(reqParam,url);
		}
	});
	 
	$('[id^=collect]').click(function() {
		if(!FrontCommonFunction.isLogin()){
			FrontCommonFunction.loginProcess();
			return;
		}
		//collect固定长度7
		var idIndex = $(this).attr('id').substring(7);
		var operateId=$('#operateId'+idIndex).val();
		
		var follower = {};
		var followerId = {};
		setFollowerId(followerId, operateId, listType);
		followerId['userId']=$("#commonUserLoginId").val();
		followerId['relationType']="1";
		follower['id']=followerId;
		follower['followerType']=getFollowerType();
		
		var reqParam={};
		reqParam['str']=JSON.stringify(follower);
		var url= '';
		if(addUrlId){
			url=$(addUrlId).attr('url');
		} else {
			url=$('#addFollowerUrl').attr('url');
		}
		collect(reqParam,url,idIndex);
	});
		
	//取消合作
	$('[id^=cancelCooperate]').click(function() {
		if(!FrontCommonFunction.isLogin()){
			FrontCommonFunction.loginProcess();
			return;
		}
		//collect固定长度7
		var idIndex = $(this).attr('id').substring(15);
		var operateId=$('#operateId'+idIndex).val();
		
		var followerIds = new Array();
		var followerId = {};
		setFollowerId(followerId, operateId,listType);
		followerId['userId']=$("#commonUserLoginId").val();
		followerId['relationType']="0";
		
		followerIds[0]=followerId;
		var reqParam={};
		reqParam['str']=JSON.stringify(followerIds);
		var url= '';
		if(cancelUrlId){
			url=$(cancelUrlId).attr('url');
		} else {
			url=$('#cancelFollowerUrl').attr('url');
		}
		cancel(reqParam, url, idIndex);
	});
	
	//取消收藏
	$('[id^=cancelCollect]').click(function() {
		if(!FrontCommonFunction.isLogin()){
			FrontCommonFunction.loginProcess();
			return;
		}
		//collect固定长度13
		var idIndex = $(this).attr('id').substring(13);
		var operateId=$('#operateId'+idIndex).val();
		
		var followerIds = new Array();
		var followerId = {};
		
		setFollowerId(followerId, operateId, listType);
		followerId['userId']=$("#commonUserLoginId").val();
		followerId['relationType']="1";
		
		followerIds[0] = followerId;
		var reqParam={};
		reqParam['str']=JSON.stringify(followerIds);
		var url= '';
		if(cancelUrlId){
			url=$(cancelUrlId).attr('url');
		} else {
			url=$('#cancelFollowerUrl').attr('url');
		}
		cancel(reqParam,url,idIndex,ifRequery, queryId);
	});
 };
 
 function cooperation(reqParam,url,idIndex){
	FrontCommonFunction.baseOptions['url'] = url;
	FrontCommonFunction.baseOptions['data'] = reqParam;
	FrontCommonFunction.baseOptions['success'] = function(datas) {
		if(datas.status===0){
			$(".altsubmit").show();
			$(".altsbg").hide();
			setTimeout(function(){//5秒后隐藏
				$(".altsubmit").hide();
			}, 1500);
		}else{
			$(".altsbg").hide();
			FrontCommonFunction.processResult(datas,"#alertClick","#errorInfo");
		}
	};
	$.ajax(FrontCommonFunction.baseOptions);
};
 
 function collect(reqParam,url,idIndex){
	FrontCommonFunction.baseOptions['url'] = url;
	FrontCommonFunction.baseOptions['data'] = reqParam;
	FrontCommonFunction.baseOptions['success'] = function(datas) {
		if(datas.status===0){
			$('#altstwo').show();
			setTimeout(function(){//5秒后隐藏
				$('#altstwo').hide();
			}, 1500);
			$('#collect'+idIndex).css('display','none');
			$('#cancelCollect'+idIndex).css('display','');
		}else{
			FrontCommonFunction.processResult(datas,"#alertClick","#errorInfo");
		}
	};
	$.ajax(FrontCommonFunction.baseOptions);
};

function cancel(reqParam,url,idIndex,ifRequery,queryId){
	FrontCommonFunction.baseOptions['url'] = url;
	FrontCommonFunction.baseOptions['data'] = reqParam;
	FrontCommonFunction.baseOptions['success'] = function(datas) {
		if(datas.status===0){
			$('#altstwo').show();
			setTimeout(function(){//5秒后隐藏
				$('#altstwo').hide();
			}, 1500);
			$('#cancelCollect'+idIndex).css('display','none');
			$('#collect'+idIndex).css('display','');
			if(ifRequery) {
				$(queryId).click();
			}
		}else{
			FrontCommonFunction.processResult(datas,"#alertClick","#errorInfo");
		}
	};
	$.ajax(FrontCommonFunction.baseOptions);
};


function getFollowerType() {
	if ($('#commonUserType').val() == '2') {
		return "1";
	} else {
		return "0";
	}
 };
 
function setFollowerId(followerId, operateId, listType) {
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