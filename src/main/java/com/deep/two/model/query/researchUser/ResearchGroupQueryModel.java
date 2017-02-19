package com.deep.two.model.query.researchUser;

import com.deep.two.dao.util.Operator;
import com.deep.two.model.query.QueryModel;

public class ResearchGroupQueryModel extends QueryModel {
    private String id;
    private String idOperator = Operator.IN;

    private String name;
    private String nameOperator = Operator.LK;

    private String domain;
    private String domainOperator = Operator.IN;

    private String field;
    private String fieldOperator = Operator.LK;

    private String leaderName;
    private String leaderNameOperator = Operator.LK;

    private String status;
    private String statusOperator = Operator.IN;

    private String communicateStatus;
    private String communicateStatusOperator = Operator.IN;

    private String remark;
    private String remarkOperator = Operator.LK;
    
    private String recommendFlag;
    private String recommendFlagOperator = Operator.EQ;

	private String seqNum;
    private String seqNumOperator = Operator.IN;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdOperator() {
        return idOperator;
    }

    public void setIdOperator(String idOperator) {
        this.idOperator = idOperator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameOperator() {
        return nameOperator;
    }

    public void setNameOperator(String nameOperator) {
        this.nameOperator = nameOperator;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getDomainOperator() {
        return domainOperator;
    }

    public void setDomainOperator(String domainOperator) {
        this.domainOperator = domainOperator;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getFieldOperator() {
        return fieldOperator;
    }

    public void setFieldOperator(String fieldOperator) {
        this.fieldOperator = fieldOperator;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public String getLeaderNameOperator() {
        return leaderNameOperator;
    }

    public void setLeaderNameOperator(String leaderNameOperator) {
        this.leaderNameOperator = leaderNameOperator;
    }

    public String getStatus() {
        return status;
    }

    public String getRecommendFlag() {
		return recommendFlag;
	}

	public void setRecommendFlag(String recommendFlag) {
		this.recommendFlag = recommendFlag;
	}

	public String getRecommendFlagOperator() {
		return recommendFlagOperator;
	}

	public void setRecommendFlagOperator(String recommendFlagOperator) {
		this.recommendFlagOperator = recommendFlagOperator;
	}

	public String getSeqNum() {
		return seqNum;
	}

	public void setSeqNum(String seqNum) {
		this.seqNum = seqNum;
	}

	public String getSeqNumOperator() {
		return seqNumOperator;
	}

	public void setSeqNumOperator(String seqNumOperator) {
		this.seqNumOperator = seqNumOperator;
	}

	public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusOperator() {
        return statusOperator;
    }

    public void setStatusOperator(String statusOperator) {
        this.statusOperator = statusOperator;
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
}
