package com.deep.two.model.query.companyUser;

import com.deep.two.dao.util.Operator;
import com.deep.two.model.query.QueryModel;

public class TechRequirementFollowerQueryModel extends QueryModel {
	private TechRequirementFollowerIdQueryModel techRequirementFollowerIdQueryModel;
    private String followerType;
    private String followerTypeOperator = Operator.IN;

    private String content;
    private String contentOperator = Operator.LK;
    
    private String status;
	private String statusOperator = Operator.IN;

    private String communicateStatus;
    private String communicateStatusOperator = Operator.IN;

    private String remark;
    private String remarkOperator = Operator.LK;

    public String getFollowerType() {
        return followerType;
    }

    public void setFollowerType(String followerType) {
        this.followerType = followerType;
    }

    public String getFollowerTypeOperator() {
        return followerTypeOperator;
    }

    public void setFollowerTypeOperator(String followerTypeOperator) {
        this.followerTypeOperator = followerTypeOperator;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContentOperator() {
        return contentOperator;
    }

    public void setContentOperator(String contentOperator) {
        this.contentOperator = contentOperator;
    }

    public String getCommunicateStatus() {
        return communicateStatus;
    }

    public void setCommunicateStatus(String communicateStatus) {
        this.communicateStatus = communicateStatus;
    }

    public String getCommunicateStatusOperator() {
        return communicateStatusOperator;
    }

    public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusOperator() {
		return this.statusOperator;
	}

	public void setStatusOperator(String statusOperator) {
		this.statusOperator = statusOperator;
	}

	public void setCommunicateStatusOperator(String communicateStatusOperator) {
        this.communicateStatusOperator = communicateStatusOperator;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemarkOperator() {
        return remarkOperator;
    }

    public void setRemarkOperator(String remarkOperator) {
        this.remarkOperator = remarkOperator;
    }

	public TechRequirementFollowerIdQueryModel getTechRequirementFollowerIdQueryModel() {
		return this.techRequirementFollowerIdQueryModel;
	}

	public void setTechRequirementFollowerIdQueryModel(
			TechRequirementFollowerIdQueryModel techRequirementFollowerIdQueryModel) {
		this.techRequirementFollowerIdQueryModel = techRequirementFollowerIdQueryModel;
	}

}
