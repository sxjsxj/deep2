$(document).ready(function() {
	initAboutUs();
	var registAgreement=$("#registAgreement").val();
	if(registAgreement!=""){
		$('#navAgreement').addClass("active");
    	$("#divAgreement").show();
    	$('#navAboutUs').removeClass("active");
		$('#navCallUs').removeClass("active");
		$('#navJoin').removeClass("active");
		$('#navExplian').removeClass("active");
		
		$("#divAboutUs").hide(); 
		$("#divJoin").hide();
		$("#divExplian").hide();
		$("#divCallUs").hide();
	}
	
	
	var callUs=$("#callUs").val();
	if(callUs!=""){
		$('#navCallUs').addClass("active");
    	$("#divCallUs").show();
    	$('#navAboutUs').removeClass("active");
		$('#navJoin').removeClass("active");
		$('#navExplian').removeClass("active");
		$('#navAgreement').removeClass("active");
		
		$("#divAboutUs").hide(); 
		$("#divExplian").hide();
		$("#divAgreement").hide();
		$("#divJoin").hide();
		
	}
	
	var infoPublish=$("#infoPublish").val();
    if(infoPublish!=""){
    	$('#navJoin').addClass("active");
    	$("#divJoin").show();
    	$('#navAboutUs').removeClass("active");
		$('#navCallUs').removeClass("active");
		$('#navExplian').removeClass("active");
		$('#navAgreement').removeClass("active");
		
		$("#divAboutUs").hide(); 
		$("#divExplian").hide();
		$("#divAgreement").hide();
		$("#divCallUs").hide();
		
	}
	
	
});
function initAboutUs() {
	
	$("#divAboutUs").show(); 
	$("#divExplian").hide();
	$("#divAgreement").hide();
	$("#divJoin").hide();
	$("#divCallUs").hide();
	
	$('#navAboutUs').click(function() {
		$('#navAboutUs').addClass("active");
		$("#divAboutUs").show(); 
		$('#navCallUs').removeClass("active");
		$('#navJoin').removeClass("active");
		$('#navExplian').removeClass("active");
		$('#navAgreement').removeClass("active");
		
		$("#divExplian").hide();
		$("#divAgreement").hide();
		$("#divJoin").hide();
		$("#divCallUs").hide();
    });
	
    $('#navCallUs').click(function() {
    	$('#navCallUs').addClass("active");
    	$("#divCallUs").show();
    	$('#navAboutUs').removeClass("active");
		$('#navJoin').removeClass("active");
		$('#navExplian').removeClass("active");
		$('#navAgreement').removeClass("active");
		
		$("#divAboutUs").hide(); 
		$("#divExplian").hide();
		$("#divAgreement").hide();
		$("#divJoin").hide();
    });
    
    $('#navJoin').click(function() {
    	$('#navJoin').addClass("active");
    	$("#divJoin").show();
    	$('#navAboutUs').removeClass("active");
		$('#navCallUs').removeClass("active");
		$('#navExplian').removeClass("active");
		$('#navAgreement').removeClass("active");
		
		$("#divAboutUs").hide(); 
		$("#divExplian").hide();
		$("#divAgreement").hide();
		$("#divCallUs").hide();
    	
    });
    
    $('#navExplian').click(function() {
    	$('#navExplian').addClass("active");
    	$("#divExplian").show();
    	$('#navAboutUs').removeClass("active");
		$('#navCallUs').removeClass("active");
		$('#navJoin').removeClass("active");
		$('#navAgreement').removeClass("active");
		
		$("#divAboutUs").hide(); 
		$("#divJoin").hide();
		$("#divAgreement").hide();
		$("#divCallUs").hide();
    });
    
    $('#navAgreement').click(function() {
    	
    	$('#navAgreement').addClass("active");
    	$("#divAgreement").show();
    	$('#navAboutUs').removeClass("active");
		$('#navCallUs').removeClass("active");
		$('#navJoin').removeClass("active");
		$('#navExplian').removeClass("active");
		
		$("#divAboutUs").hide(); 
		$("#divJoin").hide();
		$("#divExplian").hide();
		$("#divCallUs").hide();
    });
	
};




