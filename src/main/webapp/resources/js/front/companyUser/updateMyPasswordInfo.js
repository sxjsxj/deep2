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
	setLeftNav('#updateMyPassword');
	initLoginUser();
	initChangeMyInfo();
	var id=$("#commonCompanyUserId").val();
	if(id!=="" && id!==null){
		getDetail();
	}
});

function initChangeMyInfo() {
	updateMyInfoInit();
	$('#commit').click(function() {
		if(passwordFromValidate()){
			var url = $('#commit').attr('url');
			var paramTemp = {};
			var commonUserLoginId=$("#commonUserLoginId").val();
			paramTemp['id']=commonUserLoginId;
			paramTemp['oldPassword']=$.trim($('#oldPassword').val());
			paramTemp['newPassword']=$.trim($('#newPasswordOne').val());
			save(url,paramTemp);
		}else{
			return;
		}
    });
	
	$('#save').click(function() {
		if(emailFromValidate()){
			var url = $('#save').attr('url');
			var paramTemp = {};
			var commonUserLoginId=$("#commonUserLoginId").val();
			paramTemp['id']=commonUserLoginId;
			paramTemp['email']=$.trim($('#email').val());
			paramTemp['telno']=$.trim($('#telno').val());
			save(url,paramTemp);
		}else{
			return;
		}
    });
};

function passwordFromValidate() {
	return $('#passwordForm').validate({
		rules : {
			oldPassword : {
				required : true,
				rangelength : [ 6, 20 ]
			},
			newPasswordOne : {
				required : true,
				rangelength : [ 6, 20 ]
			},
			newPasswordTwo : {
				required : true,
				equalTo : "#newPasswordOne",
				rangelength : [ 6, 20 ]
			}
		},
		messages : {
			oldPassword : {
				required : '<font color="red">&nbsp;&nbsp;必填</font>',
				rangelength : jQuery.format('<font color="red">&nbsp;&nbsp;6~20个字符</font>'),
			},
			newPasswordOne : {
				required : '<font color="red">&nbsp;&nbsp;必填</font>',
				rangelength : jQuery.format('<font color="red">&nbsp;&nbsp;6~20个字符</font>'),
			},
			newPasswordTwo : {
				required : '<font color="red">&nbsp;&nbsp;必填</font>',
				rangelength : jQuery.format('<font color="red">&nbsp;&nbsp;6~20个字符</font>'),
				equalTo : '<font color="red">&nbsp;&nbsp;密码不一致</font>'
			}
		}
	}).form();
};

function emailFromValidate() {
	// 手机号码验证
	jQuery.validator.addMethod("telno", function(value, element) {
		var length = value.length;
		var mobile = /^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/;
		return this.optional(element) || (length == 11 && mobile.test(value));
	}, '<font color="red">&nbsp;手机号不正确</font>');
	
	return $('#emailForm').validate({
		rules : {
			email : {
				required: true,
				email:email
				},
			telno : {
				required: true,
				telno:true
			}
		},
		messages : {
			email :{
				required: '<font color="red">&nbsp;&nbsp;必填</font>'
			},
			telno :{
				required: '<font color="red">&nbsp;&nbsp;必填</font>'
			}
		}
	}).form();
};

function save(url,requestParam) {
	var saveParam={};
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
			//保存失败 弹框
			$('#errorInfo').html("");
			FrontCommonFunction.processResult(datas,"#alertClick","#errorInfo");
			setTimeout(function(){//5秒后隐藏
				$('#altsthree').hide();
			}, 1500);
		}
	};
	$.ajax(FrontCommonFunction.baseOptions);
};

function getDetail() {
	var id=$("#commonCompanyUserId").val();
	var url = $('#getDetailUrl').attr('url');
	FrontCommonFunction.baseOptions['url'] = url;
	var requestParamTemp = {};
	requestParamTemp['id']=id;
	FrontCommonFunction.baseOptions['data'] = requestParamTemp;
	FrontCommonFunction.baseOptions['success'] = function(datas) {
		if(datas){
			//$("#oldPassword").val(datas.userModel.password);
			$("#email").val(datas.userModel.email);
			$("#telno").val(datas.userModel.telno);
		}else{
			//保存失败 弹框
			$('#errorInfo').html("");
			FrontCommonFunction.processResult(datas,"#alertClick","#errorInfo");
		}
	};
	$.ajax(FrontCommonFunction.baseOptions);
};
