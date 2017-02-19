function setLeftNav(buttonSelector) {
	var type = $('#commonInvestorUserType').val();
	if(type == '0') {
		$('#myInvestorInfo_a').attr('href', $('#orgUrl').val());
	}
	if(type == '1') {
		$('#myInvestorInfo_a').attr('href',$('#perUrl').val());
	}
	//鼠标移向
	$('#investorMyRecommend').mouseover(function() {
		$('#investorMyRecommend').addClass("active");
		var imgUrl = "../resources/images/front/img/my_tuijian2.png";
		$('#myrecommendImg').attr("src", imgUrl);
	});

	$('#investorMyRecommendAchievement').mouseover(function() {
		$('#investorMyRecommendAchievement').addClass("active");
		var imgUrl = "../resources/images/front/img/my_chengguo2.png";
		$('#myCollectionAchievementImg').attr("src", imgUrl);
	});

	$('#investorMyRecommendFundRequire').mouseover(function() {
		$('#investorMyRecommendFundRequire').addClass("active");
		var imgUrl = "../resources/images/front/img/my_project2.png";
		$('#myCompanyInfoImg').attr("src", imgUrl);
	});

	$('#investorMyRecommendResearchGroup').mouseover(function() {
		$('#investorMyRecommendResearchGroup').addClass("active");
		var imgUrl = "../resources/images/front/img/my_tuandui2.png";
		$('#myCollectionResearchGroupImg').attr("src", imgUrl);
	});

	$('#researchGroupMyCollectionInvestor').mouseover(function() {
		$('#researchGroupMyCollectionInvestor').addClass("active");
		var imgUrl = "../resources/images/front/img/my_shouzhifang2.png";
		$('#myCollectionInvestorImg').attr("src", imgUrl);
	});
	
	$('#investorUpdateMyPassword').mouseover(function() {
		$('#investorUpdateMyPassword').addClass("active");
		var imgUrl = "../resources/images/front/img/my_change2.png";
		$('#updateMyPasswordImg').attr("src", imgUrl);
	});
	
	//点击事件
	$('#investorMyRecommend').click(function() {
		$('#leftBtns').find('li').removeClass("active");
		$('#investorMyRecommend').addClass("active");
		var imgUrl = "../resources/images/front/img/my_tuijian2.png";
		$('#myrecommendImg').attr("src", imgUrl);
	});

	$('#investorMyRecommendAchievement').click(function() {
		$('#leftBtns').find('li').removeClass("active");
		$('#investorMyRecommendAchievement').addClass("active");
		var imgUrl = "../resources/images/front/img/my_chengguo2.png";
		$('#myCollectionAchievementImg').attr("src", imgUrl);
	});

	$('#investorMyRecommendFundRequire').click(function() {
		$('#leftBtns').find('li').removeClass("active");
		$('#investorMyRecommendFundRequire').addClass("active");
		var imgUrl = "../resources/images/front/img/my_project2.png";
		$('#myCompanyInfoImg').attr("src", imgUrl);
	});

	$('#investorMyRecommendResearchGroup').click(function() {
		$('#leftBtns').find('li').removeClass("active");
		$('#investorMyRecommendResearchGroup').addClass("active");
		var imgUrl = "../resources/images/front/img/my_tuandui2.png";
		$('#myCollectionResearchGroupImg').attr("src", imgUrl);
	});
	
	$('#researchGroupMyCollectionInvestor').click(function() {
		$('#leftBtns').find('li').removeClass("active");
		$('#researchGroupMyCollectionInvestor').addClass("active");
		var imgUrl = "../resources/images/front/img/my_shouzhifang2.png";
		$('#myCollectionInvestorImg').attr("src", imgUrl);
	});

	$('#investorUpdateMyPassword').click(function() {
		$('#leftBtns').find('li').removeClass("active");
		$('#investorUpdateMyPassword').addClass("active");
		var imgUrl = "../resources/images/front/img/my_change2.png";
		$('#updateMyPasswordImg').attr("src", imgUrl);
	});

	//移出
	$('#investorMyRecommend').mouseout(function() {
		if(buttonSelector !== '#investorMyRecommend') {
			$('#investorMyRecommend').removeClass("active");
			var imgUrl = "../resources/images/front/img/my_tuijian.png";
			$('#myrecommendImg').attr("src", imgUrl);
		}
	});

	$('#investorMyRecommendAchievement').mouseout(function() {
		if(buttonSelector !== '#investorMyRecommendAchievement') {
			var active = $('#investorMyRecommendAchievement').removeClass('active');
			var imgUrl = "../resources/images/front/img/my_chengguo.png";
			$('#myCollectionAchievementImg').attr("src", imgUrl);
		}
	});

	$('#investorMyRecommendFundRequire').mouseout(function() {
		if(buttonSelector !== '#investorMyRecommendFundRequire') {
			$('#investorMyRecommendFundRequire').removeClass("active");
			var imgUrl = "../resources/images/front/img/my_project.png";
			$('#myCompanyInfoImg').attr("src", imgUrl);
		}
	});

	$('#investorMyRecommendResearchGroup').mouseout(function() {
		if(buttonSelector !== '#investorMyRecommendResearchGroup') {
			$('#investorMyRecommendResearchGroup').removeClass("active");
			var imgUrl = "../resources/images/front/img/my_tuandui.png";
			$('#myCollectionResearchGroupImg').attr("src", imgUrl);
		}
	});

	$('#researchGroupMyCollectionInvestor').mouseout(function() {
		if(buttonSelector !== '#researchGroupMyCollectionInvestor') {
			$('#researchGroupMyCollectionInvestor').removeClass("active");
			var imgUrl = "../resources/images/front/img/my_shouzhifang.png";
			$('#myCollectionInvestorImg').attr("src", imgUrl);
		}
	});
	
	$('#investorUpdateMyPassword').mouseout(function() {
		if(buttonSelector !== '#investorUpdateMyPassword') {
			$('#investorUpdateMyPassword').removeClass("active");
			var imgUrl = "../resources/images/front/img/my_change.png";
			$('#updateMyPasswordImg').attr("src", imgUrl);
		}
	});
	$(buttonSelector).click();
};