$(document).ready(function() {
	$('#altstwo').hide();
	$('#altsthree').hide();
	$('.img2').click(function(){
		$('#altstwo').hide();
		$('#altsthree').hide();
	});
	$('#alertClick').click(function(){
	});
	//弹框start
	$('.registSuccess').click(function(){
		//$('.city').show();
		$('#altsthree').show();
	});
	$('.ok').click(function(){
		$('.city').hide();
	})
	//弹框end
	
	//初始化省份
	FrontCommonFunction.initSelectProvince("#selectProvince");
	//初始化市
	FrontCommonFunction.initSelectCity("#selectCity");
	
	//设置左侧导航
	initLoginUser();
	initInvestorPersonalUserManager();
	setLeftNav("#researchGroupMyCollectionInvestor");
	$('#Button1').click(function(){
	});
	var commonInvestorUserId=$("#commonInvestorUserId").val();
	if(commonInvestorUserId!=="" && commonInvestorUserId!==undefined && commonInvestorUserId!=="undefined"){
		getDetail();
		$("#agree").attr("checked", true);
	}
});

function initInvestorPersonalUserManager() {
	//下拉注册事件
	setSelectValue();
	
	 $("#contactName").keyup(function(){
		 var contactName=$("#contactName").val();
		if(contactName!==""){
			$("#contactNameResult").html('');
		}
	 });
	  
	  $("#contactTel").keyup(function(){
		 var contactTel=$("#contactTel").val();
		 if(contactTel!==""){
			$("#contactTelResult").html('');
		 }
	 });
	
	//投资领域
	FrontCommonFunction.initCheckBoxFormBaseResearchField("#investDomainCheckBoxUrl");
	//investPhaselectAll全选
	$('#investPhaselectAll').click(function() {
		if($(this).hasClass('on')){
			$('#investPhaseCheckBox input:checkbox[name=investPhase]').each(function(i){
				if($(this).is(':checked')){
					$(this).removeAttr('checked');
				}
			});
			$("#investPhaselectAll").html('<font color="#349fc4">全部选中</font>');
			$(this).removeClass('on');
		}else{
			$('#investPhaseCheckBox input:checkbox[name=investPhase]').each(function(i){
				if(!$(this).is(':checked')){
					this.checked=true;
				}
			});
			$("#investPhaselectAll").html('<font color="#349fc4">取消全选</font>');
			$(this).addClass('on');
		}
    });
	
	//investAmountselectAll全选
	$('#investAmountselectAll').click(function() {
		if($(this).hasClass('on')){
			$('#investAmountCheckBox input:checkbox[name=investAmount]').each(function(i){
				if($(this).is(':checked')){
					$(this).removeAttr('checked');
				}
			});
			$("#investAmountselectAll").html('<font color="#349fc4">全部选中</font>');
			$(this).removeClass('on');
		}else{
			$('#investAmountCheckBox input:checkbox[name=investAmount]').each(function(i){
				if(!$(this).is(':checked')){
					this.checked=true;
				}
			});
			$("#investAmountselectAll").html('<font color="#349fc4">取消全选</font>');
			$(this).addClass('on');
		}
    });
	
	//investDomain全选
	$('#investDomainselectAll').click(function() {
		if($(this).hasClass('on')){
			$('#investDomainCheckBox input:checkbox[name=investDomain]').each(function(i){
				if($(this).is(':checked')){
					$(this).removeAttr('checked');
				}
			});
			$("#investDomainselectAll").html('<font color="#349fc4">全部选中</font>');
			$(this).removeClass('on');
		}else{
			$('#investDomainCheckBox input:checkbox[name=investDomain]').each(function(i){
				if(!$(this).is(':checked')){
					this.checked=true;
				}
			});
			$("#investDomainselectAll").html('<font color="#349fc4">取消全选</font>');
			$(this).addClass('on');
		}
    });
	
	
	//	$("#selectDomain").find("dd").click(function(){
//	    $("#domain").val($(this).attr("value")); 
//	});
	
	//投资方式
	$("#checkBoxInvestType [id^=investTypeCheckBox]").click(function() {
		//investTypeCheckBox固定长度是18
		var idIndex=$(this).attr("id").substring(18);
		//固定属性：typeCheckBoxValue
		if($("#investTypeCheckBoxValue"+idIndex).hasClass("on")){
			 $("#investTypeCheckBoxValue"+idIndex).removeClass("on");
		}else{
			 $("#investTypeCheckBoxValue"+idIndex).attr("class","on");
		}
		text = $("#checkBoxInvestType [id^=investTypeCheckBoxValue]input[class=on]").map(function(index,elem) {
			return $(elem).val();
		}).get().join(',');
		if(text!==""){
			$("#investTypeCheckResult").html('');
		}else{
			$("#investTypeCheckResult").html('<font color="red">至少选择一种投资方式</font>');
		}
		$("#investTypeId").val(text);
	});
	
	$('#saveBtn').click(function() {
		var imgCheckFlag=$("#imgCheckFlag").val();//为空代表成功,0代表失败
		var fileCheckFlag=$("#fileCheckFlag").val();//为空代表成功,0代表失败
		if(imgCheckFlag==="0"){
			$("#imgTypeCheckResult").html('<font color="red">图像格式只能是:GIF,JPG,JPEG,PNG</font>');
		}
        if(fileCheckFlag==="0"){
        	$("#fileTypeCheckResult").html('<font style="color:red;">上传文件超过5M,请重新上传。</font>');
		}
		var contactName=$("#contactName").val();
		var contactTel=$("#contactTel").val();
		if(contactTel===""){
			$("#contactTelResult").html('<font color="red">必填</font>');
		}
		if(contactName===""){
			$("#contactNameResult").html('<font color="red">必填</font>');
		}
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
		
		var investType=$("#investTypeId").val();
		if(investType===""){
			$("#investTypeCheckResult").html('<font color="red">至少选择一种投资方式</font>');
		}
		
		if(imgCheckFlag ==="" && fileCheckFlag==="" 
			&& contactName!=="" && contactTel!=="" && province!==""
				&& city!=="" && county!=="" && investType!==""){
				save();
		}else{
			return;
		}
    });
};

function setSelectValue(){
	$("#selectProvince").find("dd").click(function(){
	    $("#province").val($(this).attr("value")); 
	    var province=$("#province").val();
		var city=$("#city").val();
		var county=$("#county").val();
		if(province!==""){
			$("#provinceCheckResult").html('');
		}
		$("#showCity").val("请选择市");
		$("#showCounty").val("请选择县");
		$("#selectCounty").html("");
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
			if(city!==""){
				$("#cityCheckResult").html('');
			}
			
			$("#showCity").val(city);
			$("#showCounty").val("请选择县");
			
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
				if(county!==""){
					$("#countyCheckResult").html('');
				}
				$("#showCounty").val(county);
			});
			
		});
	});
};

function getDetail() {
    //表单验证通过
	var url = $('#getDetailUrl').attr('detailUrl');
	var detailParam={};
	detailParam['id']=$("#commonInvestorUserId").val();;
	FrontCommonFunction.baseOptions['url'] = url;
	FrontCommonFunction.baseOptions['data'] = detailParam;
	FrontCommonFunction.baseOptions['success'] = function(datas) {
		$('#contactTel').val(datas.userModel.telno);
		if(!datas.contactName) return;
		$('#contactName').val(datas.contactName);
		$('#province').val(datas.province);
		$("#showProvince").val(datas.province);
		$('#city').val(datas.city);
		$('#showCity').val(datas.city);
		$('#county').val(datas.county);
		$('#showCounty').val(datas.county);
		$('#contactTel').val(datas.contactTel);
		$('#address').val(datas.address);
		$('#investExperience').val(datas.investExperience);
		$('#investOutline').val(datas.investOutline);
		//投资方式
		//投资方式
		if(datas.investType != null){
			var investTypeId=datas.investType;
			$('#investTypeId').val(investTypeId);
			var arr=new Array();
			arr=investTypeId.split(",");
			for(var i=0;i<arr.length;i++){
				if(arr[i]==="0"){
					$("#investTypeCheckBox0").attr("checked", true);
					$("#investTypeCheckBoxValue0").attr("class","on");
				}else if(arr[i]==="1"){
					$("#investTypeCheckBox1").attr("checked", true);
					$("#investTypeCheckBoxValue1").attr("class","on");
				}else if(arr[i]==="2"){
					$("#investTypeCheckBox2").attr("checked", true);
					$("#investTypeCheckBoxValue2").attr("class","on");
				}else if(arr[i]==="3"){
					$("#investTypeCheckBox3").attr("checked", true);
					$("#investTypeCheckBoxValue3").attr("class","on");
				}else if(arr[i]==="4"){
					$("#investTypeCheckBox4").attr("checked", true);
					$("#investTypeCheckBoxValue4").attr("class","on");
				}
			}
		}
		//投资领域
		if (datas.investDomain != null) {
			var investDomain=datas.investDomain;
			var arr=new Array();
			arr=investDomain.split(",");
			for(var i=0;i<arr.length;i++){
				if(arr[i]==="0"){
					$("#investDomainCheckBox0").attr("checked", true);
				}else if(arr[i]==="1"){
					$("#investDomainCheckBox1").attr("checked", true);
				}else if(arr[i]==="2"){
					$("#investDomainCheckBox2").attr("checked", true);
				}else if(arr[i]==="3"){
					$("#investDomainCheckBox3").attr("checked", true);
				}else if(arr[i]==="4"){
					$("#investDomainCheckBox4").attr("checked", true);
				}else if(arr[i]==="5"){
					$("#investDomainCheckBox5").attr("checked", true);
				}else{
					$("#investDomainCheckBox6").attr("checked", true);
				}
			}
		}
		//投资额
		if(datas.investAmount) {
			var investAmount=datas.investAmount;
			var arrInvestAmount=new Array();
			arrInvestAmount=investAmount.split(",");
			for(var i=0;i<arrInvestAmount.length;i++){
				if(arrInvestAmount[i]==="0"){
					$("#investAmount0").attr("checked", true);
				}else if(arrInvestAmount[i]==="1"){
					$("#investAmount1").attr("checked", true);
				}else if(arrInvestAmount[i]==="2"){
					$("#investAmount2").attr("checked", true);
				}else if(arrInvestAmount[i]==="3"){
					$("#investAmount3").attr("checked", true);
				}else if(arrInvestAmount[i]==="4"){
					$("#investAmount4").attr("checked", true);
				}
			}
		}
		//阶段
		if (datas.investPhase) {
			var investPhase=datas.investPhase;
			var arrInvestPhase=new Array();
			arrInvestPhase=investPhase.split(",");
			for(var i=0;i<arrInvestPhase.length;i++){
				if(arrInvestPhase[i]==="0"){
					$("#investPhase0").attr("checked", true);
				}else if(arrInvestPhase[i]==="1"){
					$("#investPhase1").attr("checked", true);
				}else if(arrInvestPhase[i]==="2"){
					$("#investPhase2").attr("checked", true);
				}else if(arrInvestPhase[i]==="3"){
					$("#investPhase3").attr("checked", true);
				}else if(arrInvestPhase[i]==="4"){
					$("#investPhase4").attr("checked", true);
				}else if(arrInvestPhase[i]==="5"){
					$("#investPhase5").attr("checked", true);
				}
			}
		}
		if (datas.logoUrl) {
			var imgUrl=datas.logoUrl;
			var path='';
			if(imgUrl==="" || imgUrl===undefined || imgUrl==="undefined"){
				path="../resources/images/front/img/fengmian_img.png";
			}else{
				path=$('#downFile').attr('url')+'?path='+imgUrl;
				
			}
			$('#companyLogo').attr('src',path);
			//$('#imgPath').val(imgUrl);
		}
		$('#filePath').val(datas.attachUrl);
		if(datas.attachName) {
			$('#fileTypeCheckResult').html('已上传文件:'+datas.attachName);
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

function imgVerify(){
	var filepath = $("#companyImgLogo").val();
	var extStart = filepath.lastIndexOf(".");
	var ext = filepath.substring(extStart, filepath.length).toUpperCase();
	if (ext != ".PNG" && ext != ".GIF" && ext != ".JPG" && ext != ".JPEG") {
		$("#imgTypeCheckResult").html('<font color="red">图像格式只能是:GIF,JPG,JPEG,PNG</font>');
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

function save() {
	    //表单验证通过
		var url = "";
		var commonInvestorUserId=$("#commonInvestorUserId").val();
		if(commonInvestorUserId!=="" && commonInvestorUserId!==undefined && commonInvestorUserId!=="undefined"){
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
			formId:'investorPersonalForm',
			timeout : 100000,
			secureuri : false, //一般设置为false
			dataType : 'json', //返回值类型 一般设置为json
			success : function(datas){
				if(datas.status===0){
//					$('#Button1').click();
					$('#altstwo').show();
					setTimeout(function(){//5秒后隐藏
//						CloseDiv('MyDiv','fade');
						$('#altstwo').hide();
						var myRecommendUrl = $('#myRecommendUrl').attr('url');
						location.href=myRecommendUrl;
					}, 1500);
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

function getData() {
	var paramTemp = {};
	var user = {};
	user['id']=$("#commonUserLoginId").val();
	paramTemp['user']=user;
	
	var commonInvestorUserId=$("#commonInvestorUserId").val();
	if(commonInvestorUserId!=="" && commonInvestorUserId!==undefined && commonInvestorUserId!=="undefined"){
		paramTemp['id']=commonInvestorUserId;
	}
	
	paramTemp['contactName']=$.trim($('#contactName').val());
	paramTemp['contactTel']=$.trim($('#contactTel').val());
	paramTemp['province']=$.trim($('#province').val());
	paramTemp['city']=$.trim($('#city').val());
	paramTemp['county']=$.trim($('#county').val());
	paramTemp['address']=$.trim($('#address').val());
	paramTemp['investType']=$.trim($('#investTypeId').val());
	//投资经历新增字段
	paramTemp['investExperience']=$.trim($('#investExperience').val());
	//设置投资领域
	var investDomainTemp="";
	$('#investDomainCheckBoxUrl input:checkbox[name=investDomain]:checked').each(function(i){
		if(i==0){
			investDomainTemp=$(this).val();
		}else{
			investDomainTemp+=(","+$(this).val());
		}
	});
	paramTemp['investDomain']=investDomainTemp;
	
	//设置投资额
	var investAmountTemp="";
	$('#investAmountCheckBox input:checkbox[name=investAmount]:checked').each(function(i){
		if(i==0){
			investAmountTemp=$(this).val();
		}else{
			investAmountTemp+=(","+$(this).val());
		}
	});
	
	//设置阶段
	var investPhaseTemp="";
	$('#investPhaseCheckBox input:checkbox[name=investPhase]:checked').each(function(i){
		if(i==0){
			investPhaseTemp=$(this).val();
		}else{
			investPhaseTemp+=(","+$(this).val());
		}
	});
	paramTemp['investDomain']=investDomainTemp;
	paramTemp['investAmount']=investAmountTemp;
	paramTemp['investPhase']=investPhaseTemp;
	paramTemp['introduction']=$('#introduction').val();
	paramTemp['investOutline']=$('#investOutline').val();
	paramTemp['logoUrl']=$('#imgPath').val();
	paramTemp['attachUrl']=$('#filePath').val();
	return paramTemp;
};