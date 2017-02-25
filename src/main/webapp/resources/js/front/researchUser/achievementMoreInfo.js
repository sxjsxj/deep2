$(document).ready(function() {
	dialogControl();
	//寻求合作end
	getDeatil();
});

function getDeatil() {
	var id=$('#detailId').val();
	var url = $('#achievementDetail').attr('url');
	FrontCommonFunction.baseOptions['url'] = url;
	var requestParamTemp = {};
	requestParamTemp['id']=id;
	FrontCommonFunction.baseOptions['data'] = requestParamTemp;
	FrontCommonFunction.baseOptions['success'] = function(datas) {
		var type = FrontCommonFunction.replaceNull(datas.researchGroupResultModel.researchUserResultModel.type);
		if(type==="0"){
        	$("#provinceName").html(FrontCommonFunction.replaceNull(datas.researchGroupResultModel.researchUserResultModel.uniProvince));
			$("#uniOrgName").html($("#uniOrgName").html()+FrontCommonFunction.replaceNull(datas.researchGroupResultModel.researchUserResultModel.uniName));
			$("#uniOrgDepart").html($("#uniOrgDepart").html()+FrontCommonFunction.replaceNull(datas.researchGroupResultModel.researchUserResultModel.uniDepartment));
		}else if(type==="1"){
        	$("#provinceName").html(FrontCommonFunction.replaceNull(datas.researchGroupResultModel.researchUserResultModel.orgProvince));
			$("#uniOrgName").html($("#uniOrgName").html()+FrontCommonFunction.replaceNull(datas.researchGroupResultModel.researchUserResultModel.orgName));
			$("#uniOrgDepart").hide();
		}else if(type==="2"){
        	$("#provinceName").html(FrontCommonFunction.replaceNull(datas.researchGroupResultModel.researchUserResultModel.orgProvince));
			$("#uniOrgName").html($("#uniOrgName").html()+FrontCommonFunction.replaceNull(datas.researchGroupResultModel.researchUserResultModel.orgName));
			$("#uniOrgDepart").hide();
		}
		var path="";
		var logoUrl=datas.logoUrl;
		if(logoUrl!==null && logoUrl!=="" && logoUrl!==undefined){
			//path=logoUrl;
			path=$('#downFile').attr('url')+'?path='+logoUrl;
		}else{
			path="../resources/images/front/img/keyanchengguo.png";
		}
		$("#amount").html(FrontCommonFunction.setAmount(datas.amount));
		$("#status").html(FrontCommonFunction.setRequirementStatus(datas.status));
		$("#detailImg").attr('src',path); 
		$("#name").html(FrontCommonFunction.replaceNull(datas.name));
		$('head title').html(datas.name);
		$("#sequenceNumber").html("编号："+FrontCommonFunction.replaceNull(datas.sequenceNumber)); 
		$("#phase").html("阶段："+FrontCommonFunction.setInvestorPhase(datas.phase)); 
		$("#domain").html(FrontCommonFunction.setInvestorDomain(datas.domain));
		$("#scanNumber").html("访问量："+FrontCommonFunction.replaceNull(datas.scanNumber));
		$("#type").html(setMultiAchievementType(datas.type));
		$("#cooperationType").html(setMultiCooperationType(datas.cooperationType));
		$("#applyTo").html(FrontCommonFunction.replaceNull(datas.applyTo));
		$("#expectedEffect").html(FrontCommonFunction.replaceNull(datas.expectedEffect));
		if(datas.caseNum) {
			$("#caseNum").html(FrontCommonFunction.replaceNull(datas.caseNum));
		}else{
			$("#caseNum").hide();
			$("#caseNumTitle").hide();
		}
		if(datas.caseDetail) {
			$("#caseDetail").html(FrontCommonFunction.replaceNull(datas.caseDetail));
		}else {
			$("#caseDetail").hide();
			$("#caseDetailTitle").hide();
		}
		$("#solution").html(FrontCommonFunction.replaceNull(datas.solution));
		$("#achievementId").val(datas.id);
		//分享控件控制
		shareControl('achievement', datas.status, '.bdsharebuttonbox');
		//注册收藏、关注事件
		setCooperateCollectFlagD(datas);
		cooperateCollectFlagControlD('achievement');
		cooperateCollectActionControlD('achievement', "#achievementId");
	};
	$.ajax(FrontCommonFunction.baseOptions);
};