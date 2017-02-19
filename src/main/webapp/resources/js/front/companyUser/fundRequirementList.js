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
		$('#currentPage').val('1');
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
			var moreInfoUrl = $("#fundRequirementMoreInfo").attr('url')+"?id="+queryReturnList[i].id;
			var li = '<div id="shaDowShow'+i+'"  class="mydiv1" onmouseout="delShaDowClass('+i+')" onmouseover="addShaDowClass('+i+')"><li>'
			li+='<input type="hidden" id="operateId'+i+'" value="'+queryReturnList[i].id+'"/>'
			var imgUrl="";
			var logoUrl =queryReturnList[i].logoUrl;
			if(logoUrl!==null && logoUrl!=="" && logoUrl!==undefined){
				imgUrl=logoUrl;
				li+='<a href="'+moreInfoUrl+'"><div class="fl ims">'+'<img style="width:240px;height:182px" src="'+$('#downFile').attr('url')+'?path='+imgUrl+'"/>'+"</div></a>"
			}else{
				imgUrl="../resources/images/front/img/zijinxuqiu.png";
				li+='<a href="'+moreInfoUrl+'"><div class="fl ims">'+'<img style="width:240px;height:182px" src="'+imgUrl+'"/>'+"</div></a>"
			}
			li+="<div class='fl rights'>"
			li+='<a href="'+moreInfoUrl+'"><div class="tits">'
			li+="<div class='fl'>"+FrontCommonFunction.replaceNull(queryReturnList[i].name)+"</div>"
			li+="<div class='fr'>"+FrontCommonFunction.setPhase(queryReturnList[i].projectPhase)+"</div>"	
			li+="<div class='clear'></div>"
			li+="</div></a>"
			li+='<a href="'+moreInfoUrl+'"><div style=" margin-bottom:-30px" class="cs">'
			li+=FrontCommonFunction.getResultMaitText(queryReturnList[i].projectIntro,200,"#fundRequirementMoreInfo",queryReturnList[i].id)
			li+="</div></a>"
			li+="<div class='f'>"
			li+='<a href="'+moreInfoUrl+'"><div style=" margin-top:58px" class="fl">'+FrontCommonFunction.setDomain(queryReturnList[i].domain)+"&nbsp;&nbsp;"+FrontCommonFunction.replaceNull(queryReturnList[i].companyUserResultModel.province)+"&nbsp;&nbsp;"+FrontCommonFunction.setStrAmount(queryReturnList[i].amountNeeded)+"&nbsp;&nbsp;"+FrontCommonFunction.setRequirementStatus(queryReturnList[i].status)+"</div></a>"
			li+='<div class="fr" style=" margin-top:50px">'		
			li+=cooperateCollectFlagDiv(queryReturnList[i], i)
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
			cooperateCollectFlagControl('fundRequirement');
			cooperateCollectActionControl('fundRequirement');
		}
	};
	$.ajax(FrontCommonFunction.baseOptions);
};

function getData() {
	var paramTemp = {};
	
	var companyUserQueryModel = {};
	var fundRequirementQueryModel={};
	var searchHeaderName=$('#searchHeaderName').val();
	if(searchHeaderName!==""){
		fundRequirementQueryModel['name']=searchHeaderName;
	}
	fundRequirementQueryModel['domain']=$.trim($("#domainId").val());
	fundRequirementQueryModel['amountNeeded']=$.trim($('#amountId').val());
	fundRequirementQueryModel['status']=$.trim($('#statusId').val());
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
	getDefaultQuery('fundRequirement', '1', fundRequirementQueryModel); 
	paramTemp['fundRequirementQueryModel'] = fundRequirementQueryModel;
	var userQueryModel = {};
	getDefaultQuery('user', '1', userQueryModel);
	paramTemp['userQueryModel'] = userQueryModel;
	return paramTemp;
};