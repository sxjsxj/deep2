document.onkeydown=function(event){ 
			e = event ? event :(window.event ? window.event : null); 
			if(e.keyCode==13){ 
			//执行的方法 
				doLogin();
			} 
} 
function doLogin() {
	window.location.href = "back/index.html";
//	var username = $("#username").val();
//	var password = $("#password").val();
//	$.ajax({
//		url : "security/user/login",
//		method : "POST",
//		dataType : "json",
//		async : false,
//		data : {
//			"username" : username,
//			"password" : password
//		},
//		success : function(data) {
//			//var ret = eval(data);
//			if (data.success===0) {
//				window.location.href = "back/index.html";
//			} else {
//				window.location.href = "login.html";
//			}
//		}
//	});
}

//忘记密码发送邮件调用
function send() {
	var email = $("#email").val();
	alert("发送邮件"+email);
	window.location.href = "login.html";
	/*$.ajax({
		url : "myLoginController/sendEmail",
		method : "POST",
		dataType : "json",
		async : false,
		data : {
			"email" : email
		},
		success : function(data) {
			//var ret = eval(data);
			if (data.success===0) {
				window.location.href = "back/index.html";
			} else {
				window.location.href = "login.html";
			}
		}
	});*/
}

