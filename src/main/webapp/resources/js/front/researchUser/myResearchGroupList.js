$(document).ready(function() {
	$('#altsnotdel').hide();
	$('#altstwo').hide();
	$('#altsthree').hide();
	$('.img2').click(function(){
		$('#altsthree').hide();
		$('#altstwo').hide();
		$('#altsnotdel').hide();
	});
	$('#alertClick').click(function(){
	});
	//弹框start
	$('.registSuccess').click(function(){
		$('#altsthree').show();
	});
	commonInit();
	initResearchGroupListManager();
	//设置左侧导航
	setLeftNav("#researchGroupMyReserachGroup");
	//新建科研团队
	$('#createResearchGroupBtn').click(function() {
		var url = $('#createResearchGroupUrl').attr('url');
		location.href=url;
    });
});

var queryParam = {};
function initResearchGroupListManager() {
	queryParam = getData();
	//页面加载查询
	query(queryParam);
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
	
	var jsonStr=JSON.stringify(param);
	var requestParamTemp = {};
	requestParamTemp['str']=jsonStr;
	requestParamTemp['currentPage'] = $('#currentPage').val();
	requestParamTemp['maxRecordPerPage'] = FrontCommonFunction.maxRecordPerPage;
	requestParamTemp['userQueryModel']=FrontCommonFunction.getCommonUserId();
	FrontCommonFunction.baseOptions['data'] = requestParamTemp;
	
	FrontCommonFunction.baseOptions['success'] = function(datas) {
		var queryReturnList = datas.queryReturnList;
		if (queryReturnList === null || queryReturnList.length === 0) {
			var noresult="";
			noresult+="<div align='center' class='fl right'>";
			noresult+="<div class='title'></div>"
			noresult+="<div style='width:900px;margin-top:2px;' class='my_tuijian_con'>"	
				noresult+="<div style='font-size:18px;' class='my_tuijian_con_title'>"	
				noresult+="暂未找到符合要求的记录"
				noresult+="</div>"
					noresult+="<div class='my_tuijian_con_txt'>"
					noresult+="</div>"	
			noresult+="</div>"	
			noresult+="</div>"
			$('#noResult').html(noresult);
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
			var universityType =  FrontCommonFunction.getUniversityType(queryReturnList[i].researchUserResultModel);
			var moreInfoUrl = $("#researchGroupMoreInfo").attr('url')+"?id="+queryReturnList[i].id;
			var li = '<div id="shaDowShow'+i+'"  class="mydiv1" onmouseout="delShaDowClass('+i+')" onmouseover="addShaDowClass('+i+')"><li>'
				li+='<input type="hidden" id="operateId'+i+'" value="'+queryReturnList[i].id+'"/>'
				li+='<input type="hidden" id="status'+i+'" value="'+queryReturnList[i].status+'"/>'
				var imgUrl="";
			var img=queryReturnList[i].logoUrl;
			if(img!==null && img!=="" && img!==undefined){
				imgUrl=img;
				li+='<a href="'+moreInfoUrl+'"><div class="fl ims">'+'<img src="'+$('#downFile').attr('url')+'?path='+imgUrl+'" style="width:240px;height:182px;"/></div></a>'
			}else{
				imgUrl="../resources/images/front/img/keyantuandui.png";
				li+='<a href="'+moreInfoUrl+'"><div class="fl ims">'+'<img src="'+imgUrl+'" style="width:240px;height:182px;"/></div></a>'
			}
			
			li+="<div class='fl rights'>"
			li+='<a href="'+moreInfoUrl+'"><div class="tits">'	
			li+="<div class='fl'>"+FrontCommonFunction.replaceNull(queryReturnList[i].name)+"</div>"
			li+="<div class='fr'>"+FrontCommonFunction.setResearchGroupStatus(queryReturnList[i].status)+"</div>"
			li+="<div class='clear'></div>"
			li+="</div></a>"
			li+="<div class='cs'>"	 
			li+="<div class='mod borderright'>" 
			li+='<a href="'+moreInfoUrl+'"><div class="cs_tis">'+"研究方向："+queryReturnList[i].field+"</div></a>"
			//li+="<div class=''><a class='fl rems'></a><span class='fl'>"+'<a href="'+moreInfoUrl+'">'+"简介&nbsp;:&nbsp;"+FrontCommonFunction.getResultMaitText(queryReturnList[i].introduction,30,"#researchGroupMoreInfo",queryReturnList[i].id)+"</a></span><div class='clear'></div></div>"
			li+="</div>"
			li+="<div class='mod marginleft'>"
			li+='<a href="'+moreInfoUrl+'"><div class="cs_tis">'+'研究成果:'+"</div></a>"
			li+="<div class=''><a class='fl rems'></a><span class='fl'>"+'<a href="'+moreInfoUrl+'">'+FrontCommonFunction.getResultMaitText(queryReturnList[i].achievement,30,"#researchGroupMoreInfo",queryReturnList[i].id)+"</a></span><div class='clear'></div></div>"
			li+="</div>"
			li+="<div class='clear'></div>"
			li+="</div>"	 
			li+="<div class='b'>"
			li+='<a href="'+moreInfoUrl+'"><div style=" margin-top:35px" class="fl">'
			li+='<div style="margin-top:50px" class="fl"><a>'+'<a href="'+moreInfoUrl+'">'+FrontCommonFunction.setDomain(queryReturnList[i].domain) + "&nbsp;&nbsp;"+ universityType+ "&nbsp;&nbsp;"+provinceName+"</a></a></div>" 
			li+="</div></a>"
			li+='<div class="fr" style=" margin-top:25px">'	
			li+='<div class="fl look">'
			li+="<div class='coll'>收藏量："+FrontCommonFunction.replaceNull(queryReturnList[i].concernNumber)+"</div>"
			li+="<div class='find'>访问量："+FrontCommonFunction.replaceNull(queryReturnList[i].scanNumber)+"</div>"
			li+="</div>"
			li+='<div id="edit'+i+'" class="fl bianji">编辑</div>'
			li+='<div id="delete'+i+'" class="fl del">删除</div>'
			li+="<div class='clear'></div>"
			li+="</div>"  
			li+="</div>"
			li+="<div class='clear'></div>"
			li+='</li></div>';
			$("#researchGroupListQuery").append(li);
			$('#edit'+i).click(function() {
				//edit固定长度4
				var idIndex=$(this).attr("id").substring(4);
				var id="#operateId"+idIndex
				var idValue=$(id).val();
				var url=$('#researchGroupDetail').attr('url');
				location.href=url+"?id="+idValue;
			});
			
			$('#delete'+i).click(function() {
				//delete固定长度6
				var idIndex=$(this).attr("id").substring(6);
				var statusId="#status"+idIndex
				var status=	$(statusId).val();
				
				if(status==="0" || status==="1"){
					var id="#operateId"+idIndex
					var idValue=$(id).val();
					var url=$('#researchGroupDelete').attr('url');
					var delParam=[];
					delParam[0]=idValue;
					var jsonStr=JSON.stringify(delParam);
					var reqParam={};
					reqParam['str']=jsonStr;
					delResearchGroup(reqParam,url)
				 }else{
					 $('#altsnotdel').show();
				 }
			});
		}
		if (queryReturnList.length !== 0) {
			FrontCommonFunction.pagination(datas.pagination.sumPage, '#currentPage', '#pagination', that, 'query');
		}
	};
	$.ajax(FrontCommonFunction.baseOptions);
};

function delResearchGroup(reqParam,url){
	FrontCommonFunction.baseOptions['url'] = url;
	FrontCommonFunction.baseOptions['data'] = reqParam;
	FrontCommonFunction.baseOptions['success'] = function(datas) {
		if(datas.status===0){
			$('#altstwo').show();
			setTimeout(function(){//5秒后隐藏
				$('#altstwo').hide();
				query(queryParam);
			}, 500);
		}else{
			//删除失败 
			$('#errorInfo').html("");
			FrontCommonFunction.processResult(datas,"#alertClick","#errorInfo");
		}
	};
	$.ajax(FrontCommonFunction.baseOptions);
};

function getData() {
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
	return paramTemp;
};