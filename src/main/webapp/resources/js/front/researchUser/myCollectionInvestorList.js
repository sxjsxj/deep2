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
	initInvestorListManager();
	//设置左侧导航
	setLeftNav('#researchGroupMyCollectionInvestor');
});

var queryParam = {};
function initInvestorListManager() {
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
	$("#checkBoxInvestPhase [id^=investPhaseCheckBox]").click(function() {
		//investPhaseCheckBox固定长度是19
		var idIndex=$(this).attr("id").substring(19);
		//固定属性：investPhaseCheckBoxValue
		if($("#investPhaseCheckBoxValue"+idIndex).hasClass("on")){
			 $("#investPhaseCheckBoxValue"+idIndex).removeClass("on");
		}else{
			 $("#investPhaseCheckBoxValue"+idIndex).attr("class","on");
		}
		text = $("#checkBoxInvestPhase [id^=investPhaseCheckBoxValue]input[class=on]").map(function(index,elem) {
			return $(elem).val();
		}).get().join(',');
		$("#investPhaseId").val(text);
	});

	//页面加载查询
	queryParam = getData();
	query(queryParam);
	$('#queryInvestor').click(function() {
		$('#currentPage').val('1');
	    query(queryParam);
    });
};

function query(param) {
	var that=this;
	param = getData();
	// 清空列表
	$('#investorListQuery').html("");
	$('#noResult').html('');
	$('#pagination').html('');
	var url = $('#queryInvestor').attr('url');
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
				noresult+="<div class='my_tuijian_con_title'>"
				noresult+="<font style='align:center;color:#333333;'>未查询到任何记录</font>"
				noresult+='<div style="align:center;color:#349fc4;margin-top:-5px;" ><a href="../investorUser/getBrowsePage">现在就查看投资方>></a></div>'
				noresult+="</div>"
					noresult+="<div class='my_tuijian_con_txt'>"
					noresult+="</div>"
			noresult+="</div>"
			noresult+="</div>"
			$('#noResult').html(noresult);
			return;
		}
		for(var i = 0; i < queryReturnList.length; i++) {
			var moreInfoUrl = $("#investorUserMoreInfo").attr('url')+"?id="+queryReturnList[i].id.investorId;
			var li = '<div id="shaDowShow'+i+'"  class="mydiv1" onmouseout="delShaDowClass('+i+')" onmouseover="addShaDowClass('+i+')"><li>'
				li+='<input type="hidden" id="operateId'+i+'" value="'+queryReturnList[i].id.investorId+'"/>'
				li+='<input type="hidden" id="operateIdUserId'+i+'" value="'+queryReturnList[i].id.userId+'"/>'
				li+='<input type="hidden" id="operateFollowerType'+i+'" value="'+queryReturnList[i].followerType+'"/>'
				li+='<input type="hidden" id="operateRelationType'+i+'" value="'+queryReturnList[i].id.relationType+'"/>'

			   var logoUrl=queryReturnList[i].investorUserResultModel.logoUrl;
			   var imgUrl="";
				if(logoUrl!==null && logoUrl!=="" && logoUrl!==undefined){
					imgUrl=logoUrl;
					li+='<a href="'+moreInfoUrl+'" target="_blank"><div class="fl ims">'+'<img style="width:240px;height:182px" src="'+$('#downFile').attr('url')+'?path='+imgUrl+'"/></div></a>'
				}else{
					imgUrl="../resources/images/front/img/touzifang.png";
					li+='<a href="'+moreInfoUrl+'" target="_blank"><div class="fl ims">'+'<img style="width:240px;height:182px" src="'+imgUrl+'"/></div></a>';
				}

				li+="<div class='fl rights'>"
				li+='<a href="'+moreInfoUrl+'" target="_blank"><div class="tits">'	;
				var userType=queryReturnList[i].investorUserResultModel.type;
				//1是个人 显示contactName
				var name="";
				var introduction="";
				if(userType=="1"){
					name=FrontCommonFunction.replaceNull(queryReturnList[i].investorUserResultModel.contactName);
					introduction=FrontCommonFunction.getResultMaitText(queryReturnList[i].investorUserResultModel.investExperience,80,"#investorUserMoreInfo",queryReturnList[i].id);
				}else{
					//0机构显示 name
					name=FrontCommonFunction.replaceNull(queryReturnList[i].investorUserResultModel.name);
					introduction=FrontCommonFunction.getResultMaitText(queryReturnList[i].investorUserResultModel.introduction,80,"#investorUserMoreInfo",queryReturnList[i].id);
				}
				li+="<div class='fl'>"+name+"</div>"
				li+="<div class='fr'>"+FrontCommonFunction.setInbestorUserType(userType)+"</div>"
				li+="<div class='clear'></div>"
				li+="</div></a>"
				li+="<div class='cs'>"
				li+="<div class='mod borderright'>"
				li+='<a href="'+moreInfoUrl+'" target="_blank"><div class="cs_tis">'+"投资领域："+FrontCommonFunction.setStrInvestorDomain(queryReturnList[i].investorUserResultModel.investDomain)+"</div></a>"
				li+='<a href="'+moreInfoUrl+'" target="_blank"><div class="cs_tis">'+"投资阶段："+FrontCommonFunction.setStrInvestorPhase(queryReturnList[i].investorUserResultModel.investPhase)+"</div></a>"
				li+="<div class=''><a class='fl rems'></a><span class='fl'>"+'<a href="'+moreInfoUrl+'" target="_blank">'+"投资概述&nbsp;:&nbsp;"+FrontCommonFunction.getResultMaitText(queryReturnList[i].investorUserResultModel.investOutline,10,"#investorUserMoreInfo",queryReturnList[i].investorUserResultModel.id)+"</a></span><div class='clear'></div></div>"
				li+="</div>"
				li+="<div class='mod marginleft'>"
				li+='<a href="'+moreInfoUrl+'" target="_blank"><div class="cs_tis">'+'简介：'+"</div></a>"
				li+="<div class=''><a class='fl rems'></a><span class='fl'>"+'<a href="'+moreInfoUrl+'" target="_blank">'+introduction+"</a></span><div class='clear'></div></div>"
				li+="</div>"
				li+="<div class='clear'></div>"
				li+="</div>"
				li+="<div class='f'>"
				li+='<a href="'+moreInfoUrl+'" target="_blank"><div style=" margin-top:40px" class="fl">'+FrontCommonFunction.replaceNull(queryReturnList[i].investorUserResultModel.province)+"</div></a>"
				li+='<div class="fr" style=" margin-top:40px">'
				li+=cooperateCollectFlagDiv(queryReturnList[i].investorUserResultModel, i)
				li+="</div>"
				li+="</div>"
				li+="</div>"
				li+="<div class='clear'></div>"
				li+='</li></div>';
			$("#investorListQuery").append(li);
		}
		if (queryReturnList.length !== 0) {
			FrontCommonFunction.pagination(datas.pagination.sumPage, '#currentPage', '#pagination', that, 'query');
			//控制登录用户
			cooperateCollectActionControl('investor', null, null, true,'#queryInvestor');
		}
	};
	$.ajax(FrontCommonFunction.baseOptions);
};

function getData() {
	var paramTemp = {};
	var investorUserQueryModel={};
	investorUserQueryModel['investDomain']=$.trim($("#domainId").val());
	investorUserQueryModel['investAmount']=$.trim($('#amountId').val());
	investorUserQueryModel['investPhase']=$.trim($('#investPhaseId').val());
	 if ($("#onlySeeLocalCity").hasClass("on")) {
		// 加入勾选本市值
		 investorUserQueryModel['province']=$("#commonMySelfProvince").val();
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
		investorUserQueryModel['province']=array.toString();
	}
	paramTemp['investorUserQueryModel']=investorUserQueryModel;
	getDefaultQuery('investorUser', '4', investorUserQueryModel);
	var investorUserFollowerQueryModel = {};
	getDefaultQuery('investorUserFollower', '4', investorUserFollowerQueryModel);
	paramTemp['investorUserFollowerQueryModel']=investorUserFollowerQueryModel;
	paramTemp['userQueryModel'] =getMyInfo();
	return paramTemp;
};
