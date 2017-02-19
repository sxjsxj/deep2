$(document).ready(function() {
	init();
	
});
function init() {
	//选择投资方注册
	$('#investor').click(function() {
		var url = $('#investor').attr('url');
		location.href=url;
//		window.open(url);
    });
	//选择科研团队注册
	$('#researchGroup').click(function() {
		var url = $('#researchGroup').attr('url');
		location.href=url;
//		window.open(url);
    });
	//选择企业
	$('#company').click(function() {
		var url = $('#company').attr('url');
		location.href=url;
//		window.open(url);
    });
	
	
};














