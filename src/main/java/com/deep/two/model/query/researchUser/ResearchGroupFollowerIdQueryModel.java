package com.deep.two.model.query.researchUser;

import com.deep.two.dao.util.Operator;
import com.deep.two.model.query.QueryModel;

public class ResearchGroupFollowerIdQueryModel extends QueryModel {
    private String userId;
    private String userIdOperator = Operator.IN;

    private String researchId;
    private String researchIdOperator = Operator.IN;

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

    public String getResearchId() {
        return researchId;
    }

    public void setResearchId(String researchId) {
        this.researchId = researchId;
    }

    public String getResearchIdOperator() {
        return researchIdOperator;
    }

    public void setResearchIdOperator(String researchIdOperator) {
        this.researchIdOperator = researchIdOperator;
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
