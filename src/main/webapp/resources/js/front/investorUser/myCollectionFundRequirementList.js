$(document).ready(function() {
	$('#altstwo').hide();
	$('#altsthree').hide();
	$('.img2').click(function(){
		$('#altsthree').hide();
		$('#altstwo').hide();
	});
	$('#alertClick').click(function(){
	});
	//弹框start
	$('.registSuccess').click(function(){
		//$('.city').show();
		$('#altsthree').show();
	});
	//寻求合作start
	$(".altsbg").hide();
	$('.close').click(function(){
		$(".altsubmit").hide();
	})
	$('.anniu_cancel-btn').click(function(){
		$(".altsbg").hide();
	})
	//寻求合作end
	//设置左侧导航
	setLeftNav('#investorMyRecommendFundRequire');
	commonInit();
	initAmountDemandListManager();
});

var queryParam = {};
function initAmountDemandListManager() {
	FrontCommonFunction.initCheckBoxBaseResearchField("#checkBoxDomain");
	//查询条件初始化大区
	FrontCommonFunction.initCheckBoxRegion("#region");
	//设置大区
	setRegionClick();
	//只查看本省市
	$("#onlySeeLocalCity").click(function() {
		if(!FrontCommonFunction.isLogin()){
			$('#nologin').show();
			$("#onlySeeLocalCity").removeClass("on");
			setTimeout(function(){//5秒后隐藏
				$('#nologin').hide();
			}, 1500);
		}else{
			if($("#onlySeeLocalCity").hasClass("on")){
				$("#region").show();
			}else{
				$("#region").hide();
			}
		}
	});
	//学科领域
	$("#checkBoxDomain [id^=domainCheckBox]").click(function() {
		//domainCheckBox固定长度是14
		var idIndex=$(this).attr("id").substring(14);
		//固定属性：domainCheckBoxValue
		if($("#domainCheckBoxValue"+idIndex).hasClass("on")){
			 $("#domainCheckBoxValue"+idIndex).removeClass("on");
		}else{
			 $("#domainCheckBoxValue"+idIndex).attr("class","on");
		}
		text = $("#checkBoxDomain [id^=domainCheckBoxValue]input[class=on]").map(function(index,elem) {
			return $(elem).val();
		}).get().join(',');
		$("#domainId").val(text);
	});
	//投资额
	$("#checkBoxAmount [id^=amountCheckBox]").click(function() {
		//amountCheckBox固定长度是14
		var idIndex=$(this).attr("id").substring(14);
		//固定属性：amountCheckBoxValue
		if($("#amountCheckBoxValue"+idIndex).hasClass("on")){
			 $("#amountCheckBoxValue"+idIndex).removeClass("on");
		}else{
			 $("#amountCheckBoxValue"+idIndex).attr("class","on");
		}
		text = $("#checkBoxAmount [id^=amountCheckBoxValue]input[class=on]").map(function(index,elem) {
			return $(elem).val();
		}).get().join(',');
		$("#amountId").val(text);
	});
	
	//阶段
	$("#checkBoxProjectPhase [id^=projectPhaseCheckBox]").click(function() {
		//projectPhaseCheckBox固定长度是20
		var idIndex=$(this).attr("id").substring(20);
		//固定属性：amountCheckBoxValue
		if($("#projectPhaseCheckBoxValue"+idIndex).hasClass("on")){
			 $("#projectPhaseCheckBoxValue"+idIndex).removeClass("on");
		}else{
			 $("#projectPhaseCheckBoxValue"+idIndex).attr("class","on");
		}
		text = $("#checkBoxProjectPhase [id^=projectPhaseCheckBoxValue]input[class=on]").map(function(index,elem) {
			return $(elem).val();
		}).get().join(',');
		$("#projectPhaseId").val(text);
	});
	
	//状态
	$("#statusCheckBox").click(function() {
		if($("#statusCheckBoxValue").hasClass("on")){
			//没勾选
			 $("#statusCheckBoxValue").removeClass("on");
			 $("#statusId").val("");
		}else{
			//勾选
			 $("#statusCheckBoxValue").attr("class","on");
			 $("#statusId").val("1,2");
		}
	});
	
	//页面加载查询
	queryParam = getData();
	query(queryParam);
	$('#queryFundRequirement').click(function() {
		queryParam = getData();
	    query(queryParam);
    });
};

function query(param) {
	var that=this;
	param = getData();
	// 清空列表
	$('#amountDemandListQuery').html("");
	$('#noResult').html('');
	$('#pagination').html('');
	var url = $('#queryFundRequirement').attr('url');
	FrontCommonFunction.baseOptions['url'] = url;
	if (param === null || jQuery.isEmptyObject(param)) {
		var requestParamTemp = {};
		requestParamTemp['str']="{}";
		requestParamTemp['currentPage'] = $('#currentPage').attr('value');
		requestParamTemp['maxRecordPerPage'] = FrontCommonFunction.maxRecordPerPage;
		requestParamTemp['userQueryModel']=FrontCommonFunction.getCommonUserId();
		FrontCommonFunction.baseOptions['data'] = requestParamTemp;
	} else {
		var jsonStr=JSON.stringify(param);
		var requestParamTemp = {};
		requestParamTemp['str']=jsonStr;
		requestParamTemp['currentPage'] = $('#currentPage').val();
		requestParamTemp['maxRecordPerPage'] = FrontCommonFunction.maxRecordPerPage;
		FrontCommonFunction.baseOptions['data'] = requestParamTemp;
	}
	
	FrontCommonFunction.baseOptions['success'] = function(datas) {
		var queryReturnList = datas.queryReturnList;
		if (queryReturnList === null || queryReturnList.length === 0) {
			var noresult="";
			noresult+="<div align='center' class='fl right'>";
			noresult+="<div class='title'></div>"
			noresult+="<div style='width:900px;margin-top:2px;' class='my_tuijian_con'>"	
				noresult+="<div class='my_tuijian_con_title'>"	
				noresult+="<font style='color:#333333;'>您还未收藏任何企业资金需求</font>"
				noresult+='<div style="color:#349fc4;margin-top:-5px;" ><a href="../fundRequirement/getBrowsePage">现在就查看企业资金需求>></a></div>'
				noresult+="</div>"
					noresult+="<div class='my_tuijian_con_txt'>"
					noresult+="</div>"	
			noresult+="</div>"	
			noresult+="</div>"
			$('#noResult').html(noresult);
			return;
		} 
		for(var i = 0; i < queryReturnList.length; i++) {	
			var moreInfoUrl = $("#fundRequirementMoreInfo").attr('url')+"?id="+queryReturnList[i].id.requirementId;
			var li = '<div id="shaDowShow'+i+'"  class="mydiv1" onmouseout="delShaDowClass('+i+')" onmouseover="addShaDowClass('+i+')"><li>'
				li+='<input type="hidden" id="operateId'+i+'" value="'+queryReturnList[i].id.requirementId+'"/>'
				li+='<input type="hidden" id="operateIdUserId'+i+'" value="'+queryReturnList[i].id.userId+'"/>'
				li+='<input type="hidden" id="operateFollowerType'+i+'" value="'+queryReturnList[i].followerType+'"/>'
				li+='<input type="hidden" id="operateRelationType'+i+'" value="'+queryReturnList[i].id.relationType+'"/>'
			
			var attachUrl =queryReturnList[i].fundRequirementResultModel.attachUrl;
			var imgUrl="";
			if(attachUrl!==null && attachUrl!=="" && attachUrl!==undefined){
				imgUrl=attachUrl;
				li+='<a href="'+moreInfoUrl+'"><div class="fl ims">'+'<img style="width:240px;height:182px" src="'+$('#downFile').attr('url')+'?path='+imgUrl+'"/>'+"</div></a>"
			}else{
				imgUrl="../resources/images/front/img/zijinxuqiu.png";
				li+='<a href="'+moreInfoUrl+'"><div class="fl ims">'+'<img style="width:240px;height:182px" src="'+imgUrl+'"/>'+"</div></a>"
			}
				li+='<a href="'+moreInfoUrl+'"><div class="fl rights">'
				li+="<div class='tits'>"
				li+="<div class='fl'>"+FrontCommonFunction.replaceNull(queryReturnList[i].fundRequirementResultModel.name)+"</div>"
				li+="<div class='fr'>"+FrontCommonFunction.setPhase(queryReturnList[i].fundRequirementResultModel.projectPhase)+"</div>"	
				li+="<div class='clear'></div>"
				li+="</div></a>"
				li+='<a href="'+moreInfoUrl+'"><div class="cs">'
				li+=FrontCommonFunction.getResultMaitText(queryReturnList[i].fundRequirementResultModel.projectIntro,300,"#fundRequirementMoreInfo",queryReturnList[i].fundRequirementResultModel.id)
				li+="</div></a>"
				li+="<div class='f'>"
				li+='<a href="'+moreInfoUrl+'"><div style=" margin-top:60px" class="fl">'+FrontCommonFunction.setDomain(queryReturnList[i].fundRequirementResultModel.domain)+"&nbsp;&nbsp;"+FrontCommonFunction.replaceNull(queryReturnList[i].fundRequirementResultModel.companyUserResultModel.province)+"&nbsp;&nbsp;"+FrontCommonFunction.setStrAmount(queryReturnList[i].fundRequirementResultModel.amountNeeded)+"&nbsp;&nbsp;"+FrontCommonFunction.setRequirementStatus(queryReturnList[i].fundRequirementResultModel.status)+"</div></a>"
				li+='<div class="fr" style=" margin-top:60px">'	
				li+=cooperateCollectFlagDiv(queryReturnList[i].fundRequirementResultModel, i)
				li+="</div>"
				li+="</div>"
				li+="</div>"
				li+="<div class='clear'></div>"
				li+='</li></div>';
			$("#amountDemandListQuery").append(li);
		}
		if (queryReturnList.length !== 0) {
			FrontCommonFunction.pagination(datas.pagination.sumPage, '#currentPage', '#pagination', that, 'query');
			//控制登录用户
			cooperateCollectActionControl('fundRequirement',null,null,true,'#queryFundRequirement');
		}
	};
	$.ajax(FrontCommonFunction.baseOptions);
};

function getData() {
	var paramTemp = {};
	var companyUserQueryModel = {};
	var fundRequirementQueryModel={};
	fundRequirementQueryModel['domain']=$.trim($("#domainId").val());
	fundRequirementQueryModel['amountNeeded']=$.trim($('#amountId').val());
	fundRequirementQueryModel['projectPhase']=$.trim($('#projectPhaseId').val());
	 if ($("#onlySeeLocalCity").hasClass("on")) {
		// 加入勾选本市值
		companyUserQueryModel['province']=$("#commonMySelfProvince").val();
	} else {
		// 勾选大区后 各个区 所选的省值
		var remen = $('#renmenCheckboxResult').val();
		var huanan = $('#huananCheckboxResult').val();
		var huabei = $('#huabeiCheckboxResult').val();
		var huadong = $('#huadongCheckboxResult').val();
		var huazhong = $('#huazhongCheckboxResult').val();
		var xibei = $('#xibeiCheckboxResult').val();
		var dongbei = $('#dongbeiCheckboxResult').val();
		var xinan = $('#xinanCheckboxResult').val();
		var gangaotai = $('#gangaotaiCheckboxResult').val();
		var haiwai = $('#haiwaiCheckboxResult').val();
		var str="";
		if(remen!==""){
			str+=remen+",";
		}
		if(huanan!==""){
			str+=huanan+",";
		}
		if(huabei!==""){
			str+=huabei+",";
		}
		if(huadong!==""){
			str+=huadong+",";
		}
		if(huazhong!==""){
			str+=huazhong+",";
		}
		if(xibei!==""){
			str+=xibei+",";
		}
		if(dongbei!==""){
			str+=dongbei+",";
		}
		if(xinan!==""){
			str+=xinan+",";
		}
		if(gangaotai!==""){
			str+=gangaotai+",";
		}
		if(haiwai!==""){
			str+=haiwai+",";
		}
		
		var ar2 = str.split(","); 
		var array = new Array(); 
		var j=0 
		for(var i=0;i<ar2.length;i++){ 
			if((array == "" || array.toString().match(new RegExp(ar2[i],"g")) == null)&&ar2[i]!=""){ 
				array[j] =ar2[i]; 
				array.sort(); 
				j++; 
			} 
		} 
		companyUserQueryModel['province']=array.toString();
	}
	getDefaultQuery('companyUser', '4', companyUserQueryModel); 
	paramTemp['companyUserQueryModel']=companyUserQueryModel;
	getDefaultQuery('fundRequirement', '4', fundRequirementQueryModel); 
	paramTemp['fundRequirementQueryModel'] = fundRequirementQueryModel;
	var fundRequirementFollowerQueryModel = {};
	getDefaultQuery('fundRequirementFollower', '4', fundRequirementFollowerQueryModel); 
	paramTemp['fundRequirementFollowerQueryModel']=fundRequirementFollowerQueryModel;
	paramTemp['userQueryModel'] =getMyInfo();
	return paramTemp;
};