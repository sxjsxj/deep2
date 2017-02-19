package com.deep.two.test.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.deep.two.dao.researchUser.ResearchGroupDAO;
import com.deep.two.model.query.investorUser.InvestorUserFollowerCombineQueryModel;
import com.deep.two.model.query.investorUser.InvestorUserFollowerQueryModel;
import com.deep.two.model.query.researchUser.ResearchGroupCombineQueryModel;
import com.deep.two.model.result.QueryListReturnVo;
import com.deep.two.model.result.ResultModel;
import com.deep.two.orm.InvestorFollower;
import com.deep.two.orm.InvestorFollowerId;
import com.deep.two.orm.InvestorUser;
import com.deep.two.orm.User;
import com.deep.two.service.investorUser.InvestorUserFollowerService;
import com.deep.two.test.BaseTest;
import com.deep.two.util.ViewException;

public class InvestorUserFollowerServiceTest extends BaseTest{
	
	@Autowired
	InvestorUserFollowerService investorUserFollowerService;
	
    @Test
    @Rollback(false)
    public void addTest() throws ViewException {
        InvestorFollower e = new InvestorFollower();
        InvestorFollowerId id = new InvestorFollowerId(this.getUser().getId(), this.getInvestorUser().getId(),"1");
        e.setId(id);
        e.setInvestorUser(this.getInvestorUser());
        e.setUser(this.getUser());
        e.setFollowerType("0");
        investorUserFollowerService.add(e , null, null);
    }
    
    @Test
    @Rollback(false)
    public void updateTest() throws ViewException {
        InvestorFollower e = new InvestorFollower();
        InvestorFollowerId id = new InvestorFollowerId(this.getUser().getId(), this.getInvestorUser().getId(),"1");
        e.setId(id);
        e.setInvestorUser(this.getInvestorUser());
        e.setUser(this.getUser());
        e.setFollowerType("0");
        investorUserFollowerService.update(e , id, null, null);
    }
    
    @Test
    @Rollback(false)
    public void deleteTest() throws ViewException {
        InvestorFollowerId id = new InvestorFollowerId(this.getUser().getId(), this.getInvestorUser().getId(),"1");
        List<Serializable> list = new ArrayList<Serializable>();
        list.add(id);
        investorUserFollowerService.delete(list , null);
    }
    
    @Test
    @Rollback(false)
    public void queryTest() throws ViewException {
        InvestorUserFollowerCombineQueryModel model = new InvestorUserFollowerCombineQueryModel();
        model.setUserQueryModel(getUserQueryModel());
        model.setInvestorUserQueryModel(getInvestorUserQueryModel());
        model.setInvestorUserFollowerQueryModel(getInvestorUserFollowerQueryModel());

        QueryListReturnVo<? extends ResultModel> list = investorUserFollowerService.combineQueryList(model, null, null);
        System.out.println(list);
    }
}
