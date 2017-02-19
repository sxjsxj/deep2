package com.deep.two.test.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import com.deep.two.model.query.companyUser.TechRequirementFollowerCombineQueryModel;
import com.deep.two.model.result.QueryListReturnVo;
import com.deep.two.model.result.ResultModel;
import com.deep.two.orm.TechRequirementFollower;
import com.deep.two.orm.TechRequirementFollowerId;
import com.deep.two.test.BaseTest;
import com.deep.two.util.ViewException;
import com.deep.two.service.companyUser.TechRequirementFollowerService;

public class TechRequirementFollowerServiceTest extends BaseTest{
	
	@Autowired
	TechRequirementFollowerService TechRequirementFollowerService;
	
    @Test
    @Rollback(false)
    public void addTest() throws ViewException {
        TechRequirementFollower e = new TechRequirementFollower();
        TechRequirementFollowerId id = new TechRequirementFollowerId(this.getUser().getId(), this.getTechRequirement().getId(),"1");
        e.setId(id);
        e.setTechRequirement(getTechRequirement());
        e.setUser(this.getUser());
        e.setFollowerType("0");
        TechRequirementFollowerService.add(e , null, null);
    }
    
	@Test
    @Rollback(false)
    public void updateTest() throws ViewException {
    	TechRequirementFollower e = new TechRequirementFollower();
        TechRequirementFollowerId id = new TechRequirementFollowerId(this.getUser().getId(), this.getTechRequirement().getId(),"1");
        e.setId(id);
        e.setTechRequirement(getTechRequirement());
        e.setUser(this.getUser());
        e.setFollowerType("1");
        TechRequirementFollowerService.update(e , id, null, null);
    }
    
    @Test
    @Rollback(false)
    public void deleteTest() throws ViewException {
        TechRequirementFollowerId id = new TechRequirementFollowerId(this.getUser().getId(), this.getTechRequirement().getId(),"1");
        List<Serializable> list = new ArrayList<Serializable>();
        list.add(id);
        TechRequirementFollowerService.delete(list , null);
    }
    
    @Test
    @Rollback(false)
    public void queryTest() throws ViewException {
        TechRequirementFollowerCombineQueryModel model = new TechRequirementFollowerCombineQueryModel();
        model.setUserQueryModel(getUserQueryModel());
        model.setTechRequirementQueryModel(getTechRequirementQueryModel());
        model.setTechRequirementFollowerQueryModel(getTechRequirementFollowerQueryModel());

        QueryListReturnVo<? extends ResultModel> list = TechRequirementFollowerService.combineQueryList(model, null, null);
        System.out.println(list);
    }
}
