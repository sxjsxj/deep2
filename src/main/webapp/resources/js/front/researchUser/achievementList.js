$(document).ready(function() {
	dialogControl();
	//寻求合作end
	commonInit();
	initAchievementListManager();
});

var queryParam = {};
function initAchievementListManager() {
	FrontCommonFunction.initCheckBoxBaseResearchField("#checkBoxDomain");
	//查询条件初始化大区
	FrontCommonFunction.initCheckBoxRegion("#region");
	//设置大区
	setRegionClick();
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
	$('#queryAchievement').click(function() {
		$('#currentPage').val('1');
	    query(queryParam);
    });
};

function query(param) {
	param = getData();
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
			$('#noResult').html('<font color="red">未查询到符合条件的记录！</font>');
			return;
		}
		for(var i = 0; i < queryReturnList.length; i++) {
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
			var logoUrl =queryReturnList[i].logoUrl;
			if(logoUrl!==null && logoUrl!=="" && logoUrl!==undefined){
				imgUrl=logoUrl;
				li+='<a href="'+moreInfoUrl+'"><div class="fl ims">'+'<img style="width:240px;height:182px" src="'+$('#downFile').attr('url')+'?path='+imgUrl+'"/>'+"</div></a>"
			}else{
				imgUrl="../resources/images/front/img/keyanchengguo.png";
				li+='<a href="'+moreInfoUrl+'"><div class="fl ims">'+'<img style="width:240px;height:182px" src="'+imgUrl+'"/>'+"</div></a>"
			}
			li+="<div class='fl rights'>"
			li+='<a href="'+moreInfoUrl+'"><div class="tits">'
			li+="<div class='fl'>"+FrontCommonFunction.setTextSize(queryReturnList[i].name, 20, '...')+"</div>"
			li+="<div class='fr'>"+FrontCommonFunction.setInvestorPhase(queryReturnList[i].phase)+"</div>"
			li+="<div class='clear'></div>"
			li+="</div></a>"
			li+='<a href="'+moreInfoUrl+'"><div class="cs">'
			li+="</div></a>"
			li+="<div class='f'>"
			li+='<a href="'+moreInfoUrl+'"><div class="fl">'+FrontCommonFunction.setInvestorDomain(queryReturnList[i].domain)+"&nbsp;&nbsp;"+provinceName+"&nbsp;&nbsp;"+FrontCommonFunction.setAmount(queryReturnList[i].amount)+"&nbsp;&nbsp;"+FrontCommonFunction.setRequirementStatus(queryReturnList[i].status)+"</div></a>"
			li+='<div class="fr">'
			li+=cooperateCollectFlagDiv(queryReturnList[i], i)
			li+="</div>"
			li+="</div>"
			li+="</div>"
			li+="<div class='clear'></div>"
			li+='</li></div>';
			$("#achievementListQuery").append(li);

			var $el = $("#achievementListQuery").find(".cs:last-child");
			FrontCommonFunction.limitTextLineNum($el, queryReturnList[i].solution,"#achievementMoreInfo",queryReturnList[i].id);
		}
		if (queryReturnList.length !== 0) {
			FrontCommonFunction.pagination(datas.pagination.sumPage, '#currentPage', '#pagination', that, 'query');
			//控制登录用户
			cooperateCollectFlagControl('achievement');
			cooperateCollectActionControl('achievement');
		}
	};
	$.ajax(FrontCommonFunction.baseOptions);
};


function getData() {
	var paramTemp = {};
	var achievementQueryModel = {};
	var universityUserQueryModel = {};
	var organizationUserQueryModel = {};
	var searchHeaderName=$('#searchHeaderName').val();
	if(searchHeaderName!==""){
		achievementQueryModel['name']=searchHeaderName;
	}
	achievementQueryModel['domain']=$.trim($("#domainId").val());
	achievementQueryModel['amount']=$.trim($('#amountId').val());
	achievementQueryModel['phase']=$.trim($('#phaseId').val());
	achievementQueryModel['cooperationType']=$.trim($('#cooperationTypeId').val());
	 if ($("#onlySeeLocalCity").hasClass("on")) {
		// 加入勾选本市值
		universityUserQueryModel['uniProvince']=$("#commonMySelfProvince").val();
		organizationUserQueryModel['orgProvince']=$("#commonMySelfProvince").val();
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
		universityUserQueryModel['uniProvince']=array.toString();
		organizationUserQueryModel['orgProvince']=array.toString();
	}
	getDefaultQuery('achievement', '1', achievementQueryModel);
	paramTemp['achievementQueryModel']=achievementQueryModel;
	if($('#statusId').val() !== '') {
		achievementQueryModel['status']=$.trim($('#statusId').val());
	}
	var researchGroupQueryModel = {};
	getDefaultQuery('researchGroup', '1', researchGroupQueryModel);
	paramTemp['researchGroupQueryModel'] = researchGroupQueryModel;
	paramTemp['universityUserQueryModel'] = universityUserQueryModel;
	paramTemp['organizationUserQueryModel'] = organizationUserQueryModel;
	var userQueryModel = {};
	getDefaultQuery('user', '1', userQueryModel);
	paramTemp['userQueryModel'] = userQueryModel;
	return paramTemp;
};
