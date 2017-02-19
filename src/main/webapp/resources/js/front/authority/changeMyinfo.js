$(document).ready(function() {
	initChangeMyInfo();
	
});
function initChangeMyInfo() {
	
	$('#commit').click(function() {
		if(passwordFromValidate()){
			var url = $('#commit').attr('url');
			var paramTemp = {};
			paramTemp['id']="1";
			paramTemp['password']=$.trim($('#newPasswordOne').val());
			save(url,paramTemp);
		}else{
			return;
		}
    });
	
	$('#save').click(function() {
		if(emailFromValidate()){
			var url = $('#save').attr('url');
			var paramTemp = {};
			paramTemp['id']="1";
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
				required : '<font color="red">必填</font>',
				rangelength : jQuery.format('<font color="red">6~20个字符</font>'),
			},
			newPasswordOne : {
				required : '<font color="red">必填</font>',
				rangelength : jQuery.format('<font color="red">6~20个字符</font>'),
			},
			newPasswordTwo : {
				required : '<font color="red">必填</font>',
				rangelength : jQuery.format('<font color="red">6~20个字符</font>'),
				equalTo : '<font color="red">密码不一致</font>'
			}
		}
	}).form();

}


function emailFromValidate() {
	// 手机号码验证
	jQuery.validator.addMethod("telno", function(value, element) {
		var length = value.length;
		var mobile = /^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/;
		return this.optional(element) || (length == 11 && mobile.test(value));
	}, '<font color="red">手机号不正确</font>');
	
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
				required: '<font color="red">必填</font>'
			},
			telno :{
				required: '<font color="red">必填</font>'
			}
		}
	}).form();

}


function save(url,requestParam) {
	var saveParam={};
	var jsonStr=JSON.stringify(requestParam);
	alert(jsonStr);
	saveParam['str']=jsonStr;
	FrontCommonFunction.baseOptions['url'] = url;
	FrontCommonFunction.baseOptions['data'] = saveParam;
	FrontCommonFunction.baseOptions['success'] = function(datas) {
		if(datas.status===0){
			
		}else{
			alert("修改成功");
		}
		
	};
	$.ajax(FrontCommonFunction.baseOptions);
};

function getData() {
	var paramTemp = {};
//	var checkflag=$("#checkTagValue").val();
	paramTemp['id']="1";
	//旧密码怎么传??
//	if(checkflag==="0"){
		paramTemp['password']=$.trim($('#newPasswordOne').val());
//	}else{
//		paramTemp['email']=$.trim($('#email').val());
//		paramTemp['telno']=$.trim($('#telno').val());
//	}
	return paramTemp;
};











