$(document).ready(function() {
	dialogControl();
	//寻求合作end
	getDeatil();
});

function getDeatil() {
	var id=$('#detailId').val();
	var url = $('#investorUserDetail').attr('url');
	FrontCommonFunction.baseOptions['url'] = url;
	var requestParamTemp = {};
	requestParamTemp['id']=id;
	FrontCommonFunction.baseOptions['data'] = requestParamTemp;
	FrontCommonFunction.baseOptions['success'] = function(datas) {
		$('head title').html(datas.name);
		$("#name").html(FrontCommonFunction.replaceNull(datas.name)); 
		$("#investDomain").html("投资领域："+FrontCommonFunction.setInvestorDomain(datas.investDomain)); 
		$("#investPhase").html("投资阶段："+FrontCommonFunction.setInvestorPhase(datas.investPhase)); 
		$("#investOutline").html("投资概述："+FrontCommonFunction.replaceNull(datas.investOutline)); 
		$("#investProvince").html(FrontCommonFunction.replaceNull(datas.province)); 
		$("#investAmount").html("投资额："+FrontCommonFunction.setAmount(datas.investAmount)); 
		$("#introduction").html(FrontCommonFunction.replaceNull(datas.introduction)); 
		$("#investorId").val(datas.id);
		//注册收藏、关注事件
		setCooperateCollectFlagD(datas);
		cooperateCollectFlagControlD('investor');
		cooperateCollectActionControlD('investor', "#investorId");
	};
	$.ajax(FrontCommonFunction.baseOptions);
};