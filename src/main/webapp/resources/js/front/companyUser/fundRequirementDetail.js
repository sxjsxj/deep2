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

	//设置左侧导航
	setLeftNav('#companyMyRequirement');
	initCompanyAmountManager();

	$('#Button1').click(function(){
	});
    var updateId=$("#updateId").val();
	if(updateId!=="" && updateId!==undefined && updateId!=="undefined"){
		getDetail(updateId);
		$("#agree").attr("checked", true);
	}
});
function initCompanyAmountManager() {
	//下拉注册事件
	setSelectValue();
	//设置行业
	FrontCommonFunction.initSelectBaseResearchField("#selectDomain");
	$("#selectDomain").find("dd").click(function(){
	    $("#domain").val($(this).attr("value"));
	    var domain=$("#domain").val();
		if(domain!==""){
			$("#checkResult1").html('');
		}
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
		var domain=$("#domain").val();
		if(domain===""){
			$("#checkResult1").html('<font color="red">必填</font>');
		}
		var projectPhase=$("#projectPhase").val();
		if(projectPhase===""){
			$("#checkResult2").html('<font color="red">必填</font>');
		}

		var amountNeeded=$("#amountNeeded").val();
		if(amountNeeded===""){
			$("#checkResult3").html('<font color="red">必填</font>');
		}
		var fileTypeCheckResult=$('#fileTypeCheckResult').html();

		if(fromValidate() && imgCheckFlag==="" && fileCheckFlag==="" && domain!=="" && projectPhase!=="" && amountNeeded!==""){
			if($("#agree").is(":checked")){
				save();
			}else{
				$("#notAgree").html('<font color="red">请勾选我承诺以上需求描述属实</font>');
				return;
			}
		}else{
			return;
		}
    });
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
}

function getDetail(id) {
    //表单验证通过
	var url = $('#getDetailUrl').attr('detailUrl');
	var detailParam={};
	detailParam['id']=id;//$("#commonFundRequirementId").val();;
	FrontCommonFunction.baseOptions['url'] = url;
	FrontCommonFunction.baseOptions['data'] = detailParam;
	FrontCommonFunction.baseOptions['success'] = function(datas) {
		$('#name').val(datas.name);
		$('#domain').val(datas.domain);
		$("#showDomain").val(FrontCommonFunction.setInvestorDomain(datas.domain));
		$('#projectTeam').val(datas.projectTeam);
		$('#projectIntro').val(datas.projectIntro);
		$('#projectPhase').val(datas.projectPhase);
		$('#showProjectPhase').val(FrontCommonFunction.setStrInvestorPhase(datas.projectPhase));
		$('#projectProspect').val(datas.projectProspect);
		$('#amountNeeded').val(datas.amountNeeded);
		$("#showAmountNeeded").val(FrontCommonFunction.setStrAmount(datas.amountNeeded));

		var imgUrl=datas.logoUrl;
	    var imgpath="";
		if(imgUrl!=null && imgUrl!=""){
			imgpath=$('#downFile').attr('url')+'?path='+imgUrl;
	     }else{
	    	imgpath="../resources/images/front/img/fengmian_img.png";
	     }
		$('#companyLogo').attr('src',imgpath);
		$('#filePath').val(datas.attachUrl);
		if(datas.attachName) {
			$('#fileTypeCheckResult').html('已上传文件:'+datas.attachName);
		}
	};
	$.ajax(FrontCommonFunction.baseOptions);
};

function fromValidate() {
	return $('#fundRequirementForm').validate({
		rules : {
			name : {
				required : true
			},
			projectTeam : {
				required : true
			},
			projectIntro : {
				required : true
			},
			projectProspect : {
				required : true
			}
		},
		messages : {
			name : {
				required : '<font color="red">必填</font>'
			},
			projectTeam : {
				required : '<font color="red">必填</font>'
			},
			projectIntro : {
				required : '<font color="red">必填</font>'
			},
			projectProspect : {
				required : '<font color="red">必填</font>'
			}
		}
	}).form();
};

function setSelectValue(){
	$("#selectPhase").find("dd").click(function(){
	    $("#projectPhase").val($(this).attr("value"));
	    var projectPhase=$("#projectPhase").val();
		if(projectPhase!==""){
			$("#checkResult2").html('');
		}
	});
	$("#selectAmount").find("dd").click(function(){
	    $("#amountNeeded").val($(this).attr("value"));
	    var amountNeeded=$("#amountNeeded").val();
		if(amountNeeded!==""){
			$("#checkResult3").html('');
		}
	});
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
		formId:'fundRequirementForm',
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
					var myRequireUrl = $('#myRequireUrl').attr('url');
					location.href=myRequireUrl;
				}, 1000);
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
	var paramTemp = {};
	var user = {};
	user['id']=$("#commonCompanyUserId").val();
	var updateId=$("#updateId").val();
	if(updateId!=="" && updateId!==undefined && updateId!=="undefined"){
		paramTemp['id']=updateId;
	}
	paramTemp['companyUser']=user;
	paramTemp['name']=$.trim($('#name').val());
	paramTemp['domain']=$.trim($('#domain').val());
	paramTemp['projectTeam']=$.trim($('#projectTeam').val());
	paramTemp['projectIntro']=$.trim($('#projectIntro').val());
	paramTemp['projectPhase']=$.trim($('#projectPhase').val());
	paramTemp['projectProspect']=$.trim($('#projectProspect').val());
	paramTemp['amountNeeded']=$.trim($('#amountNeeded').val());
	return paramTemp;
};
