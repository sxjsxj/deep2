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
	initMyAchievementManager();
	//设置左侧导航
	setLeftNav('#researchGroupMyAchievement');
	//发布科研成果
	$('#publishMyAchievement').click(function() {
		// 此处应该先查询 当前用户是否维护了 科研团队信息。
		//科研团队id 为空则没有维护,否则维护
		//根据科研用户id查出researchgroup查到代表维护，没查到代表为维护
		getReserachGroup();
		//getReserachGroup此方法调用后查到会设置id
		var  hasResearchGroup=$("#hasResearchGroup").val();
		if(hasResearchGroup===""){
			$('#altsone').show();
		}else{
			var url =$('#addAchieveMentPageUrl').attr('url');
			location.href=url;
		}
    });
	$('#altsone').hide();
	$('.img2').click(function(){
		$('#altsone').hide();
		//ShowDiv('MyDiv','fade')
	});

});

var queryParam = {};
function initMyAchievementManager() {

	//审核状态页
	$('#child0').click(function() {
		$('#childtagValue').val("-1");
		$('[id^=child]').removeClass("active");
		$('#child0').addClass("active");
		$('#currentPage').val('1');
	    query(queryParam);
    });
	$('#child1').click(function() {
		$('#childtagValue').val("0");
		$('[id^=child]').removeClass("active");
		$('#child1').addClass("active");
		$('#currentPage').val('1');
	    query(queryParam);
    });
	$('#child2').click(function() {
		$('#childtagValue').val("1");
		$('[id^=child]').removeClass("active");
		$('#child2').addClass("active");
		$('#currentPage').val('1');
	    query(queryParam);
    });
	$('#child3').click(function() {
		$('#childtagValue').val("2");
		$('[id^=child]').removeClass("active");
		$('#child3').addClass("active");
		$('#currentPage').val('1');
	    query(queryParam);
    });
	$('#child4').click(function() {
		$('#childtagValue').val("3");
		$('[id^=child]').removeClass("active");
		$('#child4').addClass("active");
		$('#currentPage').val('1');
	    query(queryParam);
    });
	$('#child5').click(function() {
		$('#childtagValue').val("4");
		$('[id^=child]').removeClass("active");
		$('#child5').addClass("active");
		$('#currentPage').val('1');
	    query(queryParam);
    });
	$('#child6').click(function() {
		$('#childtagValue').val("5");
		$('[id^=child]').removeClass("active");
		$('#child6').addClass("active");
		$('#currentPage').val('1');
	    query(queryParam);
    });
	//页面加载查询
	$('#childtagValue').val("-1");
	query(queryParam);
};

function query(param) {
	var that=this;
	param = getData();
	// 清空列表
	$('#myAchievementQuery').html("");
	$('#noResult').html('');
	$('#pagination').html('');
	var url =$('#queryAchievement').attr('url');
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
				noresult+="暂未找到符合要求的记录"
				noresult+="</div>"
					noresult+="<div class='my_tuijian_con_txt'>"
					noresult+="</div>"
			noresult+="</div>"
			noresult+="</div>"
			$('#noResult').html(noresult);
			return;
		}
		var child1=0;
		var child2=0;
		var child3=0;
		var child4=0;
		var child5=0;
		var child6=0;
		for(var i = 0; i < queryReturnList.length; i++) {
			var status=queryReturnList[i].status;
			if(status=== '0'){
				child1++;
			}else if(status=== '1'){
				child2++;
			}else if(status=== '2'){
				child3++;
			}else if(status=== '3'){
				child4++;
			}else if(status=== '4'){
				child5++;
			}else if(status=== '5'){
				child6++;
			}

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
			var templi='';
			var imgUrl="";
			var img=queryReturnList[i].researchGroupResultModel.logoUrl;
			if(img!==null && img!=="" && img!==undefined){
				imgUrl=img;
				templi+='<img src="'+$('#downFile').attr('url')+'?path='+imgUrl+'" style="width:240px;height:182px"/>'
			}else{
				imgUrl="../resources/images/front/img/keyanchengguo.png";
				templi+='<img src="'+imgUrl+'" style="width:240px;height:182px"/>'
			}
			var li='<div id="shaDowShow'+i+'"  class="mydiv1" onmouseout="delShaDowClass('+i+')" onmouseover="addShaDowClass('+i+')"><li>'
				li+='<input type="hidden" id="operateId'+i+'" value="'+queryReturnList[i].id+'"/>'
				li+='<input type="hidden" id="status'+i+'" value="'+queryReturnList[i].status+'"/>'
				li+='<a href="'+moreInfoUrl+'" target="_blank"><div class="fl ims">'
				li+=templi;
			    li+="</div><a>"
				li+="<div class='fl rights'>"
				  li+='<a href="'+moreInfoUrl+'" target="_blank"><div class="titl">'
			        li+="<div class='fl les'>"+FrontCommonFunction.setTextSize(queryReturnList[i].name, 20, '...')+"</div>"
					li+="<div class='fr'>"
					 li+="<div class='fl'>"+FrontCommonFunction.setAchievementStatus(queryReturnList[i].status)+"</div>"
					 li+="<div class='fl ge'>"+FrontCommonFunction.setStrInvestorPhase(queryReturnList[i].phase)+"</div>"
					 li+="<div class='clear'></div>"
					li+="</div>"
					li+="<div class='clear'></div>"
				  li+="</div></a>"

				  li+='<a href="'+moreInfoUrl+'" target="_blank"><div class="cs">'
					  li+=FrontCommonFunction.getResultMaitText(queryReturnList[i].solution,200,"#achievementMoreInfo",queryReturnList[i].id)
				  li+="</div></a>"

				li+="<div class='b'>"
					  li+='<div class="fl">'
					   	li+="<span>"+'<a href="'+moreInfoUrl+'" target="_blank">'+FrontCommonFunction.setInvestorDomain(queryReturnList[i].domain)+"</span>"
						  li+="<span>"+provinceName+"</span>"
						 	li+="<span>"+FrontCommonFunction.setAmount(queryReturnList[i].amount)+"</span>"
						  li+="<span>"+FrontCommonFunction.setRequirementStatus(queryReturnList[i].status)+"</a></span>"

						li+="</div>"
					  li+='<div class="fr">'
						  li+='<div class="fl look">'
						    li+="<div class='coll'>收藏量："+FrontCommonFunction.replaceNull(queryReturnList[i].concernNumber)+"</div>"
						    li+="<div class='find'>访问量："+FrontCommonFunction.replaceNull(queryReturnList[i].scanNumber)+"</div>"
						  li+="</div>"
							  li+='<div id="edit'+i+'" class="fl bianji">编辑</div>'
							  li+='<div id="delete'+i+'" class="fl del">删除</div>'
						  li+="<div class='clear'></div>"
					 li+="</div>"

				  li+="<div class='clear'></div>"
				li+="</div>"

				li+="</div>"
				li+="<div class='clear'></div>"
				li+='</li></div>';
			$("#myAchievementQuery").append(li);

			$('#edit'+i).click(function() {
				//edit固定长度4
				var idIndex=$(this).attr("id").substring(4);
				var id="#operateId"+idIndex
				var idValue=$(id).val();
				var url=$('#achievementDetail').attr('url');
				location.href=url+"?id="+idValue;
			});

			$('#delete'+i).click(function() {
				//delete固定长度6
				var idIndex=$(this).attr("id").substring(6);
				var statusId="#status"+idIndex
				var status=	$(statusId).val();

				if(status==="0" || status==="1" || status==="3"){
					var id="#operateId"+idIndex
					var idValue=$(id).val();
					var url=$('#achievementDelete').attr('url');
					var delParam=[];
					delParam[0]=idValue;
					var jsonStr=JSON.stringify(delParam);
					var reqParam={};
					reqParam['str']=jsonStr;
					delAchievement(reqParam,url)
				 }else{
					 $('#altsnotdel').show();
				 }
			});
		}

		var cf=$("#child0FlagFirst").val();
		if(cf==="0"){
			$("#child0FlagFirst").val("1");
			$("#child0").html("所有项目（"+queryReturnList.length+"）");
			$("#child1").html("待审核（"+child1+"）");
			// $("#child2").html("征集中（"+child2+"）");
			$("#child3").html("洽谈中（"+child3+"）");
			$("#child4").html("合作中（"+child4+"）");
			$("#child5").html("已完成（"+child5+"）");
			$("#child6").html("已拒绝（"+child6+"）");
		}

		if (queryReturnList.length !== 0) {
			FrontCommonFunction.pagination(datas.pagination.sumPage, '#currentPage', '#pagination', that, 'query');
		}
	};
	$.ajax(FrontCommonFunction.baseOptions);
};

function delAchievement(reqParam,url){
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
}

function getData() {
	var status=$('#childtagValue').val();
	var paramTemp = {};

	var achievementQueryModel = {};
	getDefaultQuery('achievement', '2', achievementQueryModel);
	if(status!=="-1"){
		achievementQueryModel['status']=status;
	}
	paramTemp['achievementQueryModel']=achievementQueryModel;
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

function getReserachGroup() {
	var url = $('#getResearchGroup').attr('url');
	//从header获取科研用户id
	var commonResearchUsrId= $('#commonResearchUserId').val();
	var queryParam={};
	var researchGroupQueryModel = {};
	getDefaultQuery('researchGroup', '2', researchGroupQueryModel);
	queryParam['researchGroupQueryModel'] = researchGroupQueryModel;
	var universityUserQueryModel={};
	universityUserQueryModel['id']=commonResearchUsrId;
	var organizationUserQueryModel = {};
	organizationUserQueryModel['id']=commonResearchUsrId;
	queryParam['universityUserQueryModel']=universityUserQueryModel;
	queryParam['organizationUserQueryModel'] = organizationUserQueryModel;
	var jsonStr=JSON.stringify(queryParam);
	var data = {};
	data['str']=jsonStr;
	FrontCommonFunction.baseOptions['url'] = url;
	FrontCommonFunction.baseOptions['data'] = data;
	FrontCommonFunction.baseOptions['success'] = function(datas) {
		if(datas.queryReturnList.length > 0){
			//表示已经维护设置researchGroupId
			$("#hasResearchGroup").val("true");
		}else{
			$("#hasResearchGroup").val("");
		}
	};
	$.ajax(FrontCommonFunction.baseOptions);
};
