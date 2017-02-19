/* 定义项目中的公共方法 */
var provinceCity="";
var cityCounty="";
var FrontCommonFunction = {
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
	/* 判断用户是否登录 */
	isLogin : function() {
		var commonUserLoginId=$("#commonUserLoginId").val();
		if(commonUserLoginId!==""){
			return true;
		}else{
			return false;
		}
	},
	loginProcess: function() {
		$('#nologin').removeClass('hide');
		$('#nologin').show();
		var loginUrl = $('#loginUrl').attr('url');
		location.href=loginUrl;
	},
	/**
	 * 下拉列表形式(初始化行业领域 alibaba_basic_research_field)
	 */
	initSelectBaseResearchField:function(id) {
		var url = $(id).attr('url');
		var param = {};
		this.baseOptions['url'] = url;
		this.baseOptions['data'] = param;
		this.baseOptions['success'] = function(datas) {
			var queryReturnList = datas;
			var dd = '';
			for(var i = 0; i < queryReturnList.length; i++) {	
				dd += '<dd value="'+i+'">' + queryReturnList[i].name + '</dd>';
			}
			$(id).append(dd);
		};
		$.ajax(this.baseOptions);
	},
	/**
	 * 下拉列表形式(初始化设置高校)
	 */
	initSelectBaseUniName:function(id) {
		var url = $(id).attr('url');
		var param = {};
		this.baseOptions['url'] = url;
		this.baseOptions['data'] = param;
		this.baseOptions['success'] = function(datas) {
			var queryReturnList = datas;
			var dd = '';
			for(var i = 0; i < queryReturnList.length; i++) {	
				dd += '<dd value="'+i+'">' + queryReturnList[i].name + '</dd>';
			}
			$(id).append(dd);
		};
		$.ajax(this.baseOptions);
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
			var dd = '';
			$.each(obj,function(n,value){
				dd += '<dd value="'+n+'">' + n + '</dd>';
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
//			var dd = '';
//			$.each(obj,function(n,value){
//				dd += '<dd value="'+n+'">' + n + '</dd>';
//			})
//			$(id).append(dd);
		};
		$.ajax(this.baseOptions);
	},
	/**
	 * 下拉列表形式(科研团队名称查询alibaba_research_group)
	 */
	initSelectResearchGroup:function(id) {
		var url = $(id).attr('url');
		var param = {};
		var commonResearchUsrId= $('#commonResearchUserId').val();
		var queryParam={};
		var researchGroupQueryModel = {};
		researchGroupQueryModel['status'] = '0,1,2';
		researchGroupQueryModel['removeFlag'] = '0';
		queryParam['researchGroupQueryModel'] = researchGroupQueryModel;
		var universityUserQueryModel={};
		universityUserQueryModel['id']=commonResearchUsrId;
		var organizationUserQueryModel = {};
		organizationUserQueryModel['id']=commonResearchUsrId;
		queryParam['universityUserQueryModel']=universityUserQueryModel;
		queryParam['organizationUserQueryModel'] = organizationUserQueryModel;
		var jsonStr=JSON.stringify(queryParam);
		param['str']=jsonStr;
		this.baseOptions['url'] = url;
		this.baseOptions['data'] = param;
		this.baseOptions['success'] = function(datas) {
			var queryReturnList = datas.queryReturnList;
			var dd = '';
			for(var i = 0; i < queryReturnList.length; i++) {	
				dd += '<dd id="'+queryReturnList[i].id+'">' + queryReturnList[i].name + '</dd>';
			}
			$(id).append(dd);
		};
		$.ajax(this.baseOptions);
	},
	/**
	 * 查询条件初始化行业复选框领域
	 */
	initCheckBoxBaseResearchField:function(id) {
		var url = $(id).attr('url');
		var param = {};
		this.baseOptions['url'] = url;
		this.baseOptions['data'] = param;
		this.baseOptions['success'] = function(datas) {
			var queryReturnList = datas;
			var option = ""
				for(var i = 0; i < queryReturnList.length; i++) {	
						option += "<div class='fl list'><div class='checkbox fl'>"
						option+='<img id="domainCheckBox'+i+'" src="../resources/images/front/img/checkbox.png"/>'
                        option+="</div>"
                        option+="<div class='fl'>"+'<input type="hidden" value="'+i+'" id="domainCheckBoxValue'+i+'"/>'+queryReturnList[i].name+"</div>"	
                        option += "<div class='clear'></div>"
						+'</div>';
			     }
			$(id).append(option);
		};
		$.ajax(this.baseOptions);
	},
	/**
	 * 查询条件初始化大区
	 */
	initCheckBoxRegion:function(id) {
		var url = $(id).attr('url');
		var param = {};
		this.baseOptions['url'] = url;
		this.baseOptions['data'] = param;
		this.baseOptions['success'] = function(datas) {
			var provinceAreaMap=eval(datas);
			var option="";
			//热门地区
			var host="<li>";
			host+="<div class='fl ti2'></div>"
			host+="<div class='fl list'>"
			    host+='<div class="checkbox fl" id="remenParentShow">'
				  host+='<img id="remenParent" src="../resources/images/front/img/checkbox.png"/>'
				host+='</div>'
				host+="<div class='fl'>热门地区</div>"
				host+="<div class='clear'></div>"	
			host+='</div>'
			var list0=provinceAreaMap["0"];
			if(list0!==undefined && list0!==null){
				for(var i = 0; i < list0.length; i++) {	
					host+='<div class="fl list">'
					    host+='<div class="checkbox fl">'
						  host+='<img id="remenChild'+i+'" src="../resources/images/front/img/checkbox.png"/>'
						host+='</div>'
						host+="<div class='fl'>"+'<input type="hidden" value="'+list0[i]+'" id="remenChildValue'+i+'"/>'+list0[i]+"</div>"
						host+="<div class='clear'></div>"	
					host+='</div>'
				}
				host+="<div class='more fl' id='moresLink' style='margin-top:2px'><a href='#'>更多>><a></div>"
				host+="<div class='clear'></div>"
				host+="</li>"
				option+=host;
			}
			
			var more="";
            more+="<div class='molist'>"
			//华南地区
            var huanan="<li>";
              huanan+="<div class='fl ti2'></div>"
            	huanan+="<div class='fl list'>"
            	huanan+='<div class="checkbox fl" id="huananParentShow">'
            	huanan+='<img id="huananParent" src="../resources/images/front/img/checkbox.png"/>'
            	huanan+='</div>'
            	huanan+="<div class='fl'>华南地区</div>"
            	huanan+="<div class='clear'></div>"	
              huanan+='</div>'
			var list1 = provinceAreaMap["1"];
			if (list1 !== undefined && list1 !== null) {
				for (var i = 0; i < list1.length; i++) {
					huanan += "<div class='fl list'>"
					huanan += "<div class='checkbox fl'>"
					huanan += '<img id="huananChild'+i+'" src="../resources/images/front/img/checkbox.png"/>'
					huanan += '</div>'
					huanan += "<div class='fl'>" +'<input type="hidden" value="'+list1[i]+'" id="huananChildValue'+i+'"/>'+ list1[i] + "</div>"
					huanan += "<div class='clear'></div>"
					huanan += '</div>'
				}
				huanan+='<div class="clear"></div></li>'
				more += huanan;
			}
			//华北地区
			 var huabei = "<li>";
			huabei += "<div class='fl ti2'></div>"
			huabei += "<div class='fl list'>"
			huabei += '<div class="checkbox fl" id="huabeiParentShow">'
			huabei += '<img id="huabeiParent" src="../resources/images/front/img/checkbox.png"/>'
			huabei += '</div>'
			huabei += "<div class='fl'>华北地区</div>"
			huabei += "<div class='clear'></div>"
			huabei += '</div>'
			var list2 = provinceAreaMap["2"];
			if (list2 !== undefined && list2 !== null) {
				for (var i = 0; i < list2.length; i++) {
					huabei += "<div class='fl list'>"
					huabei += "<div class='checkbox fl'>"
					huabei += '<img id="huabeiChild'+i+'" src="../resources/images/front/img/checkbox.png"/>'
					huabei += '</div>'
					huabei += "<div class='fl'>"+'<input type="hidden" value="'+list2[i]+'" id="huabeiChildValue'+i+'"/>'+ list2[i] + "</div>"
					huabei += "<div class='clear'></div>"
					huabei += '</div>'
				}
				huabei += '<div class="clear"></div></li>'
				more += huabei;
			}
			// 华东地区
			 var huadong = "<li>";
				huadong += "<div class='fl ti2'></div>"
				huadong += "<div class='fl list'>"
				huadong += '<div class="checkbox fl" id="huadongParentShow">'
				huadong += '<img id="huadongParent" src="../resources/images/front/img/checkbox.png"/>'
				huadong += '</div>'
				huadong += "<div class='fl'>华东地区</div>"
				huadong += "<div class='clear'></div>"
				huadong += '</div>'
			var list3=provinceAreaMap["3"];
			if(list3!==undefined && list3!==null){
				for(var i = 0; i < list3.length; i++) {	
					huadong += "<div class='fl list'>"
						huadong += "<div class='checkbox fl'>"
						huadong += '<img id="huadongChild'+i+'" src="../resources/images/front/img/checkbox.png"/>'
						huadong += '</div>'
						huadong += "<div class='fl'>"+'<input type="hidden" value="'+list3[i]+'" id="huadongChildValue'+i+'"/>'+ list3[i] + "</div>"
						huadong += "<div class='clear'></div>"
						huadong += '</div>'
				}
				huadong += '<div class="clear"></div></li>'
				more += huadong;
			}
			//华中地区
			 var huazhong = "<li>";
				huazhong += "<div class='fl ti2'></div>"
				huazhong += "<div class='fl list'>"
				huazhong += '<div class="checkbox fl" id="huazhongParentShow">'
				huazhong += '<img id="huazhongParent" src="../resources/images/front/img/checkbox.png"/>'
				huazhong += '</div>'
				huazhong += "<div class='fl'>华中地区</div>"
				huazhong += "<div class='clear'></div>"
				huazhong += '</div>'
			var list4=provinceAreaMap["4"];
			if(list4!==undefined && list4!==null){
				for(var i = 0; i < list4.length; i++) {	
					huazhong += "<div class='fl list'>"
						huazhong += "<div class='checkbox fl'>"
						huazhong += '<img id="huazhongChild'+i+'" src="../resources/images/front/img/checkbox.png"/>'
						huazhong += '</div>'
						huazhong += "<div class='fl'>"+'<input type="hidden" value="'+list4[i]+'" id="huazhongChildValue'+i+'"/>'+ list4[i] + "</div>"
						huazhong += "<div class='clear'></div>"
						huazhong += '</div>'
				}
				huazhong += '<div class="clear"></div></li>'
				more += huazhong;
			}
			//西北地区
			 var xibei = "<li>";
				xibei += "<div class='fl ti2'></div>"
				xibei += "<div class='fl list'>"
				xibei += '<div class="checkbox fl" id="xibeiParentShow">'
				xibei += '<img id="xibeiParent" src="../resources/images/front/img/checkbox.png"/>'
				xibei += '</div>'
				xibei += "<div class='fl'>西北地区</div>"
				xibei += "<div class='clear'></div>"
				xibei += '</div>'
			var list5=provinceAreaMap["5"];
			if(list5!==undefined && list5!==null){
				for(var i = 0; i < list5.length; i++) {	
					xibei += "<div class='fl list'>"
						xibei += "<div class='checkbox fl'>"
						xibei += '<img id="xibeiChild'+i+'" src="../resources/images/front/img/checkbox.png"/>'
						xibei += '</div>'
						xibei += "<div class='fl'>"+'<input type="hidden" value="'+list5[i]+'" id="xibeiChildValue'+i+'"/>'+ list5[i] + "</div>"
						xibei += "<div class='clear'></div>"
						xibei += '</div>'
				}
				xibei += '<div class="clear"></div></li>'
				more += xibei;
			}
			//东北地区
			 var dongbei = "<li>";
				dongbei += "<div class='fl ti2'></div>"
				dongbei += "<div class='fl list'>"
				dongbei += '<div class="checkbox fl" id="dongbeiParentShow">'
				dongbei += '<img id="dongbeiParent" src="../resources/images/front/img/checkbox.png"/>'
				dongbei += '</div>'
				dongbei += "<div class='fl'>东北地区</div>"
				dongbei += "<div class='clear'></div>"
				dongbei += '</div>'
			var list6=provinceAreaMap["6"];
			if(list6!==undefined && list6!==null){
				for(var i = 0; i < list6.length; i++) {	
					dongbei += "<div class='fl list'>"
						dongbei += "<div class='checkbox fl'>"
						dongbei += '<img id="dongbeiChild'+i+'" src="../resources/images/front/img/checkbox.png"/>'
						dongbei += '</div>'
						dongbei += "<div class='fl'>"+'<input type="hidden" value="'+list6[i]+'" id="dongbeiChildValue'+i+'"/>'+ list6[i] + "</div>"
						dongbei += "<div class='clear'></div>"
						dongbei += '</div>'
				}
				dongbei += '<div class="clear"></div></li>'
				more += dongbei;
			}
			//西南地区
			 var xinan = "<li>";
				xinan += "<div class='fl ti2'></div>"
				xinan += "<div class='fl list'>"
				xinan += '<div class="checkbox fl" id="xinanParentShow">'
				xinan += '<img id="xinanParent" src="../resources/images/front/img/checkbox.png"/>'
				xinan += '</div>'
				xinan += "<div class='fl'>西南地区</div>"
				xinan += "<div class='clear'></div>"
				xinan += '</div>'
			var list7=provinceAreaMap["7"];
			if(list7!==undefined && list7!==null){
				for(var i = 0; i < list7.length; i++) {	
					xinan += "<div class='fl list'>"
						xinan += "<div class='checkbox fl'>"
						xinan += '<img id="xinanChild'+i+'" src="../resources/images/front/img/checkbox.png"/>'
						xinan += '</div>'
						xinan += "<div class='fl'>"+'<input type="hidden" value="'+list7[i]+'" id="xinanChildValue'+i+'"/>'+ list7[i] + "</div>"
						xinan += "<div class='clear'></div>"
						xinan += '</div>'
				}
				xinan += '<div class="clear"></div></li>'
				more += xinan;
			}
			//港澳台地区
			var gangaotai = "<li>";
			gangaotai += "<div class='fl ti2'></div>"
			gangaotai += "<div class='fl list'>"
			gangaotai += '<div class="checkbox fl" id="gangaotaiParentShow">'
			gangaotai += '<img id="gangaotaiParent" src="../resources/images/front/img/checkbox.png"/>'
			gangaotai += '</div>'
			gangaotai += "<div class='fl'>港澳台地区</div>"
			gangaotai += "<div class='clear'></div>"
			gangaotai += '</div>'
			var list8=provinceAreaMap["8"];
			if(list8!==undefined && list8!==null){
				for(var i = 0; i < list8.length; i++) {	
					gangaotai += "<div class='fl list'>"
						gangaotai += "<div class='checkbox fl'>"
						gangaotai += '<img id="gangaotaiChild'+i+'" src="../resources/images/front/img/checkbox.png"/>'
						gangaotai += '</div>'
						gangaotai += "<div class='fl'>"+'<input type="hidden" value="'+list8[i]+'" id="gangaotaiChildValue'+i+'"/>'+ list8[i] + "</div>"
						gangaotai += "<div class='clear'></div>"
						gangaotai += '</div>'
				}
				gangaotai += '<div class="clear"></div></li>'
				more += gangaotai;
			}
			//海外地区
			var haiwai = "<li>";
			haiwai += "<div class='fl ti2'></div>"
			haiwai += "<div class='fl list'>"
			haiwai += '<div class="checkbox fl" id="haiwaiParentShow">'
			haiwai += '<img id="haiwaiParent" src="../resources/images/front/img/checkbox.png"/>'
			haiwai += '</div>'
			haiwai += "<div class='fl'>海外地区</div>"
			haiwai += "<div class='clear'></div>"
			haiwai += '</div>'
			var list9=provinceAreaMap["9"];
			if(list9!==undefined && list9!==null){
				for(var i = 0; i < list9.length; i++) {	
					haiwai += "<div class='fl list'>"
						haiwai += "<div class='checkbox fl'>"
						haiwai += '<img id="haiwaiChild'+i+'" src="../resources/images/front/img/checkbox.png"/>'
						haiwai += '</div>'
						haiwai += "<div class='fl'>"+'<input type="hidden" value="'+list9[i]+'" id="haiwaiChildValue'+i+'"/>'+ list9[i] + "</div>"
						haiwai += "<div class='clear'></div>"
						haiwai += '</div>'
				}
				haiwai += '<div class="clear"></div></li>'
				more += haiwai;
			}
			more+="</div>"
			option+=more;
			$(id).append(option);
		};
		$.ajax(this.baseOptions);
	},
	/**
	 * 表单新增编辑初始化行业复选框领域
	 */
	initCheckBoxFormBaseResearchField:function(id) {
		var url = $(id).attr('url');
		var param = {};
		this.baseOptions['url'] = url;
		this.baseOptions['data'] = param;
		this.baseOptions['success'] = function(datas) {
			var queryReturnList = datas;
			var option = ""
				for(var i = 0; i < queryReturnList.length; i++) {	
						option+= "<div class='fl txts'>"
						option+='<input class="checkbox" id="investDomainCheckBox'+i+'" value="'+i+'" name="investDomain" type="checkbox">'
						option+='<div class="fl s">'+queryReturnList[i].name+'</div>'
                        option += "<div class='clear'></div>"
						+'</div>';
			     }
			$(id).append(option);
		};
		$.ajax(this.baseOptions);
	},
	setType:function(dataObj){
		var result = '';
		if(dataObj === null || dataObj === 'null'||dataObj === undefined){
			result = '';
		} else {
			if(dataObj==="0"){
				result = "新产品研发";
			 }else if(dataObj==="1"){
				 result = "产品技术升级";
			 }else if(dataObj=="2"){
				 result = "技术服务";
			 }else{
				 result = '其他';
			 }
		}
		return result;
	},
	setResearchUserType:function(dataObj){
		var result = '';
		if(dataObj === null || dataObj === 'null'||dataObj === undefined){
			result = '';
		} else {
			if(dataObj==="0"){
				result = "高校";
			 }else if(dataObj==="1"){
				 result = "科研机构";
			 }else if(dataObj=="2"){
				 result = "个人";
			 }else{
				 result = '其他';
			 }
		}
		return result;
	},
	setInbestorType:function(dataObj){
		var result = '';
		if(dataObj === null || dataObj === 'null'||dataObj === undefined){
			result = '';
		} else {
			if(dataObj==="0"){
				result = "新产品研发";
			 }else if(dataObj==="1"){
				 result = "产品技术升级";
			 }else if(dataObj=="2"){
				 result = "技术服务";
			 }else{
				 result = '其他';
			 }
		}
		return result;
	},
	setInbestorUserType:function(dataObj){
		var result = '';
		if(dataObj === null || dataObj === 'null'||dataObj === undefined){
			result = '';
		} else {
			if(dataObj==="0"){
				result = "机构";
			 }else if(dataObj==="1"){
				 result = "个人";
			 }else{
				 result = '其他';
			 }
		}
		return result;
	},
	setStrAchievementType:function(dataObj){
		var result = '';
		if(dataObj === null || dataObj === 'null'||dataObj === undefined){
			result = '';
		} else {
			if(dataObj==="0"){
				result = "新产品研发";
			 }else if(dataObj==="1"){
				 result = "新技术";
			 }else if(dataObj=="2"){
				 result = "带有技术参数的图纸";
			 }else if(dataObj=="3"){
				 result = "专利";
			 }else{
				 result = '其他';
			 }
		}
		return result;
	},
	setDuration:function(dataObj){
		var result = '';
		if(dataObj === null || dataObj === 'null'){
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
			 }else if(dataObj==="5"){
				 result = "24个月以上";
			 }else{
				 result = "其他";
			 }
		}
		return result;
	},
	setInbestorCooperationType:function(dataObj){
		var result = '';
		if(dataObj === null || dataObj === 'null'||dataObj === undefined){
			result = '';
		} else {
			if(dataObj==="0"){
				result = "技术入股";
			 }else if(dataObj==="1"){
				 result = "技术转让";
			 }else if(dataObj=="2"){
				 result = "技术许可";
			 }else if(dataObj=="3"){
				 result = "委托开发";
			 }else if(dataObj=="4"){
				 result = "技术服务";
			 }else if(dataObj=="5"){
				 result = "其他";
			 }else{
				 result = '其他';
			 }
		}
		return result;
	},
	setScale:function(dataObj){
		var result = '';
		if(dataObj === null || dataObj === 'null'||dataObj === undefined){
			result = '';
		} else {
			if(dataObj==="0"){
				result = "50人以下";
			 }else if(dataObj==="1"){
				 result = "50-100人";
			 }else if(dataObj=="2"){
				 result = "100-500人";
			 }else if(dataObj=="3"){
				 result = "500-1000人";
			 }else if(dataObj=="4"){
				 result = "1000-2000人";
			 }else if(dataObj=="5"){
				 result = "2000-5000人";
			 }else if(dataObj=="6"){
				 result = "5000人以上";
			 }else{
				 result = '其他';
			 }
		}
		return result;
	},
	setStrScale:function(dataObj){
		var result = '';
		if(dataObj === null || dataObj === 'null'||dataObj === undefined){
			result = '';
		} else {
			if(dataObj==="0"){
				result = "50人以下";
			 }else if(dataObj==="1"){
				 result = "50-100人";
			 }else if(dataObj=="2"){
				 result = "100-500人";
			 }else if(dataObj=="3"){
				 result = "500-1000人";
			 }else if(dataObj=="4"){
				 result = "1000-2000人";
			 }else if(dataObj=="5"){
				 result = "2000-5000人";
			 }else if(dataObj=="6"){
				 result = "5000人以上";
			 }else{
				 result = '其他';
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
	setInvestorDomain:function(dataObj){
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
	setStrInvestorDomain:function(dataObj){
		var result = '';
		if(dataObj === null || dataObj === 'null'||dataObj === undefined){
			result = '不限';
		} else {
			
			if(dataObj.length>5){
				dataObj=dataObj.substring(0,5);
			}
			result =dataObj.replace('0','信息技术').replace('1','机械电子').replace('2','生物工程').replace('3','能源环保').replace('4','化学化工').replace('5','材料科学').replace('6','其他')+"...";
		}
		return result;
	},
	getCommonUserId:function(){
		var userQueryModel={};
		var commonUserLoginId=$("#commonUserLoginId").val();
		userQueryModel['id']=commonUserLoginId;
		return userQueryModel;
	},
	setPhase:function(dataObj){
		var result = '';
		if(dataObj === null || dataObj === 'null'||dataObj === undefined){
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
	setStrPatent:function(dataObj){
		var result = '';
		if(dataObj === null || dataObj === 'null'||dataObj === undefined){
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
	setStrNature:function(dataObj){
		var result = '';
		if(dataObj === null || dataObj === 'null'||dataObj === undefined){
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
			 }else if(dataObj==="4"){
				 result =  "其他";
			 }else{
				 result =  "其他";
			 }
		}
		return result;
	},
	setStrLeaderTitle:function(dataObj){
		var result = '';
		if(dataObj === null || dataObj === 'null'||dataObj === undefined){
			result = '';
		} else {
			if(dataObj==="0"){
				result =  "院士";
			 }else if(dataObj==="1"){
				 result =  "教授高级工程师";
			 }else if(dataObj==="2"){
				 result =  "高级工程师";
			 }else if(dataObj==="3"){
				 result =  "研究员";
			 }else if(dataObj==="4"){
				 result =  "工程师";
			 }else if(dataObj==="5"){
				 result =  "教授";
			 }else if(dataObj==="6"){
				 result =  "副教授";
			 }else if(dataObj==="7"){
				 result =  "其他";
			 }else{
				 result =  "其他";
			 }
		}
		return result;
	},
	setInvestorPhase:function(dataObj){
		var result = '';
		if(dataObj === null || dataObj === 'null'||dataObj === undefined){
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
	setStrInvestorPhase:function(dataObj){
		var result = '';
		if(dataObj === null || dataObj === 'null'||dataObj === undefined){
			result = '不限';
		} else {
			if(dataObj.length>5){
				dataObj=dataObj.substring(0,5);
			}
			result =dataObj.replace('0','研发阶段').replace('1','实验室阶段').replace('2','概念阶段').replace('3','小批量生产').replace('4','规模化生产阶段').replace('5','市场推广阶段').replace('6','其他')+"...";
		}
		return result;
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
	setStrAmount:function(dataObj){
		var result = '';
		if(dataObj === null || dataObj === 'null'||dataObj === undefined){
			result = '';
		} else {
			if(dataObj==="0"){
				result =  "100万以下";
			 }else if(dataObj==="1"){
				 result =  "100-500万";
			 }else if(dataObj==="2"){
				 result =  "500万-1000万";
			 }else if(dataObj==="3"){
				 result =  "1000万以上";
			 }else{
				 result =  "面议";
			 }
		}
		return result;
	},
	setAmount:function(dataObj){
		var result = '';
		if(dataObj === null || dataObj === 'null'||dataObj === undefined){
			result = '';
		} else {
			if(dataObj==='0'){
				result =  "100万以下";
			 }else if(dataObj==='1'){
				 result =  "100-500万";
			 }else if(dataObj==='2'){
				 result =  "500万-1000万";
			 }else if(dataObj==='3'){
				 result =  "1000万以上";
			 }else{
				 result =  "面议";
			 }
		}
		return result;
	},
	setStrProductValue:function(dataObj){
		var result = '';
		if(dataObj === null || dataObj === 'null'||dataObj === undefined){
			result = '';
		} else {
			if(dataObj==="0"){
				result =  "0-100万";
			 }else if(dataObj==="1"){
				 result =  "100-500万";
			 }else if(dataObj==="2"){
				 result =  "500-1000万";
			 }else if(dataObj==="3"){
				 result =  "1000-5000万";
			 }else if(dataObj==="4"){
				 result =  "5000万以上";
			 }else{
				 result =  "其他";
			 }
		}
		return result;
	},
	setRequirementStatus:function(dataObj){
		var result = '';
		if(dataObj === null || dataObj === 'null'||dataObj === undefined){
			result = '';
		} else {
			if(dataObj==="0"){
				result = "待审核";
			 }else if(dataObj==="1"){
				 result = "征集中";
			 }else if(dataObj==="2"){
				 result = "洽谈中";
			 }else if(dataObj==="3"){
				 result = "合作中";
			 }else if(dataObj==="4"){
				 result = "已完成";
			 }else{
				 result= "其他";
			 }
		}
		return result;
	},
	setResearchGroupStatus:function(dataObj){
		var result = '';
		if(dataObj === null || dataObj === 'null'||dataObj === undefined){
			result = '';
		} else {
			if(dataObj==="0"){
				result = "待审核";
			 }else if(dataObj==="1"){
				 result = "审核通过";
			 }else if(dataObj==="2"){
				 result = "审核不通过";
			 }else{
				 result= "其他";
			 }
		}
		return result;
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
	 getResultMaitText: function(str, size,moreInfoId,id) {
		 if(str === null || str === 'null' ||str === undefined){
			 return '';
		 }
		 var moreInfoUrl = $(moreInfoId).attr('url')+"?id="+id;
			var link = '<a href="#" style="color:blue;" onclick="doMoreInfo(\''+moreInfoUrl+'\')">' + '更多信息' + '</a>';
			var subStr = str;
			var inputNum = str.replace(/[^\x00-\xff]/g, "**").length; // 得到输入的字节数;
			if (inputNum > size) {
				var temp = str.replace(/[^\x00-\xff]/g, "**"); // 得到替换后的字符;
				var count0 = 0;
				temp = temp.substring(0, size).match(/\*/g);
				if (temp !== null) {
					count0 = temp.length;
				}
//				subStr = str.substring(0, ((size - count0) + parseInt(count0 / 2)))+'......'+link;
				subStr = str.substring(0, ((size - count0) + parseInt(count0 / 2)))+'......';
			}
			return subStr;
		},
		getSpace: function() {
			var str="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				   +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				   +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				   +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				   +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				   +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				   +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				return str;
			},
	 getDate:function(date) {
			if(date===null){
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
	replaceNull:function(dataObj){
		var result = '';
		if(dataObj ==="0") return "0";
		if(dataObj == null || dataObj==""|| dataObj == 'null' ||dataObj == undefined ||dataObj == "undefined"){
			result = '';
		} else {
			result = dataObj;
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
			          '<div id="paginationInfo">' +
		        		 initPaginationBar(sumPage, currentPage) + 
		        	   '</div>'+
		            	'<li class="fl all">共<span id="sumPage">'+ sumPage +'</span>页</li>'+
		            	'<li class="inpus fl"><input id="toPage" type="text"/>页</li>' +
		                '<li class="go fl"><a id="toPageConfirm" class="sureButton">跳转</a></li>' +
		                '<div class="clear"></div>';
		$(paginationSelector).append(paginationInfo);
		$('#toPage').val(currentPage);
		$('#paginationInfo').find('a').click(function() {
			var curPageTemp = $('#paginationInfo').find('.active').html();
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
		var maxRecordPerPage = 8;
		return maxRecordPerPage;
	},
	processResult:function(datas,returnInfoModal,returnInfo) {
		var status = datas.status;
		if (status === 0) {
			getWord(status,datas.infoList, '',returnInfoModal,returnInfo);
		}
		if (status === 1) {
			getWord(status, datas.warningList, datas.infoList,returnInfoModal,returnInfo);
		}
		if (status === 2) {
			getWord(status, datas.warningList, datas.errorList,returnInfoModal,returnInfo);
		}
	},
	getErrorResult:function(datas) {
		var status = datas.status;
		if (status === 0) {
			return getReturnErrorInfo(status,datas.infoList, '');
		}
		if (status === 1) {
			return getReturnErrorInfo(status, datas.warningList, datas.infoList);
		}
		if (status === 2) {
			return getReturnErrorInfo(status, datas.warningList, datas.errorList);
		}
	}
};

function getReturnErrorInfo(status, listOne, listTwo) {
	var first = '';
	var second = '';
	for(var i = 0; i < listOne.length; i++) {
		first += listOne[i];
	}
	for(var j = 0; j < listTwo.length; j++) {
		second += listTwo[j];
	}
	if (status === 0) {
		return first;
	}
	if (status === 1) {
        if(first!=""){
        	return first;
        }else{
        	return second;
        }
	}
	if (status === 2) {
		if(first!=""){
        	return first;
        }else{
        	return second;
        }
	}
};

function getWord(status, listOne, listTwo,returnInfoModal,returnInfo) {
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
		$(returnInfo).html(first);
		$(returnInfoModal).click();
	}
	if (status === 1) {
		$(returnInfo).html("");
		if(first!=""){
			$(returnInfo).html(first);
		}else{
			$(returnInfo).html(second);
		}
		$(returnInfoModal).click();
	}
	if (status === 2) {
		$(returnInfo).html("");
		if(first!=""){
			$(returnInfo).html(first);
		}else{
			$(returnInfo).html(second);
		}
		$(returnInfoModal).click();
	}
};

function doMoreInfo(url){
	window.open(url);
}

//根据当前页码数，初始化分页信息
function initPaginationBar(sumPage, currentPage) {
	var paginationBar = '';
	var prevPage = '<a class="pagePrev"><li class="fl lefticon"><img src="../resources/images/front/img/lefticon.png"/></li></a>';
	var nextPage = '<a class="pageNext"><li class="fl righticon"><img src="../resources/images/front/img/righticon.png"/></li></a>';
	var prevPageGray = '<b class="pagePrev"><li class="fl lefticon"><img src="../resources/images/front/img/lefticon.png"/></li></b>';
	var nextPageGray = '<b class="pageNext"><li class="fl righticon"><img src="../resources/images/front/img/righticon.png"/></li></b>';
	// 根据当前页设置“上一页”的状态
	if (currentPage === 1) {
		paginationBar += prevPageGray+"<li class='btn'>";
	} else {
		paginationBar += prevPage+"<li class='btn'>";
	}
	// 如果总页数不超过5页，那么全部显示。
	if (sumPage <= 5) {
		for(var i = 1; i <= sumPage; i++) {
			if (i === currentPage) {
				paginationBar = paginationBar + '<b class="pageCur"><div class="active">'+ i + '</div></b>';
			} else {
				paginationBar = paginationBar + '<div><a>'+ i +'</a></div>';
			}
		} 
		paginationBar=paginationBar+"</li>";
	} 
	// 如果总页数大于5页，并且当前页小于等于5，显示 '12345...下一页'
	if (sumPage > 5 && currentPage <= 5) {
		for(var j = 1; j <= currentPage; j++) {
			if (j === currentPage) {
				if(currentPage>1){
					paginationBar = paginationBar + '<div><a>'+ (j-1) +'</a></div>';
				}
				paginationBar = paginationBar + '<b class="pageCur"><div class="active">'+ j +'</div></b>';
			} 
		} 
		if (currentPage === sumPage-1) {
			paginationBar = paginationBar + '<div><a>'+ (currentPage+1) +'</a></div>'; 
		}
		if (currentPage < sumPage-2) {
			var tem='';
			 if(currentPage==1){
				 tem='<div><a>'+(currentPage+2)+'</a></div>';
	          }
			paginationBar =paginationBar + '<div><a>'+ (currentPage+1) +'</a></div>' +
			              tem+
				         '<b class="pageBreak"><div class="more">...</div></b>'+
			             '<div><a>'+ (sumPage) +'</a></div>';
	    }
		paginationBar=paginationBar+"</li>";
	}
	
	// 如果总页数大于5页，并且当前页大于5，显示 '123..下一页'
	if (sumPage > 5 && currentPage > 5) {
		var tem1="";
		if((currentPage === sumPage-2) || (currentPage === sumPage-1) || currentPage ===sumPage){
			tem1='<b class="pageBreak"><div class="more">...</div></b>';
		}
		var tem2="";
		if (currentPage === sumPage-1) {
			tem2= '<div><a>'+ (currentPage-1) +'</a></div>';
		}
		
		var tem3="";
		if (currentPage === sumPage) {
			tem3+= '<div><a>'+ (currentPage-2) +'</a></div>';
			tem3+= '<div><a>'+ (currentPage-1) +'</a></div>';
		}
		paginationBar = paginationBar +
						'<div><a>1</a></div>' +
						tem1+
						tem2+
						tem3+
						'<b class="pageCur"><div class="active">'+ currentPage +'</div></b>'; 
		if (currentPage === sumPage-1) {
			paginationBar = paginationBar + '<div><a>'+ (currentPage+1) +'</a></div>'; 
		}
		if (currentPage === sumPage-2) {
			paginationBar = paginationBar +
			'<div><a>'+ (currentPage+1) +'</a></div>' + 
			'<div><a>'+ (currentPage+2) +'</a></div>'; 
		}
		if (currentPage < sumPage-2) {
			paginationBar =paginationBar + '<div><a>'+ (currentPage+1) +'</a></div>' +
				         '<b class="pageBreak"><div class="more">...</div></b>'+
			             '<div><a>'+ (sumPage) +'</a></div>';
	    }
		paginationBar=paginationBar+"</li>";
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
	FrontCommonFunction.toUpperCase();
});



