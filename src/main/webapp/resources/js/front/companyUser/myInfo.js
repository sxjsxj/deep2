$(document).ready(function() {
	//发布需求类型弹框
	$("#alts").hide();
	$("#publishMyRequirementnew").click(function(){
		$('#alts').show();
		$('#altstwo').hide();
	});
	
	$('#altstwo').hide();
	$('#altsthree').hide();
	$('.img2').click(function(){
		$('#altstwo').show();
		$('#altsthree').hide();
		$('#alts').hide();
	});
	$('#alertClick').click(function(){
	});
	//弹框start
	$('.registSuccess').click(function(){
		$('#altsthree').show();
	});
	//设置左侧导航
	initLoginUser();
	initCompanyUserManager();
	setLeftNav('#myCompanyInfo');
	//初始化省份
	FrontCommonFunction.initSelectProvince("#selectProvince");
	//初始化市
	FrontCommonFunction.initSelectCity("#selectCity");
	//下拉注册事件
	setSelectValue();
	var commonCompanyUserId=$("#commonCompanyUserId").val();
	if(commonCompanyUserId!=="" && commonCompanyUserId!==undefined && commonCompanyUserId!=="undefined"){
		getDetail();
		$("#agree").attr("checked", true);
	}
});

function initCompanyUserManager() {
	
	$('#Button1').click(function(){
	});
	
	$('#techRequire').click(function(){
		var url = $('#techRequire').attr('url');
		location.href=url;
	});
	
	$('#fundRequire').click(function(){
		var url = $('#fundRequire').attr('url');
		location.href=url;
	});
	
	//设置行业
	FrontCommonFunction.initSelectBaseResearchField("#selectDomain");
	$("#selectDomain").find("dd").click(function(){
	    $("#domain").val($(this).attr("value")); 
	    var domain=$("#domain").val();
		if(domain!==""){
			$("#domainCheckResult").html('');
		}
	});
	
	$("#contactName").keyup(function(){
		var contactName=$("#contactName").val();
		if(contactName!==""){
			$("#contactNameResult").html("");
		}
	});
	
    $("#contactTel").keyup(function(){
    	var contactTel=$("#contactTel").val();
        if(contactTel!==""){
        	$("#contactTelResult").html("");
		}
	});
	
	$('#saveBtn').click(function() {
		var imgCheckFlag=$("#imgCheckFlag").val();//为空代表成功,0代表失败
		var fileCheckFlag=$("#fileCheckFlag").val();//为空代表成功,0代表失败
		if(imgCheckFlag==="0"){
			$("#imgTypeCheckResult").html('<font color="red">&nbsp;&nbsp;图像格式只能是:GIF,JPG,JPEG,PNG</font>');
		}
		if(fileCheckFlag==="0"){
        	$("#fileTypeCheckResult").html('<font style="color:red;">上传文件超过5M,请重新上传。</font>');
		}
		
		//所属行业 性质
		var domain=$("#domain").val();
		var nature=$("#nature").val();
		if(nature===""){
			$("#natureCheckResult").html('<font color="red">必填</font>');
		}
		if(domain===""){
			$("#domainCheckResult").html('<font color="red">必填</font>');
		}
		//规模  产值
		var scale=$("#scale").val();
		var productValue=$("#productValue").val();
		if(productValue===""){
			$("#productValueCheckResult").html('<font color="red">必填</font>');
		}
		if(scale===""){
			$("#scaleCheckResult").html('<font color="red">必填</font>');
		}
		//省市县
		var province=$("#province").val();
		var city=$("#city").val();
		var county=$("#county").val();
		if(province===""){
			$("#provinceCheckResult").html('<font color="red">必填</font>');
			
		}
		if(city===""){
			$("#cityCheckResult").html('<font color="red">必填</font>');
		}
		if(county===""){
			$("#countyCheckResult").html('<font color="red">必填</font>');
		}
		
		if(fromValidate() && imgCheckFlag ==="" && fileCheckFlag==="" && contactName!=="" && contactTel!==""
			&& domain!==""&& nature!==""&& scale!==""&& productValue!==""&& province!==""&& city!==""&& county!==""){
			if($("#agree").is(":checked")){
				save();
			}else{
				$("#notAgree").html('<font color="red">&nbsp;&nbsp;请您承诺以上企业信息属实，并勾选此项</font>');
				return;
			}
		}else{
			return;
		}
    });
};

function fromValidate() {
	return $('#companyUserForm').validate({
		rules : {
			name : {
				required : true
			},
			contactName:{
				required : true
			},
			contactTel:{
				required : true
			}
			
		},
		messages : {
			name : {
				required : '<font color="red">必填</font>'
			},
			contactName : {
				required : '<font color="red">必填</font>'
			},
			contactTel : {
				required : '<font color="red">必填</font>'
			}
		}
	}).form();
}

function imgVerify(){
	var filepath = $("#companyImgLogo").val();
	var extStart = filepath.lastIndexOf(".");
	var ext = filepath.substring(extStart, filepath.length).toUpperCase();
	if (ext != ".PNG" && ext != ".GIF" && ext != ".JPG" && ext != ".JPEG") {
		$("#imgTypeCheckResult").html('<font color="red">&nbsp;&nbsp;图像格式只能是:GIF,JPG,JPEG,PNG</font>');
		$("#imgCheckFlag").val("0");//验证不通过标识
		$('#imgPath').val("");
		return false;
	}else{
		$("#imgCheckFlag").val("");
		$("#imgTypeCheckResult").html("");
	}
   //文件大小
   var dom = document.getElementById("companyImgLogo");
   var fileSize = dom.files[0].size;
   var size=fileSize/(1024*1024); //单位M
   if(size>2){
	   $("#imgTypeCheckResult").html('<font color="red">图片大小不能超过2M</font>');
	   $("#imgCheckFlag").val("0");//验证不通过标识
	   return false;
   }else{
	   $("#imgCheckFlag").val("");
	   $("#imgTypeCheckResult").html("");
   }
   return true;
};

function setSelectValue(){
	$("#selectNature").find("dd").click(function(){
	    $("#nature").val($(this).attr("value")); 
		var nature=$("#nature").val();
		if(nature!==""){
			$("#natureCheckResult").html('');
		}
	});
	$("#selectScale").find("dd").click(function(){
	    $("#scale").val($(this).attr("value")); 
	    var scale=$("#scale").val();
		var productValue=$("#productValue").val();
		if(scale!==""){
			$("#scaleCheckResult").html('');
		}
	});
	$("#selectProductValue").find("dd").click(function(){
	    $("#productValue").val($(this).attr("value")); 
		var productValue=$("#productValue").val();
		if(productValue!==""){
			$("#productValueCheckResult").html('');
		}
	});
	$("#selectProvince").find("dd").click(function(){
	    $("#province").val($(this).attr("value")); 
	    var province=$("#province").val();
		var city=$("#city").val();
		var county=$("#county").val();
		if(province!==""){
			$("#provinceCheckResult").html('');
		}
		if(city!==""){
			$("#cityCheckResult").html('');
		}
		if(county!==""){
			$("#countyCheckResult").html('');
		}
		$("#showCity").val("请选择市");
		$("#showCounty").val("请选择县");
		$("#selectCounty").html("");
		 $("#county").val("");
		//根据省查省下市
		var provinceCityMap=FrontCommonFunction.tempProvinceCity();
		var listCity=provinceCityMap[province];
		var dd = '';
		for(var i = 0; i < listCity.length; i++) {	
			dd += '<dd value="'+listCity[i]+'">' + listCity[i] + '</dd>';
		}
		$("#selectCity").html("");
		$("#selectCity").append(dd);
		
		$("#selectCity").find("dd").click(function(){
		    $("#city").val($(this).attr("value")); 
		    var province=$("#province").val();
			var city=$("#city").val();
			var county=$("#county").val();
			if(province!==""){
				$("#provinceCheckResult").html('');
			}
			if(city!==""){
				$("#cityCheckResult").html('');
			}
			if(county!==""){
				$("#countyCheckResult").html('');
			}
			
			$("#showCity").val(city);
			$("#showCounty").val("请选择县");
			$("#county").val("");
			//根据市查县
			var cityCountyMap=FrontCommonFunction.tempCityCounty();
			var listCounty=cityCountyMap[city];
			var dd = '';
			for(var i = 0; i < listCounty.length; i++) {	
				dd += '<dd value="'+listCounty[i]+'">' + listCounty[i] + '</dd>';
			}
			$("#selectCounty").html("");
			$("#selectCounty").append(dd);
			
			$("#selectCounty").find("dd").click(function(){
			    $("#county").val($(this).attr("value")); 
			    var province=$("#province").val();
				var city=$("#city").val();
				var county=$("#county").val();
				if(province!==""){
					$("#provinceCheckResult").html('');
				}
				if(city!==""){
					$("#cityCheckResult").html('');
				}
				if(county!==""){
					$("#countyCheckResult").html('');
				}
				$("#showCounty").val(county);
			});
			
		});
		
	});
};

function save() {
    //表单验证通过
	var url = "";
	var commonCompanyUserId=$("#commonCompanyUserId").val();
	if(commonCompanyUserId!=="" && commonCompanyUserId!==undefined && commonCompanyUserId!=="undefined"){
		url = $('#updateUrl').attr('updateUrl');
	}else{
		url = $('#saveBtn').attr('saveUrl');
	}
	var saveParam={};
	var requestParam = getData();
	var jsonStr=JSON.stringify(requestParam);
	$('#str').val(jsonStr);
	$.ajaxFileUpload({
		url : url, //用于文件上传的服务器端请求地址
		type : 'post',
		formId:'companyUserForm',
		timeout : 100000,
		secureuri : false, //一般设置为false
		dataType : 'json', //返回值类型 一般设置为json
		success : function(datas){
			if(datas.status===0){
//					$('#Button1').click();
				$('#altstwo').show();
			}else{
				//保存失败 弹框
				$('#errorInfo').html("");
				FrontCommonFunction.processResult(datas,"#alertClick","#errorInfo");
			}
		},
		error  : function(xmlHttpRequest, status, error) {
			$.showTuiErrorDialog('发生通讯错误！');
		}
	});
};

function getDetail() {
	var url = $('#getDetailUrl').attr('detailUrl');
	var detailParam={};
	detailParam['id']=$("#commonCompanyUserId").val();;
	FrontCommonFunction.baseOptions['url'] = url;
	FrontCommonFunction.baseOptions['data'] = detailParam;
	FrontCommonFunction.baseOptions['success'] = function(datas) {
		$('#name').val(datas.name);
		$('#domain').val(datas.domain);
		$("#showDomain").val(FrontCommonFunction.setInvestorDomain(datas.domain));
		$('#nature').val(datas.nature);
		$('#showNature').val(FrontCommonFunction.setStrNature(datas.nature));
		$('#scale').val(datas.scale);
		$('#showScale').val(FrontCommonFunction.setScale(datas.scale));
		$('#productValue').val(datas.productValue);
		$('#showProductValue').val(FrontCommonFunction.setStrProductValue(datas.productValue));
		$('#address').val(datas.address);
		$('#contactName').val(datas.contactName);
		if(datas.contactTel) {
			$('#contactTel').val(datas.contactTel);
		} else {
			$('#contactTel').val(datas.userModel.telno);
		}
		$('#contactTitle').val(datas.contactTitle);
		$('#introduction').val(datas.introduction);
		$('#province').val(datas.province);
		$("#showProvince").val(datas.province);
		$('#city').val(datas.city);
		$('#showCity').val(datas.city);
		$('#county').val(datas.county);
		$('#showCounty').val(datas.county);
		//设置图片
		var logoUrl=datas.logoUrl;
		if(logoUrl!==undefined && logoUrl!==null && logoUrl!==""){
			var imgurl=$('#downFile').attr('url')+'?path='+logoUrl;
			$('#companyLogo').attr("src",imgurl);
		}
	};
	$.ajax(FrontCommonFunction.baseOptions);
};

function showPreview(source) {
	imgVerify();
    var file = source.files[0];
    if (window.FileReader) {
        var fr = new FileReader();
        fr.onloadend = function(e) {
        	document.getElementById("companyLogo").src = e.target.result;
        };
        fr.readAsDataURL(file);
    }
};

function uploadFile(fileId){
	//表单验证通过
	var url = "";
	var filepath = $("#companyFile").val();
	var extStart = filepath.lastIndexOf(".");
	var ext = filepath.substring(extStart, filepath.length).toUpperCase();
	if (ext != ".RAR" && ext != ".ZIP") {
		$("#fileTypeCheckResult").html('<font color="red">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;附件格式只能是:RAR,ZIP</font>');
		$('#filePath').val("");
		return false;
	}else{
		$("#fileTypeCheckResult").html("");
	}
   //文件大小
   var dom = document.getElementById("companyFile");
   var fileSize = dom.files[0].size;
   var size=fileSize/(1024*1024); //单位M
   if(size>5){
	   $("#fileTypeCheckResult").html('<font color="red">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;附件大小超过了5M</font>');
	   return false;
   }else{
	   $("#fileTypeCheckResult").html("");
   }
	var path="";
	var requestParam = getData();
	var jsonStr=JSON.stringify(requestParam);
	$.ajaxFileUpload({
		url : url, //用于文件上传的服务器端请求地址
		secureuri : false,//是否启用安全提交，一般设置为false
		fileElementId : fileId,//文件上传控件的id
		type:"post",
		data : {
			"str":jsonStr
		},
		dataType : 'json',
		success : function(data) {
			path=data.path;
			$('#filePath').val(path);
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert('操作失败');
		},
		complete : function(XMLHttpRequest, textStatus) {
			//("loaded");  
		}
	})
	return path;
}

function getData() {
	var paramTemp = {};
	var user = {};
	user['id']=$("#commonUserLoginId").val();
	paramTemp['user']=user;
	
	var commonCompanyUserId=$("#commonCompanyUserId").val();
	if(commonCompanyUserId!=="" && commonCompanyUserId!==undefined && commonCompanyUserId!=="undefined"){
		paramTemp['id']=commonCompanyUserId;
	}
	// 公司名称
	paramTemp['name']=$.trim($('#name').val());
	// 行业
	paramTemp['domain']=$.trim($('#domain').val());
	// 公司性质
	paramTemp['nature']=$.trim($('#nature').val());
	paramTemp['scale']=$.trim($('#scale').val());
	// 产值新增字段
	paramTemp['productValue']=$.trim($('#productValue').val());
	paramTemp['province']=$.trim($('#province').val());
	paramTemp['city']=$.trim($('#city').val());
	paramTemp['county']=$.trim($('#county').val());
	paramTemp['address']=$.trim($('#address').val());
	paramTemp['contactName']=$.trim($('#contactName').val());
	paramTemp['contactTel']=$.trim($('#contactTel').val());
	paramTemp['contactTitle']=$.trim($('#contactTitle').val());
	paramTemp['introduction']=$('#introduction').val();
	paramTemp['logoUrl']=$('#imgPath').val();
	paramTemp['attachUrl']=$('#filePath').val();
	return paramTemp;
};