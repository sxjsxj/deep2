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
	setLeftNav('#companyMyCollectionResearchGroup');
	commonInit();
	initResearchGroupListManager();
});

var queryParam = {};
function initResearchGroupListManager() {
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
	//页面加载查询
	queryParam = getData();
	query(queryParam);
	$('#queryResearchGroup').click(function() {
		$('#currentPage').val('1');
	    query(queryParam);
    });
};


function query(param) {
	var that=this;
	param = getData();
	// 清空列表
	$('#researchGroupListQuery').html("");
	$('#noResult').html('');
	$('#pagination').html('');
	var url = $('#queryResearchGroup').attr('url');
	FrontCommonFunction.baseOptions['url'] = url;
	if (param === null) {
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
			noresult+="<div style='width:900px;margin-top:0px;' class='my_tuijian_con'>"
				noresult+="<div class='my_tuijian_con_title'>"
				noresult+="<font style='color:#333333;'>您还未收藏任何科研团队</font>"
				noresult+='<div style="color:#349fc4;margin-top:-5px;" ><a href="../researchGroup/getBrowsePage">现在就查看科研团队>></a></div>'
				noresult+="</div>"
					noresult+="<div class='my_tuijian_con_txt'>"
					noresult+="</div>"
			noresult+="</div>"
			noresult+="</div>"
			$('#noResult').html(noresult);
			return;
		}
		for(var i = 0; i < queryReturnList.length; i++) {
			var moreInfoUrl = $("#researchGroupMoreInfo").attr('url')+"?id="+queryReturnList[i].researchGroupResultModel.id;;
			var li = '<div id="shaDowShow'+i+'"  class="mydiv1" onmouseout="delShaDowClass('+i+')" onmouseover="addShaDowClass('+i+')"><li>'
				li+='<input type="hidden" id="operateId'+i+'" value="'+queryReturnList[i].id.researchId+'"/>'
				li+='<input type="hidden" id="operateIdUserId'+i+'" value="'+queryReturnList[i].id.userId+'"/>'
				li+='<input type="hidden" id="operateFollowerType'+i+'" value="'+queryReturnList[i].followerType+'"/>'
				li+='<input type="hidden" id="operateRelationType'+i+'" value="'+queryReturnList[i].id.relationType+'"/>'

				var imgUrl="";
				var logoUrl=queryReturnList[i].researchGroupResultModel.logoUrl;
				if(logoUrl!==null && logoUrl!=="" && logoUrl!==undefined){
					imgUrl=logoUrl;
					li+='<a href="'+moreInfoUrl+'"><div class="fl ims">'+'<img style="width:240px;height:182px" src="'+$('#downFile').attr('url')+'?path='+imgUrl+'"/></div></a>'
				}else{
					imgUrl="../resources/images/front/img/keyantuandui.png";
					li+='<a href="'+moreInfoUrl+'"><div class="fl ims">'+'<img style="width:240px;height:182px" src="'+imgUrl+'"/></div></a>'
				}

				li+="<div class='fl rights'>"
				 li+='<a href="'+moreInfoUrl+'"><div class="tits">'
				li+="<div class='fl'>"+FrontCommonFunction.setTextSize(queryReturnList[i].researchGroupResultModel.name, 20, '...')+"</div>"
				li+="<div class='fr'>"+FrontCommonFunction.setResearchUserType(queryReturnList[i].researchGroupResultModel.researchUserResultModel.type)+"</div>"
				li+="<div class='clear'></div>"
				 li+="</div></a>"
				li+="<div class='cs'>"
				li+='<div class="mod borderright">'
				li+='<a href="'+moreInfoUrl+'"><div class="cs_tis">'+"研究方向："+FrontCommonFunction.setInvestorDomain(queryReturnList[i].researchGroupResultModel.domain)+"</div></a>"
				li+="<div class=''><a class='fl rems'></a>"+'<a href="'+moreInfoUrl+'"><span class="fl">'+"简介&nbsp;:&nbsp;"+FrontCommonFunction.getResultMaitText(queryReturnList[i].researchGroupResultModel.introduction,100,"#researchGroupMoreInfo",queryReturnList[i].researchGroupResultModel.id)+"</span></a><div class='clear'></div></div>"
				li+="</div>"
				li+='<div class="mod marginleft">'
				li+='<a href="'+moreInfoUrl+'"><div class="cs_tis">'+'研究成果:'+"</div></a>"
				li+='<div class="">'+"<a class='fl rems'></a><span class='fl'>"+'<a href="'+moreInfoUrl+'">'+FrontCommonFunction.getResultMaitText(queryReturnList[i].researchGroupResultModel.achievement,90,"#researchGroupMoreInfo",queryReturnList[i].researchGroupResultModel.id)+"</a></span><div class='clear'></div></div>"
				li+="</div>"
				li+="<div class='clear'></div>"
				li+="</div>"
				li+="<div class='f'>"
				li+='<div class="fl"><a>'+'<a href="'+moreInfoUrl+'">'+FrontCommonFunction.replaceNull(queryReturnList[i].researchGroupResultModel.researchUserResultModel.uniCity)+"</a></a></div>"
				li+='<div class="fr">'
				li+=cooperateCollectFlagDiv(queryReturnList[i].researchGroupResultModel, i)
				li+="</div>"
				li+="<div class='clear'></div>"
				li+="</div>"
				li+="</div>"
				li+="<div class='clear'></div>"
				li+='</li></div>';
			$("#researchGroupListQuery").append(li);
		}
		if (queryReturnList.length !== 0) {
			FrontCommonFunction.pagination(datas.pagination.sumPage, '#currentPage', '#pagination', that, 'query');
			//控制登录用户
			cooperateCollectActionControl('researchGroup',null,null,true,'#queryResearchGroup');
		}
	};
	$.ajax(FrontCommonFunction.baseOptions);
};

function getData() {
	var paramTemp = {};
	var researchGroupQueryModel = {};
	var universityUserQueryModel = {};
	var organizationUserQueryModel = {};
	researchGroupQueryModel['domain']=$("#domainId").val();
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
	var researchGroupFollowerQueryModel = {};
	getDefaultQuery('researchGroupFollower', '4', researchGroupFollowerQueryModel);
	paramTemp['researchGroupFollowerQueryModel']=researchGroupFollowerQueryModel;
	getDefaultQuery('researchGroup', '4', researchGroupQueryModel);
	paramTemp['researchGroupQueryModel'] = researchGroupQueryModel;
	paramTemp['universityUserQueryModel'] = universityUserQueryModel;
	paramTemp['organizationUserQueryModel'] = organizationUserQueryModel;
	paramTemp['userQueryModel'] =getMyInfo();
	return paramTemp;
};
