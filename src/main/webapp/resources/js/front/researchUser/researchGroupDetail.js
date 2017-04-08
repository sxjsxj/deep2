$(document).ready(function() {
	initResearchGroupManager();
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
	
	//设置左侧导航
	setLeftNav('#researchGroupMyReserachGroup');
	var updateId=$("#updateId").val();
	if(updateId!=="" && updateId!==undefined && updateId!=="undefined"){
		getDetail(updateId);
		$("#agree").attr("checked", true);
	}
});
function initResearchGroupManager() {
	//下拉注册事件
	setSelectValue();
	//自动带出联系方式
	$("#leaderTel").val($('#commonUserTel').val());
	
	$("#leaderPosition").keyup(function(){
		var leaderPosition=$("#leaderPosition").val();
		if(leaderPosition!==""){
			$("#leaderPositionResult").html("");
		}
	});
	
	$("#leaderName").keyup(function(){
		var leaderName=$("#leaderName").val();
		if(leaderName!==""){
			$("#leaderNameResult").html('');
		}
	});
	
	$("#leaderTel").keyup(function(){
		var leaderTel=$("#leaderTel").val();
		if(leaderTel!==""){
			$("#leaderTelResult").html('');
		}
	});
	
	//设置行业
	FrontCommonFunction.initSelectBaseResearchField("#selectDomain");
	$("#selectDomain").find("dd").click(function(){
	    $("#domain").val($(this).attr("value")); 
	    var domain=$("#domain").val();
		if(domain!==""){
			$("#checkResult3").html('');
		}
	});
	$('#saveBtn').click(function() {
		
		var imgCheckFlag=$("#imgCheckFlag").val();//为空代表成功,0代表失败
		var fileCheckFlag=$("#fileCheckFlag").val();//为空代表成功,0代表失败
		if(imgCheckFlag==="0"){
			$("#imgTypeCheckResult").html('<font color="red">图像格式只能是:GIF,JPG,JPEG,PNG</font>');
		}
        if(fileCheckFlag==="0"){
        	$("#fileTypeCheckResult").html('<font color="red">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;附件大小不能超过5M</font>');
		}
		
		//图片验证通过值为空 否则为0
		var leaderImgCheckFlag=$("#leaderImgCheckFlag").val();
		if(leaderImgCheckFlag==="0"){
			$("#leaderImgTypeCheckResult").html('<font color="red">图像格式只能是:GIF,JPG,JPEG,PNG</font>');
		}
		
		var leaderName=$("#leaderName").val();
		var leaderTel=$("#leaderTel").val();
		if(leaderTel===""){
			$("#leaderTelResult").html('<font color="red">必填</font>');
		}
		if(leaderName===""){
			$("#leaderNameResult").html('<font color="red">必填</font>');
		}
		if($.trim($('#achievement').val() =='')) {
			$("#achievementResult").html('<font color="red">必填</font>');
		}
		var leaderTitle=$("#leaderTitle").val();
		var leaderPosition=$("#leaderPosition").val();
		if(leaderPosition===""){
			$("#leaderPositionResult").html('<font color="red">必填</font>');
		}
		if(leaderTitle===""){
			$("#leaderTitleResult").html('<font color="red">必填</font>');
		}
		
		var domain=$("#domain").val();
		if(domain===""){
			$("#checkResult3").html('<font color="red">必填</font>');
		}
		
		if(fromValidate() && imgCheckFlag==="" && fileCheckFlag===""
			&& leaderImgCheckFlag==="" && leaderName!=="" && leaderTitle!=="" && leaderPosition!=="" && leaderTel!==""&& domain!==""){
			if($("#agree").is(":checked")){
				save();
			}else{
				$("#notAgree").html('<font color="red">&nbsp;&nbsp;请您承诺以上科研团队及负责人信息属实，并勾选此项</font>');
				return;
			}
		}else{
			return;
		}
    });
};

function fromValidate() {
	return $('#researchGroupForm').validate({
		rules : {
			name : {
				required : true
			},
			field : {
				required : true
			},
			experience : {
				required : true
			},
			leaderDepart : {
				required : true
			},
			teamSize : {
				number:true
			}
		},
		messages : {
			name : {
				required : '<font color="red">必填</font>'
			},
			field : {
				required : '<font color="red">必填</font>'
			},
			experience : {
				required : '<font color="red">必填</font>'
			},
			leaderDepart : {
				required : '<font color="red">必填</font>'
			},
			teamSize : {
				number:'<font color="red">数字</font>'
			}
		}
	}).form();
};

function setSelectValue(){
	$("#selectLeaderTitle").find("dd").click(function(){
	    $("#leaderTitle").val($(this).attr("value")); 
	    var leaderTitle=$("#leaderTitle").val();
		if(leaderTitle!==""){
			$("#leaderTitleResult").html('');
		}
	});
};

function showPreview(source,imgId) {
	if(imgId==="projectLogo"){
		imgVerify();
	}
	if(imgId==="leaderLogo"){
		leaderLogoImgVerify();
	}
    var file = source.files[0];
    if (window.FileReader) {
        var fr = new FileReader();
        fr.onloadend = function(e) {
        	document.getElementById(imgId).src = e.target.result;
        };
        fr.readAsDataURL(file);
    }
};

function imgVerify(){
	var filepath = $("#companyImgLogo").val();
	var extStart = filepath.lastIndexOf(".");
	var ext = filepath.substring(extStart, filepath.length).toUpperCase();
	if (ext != ".PNG" && ext != ".GIF" && ext != ".JPG" && ext != ".JPEG") {
		$("#imgTypeCheckResult").html('<font color="red">&nbsp;&nbsp;图像格式只能是:GIF,JPG,JPEG,PNG</font>');
		$("#imgCheckFlag").val("0");//验证不通过标识
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
}


function leaderLogoImgVerify(){
	var filepath = $("#leaderImgLogo").val();
	var extStart = filepath.lastIndexOf(".");
	var ext = filepath.substring(extStart, filepath.length).toUpperCase();
	if (ext != ".PNG" && ext != ".GIF" && ext != ".JPG" && ext != ".JPEG") {
		$("#leaderImgTypeCheckResult").html('<font color="red">&nbsp;&nbsp;图像格式只能是:GIF,JPG,JPEG,PNG</font>');
		$("#leaderImgCheckFlag").val("0");//验证不通过标识
		return false;
	}else{
		$("#leaderImgCheckFlag").val("");
		$("#leaderImgTypeCheckResult").html("");
	}
   //文件大小
   var dom = document.getElementById("leaderImgLogo");
   var fileSize = dom.files[0].size;
   var size=fileSize/(1024*1024); //单位M
   if(size>2){
	   $("#leaderImgTypeCheckResult").html('<font color="red">图片大小不能超过2M</font>');
	   $("#leaderImgCheckFlag").val("0");//验证不通过标识
	   return false;
   }else{
	   $("#leaderImgCheckFlag").val("");
	   $("#leaderImgTypeCheckResult").html("");
   }
   return true;
};


function getDetail(id) {
    //表单验证通过
	var url = $('#getDetailUrl').attr('detailUrl');
	var detailParam={};
	detailParam['id']=id;//$("#commonResearchGroupId").val();;
	FrontCommonFunction.baseOptions['url'] = url;
	FrontCommonFunction.baseOptions['data'] = detailParam;
	FrontCommonFunction.baseOptions['success'] = function(datas) {
		console.log(JSON.stringify(datas));
		$('#name').val(datas.name);
		$('#domain').val(datas.domain);
		$("#showDomain").val(FrontCommonFunction.setInvestorDomain(datas.domain));
		$('#leaderTitle').val(datas.leaderTitle);
		$('#showLeaderTitle').val(FrontCommonFunction.setStrLeaderTitle(datas.leaderTitle));
		$('#introduction').val(datas.introduction);
		$('#field').val(datas.field);
		$('#achievement').val(datas.achievement);
		$('#teamSize').val(datas.teamSize);
		$('#experience').val(datas.experience);
		$('#leaderName').val(datas.leaderName);
		$('#leaderTel').val(datas.leaderTel);
		$('#leaderDepart').val(datas.leaderDepart);
		$('#leaderPosition').val(datas.leaderPosition);
		$('#leaderIntro').val(datas.leaderIntro);
		$('#leaderAchieve').val(datas.leaderAchieve);
		$('#teamOthers').val(datas.teamOthers);
		var imgUrl=datas.logoUrl;
		var path='';
		if(imgUrl==="" || imgUrl===undefined || imgUrl==="undefined"){
			path="../resources/images/front/img/fengmian_img.png";
		}else{
			path=$('#downFile').attr('url')+'?path='+imgUrl;
		}
		$('#companyImg').attr('src',path);
		//$('#imgPath').val(imgUrl);
		var leaderUrl=datas.leaderUrl;
		if(leaderUrl==="" || leaderUrl===undefined || leaderUrl==="undefined"){
			leaderUrl="../resources/images/front/img/fengmian_img.png";
		}else{
			leaderUrl=$('#downFile').attr('url')+'?path='+leaderUrl;
		}
		$('#leaderImg').attr('src',leaderUrl);
		
		$('#filePath').val(datas.attachUrl);
		if(datas.attachName) {
			$('#fileTypeCheckResult').html('已上传文件:'+datas.attachName);
		}
	};
	$.ajax(FrontCommonFunction.baseOptions);
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
			formId:'researchGroupForm',
			timeout : 100000,
			secureuri : false, //一般设置为false
			dataType : 'json', //返回值类型 一般设置为json
			success : function(datas){
				if(datas.status===0){
//					$('#Button1').click();
					$('#altstwo').show();
				}else{
					//失败
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
	user['id']=$("#commonResearchUserId").val();
	paramTemp['researchUser']=user;
	
	var updateId=$("#updateId").val();
	if(updateId!=="" && updateId!==undefined && updateId!=="undefined"){
		paramTemp['id']=updateId;
	}
	paramTemp['name']=$.trim($('#name').val());
	paramTemp['domain']=$.trim($('#domain').val());
	paramTemp['introduction']=$.trim($('#introduction').val());
	paramTemp['field']=$.trim($('#field').val());
	paramTemp['achievement']=$.trim($('#achievement').val());
	paramTemp['teamSize']=$.trim($('#teamSize').val());
	paramTemp['experience']=$.trim($('#experience').val());
	paramTemp['leaderName']=$.trim($('#leaderName').val());
	paramTemp['leaderTel']=$.trim($('#leaderTel').val());
	paramTemp['leaderDepart']=$('#leaderDepart').val();
	paramTemp['leaderTitle']=$('#leaderTitle').val();
	paramTemp['leaderPosition']=$('#leaderPosition').val();
	paramTemp['leaderIntro']=$('#leaderIntro').val();
	
	paramTemp['leaderAchieve']=$('#leaderAchieve').val();
	paramTemp['teamOthers']=$('#teamOthers').val();
	
	paramTemp['logoUrl']=$('#imgPath').val();
	paramTemp['attachUrl']=$('#filePath').val();
	return paramTemp;
};