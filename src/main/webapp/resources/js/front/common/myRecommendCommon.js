function myRecommendList(that, queryData, queryData2, url) {
	FrontCommonFunction.baseOptions['url'] = url;
	FrontCommonFunction.baseOptions['data'] = queryData;
	FrontCommonFunction.baseOptions['success'] = function(datas) {
		if(datas.status === 0){
			that.display(datas);
		}else{
			FrontCommonFunction.baseOptions['url'] = url;
			FrontCommonFunction.baseOptions['data'] = queryData;
			FrontCommonFunction.baseOptions['success'] = function(datas) {
				if(datas.status === 0){
					that.display(datas);
				} else {
					
				}
			};
			$.ajax(FrontCommonFunction.baseOptions);
		}
	};
	$.ajax(FrontCommonFunction.baseOptions);
};
