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
	//没有维护企业信息弹框
	$('#altsone').hide();
	$('.img2').click(function(){
		$('#altsone').hide();
	});

	//已经维护企业信息弹框发布需求类型弹框
	$('#companyAlts').hide();
	$('.img2').click(function(){
		$('#companyAlts').hide();
	});

	//寻求合作start
	$(".altsbg").hide();
	$(".altsubmit").hide();
	$('.close').click(function(){
		$(".altsubmit").hide();
	})
	$('.anniu_cancel-btn').click(function(){
		$(".altsbg").hide();
	})
	//寻求合作end
	$('#techRequire').click(function(){
		var url = $('#techRequire').attr('url');
		location.href=url;
	});

	$('#fundRequire').click(function(){
		var url = $('#fundRequire').attr('url');
		location.href=url;
	});

	//点击发布需求
	$('#publishRequirement').click(function() {
		//企业用户id 为空则没有维护企业信息,否则维护
		var commonCompanyUserId=$('#commonCompanyUserId').val();
		var commonMySelfDomain=$('#commonMySelfDomain').val();

		if(commonCompanyUserId != '' && commonMySelfDomain != ''){
			$('#companyAlts').show();
		}else{
			$('#altsone').show();
		}
    });
    //设置左侧导航
	setLeftNav('#companyMyRecommend');
	commonInit();
	initAchievementListManager();
});

var queryParam = {};
var myDomain = '';

function initAchievementListManager() {
	myDomain = $('#commonMySelfDomain').val();
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
	queryParam = getData();
	query(queryParam);
	$('#queryAchievement').click(function() {
		$('#currentPage').val('1');
	    query(queryParam);
    });
};

function query(param) {
	param = getData();
	if(myDomain == ''){
		var noresult="";
		noresult+="<div align='center' class='fl right'>";
		noresult+="<div class='title'></div>"
		noresult+="<div style='width:900px;margin-top:10px;' class='my_tuijian_con'>"
			noresult+="<div style='font-size:17px;' class='my_tuijian_con_title'>"
			noresult+="<font style='margin-left:-90px;color:#333333;'>您还未维护企业信息。</font>"
				noresult+="<div style='margin-left:-90px;color:#333333;'>维护后，我们将根据您的所在领域，为您推荐优质科研成果。</div>"
			noresult+='<div style="color:#349fc4;margin-top:-5px;" ><a href="../companyUser/getDetailPageForAdd">现在完善企业信息>></a></div>'
			noresult+="</div>"
				noresult+="<div class='my_tuijian_con_txt'>"
				noresult+="</div>"
		noresult+="</div>"
		noresult+="</div>"
		$('#noResult').html(noresult);
		return;
	}
	var that=this;
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
			noresult+="<div align='center' class='fl right'>";
			noresult+="<div class='title'></div>"
			noresult+="<div style='width:900px;margin-top:-18px;' class='my_tuijian_con'>"
			noresult+="<div style='font-size:17px;' class='my_tuijian_con_title'>"
			noresult+="<font style='margin-left:-90px;color:#333333;'>" +
						"暂未找到您所需领域的科研成果，现在为您推荐几个优质科研成果。您所需的科研成果，我们会持续为您关注。</font>"
			noresult+="</div>"
			noresult+="<div class='my_tuijian_con_txt'>"
			noresult+="</div>"
			noresult+="</div>"
			noresult+="</div>"
			//$('#noResult').html(noresult);

			//不考虑领域
			param['achievementQueryModel'].domain = '';
			var url = $('#queryAchievement').attr('url');
			FrontCommonFunction.baseOptions['url'] = url;
			var jsonStr=JSON.stringify(param);
			var requestParamTemp = {};
			requestParamTemp['str']=jsonStr;
			requestParamTemp['currentPage'] = $('#currentPage').val();
			requestParamTemp['maxRecordPerPage'] = FrontCommonFunction.maxRecordPerPage;
			FrontCommonFunction.baseOptions['data'] = requestParamTemp;

			FrontCommonFunction.baseOptions['success'] = function(datas) {
				display(that, datas, datas.queryReturnList);
			}
			$.ajax(FrontCommonFunction.baseOptions);
		}
		display(that, datas, datas.queryReturnList);
	};
	$.ajax(FrontCommonFunction.baseOptions);
};

function getData() {
	var paramTemp = {};
	var achievementQueryModel = {};
	var universityUserQueryModel = {};
	var organizationUserQueryModel = {};
	achievementQueryModel['domain']=myDomain;
	achievementQueryModel['amount']=$.trim($('#amountId').val());
	achievementQueryModel['phase']=$.trim($('#phaseId').val());
	achievementQueryModel['cooperationType']=$.trim($('#cooperationTypeId').val());
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

function display(that, datas, queryReturnList) {
	if (queryReturnList === null || queryReturnList.length === 0) {
		var noresult="";
		/*noresult+="<div align='center' style='margin-top:-5px;' class='fl right'>";
		noresult+="<div class='title'></div>"
		noresult+="<div style='width:900px;margin-top:-18px;' class='my_tuijian_con'>"
		noresult+="<div style='font-size:17px;' class='my_tuijian_con_title'>"
		noresult+="<font style='margin-left:-90px;color:#333333;'>" +
					"暂未找到您所需领域的科研成果，现在为您推荐几个优质科研成果。您所需的科研成果，我们会持续为您关注。</font>"
		noresult+="</div>"
		noresult+="<div class='my_tuijian_con_txt'>"
		noresult+="</div>"
		noresult+="</div>"
		noresult+="</div>"*/
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
		FrontCommonFunction.pagination(datas.pagination.sumPage, '#currentPage', '#pagination', that, 'query');
		//控制登录用户
		cooperateCollectActionControl('achievement');
	}
};
