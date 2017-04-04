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
		if(datas.name){
			$('head title').html(datas.name);
		}
		var type = $('#commonInvestorUserType').val();
		if(type == '0') {
			$("#name").html(FrontCommonFunction.replaceNull(datas.name));
		}
		if(type == '1') {
			$("#name").html(FrontCommonFunction.replaceNull(datas.name));
		}
		$("#investDomain").html("投资领域："+FrontCommonFunction.setInvestorDomain(datas.investDomain));
		$("#investPhase").html("投资阶段："+FrontCommonFunction.setStrInvestorPhase(datas.investPhase));
		$("#investOutline").html(FrontCommonFunction.replaceNull(datas.investOutline));
		//$("#investProvince").html(FrontCommonFunction.replaceNull(datas.province));
		$("#investAmount").html("投资额："+FrontCommonFunction.setAmount(datas.investAmount));
		if(datas.introduction){
			$("#introduction").html(FrontCommonFunction.replaceNull(datas.introduction));
		} else {
			$("#introduction").hide();
			$("#introductionTitle").hide();
		}
		$("#investorId").val(datas.id);
		//分享控件控制
		shareControl('investorUser', datas.userModel.status, '.bdsharebuttonbox');
		//注册收藏、关注事件
		setCooperateCollectFlagD(datas);
		cooperateCollectFlagControlD('investor');
		cooperateCollectActionControlD('investor', "#investorId");
	};
	$.ajax(FrontCommonFunction.baseOptions);
};
