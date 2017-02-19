function commonInit() {
	initLoginUser();
	setRegionClick();
};

function updateMyInfoInit() {
	$('#emailForm').hide();
	$('#editPassword').click(function() {
		$('#passwordForm').show();
		$('#emailForm').hide();
	});
	$('#editEmail').click(function() {
		$('#passwordForm').hide();
		$('#emailForm').show();
	});
};

function defaultInfoInit() {
	var url = $('#currentUser').attr('url');
	FrontCommonFunction.baseOptions['url'] = url;
	FrontCommonFunction.baseOptions['data'] = {};
	FrontCommonFunction.baseOptions['success'] = function(datas) {
		alert(JSON.stringify(datas));
		if(datas !== null) {
			if(datas.userType == '0') {
				$('#contactTel').val(datas.contactTel);
			}
			if(datas.userType == '1') {
				$('#contactTel').val(datas.contactTel);
			}
			if(datas.userType == '2') {
				$('#contactTel').val(datas.contactTel);
			}
		}
	};
	$.ajax(FrontCommonFunction.baseOptions);
};