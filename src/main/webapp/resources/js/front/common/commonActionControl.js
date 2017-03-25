$(function() {
	$(".more").click(function(){
		if(!FrontCommonFunction.isLogin()){
			$('#nologin').show();
			setTimeout(function(){//5秒后隐藏
				$('#nologin').hide();
			}, 1500);
		}else{
			if($(this).hasClass('on')){
				$(this).removeClass("on");
				$("#mores").slideUp(100);
				$(this).text('查看更多信息>>');
			}else{
				$(this).addClass("on");
				$(this).text('收起');
				$("#mores").slideDown(100);
			}
		}
	});
});

	function setMultiCooperationType(dataObj){
		var result = '';
		if(dataObj === null || dataObj === 'null'||dataObj === undefined){
			result = '';
		} else {
			var datas = dataObj.split(',');
			for(var i = 0; i <datas.length; i++) {
				result = result + ' ' + FrontCommonFunction.setCooperationType(datas[i]);
			}
		}
		return result;
	};
	function setMultiAchievementType(dataObj){
		var result = '';
		if(dataObj === null || dataObj === 'null'||dataObj === undefined){
			result = '';
		} else {
			var datas = dataObj.split(',');
			for(var i = 0; i <datas.length; i++) {
				result = result + ' ' + FrontCommonFunction.setAchievementType(datas[i]);
			}
		}
		return result;
	};

/**
 * 分享控件控制
 * @param moreType 详情类型
 * @param status  审批状态
 * @param selector 控件选择器
 */
function shareControl(moreType, status, selector) {
	if(moreType == 'researchGroup') {
		if(status == '0' || status == '2'){
			$(selector).hide();
		}
	}
	if(moreType == 'achievement') {
		if(status == '0' || status == '5'){
			$(selector).hide();
		}
	}
	if(moreType == 'techRequirement') {
		if(status == '0' || status == '5'){
			$(selector).hide();
		}
	}
	if(moreType == 'fundRequirement') {
		if(status == '0' || status == '5'){
			$(selector).hide();
		}
	}
	if(moreType == 'investorUser') {
		if(status == '0' || status == '2'){
			$(selector).hide();
		}
	}

}

function dialogControl() {
	$('#altstwo').hide();
	$('#altsthree').hide();
	$('#nologin').hide();
	$('.img2').click(function(){
		$('#nologin').hide();
		$('#altsthree').hide();
		$('#altstwo').hide();
	});
	$('#alertClick').click(function(){
	});
	//弹框start
	$('.registSuccess').click(function(){
		$('#altsthree').show();
	});
	//寻求合作start
	$(".altsbg").hide();
	$('.close').click(function(){
		$(".altsubmit").hide();
	});
	$('.anniu_cancel-btn').click(function(){
		$(".altsbg").hide();
	});
};

function delShaDowClass(index){
	$("#shaDowShow"+index).removeClass("mydiv2");
	$("#shaDowShow"+index).addClass("mydiv1");
};

function addShaDowClass(index){
	$("#shaDowShow"+index).removeClass("mydiv1");
	$("#shaDowShow"+index).addClass("mydiv2");
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

function setRegionClick(){
	//只查看本省市
	$("#onlySeeLocalCity").click(function(){
		if(!FrontCommonFunction.isLogin()){
			$('#nologin').show();
			$("#onlySeeLocalCity").removeClass("on");
			setTimeout(function(){//5秒后隐藏
				$('#nologin').hide();
			}, 1500);
		}else{
			if($("#onlySeeLocalCity").hasClass("on")){
				$("#region").show();
			}else{
				$("#region").hide();
			}
		}
	});
	//热门地区
	$("#remenParent").click(function() {
		if($("#remenParentShow").hasClass("on")){
			$("[id^=remenChild]").each(function(n){
				//remenChild固定长度是10
				 var idIndex=$(this).attr("id").substring(10);
				 if($("#remenChildValue"+idIndex).hasClass("on")){
					 $(this).click();
				 }
			 });
			 $("[id^=remenChildValue]").removeClass("on");
		}else{
			 $("[id^=remenChild]").each(function(n){
				//remenChild固定长度是10
				 var idIndex=$(this).attr("id").substring(10);
				 if(!$("#remenChildValue"+idIndex).hasClass("on")){
					 $(this).click();
				 }
			 });
			 $("[id^=remenChildValue]").attr("class","on");
		}
		text = $("[id^=remenChildValue]input[class=on]").map(function(index,elem) {
			return $(elem).val();
		}).get().join(',');
		$("#renmenCheckboxResult").val(text);
	});

	$("[id^=remenChild]").click(function() {
		//remenChild固定长度是10
		var idIndex=$(this).attr("id").substring(10);
		//固定属性：domainCheckBoxValue
		if($("#remenChildValue"+idIndex).hasClass("on")){
			 $("#remenChildValue"+idIndex).removeClass("on");
		}else{
			 $("#remenChildValue"+idIndex).attr("class","on");
		}
		text = $("[id^=remenChildValue]input[class=on]").map(function(index,elem) {
			return $(elem).val();
		}).get().join(',');
		$("#renmenCheckboxResult").val(text);
	});
	//华南地区
	$("#huananParent").click(function() {
		if($("#huananParentShow").hasClass("on")){
			$("[id^=huananChild]").each(function(n){
				//huananChild固定长度是11
				var idIndex=$(this).attr("id").substring(11);
				 if($("#huananChildValue"+idIndex).hasClass("on")){
					 $(this).click();
				 }
			 });
			 $("[id^=huananChildValue]").removeClass("on");
		}else{
			 $("[id^=huananChild]").each(function(n){
				//huananChild固定长度是11
					var idIndex=$(this).attr("id").substring(11);
					 if(!$("#huananChildValue"+idIndex).hasClass("on")){
						 $(this).click();
					 }
			 });
			 $("[id^=huananChildValue]").attr("class","on");
		}
		text = $("[id^=huananChildValue]input[class=on]").map(function(index,elem) {
			return $(elem).val();
		}).get().join(',');
		$("#huananCheckboxResult").val(text);
	});

	$("[id^=huananChild]").click(function() {
		//huananChild固定长度是11
		var idIndex=$(this).attr("id").substring(11);
		if($("#huananChildValue"+idIndex).hasClass("on")){
			 $("#huananChildValue"+idIndex).removeClass("on");
		}else{
			 $("#huananChildValue"+idIndex).attr("class","on");
		}
		text = $("[id^=huananChildValue]input[class=on]").map(function(index,elem) {
			return $(elem).val();
		}).get().join(',');
		$("#huananCheckboxResult").val(text);
	});
	//华北
	$("#huabeiParent").click(function() {
		if($("#huabeiParentShow").hasClass("on")){
			$("[id^=huabeiChild]").each(function(n){
				//huabeiChild固定长度是11
				var idIndex=$(this).attr("id").substring(11);
				 if($("#huabeiChildValue"+idIndex).hasClass("on")){
					 $(this).click();
				 }
			 });
			 $("[id^=huabeiChildValue]").removeClass("on");
		}else{
			 $("[id^=huabeiChild]").each(function(n){
				//huabeiChild固定长度是11
					var idIndex=$(this).attr("id").substring(11);
					 if(!$("#huabeiChildValue"+idIndex).hasClass("on")){
						 $(this).click();
					 }
			 });
			 $("[id^=huabeiChildValue]").attr("class","on");
		}
		text = $("[id^=huabeiChildValue]input[class=on]").map(function(index,elem) {
			return $(elem).val();
		}).get().join(',');
		$("#huabeiCheckboxResult").val(text);
	});
	$("[id^=huabeiChild]").click(function() {
		//huabeiChild固定长度是11
		var idIndex=$(this).attr("id").substring(11);
		if($("#huabeiChildValue"+idIndex).hasClass("on")){
			 $("#huabeiChildValue"+idIndex).removeClass("on");
		}else{
			 $("#huabeiChildValue"+idIndex).attr("class","on");
		}
		text = $("[id^=huabeiChildValue]input[class=on]").map(function(index,elem) {
			return $(elem).val();
		}).get().join(',');
		$("#huabeiCheckboxResult").val(text);
	});
	//华东
	$("#huadongParent").click(function() {
		if($("#huadongParentShow").hasClass("on")){
			$("[id^=huadongChild]").each(function(n){
				//huadongChild固定长度是12
				var idIndex=$(this).attr("id").substring(12);
				 if($("#huadongChildValue"+idIndex).hasClass("on")){
					 $(this).click();
				 }
			 });
			 $("[id^=huadongChildValue]").removeClass("on");
		}else{
			 $("[id^=huadongChild]").each(function(n){
				//huadongChild固定长度是12
					var idIndex=$(this).attr("id").substring(12);
					 if(!$("#huadongChildValue"+idIndex).hasClass("on")){
						 $(this).click();
					 }
			 });
			 $("[id^=huadongChildValue]").attr("class","on");
		}
		text = $("[id^=huadongChildValue]input[class=on]").map(function(index,elem) {
			return $(elem).val();
		}).get().join(',');
		$("#huadongCheckboxResult").val(text);
	});

	$("[id^=huadongChild]").click(function() {
		//huadongChild固定长度是12
		var idIndex=$(this).attr("id").substring(12);
		if($("#huadongChildValue"+idIndex).hasClass("on")){
			 $("#huadongChildValue"+idIndex).removeClass("on");
		}else{
			 $("#huadongChildValue"+idIndex).attr("class","on");
		}
		text = $("[id^=huadongChildValue]input[class=on]").map(function(index,elem) {
			return $(elem).val();
		}).get().join(',');
		$("#huadongCheckboxResult").val(text);
	});
	//华中
	$("#huazhongParent").click(function() {
		if($("#huazhongParentShow").hasClass("on")){
			$("[id^=huazhongChild]").each(function(n){
				//huazhongChild固定长度是13
				var idIndex=$(this).attr("id").substring(13);
				 if($("#huazhongChildValue"+idIndex).hasClass("on")){
					 $(this).click();
				 }
			 });
			 $("[id^=huazhongChildValue]").removeClass("on");
		}else{
			 $("[id^=huazhongChild]").each(function(n){
				//huazhongChild固定长度是13
					var idIndex=$(this).attr("id").substring(13);
					 if(!$("#huazhongChildValue"+idIndex).hasClass("on")){
						 $(this).click();
					 }
			 });
			 $("[id^=huazhongChildValue]").attr("class","on");
		}
		text = $("[id^=huazhongChildValue]input[class=on]").map(function(index,elem) {
			return $(elem).val();
		}).get().join(',');
		$("#huazhongCheckboxResult").val(text);
	});

	$("[id^=huazhongChild]").click(function() {
		//huazhongChild固定长度是13
		var idIndex=$(this).attr("id").substring(13);
		if($("#huazhongChildValue"+idIndex).hasClass("on")){
			 $("#huazhongChildValue"+idIndex).removeClass("on");
		}else{
			 $("#huazhongChildValue"+idIndex).attr("class","on");
		}
		text = $("[id^=huazhongChildValue]input[class=on]").map(function(index,elem) {
			return $(elem).val();
		}).get().join(',');
		$("#huazhongCheckboxResult").val(text);
	});
	//西北
	$("#xibeiParent").click(function() {
		if($("#xibeiParentShow").hasClass("on")){
			$("[id^=xibeiChild]").each(function(n){
				//xibeiChild固定长度是10
				var idIndex=$(this).attr("id").substring(10);
				 if($("#xibeiChildValue"+idIndex).hasClass("on")){
					 $(this).click();
				 }
			 });
			 $("[id^=xibeiChildValue]").removeClass("on");
		}else{
			 $("[id^=xibeiChild]").each(function(n){
				//xibeiChild固定长度是10
					var idIndex=$(this).attr("id").substring(10);
					 if(!$("#xibeiChildValue"+idIndex).hasClass("on")){
						 $(this).click();
					 }
			 });
			 $("[id^=xibeiChildValue]").attr("class","on");
		}
		text = $("[id^=xibeiChildValue]input[class=on]").map(function(index,elem) {
			return $(elem).val();
		}).get().join(',');
		$("#xibeiCheckboxResult").val(text);
	});

	$("[id^=xibeiChild]").click(function() {
		//xibeiChild固定长度是10
		var idIndex=$(this).attr("id").substring(10);
		if($("#xibeiChildValue"+idIndex).hasClass("on")){
			 $("#xibeiChildValue"+idIndex).removeClass("on");
		}else{
			 $("#xibeiChildValue"+idIndex).attr("class","on");
		}
		text = $("[id^=xibeiChildValue]input[class=on]").map(function(index,elem) {
			return $(elem).val();
		}).get().join(',');
		$("#xibeiCheckboxResult").val(text);
	});
	//东北
	$("#dongbeiParent").click(function() {
		if($("#dongbeiParentShow").hasClass("on")){
			$("[id^=dongbeiChild]").each(function(n){
				//dongbeiChild固定长度是12
				var idIndex=$(this).attr("id").substring(12);
				 if($("#dongbeiChildValue"+idIndex).hasClass("on")){
					 $(this).click();
				 }
			 });
			 $("[id^=dongbeiChildValue]").removeClass("on");
		}else{
			 $("[id^=dongbeiChild]").each(function(n){
				//dongbeiChild固定长度是12
					var idIndex=$(this).attr("id").substring(12);
					 if(!$("#dongbeiChildValue"+idIndex).hasClass("on")){
						 $(this).click();
					 }
			 });
			 $("[id^=dongbeiChildValue]").attr("class","on");
		}
		text = $("[id^=dongbeiChildValue]input[class=on]").map(function(index,elem) {
			return $(elem).val();
		}).get().join(',');
		$("#dongbeiCheckboxResult").val(text);
	});

	$("[id^=dongbeiChild]").click(function() {
		//dongbeiChild固定长度是12
		var idIndex=$(this).attr("id").substring(12);
		if($("#dongbeiChildValue"+idIndex).hasClass("on")){
			 $("#dongbeiChildValue"+idIndex).removeClass("on");
		}else{
			 $("#dongbeiChildValue"+idIndex).attr("class","on");
		}
		text = $("[id^=dongbeiChildValue]input[class=on]").map(function(index,elem) {
			return $(elem).val();
		}).get().join(',');
		$("#dongbeiCheckboxResult").val(text);
	});
	//西南
	$("#xinanParent").click(function() {
		if($("#xinanParentShow").hasClass("on")){
			$("[id^=xinanChild]").each(function(n){
				//xinanChild固定长度是10
				var idIndex=$(this).attr("id").substring(10);
				 if($("#xinanChildValue"+idIndex).hasClass("on")){
					 $(this).click();
				 }
			 });
			 $("[id^=xinanChildValue]").removeClass("on");
		}else{
			 $("[id^=xinanChild]").each(function(n){
				//xinanChild固定长度是10
					var idIndex=$(this).attr("id").substring(10);
					 if(!$("#xinanChildValue"+idIndex).hasClass("on")){
						 $(this).click();
					 }
			 });
			 $("[id^=xinanChildValue]").attr("class","on");
		}
		text = $("[id^=xinanChildValue]input[class=on]").map(function(index,elem) {
			return $(elem).val();
		}).get().join(',');
		$("#xinanCheckboxResult").val(text);
	});

	$("[id^=xinanChild]").click(function() {
		//xinanChild固定长度是10
		var idIndex=$(this).attr("id").substring(10);
		if($("#xinanChildValue"+idIndex).hasClass("on")){
			 $("#xinanChildValue"+idIndex).removeClass("on");
		}else{
			 $("#xinanChildValue"+idIndex).attr("class","on");
		}
		text = $("[id^=xinanChildValue]input[class=on]").map(function(index,elem) {
			return $(elem).val();
		}).get().join(',');
		$("#xinanCheckboxResult").val(text);
	});
	//港澳台
	$("#gangaotaiParent").click(function() {
		if($("#gangaotaiParentShow").hasClass("on")){
			$("[id^=gangaotaiChild]").each(function(n){
				//gangaotaiChild固定长度是14
				var idIndex=$(this).attr("id").substring(14);
				 if($("#gangaotaiChildValue"+idIndex).hasClass("on")){
					 $(this).click();
				 }
			 });
			 $("[id^=gangaotaiChildValue]").removeClass("on");
		}else{
			 $("[id^=gangaotaiChild]").each(function(n){
				//gangaotaiChild固定长度是14
					var idIndex=$(this).attr("id").substring(14);
					 if(!$("#gangaotaiChildValue"+idIndex).hasClass("on")){
						 $(this).click();
					 }
			 });
			 $("[id^=gangaotaiChildValue]").attr("class","on");
		}
		text = $("[id^=gangaotaiChildValue]input[class=on]").map(function(index,elem) {
			return $(elem).val();
		}).get().join(',');
		$("#gangaotaiCheckboxResult").val(text);
	});

	$("[id^=gangaotaiChild]").click(function() {
		//gangaotaiChild固定长度是14
		var idIndex=$(this).attr("id").substring(14);
		if($("#gangaotaiChildValue"+idIndex).hasClass("on")){
			 $("#gangaotaiChildValue"+idIndex).removeClass("on");
		}else{
			 $("#gangaotaiChildValue"+idIndex).attr("class","on");
		}
		text = $("[id^=gangaotaiChildValue]input[class=on]").map(function(index,elem) {
			return $(elem).val();
		}).get().join(',');
		$("#gangaotaiCheckboxResult").val(text);
	});
	//海外
	$("#haiwaiParent").click(function() {
		if($("#haiwaiParentShow").hasClass("on")){
			$("[id^=haiwaiChild]").each(function(n){
				//haiwaiChild固定长度是11
				var idIndex=$(this).attr("id").substring(11);
				 if($("#haiwaiChildValue"+idIndex).hasClass("on")){
					 $(this).click();
				 }
			 });
			 $("[id^=haiwaiChildValue]").removeClass("on");
		}else{
			 $("[id^=haiwaiChild]").each(function(n){
				//haiwaiChild固定长度是11
					var idIndex=$(this).attr("id").substring(11);
					 if(!$("#haiwaiChildValue"+idIndex).hasClass("on")){
						 $(this).click();
					 }
			 });
			 $("[id^=haiwaiChildValue]").attr("class","on");
		}
		text = $("[id^=haiwaiChildValue]input[class=on]").map(function(index,elem) {
			return $(elem).val();
		}).get().join(',');
		$("#haiwaiCheckboxResult").val(text);
	});

	$("[id^=haiwaiChild]").click(function() {
		//haiwaiChild固定长度是11
		var idIndex=$(this).attr("id").substring(11);
		if($("#haiwaiChildValue"+idIndex).hasClass("on")){
			 $("#haiwaiChildValue"+idIndex).removeClass("on");
		}else{
			 $("#haiwaiChildValue"+idIndex).attr("class","on");
		}
		text = $("[id^=haiwaiChildValue]input[class=on]").map(function(index,elem) {
			return $(elem).val();
		}).get().join(',');
		$("#haiwaiCheckboxResult").val(text);
	});
};
