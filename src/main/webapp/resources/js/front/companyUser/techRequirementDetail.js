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

	$('#Button1').click(function(){
	});
	var updateId=$("#updateId").val();
	if(updateId!=="" && updateId!==undefined && updateId!=="undefined"){
		getDetail(updateId);
		$("#agree").attr("checked", true);
	}
	//设置左侧导航
	setLeftNav('#companyMyRequirement');
	initCompanyTechnicalDemand();
});


function initCompanyTechnicalDemand() {
	//下拉注册事件
	setSelectValue();
	$("#contactName").keyup(function(){
		var contactName=$("#contactName").val();
		if(contactName!==""){
			$("#contactNameResult").html("");
		}
	});

	$("#contactTel").keyup(function(){
		var contactTel=$("#contactTel").val();
		if(contactTel!==""){
			$("#contactTelResult").html("");
		}
	});
	$("#contactEmail").keyup(function(){
		var contactEmail=$("#contactEmail").val();
		var flag=/^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))$/i.test(contactEmail);
		if(flag){
			$("#contactEmailResult").html("");
		}

	});
	//设置行业
	FrontCommonFunction.initSelectBaseResearchField("#selectDomain");
	$("#selectDomain").find("dd").click(function(){
	    $("#domain").val($(this).attr("value"));
	    var domain=$("#domain").val();
		if(domain!=="" ){
			$("#domainCheckResult").html('');
		}
	});
	//合作方式
	$("#checkBoxCooperationType [id^=cooperationTypeCheckBox]").click(function() {
		//cooperationTypeCheckBox固定长度是23
		var idIndex=$(this).attr("id").substring(23);
		//固定属性：cooperationTypeCheckBoxValue
		if($("#cooperationTypeCheckBoxValue"+idIndex).hasClass("on")){
			 $("#cooperationTypeCheckBoxValue"+idIndex).removeClass("on");
		}else{
			 $("#cooperationTypeCheckBoxValue"+idIndex).attr("class","on");
		}
		text = $("#checkBoxCooperationType [id^=cooperationTypeCheckBoxValue]input[class=on]").map(function(index,elem) {
			return $(elem).val();
		}).get().join(',');

		if(text!==""){
			$("#cooperationTypeCheckResult").html('');
		}else{
			$("#cooperationTypeCheckResult").html('<font color="red">合作方式至少选一种</font>');
		}

		$("#cooperationTypeId").val(text);
	});

	$('#saveBtn').click(function() {
		var fileCheckFlag=$("#fileCheckFlag").val();//为空代表成功,0代表失败
		if(fileCheckFlag==="0"){
        	$("#fileTypeCheckResult").html('<font style="color:red;">上传文件超过5M,请重新上传。</font>');
		}

		var contactName=$("#contactName").val();
		var contactTel=$("#contactTel").val();
		var contactEmail=$("#contactEmail").val();

		var domain=$("#domain").val();
		var amount=$("#amount").val();
		if(amount===""){
			$("#amountCheckResult").html('<font color="red">必填</font>');
		}
		if(domain===""){
			$("#domainCheckResult").html('<font color="red">必填</font>');
		}

		var duration=$("#duration").val();
		var type=$("#type").val();
		if(duration===""){
			$("#durationCheckResult").html('<font color="red">必填</font>');
		}
		if(type===""){
			$("#typeCheckResult").html('<font color="red">必填</font>');
		}

		var cooperationType=$('#cooperationTypeId').val();

		if(cooperationType===""){
			$("#cooperationTypeCheckResult").html('<font color="red">合作方式至少选一种</font>');
		}

		var emailCheck=true;
		var contactEmail=$('#contactEmail').val();
		if(contactEmail!==""){
		    emailCheck=/^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))$/i.test(contactEmail);
			if(!emailCheck){
				$("#contactEmailResult").html('<font color="red">格式错误</font>');
			}
		}

		if(fromValidate() && emailCheck===true && contactName!=="" && fileCheckFlag==="" && cooperationType!=="" && contactTel!=="" && domain!=="" && amount!==""&& duration!=="" && type!==""){
			if($("#agree").is(":checked")){
				save();
			}else{
				$("#notAgree").html('<font color="red">请勾选我承诺以上企业需求属实</font>');
				return;
			}
		}else{
			return;
		}
   });
};


function fromValidate() {
	return $('#techRequirementFrom').validate({
		rules : {
			name : {
				required : true
			},
			contactName : {
				required : true
			},
			contactTel : {
				required : true
			},
			detail : {
				required : true
			}
		},
		messages : {
			name : {
				required : '<font color="red">必填</font>'
			},
			contactName : {
				required : '<font color="red">必填</font>'
			},
			contactTel : {
				required : '<font color="red">必填</font>'
			},
			detail : {
				required : '<font color="red">必填</font>'
			}

		}
	}).form();
};

function setSelectValue(){
	$("#selectAmount").find("dd").click(function(){
	    $("#amount").val($(this).attr("value"));
	    var domain=$("#domain").val();
		var amount=$("#amount").val();
		if(amount!==""){
			$("#amountCheckResult").html('');
		}
	});
	$("#selectDuration").find("dd").click(function(){
	    $("#duration").val($(this).attr("value"));
	    var duration=$("#duration").val();
		if(duration!==""){
			$("#durationCheckResult").html('');
		}
	});
	$("#selectType").find("dd").click(function(){
	    $("#type").val($(this).attr("value"));
		var type=$("#type").val();
		if(type!==""){
			$("#typeCheckResult").html('');
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
		formId:'techRequirementFrom',
		timeout : 100000,
		secureuri : false, //一般设置为false
		dataType : 'json', //返回值类型 一般设置为json
		success : function(datas){
			if(datas.status===0){
//				$('#Button1').click();
				$('#altstwo').show();
				setTimeout(function(){//5秒后隐藏
//					CloseDiv('MyDiv','fade');
					$('#altstwo').hide();
					var myRequireUrl = $('#myRequireUrl').attr('url');
					location.href=myRequireUrl;
				}, 1500);
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

function getDetail(id) {
    //表单验证通过
	var url = $('#getDetailUrl').attr('detailUrl');
	var detailParam={};
	detailParam['id']=id;//$("#commonTechRequirementId").val();
	FrontCommonFunction.baseOptions['url'] = url;
	FrontCommonFunction.baseOptions['data'] = detailParam;
	FrontCommonFunction.baseOptions['success'] = function(datas) {
		$('#name').val(datas.name);
		$('#contactName').val(datas.contactName);
		$('#contactTel').val(datas.contactTel);
		$('#contactEmail').val(datas.contactEmail);
		$('#domain').val(datas.domain);
		$("#showDomain").val(FrontCommonFunction.setInvestorDomain(datas.domain));
		$('#amount').val(datas.amount);
		$('#showAmount').val(FrontCommonFunction.setStrAmount(datas.amount));

		$('#duration').val(datas.duration);
		$('#showDuration').val(FrontCommonFunction.setDuration(datas.duration));
		$('#type').val(datas.type);
		$('#showType').val(FrontCommonFunction.setInbestorType(datas.type));
		$('#detail').val(datas.detail);
		$('#similarProduct').val(datas.similarProduct);
		$('#filePath').val(datas.attachUrl);
		if(datas.attachName) {
			$('#fileTypeCheckResult').html('已上传文件:'+datas.attachName);
		}
		//合作方式
		var cooperType=datas.cooperationType;
		$('#cooperationTypeId').val(cooperType);
		var arr=new Array();
		arr=cooperType.split(",");
		for(var i=0;i<arr.length;i++){
			if(arr[i]==="0"){
				$("#cooperationTypeCheckBox0").click();
			}else if(arr[i]==="1"){
				$("#cooperationTypeCheckBox1").click();
			}else if(arr[i]==="2"){
				$("#cooperationTypeCheckBox2").click();
			}else if(arr[i]==="3"){
				$("#cooperationTypeCheckBox3").click();
			}else if(arr[i]==="4"){
				$("#cooperationTypeCheckBox4").click();
			}else if(arr[i]==="5"){
				$("#cooperationTypeCheckBox5").click();
			}
		}
	};
	$.ajax(FrontCommonFunction.baseOptions);
};


function getData() {
	var paramTemp = {};
	var companyUser = {};
	companyUser['id']=$("#commonCompanyUserId").val();;
	var updateId=$("#updateId").val();
	if(updateId!=="" && updateId!==undefined && updateId!=="undefined"){
		paramTemp['id']=updateId;
	}
	paramTemp['companyUser']=companyUser;
	paramTemp['name']=$.trim($('#name').val());
	paramTemp['contactName']=$.trim($('#contactName').val());
	paramTemp['contactTel']=$.trim($('#contactTel').val());
	paramTemp['contactEmail']=$.trim($('#contactEmail').val());
	paramTemp['domain']=$.trim($('#domain').val());
	paramTemp['amount']=$.trim($('#amount').val());
	paramTemp['duration']=$.trim($('#duration').val());
	paramTemp['type']=$.trim($('#type').val());
	paramTemp['cooperationType']=$.trim($('#cooperationTypeId').val());
	paramTemp['detail']=$('#detail').val();
	paramTemp['similarProduct']=$('#similarProduct').val();
	paramTemp['attachUrl']=$('#filePath').val();
	return paramTemp;
};
