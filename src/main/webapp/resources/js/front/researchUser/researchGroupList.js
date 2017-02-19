$(document).ready(function() {
	dialogControl();
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
	// 清空列表
	param = getData();
	$('#researchGroupListQuery').html("");
	$('#noResult').html('');
	$('#pagination').html('');
	var url = $('#queryResearchGroup').attr('url');
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
			var type=queryReturnList[i].researchUserResultModel.type;
			var provinceName="";
			if(type==="0"){
				provinceName=FrontCommonFunction.replaceNull(queryReturnList[i].researchUserResultModel.uniProvince);
			}else if(type==="1"){
				provinceName=FrontCommonFunction.replaceNull(queryReturnList[i].researchUserResultModel.orgProvince);
			}else if(type==="2"){
				provinceName=FrontCommonFunction.replaceNull(queryReturnList[i].researchUserResultModel.orgProvince);
			}
			var moreInfoUrl = $("#researchGroupMoreInfo").attr('url')+"?id="+queryReturnList[i].id;
			var li = '<div id="shaDowShow'+i+'"  class="mydiv1" onmouseout="delShaDowClass('+i+')" onmouseover="addShaDowClass('+i+')"><li>'
				li+='<input type="hidden" id="operateId'+i+'" value="'+queryReturnList[i].id+'"/>'
			    var imgUrl="";
			    var logoUrl =queryReturnList[i].logoUrl;
				if(logoUrl!==null && logoUrl!=="" && logoUrl!==undefined){
					imgUrl=logoUrl;
					li+='<a href="'+moreInfoUrl+'"><div class="fl ims"><img style="width:240px;height:182px" src="'+$('#downFile').attr('url')+'?path='+imgUrl+'"/></div></a>'
				}else{
					imgUrl="../resources/images/front/img/keyantuandui.png";
					li+='<a href="'+moreInfoUrl+'"><div class="fl ims"><img style="width:240px;height:182px" src="'+imgUrl+'"/></div></a>'
				}
			    li+='<div class="fl rights">'
				li+='<a href="'+moreInfoUrl+'"><div class="tits">'	
				li+="<div class='fl'>"+FrontCommonFunction.replaceNull(queryReturnList[i].name)+"</div>"
			    li+="<div class='fr'>"+FrontCommonFunction.setResearchUserType(queryReturnList[i].researchUserResultModel.type)+"</div>"
			    li+="<div class='clear'></div>"
				li+="</div></a>"
				li+='<div class="cs">'	 
				li+='<div class="mod borderright">'
				li+='<a href="'+moreInfoUrl+'"><div class="cs_tis">'+"研究方向："+queryReturnList[i].field+"</div></a>"
				li+="<div class=''><a class='fl rems'></a>"+"<span class='fl'>"+"简介&nbsp;:&nbsp;"+'<a href="'+moreInfoUrl+'">'+FrontCommonFunction.getResultMaitText(queryReturnList[i].introduction,70,"#researchGroupMoreInfo",queryReturnList[i].id)+"</span></a><div class='clear'></div></div>"
				li+="</div>"
				li+='<div class="mod marginleft">'
				li+='<a href="'+moreInfoUrl+'"><div class="cs_tis">'+'研究成果:'+"</div></a>"
				li+="<div class=''><a class='fl rems'></a><span class='fl'>"+'<a href="'+moreInfoUrl+'">'+FrontCommonFunction.getResultMaitText(queryReturnList[i].achievement,70,"#researchGroupMoreInfo",queryReturnList[i].id)+"</a></span><div class='clear'></div></div>"
				li+="</div>"
				li+="<div class='clear'></div>"
				li+="</div>"	 
				li+="<div class='f'>"
				li+='<div style="margin-top:50px" class="fl"><a>'+'<a href="'+moreInfoUrl+'">'+FrontCommonFunction.setDomain(queryReturnList[i].domain) + "&nbsp;&nbsp;" +provinceName+"</a></a></div>" 
				li+='<div class="fr" style=" margin-top:40px">'	
				li+=cooperateCollectFlagDiv(queryReturnList[i], i)
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
			cooperateCollectFlagControl('researchGroup');
			cooperateCollectActionControl('researchGroup');
		}
	};
	$.ajax(FrontCommonFunction.baseOptions);
};		

function getData() {
	var paramTemp = {};
	
	var researchGroupQueryModel = {};
	var searchHeaderName=$('#searchHeaderName').val();
	if(searchHeaderName!==""){
		researchGroupQueryModel['name']=searchHeaderName;
	}
	researchGroupQueryModel['domain']=$("#domainId").val();
	var universityUserQueryModel = {};
	var organizationUserQueryModel = {};
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
	getDefaultQuery('researchGroup', '1', researchGroupQueryModel);
	paramTemp['researchGroupQueryModel'] = researchGroupQueryModel;
	paramTemp['universityUserQueryModel'] = universityUserQueryModel;
	paramTemp['organizationUserQueryModel'] = organizationUserQueryModel;
	var userQueryModel = {};
	getDefaultQuery('user', '1', userQueryModel);
	paramTemp['userQueryModel'] = userQueryModel;
	return paramTemp;
};