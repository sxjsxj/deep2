package com.deep.two.model.query.companyUser;

import com.deep.two.dao.util.Operator;
import com.deep.two.model.query.QueryModel;

public class FundRequirementFollowerIdQueryModel extends QueryModel {
    private String userId;
    private String userIdOperator = Operator.IN;

    private String requirementId;
    private String requirementIdOperator = Operator.IN;

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

    public String getRequirementId() {
        return requirementId;
    }

    public void setRequirementId(String requirementId) {
        this.requirementId = requirementId;
    }

    public String getRequirementIdOperator() {
        return requirementIdOperator;
    }

    public void setRequirementIdOperator(String requirementIdOperator) {
        this.requirementIdOperator = requirementIdOperator;
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
