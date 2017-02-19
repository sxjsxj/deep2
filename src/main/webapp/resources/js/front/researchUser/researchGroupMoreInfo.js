$(document).ready(function() {
	dialogControl();
	getDeatil();
});

function getDeatil() {
	var id=$('#detailId').val();
	var url = $('#researchGroupDetail').attr('url');
	FrontCommonFunction.baseOptions['url'] = url;
	var requestParamTemp = {};
	requestParamTemp['id']=id;
	FrontCommonFunction.baseOptions['data'] = requestParamTemp;
	FrontCommonFunction.baseOptions['success'] = function(datas) {
		var type=datas.researchUserResultModel.type;
		var path="";
		var logoUrl=datas.logoUrl;
		if(logoUrl!==null && logoUrl!=="" && logoUrl!==undefined){
			path=$('#downFile').attr('url')+'?path='+logoUrl;
		}else{
			path="../resources/images/front/img/keyantuandui.png";
		}
		$("#detailImg").attr('src',path); 
		$("#name").html(datas.name); 
		$('head title').html(datas.name);
		$("#domain").html("领域："+FrontCommonFunction.setInvestorDomain(datas.domain));
		$("#domain2").html(FrontCommonFunction.setInvestorDomain(datas.domain));
        if(type==="0"){
        	$("#provinceName").html(FrontCommonFunction.replaceNull(datas.researchUserResultModel.uniName));
		}else if(type==="1"){
			$("#provinceName").html(FrontCommonFunction.replaceNull(datas.researchUserResultModel.orgName));
		}else if(type==="2"){
			$("#provinceName").html(FrontCommonFunction.replaceNull(datas.researchUserResultModel.orgName));
		}
		$("#scanNumber").html("访问量："+FrontCommonFunction.replaceNull(datas.scanNumber));
		$("#leaderDepart").html("主管部门："+FrontCommonFunction.replaceNull(datas.leaderDepart));
		$("#introduction").html(FrontCommonFunction.replaceNull(datas.introduction));
		$("#field").html(FrontCommonFunction.replaceNull(datas.field));
		$("#achievement").html(FrontCommonFunction.replaceNull(datas.achievement));
		$("#teamSize").html(FrontCommonFunction.replaceNull(datas.teamSize));
		$("#leaderInfo").html(FrontCommonFunction.replaceNull(datas.leaderName)+"&nbsp;&nbsp;"+FrontCommonFunction.replaceNull(datas.leaderTitle)+"&nbsp;&nbsp;"+FrontCommonFunction.replaceNull(datas.leaderTel));
		$("#leaderAchieve").html(FrontCommonFunction.replaceNull(datas.leaderAchieve));
		$("#researchId").val(datas.id);
		//注册收藏、关注事件
		setCooperateCollectFlagD(datas);
		cooperateCollectFlagControlD('researchGroup');
		cooperateCollectActionControlD('researchGroup', "#researchId");
	};
	$.ajax(FrontCommonFunction.baseOptions);
};