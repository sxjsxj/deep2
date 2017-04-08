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
	setLeftNav('#investorMyRecommend');
	commonInit();
	initAchievementListManager();
});

var queryParam = {};
var myProvince = '';
var myCity = '';
function initAchievementListManager() {
	FrontCommonFunction.initCheckBoxBaseResearchField("#checkBoxDomain");
	myProvince = $('#investorProvince').val();
	myCity = $('#investorCity').val();
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
	$('#achievement').click(function() {
		$("#tagValue").val("0");
		$('#achievement').addClass("active");
		$('#fundRequirement').removeClass("active");
		$("#checkedInfo").html("科研成果发布主体为高校、科研机构以及个人科研团队");
		//科研成果
		$("#achievementListQuery").empty();
		$("#fundRequirementListQuery").empty();
		queryParam = getAchievementData();
	    achievementQuery(queryParam);
    });
	
	$('#fundRequirement').click(function() {
		$("#tagValue").val("1");
		$('#fundRequirement').addClass("active");
		$('#achievement').removeClass("active");
		$("#checkedInfo").html("企业项目为企业发布的资金需求");
		//企业资金需求
		$("#achievementListQuery").empty();
		$("#fundRequirementListQuery").empty();
		queryParam = getFundRequirementData();
		fundRequirementQuery(queryParam);
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
	
	//阶段
	$("#checkBoxPhase [id^=phaseCheckBox]").click(function() {
		//phaseCheckBox固定长度是13
		var idIndex=$(this).attr("id").substring(13);
		//固定属性：amountCheckBoxValue
		if($("#phaseCheckBoxValue"+idIndex).hasClass("on")){
			 $("#phaseCheckBoxValue"+idIndex).removeClass("on");
		}else{
			 $("#phaseCheckBoxValue"+idIndex).attr("class","on");
		}
		text = $("#checkBoxPhase [id^=phaseCheckBoxValue]input[class=on]").map(function(index,elem) {
			return $(elem).val();
		}).get().join(',');
		$("#phaseId").val(text);
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
	
	
	//合作方式
	$("#checkBoxCooperationType [id^=cooperationTypeCheckBox]").click(function() {
		//cooperationTypeCheckBox固定长度是23
		var idIndex=$(this).attr("id").substring(23);
		//固定属性：cooperationTypeCheckBoxValue
		if($("#cooperationTypeCheckBoxValue"+idIndex).hasClass("on")){
			 $("#cooperationTypeCheckBoxValue"+idIndex).removeClass("on");
		}else{
			 $("#cooperationTypeCheckBoxValue"+idIndex).attr("class","on");
		}
		text = $("#checkBoxCooperationType [id^=cooperationTypeCheckBoxValue]input[class=on]").map(function(index,elem) {
			return $(elem).val();
		}).get().join(',');
		$("#cooperationTypeId").val(text);
	});
	
	//页面加载查询
	achievementQuery(queryParam);
	$('#query').click(function() {
		$("#achievementListQuery").empty();
		$("#fundRequirementListQuery").empty();
		var val=$("#tagValue").val();
		if(val==="0"){
			//科研成果
			queryParam = getDefaultAchievementData();
		    achievementQuery(queryParam);
		}else{
			//企业资金需求
			queryParam = getDefaultFundRequirementData();
			fundRequirementQuery(queryParam);
		}
    });
};

function achievementQuery(param) {
	if(myProvince == '' && myCity == ''){
		var noresult="";
		noresult+="<div align='center' style='margin-top:-5px;' class='fl right'>";
		noresult+="<div class='title'></div>"
		noresult+="<div style='width:900px;margin-top:2px;' class='my_tuijian_con'>"	
			noresult+="<div class='my_tuijian_con_title'>"	
			noresult+="<font style='color:#333333;'>您还未维护投资意向。</font>"
				noresult+="<div style='margin-top:-5px;color:#333333;'>维护后我们将根据您的投资需求，为您推荐优质投资项目。</div>"
			noresult+='<div style="color:#349fc4;margin-top:-5px;" ><a href="../investorUser/getPersonalUserDetailPageForAdd">现在维护投资意向>></a></div>'
			noresult+="</div>"
				noresult+="<div class='my_tuijian_con_txt'>"
				noresult+="</div>"	
		noresult+="</div>"	
		noresult+="</div>"
		$('#noResult').html(noresult);
		return;
	}
	var that=this;
	param = getDefaultAchievementData();
	// 清空列表
	$('#achievementListQuery').html("");
	$('#noResult').html('');
	$('#pagination').html('');
	var url = $('#queryAchievement').attr('url');
	FrontCommonFunction.baseOptions['url'] = url;
	var jsonStr=JSON.stringify(param);
	var requestParamTemp = {};
	requestParamTemp['str']=jsonStr;
	requestParamTemp['currentPage'] = $('#currentPage').val();
	requestParamTemp['maxRecordPerPage'] = FrontCommonFunction.maxRecordPerPage;
	FrontCommonFunction.baseOptions['data'] = requestParamTemp;
	
	FrontCommonFunction.baseOptions['success'] = function(datas) {
		var queryReturnList = datas.queryReturnList;
		if (queryReturnList === null || queryReturnList.length === 0) {
			var noresult="";
			noresult+="<div align='center' style='margin-top:-5px;' class='fl right'>";
			noresult+="<div class='title'></div>"
			noresult+="<div style='width:900px;margin-top:-18px;' class='my_tuijian_con'>"	
			noresult+="<div class='my_tuijian_con_title'>"	
			noresult+="<font style='margin-left:25px;color:#333333;'>" +
						"暂未找到您所需领域的科研成果。</font>"
			noresult+="</div>"
			noresult+="<div class='my_tuijian_con_txt'>"
			noresult+="</div>"	
			noresult+="</div>"	
			noresult+="</div>"
			//$('#noResult').html(noresult);
			
			//不考虑领域
			param = getAchievementData();
			var url = $('#queryAchievement').attr('url');
			FrontCommonFunction.baseOptions['url'] = url;
			var jsonStr=JSON.stringify(param);
			var requestParamTemp = {};
			requestParamTemp['str']=jsonStr;
			requestParamTemp['currentPage'] = $('#currentPage').val();
			requestParamTemp['maxRecordPerPage'] = FrontCommonFunction.maxRecordPerPage;
			FrontCommonFunction.baseOptions['data'] = requestParamTemp;
			
			FrontCommonFunction.baseOptions['success'] = function(datas) {
				displayAchievement(that, datas, datas.queryReturnList);		
			}
			$.ajax(FrontCommonFunction.baseOptions);
		} 
		displayAchievement(that, datas, datas.queryReturnList);		
	};
	$.ajax(FrontCommonFunction.baseOptions);
};

function fundRequirementQuery(param) {
	if(myDomain == ''){
		var noresult="";
		noresult+="<div align='center' style='margin-top:-5px;' class='fl right'>";
		noresult+="<div class='title'></div>"
		noresult+="<div style='width:900px;margin-top:2px;' class='my_tuijian_con'>"	
			noresult+="<div class='my_tuijian_con_title'>"	
			noresult+="<font style='color:#333333;'>您还未维护投资意向。</font>"
				noresult+="<div style='margin-top:-5px;color:#333333;'>维护后我们将根据您的投资需求，为您推荐优质投资项目。</div>"
			noresult+='<div style="color:#349fc4;margin-top:-5px;" ><a href="../investorUser/getPersonalUserDetailPageForAdd">现在维护投资意向>></a></div>'
			noresult+="</div>"
				noresult+="<div class='my_tuijian_con_txt'>"
				noresult+="</div>"	
		noresult+="</div>"	
		noresult+="</div>"
		$('#noResult').html(noresult);
		return;
	}
	var that=this;
	param = getDefaultFundRequirementData();
	// 清空列表
	$('#fundRequirementListQuery').html("");
	$('#noResult').html('');
	$('#pagination').html('');
	
	//不考虑领域
	param = getFundRequirementData();
	var url = $('#queryFundRequirement').attr('url');
	FrontCommonFunction.baseOptions['url'] = url;
	var jsonStr=JSON.stringify(param);
	var requestParamTemp = {};
	requestParamTemp['str']=jsonStr;
	requestParamTemp['currentPage'] = $('#currentPage').val();
	requestParamTemp['maxRecordPerPage'] = FrontCommonFunction.maxRecordPerPage;
	FrontCommonFunction.baseOptions['data'] = requestParamTemp;
	
	FrontCommonFunction.baseOptions['success'] = function(datas) {
		var queryReturnList = datas.queryReturnList;
		if (queryReturnList === null || queryReturnList.length === 0) {
			var noresult="";
			noresult+="<div align='center' style='margin-top:-5px;' class='fl right'>";
			noresult+="<div class='title'></div>"
			noresult+="<div style='width:900px;margin-top:2px;' class='my_tuijian_con'>"	
			noresult+="<div  class='my_tuijian_con_title'>"	
			noresult+="<font style='margin-left:25px;color:#333333;'>暂未找到您所需领域的资金需求。</font>"
			noresult+="</div>"
			noresult+="<div class='my_tuijian_con_txt'>"
			noresult+="</div>"	
			noresult+="</div>"	
			noresult+="</div>"
			//$('#noResult').html(noresult);
			

			var url = $('#queryFundRequirement').attr('url');
			FrontCommonFunction.baseOptions['url'] = url;
			var jsonStr=JSON.stringify(param);
			var requestParamTemp = {};
			requestParamTemp['str']=jsonStr;
			requestParamTemp['currentPage'] = $('#currentPage').val();
			requestParamTemp['maxRecordPerPage'] = FrontCommonFunction.maxRecordPerPage;
			FrontCommonFunction.baseOptions['data'] = requestParamTemp;
			
			FrontCommonFunction.baseOptions['success'] = function(datas) {
				displayFundRequirement(that, datas, datas.queryReturnList);
			}
			$.ajax(FrontCommonFunction.baseOptions);
		} 
		displayFundRequirement(that, datas, queryReturnList)
	};
	$.ajax(FrontCommonFunction.baseOptions);
};

function getAchievementData() {
	var paramTemp = {};
	var achievementQueryModel = {};
	var universityUserQueryModel = {};
	var organizationUserQueryModel = {};
	achievementQueryModel['domain']=$.trim($('#domainId').val());
	achievementQueryModel['amount']=$.trim($('#amountId').val());
	achievementQueryModel['phase']=$.trim($('#phaseId').val());
    if($("#onlySeeLocalCity").hasClass("on")){
		//加入勾选本市值
		universityUserQueryModel['uniProvince']=$("#commonMySelfProvince").val();
		organizationUserQueryModel['orgProvince']=$("#commonMySelfProvince").val();
	}else{
		//勾选大区后 各个区 所选的省值
		var remen=$('#renmenCheckboxResult').val();
		var huanan=$('#huananCheckboxResult').val();
		var huabei=$('#huabeiCheckboxResult').val();
		var huadong=$('#huadongCheckboxResult').val();
		var huazhong=$('#huazhongCheckboxResult').val();
		var xibei=	$('#xibeiCheckboxResult').val();
		var dongbei=$('#dongbeiCheckboxResult').val();
		var xinan=$('#xinanCheckboxResult').val();
		var gangaotai=$('#gangaotaiCheckboxResult').val();
		var haiwai=$('#haiwaiCheckboxResult').val();
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
		universityUserQueryModel['uniProvince']=array.toString();
		organizationUserQueryModel['orgProvince']=array.toString();
	}
	getDefaultQuery('achievement', '3', achievementQueryModel);
	paramTemp['achievementQueryModel']=achievementQueryModel;
	var researchGroupQueryModel = {};
	getDefaultQuery('researchGroup', '3', researchGroupQueryModel);
	paramTemp['researchGroupQueryModel'] = researchGroupQueryModel;
	paramTemp['universityUserQueryModel'] = universityUserQueryModel;
	paramTemp['organizationUserQueryModel'] = organizationUserQueryModel;
	var userQueryModel = {};
	getDefaultQuery('user', '3', userQueryModel);
	paramTemp['userQueryModel'] = userQueryModel;
	return paramTemp;
};

function getDefaultAchievementData() {
	var paramTemp = {};
	var achievementQueryModel = {};
	var universityUserQueryModel = {};
	var organizationUserQueryModel = {};
	achievementQueryModel['domain']=$('#investorDomain').val();
	achievementQueryModel['amount']=$('#investorAmount').val();
	achievementQueryModel['phase']=$('#investorPhase').val();
	universityUserQueryModel['uniProvince']=$('#investorProvince').val();
	organizationUserQueryModel['orgProvince']=$('#investorProvince').val();
	getDefaultQuery('achievement', '3', achievementQueryModel);
	paramTemp['achievementQueryModel']=achievementQueryModel;
	var researchGroupQueryModel = {};
	getDefaultQuery('researchGroup', '3', researchGroupQueryModel);
	paramTemp['researchGroupQueryModel'] = researchGroupQueryModel;
	paramTemp['universityUserQueryModel'] = universityUserQueryModel;
	paramTemp['organizationUserQueryModel'] = organizationUserQueryModel;
	var userQueryModel = {};
	getDefaultQuery('user', '3', userQueryModel);
	paramTemp['userQueryModel'] = userQueryModel;
	return paramTemp;
};

function getDefaultFundRequirementData() {
	var paramTemp = {};
    var companyUserQueryModel = {};
	var fundRequirementQueryModel = {};
	//加入推荐
	fundRequirementQueryModel['domain']=$('#investorDomain').val();
	fundRequirementQueryModel['amountNeeded']=$('#investorAmount').val();
	fundRequirementQueryModel['projectPhase']=$('#investorPhase').val();
	companyUserQueryModel['province']=$("#investorProvince").val();
	getDefaultQuery('companyUser', '3', companyUserQueryModel); 
	paramTemp['companyUserQueryModel']=companyUserQueryModel;
	getDefaultQuery('fundRequirement', '3', fundRequirementQueryModel); 
	paramTemp['fundRequirementQueryModel'] = fundRequirementQueryModel;
	var userQueryModel = {};
	getDefaultQuery('user', '3', userQueryModel);
	paramTemp['userQueryModel'] = userQueryModel;
	return paramTemp;
};

function getFundRequirementData() {
    var paramTemp = {};
    var companyUserQueryModel = {};
	var fundRequirementQueryModel = {};
	//加入推荐
	fundRequirementQueryModel['domain']=$.trim($('#domainId').val());
	fundRequirementQueryModel['amountNeeded']=$.trim($('#amountId').val());
	fundRequirementQueryModel['projectPhase']=$('#phaseId').val();
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
	getDefaultQuery('companyUser', '3', companyUserQueryModel); 
	paramTemp['companyUserQueryModel']=companyUserQueryModel;
	getDefaultQuery('fundRequirement', '3', fundRequirementQueryModel); 
	paramTemp['fundRequirementQueryModel'] = fundRequirementQueryModel;
	var userQueryModel = {};
	getDefaultQuery('user', '3', userQueryModel);
	paramTemp['userQueryModel'] = userQueryModel;
	return paramTemp;
};

function displayAchievement(that, datas, queryReturnList) {
	if (queryReturnList === null || queryReturnList.length === 0) {
		var noresult="";
		noresult+="<div align='center' style='margin-top:-5px;' class='fl right'>";
		noresult+="<div class='title'></div>"
		noresult+="<div style='width:900px;margin-top:-18px;' class='my_tuijian_con'>"	
		noresult+="<div class='my_tuijian_con_title'>"	
		noresult+="<font style='margin-left:25px;color:#333333;'>" +
					"暂未找到您所需领域的科研成果。</font>"
		noresult+="</div>"
		noresult+="<div class='my_tuijian_con_txt'>"
		noresult+="</div>"	
		noresult+="</div>"	
		noresult+="</div>"
		$('#noResult').html(noresult);
		return;
	} 
	for(var i = 0; i < queryReturnList.length; i++) {
		//取不到
		var type=queryReturnList[i].researchGroupResultModel.researchUserResultModel.type;
		var provinceName="";
		if(type==="0"){
			provinceName=FrontCommonFunction.replaceNull(queryReturnList[i].researchGroupResultModel.researchUserResultModel.uniProvince);
		}else if(type==="1"){
			provinceName=FrontCommonFunction.replaceNull(queryReturnList[i].researchGroupResultModel.researchUserResultModel.orgProvince);
		}else if(type==="2"){
			provinceName=FrontCommonFunction.replaceNull(queryReturnList[i].researchGroupResultModel.researchUserResultModel.orgProvince);
		}
		
		var moreInfoUrl = $("#achievementMoreInfo").attr('url')+"?id="+queryReturnList[i].id;
		var li = '<div id="shaDowShow'+i+'"  class="mydiv1" onmouseout="delShaDowClass('+i+')" onmouseover="addShaDowClass('+i+')"><li>'
			li+='<input type="hidden" id="operateId'+i+'" value="'+queryReturnList[i].id+'"/>'
			var imgUrl="";
			var logoUrl=queryReturnList[i].logoUrl;
			if(logoUrl!==null && logoUrl!=="" && logoUrl!==undefined){
				imgUrl=logoUrl;
				li+='<a href="'+moreInfoUrl+'" target="_blank"><div class="fl ims">'+'<img style="width:240px;height:182px" src="'+$('#downFile').attr('url')+'?path='+imgUrl+'"/>'+"</div></a>"
			}else{
				imgUrl="../resources/images/front/img/keyanchengguo.png";
				li+='<a href="'+moreInfoUrl+'" target="_blank"><div class="fl ims">'+'<img style="width:240px;height:182px" src="'+imgUrl+'"/>'+"</div></a>"
			}
		
			li+='<a href="'+moreInfoUrl+'" target="_blank"><div class="fl rights">'
			li+="<div class='tits'>"
			li+="<div class='fl'>"+FrontCommonFunction.replaceNull(queryReturnList[i].name)+"</div>"
			li+="<div class='fr'>"+FrontCommonFunction.setStrInvestorPhase(queryReturnList[i].phase)+"</div>"	
			li+="<div class='clear'></div>"
			li+="</div></a>"
			li+='<a href="'+moreInfoUrl+'" target="_blank"><div class="cs">'
			li+=FrontCommonFunction.getResultMaitText(queryReturnList[i].solution,300,"#achievementMoreInfo",queryReturnList[i].id)
			li+="</div></a>"
			li+='<div class="f">'
			li+='<a href="'+moreInfoUrl+'" target="_blank"><div style=" margin-top:60px" class="fl">'+FrontCommonFunction.setInvestorDomain(queryReturnList[i].domain)+"&nbsp;&nbsp;"+provinceName+"&nbsp;&nbsp;"+FrontCommonFunction.setAmount(queryReturnList[i].amount)+"&nbsp;&nbsp;"+FrontCommonFunction.setRequirementStatus(queryReturnList[i].status)+"</div></a>"
			li+='<div class="fr" style=" margin-top:60px">'	
			li+=cooperateCollectFlagDiv(queryReturnList[i], i)
			li+="</div>"
			li+="</div>"
			li+="</div>"
			li+="<div class='clear'></div>"
			li+='</li></div>';
		$("#achievementListQuery").append(li);
	}
	if (queryReturnList.length !== 0) {
		FrontCommonFunction.pagination(datas.pagination.sumPage, '#currentPage', '#pagination', that, 'achievementQuery');
		//控制登录用户
		cooperateCollectActionControl('achievement');
	}
};

function displayFundRequirement(that, datas, queryReturnList) {
	if (queryReturnList === null || queryReturnList.length === 0) {
		var noresult="";
		noresult+="<div align='center' style='margin-top:-5px;' class='fl right'>";
		noresult+="<div class='title'></div>"
		noresult+="<div style='width:900px;margin-top:2px;' class='my_tuijian_con'>"	
		noresult+="<div  class='my_tuijian_con_title'>"	
		noresult+="<font style='margin-left:25px;color:#333333;'>暂未找到您所需领域的资金需求。</font>"
		noresult+="</div>"
		noresult+="<div class='my_tuijian_con_txt'>"
		noresult+="</div>"	
		noresult+="</div>"	
		noresult+="</div>"
		$('#noResult').html(noresult);
		return;
	} 
	for(var i = 0; i < queryReturnList.length; i++) {	
		var moreInfoUrl = $("#fundRequirementMoreInfo").attr('url')+"?id="+queryReturnList[i].id;
		
		var li = '<div id="shaDowShow'+i+'"  class="mydiv1" onmouseout="delShaDowClass('+i+')" onmouseover="addShaDowClass('+i+')"><li>'
			li+='<input type="hidden" id="operateId'+i+'" value="'+queryReturnList[i].id+'"/>'
		
			var imgUrl="";
			var attachUrl=queryReturnList[i].attachUrl;
			if(attachUrl!==null && attachUrl!=="" && attachUrl!==undefined){
				imgUrl=attachUrl;
				li+='<a href="'+moreInfoUrl+'" target="_blank"><div class="fl ims">'+'<img style="width:240px;height:182px" src="'+$('#downFile').attr('url')+'?path='+imgUrl+'"/>'+"</div></a>"
			}else{
				imgUrl="../resources/images/front/img/zijinxuqiu.png";
				li+='<a href="'+moreInfoUrl+'" target="_blank"><div class="fl ims">'+'<img style="width:240px;height:182px" src="'+imgUrl+'"/>'+"</div></a>"
			}
			
			li+="<div class='fl rights'>"
			li+='<a href="'+moreInfoUrl+'" target="_blank"><div class="tits">'
			li+="<div class='fl'>"+FrontCommonFunction.replaceNull(queryReturnList[i].name)+"</div>"
			li+="<div class='fr'>"+FrontCommonFunction.setPhase(queryReturnList[i].projectPhase)+"</div>"	
			li+="<div class='clear'></div>"
			li+="</div></a>"
			li+='<a href="'+moreInfoUrl+'" target="_blank"><div class="cs">'
			li+=FrontCommonFunction.getResultMaitText(queryReturnList[i].projectIntro,300,"#fundRequirementMoreInfo",queryReturnList[i].id)
			li+="</div></a>"
			li+='<div class="f">'
			li+='<a href="'+moreInfoUrl+'" target="_blank"><div style=" margin-top:60px" class="fl">'+FrontCommonFunction.setDomain(queryReturnList[i].domain)+"&nbsp;&nbsp;"+FrontCommonFunction.replaceNull(queryReturnList[i].companyUserResultModel.province)+"&nbsp;&nbsp;"+FrontCommonFunction.setStrAmount(queryReturnList[i].amountNeeded)+"&nbsp;&nbsp;"+FrontCommonFunction.setRequirementStatus(queryReturnList[i].status)+"</div></a>"
			li+='<div class="fr" style=" margin-top:60px">'	
			li+=cooperateCollectFlagDiv(queryReturnList[i], i)
			li+="</div>"
			li+="</div>"
			li+="</div>"
			li+="<div class='clear'></div>"
			li+='</li></div>';
		$("#fundRequirementListQuery").append(li);
	}
	if (queryReturnList.length !== 0) {
		FrontCommonFunction.pagination(datas.pagination.sumPage, '#currentPage', '#pagination', that, 'fundRequirementQuery');
		cooperateCollectActionControl('fundRequirement', '#fundRequirementAddFollowerUrl', '#fundRequirementCancelFollowerUrl');
	}
};