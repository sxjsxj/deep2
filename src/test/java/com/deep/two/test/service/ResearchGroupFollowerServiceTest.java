package com.deep.two.test.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import com.deep.two.dao.researchUser.ResearchGroupDAO;
import com.deep.two.model.query.researchUser.ResearchGroupCombineQueryModel;
import com.deep.two.model.query.researchUser.ResearchGroupFollowerCombineQueryModel;
import com.deep.two.model.result.QueryListReturnVo;
import com.deep.two.model.result.ResultModel;
import com.deep.two.orm.InvestorFollower;
import com.deep.two.orm.InvestorFollowerId;
import com.deep.two.orm.InvestorUser;
import com.deep.two.orm.ResearchGroupFollower;
import com.deep.two.orm.ResearchGroupFollowerId;
import com.deep.two.orm.User;
import com.deep.two.test.BaseTest;
import com.deep.two.util.ViewException;
import com.deep.two.service.researchUser.ResearchGroupFollowerService;

public class ResearchGroupFollowerServiceTest extends BaseTest{
	
	@Autowired
	ResearchGroupFollowerService ResearchGroupFollowerService;
	
    @Test
    @Rollback(false)
    public void addTest() throws ViewException {
        ResearchGroupFollower e = new ResearchGroupFollower();
        ResearchGroupFollowerId id = new ResearchGroupFollowerId(this.getUser().getId(), this.getResearchGroup().getId(),"1");
        e.setId(id);
        e.setResearchGroup(getResearchGroup());
        e.setUser(this.getUser());
        e.setFollowerType("0");
        ResearchGroupFollowerService.add(e , null, null);
    }
    
    @Test
    @Rollback(false)
    public void updateTest() throws ViewException {
    	ResearchGroupFollower e = new ResearchGroupFollower();
        ResearchGroupFollowerId id = new ResearchGroupFollowerId(this.getUser().getId(), this.getResearchGroup().getId(),"1");
        e.setId(id);
        e.setResearchGroup(getResearchGroup());
        e.setUser(this.getUser());
        e.setFollowerType("1");
        ResearchGroupFollowerService.update(e , id,null, null);
    }
    
    @Test
    @Rollback(false)
    public void deleteTest() throws ViewException {
        ResearchGroupFollowerId id = new ResearchGroupFollowerId(this.getUser().getId(), this.getResearchGroup().getId(),"1");
        List<Serializable> list = new ArrayList<Serializable>();
        list.add(id);
        ResearchGroupFollowerService.delete(list , null);
    }
    
    @Test
    @Rollback(false)
    public void queryTest() throws ViewException {
        ResearchGroupFollowerCombineQueryModel model = new ResearchGroupFollowerCombineQueryModel();
        model.setUserQueryModel(getUserQueryModel());
        model.setResearchGroupQueryModel(getResearchGroupQueryModel());
        model.setResearchGroupFollowerQueryModel(getResearchGroupFollowerQueryModel());

        QueryListReturnVo<? extends ResultModel> list = ResearchGroupFollowerService.combineQueryList(model, null, null);
        System.out.println(list);
    }
}
