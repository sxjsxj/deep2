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
	setLeftNav('#researchGroupMyCollectionTechRequirement');
});

var queryParam = {};
function initAmountDemandListManager() {
	
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
	// 清空列表
	param = getData();
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
				noresult+="<div class='my_tuijian_con_title'>"	
				noresult+="<font style='align:center;color:#333333;'>您还未收藏任何企业需求</font>"
				noresult+='<div style="align:center;color:#349fc4;margin-top:-5px;" ><a href="../techRequirement/getBrowsePage">现在就查看企业需求>></a></div>'
				noresult+="</div>"
					noresult+="<div class='my_tuijian_con_txt'>"
					noresult+="</div>"	
			noresult+="</div>"	
			noresult+="</div>"
			$('#noResult').html(noresult);
			return;
		} 
		for(var i = 0; i < queryReturnList.length; i++) {	
			var moreInfoUrl = $("#techRequirementMoreInfo").attr('url')+"?id="+queryReturnList[i].id.requirementId;
			var li = '<div id="shaDowShow'+i+'"  class="mydiv1" onmouseout="delShaDowClass('+i+')" onmouseover="addShaDowClass('+i+')"><li>'
				li+='<input type="hidden" id="operateId'+i+'" value="'+queryReturnList[i].id.requirementId+'"/>'
				li+='<input type="hidden" id="operateIdUserId'+i+'" value="'+queryReturnList[i].id.userId+'"/>'
				li+='<input type="hidden" id="operateFollowerType'+i+'" value="'+queryReturnList[i].followerType+'"/>'
				li+='<input type="hidden" id="operateRelationType'+i+'" value="'+queryReturnList[i].id.relationType+'"/>'
			
				var imgUrl="";
			    var img=queryReturnList[i].techRequirementResultModel.attachUrl;
			    if(img!==null && img!=="" && img!==undefined){
			    	imgUrl=img;
			    	li+='<a href="'+moreInfoUrl+'"><div class="fl ims">'+'<img style="width:240px;height:182px;" src="'+$('#downFile').attr('url')+'?path='+imgUrl+'"/>'+"</div></a>"
				}else{
					imgUrl="../resources/images/front/img/jishuxuqu.png";
					li+='<a href="'+moreInfoUrl+'"><div class="fl ims">'+'<img style="width:240px;height:182px;" src="'+imgUrl+'"/>'+"</div></a>"
				}
				li+="<div class='fl rights'>"
				li+='<a href="'+moreInfoUrl+'"><div class="tits">'
				li+="<div class='fl'>"+FrontCommonFunction.replaceNull(queryReturnList[i].techRequirementResultModel.name)+"</div>"
				li+="<div class='fr'>"+FrontCommonFunction.setType(queryReturnList[i].techRequirementResultModel.type)+"</div>"	
				li+="<div class='clear'></div>"
				li+="</div></a>"
				li+='<a href="'+moreInfoUrl+'"><div class="cs">'
				li+=FrontCommonFunction.getResultMaitText(queryReturnList[i].techRequirementResultModel.detail,300,"#techRequirementMoreInfo",queryReturnList[i].id.requirementId)
				li+="</div></a>"
				li+="<div class='f'>"
				li+='<a href="'+moreInfoUrl+'"><div style=" margin-top:60px" class="fl">'+FrontCommonFunction.setDomain(queryReturnList[i].techRequirementResultModel.domain)+"&nbsp;&nbsp;"+FrontCommonFunction.replaceNull(queryReturnList[i].techRequirementResultModel.companyUserResultModel.province)+"&nbsp;&nbsp;"+FrontCommonFunction.setAmount(queryReturnList[i].techRequirementResultModel.amount)+"&nbsp;&nbsp;"+FrontCommonFunction.setRequirementStatus(queryReturnList[i].techRequirementResultModel.status)+"</div></a>"
				li+='<div class="fr" style=" margin-top:60px">'	
				li+=cooperateCollectFlagDiv(queryReturnList[i].techRequirementResultModel, i)
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
			cooperateCollectActionControl('techRequirement', null, null, true,'#queryTechRequirement');
		}
	};
	$.ajax(FrontCommonFunction.baseOptions);
};

function getData() {
	var paramTemp = {};
	
	var companyUserQueryModel = {};
	var techRequirementQueryModel = {};
	techRequirementQueryModel['domain']=$.trim($("#domainId").val());
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
	getDefaultQuery('companyUser', '4', companyUserQueryModel); 
	paramTemp['companyUserQueryModel']=companyUserQueryModel;
	getDefaultQuery('techRequirement', '4', techRequirementQueryModel); 
	paramTemp['techRequirementQueryModel'] = techRequirementQueryModel;
	var techRequirementFollowerQueryModel = {};
	getDefaultQuery('techRequirementFollower', '4', techRequirementFollowerQueryModel); 
	paramTemp['techRequirementFollowerQueryModel']=techRequirementFollowerQueryModel;
	paramTemp['userQueryModel'] =getMyInfo();
	return paramTemp;
};