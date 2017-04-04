$(document).ready(function() {
	$('#altstwo').hide();
	$('#altsthree').hide();
	$('#nologin').hide();
	$('.img2').click(function(){
		$('#nologin').hide();
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

	//研发类型
	$("#checkBoxType [id^=typeCheckBox]").click(function() {
		//typeCheckBox固定长度是12
		var idIndex=$(this).attr("id").substring(12);
		//固定属性：amountCheckBoxValue
		if($("#typeCheckBoxValue"+idIndex).hasClass("on")){
			 $("#typeCheckBoxValue"+idIndex).removeClass("on");
		}else{
			 $("#typeCheckBoxValue"+idIndex).attr("class","on");
		}
		text = $("#checkBoxType [id^=typeCheckBoxValue]input[class=on]").map(function(index,elem) {
			return $(elem).val();
		}).get().join(',');
		$("#typeId").val(text);
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
	$('#queryTechRequirement').click(function() {
		$('#currentPage').val('1');
	    query(queryParam);
    });
};

function query(param) {
	var that=this;
	param = getData();
	// 清空列表
	$('#techRequirementListQuery').html("");
	$('#noResult').html('');
	$('#pagination').html('');
	var url = $('#queryTechRequirement').attr('url');
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
			var moreInfoUrl = $("#techRequirementMoreInfo").attr('url')+"?id="+queryReturnList[i].id;
			var li = '<div id="shaDowShow'+i+'"  class="mydiv1 list-no-img" onmouseout="delShaDowClass('+i+')" onmouseover="addShaDowClass('+i+')"><li>'
			var imgUrl="";
			var temli='';
			var logoUrl =queryReturnList[i].logoUrl;
			if(logoUrl!==null && logoUrl!=="" && logoUrl!==undefined){
				imgUrl=logoUrl;
				temli='<a href="'+moreInfoUrl+'" target="_blank"><div class="fl ims">'+'<img style="width:240px;height:182px" src="'+$('#downFile').attr('url')+'?path='+imgUrl+'"/>'+"</div></a>"
			}else{
				imgUrl="../resources/images/front/img/jishuxuqu.png";
				temli='<a href="'+moreInfoUrl+'" target="_blank"><div class="fl ims">'+'<img style="width:240px;height:182px" src="'+imgUrl+'"/>'+"</div></a>"
			}

			li+='<input type="hidden" id="operateId'+i+'" value="'+queryReturnList[i].id+'"/>'
			//li+=temli;
			li+='<a href="'+moreInfoUrl+'" target="_blank"><div class="fl ims"><div class="fl rights">'
			li+="<div class='tits'>"
			li+="<div class='fl'>"+FrontCommonFunction.replaceNull(queryReturnList[i].name)+"</div>"
			li+="<div class='fr'>"+FrontCommonFunction.setType(queryReturnList[i].type)+"</div>"
			li+="<div class='clear'></div>"
			li+="</div></a>"
			li+='<a href="'+moreInfoUrl+'" target="_blank"><div class="cs">'
			li+="</div></a>"
			li+="<div class='f'>"
			li+='<a href="'+moreInfoUrl+'" target="_blank"><div class="fl">'+FrontCommonFunction.setDomain(queryReturnList[i].domain)+"&nbsp;&nbsp;"+FrontCommonFunction.replaceNull(queryReturnList[i].companyUserResultModel.province)+"&nbsp;&nbsp;"+FrontCommonFunction.setAmount(queryReturnList[i].amount)+"&nbsp;&nbsp;"+FrontCommonFunction.setRequirementStatus(queryReturnList[i].status)+"</div></a>"
			li+='<div class="fr">'
			li+=cooperateCollectFlagDiv(queryReturnList[i], i)
			li+="</div>"
			li+="</div>"
			li+="</div>"
			li+="<div class='clear'></div>"
			li+='</li></div>';
			$("#techRequirementListQuery").append(li);

			var $el = $("#techRequirementListQuery").find(".cs:last-child");
			FrontCommonFunction.limitTextLineNum($el, queryReturnList[i].detail,"#techRequirementMoreInfo",queryReturnList[i].id, '...');
		}
		if (queryReturnList.length !== 0) {
			FrontCommonFunction.pagination(datas.pagination.sumPage, '#currentPage', '#pagination', that, 'query');
			//控制登录用户
			cooperateCollectFlagControl('techRequirement');
			cooperateCollectActionControl('techRequirement');
		}
	};
	$.ajax(FrontCommonFunction.baseOptions);
};

function getData() {
	var paramTemp = {};

	var companyUserQueryModel = {};
	var techRequirementQueryModel={};
	var searchHeaderName=$('#searchHeaderName').val();
	if(searchHeaderName!==""){
		techRequirementQueryModel['name']=searchHeaderName;
	}
	techRequirementQueryModel['domain']=$.trim($("#domainId").val());
	techRequirementQueryModel['amount']=$.trim($('#amountId').val());
	techRequirementQueryModel['status']=$.trim($('#statusId').val());
	techRequirementQueryModel['cooperationType']=$.trim($('#cooperationTypeId').val());
	techRequirementQueryModel['type']=$.trim($('#typeId').val());
    if($("#onlySeeLocalCity").hasClass("on")){
		//加入勾选本市值
		companyUserQueryModel['province']=$("#commonMySelfProvince").val();
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
		companyUserQueryModel['province']=array.toString();
	}
	getDefaultQuery('companyUser', '1', companyUserQueryModel);
	paramTemp['companyUserQueryModel']=companyUserQueryModel;
	getDefaultQuery('techRequirement', '1', techRequirementQueryModel);
	paramTemp['techRequirementQueryModel'] = techRequirementQueryModel;
	if($('#statusId').val() !== '') {
		techRequirementQueryModel['status']=$.trim($('#statusId').val());
	}
	var userQueryModel = {};
	getDefaultQuery('user', '1', userQueryModel);
	paramTemp['userQueryModel'] = userQueryModel;
	return paramTemp;
};
