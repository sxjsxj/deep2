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
		var provinceName = "";
		if (type === "0") {
			provinceName = FrontCommonFunction.replaceNull(datas.researchGroupResultModel.researchUserResultModel.uniProvince);
		} else if (type === "1") {
			//alert(datas.researchGroupResultModel.researchUserResultModel.orgProvince);
			provinceName = FrontCommonFunction.replaceNull(datas.researchGroupResultModel.researchUserResultModel.orgProvince);
		} else if (type === "2") {
			provinceName = FrontCommonFunction.replaceNull(datas.researchGroupResultModel.researchUserResultModel.orgProvince);
		}
		var path="";
		var logoUrl=datas.logoUrl;
		if(logoUrl!==null && logoUrl!=="" && logoUrl!==undefined){
			//path=logoUrl;
			path=$('#downFile').attr('url')+'?path='+logoUrl;
		}else{
			path="../resources/images/front/img/keyanchengguo.png";
		}
		$("#detailImg").attr('src',path); 
		$("#name").html(FrontCommonFunction.replaceNull(datas.name)); 
		$("#sequenceNumber").html("编号："+FrontCommonFunction.replaceNull(datas.sequenceNumber)); 
		$("#phase").html("阶段："+FrontCommonFunction.setInvestorPhase(datas.phase)); 
		$("#domain").html(FrontCommonFunction.setInvestorDomain(datas.domain));
		$("#provinceName").html(provinceName);
		$("#scanNumber").html("访问量："+FrontCommonFunction.replaceNull(datas.scanNumber));
//		$("#leaderDepart").html("主管部门："+FrontCommonFunction.replaceNull(datas.leaderDepart));
		$("#type").html(FrontCommonFunction.setInbestorType(datas.type));
		$("#cooperationType").html(FrontCommonFunction.setInbestorCooperationType(datas.cooperationType));
		$("#applyTo").html(FrontCommonFunction.replaceNull(datas.applyTo));
		$("#expectedEffect").html(FrontCommonFunction.replaceNull(datas.expectedEffect));
		$("#caseNum").html(FrontCommonFunction.replaceNull(datas.caseNum));
		$("#caseDetail").html(FrontCommonFunction.replaceNull(datas.caseDetail));
		$("#solution").html(FrontCommonFunction.replaceNull(datas.solution));
		$("#achievementId").val(datas.id);
		//注册收藏、关注事件
		setCooperateCollectFlagD(datas);
		cooperateCollectFlagControlD('achievement');
		cooperateCollectActionControlD('achievement', "#achievementId");
	};
	$.ajax(FrontCommonFunction.baseOptions);
};