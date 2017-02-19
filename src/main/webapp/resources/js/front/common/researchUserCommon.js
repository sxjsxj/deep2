function setLeftNav(buttonSelector){
	//鼠标移向
	$('#researchGroupMyReserachGroup').mouseover(function() {
		$('#researchGroupMyReserachGroup').addClass("active");
		var imgUrl="../resources/images/front/img/my_tuandui2.png";
		$('#myCollectionResearchGroupImg').attr("src",imgUrl);
    });
	
	$('#researchGroupMyAchievement').mouseover(function() {
		$('#researchGroupMyAchievement').addClass("active");
		var imgUrl="../resources/images/front/img/my_chengguo2.png";
		$('#myCollectionAchievementImg').attr("src",imgUrl);
    });
	
	$('#researchGroupMyRecommend').mouseover(function() {
		$('#researchGroupMyRecommend').addClass("active");
		var imgUrl="../resources/images/front/img/my_tuijian2.png";
		$('#myrecommendImg').attr("src",imgUrl);
    });
	
	$('#researchGroupMyCollectionTechRequirement').mouseover(function() {
		$('#researchGroupMyCollectionTechRequirement').addClass("active");
		var imgUrl="../resources/images/front/img/my_xuqiu2.png";
		$('#myreqImg').attr("src",imgUrl);
    });
	
	$('#researchGroupMyCollectionInvestor').mouseover(function() {
		$('#researchGroupMyCollectionInvestor').addClass("active");
		var imgUrl="../resources/images/front/img/my_shouzhifang2.png";
		$('#myCollectionInvestorImg').attr("src",imgUrl);
    });
	
	$('#researchGroupMyInfo').mouseover(function() {
		$('#researchGroupMyInfo').addClass("active");
		var imgUrl="../resources/images/front/img/my_info2.png";
		$('#myCompanyInfoImg').attr("src",imgUrl);
    });
	
	$('#researchGroupUpdateMyPassword').mouseover(function() {
		$('#researchGroupUpdateMyPassword').addClass("active");
		var imgUrl="../resources/images/front/img/my_change2.png";
		$('#updateMyPasswordImg').attr("src",imgUrl);
    });
	
	//移出
	$('#researchGroupMyReserachGroup').mouseout(function() {
		if(buttonSelector !== '#researchGroupMyReserachGroup') {
			$('#researchGroupMyReserachGroup').removeClass("active");
			var imgUrl="../resources/images/front/img/my_tuandui.png";
			$('#myCollectionResearchGroupImg').attr("src",imgUrl);
		}
    });
	
	$('#researchGroupMyAchievement').mouseout(function() {
		if(buttonSelector !== '#researchGroupMyAchievement') {
			$('#researchGroupMyAchievement').removeClass("active");
			var imgUrl="../resources/images/front/img/my_chengguo.png";
			$('#myCollectionAchievementImg').attr("src",imgUrl);
		}
    });
	
	$('#researchGroupMyRecommend').mouseout(function() {
		if(buttonSelector !== '#researchGroupMyRecommend') {
			$('#researchGroupMyRecommend').removeClass("active");
			var imgUrl="../resources/images/front/img/my_tuijian.png";
			$('#myrecommendImg').attr("src",imgUrl);
		}
    });
	
	$('#researchGroupMyCollectionTechRequirement').mouseout(function() {
		if(buttonSelector !== '#researchGroupMyCollectionTechRequirement') {
			$('#researchGroupMyCollectionTechRequirement').removeClass("active");
			var imgUrl="../resources/images/front/img/my_xuqiu.png";
			$('#myreqImg').attr("src",imgUrl);
		}
    });
	
	$('#researchGroupMyCollectionInvestor').mouseout(function() {
		if(buttonSelector !== '#researchGroupMyCollectionInvestor') {
			$('#researchGroupMyCollectionInvestor').removeClass("active");
			var imgUrl="../resources/images/front/img/my_shouzhifang.png";
			$('#myCollectionInvestorImg').attr("src",imgUrl);
		}
    });
	
	$('#researchGroupMyInfo').mouseout(function() {
		if(buttonSelector !== '#researchGroupMyInfo') {
			$('#researchGroupMyInfo').removeClass("active");
			var imgUrl="../resources/images/front/img/my_info.png";
			$('#myCompanyInfoImg').attr("src",imgUrl);
		}
    });
	$('#researchGroupUpdateMyPassword').mouseout(function() {
		if(buttonSelector !== '#researchGroupUpdateMyPassword') {
			$('#researchGroupUpdateMyPassword').removeClass("active");
			var imgUrl="../resources/images/front/img/my_change.png";
			$('#updateMyPasswordImg').attr("src",imgUrl);
		}
    });

	//点击事件
	$('#researchGroupMyReserachGroup').click(function() {
		$('#leftBtns').find('li').removeClass('active');
		$('#researchGroupMyReserachGroup').addClass("active");
		var imgUrl="../resources/images/front/img/my_tuandui2.png";
		$('#myCollectionResearchGroupImg').attr("src",imgUrl);
    });
	
	$('#researchGroupMyAchievement').click(function() {
		$('#leftBtns').find('li').removeClass('active');
		$('#researchGroupMyAchievement').addClass("active");
		var imgUrl="../resources/images/front/img/my_chengguo2.png";
		$('#myCollectionAchievementImg').attr("src",imgUrl);
    });
	
	$('#researchGroupMyRecommend').click(function() {
		$('#leftBtns').find('li').removeClass('active');
		$('#researchGroupMyRecommend').addClass("active");
		var imgUrl="../resources/images/front/img/my_tuijian2.png";
		$('#myrecommendImg').attr("src",imgUrl);
    });
	
	$('#researchGroupMyCollectionTechRequirement').click(function() {
		$('#leftBtns').find('li').removeClass('active');
		$('#researchGroupMyCollectionTechRequirement').addClass("active");
		var imgUrl="../resources/images/front/img/my_xuqiu2.png";
		$('#myreqImg').attr("src",imgUrl);
    });
	
	$('#researchGroupMyCollectionInvestor').click(function() {
		$('#leftBtns').find('li').removeClass('active');
		$('#researchGroupMyCollectionInvestor').addClass("active");
		var imgUrl="../resources/images/front/img/my_shouzhifang2.png";
		$('#myCollectionInvestorImg').attr("src",imgUrl);
    });
	
	$('#researchGroupMyInfo').click(function() {
		$('#leftBtns').find('li').removeClass('active');
		$('#researchGroupMyInfo').addClass("active");
		var imgUrl="../resources/images/front/img/my_info2.png";
		$('#myCompanyInfoImg').attr("src",imgUrl);
    });
	
	$('#researchGroupUpdateMyPassword').click(function() {
		$('#leftBtns').find('li').removeClass('active');
		$('#researchGroupUpdateMyPassword').addClass("active");
		var imgUrl="../resources/images/front/img/my_change2.png";
		$('#updateMyPasswordImg').attr("src",imgUrl);
    });
	
	$(buttonSelector).click();
};