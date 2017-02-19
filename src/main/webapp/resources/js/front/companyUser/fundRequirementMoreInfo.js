$(document).ready(function() {
	dialogControl();
	//寻求合作end
	getDeatil();
});

function getDeatil() {
	var id=$('#detailId').val();
	var url = $('#fundRequirementDetail').attr('url');
	FrontCommonFunction.baseOptions['url'] = url;
	var requestParamTemp = {};
	requestParamTemp['id']=id;
	FrontCommonFunction.baseOptions['data'] = requestParamTemp;
	FrontCommonFunction.baseOptions['success'] = function(datas) {
		var path="";
		var logoUrl=datas.logoUrl;
		if(logoUrl!==null && logoUrl!=="" && logoUrl!==undefined){
			path=$('#downFile').attr('url')+'?path='+logoUrl;
		}else{
			path="../resources/images/front/img/zijinxuqiu.png";
		}
		$("#detailImg").attr('src',path); 
		$("#name").html(datas.name); 
		$('head title').html(datas.name);
		$("#sequenceNumber").html("编号："+FrontCommonFunction.replaceNull(datas.sequenceNumber));
		$("#projectPhase").html("实验阶段："+FrontCommonFunction.setPhase(datas.projectPhase));
		$("#domain").html(FrontCommonFunction.setInvestorDomain(datas.domain));
		$("#companyProvince").html(FrontCommonFunction.replaceNull(datas.companyUserResultModel.province))
		$("#amountNeeded").html(FrontCommonFunction.setAmount(datas.amountNeeded));
		$("#scanNumber").html("浏览量："+FrontCommonFunction.replaceNull(datas.scanNumber));
		$("#projectTeam").html(FrontCommonFunction.replaceNull(datas.projectTeam));
		$("#projectProspect").html(FrontCommonFunction.replaceNull(datas.projectProspect));
		$("#projectIntro").html(FrontCommonFunction.replaceNull(datas.projectIntro));
		$("#requireId").val(datas.id);
		//注册收藏、关注事件
		setCooperateCollectFlagD(datas);
		cooperateCollectFlagControlD('fundRequirement');
		cooperateCollectActionControlD('fundRequirement', "#requireId");
	};
	$.ajax(FrontCommonFunction.baseOptions);
};