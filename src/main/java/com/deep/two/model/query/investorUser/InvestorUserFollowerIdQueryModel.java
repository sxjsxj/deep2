package com.deep.two.model.query.investorUser;

import com.deep.two.dao.util.Operator;
import com.deep.two.model.query.QueryModel;

public class InvestorUserFollowerIdQueryModel extends QueryModel {
    private String userId;
    private String userIdOperator = Operator.IN;

    private String investorId;
    private String investorIdOperator = Operator.IN;

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

	public String getInvestorId() {
		return this.investorId;
	}

	public void setInvestorId(String investorId) {
		this.investorId = investorId;
	}

	public String getInvestorIdOperator() {
		return this.investorIdOperator;
	}

	public void setInvestorIdOperator(String investorIdOperator) {
		this.investorIdOperator = investorIdOperator;
	}
}
