$(document).ready(function() {
	dialogControl();
	//寻求合作end
	getDeatil();
});

function getDeatil() {
	var id=$('#detailId').val();
	var url = $('#techRequirementDetail').attr('url');
	FrontCommonFunction.baseOptions['url'] = url;
	var requestParamTemp = {};
	requestParamTemp['id']=id;
	FrontCommonFunction.baseOptions['data'] = requestParamTemp;
	FrontCommonFunction.baseOptions['success'] = function(datas) {
		$('head title').html(datas.name);
		$("#name").html(FrontCommonFunction.replaceNull(datas.name)); 
		$("#sequenceNumber").html("编号："+FrontCommonFunction.replaceNull(datas.sequenceNumber)); 
		$("#domain").html(FrontCommonFunction.setInvestorDomain(datas.domain)); 
		$("#status").html(FrontCommonFunction.setRequirementStatus(datas.status));
		$("#scanNumber").html("浏览量: "+FrontCommonFunction.replaceNull(datas.scanNumber)); 
		$("#address").html("公司所在地："+FrontCommonFunction.replaceNull(datas.companyUserResultModel.province))
		$("#domain2").html("所在领域："+FrontCommonFunction.setInvestorDomain(datas.domain));
		$("#amount").html("研发经费："+FrontCommonFunction.setAmount(datas.amount));
		$("#type").html("需求类型："+FrontCommonFunction.setType(datas.type));
		$("#duration").html("研发周期："+FrontCommonFunction.setDuration(datas.duration));
		$("#cooperationType").html("合作方式："+setMultiCooperationType(datas.cooperationType));
		$("#detail").html(FrontCommonFunction.replaceNull(datas.detail));
		if(!datas.similarProduct) {
			$("#similarProduct").html(FrontCommonFunction.replaceNull(datas.similarProduct));
		}
		$("#province").html(datas.companyUserResultModel.province);
		$("#requireId").val(datas.id);
		//分享控件控制
		shareControl('techRequirement', datas.status, 'bdsharebuttonbox');
		//注册收藏、关注事件
		setCooperateCollectFlagD(datas);
		cooperateCollectFlagControlD('techRequirement');
		cooperateCollectActionControlD('techRequirement', "#requireId");
	};
	$.ajax(FrontCommonFunction.baseOptions);
};