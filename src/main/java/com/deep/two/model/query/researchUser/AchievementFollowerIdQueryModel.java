package com.deep.two.model.query.researchUser;

import com.deep.two.dao.util.Operator;
import com.deep.two.model.query.QueryModel;

public class AchievementFollowerIdQueryModel extends QueryModel {
    private String userId;
    private String userIdOperator = Operator.IN;

    private String achievementId;
    private String achievementIdOperator = Operator.IN;

    private String relationType;
    private String relationTypeOperator = Operator.IN;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserIdOperator() {
        return userIdOperator;
    }

    public void setUserIdOperator(String userIdOperator) {
        this.userIdOperator = userIdOperator;
    }

    public String getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(String achievementId) {
        this.achievementId = achievementId;
    }

    public String getAchievementIdOperator() {
        return achievementIdOperator;
    }

    public void setAchievementIdOperator(String achievementIdOperator) {
        this.achievementIdOperator = achievementIdOperator;
    }

    public String getRelationType() {
        return relationType;
    }

    public void setRelationType(String relationType) {
        this.relationType = relationType;
    }

    public String getRelationTypeOperator() {
        return relationTypeOperator;
    }

    public void setRelationTypeOperator(String relationTypeOperator) {
        this.relationTypeOperator = relationTypeOperator;
    }
}
