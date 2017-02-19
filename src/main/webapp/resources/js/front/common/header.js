$(document).ready(function() {
	init();
	var userType=$('#commonUserType').val();
	if(userType!=="" && userType!==null){
		$('#goCenter').show();
	}
	$('#goCenter').click(function() {
		if(userType==="0"){
			var url = $('#companyUserCenter').attr('url');
			location.href=url;
		}else if(userType==="1"){
			var url = $('#researchUserCenter').attr('url');
			location.href=url;
		}else if(userType==="2"){
			var url = $('#investorUserCenter').attr('url');
			location.href=url;
		}
	});
});

function init() {
	$("#headerSelectSearch").find("dd").click(function(){
	    $("#headerSelectCheck").val($(this).attr("value")); 
	});
	//初始化登录状态
	initLoginUser();
	
	//搜索
	$('#headerSerarch').click(function() {
		var searchName =$('#searchName').val();
		var headerSelectCheck =$('#headerSelectCheck').val();
		var url="";
		// 0 科研成果 1 技术需求 2 资金需求 3 科研团队 4投资资金 
		if(headerSelectCheck==="0"){
			url = $('#headerSearchAchievement').attr('url');
		}else if(headerSelectCheck==="1"){
			url = $('#headerSearchTechRequirement').attr('url');
		}else if(headerSelectCheck==="2"){
			url = $('#headerSearchFundRequirement').attr('url');
		}else if(headerSelectCheck==="3"){
			url = $('#headerSearchResearchGroup').attr('url');
		}else if(headerSelectCheck==="4"){
			url = $('#headerSearchInvestorUser').attr('url');
		}
		if(searchName!==""){
			url=url+"?name="+searchName;
		}
		window.open(url);
    });
};

function initLoginUser() {
	var url = $('#currentUser').attr('url');
	FrontCommonFunction.baseOptions['url'] = url;
	FrontCommonFunction.baseOptions['data'] = {};
	FrontCommonFunction.baseOptions['success'] = function(data) {
		if(data !== null) {
			$('#login').hide();
			$('#register').hide();
			$('#currentUser').show();
	                var str=data.email;
			var name="";
			if(str.length>18){
				name=str.substring(0, 14)+"...";
			}else{
				name=str;
			}
			$('#currentUser').html(name);
			//$('#currentUser').html('您好：'+data.email);
			$('#commonUserLoginId').val(data.id);
			$('#commonUserType').val(data.userType);
			$('#commonUserTel').val(data.telno);
			var companys = data.companyUserModels;
			for(var i = 0; i < companys.length; i++) {
				$('#commonCompanyUserId').val(companys[i].id);
				$('#commonMySelfProvince').val(companys[i].province);
				$('#commonMySelfCity').val(companys[i].city);
				$('#commonMySelfDomain').val(companys[i].domain);
			}
			var researches = data.researchUserModels;
			for(var i = 0; i < researches.length; i++) {
				$('#commonResearchUserId').val(researches[i].id);
				$('#commonResearchUserType').val(researches[i].type);
				$('#commonMySelfProvince').val(researches[i].province);
				$('#commonMySelfCity').val(researches[i].city);
			}
			var investors = data.investorUserModels;
			for(var i = 0; i < investors.length; i++) {
				$('#commonInvestorUserId').val(investors[i].id);
				$('#commonInvestorUserType').val(investors[i].type);
				$('#investorDomain').val(investors[i].investDomain);
				$('#investorAmount').val(investors[i].investAmount);
				$('#investorPhase').val(investors[i].investPhase);
				$('#investorProvince').val(investors[i].province);
				$('#commonMySelfProvince').val(investors[i].province);
				$('#commonMySelfCity').val(investors[i].city);
				$('#investorCity').val(investors[i].city);
			}
			$('#logout').show();
		}
	};
	$.ajax(FrontCommonFunction.baseOptions);
};