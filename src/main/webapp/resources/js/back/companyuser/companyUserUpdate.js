$(document).ready(function() {
	CommonFunction.initBaseResearchField("#compareUserDetailDomain");
	var urlInfo=decodeURI(window.location.search);
	var id=urlInfo.substring(urlInfo.indexOf("=")+1);
	$("#updateButn").click(function() {
		editCompanyUser();
    });
	if(id!==""&&id!==null){
		getCompanyUserDetail(id);
	}
});
var queryParam = {};

function editCompanyUser(){
	if($("#updateNature").val()===""){
		alert("请选择公司性质");
		return false;
	}
	if($("#compareUserDetailDomain").val()===""){
		alert("请选择行业");
		return;
	}
	if($("#updateScale").val()===""){
		alert("请选择规模");
		return;
	}
	if($("#updateProductValue").val()===""){
		alert("请选择产值");
		return;
	}
	
	if($("#updateProvince").val()===""){
		alert("请选择省份");
		return;
	}
	if($("#updateCity").val()===""){
		alert("请选择所在市");
		return;
	}
	
	if($("#updateCounty").val()===""){
		alert("请选择所在县");
		return;
	}
	var validate=$("#updateCompanyUserFrom").validate({
		rules:{
			name:{
				required:true
			},
			address:{
				required:true
			},
			contactTitle:{
				required:true
			},
			contactName:{
				required:true
			},
			contactTel:{
				required:true
			},
			introduction:{
				required:true
			}
		},
		messages:{
			name:{
				required:"<font color='red'>必填</font>"
			},
			address:{
				required:"<font color='red'>必填</font>"
			},
			contactTitle:{
				required:"<font color='red'>必填</font>"
			},
			contactName:{
				required:"<font color='red'>必填</font>"
			},
			contactTel:{
				required:"<font color='red'>必填</font>"
			},
			introduction:{
				required:"<font color='red'>必填</font>"
			}
			
		}
	});
	if($("#updateCompanyUserFrom").valid()){
	    var param=getData();
	    var reqParam={}
	    var url = $('#updateButn').attr('url');
	    var jsonStr=JSON.stringify(param);
	    reqParam['str']=jsonStr;
	    CommonFunction.baseOptions['url'] = url;
		CommonFunction.baseOptions['data'] = reqParam;
		CommonFunction.baseOptions['success'] = function(datas) {
			if(datas.status===0){
				window.open('companyUserInfoList.html');
			}
		};
		$.ajax(CommonFunction.baseOptions);
	}else{
		return;
	}
};


function getData() {
	var name= $("#updateName").val();//公司名称
	var nature= $("#updateNature").val();
	var domain= $("#compareUserDetailDomain").val();
	var scale = $("#updateScale").val();
	var productValue = $("#updateProductValue").val();
	var province= $("#updateProvince").val();
	var city= $("#updateCity").val();
	var county= $("#updateCounty").val();
	var address= $("#updateAddress").val();
	var contactTitle= $("#updateContactTitle").val();
	var contactName= $("#updateContactName").val();
	var contactTel= $("#updateContactTel").val();
	var introduction= $("#updateIntroduction").val();
	var paramTemp={};
	paramTemp['name']=name;
	paramTemp['nature']=nature;
	paramTemp['domain']=domain;
	paramTemp['productValue']=productValue;
	paramTemp['province']=province;
	paramTemp['city']=city;
	paramTemp['county']=county;
	paramTemp['address']=address;
	paramTemp['contactTitle']=contactTitle;
	paramTemp['contactTel']=contactTel;
	paramTemp['contactName']=contactName;
	paramTemp['introduction']=introduction;
	return paramTemp;
};

function getCompanyUserDetail(id){
	var reqParam={}
    var url = $('#getDetailComanyUserDetail').attr('url');
	reqParam['id']=id;
    CommonFunction.baseOptions['url'] = url;
	CommonFunction.baseOptions['data'] = reqParam;
	CommonFunction.baseOptions['success'] = function(datas) {
		var companyUser=datas;
		$('#updateName').val(companyUser.name);
		
		var natureSelect=$("#updateNature").select2({
		});
		natureSelect.val(companyUser.nature).trigger("change");
		
		var scaleSelect=$("#updateScale").select2({
		});
		scaleSelect.val(companyUser.scale).trigger("change");
		var domainSelect=$("#compareUserDetailDomain").select2({
		});
		domainSelect.val(companyUser.domain).trigger("change");
		var productValueSelect=$("#updateProductValue").select2({
		});
		productValueSelect.val(companyUser.productValue).trigger("change");
		
		var provinceSelect=$("#updateProvince").select2({
		});
		provinceSelect.val(companyUser.province).trigger("change");
		
		var citySelect=$("#updateCity").select2({
		});
		citySelect.val(companyUser.city).trigger("change");
		
		var countySelect=$("#updateCounty").select2({
		});
		countySelect.val(companyUser.county).trigger("change");
		
		$('#updateAddress').val(companyUser.address);
		$('#updateContactTitle').val(companyUser.contactTitle);
		$('#updateContactName').val(companyUser.contactName);
		$('#updateContactTel').val(companyUser.contactTel);
		$('#updateIntroduction').val(companyUser.introduction);
	};
	$.ajax(CommonFunction.baseOptions);
}

function initBasicResearchField(){
	    var reqParam={}
	    var url = $('#searchBasicResearchField').attr('url');
	    CommonFunction.baseOptions['url'] = url;
		CommonFunction.baseOptions['data'] = reqParam;
		CommonFunction.baseOptions['success'] = function(datas) {
			var basicRearchFieldList=datas;
			var domainShow = '';
			for(var i = 0; i < basicRearchFieldList.length; i++) {	
				idIndex="domain"+i
				domainShow+='<input type="checkbox"  name="domain" class="domain" id='+idIndex+' value="'+basicRearchFieldList[i].name+'"  style="width:12px"/>'
				+basicRearchFieldList[i].name+'';
			}
			$("#domainDiv").append(domainShow);
		};
		$.ajax(CommonFunction.baseOptions);
}

