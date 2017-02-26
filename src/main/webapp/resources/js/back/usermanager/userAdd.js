$(document).ready(function() {
	$('#adminUserAdd').click(function() {
		save();
	});
});

function save() {
    //表单验证通过
	var url = $('#adminUserAdd').attr('url');
	var saveParam={};
	var requestParam = getData();
	var jsonStr=JSON.stringify(requestParam);
	saveParam['str']=jsonStr;
	CommonFunction.baseOptions['url'] = url;
	CommonFunction.baseOptions['data'] = saveParam;
	CommonFunction.baseOptions['success'] = function(datas) {
		if(datas.status===0){
			alert('成功!!!');
		}else{
			
			alert('失败:'+datas.errorList);
		}
		
	};
	$.ajax(CommonFunction.baseOptions);
};

function getData() {
	var user = {};
	user['userType']='3';
	user['email']=$.trim($('#email').val());
	user['telno']=$.trim($('#telno').val());
	user['password']=$.trim($('#password').val());
	return user;
};
