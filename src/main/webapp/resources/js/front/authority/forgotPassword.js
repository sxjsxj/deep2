$(document).ready(function() {
	initFindPasswordManager();
	$('#Button1').click(function(){
	});
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
});
function initFindPasswordManager() {
	$('#send').click(function() {
		if(fromValidate()){
			send();
		}else{
			return;
		}
		
	});
};


function fromValidate() {
	return $('#findPasswordForm').validate({
		rules : {
			email : {
				required: true,
				email:email
				},
				password : {
				required : true,
				rangelength : [ 6, 20 ]
			}
		},
		messages : {
			email :{
				required: '<font color="red">&nbsp;&nbsp;必填</font>'
			},
			password : {
				required : '<font color="red">&nbsp;&nbsp;必填</font>',
				rangelength : jQuery.format('<font color="red">&nbsp;&nbsp;6~20个字符</font>'),
			}
		}
	}).form();

}

function send() {
	    //表单验证通过
		var url = $('#send').attr('url');
		var saveParam={};
		saveParam['str']=$('#email').val();
		FrontCommonFunction.baseOptions['url'] = url;
		FrontCommonFunction.baseOptions['data'] = saveParam;
		FrontCommonFunction.baseOptions['success'] = function(datas) {
			if(datas.status===0){
//			$('#Button1').click();
//			setTimeout(function(){
//				CloseDiv('MyDiv','fade');
//				var toLoginPageUrl = $('#toLoginPageUrl').attr('url');
//				location.href=toLoginPageUrl;
//			}, 1500);
			$('#altstwo').show();
			var submitUrl = $('#toSubmitPasswordPageUrl').attr('url');
			setTimeout(function(){//5秒后隐藏
				$('#altstwo').hide();
				location.href=submitUrl;
				}, 1500);
			}else{
				$('#errorInfo').html("");
			FrontCommonFunction.processResult(datas,"#alertClick","#errorInfo");
			}
			
		};
		$.ajax(FrontCommonFunction.baseOptions);
};

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

function getData() {
	var paramTemp = {};
	paramTemp['email'] = $('#email').val();
	return paramTemp;
};
