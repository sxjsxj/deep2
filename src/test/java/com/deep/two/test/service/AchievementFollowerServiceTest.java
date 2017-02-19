package com.deep.two.test.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import com.deep.two.model.query.researchUser.AchievementFollowerCombineQueryModel;
import com.deep.two.model.result.QueryListReturnVo;
import com.deep.two.model.result.ResultModel;
import com.deep.two.orm.AchievementFollower;
import com.deep.two.orm.AchievementFollowerId;
import com.deep.two.test.BaseTest;
import com.deep.two.util.ViewException;
import com.deep.two.service.researchUser.AchievementFollowerService;

public class AchievementFollowerServiceTest extends BaseTest{
	
	@Autowired
	AchievementFollowerService AchievementFollowerService;
	
    @Test
    @Rollback(false)
    public void addTest() throws ViewException {
        AchievementFollower e = new AchievementFollower();
        AchievementFollowerId id = new AchievementFollowerId(
        		this.getUser().getId(), this.getAchievement().getId(),"1");
        e.setId(id);
        e.setFollowerType("0");
        AchievementFollowerService.add(e , null, null);
    }
    
    @Test
    @Rollback(false)
    public void updateTest() throws ViewException {
    	AchievementFollower e = new AchievementFollower();
        AchievementFollowerId id = new AchievementFollowerId(this.getUser().getId(), this.getAchievement().getId(),"1");
        e.setId(id);
        e.setAchievement(getAchievement());
        e.setUser(this.getUser());
        e.setFollowerType("1");
        id.setRelationType("1");
        AchievementFollowerService.update(e , id, null, null);
    }
    
    @Test
    @Rollback(false)
    public void deleteTest() throws ViewException {
        AchievementFollowerId id = new AchievementFollowerId(this.getUser().getId(), this.getAchievement().getId(),"1");
        List<Serializable> list = new ArrayList<Serializable>();
        list.add(id);
        AchievementFollowerService.delete(list , null);
    }
    
    @Test
    @Rollback(false)
    public void queryTest() throws ViewException {
        AchievementFollowerCombineQueryModel model = new AchievementFollowerCombineQueryModel();
        model.setUserQueryModel(getUserQueryModel());
        model.setAchievementQueryModel(getAchievementQueryModel());
        model.setAchievementFollowerQueryModel(getAchievementFollowerQueryModel());

        QueryListReturnVo<? extends ResultModel> list = AchievementFollowerService.combineQueryList(model, null, null);
        System.out.println(list);
    }
}
