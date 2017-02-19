package com.deep.two.test.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import com.deep.two.dao.researchUser.ResearchGroupDAO;
import com.deep.two.model.ApproveModel;
import com.deep.two.model.query.researchUser.ResearchGroupCombineQueryModel;
import com.deep.two.model.result.QueryListReturnVo;
import com.deep.two.model.result.ResultModel;
import com.deep.two.test.BaseTest;
import com.deep.two.util.ViewException;

//指定测试用例的运行器 这里是指定了Junit4
@RunWith(SpringJUnit4ClassRunner.class)
//指定Spring的配置文件
@ContextConfiguration({ "/deep2-context.xml" })
//对所有的测试方法都使用事务，并在测试完成后回滚事务
@TransactionConfiguration(transactionManager = "transactionManager")
@Transactional
public class ResearchGroupServiceImplTest extends BaseTest {

	@Autowired
	ResearchGroupDAO researchGroupDAO;

    @Test
    public void queryTest() throws ViewException {
        QueryListReturnVo<? extends ResultModel> list = null;
        ResearchGroupCombineQueryModel model = new ResearchGroupCombineQueryModel();
        model.setUserQueryModel(this.getUserQueryModel());
        model.setOrganizationUserQueryModel(getOrganizationUserQueryModel());
        model.setUniversityUserQueryModel(getUniversityUserQueryModel());
        model.setResearchGroupQueryModel(getResearchGroupQueryModel());
        
        list = researchGroupDAO.combineQueryList(model, null, null);
        System.out.println(list);
        
    }
    
    @Test
    @Rollback(false)
    public void approveTest() throws ViewException {
		researchGroupDAO.approve(getApproveModel(), null);
    }
    
    @Test
    @Rollback(false)
    public void recommendTest() throws ViewException {
		researchGroupDAO.recommend(getRecommendModel(), null);
    }
}
