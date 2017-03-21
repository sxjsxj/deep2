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

	//设置左侧导航
	initLoginUser();
	setLeftNav('#companyMyRequirement');
	initMyRequirementManager();
});

var queryParam = {};
function initMyRequirementManager() {
	//点击发布需求
	$('#publishMyRequirement').click(function() {
		//企业用户id 为空则没有维护企业信息,否则维护
		var commonCompanyUserId=$('#commonCompanyUserId').val();
		var commonMySelfDomain=$('#commonMySelfDomain').val();

		if(commonCompanyUserId != '' && commonMySelfDomain != ''){
			$('#alts').show();
		}else{
			$('#altsone').show();
		}
    });
	//没有维护企业信息弹框
	$('#altsone').hide();
	$('.img2').click(function(){
		$('#altsone').hide();
	});

	//已经维护企业信息弹框发布需求类型弹框
	$('#alts').hide();
	$('.img2').click(function(){
		$('#alts').hide();
	});

	$('#myTechRequire').click(function(){
		var url = $('#myTechRequire').attr('url');
		location.href=url;
	});

	$('#myFundRequire').click(function(){
		var url = $('#myFundRequire').attr('url');
		location.href=url;
	});

	//技术和资金tag页
	$('#techRequire').click(function() {
		$("#fundRequire").removeClass("active");
		$('#techRequire').addClass("active");
		$('[id^=child]').removeClass("active");
		$('#child0').addClass("active");
		$('#tagValue').val("0");
		$('#childtagValue').val("-1");
		$('#currentPage').val('1');
		$("#child0FlagFirst").val('0');
	    query(queryParam);
    });
	$('#fundRequire').click(function() {
		$("#fundRequire").addClass("active");
		$('#techRequire').removeClass("active");
		$('[id^=child]').removeClass("active");
		$('#child0').addClass("active");
		$('#childtagValue').val("-1");
		$('#tagValue').val("1");
		$('#currentPage').val('1');
		$("#child0FlagFirst").val('0');
	    query(queryParam);
    });
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
	queryParam = getData();
	query(queryParam);
};

function query(param) {
	param = getData();
	var that=this;
	// 清空列表
	$('#requirementListQuery').html("");
	$('#noResult').html('');
	$('#pagination').html('');

	var url ="";
	var tagValue=$("#tagValue").val();
	if(tagValue==="0"){
		url=$('#queryTechRequirement').attr('url');
	}else{
		url=$('#queryFundRequirement').attr('url');
	}
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
				noresult+="<div style='font-size:17px;color:#333333' class='my_tuijian_con_title'>"
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
			if(status==="0"){
				child1++;
			}else if(status==="1"){
				child2++;
			}else if(status==="2"){
				child3++;
			}else if(status==="3"){
				child4++;
			}else if(status==="4"){
				child5++;
			}else if(status==="5"){
				child6++;
			}
			var type="";
			var amount="";
			if(tagValue==="0"){
				type=FrontCommonFunction.setInbestorType(queryReturnList[i].type);
				amount=FrontCommonFunction.setStrAmount(queryReturnList[i].amount);
			}else{
				type=FrontCommonFunction.setInvestorPhase(queryReturnList[i].projectPhase);
				amount=FrontCommonFunction.setStrAmount(queryReturnList[i].amountNeeded);
			}
			var moreInfoUrl = "";
			var styleCss="";
			if(tagValue==="0"){
				moreInfoUrl = $("#techRequirementMoreInfo").attr('url')+"?id="+queryReturnList[i].id;
				styleCss="margin-top:35px;margin-right:10px;";
			}else{
				moreInfoUrl = $("#fundRequirementMoreInfo").attr('url')+"?id="+queryReturnList[i].id;
				styleCss="margin-top:60px;margin-right:10px;";
			}

			var li = '<div id="shaDowShow'+i+'" class="mydiv1" onmouseout="delShaDowClass('+i+')" onmouseover="addShaDowClass('+i+')"><li>'
				li+='<input type="hidden" id="operateId'+i+'" value="'+queryReturnList[i].id+'"/>'
				li+='<input type="hidden" id="status'+i+'" value="'+queryReturnList[i].status+'"/>'
				li+='<a href="'+moreInfoUrl+'"><div class="titl">'
					li+="<div class='fl les'>"+FrontCommonFunction.replaceNull(queryReturnList[i].name)+"</div>"
					li+="<div class='fr'>"
					 li+="<div class='fl'>"+FrontCommonFunction.setRequirementStatus(queryReturnList[i].status)+"</div>"
					 li+="<div class='fl ge'>"+type+"</div>"
					 li+="<div class='clear'></div>"
					li+="</div>"
					li+="<div class='clear'></div>"
				li+="</div></a>"
				li+='<a href="'+moreInfoUrl+'"><div class="txt">'
					li+=FrontCommonFunction.getResultMaitText(queryReturnList[i].detail,100,"#techRequirementMoreInfo",queryReturnList[i].id)
				li+="</div></a>"
				li+="<div class='b'>"
				li+='<a href="'+moreInfoUrl+'"><div style=" margin-top:60px" class="fl">'+"<span>"+FrontCommonFunction.setInvestorDomain(queryReturnList[i].domain)+"</span><span>"+FrontCommonFunction.replaceNull(queryReturnList[i].companyUserResultModel.province)+"</span><span>"+amount+"</span><span>"+FrontCommonFunction.setRequirementStatus(queryReturnList[i].status)+"</span></div></a>"
				li+='<div class="fr" style='+styleCss+'>'
					 li+="<div class='fl look' style='margin-top:5px;'>"
					  li+="<div class='coll'>收藏量："+FrontCommonFunction.replaceNull(queryReturnList[i].concernNumber)+"</div>"
					  li+="<div class='find'>访问量："+FrontCommonFunction.replaceNull(queryReturnList[i].scanNumber)+"</div>"
					 li+="</div>"
				    li+='<div id="edit'+i+'" style="margin-top:10px;" class="fl bianji">编辑</div>'
				    li+='<div id="delete'+i+'" style="margin-top:10px;" class="fl del">删除</div>'
					li+="<div class='clear'></div>"
					li+="</div>"
				li+="<div class='clear'></div>"
				li+="</div>"
				li+='</li></div>';
			$("#requirementListQuery").append(li);

			$('[id^=edit]').click(function() {
				//edit固定长度4
				var idIndex=$(this).attr("id").substring(4);
				var id="#operateId"+idIndex
				var idValue=$(id).val();
				var tagValue=$("#tagValue").val();
				if(tagValue==="0"){
					var url=$('#techRequirementDetail').attr('url');
					location.href=url+"?id="+idValue;
				}else{
					var url=$('#fundRequirementDetail').attr('url');
					location.href=url+"?id="+idValue;
				}
			});

			$('[id^=delete]').click(function() {
				//delete固定长度6
				var idIndex=$(this).attr("id").substring(6);
				var statusId="#status"+idIndex
				var status=	$(statusId).val();
				if(status==="0" || status==="1" || status==="3"){
					var id="#operateId"+idIndex
					var idValue=$(id).val();
					var tagValue=$("#tagValue").val();
					if(tagValue==="0"){
						var url=$('#techRequirementDelete').attr('url');
						var delParam=[];
						delParam[0]=idValue;
						var jsonStr=JSON.stringify(delParam);
						var reqParam={};
						reqParam['str']=jsonStr;

						delMyRequire(reqParam,url)
					}else{
						var url=$('#fundRequirementDelete').attr('url');
						var delParam=[];
						delParam[0]=idValue;
						var jsonStr=JSON.stringify(delParam);
						var reqParam={};
						reqParam['str']=jsonStr;

						delMyRequire(reqParam,url)
					}
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
			$("#child2").html("征集中（"+child2+"）");
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

function delMyRequire(reqParam,url){
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
	var tagValue=$("#tagValue").val();
	var status=$('#childtagValue').val();

	var companyUserQueryModel = {};
	if(tagValue==="0"){
		//技术需求
		var techRequirementQueryModel = {};
		getDefaultQuery('techRequirement', '2', techRequirementQueryModel);
		if(status!=="-1"){
			techRequirementQueryModel['status']=status;
		}
		paramTemp['techRequirementQueryModel'] = techRequirementQueryModel;
		getDefaultQuery('companyUser', '2', companyUserQueryModel);
		paramTemp['companyUserQueryModel']=companyUserQueryModel;
		paramTemp['userQueryModel'] =getMyInfo();
	}else{
		//资金需求
		var fundRequirementQueryModel={};
		getDefaultQuery('fundRequirement', '2', fundRequirementQueryModel);
		if(status!=="-1"){
			fundRequirementQueryModel['status']=status;
		}
		paramTemp['fundRequirementQueryModel'] = fundRequirementQueryModel;
		getDefaultQuery('companyUser', '2', companyUserQueryModel);
		paramTemp['companyUserQueryModel']=companyUserQueryModel;
		paramTemp['userQueryModel'] =getMyInfo();
	}
	return paramTemp;
};
