/* 定义项目中的公共方法 */
var provinceCity="";
var cityCounty="";
var CommonFunction = {
	tempProvinceCity:function(){
		return provinceCity;
	},
	tempCityCounty:function(){
	  return cityCounty;
	},
	formSerializeObj: function(formId){
		var arr = $('#' + formId).serializeArray();
		var result = {};
		for ( var i = 0; i < arr.length; i++) {
			result[arr[i].name] = arr[i].value;
		}
		return result;
	},
	reQuery:function(datas, checkedSelector, querySelector) {
		if (datas.status === 0) {
			$(querySelector).trigger('click');
		}
	},
	// 以下函数都是页面的初始化函数，在页面的初始化中必须包括这几个函数
	/*若有mode='upper'的属性，则将输入值都转换成大写 */
	toUpperCase : function() {
		$("[mode='upper']").each(function() {
			$(this).bind("keyup", function(e) {
				$(this).val($(this).val().toUpperCase());
			});
		});
	},
	/* 在页面中安装时间控件，当元素带有属性mode^='date'时，需要安装时间控件 */
	installCalendar : function() {
		$("[class*='date-pick']").each(function(){
			$(this).datepicker({ dateFormat: 'yy-mm-dd' });
		});

	},
	processResult:function(actionCode,datas,returnInfoModal,returnInfo) {
		var status = datas.status;
		if (status === 0) {
			getWord(actionCode, status,datas.infoList, '',returnInfoModal,returnInfo);
		}
		if (status === 1) {
			getWord(actionCode, status, datas.warningList, datas.infoList,returnInfoModal,returnInfo);
		}
		if (status === 2) {
			getWord(actionCode, status, datas.warningList, datas.errorList,returnInfoModal,returnInfo);
		}
	},
	/**
	 * 下拉列表形式(初始化省份)
	 */
	initSelectProvince:function(id) {
		var url = $(id).attr('url');
		var param = {};
		this.baseOptions['url'] = url;
		this.baseOptions['data'] = param;
		this.baseOptions['success'] = function(datas) {
			var obj=eval(datas);
			provinceCity=obj;
			var dd = '<option value=" " selecetd="selected">请选择省份</option>';
			$.each(obj,function(n,value){
				dd += '<option value="'+n+'">' + n + '</option>';
			})
			$(id).append(dd);
		};
		$.ajax(this.baseOptions);
	},
	/**
	 * 下拉列表形式(初始化市)
	 */
	initSelectCity:function(id) {
		var url = $(id).attr('url');
		var param = {};
		this.baseOptions['url'] = url;
		this.baseOptions['data'] = param;
		this.baseOptions['success'] = function(datas) {
			var obj=eval(datas);
			cityCounty=obj;
		};
		$.ajax(this.baseOptions);
	},
	/**
	 * 初始化行业领域 alibaba_basic_research_field
	 */
	initBaseResearchField:function(id) {
		var url = $(id).attr('url');
		var param = {};
		this.baseOptions['url'] = url;
		this.baseOptions['data'] = param;
		this.baseOptions['success'] = function(datas) {
			var queryReturnList = datas;
			var option = '<option value="">请选择行业</option>';
			for(var i = 0; i < queryReturnList.length; i++) {
				option += '<option value="'+i+'">' + queryReturnList[i].name + '</option>';
			}
			$(id).append(option);
		};
		$.ajax(this.baseOptions);
	},

	/**
	 * 初始化行业复选框领域
	 */
	initBaseResearchFieldCheckBox:function(id) {
		var url = $(id).attr('url');
		var param = {};
		this.baseOptions['url'] = url;
		this.baseOptions['data'] = param;
		this.baseOptions['success'] = function(datas) {
			var queryReturnList = datas;
			var option = ''
				for(var i = 0; i < queryReturnList.length; i++) {
					if(i ==0){
						option += '<div id="domainCheckBox"+'+i+' class="checkbox-inline"><label>'
						option += '<input type="checkbox" name="domaincheckbox[]" value="+'+i+'+" data-bv-message="请至少选择一种投资领域" />'+queryReturnList[i].name
						+'</label></div>'
					}else{
						option += '<div id="domainCheckBox"+'+i+' class="checkbox-inline"><label>'
						option += '<input type="checkbox" name="domaincheckbox[]" value="+'+i+'+"/>'+queryReturnList[i].name
						+'</label></div>'
					}
			}
			$(id).append(option);
		};
		$.ajax(this.baseOptions);
	},
	/**
	 * 初始化basic_province_area省市基础表复选框领域
	 */
	initBaseProvinceAreaCheckBox:function(id) {
		var url = $(id).attr('url');
		var param = {};
		this.baseOptions['url'] = url;
		this.baseOptions['data'] = param;
		this.baseOptions['success'] = function(datas) {
			var queryReturnList = datas;
			var option ='';
			for(var i = 0; i < queryReturnList.length; i++){
				var list=queryReturnList[i];
				var areaDesc='';
				for(var j = 0; j < list.length; j++) {
					areaDesc=list[j].areaDec;
					option += '<div class="checkbox-inline"><label>'
					option += '<input type="checkbox" name="basicProvinceAreaCheckbox[]" value="+'+i+j+'+" />'+list[j].province
					+'</label></div>'
				}
				option='<input type="checkbox">'+areaDesc+option+'</br>';
			}
			$(id).append(option);
		};
		$.ajax(this.baseOptions);
	},
	/* 对于页面上面的form进行reset */
	resetForm : function(formId) {
		// clear all input for new add operation
		var formIdSelector = '';
		if (formId.indexOf('#') >= 0) {
			formIdSelector = formId;
		} else {
			formIdSelector = '#' + formId;
		}
		$(formIdSelector).find('input[resetable!="no"]:text').each(function() {
			$(this).val("");
		});
		$(formIdSelector).find('input[resetable!="no"]:checkbox').each(function() {
			$(this).attr("checked", false);
		});
		$(formIdSelector).find('input[resetable!="no"]:radio').each(function() {
			$(this).attr("checked", false);
		});
		$(formIdSelector).find('select').each(function() {
			$(this).get(0).options[0].selected = true;
			$(this).trigger("change");
		});
		$(formIdSelector).find('textarea').each(function() {
			$(this).attr("value", '');
		});
	},
	closeSubtables : function(formId) {
		$('#' + formId).find('img').each(function() {
			$(this).click();
		});
	},
	selectOptTitle : function() {
		$('select').each(function() {
			$(this).find('option').each(function() {
				$(this).attr('title', this.innerHTML);
			});
		});
	},
	inputReadOnly : function() {
		$('input[readonly="readonly"]:text').each(function() {
			if ($(this).attr('class')) {
				$(this).attr('class', $(this).attr('class') + ' disabledinput');
			} else {
				$(this).attr('class', 'disabledinput');
			}
		});
	},

	/* 保存form中的input的value值 */
	formValue : function(formId) {
		var result = [];
		$('#' + formId).find('input').each(function() {
			result.push($(this).val());
		});
		$('#' + formId).find('select').each(function() {
			result.push($(this).val());
		});
		return result;
	},

	hiddenDiv : function(clickId, hiddenId, showId) {
		$('#' + clickId).live('click', function() {
			$(this).hide();
			$('#' + hiddenId).hide();
			$('#' + showId).show();
		});
	},
	showDiv : function(clickId, showId, hiddenId) {
		$('#' + clickId).live('click', function() {
			$(this).hide();
			$('#' + showId).show();
			$('#' + hiddenId).show();
		});
	},
	/* 根据指定的id和传入的字符串，选中select中的option选项 */
	selectOption : function(id, src) {
		$('#' + id).find('option').each(function() {
			if ($(this).val() == src) {
				$(this).attr('selected', true);
			}
		});
	},
	//为了方便json的ajax请求，使用baseOptions对象
	baseOptions:{
		'type' : 'POST',
		'dataType' : 'json',
		'contentType' : 'application/x-www-form-urlencoded; charset=UTF-8',
		'timeout' : 100000,
		'async' : false,
		'error' : function(xmlHttpRequest, status, error) {
			var reponseText = xmlHttpRequest.responseText;
			if (reponseText !== null && reponseText.indexOf('SESSION_TIME_OUT_FAIL') > 0) {
				$.showTuiErrorDialog('会话超时，请重新登录！', function() {
					location.href = $('#exit').attr('href');
				});
			} else {
				$.showTuiErrorDialog('发生通讯错误！');
			}
		}
	 },
	 getDate:function(date) {
			if(date===null || date === 'null' || date === undefined || date ==="undefined"){
				return '';
			}else{
				var yxday = new Date(date);
				var month = yxday.getMonth() < 9 ? '0'
						+ (yxday.getMonth() + 1).toString() : (yxday.getMonth() + 1)
						.toString();
				var day = yxday.getDate() < 10 ? '0' + yxday.getDate().toString()
						: yxday.getDate().toString();

				return yxday.getFullYear().toString() + '-' + month + '-' + day;
			}
		},
	 ////获取前台文本框字节数 参数 '#id' 及限制字节数
	 getTextLenth:function(id){
			var maxlenth= parseInt($(id).attr('maxlength'));
			//得到输入的字节数
		     var inputNum = $(id).val().replace(/[^\x00-\xff]/g, "**").length; //得到输入的字节数;
		     var text=$(id).val();
		     //取得被*替换掉的字符串
		     var replaceText=$(id).val().replace(/[^\x00-\xff]/g, "**");
		     var maxStr=replaceText.substring(0,maxlenth);
		     var k=0,sum=0;//sum为在允许输入最多字符里替换中文后*的个数
		     k=maxStr.indexOf("*");
		     while(k>-1){
		         sum+=1;
		         k=maxStr.indexOf("*",k+1);
		     }
		     //允许范围内输入的中文个数
		     var chineseLength=parseInt(sum)/2;
			 if (inputNum > maxlenth) {
			    //除去中文外还能输入的字节数
			    var nextLenth=maxlenth-chineseLength*2;
			    $(id).val(text.substring(0, chineseLength+nextLenth));
		     }
	},
	// 及时提示前台 还能输入多少字符 获取前台文本框字节数 参数 '#id' 及限制字节数
	getInfoTextLenth:function(id,titleInputedWord,titleInputingWord){
		var maxlenth= parseInt($(id).attr('maxlength'));
		//得到输入的字节数
	     var inputNum = $(id).val().replace(/[^\x00-\xff]/g, "**").length; //得到输入的字节数;
	     var text=$(id).val();
		 if (inputNum <= maxlenth) {
			  $(titleInputedWord).html(inputNum + "字节");
			  $(titleInputingWord).html((maxlenth - inputNum)+ "字母," + (Math.round(((maxlenth -inputNum) / 2) - 0.5)) + "汉字");
		}

		 //取得被*替换掉的字符串
	     var replaceText=$(id).val().replace(/[^\x00-\xff]/g, "**");
	     var maxStr=replaceText.substring(0,maxlenth);
	     var k=0,sum=0;//sum为在允许输入最多字符里替换中文后*的个数
	     k=maxStr.indexOf("*");
	     while(k>-1){
	         sum+=1;
	         k=maxStr.indexOf("*",k+1);
	     }
	     //允许范围内输入的中文个数
	     var chineseLength=parseInt(sum)/2;
		 if (inputNum > maxlenth) {
		    //除去中文外还能输入的字节数
		    var nextLenth=maxlenth-chineseLength*2;
		    $(id).val(text.substring(0, chineseLength+nextLenth));
	     }
	},
	trim:function(str) {
		if(str==='null'||str===null) {
			return '';
		} else {
			return str;
		}
	},
	selectOnlyOne:function(tbodySelector) {
		var tBodySelector = '';
		if (tbodySelector.indexOf('#') >= 0) {
			tBodySelector = tbodySelector;
		} else {
			tBodySelector = '#' + tbodySelector;
		}
		$(document).delegate(tBodySelector+' tr', 'click', function(){
			// 该条记录是否已被选中
			var flag = $(this).find('input:checkbox').is(':checked');
			// 如果选中
			if (flag) {
				$(this).removeClass('trbgBlue');
				$(this).addClass('trbgWhite');
				$(this).find('input:checkbox').removeAttr('checked');
			} else {
				$(tBodySelector).find('input:checkbox').removeAttr('checked');
				$(tBodySelector).find('tr').removeClass('trbgBlue');
				$(tBodySelector).find('tr').addClass('trbgWhite');
				$(this).removeClass('trbgWhite');
				$(this).addClass('trbgBlue');
				$(this).find('input:checkbox').each(function() {
					this.checked=true;
				});
			}
		});
	},
	isNull:function(dataObj){
		var result = false;
		if(dataObj === null || dataObj === 'null' || dataObj === undefined || dataObj ==="undefined"){
			result = true;
		} else {
			result = false;
		}
		return result;
	},
	replaceNull:function(dataObj){
		var result = '';
		if(dataObj === null || dataObj === 'null' || dataObj === undefined || dataObj ==="undefined"){
			result = '';
		} else {
			result = dataObj;
		}
		return result;
	},
	getAttach:function(param) {
		var attachUrl = param.attachUrl;
		var attachName = '';
		if(param.attachName) {
			attachName = param.attachName;
		}
		if(!this.isNull(attachUrl)) {
			return '<td>'+ '<a href="'+$('#downFile').attr('url')+'?path='+attachUrl+'">'+attachName+'</a>' +'</td>';
		}else {
			return '<td> </td>';
		}
	},
	setStrDomain:function(dataObj){
		var result = '';
		if(dataObj === null || dataObj === 'null'||dataObj === undefined){
			result = '';
		} else {
			if(dataObj==="0"){
				result = "信息技术";
			 }else if(dataObj==="1"){
				 result = "机械电子";
			 }else if(dataObj=="2"){
				 result = "生物工程";
			 }else if(dataObj=="3"){
				 result = "能源环保";
			 }else if(dataObj=="4"){
				 result = "化学化工";
			 }else if(dataObj=="5"){
				 result = "材料科学";
			 }else{
				 result = '其他';
			 }
		}
		return result;
	},
	setUserType:function(dataObj){
		var result = '';
		if(dataObj === null || dataObj === 'null' || dataObj === undefined || dataObj ==="undefined"){
			result = '';
		} else {
			if(dataObj==="0"){
				result = "企业";
			 }else if(dataObj==="1"){
				 result = "科研机构";
			 }else if(dataObj==="2"){
				 result = "投资方";
			 }else{
				 result ="其他";
			 }
		}
		return result;
	},
	setDeclare:function(uniProject211,uniProject985,uniNationalPriority){
		//0是 1否
		var result = '';
		var uniProject211="";
		var uniProject985="";
		var uniNationalPriority="";
		if(uniProject211 === null || uniProject211 === 'null' || uniProject211 === undefined || uniProject211 ==="undefined"){
			uniProject211 = '';
		}
		if(uniProject985 === null || uniProject985 === 'null' || uniProject985 === undefined || uniProject985 ==="undefined"){
			uniProject985 = '';
		}
		if(uniNationalPriority === null || uniNationalPriority === 'null' || uniNationalPriority === undefined || uniNationalPriority ==="undefined"){
			uniNationalPriority = '';
		}
		if(uniProject211 === '1'){
			uniProject211 = '211高校';
		}
		if(uniProject985 === '1'){
			uniProject985 = '985高校';
		}
		if(uniNationalPriority === '0'){
			uniNationalPriority = '全国重点大学';
		}
		result=uniProject211+uniProject985+uniNationalPriority;
		return result;
	},
	setResearchUserType:function(dataObj){
		var result = '';
		if(dataObj === null || dataObj === 'null' || dataObj === undefined || dataObj ==="undefined"){
			result = '';
		} else {
			if(dataObj==="0"){
				result= "高校";
			 }else if(dataObj==="1"){
				 result= "科研机构";
			 }else if(dataObj==="2"){
				 result= "个人";
			 }
		}
		return result;
	},
	setStatus:function(dataObj){
		var result = '';
		if(dataObj === null || dataObj === 'null' || dataObj === undefined || dataObj ==="undefined"){
			result = '';
		} else {
			if(dataObj==="0"){
				result= "待审核";
			 }else if(dataObj==="1"){
				 result= "审核通过";
			 }else if(dataObj==="2"){
				 result= "拒绝";
			 }else{
				 result= "其他";
			 }
		}
		return result;
	},
	setFollowerType:function(dataObj){
		var result = '';
		if(dataObj === null || dataObj === 'null' || dataObj === undefined || dataObj ==="undefined"){
			result = '';
		} else {
			if(dataObj==="0"){
				result =  "非投资方";
			 }else if(dataObj==="1"){
				 result =  "投资方";
			 }else{
				 result =  "其他";
			 }
		}
		return result;
	},
	setRequirementFollowerType:function(dataObj){
		var result = '';
		if(dataObj === null || dataObj === 'null' || dataObj === undefined || dataObj ==="undefined"){
			result = '';
		} else {
			if(dataObj==="0"){
				 return "高校";
			 }else if(dataObj==="1"){
				 return "科研机构";
			 }else if(dataObj==="2"){
				 return "个人";
			 }else{
				 return "其他";
			 }
		}
		return result;
	},
	setInvestorFollowerType:function(dataObj){
		var result = '';
		if(dataObj === null || dataObj === 'null' || dataObj === undefined || dataObj ==="undefined"){
			result = '';
		} else {
			if(dataObj===0){
				 return "高校/科研机构/其他";
			 }else if(dataObj===1){
				 return "企业";
			 }else{
				 return "其他";
			 }
		}
		return result;
	},
	setStrInvestorFollowerType:function(dataObj){
		var result = '';
		if(dataObj === null || dataObj === 'null' || dataObj === undefined || dataObj ==="undefined"){
			result = '';
		} else {
			if(dataObj==="0"){
				 return "高校/科研机构/其他";
			 }else if(dataObj==="1"){
				 return "企业";
			 }else{
				 return "其他";
			 }
		}
		return result;
	},
	setRelationType:function(dataObj){
		var result = '';
		if(dataObj === null || dataObj === 'null' || dataObj === undefined || dataObj ==="undefined"){
			result = '';
		} else {
			if(dataObj==="0"){
				result =  "寻求合作";
			 }else if(dataObj==="1"){
				 result =  "收藏";
			 }else{
				 result =  "其他";
			 }
		}
		return result;
	},
	setRequirementStatus:function(dataObj){
		var result = '';
		if(dataObj === null || dataObj === 'null' || dataObj === undefined || dataObj ==="undefined"){
			result = '';
		} else {
			if(dataObj==="0"){
				result = "待审核";
			 }else if(dataObj==="1"){
				 result = "";  // 原来征集中
			 }else if(dataObj==="2"){
				 result = "洽谈中";
			 }else if(dataObj==="3"){
				 result = "合作中";
			 }else if(dataObj==="4"){
				 result = "已完成";
			 }else if(dataObj==="5"){
				 result = "已拒绝";
			 }else{
				 result= "其他";
			 }
		}
		return result;
	},
	setCommunicateStatus:function(dataObj){
		var result = '';
		if(dataObj === null || dataObj === 'null' || dataObj === undefined || dataObj ==="undefined"){
			result = '';
		} else {
			 if(dataObj==="0"){
				 result= "待沟通";
			 }else if(dataObj==="1"){
				 result= "已初步沟通";
			 }else if(dataObj==="2"){
				 result= "有合作意向";
			 }else if(dataObj==="3"){
				 result= "一般";
			 }else if(dataObj==="4"){
				 result= "暂无合作意向";
			 }else{
				 result= "其他";
			 }
		}
		return result;
	},
	setLeaderTitle:function(dataObj){
		var result = '';
		if(dataObj === null || dataObj === 'null' || dataObj === undefined || dataObj ==="undefined"){
			result = '';
		} else {
			if(dataObj==="0"){
				result = "院士";
			 }else if(dataObj==="1"){
				 result = "教授高级工程师";
			 }else if(dataObj==="2"){
				 result = "高级工程师";
			 }else if(dataObj==="3"){
				 result = "研究员";
			 }else if(dataObj==="4"){
				 result = "工程师";
			 }else if(dataObj==="5"){
				 result = "教授";
			 }else if(dataObj==="6"){
				 result = "副教授";
			 }else{
				 result = "其他";
			 }
		}
		return result;
	},
	setRemark:function(dataObj){
		var result = '';
		if(dataObj === null || dataObj === 'null' || dataObj === undefined || dataObj ==="undefined"){
			result = '';
		} else {
			result=getResultMaitText(dataObj,15);
		}
		return result;
	},
	setRemoveFlag:function(dataObj){
		var result = '';
		if(dataObj === null || dataObj === 'null' || dataObj === undefined || dataObj ==="undefined"){
			result = '';
		} else {
			if(dataObj === '0') {
				result = '正常';
			}
			if(dataObj === '1') {
				result= '已删除';
			}
		}
		return result;
	},
	setDetail:function(dataObj){
		var result = '';
		if(dataObj === null || dataObj === 'null' || dataObj === undefined || dataObj ==="undefined"){
			result = '';
		} else {
			result=getResultMaitText(dataObj,15);
		}
		return result;
	},
	setScale:function(dataObj){
		var result = '';
		if(dataObj === null || dataObj === 'null' || dataObj === undefined || dataObj ==="undefined"){
			result = '';
		} else {
			if(dataObj==="0"){
				result = "50人以下";
			 }else if(dataObj==="1"){
				 result = "50-100人";
			 }else if(dataObj==="2"){
				 result = "100-500人";
			 }else if(dataObj==="3"){
				 result = "500-1000人";
			 }else if(dataObj==="4"){
				 result = "1000-2000人";
			 }else if(dataObj==="5"){
				 result = "2000-5000人";
			 }else if(dataObj==="6"){
				 result = "5000人以上";
			 }else{
				 result ="其他";
			 }

		}
		return result;
	},
	setAmount:function(dataObj){
		var result = '';
		if(dataObj === null || dataObj === 'null' || dataObj === undefined || dataObj ==="undefined"){
			result = '';
		} else {
			if(dataObj===0){
				result =  "100万以下";
			 }else if(dataObj===1){
				 result =  "100-500万";
			 }else if(dataObj===2){
				 result =  "500万-1000万 ";
			 }else if(dataObj===3){
				 result =  "1000万以上";
			 }else if(dataObj===4){
				 result =  "面议";
			 }else{
				 result =  "其他";
			 }
		}
		return result;
	},
	setStrAmount:function(dataObj){
		var result = '';
		if(dataObj === null || dataObj === 'null' || dataObj === undefined || dataObj ==="undefined"){
			result = '';
		} else {
			if(dataObj==="0"){
				result =  "100万以下";
			 }else if(dataObj==="1"){
				 result =  "100-500万";
			 }else if(dataObj==="2"){
				 result =  "500万-1000万 ";
			 }else if(dataObj==="3"){
				 result =  "1000万以上";
			 }else if(dataObj==="4"){
				 result =  "面议";
			 }else{
				 result =  "其他";
			 }
		}
		return result;
	},
	setPhase:function(dataObj){
		var result = '';
		if(dataObj === null || dataObj === 'null' || dataObj === undefined || dataObj ==="undefined"){
			result = '';
		} else {
			if(dataObj===0){
				result =  "研发阶段";
			 }else if(dataObj===1){
				 result =  "实验室阶段";
			 }else if(dataObj===2){
				 result =  "概念阶段";
			 }else if(dataObj===3){
				 result =  "小批量生产";
			 }else if(dataObj===4){
				 result =  "规模化生产阶段";
			 }else if(dataObj===5){
				 result =  "市场推广阶段";
			 }else{
				 result =  "其他";
			 }
		}
		return result;
	},
	setStrPhase:function(dataObj){
		var result = '';
		if(dataObj === null || dataObj === 'null' || dataObj === undefined || dataObj ==="undefined"){
			result = '';
		} else {
			if(dataObj==="0"){
				result =  "研发阶段";
			 }else if(dataObj==="1"){
				 result =  "实验室阶段";
			 }else if(dataObj==="2"){
				 result =  "概念阶段";
			 }else if(dataObj==="3"){
				 result =  "小批量生产";
			 }else if(dataObj==="4"){
				 result =  "规模化生产阶段";
			 }else if(dataObj==="5"){
				 result =  "市场推广阶段";
			 }else{
				 result =  "其他";
			 }
		}
		return result;
	},
	setDuration:function(dataObj){
		var result = '';
		if(dataObj === null || dataObj === 'null' || dataObj === undefined || dataObj ==="undefined"){
			result = '';
		} else {
			if(dataObj==="0"){
				result = "1个月";
			 }else if(dataObj==="1"){
				 result = "1-3个月";
			 }else if(dataObj==="2"){
				 result = "3-6个月";
			 }else if(dataObj==="3"){
				 result = "6-12个月";
			 }else if(dataObj==="4"){
				 result = "12-24个月";
			 }else{
				 result = "24个月以上";
			 }
		}
		return result;
	},
	setCaseNum:function(dataObj){
		var result = '';
		if(dataObj === null || dataObj === 'null' || dataObj === undefined || dataObj ==="undefined"){
			result = '';
		} else {
			 if(dataObj===0){
				 result = "0家";
			 }else if(dataObj===1){
				 result = "1家";
			 }else if(dataObj===2){
				 result = "2-5家";
			 }else if(dataObj===3){
				 result = "5家以上";
			 }else{
				 result = "其他";
			 }
		}
		return result;
	},
	setType:function(dataObj){
		var result = '';
		if(dataObj === null || dataObj === 'null' || dataObj === undefined || dataObj ==="undefined"){
			result = '';
		} else {
			if(dataObj===0){
				result = "新产品研发";
			 }else if(dataObj===1){
				 result = "产品技术升级";
			 }else if(dataObj==2){
				 result = "技术服务";
			 }else if(dataObj==3){
				 result = '专利';
			 }else{
				 result = '其他';
			 }
		}
		return result;
	},
	setStrType:function(dataObj){
		var result = '';
		if(dataObj === null || dataObj === 'null' || dataObj === undefined || dataObj ==="undefined"){
			result = '';
		} else {
			if(dataObj==="0"){
				result = "新产品研发";
			 }else if(dataObj==="1"){
				 result = "产品技术升级";
			 }else if(dataObj=="2"){
				 result = "技术服务";
			 }else if(dataObj=="3"){
				 result = '专利';
			 }else{
				 result = '其他';
			 }
		}
		return result;
	},
	setPatent:function(dataObj){
		var result = '';
		if(dataObj === null || dataObj === 'null' || dataObj === undefined || dataObj ==="undefined"){
			result = '';
		} else {
			if(dataObj==="0"){
				result =  "已申请";
			 }else if(dataObj==="1"){
				 result =  "已公示";
			 }else if(dataObj==="2"){
				 result =  "已授权";
			 }else{
				 result =  "其他";
			 }
		}
		return result;
	},
	setCooperationType:function(dataObj){
		var result = '';
		if(dataObj === null || dataObj === 'null' || dataObj === undefined || dataObj ==="undefined"){
			result = '';
		} else {
			if(dataObj===0){
				result =  "技术入股";
			 }else if(dataObj===1){
				 result =  "技术转让";
			 }else if(dataObj===2){
				 result =  "技术许可";
			 }else if(dataObj===3){
				 result =  "委托开发";
			 }else if(dataObj===4){
				 result =  "技术服务";
			 }else{
				 result =  "其他";
			 }
		}
		return result;
	},
	setStrCooperationType:function(dataObj){
		var result = '';
		if(dataObj === null || dataObj === 'null' || dataObj === undefined || dataObj ==="undefined"){
			result = '';
		} else {
			if(dataObj==="0"){
				result =  "技术入股";
			 }else if(dataObj==="1"){
				 result =  "技术转让";
			 }else if(dataObj==="2"){
				 result =  "技术许可";
			 }else if(dataObj==="3"){
				 result =  "委托开发";
			 }else if(dataObj==="4"){
				 result =  "技术服务";
			 }else{
				 result =  "其他";
			 }
		}
		return result;
	},
	setInvestType:function(dataObj){
		var result = '';
		if(dataObj === null || dataObj === 'null' || dataObj === undefined || dataObj ==="undefined"){
			result = '';
		} else {

			if(dataObj===0){
				result =  "股权投资";
			 }else if(dataObj===1){
				 result =  "债券投资";
			 }else if(dataObj===2){
				 result =  "金融投资";
			 }else if(dataObj===3){
				 result =  "bt/bot项目投资";
			 }else{
				 result =  "其他投资";
			 }

		}
		return result;
	},
	setStrInvestType:function(dataObj){
		var result = '';
		if(dataObj === null || dataObj === 'null' || dataObj === undefined || dataObj ==="undefined"){
			result = '';
		} else {

			if(dataObj==="0"){
				result =  "股权投资";
			 }else if(dataObj==="1"){
				 result =  "债券投资";
			 }else if(dataObj==="2"){
				 result =  "金融投资";
			 }else if(dataObj==="3"){
				 result =  "bt/bot项目投资";
			 }else if(dataObj==="4"){
				 result =  "其他投资";
			 }else{
				 result =  "其他";
			 }

		}
		return result;
	},
	setDomain:function(dataObj){
		var result = '';
		if(dataObj === null || dataObj === 'null'||dataObj === undefined){
			result = '';
		} else {
			if(dataObj==="0"){
				result = "信息技术";
			 }else if(dataObj==="1"){
				 result = "机械电子";
			 }else if(dataObj=="2"){
				 result = "生物工程";
			 }else if(dataObj=="3"){
				 result = "能源环保";
			 }else if(dataObj=="4"){
				 result = "化学化工";
			 }else if(dataObj=="5"){
				 result = "材料科学";
			 }else{
				 result = '其他';
			 }
		}
		return result;
	},
	setNature:function(dataObj){
		var result = '';
		if(dataObj === null || dataObj === 'null' || dataObj === undefined || dataObj ==="undefined"){
			result = '';
		} else {
			 if(dataObj==="0"){
				 result =  "国有企业";
			 }else if(dataObj==="1"){
				 result =  "民营独资";
			 }else if(dataObj==="2"){
				 result =  "外企独资";
			 }else if(dataObj==="3"){
				 result =  "中外合资";
			 }else{
				 result =  "其他";
			 }

		}
		return result;
	},
	pagination:function(sumPage, currentPageSelector, paginationSelector,obj, methodName) {
		if (sumPage === null || isNaN(sumPage)) {
			return;
		}
		var sumPage = parseInt(sumPage);
		var currentPage = parseInt($(currentPageSelector).val());
		if (currentPage === 0) {
			return;
		}
		var paginationInfo =
			 '<div class="pageControlLayout">' +
			 	'<div class="pageControl">' +
		        	'<div id="paginationInfo" class="left pagesButtonLayout">' +
		        		initPaginationBar(sumPage, currentPage) +
		                '<div class="clear"></div>' +
		            '</div>' +
		            '<div class="left toPageLayout">' +
		            	'<div class="left"><b>共</b><b id="sumPage">'+ sumPage +'</b><b>页&nbsp;&nbsp;跳转到第  </b><input id="toPage" type="text" size="3" class="widthAuto" /><b>页</b></div>' +
		                '<a id="toPageConfirm" class="sureButton">跳转</a>' +
		                '<div class="clear"></div>' +
		            '</div>' +
		            '<div class="clear"></div>' +
		        '</div>' +
		    '</div>';
		$(paginationSelector).append(paginationInfo);
		$('#toPage').val(currentPage);
		$('#paginationInfo').find('a').click(function() {
			var curPageTemp = $('#paginationInfo').find('.pageCur').html();
			var curPage = '';
			if ($(this).hasClass('pagePrev')) {
				curPage = parseInt(curPageTemp)-1;
			} else if ($(this).hasClass('pageNext')) {
				curPage = parseInt(curPageTemp)+1;
			} else {
				curPage = $(this).html();
			}
			$(currentPageSelector).val(curPage);
			obj[methodName](null);
		});
		$('#toPageConfirm').click(function() {
			var toPage = parseInt($('#toPage').val());
			var sumPage = parseInt($('#sumPage').html());
			if (isNaN(toPage) || toPage <= 0) {
				$(currentPageSelector).val('1');
			} else if (toPage > sumPage) {
				$(currentPageSelector).val(sumPage);
			} else {
				$(currentPageSelector).val(toPage);
			}
			obj[methodName](null);
		});
	},
	maxRecordPerPage:function() {
		//每页显示几条
		var maxRecordPerPage = 10;
		return maxRecordPerPage;
	},
	selectAll:function(selectAll, tbody) {
		var selectAllSelector = '';
		var tBodySelector = '';
		if (selectAll.indexOf('#') >= 0) {
			selectAllSelector = selectAll;
		} else {
			selectAllSelector = '#' + selectAll;
		}
		if (tbody.indexOf('#') >= 0) {
			tBodySelector = tbody;
		} else {
			tBodySelector = '#' + tbody;
		}
		$(selectAllSelector).change(function() {
			if($(this).is(':checked')) {
				$(tBodySelector).find('tr').removeClass('trbgWhite');
				$(tBodySelector).find('tr').addClass('trbgBlue');
				$(tBodySelector).find('input:checkbox').each(function() {
					this.checked=true;
				});
			} else {
				$(tBodySelector).find('tr').removeClass('trbgBlue');
				$(tBodySelector).find('tr').addClass('trbgWhite');
				$(tBodySelector).find('input:checkbox').removeAttr('checked');
			}
		});

		$(document).delegate(tBodySelector +' tr input:checkbox', 'change', function(event){
			var flag = $(this).is(':checked');
			if (!flag) {
				$(this).parents('tr').removeClass('trbgBlue');
				$(this).parents('tr').addClass('trbgWhite');
				this.checked=false;
			} else {
				$(this).parents('tr').removeClass('trbgWhite');
				$(this).parents('tr').addClass('trbgBlue');
				this.checked=true;
			}
			event.stopPropagation();
		});
	}
};


function getWord(actionCode, status, listOne, listTwo,returnInfoModal,returnInfo) {
	var first = '';
	var second = '';
	for(var i = 0; i < listOne.length; i++) {
		first += listOne[i];
	}
	for(var j = 0; j < listTwo.length; j++) {
		second += listTwo[j];
	}
	if (status === 0) {
		$(returnInfo).html("");
//		$(returnInfo).html(first);
		$(returnInfo).html("成功");
		$(returnInfoModal).click();
	}
	if (status === 1) {
		$(returnInfo).html("");
		$(returnInfo).html(first+second);
		$(returnInfoModal).click();
	}
	if (status === 2) {
		$(returnInfo).html("");
		$(returnInfo).html(first+second);
		$(returnInfoModal).click();
	}
};



function getResultMaitText(str, size) {
	var link = '<a href="#" style="color:blue;" onclick="doMoreInfo(\''+str+'\')">' + '更多信息' + '</a>';
	var subStr = str;
	var inputNum = str.replace(/[^\x00-\xff]/g, "**").length; // 得到输入的字节数;
	if (inputNum > size) {
		var temp = str.replace(/[^\x00-\xff]/g, "**"); // 得到替换后的字符;
		var count0 = 0;
		temp = temp.substring(0, size).match(/\*/g);
		if (temp !== null) {
			count0 = temp.length;
		}
		subStr = str.substring(0, ((size - count0) + parseInt(count0 / 2)))+'...'+link;
	}
	return subStr;
};

function doMoreInfo(str){
	window.open('moreInfo.html?params='+str,'');
}

//根据当前页码数，初始化分页信息
function initPaginationBar(sumPage, currentPage) {
	var paginationBar = '';
	var prevPage = '<a class="pagePrev">上一页</a>';
	var nextPage = '<a class="pageNext">下一页</a>';
	var prevPageGray = '<b class="pagePrev">上一页</b>';
	var nextPageGray = '<b class="pageNext">下一页</b>';
	// 根据当前页设置“上一页”的状态
	if (currentPage === 1) {
		paginationBar += prevPageGray;
	} else {
		paginationBar += prevPage;
	}
	// 如果总页数不超过5页，那么全部显示。
	if (sumPage <= 5) {
		for(var i = 1; i <= sumPage; i++) {
			if (i === currentPage) {
				paginationBar = paginationBar + '<b class="pageCur">'+ i + '</b>';
			} else {
				paginationBar = paginationBar + '<a>'+ i +'</a>';
			}
		}
	}
	// 如果总页数大于5页，并且当前页小于等于5，显示 '12345...下一页'
	if (sumPage > 5 && currentPage <= 5) {
		for(var j = 1; j <= currentPage; j++) {
			if (j === currentPage) {
				paginationBar = paginationBar + '<b class="pageCur">'+ j +'</b>';
			} else {
				paginationBar = paginationBar + '<a>'+ j +'</a>';
			}
		}

		if (currentPage === sumPage-1) {
			paginationBar = paginationBar + '<a>'+ (currentPage+1) +'</a>';
		}
		if (currentPage === sumPage-2) {
			paginationBar = paginationBar + '<a>'+ (currentPage+1) +'</a>' +
							 '<a>'+ (currentPage+2) +' </a>';
		}
		if (currentPage < sumPage-2) {
			paginationBar = paginationBar + '<a>'+ (currentPage+1) +'</a>' +
							 '<a>'+ (currentPage+2) +'</a>' +
							 '<b class="pageBreak">...</b>';
		}
	}

	// 如果总页数大于5页，并且当前页大于5，显示 '123..下一页'
	if (sumPage > 5 && currentPage > 5) {
		paginationBar = paginationBar + '<a>1</a>' +
						'<a>2</a>' +
						'<b class="pageBreak">...</b>' +
						'<a>'+ (currentPage-2) +'</a>' +
						'<a>'+ (currentPage-1) +'</a>' +
						'<b class="pageCur">'+ currentPage +'</b>';
		if (currentPage === sumPage-1) {
			paginationBar = paginationBar + '<a>'+ (currentPage+1) +'</a>';
		}
		if (currentPage === sumPage-2) {
			paginationBar = paginationBar + '<a>'+ (currentPage+1) +'</a>' +
							 '<a>'+ (currentPage+2) +' </a>';
		}
		if (currentPage < sumPage-2) {
			paginationBar = paginationBar + '<a>'+ (currentPage+1) +'</a>' +
							 '<a>'+ (currentPage+2) +'</a>' +
							 '<b class="pageBreak">...</b>';
		}
	}
	// 根据当前页设置“下一页”的状态
	if (currentPage === sumPage) {
		paginationBar += nextPageGray;
	} else {
		paginationBar += nextPage;
	}
	return paginationBar;
};
/* 默认的页面加载函数，对页面加载函数进行执行 */
$(document).ready(function() {
	CommonFunction.toUpperCase();
});
