package com.deep.two.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.deep.two.model.ApproveModel;
import com.deep.two.model.RecommendModel;
import com.deep.two.model.query.authority.UserQueryModel;
import com.deep.two.model.query.companyUser.FundRequirementFollowerQueryModel;
import com.deep.two.model.query.companyUser.FundRequirementQueryModel;
import com.deep.two.model.query.companyUser.TechRequirementFollowerQueryModel;
import com.deep.two.model.query.companyUser.TechRequirementQueryModel;
import com.deep.two.model.query.investorUser.InvestorUserFollowerQueryModel;
import com.deep.two.model.query.investorUser.InvestorUserQueryModel;
import com.deep.two.model.query.researchUser.AchievementFollowerQueryModel;
import com.deep.two.model.query.researchUser.AchievementQueryModel;
import com.deep.two.model.query.researchUser.OrganizationUserQueryModel;
import com.deep.two.model.query.researchUser.ResearchGroupFollowerQueryModel;
import com.deep.two.model.query.researchUser.ResearchGroupQueryModel;
import com.deep.two.model.query.researchUser.UniversityUserQueryModel;
import com.deep.two.orm.Achievement;
import com.deep.two.orm.FundRequirement;
import com.deep.two.orm.InvestorFollowerId;
import com.deep.two.orm.InvestorUser;
import com.deep.two.orm.ResearchGroup;
import com.deep.two.orm.TechRequirement;
import com.deep.two.orm.User;

//指定测试用例的运行器 这里是指定了Junit4
@RunWith(SpringJUnit4ClassRunner.class)
//指定Spring的配置文件
@ContextConfiguration({ "classpath:spring/deep2-*.xml" })
//对所有的测试方法都使用事务，并在测试完成后回滚事务
@TransactionConfiguration(transactionManager = "transactionManager")
@Transactional
public class BaseTest {
	
	 public User getUser() {
		 User model = new User();
		 model.setId("1");
	     return model;
	  }
	 
	 public InvestorUser getInvestorUser() {
		 InvestorUser model = new InvestorUser();
	       model.setId("402880e4578ad04301578ad0baec0001");
	       return model;
	   }
   
   public UserQueryModel getUserQueryModel() {
	   UserQueryModel model = new UserQueryModel();
       model.setEmail("sxj@126.com");
       return model;
   }
   
   public InvestorUserQueryModel getInvestorUserQueryModel() {
	   InvestorUserQueryModel model = new InvestorUserQueryModel();
       model.setId("402880e4578ad04301578ad0baec0001");
       return model;
   }
   
   public ResearchGroup getResearchGroup() {
	   ResearchGroup model = new ResearchGroup();
       model.setId("1");
       return model;
   }
   
   public Achievement getAchievement() {
	   Achievement model = new Achievement();
       model.setId("402881e757147a970157176e2c250012");
       return model;
   }
   
   public FundRequirement getFundRequirement() {
	   FundRequirement model = new FundRequirement();
       model.setId("402881e757147a9701571757b41f000d");
       return model;
	}
   
   public TechRequirement getTechRequirement() {
	   TechRequirement model = new TechRequirement();
       model.setId("402881e757147a97015717558989000a");
       return model;
	}
   
   public InvestorUserFollowerQueryModel getInvestorUserFollowerQueryModel() {
	   InvestorUserFollowerQueryModel model = new InvestorUserFollowerQueryModel();
       return model;
   }
   
   public UniversityUserQueryModel getUniversityUserQueryModel() {
	   UniversityUserQueryModel universityUserQueryModel = new UniversityUserQueryModel();
	   return universityUserQueryModel;
   }

   public OrganizationUserQueryModel getOrganizationUserQueryModel() {
	   OrganizationUserQueryModel organizationUserQueryModel = new OrganizationUserQueryModel();
	   return organizationUserQueryModel;
   }

   public ResearchGroupQueryModel getResearchGroupQueryModel() {
	   ResearchGroupQueryModel researchGroupQueryModel = new ResearchGroupQueryModel();
	   researchGroupQueryModel.setName("科研团队");
	   researchGroupQueryModel.setRecommendFlag("1");
	   return researchGroupQueryModel;
   }
   
   public ResearchGroupFollowerQueryModel getResearchGroupFollowerQueryModel() {
	   ResearchGroupFollowerQueryModel researchGroupQueryModel = new ResearchGroupFollowerQueryModel();
	   return researchGroupQueryModel;
   }
   
   public AchievementQueryModel getAchievementQueryModel() {
	   AchievementQueryModel researchGroupQueryModel = new AchievementQueryModel();
	   researchGroupQueryModel.setName("2222");
	   return researchGroupQueryModel;
   }
   
   public AchievementFollowerQueryModel getAchievementFollowerQueryModel() {
	   AchievementFollowerQueryModel researchGroupQueryModel = new AchievementFollowerQueryModel();
	   return researchGroupQueryModel;
   }
   
   public FundRequirementQueryModel getFundRequirementQueryModel() {
	   FundRequirementQueryModel researchGroupQueryModel = new FundRequirementQueryModel();
	   researchGroupQueryModel.setName("22");
	   return researchGroupQueryModel;
	}
	
   public FundRequirementFollowerQueryModel getFundRequirementFollowerQueryModel() {
	   FundRequirementFollowerQueryModel researchGroupQueryModel = new FundRequirementFollowerQueryModel();
	   return researchGroupQueryModel;
	}
   
   public TechRequirementQueryModel getTechRequirementQueryModel() {
	   TechRequirementQueryModel researchGroupQueryModel = new TechRequirementQueryModel();
	   researchGroupQueryModel.setName("22");
	   return researchGroupQueryModel;
	}
	
   public TechRequirementFollowerQueryModel getTechRequirementFollowerQueryModel() {
	   TechRequirementFollowerQueryModel researchGroupQueryModel = new TechRequirementFollowerQueryModel();
	   return researchGroupQueryModel;
	}
   
   public ApproveModel getApproveModel() {
	   ApproveModel model = new ApproveModel();
	   List<Serializable> idList = new ArrayList<Serializable>();
	   idList.add("1");
	   model.setIdList(idList);
	   model.setCommunicateStatus("2");
	   model.setStatus("2");
	   model.setRemark("测试");
	   return model;
	}
   
   public RecommendModel getRecommendModel() {
	   RecommendModel model = new RecommendModel();
	   List<Serializable> idList = new ArrayList<Serializable>();
	   idList.add("1");
	   model.setIdList(idList);
	   model.setSeqNum("20");
	   return model;
	}
}
