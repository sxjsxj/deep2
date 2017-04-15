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
	$('#Button1').click(function(){
	});
	initAchievementManager();
	//设置左侧导航
	setLeftNav('#researchGroupMyAchievement');
	var updateId=$("#updateId").val();
	if(updateId!=="" && updateId!==undefined && updateId!=="undefined"){
		getDetail(updateId);
		$("#agree").attr("checked", true);
	}
});


function initAchievementManager() {
	$("#patentDiv").hide();
	$("#patenterDiv").hide();
	
	$("#typeCheckBox3").click(function() {
		if($("#typeCheckBoxValue3").hasClass("on")){
			$("#patentDiv").hide();
			$("#patenterDiv").hide();
		}else{
			$("#patentDiv").show();
			$("#patenterDiv").show();
		}
	});
	
	//下拉注册事件
	setSelectValue();
	//设置行业
	FrontCommonFunction.initSelectBaseResearchField("#selectDomain");
	//设置科研团队名称暂时先注释掉
	FrontCommonFunction.initSelectResearchGroup("#selectResearchGroupName");
	
	$("#selectDomain").find("dd").click(function(){
	    $("#domain").val($(this).attr("value")); 
	    var domain=$("#domain").val();
		if(domain!==""){
			$("#checkResult2").html('');
		}
	});
	
	//成果形式
	$("#checkBoxType [id^=typeCheckBox]").click(function() {
		//typeCheckBox固定长度是12
		var idIndex=$(this).attr("id").substring(12);
		//固定属性：typeCheckBoxValue
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
	
	//寻求合作方式
	$("#checkBoxCooperationType [id^=cooperationTypeCheckBox]").click(function() {
		//cooperationTypeCheckBox固定长度是23
		var idIndex=$(this).attr("id").substring(23);
		//固定属性：cooperationTypeCheckBoxValue
		if($("#cooperationTypeCheckBoxValue"+idIndex).hasClass("on")){
			 $("#cooperationTypeCheckBoxValue"+idIndex).removeClass("on");
		}else{
			 $("#cooperationTypeCheckBoxValue"+idIndex).attr("class","on");
		}
		text = $("#checkBoxCooperationType [id^=cooperationTypeCheckBoxValue]input[class=on]").map(function(index,elem) {
			return $(elem).val();
		}).get().join(',');
		$("#cooperationTypeId").val(text);
	});
	
	$('#saveBtn').click(function() {
		//图片验证通过值为空 否则为0
		var imgCheckFlag=$("#imgCheckFlag").val();//为空代表成功,0代表失败
		var fileCheckFlag=$("#fileCheckFlag").val();//为空代表成功,0代表失败
		if(imgCheckFlag==="0"){
			$("#imgTypeCheckResult").html('<font color="red">&nbsp;&nbsp;图像格式只能是:GIF,JPG,JPEG,PNG</font>');
		}
		if(fileCheckFlag==="0"){
        	$("#fileTypeCheckResult").html('<font style="color:red;">上传文件超过5M,请重新上传。</font>');
		}
		
		
		var researchGroupName = $("#researchGroupName").val();
		if(researchGroupName===""){
			$("#checkResult1").html('<font color="red">必填</font>');
		}
		
		var domain=$("#domain").val();
		if(domain===""){
			$("#checkResult2").html('<font color="red">必填</font>');
		}
		
		if($("#typeCheckBoxValue3").hasClass("on")){
			var patent=$("#patent").val();
			if(patent===""){
				$("#checkResult3").html('<font color="red">必填</font>');
			}
			var patenter=$("#patenter").val();
			if(patenter===""){
				$("#checkResultpatenter").html('<font color="red">必填</font>');
			}
		}else{
			$("#checkResult3").html('');
			$("#checkResultpatenter").html('');
		}
		
		var amount=$("#amount").val();
		if(amount===""){
			$("#checkResult4").html('<font color="red">必填</font>');
		}
		var phase=$("#phase").val();
		if(phase===""){
			$("#checkResult5").html('<font color="red">必填</font>');
		}
		//成果形式
		if($('#typeId').val() === '') {
			$("#checkResult6").html('<font color="red">必填</font>');
		}
		//合作方式
		if($('#cooperationTypeId').val() === '') {
			$("#checkResult7").html('<font color="red">必填</font>');
		}
		if(fromValidate() && imgCheckFlag ==="" && fileCheckFlag==="" && researchGroupName!==""
			&& domain!==""&& patent!==""&& amount!==""&& phase!==""){
			if($("#agree").is(":checked")){
				save();
			}else{
				$("#notAgree").html('<font color="red">&nbsp;&nbsp;请您承诺以上信息属实，并勾选此项</font>');
				return;
			}
		}else{
			return;
		}
    });
};


function getDetail(id) {
    //表单验证通过
	var url = $('#getDetailUrl').attr('detailUrl');
	var detailParam={};
	detailParam['id']=id;
	FrontCommonFunction.baseOptions['url'] = url;
	FrontCommonFunction.baseOptions['data'] = detailParam;
	FrontCommonFunction.baseOptions['success'] = function(datas) {
		$('#researchGroupId').val(datas.researchGroupResultModel.id);
		$('#researchGroupName').val(datas.researchGroupResultModel.name);
		$('#showResearchGroupName').val(datas.researchGroupResultModel.name);
		$('#name').val(datas.name);
		
		$('#domain').val(datas.domain);
		$("#showDomain").val(FrontCommonFunction.setInvestorDomain(datas.domain));
		$('#patent').val(datas.patent);
		$('#showPatent').val(FrontCommonFunction.setStrPatent(datas.patent));
		$('#amount').val(datas.amount);
		$('#showAmount').val(FrontCommonFunction.setStrAmount(datas.amount));
		$('#phase').val(datas.phase);
		$('#showPhase').val(FrontCommonFunction.setStrInvestorPhase(datas.phase));
		$('#patenter').val(datas.patenter);
		$('#solution').val(datas.solution);
		$('#applyTo').val(datas.applyTo);
		$('#expectedEffect').val(datas.expectedEffect);
		$('#caseNum').val(datas.caseNum);
		$('#caseDetail').val(datas.caseDetail);
		//成果形式
		var typeId=datas.type;
		$('#typeId').val(typeId);
		var typeArr=new Array();
		typeArr=typeId.split(",");
		for(var i=0;i<typeArr.length;i++){
			if(typeArr[i]==="0"){
				$("#typeCheckBox0").click();
			}else if(typeArr[i]==="1"){
				$("#typeCheckBox1").click();
			}else if(typeArr[i]==="2"){
				$("#typeCheckBox2").click();
			}else if(typeArr[i]==="3"){
				$("#typeCheckBox3").click();
			}
		}
		//寻求合作方式
		var cooperationTypeId=datas.cooperationType;
		$('#cooperationTypeId').val(cooperationTypeId);
		var arr=new Array();
		arr=cooperationTypeId.split(",");
		for(var i=0;i<arr.length;i++){
			if(arr[i]==="0"){
				$("#cooperationTypeCheckBox0").click();
			}else if(arr[i]==="1"){
				$("#cooperationTypeCheckBox1").click();
			}else if(arr[i]==="2"){
				$("#cooperationTypeCheckBox2").click();
			}else if(arr[i]==="3"){
				$("#cooperationTypeCheckBox3").click();
			}else if(arr[i]==="4"){
				$("#cooperationTypeCheckBox4").click();
			}else if(arr[i]==="5"){
				$("#cooperationTypeCheckBox5").click();
			}
			
		}
		var imgUrl=datas.logoUrl;//"../resources/images/front/img/fengmian_img.png";
	    var imgpath="";
		if(imgUrl!=null && imgUrl!=""){
			imgpath=$('#downFile').attr('url')+'?path='+imgUrl;
	     }else{
	    	 imgpath="../resources/images/front/img/fengmian_img.png";
	     }
		
		$('#companyLogo').attr('width',"160px");
		$('#companyLogo').attr('height',"120px");
		$('#companyLogo').attr('src',imgUrl);
		$('#imgPath').val(imgUrl);
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

function fromValidate() {
	return $('#achievementForm').validate({
		rules : {
			name : {
				required : true
			},
//			patenter : {
//				required : true
//			},
			solution : {
				required : true
			},
			applyTo : {
				required : true
			},
			expectedEffect : {
				required : true
			}
		},
		messages : {
			name : {
				required : '<font color="red">必填</font>'
			},
//			patenter : {
//				required : '<font color="red">必填</font>'
//			},
			solution : {
				required : '<font color="red">必填</font>'
			},
			applyTo : {
				required : '<font color="red">必填</font>'
			},
			expectedEffect : {
				required : '<font color="red">必填</font>'
			}
		}
	}).form();
};

function setSelectValue(){
	$("#selectResearchGroupName").delegate(' dd', 'click', function(){
	    $("#researchGroupName").val($(this).html()); 
	    $("#researchGroupId").val($(this).attr("id")); 
	    var researchGroupName=$("#researchGroupName").val();
		if(researchGroupName!==""){
			$("#checkResult1").html('');
		}
	});
	$("#selectPatent").find("dd").click(function(){
	    $("#patent").val($(this).attr("value")); 
	    var patent=$("#patent").val();
		if(patent!==""){
			$("#checkResult3").html('');
		}
	});
	$("#selectAmount").find("dd").click(function(){
	    $("#amount").val($(this).attr("value")); 
	    var amount=$("#amount").val();
		if(amount!==""){
			$("#checkResult4").html('');
		}
	});
	$("#selectPhase").find("dd").click(function(){
	    $("#phase").val($(this).attr("value")); 
	    var phase=$("#phase").val();
		if(phase!==""){
			$("#checkResult5").html('');
		}
	});
};

function uploadImg(fileId){
	var url = $('#upLoadImgUrl').attr('url');
	var filepath = $("#companyImgLogo").val();
	var extStart = filepath.lastIndexOf(".");
	var ext = filepath.substring(extStart, filepath.length).toUpperCase();
	if (ext != ".PNG" && ext != ".GIF" && ext != ".JPG" && ext != ".JPEG") {
		$("#imgTypeCheckResult").html('<font color="red">图像格式只能是:GIF,JPG,JPEG,PNG</font>');
		$("#imgCheckFlag").val("0");
		var path='';
		var imgUrl=datas.logoUrl;
		if(imgUrl==="" || imgUrl===undefined || imgUrl==="undefined"){
			path="../resources/images/front/img/fengmian_img.png";
		}else{
			path=$('#downFile').attr('url')+'?path='+imgUrl;
		}
		$('#companyLogo').attr('width',"160px");
		$('#companyLogo').attr('height',"120px");
		$('#companyLogo').attr('src',path);
		$('#imgPath').val("");
		return false;
	}else{
		$("#imgTypeCheckResult").html("");
	}
   //文件大小
   var dom = document.getElementById("companyImgLogo");
   var fileSize = dom.files[0].size;
   var size=fileSize/(1024*1024); //单位M
//   var imgSize=fileSize/1024; //单位k
	var path="";
	$.ajaxFileUpload({
		url : url, //用于文件上传的服务器端请求地址
		secureuri : false,//是否启用安全提交，一般设置为false
		fileElementId : fileId,//文件上传控件的id
		type:"post",
		data : "",
		dataType : 'json',
		success : function(data) {
			path=data.path;
			$('#imgPath').val(path);
			var imgUrl="../resources/images/front/img/pander.jpg";
			$('#companyLogo').attr('width',"160px");
			$('#companyLogo').attr('height',"120px");
			$('#companyLogo').attr('src',imgUrl);
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert('操作失败');
		},
		complete : function(XMLHttpRequest, textStatus) {
			//("loaded");  
		}
	})
	return path;
};

function uploadFile(fileId){
	var url = $('#upLoadFileUrl').attr('url');
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
	$.ajaxFileUpload({
		url : url, //用于文件上传的服务器端请求地址
		secureuri : false,//是否启用安全提交，一般设置为false
		fileElementId : fileId,//文件上传控件的id
		type:"post",
		data : "",
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
};

function save() {
	 //表单验证通过
	var url = "";
	var updateId=$("#updateId").val();
	if(updateId!=="" && updateId!==undefined && updateId!=="undefined"){
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
		formId:'achievementForm',
		timeout : 100000,
		secureuri : false, //一般设置为false
		dataType : 'json', //返回值类型 一般设置为json
		success : function(datas){
			if(datas.status===0){
//					$('#Button1').click();
				$('#altstwo').show();
				setTimeout(function(){//2.5秒后隐藏
//						CloseDiv('MyDiv','fade');
					$('#altstwo').hide();
					var myAchievementUrl = $('#myAchievementUrl').attr('url');
					location.href=myAchievementUrl;
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
	var researchGroup = {};
	var researchGroupId=$("#researchGroupId").val();
    researchGroup['id']=researchGroupId;
	researchGroup['name']=$.trim($('#researchGroupName').val());
	
    var updateId=$("#updateId").val();
	if(updateId!=="" && updateId!==undefined && updateId!=="undefined"){
		paramTemp['id']=updateId;
	}
	paramTemp['researchGroup']=researchGroup;
	paramTemp['name']=$.trim($('#name').val());
	paramTemp['domain']=$.trim($('#domain').val());
	paramTemp['patent']=$.trim($('#patent').val());
	paramTemp['patenter']=$.trim($('#patenter').val());
	paramTemp['amount']=$.trim($('#amount').val());
	paramTemp['solution']=$.trim($('#solution').val());
	paramTemp['phase']=$.trim($('#phase').val());
	paramTemp['type']=$.trim($('#typeId').val());
	paramTemp['cooperationType']=$.trim($('#cooperationTypeId').val());
	paramTemp['applyTo']=$('#applyTo').val();
	paramTemp['expectedEffect']=$('#expectedEffect').val();
	paramTemp['caseNum']=$('#caseNum').val();
	paramTemp['caseDetail']=$('#caseDetail').val();
	paramTemp['logoUrl']=$('#imgPath').val();
	paramTemp['attachUrl']=$('#filePath').val();
	return paramTemp;
};