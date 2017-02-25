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
		$("#domain2").html(FrontCommonFunction.setInvestorDomain(datas.domain));
		$("#scanNumber").html("浏览量："+FrontCommonFunction.replaceNull(datas.scanNumber));
		var type=datas.researchUserResultModel.type;
        if(type==="0"){
        	$("#provinceName").html(FrontCommonFunction.replaceNull(datas.researchUserResultModel.uniProvince));
			$("#uniOrgName").html($("#uniOrgName").html()+FrontCommonFunction.replaceNull(datas.researchUserResultModel.uniName));
			$("#uniOrgDepart").html($("#uniOrgDepart").html()+FrontCommonFunction.replaceNull(datas.researchUserResultModel.uniDepartment));
		}else if(type==="1"){
        	$("#provinceName").html(FrontCommonFunction.replaceNull(datas.researchUserResultModel.orgProvince));
			$("#uniOrgName").html($("#uniOrgName").html()+FrontCommonFunction.replaceNull(datas.researchUserResultModel.orgName));
			$("#uniOrgDepart").hide();
		}else if(type==="2"){
        	$("#provinceName").html(FrontCommonFunction.replaceNull(datas.researchUserResultModel.orgProvince));
			$("#uniOrgName").html($("#uniOrgName").html()+FrontCommonFunction.replaceNull(datas.researchUserResultModel.orgName));
			$("#uniOrgDepart").hide();
		}
        if(datas.introduction) {
    		$("#introduction").html(FrontCommonFunction.replaceNull(datas.introduction));
        }else {
        	$("#introduction").hide();
        	$("#introductionTitle").hide();
        }
		$("#field").html(FrontCommonFunction.replaceNull(datas.field));
		if(datas.achievement) {
			$("#achievement").html(FrontCommonFunction.replaceNull(datas.achievement));
		} else {
			$("#achievement").hide();
			$("#achievementTitle").hide();
		}
		if(datas.teamSize) {
			$("#teamSize").html(FrontCommonFunction.replaceNull(datas.teamSize));
		}else {
			$("#teamSize").hide();
			$("#teamSizeTitle").hide();
		}
		if(datas.leaderIntro) {
			$("#leaderInfo").html(FrontCommonFunction.replaceNull(datas.leaderIntro));
		}else {
			$("#leaderInfo").hide();
			$("#leaderInfoTitle").hide();
		}
		if(datas.leaderAchieve) {
			$("#leaderAchieve").html(FrontCommonFunction.replaceNull(datas.leaderAchieve));
		}else {
			$("#leaderAchieve").hide();
			$("#leaderAchieveTitle").hide();
		}
		$("#researchId").val(datas.id);
		//分享控件控制
		shareControl('researchGroup', datas.status, '.bdsharebuttonbox');
		//注册收藏、关注事件
		setCooperateCollectFlagD(datas);
		cooperateCollectFlagControlD('researchGroup');
		cooperateCollectActionControlD('researchGroup', "#researchId");
	};
	$.ajax(FrontCommonFunction.baseOptions);
};