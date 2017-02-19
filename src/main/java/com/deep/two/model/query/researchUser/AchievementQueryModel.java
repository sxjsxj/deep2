package com.deep.two.model.query.researchUser;

import com.deep.two.dao.util.Operator;
import com.deep.two.model.query.QueryModel;

public class AchievementQueryModel extends QueryModel {
    private String id;
    private String idOperator = Operator.IN;

    private String name;
    private String nameOperator = Operator.LK;

    private String domain;
    private String domainOperator = Operator.IN;

    private String amount;
    private String amountOperator = Operator.IN;

    private String phase;
    private String phaseOperator = Operator.IN;

    private String caseNum;
    private String caseNumOperator = Operator.IN;

    private String cooperationType;
    private String cooperationTypeOperator = Operator.MULTILK;

    private String sequenceNumber;
    private String sequenceNumberOperator = Operator.LK;

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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAmountOperator() {
        return amountOperator;
    }

    public void setAmountOperator(String amountOperator) {
        this.amountOperator = amountOperator;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public String getPhaseOperator() {
        return phaseOperator;
    }

    public void setPhaseOperator(String phaseOperator) {
        this.phaseOperator = phaseOperator;
    }

    public String getCaseNum() {
        return caseNum;
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

	public void setCaseNum(String caseNum) {
        this.caseNum = caseNum;
    }

    public String getCaseNumOperator() {
        return caseNumOperator;
    }

    public void setCaseNumOperator(String caseNumOperator) {
        this.caseNumOperator = caseNumOperator;
    }

    public String getCooperationType() {
        return cooperationType;
    }

    public void setCooperationType(String cooperationType) {
        this.cooperationType = cooperationType;
    }

    public String getCooperationTypeOperator() {
        return cooperationTypeOperator;
    }

    public void setCooperationTypeOperator(String cooperationTypeOperator) {
        this.cooperationTypeOperator = cooperationTypeOperator;
    }

    public String getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(String sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public String getSequenceNumberOperator() {
        return sequenceNumberOperator;
    }

    public void setSequenceNumberOperator(String sequenceNumberOperator) {
        this.sequenceNumberOperator = sequenceNumberOperator;
    }

    public String getStatus() {
        return status;
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
