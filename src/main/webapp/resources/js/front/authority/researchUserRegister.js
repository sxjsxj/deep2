$(document).ready(function() {
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
	
	initResearchGroupRegistor();
	
	$('#altsone').hide();
	$('#altstwo').hide();
	$('#altsthree').hide();
	$('.img2').click(function(){
		$('#altsone').hide();
		$('#altstwo').hide();
		$('#altsthree').hide();
		//ShowDiv('MyDiv','fade')
	});
});
var queryParam = {};
function initResearchGroupRegistor() {
	$('#alertClick').click(function(){
	});
	//弹框start
	$('.registSuccess').click(function(){
//		$('.city').show();
		$('#altsthree').show();
		
	});
	$('.ok').click(function(){
		$('.city').hide();
	})
	
	$('#Button1').click(function(){
	});
	
	setSelect();
	$("#shcoolForm").show(); 
	$("#organizationForm").hide();
	$("#personalForm").hide();
	
	$('#agree').click(function() {
		if($("#agree").is(":checked")){
			$("#notAgree").html('');
		}
    });
	
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
	
	$('#registComit').click(function() {
		var uniProvince=$('#uniProvince').val();
		var uniCity=$('#uniCity').val();
		if(uniProvince==="" || uniCity===""){
			$('#unRequiredFlag').html('<font color="red">必填</font>');
		}
		
		var uniName=$('#uniName').val();
		if(uniName===""){
			$('#unNameFlag').html('<font color="red">必填</font>');
		}
		
		var orgProvince=$('#orgProvince').val();
		var orgCity=$('#orgCity').val();
		var orgCounty=$('#orgCounty').val();
		if(orgProvince==="" || orgCity==="" || orgCounty===""){
			$('#orgRequiredFlag').html('<font color="red">必填</font>');
		}
		
		var personalProvince=$('#personalProvince').val();
		var personalCity=$('#personalCity').val();
		var personalCounty=$('#personalCounty').val();
		if(personalProvince==="" || personalCity==="" || personalCounty===""){
			$('#personalRequiredFlag').html('<font color="red">必填</font>');
		}
		
		if(commonFromValidate()){
			var tagflg=$('#tagCheckValue').val();
			if(tagflg==="0"){
				//高校
				if(!shcoolFormValidate()){
					return;
				}
				var uniProvince=$('#uniProvince').val();
				var uniCity=$('#uniCity').val();
				if(uniProvince==="" || uniCity===""){
					$('#unRequiredFlag').html('<font color="red">必填</font>');
					return;
				}
				
				var uniName=$('#uniName').val();
				if(uniName===""){
					$('#unNameFlag').html('<font color="red">必填</font>');
					return;
				}
				
			}else if(tagflg==="1"){
				//科研机构
				if(!organizationFormValidate()){
					return;
				}
				var orgProvince=$('#orgProvince').val();
				var orgCity=$('#orgCity').val();
				var orgCounty=$('#orgCounty').val();
				if(orgProvince==="" || orgCity==="" || orgCounty===""){
					$('#orgRequiredFlag').html('<font color="red">&nbsp;必填</font>');
					return;
				}
			}else{
				//个人
				if(!personalFormValidate()){
					return;
				}
				var personalProvince=$('#personalProvince').val();
				var personalCity=$('#personalCity').val();
				var personalCounty=$('#personalCounty').val();
				if(personalProvince==="" || personalCity==="" || personalCounty===""){
					$('#personalRequiredFlag').html('<font color="red">&nbsp;必填</font>');
					return;
				}
			}
			if($("#agree").is(":checked")){
				save();
			}else{
				$("#notAgree").html('<font color="red">请接受服务条款</font>');
				return;
			}
		}else{
			return;
		}
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

}

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
				required : '<font color="red">&nbsp;必填</font>'
			},
			orgAddress : {
				required : '<font color="red">&nbsp;必填</font>'
			}
		}
	}).form();

}


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
				required : '<font color="red">&nbsp;必填</font>'
			},
			personalAddress : {
				required : '<font color="red">&nbsp;必填</font>'
			}
		}
	}).form();

}

function commonFromValidate() {
	// 手机号码验证
	jQuery.validator.addMethod("telno", function(value, element) {
		var length = value.length;
		var mobile = /^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/;
		return this.optional(element) || (length == 11 && mobile.test(value));
	}, '<font color="red">&nbsp;&nbsp;请正确填写您的手机号码</font>');
	
	return $('#commonFormValidate').validate({
		rules : {
			email : {
				required: true,
				email:email
				},
			telno : {
				required: true,
				telno:true
				},
				passwordOne : {
				required : true,
				rangelength : [ 6, 20 ]
			},
			passwordTwo : {
				required : true,
				equalTo : "#passwordOne",
				rangelength : [ 6, 20 ]
			}
		},
		messages : {
			email :{
				required: '<font color="red">&nbsp;&nbsp;必填</font>'
			},
			telno :{
				required: '<font color="red">&nbsp;&nbsp;必填</font>'
			},
			passwordOne : {
				required : '<font color="red">&nbsp;&nbsp;必填</font>',
				rangelength : jQuery.format('<font color="red">&nbsp;6~20个字符</font>'),
			},
			passwordTwo : {
				required : '<font color="red">&nbsp;&nbsp;必填</font>',
				rangelength : jQuery.format('<font color="red">&nbsp;6~20个字符</font>'),
				equalTo : '<font color="red">&nbsp;密码不一致</font>'
			}
		}
	}).form();

}

function setSelect(){
	//高校
	 $("#selectUniProvince").find("dd").click(function(){
		 $("#uniProvince").val($(this).attr("value")); 
		 var uniProvince=$('#uniProvince').val();
		 var uniCity=$('#uniCity').val();
		 if(uniProvince!=="" && uniCity!==""){
			 $('#unRequiredFlag').html('');
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
			$("#selectUniName").html("");
			$("#showUniName").val("请选择高校");
			$("#selectUniCity").append(dd);
			
			$("#selectUniCity").find("dd").click(function(){
				$("#uniCity").val($(this).attr("value"));
				var uniProvince=$('#uniProvince').val();
				var uniCity=$('#uniCity').val();
				 $('#showUniCity').val(uniCity);
				if(uniProvince!=="" && uniCity!==""){
					 $('#unRequiredFlag').html('');
				}
				//根据省市查高校名称
				var url = $('#selectUniName').attr('url');
				var queryParam={};
				var requestParam = {};
				requestParam['province']=uniProvince;
				requestParam['city']=uniCity;
				var jsonStr=JSON.stringify(requestParam);
				queryParam['str']=jsonStr;
				FrontCommonFunction.baseOptions['url'] = url;
				FrontCommonFunction.baseOptions['data'] = queryParam;
				FrontCommonFunction.baseOptions['success'] = function(datas) {
					//根据key取list
					var queryReturnList=datas[uniProvince+"_"+uniCity];
					var dd = '';
					for(var i = 0; i < queryReturnList.length; i++) {
						dd += '<dd value="'+queryReturnList[i].name+'">' + queryReturnList[i].name + '</dd>';
					}
					$("#showUniName").val("请选择高校");
					$("#selectUniName").html("");
					$("#selectUniName").append(dd);
					//高校名称click
					$("#selectUniName").find("dd").click(function(){
						$("#uniName").val($(this).attr("value"));
						var uniName=$('#uniName').val();
						 $('#showUniName').val(uniName);
						 var uniName=$('#uniName').val();
							if(uniName!==""){
								$('#unNameFlag').html('');
							}
					});
					
				};
				$.ajax(FrontCommonFunction.baseOptions);
			});
	});
	//科研机构
	 $("#selectOrgProvince").find("dd").click(function(){
		 $("#orgProvince").val($(this).attr("value")); 
			var orgProvince=$('#orgProvince').val();
			var orgCity=$('#orgCity').val();
			var orgCounty=$('#orgCounty').val();
			if(orgProvince!=="" && orgCity!=="" && orgCounty!==""){
				$('#orgRequiredFlag').html('');
			}
			
			 $('#showOrgCity').val("请选择");
			 $("#showOrgCounty").val("请选择");
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
						if(orgProvince!=="" && orgCity!=="" && orgCounty!==""){
							$('#orgRequiredFlag').html('');
						}
						$("#showOrgCity").val(orgCity);
						$("#showOrgCounty").val("请选择");
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
								if(orgProvince!=="" && orgCity!=="" && orgCounty!==""){
									$('#orgRequiredFlag').html('');
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
			if(personalProvince!=="" && personalCity!=="" && personalCounty!==""){
				$('#personalRequiredFlag').html('');
			}
			
			$("#showPersonalCity").val("请选择");
			$("#showPersonalCounty").val("请选择");
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
					if(personalProvince!=="" && personalCity!=="" && personalCounty!==""){
						$('#personalRequiredFlag').html('');
					}
					$("#showPersonalCity").val(personalCity);
					$("#showPersonalCounty").val("请选择");
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
							if(personalProvince!=="" && personalCity!=="" && personalCounty!==""){
								$('#personalRequiredFlag').html('');
							}
							$("#showPersonalCounty").val(personalCounty);
					});
			});
	});
}



//弹出隐藏层
function ShowDiv(show_div,bg_div){
	document.getElementById(show_div).style.display='block';
	document.getElementById(bg_div).style.display='block' ;
	var bgdiv = document.getElementById(bg_div);
	bgdiv.style.width = document.body.scrollWidth;
	// bgdiv.style.height = $(document).height();
	$("#"+bg_div).height($(document).height());
};
//关闭弹出层
function CloseDiv(show_div,bg_div){
	document.getElementById(show_div).style.display='none';
	document.getElementById(bg_div).style.display='none';
};

function save() {
    //表单验证通过
	var url = $('#registComit').attr('url');
	var saveParam={};
	var requestParam = getData();
	var jsonStr=JSON.stringify(requestParam);
	saveParam['str']=jsonStr;
	FrontCommonFunction.baseOptions['url'] = url;
	FrontCommonFunction.baseOptions['data'] = saveParam;
	FrontCommonFunction.baseOptions['success'] = function(datas) {
		if(datas.status===0){
			//$('#Button1').click();
			$('#altstwo').show();
			var loginUrl = $('#loginUrl').attr('url');
			setTimeout(function(){//5秒后隐藏
				$('#altstwo').hide();
				location.href=loginUrl;
			}, 1500);
		}else{
			//注册失败 
			$('#errorInfo').html("");
			FrontCommonFunction.processResult(datas,"#alertClick","#errorInfo");
		}
		
	};
	$.ajax(FrontCommonFunction.baseOptions);
};

function getData() {
	var paramTemp = {};
	var user = {};
	var researchUser = {};
	user['userType']="1";
	user['email']=$.trim($('#email').val());
	user['telno']=$.trim($('#telno').val());
	user['password']=$.trim($('#passwordOne').val());
	var flag=$('#tagCheckValue').val();
	if(flag==="0"){
		//高校
		researchUser['type']='0';
		researchUser['uniProvince']=$.trim($('#uniProvince').val());
		researchUser['uniCity']=$.trim($('#uniCity').val());
		researchUser['uniName']=$.trim($('#uniName').val());
	}else if(flag==="1"){
		//科研机构
		researchUser['type']='1';
		researchUser['orgName']=$.trim($('#orgName').val());
		researchUser['orgProvince']=$.trim($('#orgProvince').val());
		researchUser['orgCity']=$.trim($('#orgCity').val());
		researchUser['orgCounty']=$.trim($('#orgCounty').val());
		researchUser['address']=$.trim($('#orgAddress').val());
	}else{
		//个人
		researchUser['type']='2';
		researchUser['orgName']=$.trim($('#personalName').val());
		researchUser['orgProvince']=$.trim($('#personalProvince').val());
		researchUser['orgCity']=$.trim($('#personalCity').val());
		researchUser['orgCounty']=$.trim($('#personalCounty').val());
		researchUser['address']=$.trim($('#personalAddress').val());
	}
	paramTemp['userModel']=user;
	paramTemp['researchUser']=researchUser;
	return paramTemp;
};











