$(document).ready(function() {
	initUserManager();
	if($('#flag').val() == '0') {
		$('#loginError').html('<font color="red">&nbsp;用户名不存在！</font>');
	}
	if($('#flag').val() == '1') {
		$('#loginError').html('<font color="red">&nbsp;用户名或密码错误！</font>');
	}
});
function initUserManager() {
	$('#login').click(function() {
		login();
	});
};

function login() {
	$('#loginForm').submit();
};

function getData() {
	var paramTemp = {};
	paramTemp['username'] = $('#username').val();
	paramTemp['password'] = $('#password').val();
	return paramTemp;
};
