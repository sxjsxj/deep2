function setLeftNav(buttonSelector) {
	//鼠标移向
	$('#companyMyRequirement').mouseover(function() {
		$('#companyMyRequirement').addClass("active");
		var imgUrl = "../resources/images/front/img/my_xuqiu2.png";
		$('#myreqImg').attr("src", imgUrl);
	});

	$('#companyMyRecommend').mouseover(function() {
		$('#companyMyRecommend').addClass("active");
		var imgUrl = "../resources/images/front/img/my_tuijian2.png";
		$('#myrecommendImg').attr("src", imgUrl);
	});

	$('#companyMyCollectionAchievement').mouseover(function() {
		$('#companyMyCollectionAchievement').addClass("active");
		var imgUrl = "../resources/images/front/img/my_chengguo2.png";
		$('#myCollectionAchievementImg').attr("src", imgUrl);
	});

	$('#companyMyCollectionResearchGroup').mouseover(function() {
		$('#companyMyCollectionResearchGroup').addClass("active");
		var imgUrl = "../resources/images/front/img/my_tuandui2.png";
		$('#myCollectionResearchGroupImg').attr("src", imgUrl);
	});

	$('#companyMyCollectionInvestor').mouseover(function() {
		$('#companyMyCollectionInvestor').addClass("active");
		var imgUrl = "../resources/images/front/img/my_shouzhifang2.png";
		$('#myCollectionInvestorImg').attr("src", imgUrl);
	});

	$('#myCompanyInfo').mouseover(function() {
		$('#myCompanyInfo').addClass("active");
		var imgUrl = "../resources/images/front/img/my_info2.png";
		$('#myCompanyInfoImg').attr("src", imgUrl);
	});

	$('#updateMyPassword').mouseover(function() {
		$('#updateMyPassword').addClass("active");
		var imgUrl = "../resources/images/front/img/my_change2.png";
		$('#updateMyPasswordImg').attr("src", imgUrl);
	});
	
	//移出
	$('#companyMyRequirement').mouseout(function() {
		if(buttonSelector !== '#companyMyRequirement') {
			$('#companyMyRequirement').removeClass("active");
			var imgUrl = "../resources/images/front/img/my_xuqiu.png";
			$('#myreqImg').attr("src", imgUrl);
		}
	});

	$('#companyMyRecommend').mouseout(function() {
		if(buttonSelector !== '#companyMyRecommend') {
			$('#companyMyRecommend').removeClass("active");
			var imgUrl = "../resources/images/front/img/my_tuijian.png";
			$('#myrecommendImg').attr("src", imgUrl);
		}
	});

	$('#companyMyCollectionAchievement').mouseout(function() {
		if(buttonSelector !== '#companyMyCollectionAchievement') {
			$('#companyMyCollectionAchievement').removeClass("active");
			var imgUrl = "../resources/images/front/img/my_chengguo.png";
			$('#myCollectionAchievementImg').attr("src", imgUrl);
		}
	});

	$('#companyMyCollectionResearchGroup').mouseout(function() {
		if(buttonSelector !== '#companyMyCollectionResearchGroup') {
			$('#companyMyCollectionResearchGroup').removeClass("active");
			var imgUrl = "../resources/images/front/img/my_tuandui.png";
			$('#myCollectionResearchGroupImg').attr("src", imgUrl);
		}
	});

	$('#companyMyCollectionInvestor').mouseout(function() {
		if(buttonSelector !== '#companyMyCollectionInvestor') {
			$('#companyMyCollectionInvestor').removeClass("active");
			var imgUrl = "../resources/images/front/img/my_shouzhifang.png";
			$('#myCollectionInvestorImg').attr("src", imgUrl);
		}
	});

	$('#myCompanyInfo').mouseout(function() {
		if(buttonSelector !== '#myCompanyInfo') {
			$('#myCompanyInfo').removeClass("active");
			var imgUrl = "../resources/images/front/img/my_info.png";
			$('#myCompanyInfoImg').attr("src", imgUrl);
		}
	});

	$('#updateMyPassword').mouseout(function() {
		if(buttonSelector !== '#updateMyPassword') {
			$('#updateMyPassword').removeClass("active");
			var imgUrl = "../resources/images/front/img/my_change.png";
			$('#updateMyPasswordImg').attr("src", imgUrl);
		}
	});

	//点击事件
	$('#companyMyRequirement').click(function() {
		$('#leftBtns').find('li').removeClass('active');
		$('#companyMyRequirement').addClass("active");
		var imgUrl = "../resources/images/front/img/my_xuqiu2.png";
		$('#myreqImg').attr("src", imgUrl);
	});

	$('#companyMyRecommend').click(function() {
		$('#leftBtns').find('li').removeClass('active');
		$('#companyMyRecommend').addClass("active");
		var imgUrl = "../resources/images/front/img/my_tuijian2.png";
		$('#myrecommendImg').attr("src", imgUrl);
	});

	$('#companyMyCollectionAchievement').click(function() {
		$('#leftBtns').find('li').removeClass('active');
		$('#companyMyCollectionAchievement').addClass("active");
		var imgUrl = "../resources/images/front/img/my_chengguo2.png";
		$('#myCollectionAchievementImg').attr("src", imgUrl);
	});

	$('#companyMyCollectionResearchGroup').click(function() {
		$('#leftBtns').find('li').removeClass('active');
		$('#companyMyCollectionResearchGroup').addClass("active");
		var imgUrl = "../resources/images/front/img/my_tuandui2.png";
		$('#myCollectionResearchGroupImg').attr("src", imgUrl);
	});

	$('#companyMyCollectionInvestor').click(function() {
		$('#leftBtns').find('li').removeClass('active');
		$('#companyMyCollectionInvestor').addClass("active");
		var imgUrl = "../resources/images/front/img/my_shouzhifang2.png";
		$('#myCollectionInvestorImg').attr("src", imgUrl);
	});

	$('#myCompanyInfo').click(function() {
		$('#leftBtns').find('li').removeClass('active');
		$('#myCompanyInfo').addClass("active");
		var imgUrl = "../resources/images/front/img/my_info2.png";
		$('#myCompanyInfoImg').attr("src", imgUrl);
	});

	$('#updateMyPassword').click(function() {
		$('#leftBtns').find('li').removeClass('active');
		$('#updateMyPassword').addClass("active");
		var imgUrl = "../resources/images/front/img/my_change2.png";
		$('#updateMyPasswordImg').attr("src", imgUrl);
	});
	
	$(buttonSelector).click();
};