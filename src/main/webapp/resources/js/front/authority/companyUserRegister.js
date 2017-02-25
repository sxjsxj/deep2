$(document).ready(function() {
	initInvestorRegistor();
	
});
var queryParam = {};
function initInvestorRegistor() {
	
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
	
	$('#agree').click(function() {
		if($("#agree").is(":checked")){
			$("#notAgree").html('');
		}
    });
	
	$('#registComit').click(function() {
		if(fromValidate()){
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

function fromValidate() {
	// 手机号码验证
	jQuery.validator.addMethod("telno", function(value, element) {
		var length = value.length;
		var mobile = /^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/;
		return this.optional(element) || (length == 11 && mobile.test(value));
	}, '<font color="red">&nbsp;手机号不正确</font>');
	
	return $('#companyUserRegistorForm').validate({
		rules : {
			email : {
				required: true,
				email:email
				},
			telno : {
				required: true,
				telno:true
				},
			passwordone : {
				required : true,
				rangelength : [ 6, 20 ]
			},
			passwordtwo : {
				required : true,
				equalTo : "#passwordone",
				rangelength : [ 6, 20 ]
			}
		},
		messages : {
			email :{
				required: '<font color="red">&nbsp;必填</font>'
			},
			telno :{
				required: '<font color="red">&nbsp;必填</font>'
			},
			passwordone : {
				required : '<font color="red">&nbsp;必填</font>',
				rangelength : jQuery.format('<font color="red">&nbsp;6~20个字符</font>'),
			},
			passwordtwo : {
				required : '<font color="red">&nbsp;必填</font>',
				rangelength : jQuery.format('<font color="red">&nbsp;6~20个字符</font>'),
				equalTo : '<font color="red">&nbsp;密码不一致</font>'
			}
		}
	}).form();

}

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
	var userModel = {};
	userModel['userType']="0";
	userModel['email']=$.trim($('#email').val());
	userModel['telno']=$.trim($('#telno').val());
	userModel['password']=$.trim($('#passwordone').val());
	paramTemp['userModel'] = userModel;
	paramTemp['userModel']=userModel;
	return paramTemp;
};