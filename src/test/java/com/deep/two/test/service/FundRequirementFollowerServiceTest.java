package com.deep.two.test.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import com.deep.two.model.query.companyUser.FundRequirementFollowerCombineQueryModel;
import com.deep.two.model.result.QueryListReturnVo;
import com.deep.two.model.result.ResultModel;
import com.deep.two.orm.FundRequirementFollower;
import com.deep.two.orm.FundRequirementFollowerId;
import com.deep.two.test.BaseTest;
import com.deep.two.util.ViewException;
import com.deep.two.service.companyUser.FundRequirementFollowerService;

public class FundRequirementFollowerServiceTest extends BaseTest{
	
	@Autowired
	FundRequirementFollowerService FundRequirementFollowerService;
	
    @Test
    @Rollback(false)
    public void addTest() throws ViewException {
        FundRequirementFollower e = new FundRequirementFollower();
        FundRequirementFollowerId id = new FundRequirementFollowerId(this.getUser().getId(), this.getFundRequirement().getId(),"1");
        e.setId(id);
        e.setFundRequirement(getFundRequirement());
        e.setUser(this.getUser());
        e.setFollowerType("0");
        FundRequirementFollowerService.add(e , null, null);
    }
    
	@Test
    @Rollback(false)
    public void updateTest() throws ViewException {
    	FundRequirementFollower e = new FundRequirementFollower();
        FundRequirementFollowerId id = new FundRequirementFollowerId(this.getUser().getId(), this.getFundRequirement().getId(),"1");
        e.setId(id);
        e.setFundRequirement(getFundRequirement());
        e.setUser(this.getUser());
        e.setFollowerType("1");
        FundRequirementFollowerService.update(e , id, null, null);
    }
    
    @Test
    @Rollback(false)
    public void deleteTest() throws ViewException {
        FundRequirementFollowerId id = new FundRequirementFollowerId(this.getUser().getId(), this.getFundRequirement().getId(),"1");
        List<Serializable> list = new ArrayList<Serializable>();
        list.add(id);
        FundRequirementFollowerService.delete(list , null);
    }
    
    @Test
    @Rollback(false)
    public void queryTest() throws ViewException {
        FundRequirementFollowerCombineQueryModel model = new FundRequirementFollowerCombineQueryModel();
        model.setUserQueryModel(getUserQueryModel());
        model.setFundRequirementQueryModel(getFundRequirementQueryModel());
        model.setFundRequirementFollowerQueryModel(getFundRequirementFollowerQueryModel());

        QueryListReturnVo<? extends ResultModel> list = FundRequirementFollowerService.combineQueryList(model, null, null);
        System.out.println(list);
    }
}
