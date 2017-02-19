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
	commonInit();
	initAmountDemandListManager();
	//设置左侧导航
	setLeftNav('#researchGroupMyRecommend');
	
	//点击发布科研成果
	$('#publishMyAchievement').click(function() {
		alert(myDomains.length);
		if(myDomains.length == 0){
			$('#altsone').show();
		}else{
			var url = $('#publishAchievement').attr('url');
			location.href=url;
		}
    });
});

var queryParam = {};
var myDomains = [];

function initAmountDemandListManager() {
	//查询条件初始化大区
	FrontCommonFunction.initCheckBoxRegion("#region");
	getReserachGroup();
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
	
	//页面加载查询
	queryParam = getData();
	query(queryParam);
	$('#queryTechRequirement').click(function() {
		$('#currentPage').val('1');
	    query(queryParam);
    });
};

function query(param) {
	param = getData();
	if(myDomains.length == 0){
		var noresult="";
		noresult+="<div align='center' class='fl right'>";
		noresult+="<div class='title'></div>"
		noresult+="<div style='width:900px;margin-top:2px;' class='my_tuijian_con'>"	
			noresult+="<div  class='my_tuijian_con_title'>"	
				noresult+="<font style='align:center;color:#333333;'>您还未维护科研团队信息。</font>"
					noresult+="<div style='margin-top:-2px;align:center;color:#333333;'>维护后将根据您的研究领域，为您推荐优质需求。</div>"
					noresult+='<div style="color:#349fc4;margin-top:-5px;" ><a href="../researchGroup/getDetailPageForAdd">现在维护科研团队信息>></a></div>'
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
			var noresult="";
			noresult+="<div align='center' class='fl right'>";
			noresult+="<div class='title'></div>"
			noresult+="<div style='width:900px;margin-top:2px;' class='my_tuijian_con'>"	
			noresult+="<div style='font-size:18px;' class='my_tuijian_con_title'>"	
			noresult+="<font style='margin-left:-100px;color:#333333;'>暂未找到您所需领域的技术需求，现在为您推荐几个优质技术需求。您所需要的需求，我们会持续为您关注。</font>"
			noresult+="</div>"
			noresult+="<div class='my_tuijian_con_txt'>"
			noresult+="</div>"	
			noresult+="</div>"	
			noresult+="</div>"
			$('#noResult').html(noresult);
			//不考虑领域
			param['techRequirementQueryModel'].domain = '';
			var url = $('#queryTechRequirement').attr('url');
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
    var companyUserQueryModel = {};
	var techRequirementQueryModel = {};
	//加入推荐
	var domains = '';
	for(var tmp in myDomains) {
		domains=tmp+',';
	}
	domains+='a';
	techRequirementQueryModel['domain']=domains;
	techRequirementQueryModel['amount']=$.trim($('#amountId').val());
	techRequirementQueryModel['cooperationType']=$.trim($('#cooperationTypeId').val());
	techRequirementQueryModel['type']=$.trim($('#typeId').val());
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
	getDefaultQuery('techRequirement', '3', techRequirementQueryModel); 
	paramTemp['techRequirementQueryModel'] = techRequirementQueryModel;
	var userQueryModel = {};
	getDefaultQuery('user', '3', userQueryModel);
	paramTemp['userQueryModel'] = userQueryModel;
	return paramTemp;
};

function getReserachGroup() {
	var url = $('#getResearchGroup').attr('url');
	//从header获取科研用户id
	var paramTemp = {};
	var researchGroupQueryModel = {};
	getDefaultQuery('researchGroup', '2', researchGroupQueryModel);
	paramTemp['researchGroupQueryModel'] = researchGroupQueryModel;
	var universityUserQueryModel = {};
	universityUserQueryModel['id']=$('#commonResearchUserId').val();
	var organizationUserQueryModel = {};
	organizationUserQueryModel['id']=$('#commonResearchUserId').val();
	paramTemp['universityUserQueryModel'] = universityUserQueryModel;
	paramTemp['organizationUserQueryModel'] = organizationUserQueryModel;
	paramTemp['userQueryModel'] =getMyInfo();
	var jsonStr=JSON.stringify(paramTemp);
	var data = {};
	data['str']=jsonStr;
	FrontCommonFunction.baseOptions['url'] = url;
	FrontCommonFunction.baseOptions['data'] = data;
	FrontCommonFunction.baseOptions['success'] = function(datas) {
		for(var i = 0; i < datas.queryReturnList.length;i++) {
			myDomains.push((datas.queryReturnList)[i].domain);
		}
	};
	$.ajax(FrontCommonFunction.baseOptions);
};

function display(that, datas, queryReturnList) {
	if (queryReturnList === null || queryReturnList.length === 0) {
		var noresult='';
		noresult+="<div align='center' class='fl right'>";
		noresult+="<div class='title'></div>"
		noresult+="<div style='width:900px;margin-top:2px;' class='my_tuijian_con'>"	
		noresult+="<div class='my_tuijian_con_title'>"	
		noresult+="<font style='align:center;color:#333333;'>暂未找到您所需领域的技术需求，我们会持续为您关注。</font>"
		noresult+="</div>"
		noresult+="<div class='my_tuijian_con_txt'>"
		noresult+="</div>"	
		noresult+="</div>"	
		noresult+="</div>"
		$('#noResult').html(noresult);
		return;
	} 
	for(var i = 0; i < queryReturnList.length; i++) {
		var moreInfoUrl = $("#techRequirementMoreInfo").attr('url')+"?id="+queryReturnList[i].id;
		var li = '<div id="shaDowShow'+i+'"  class="mydiv1" onmouseout="delShaDowClass('+i+')" onmouseover="addShaDowClass('+i+')"><li>'
			li+='<input type="hidden" id="operateId'+i+'" value="'+queryReturnList[i].id+'"/>'
			
			var imgUrl="";
		    var img=queryReturnList[i].logoUrl;
		    if(img!==null && img!=="" && img!==undefined){
		    	imgUrl=img;
		    	li+='<a href="'+moreInfoUrl+'"><div class="fl ims">'+'<img src="'+$('#downFile').attr('url')+'?path='+imgUrl+'"/>'+"</div></a>"
			}else{
				imgUrl="../resources/images/front/img/jishuxuqu.png";
				li+='<a href="'+moreInfoUrl+'"><div class="fl ims">'+'<img src="'+imgUrl+'"/>'+"</div></a>"
			}
		
			li+="<div class='fl rights'>"
			li+='<a href="'+moreInfoUrl+'"><div class="tits">'
			li+="<div class='fl'>"+FrontCommonFunction.replaceNull(queryReturnList[i].name)+"</div>"
			li+="<div class='fr'>"+FrontCommonFunction.setType(queryReturnList[i].type)+"</div>"	
			li+="<div class='clear'></div>"
			li+="</div></a>"
			li+='<a href="'+moreInfoUrl+'"><div class="cs">'
			li+=FrontCommonFunction.getResultMaitText(queryReturnList[i].detail,300,"#techRequirementMoreInfo",queryReturnList[i].id)
			li+="</div></a>"
			li+="<div class='f'>"
			li+='<a href="'+moreInfoUrl+'"><div style=" margin-top:50px" class="fl">'+FrontCommonFunction.setDomain(queryReturnList[i].domain)+"&nbsp;&nbsp;"+FrontCommonFunction.replaceNull(queryReturnList[i].companyUserResultModel.province)+"&nbsp;&nbsp;"+FrontCommonFunction.setAmount(queryReturnList[i].amount)+"&nbsp;&nbsp;"+FrontCommonFunction.setRequirementStatus(queryReturnList[i].status)+"</div></a>"
			li+='<div class="fr" style=" margin-top:60px">'		
			li+=cooperateCollectFlagDiv(queryReturnList[i], i)
			li+="</div>"
			li+="</div>"
			li+="</div>"
			li+="<div class='clear'></div>"
			li+='</li></div>';
		$("#techRequirementListQuery").append(li);
	}
	if (queryReturnList.length !== 0) {
		FrontCommonFunction.pagination(datas.pagination.sumPage, '#currentPage', '#pagination', that, 'query');
		//控制登录用户
		cooperateCollectActionControl('techRequirement');
	}
};