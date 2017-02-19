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
	
	//高校初始化省份
	FrontCommonFunction.initSelectProvince("#selectUniProvince");
	//高校初始化市
	FrontCommonFunction.initSelectCity("#selectUniCity");
	
	//科研机构初始化省份
	FrontCommonFunction.initSelectProvince("#selectOrgProvince");
	//科研机构初始化市
	FrontCommonFunction.initSelectCity("#selectOrgCity");
	
	//个人初始化省份
	FrontCommonFunction.initSelectProvince("#selectPersonalProvince");
	//个人始化市
	FrontCommonFunction.initSelectCity("#selectPersonalCity");
	
	//设置左侧导航
	initLoginUser();
	initChangeMyInfo();
	setLeftNav('#researchGroupMyInfo');
	var commonResearchUserId=$("#commonResearchUserId").val();
	if(commonResearchUserId!=="" && commonResearchUserId!==undefined && commonResearchUserId!=="undefined"){
		getDetail();
	}
	//设置高校
	FrontCommonFunction.initSelectBaseUniName("#selectUniName");
	$("#selectUniName").find("dd").click(function(){
	    $("#uniName").val($(this).attr("value")); 
	    var uniName=$('#uniName').val();
		if(uniName!==""){
			$('#unNameRequiredFlag').html('');
		}
	});
});

function getDetail() {
	var url = $('#getDetailUrl').attr('detailUrl');
	var detailParam={};
	detailParam['id']=$("#commonResearchUserId").val();;
	FrontCommonFunction.baseOptions['url'] = url;
	FrontCommonFunction.baseOptions['data'] = detailParam;
	FrontCommonFunction.baseOptions['success'] = function(datas) {
		var type=datas.type;
		if(type==="0"){
			$("#shcool").show();
			$("#organization").hide();
			$("#personal").hide();
			
			$('#tagCheckValue').val("");
			$('#tagCheckValue').val("0");
			$("#shcoolForm").show(); 
			$("#organizationForm").hide();
			$("#personalForm").hide();
			//高校
			$('#uniProvince').val(datas.uniProvince);
			$("#showUniProvince").val(datas.uniProvince);
			$('#uniCity').val(datas.uniCity);
			$("#showUniCity").val(datas.uniCity);
			$("#showUniName").val(datas.uniName);
			$('#uniName').val(datas.uniName);
		}else if(type==="1"){
			$("#organization").show();
			$("#shcool").hide();
			$("#personal").hide();
			
			$('#tagCheckValue').val("");
			$('#tagCheckValue').val("1");
			$("#shcoolForm").hide(); 
			$("#organizationForm").show();
			$("#personalForm").hide();
			//科研机构
			$('#orgName').val(datas.orgName);
			$('#orgProvince').val(datas.orgProvince);
			$("#showOrgProvince").val(datas.orgProvince);
			$('#orgCity').val(datas.orgCity);
			$("#showOrgCity").val(datas.orgCity);
			$('#orgCounty').val(datas.orgCounty);
			$("#showOrgCounty").val(datas.orgCounty);
			$('#orgAddress').val(datas.address);
		}else{
			//个人
			$("#personal").show();
			$("#shcool").hide();
			$("#organization").hide();
			$('#tagCheckValue').val("");
			$('#tagCheckValue').val("2");
			$("#shcoolForm").hide(); 
			$("#organizationForm").hide();
			$("#personalForm").show();
			
			$('#personalName').val(datas.orgName);
			$('#personalProvince').val(datas.orgProvince);
			$("#showPersonalProvince").val(datas.orgProvince);
			$('#personalCity').val(datas.orgCity);
			$("#showPersonalCity").val(datas.orgCity);
			$('#personalCounty').val(datas.orgCounty);
			$("#showPersonalCounty").val(datas.orgCounty);
			$('#personalAddress').val(datas.address);
		}
	};
	$.ajax(FrontCommonFunction.baseOptions);
};

function initChangeMyInfo() {
	setSelect();
	$("#shcoolForm").show(); 
	$("#organizationForm").hide();
	$("#personalForm").hide();
	
	$('#shcool').click(function() {
		$('#tagCheckValue').val("");
		$('#tagCheckValue').val("0");
		$("#shcoolForm").show(); 
		$("#organizationForm").hide();
		$("#personalForm").hide();
    });
    $('#organization').click(function() {
    	$('#tagCheckValue').val("");
		$('#tagCheckValue').val("1");
		$("#shcoolForm").hide(); 
		$("#organizationForm").show();
		$("#personalForm").hide();
    });
    $('#personal').click(function() {
    	$('#tagCheckValue').val("");
		$('#tagCheckValue').val("2");
		$("#shcoolForm").hide(); 
		$("#organizationForm").hide();
		$("#personalForm").show();
    });
	
	$('#saveBtn').click(function() {
		var tagflg=$('#tagCheckValue').val();
		if(tagflg==="0"){
			var uniName=$('#uniName').val();
			if(uniName===""){
				$('#unNameRequiredFlag').html('<font color="red">必填</font>');
			}
			
			var uniProvince=$('#uniProvince').val();
			var uniCity=$('#uniCity').val();
			if(uniProvince===""){
				$('#unRequiredProvinceCheckResult').html('<font color="red">必填</font>');
				if(uniCity===""){
					$('#unRequiredCityCheckResult').html('<font color="red">必填</font>');
				}
				return;
			}
			
			if(uniCity===""){
				$('#unRequiredCityCheckResult').html('<font color="red">必填</font>');
				return;
			}
			if(uniName===""){
				$('#unNameRequiredFlag').html('<font color="red">必填</font>');
				return;
			}
			
		}else if(tagflg==="1"){
			
			var orgProvince=$('#orgProvince').val();
			var orgCity=$('#orgCity').val();
			var orgCounty=$('#orgCounty').val();
			if(orgProvince===""){
				$('#orgRequiredProvinceCheckResult').html('<font color="red">必填</font>');
			}
			if(orgCity===""){
				$('#orgRequiredCityCheckResult').html('<font color="red">必填</font>');
			}
			if(orgCounty===""){
				$('#orgRequiredCountyCheckResult').html('<font color="red">必填</font>');
			}
			
			//科研机构
			if(!organizationFormValidate()){
				return;
			}
			if(orgProvince===""){
				$('#orgRequiredProvinceCheckResult').html('<font color="red">必填</font>');
				return;
			}
			if(orgCity===""){
				$('#orgRequiredCityCheckResult').html('<font color="red">必填</font>');
				return;
			}
			if(orgCounty===""){
				$('#orgRequiredCountyCheckResult').html('<font color="red">必填</font>');
				return;
			}
		}else{
			//个人
			var personalProvince=$('#personalProvince').val();
			var personalCity=$('#personalCity').val();
			var personalCounty=$('#personalCounty').val();
			
			if(personalProvince===""){
				$('#personalRequiredProvinceCheckResult').html('<font color="red">必填</font>');
			}
			if(personalCity===""){
				$('#personalRequiredCityCheckResult').html('<font color="red">必填</font>');
			}
			if(personalCounty===""){
				$('#personalRequiredCountyCheckResult').html('<font color="red">必填</font>');
			}
			
			if(!personalFormValidate()){
				return;
			}
			
			if(personalProvince===""){
				$('#personalRequiredProvinceCheckResult').html('<font color="red">必填</font>');
				return;
			}
			if(personalCity===""){
				$('#personalRequiredCityCheckResult').html('<font color="red">必填</font>');
				return;
			}
			if(personalCounty===""){
				$('#personalRequiredCountyCheckResult').html('<font color="red">必填</font>');
				return;
			}
		}
		save();
    });
};


function setSelect(){
	//高校
	 $("#selectUniProvince").find("dd").click(function(){
		 $("#uniProvince").val($(this).attr("value")); 
		 var uniProvince=$('#uniProvince').val();
		 var uniCity=$('#uniCity').val();
		 if(uniProvince!==""){
			 $('#unRequiredProvinceCheckResult').html('');
		  }
		 $('#showUniCity').val("请选择市");
		 $("#uniCity").val("");
		//根据省查省下市
		var provinceCityMap=FrontCommonFunction.tempProvinceCity();
		var listCity=provinceCityMap[uniProvince];
		var dd = '';
		for(var i = 0; i < listCity.length; i++) {	
			dd += '<dd value="'+listCity[i]+'">' + listCity[i] + '</dd>';
		}
		$("#selectUniCity").html("");
		$("#selectUniCity").append(dd);
		$("#selectUniCity").find("dd").click(function(){
			$("#uniCity").val($(this).attr("value"));
			var uniProvince=$('#uniProvince').val();
			var uniCity=$('#uniCity').val();
			 $('#showUniCity').val(uniCity);
			if(uniCity!==""){
				 $('#unRequiredCityCheckResult').html('');
			  }
		});
	});
	//科研机构
	 $("#selectOrgProvince").find("dd").click(function(){
		 $("#orgProvince").val($(this).attr("value")); 
			var orgProvince=$('#orgProvince').val();
			var orgCity=$('#orgCity').val();
			var orgCounty=$('#orgCounty').val();
			if(orgProvince!==""){
				$('#orgRequiredProvinceCheckResult').html('');
			}
			 $('#showOrgCity').val("请选择市");
			 $("#showOrgCounty").val("请选择县");
			 $("#selectOrgCounty").html("");
			 $("#orgCounty").val("");
			//根据省查省下市
			var provinceCityMap=FrontCommonFunction.tempProvinceCity();
			var listCity=provinceCityMap[orgProvince];
			var dd = '';
			for(var i = 0; i < listCity.length; i++) {	
				dd += '<dd value="'+listCity[i]+'">' + listCity[i] + '</dd>';
			}
			$("#selectOrgCity").html("");
			$("#selectOrgCity").append(dd);
			$("#selectOrgCity").find("dd").click(function(){
			$("#orgCity").val($(this).attr("value")); 
			var orgProvince=$('#orgProvince').val();
			var orgCity=$('#orgCity').val();
			var orgCounty=$('#orgCounty').val();
			if(orgCity!==""){
				$('#orgRequiredCityCheckResult').html('');
			}
			$("#showOrgCity").val(orgCity);
			$("#showOrgCounty").val("请选择县");
			$("#orgCounty").val("");
			
			//根据市查县
			var cityCountyMap=FrontCommonFunction.tempCityCounty();
			var listCounty=cityCountyMap[orgCity];
			var dd = '';
			for(var i = 0; i < listCounty.length; i++) {	
				dd += '<dd value="'+listCounty[i]+'">' + listCounty[i] + '</dd>';
			}
			$("#selectOrgCounty").html("");
			$("#selectOrgCounty").append(dd);
			
			$("#selectOrgCounty").find("dd").click(function(){
				$("#orgCounty").val($(this).attr("value")); 
				var orgProvince=$('#orgProvince').val();
				var orgCity=$('#orgCity').val();
				var orgCounty=$('#orgCounty').val();
				if(orgCounty!==""){
					$('#orgRequiredCountyCheckResult').html('');
				}
				$('#showOrgCounty').val(orgCounty);
			});
		});
	});
	//个人
	 $("#selectPersonalProvince").find("dd").click(function(){
		 $("#personalProvince").val($(this).attr("value")); 
		 var personalProvince=$('#personalProvince').val();
		var personalCity=$('#personalCity').val();
		var personalCounty=$('#personalCounty').val();
		if(personalProvince!==""){
			$('#personalRequiredProvinceCheckResult').html('');
		}
		$("#showPersonalCity").val("请选择市");
		$("#showPersonalCounty").val("请选择县");
		$("#selectPersonalCounty").html("");
		$("#personalCounty").val("");
		
		//根据省查省下市
		var provinceCityMap=FrontCommonFunction.tempProvinceCity();
		var listCity=provinceCityMap[personalProvince];
		var dd = '';
		for(var i = 0; i < listCity.length; i++) {	
			dd += '<dd value="'+listCity[i]+'">' + listCity[i] + '</dd>';
		}
		$("#selectPersonalCity").html("");
		$("#selectPersonalCity").append(dd);
		
		$("#selectPersonalCity").find("dd").click(function(){
			$("#personalCity").val($(this).attr("value")); 
			var personalProvince=$('#personalProvince').val();
			var personalCity=$('#personalCity').val();
			var personalCounty=$('#personalCounty').val();
			if(personalCity!==""){
				$('#personalRequiredCityCheckResult').html('');
			}
			$("#showPersonalCity").val(personalCity);
			$("#showPersonalCounty").val("请选择县");
			$("#personalCounty").val("");
			
			//根据市查县
			var cityCountyMap=FrontCommonFunction.tempCityCounty();
			var listCounty=cityCountyMap[personalCity];
			var dd = '';
			for(var i = 0; i < listCounty.length; i++) {	
				dd += '<dd value="'+listCounty[i]+'">' + listCounty[i] + '</dd>';
			}
			$("#selectPersonalCounty").html("");
			$("#selectPersonalCounty").append(dd);
			$("#selectPersonalCounty").find("dd").click(function(){
				$("#personalCounty").val($(this).attr("value")); 
				var personalProvince=$('#personalProvince').val();
				var personalCity=$('#personalCity').val();
				var personalCounty=$('#personalCounty').val();
				if(personalCounty!==""){
					$('#personalRequiredCountyCheckResult').html('');
				}
				$("#showPersonalCounty").val(personalCounty);
			});
		});
	});
};

function shcoolFormValidate() {
	return $('#shcoolFormValidate').validate({
		rules : {
			uniName : {
				required : true
			}
		},
		messages : {
			uniName : {
				required : '<font color="red">必填</font>'
			}
		}
	}).form();
};

function organizationFormValidate() {
	return $('#organizationFormValidate').validate({
		rules : {
			orgName : {
				required : true
			},
			orgAddress : {
				required : true
			}
		},
		messages : {
			orgName : {
				required : '<font color="red">必填</font>'
			},
			orgAddress : {
				required : '<font color="red">必填</font>'
			}
		}
	}).form();
};

function personalFormValidate() {
	return $('#personalFormValidate').validate({
		rules : {
			personalName : {
				required : true
			},
			personalAddress : {
				required : true
			}
		},
		messages : {
			personalName : {
				required : '<font color="red">必填</font>'
			},
			personalAddress : {
				required : '<font color="red">必填</font>'
			}
		}
	}).form();
};


function save() {
	var url = "";
	var commonResearchUserId=$("#commonResearchUserId").val();
	if(commonResearchUserId!=="" && commonResearchUserId!==undefined && commonResearchUserId!=="undefined"){
		url = $('#updateUrl').attr('updateUrl');
	}else{
		url = $('#saveBtn').attr('saveUrl');
	}
	var saveParam={};
	var requestParam = getData();
	var jsonStr=JSON.stringify(requestParam);
	saveParam['str']=jsonStr;
	FrontCommonFunction.baseOptions['url'] = url;
	FrontCommonFunction.baseOptions['data'] = saveParam;
	FrontCommonFunction.baseOptions['success'] = function(datas) {
		if(datas.status===0){
			$('#altstwo').show();
			setTimeout(function(){//5秒后隐藏
				$('#altstwo').hide();
			}, 1500);
		}else{
			$('#errorInfo').html("");
			FrontCommonFunction.processResult(datas,"#alertClick","#errorInfo");
		}
	};
	$.ajax(FrontCommonFunction.baseOptions);
};

function getData() {
	var researchUser={};
	var user={};
	user['id']=$('#commonUserLoginId').val();
	researchUser['id']=$('#commonResearchUserId').val();
	researchUser['user']=user;
	
	var flag=$('#tagCheckValue').val();
	if(flag==="0"){
		//高校
		researchUser['uniProvince']=$.trim($('#uniProvince').val());
		researchUser['uniCity']=$.trim($('#uniCity').val());
		researchUser['uniName']=$.trim($('#uniName').val());
	}else if(flag==="1"){
		//科研机构
		researchUser['orgName']=$.trim($('#orgName').val());
		researchUser['orgProvince']=$.trim($('#orgProvince').val());
		researchUser['orgCity']=$.trim($('#orgCity').val());
		researchUser['orgCounty']=$.trim($('#orgCounty').val());
		researchUser['address']=$.trim($('#orgAddress').val());
	}else{
		//个人
		researchUser['orgName']=$.trim($('#personalName').val());
		researchUser['orgProvince']=$.trim($('#personalProvince').val());
		researchUser['orgCity']=$.trim($('#personalCity').val());
		researchUser['orgCounty']=$.trim($('#personalCounty').val());
		researchUser['address']=$.trim($('#personalAddress').val());
	}
	return researchUser;
};