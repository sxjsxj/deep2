package com.deep.two.model.query.companyUser;

import com.deep.two.dao.util.Operator;
import com.deep.two.model.query.QueryModel;

public class FundRequirementQueryModel extends QueryModel {
	private String id;
	private String idOperator = Operator.IN;

	private String name;
	private String nameOperator = Operator.LK;

	private String domain;
	private String domainOperator = Operator.IN;

	private String contactName;
	private String contactNameOperator = Operator.LK;

	private String projectName;
	private String projectNameOperator = Operator.LK;
	
	private String projectPhase;
	private String projectPhaseOperator = Operator.IN;
	
	private String amountNeeded;
	private String amountNeededOperator = Operator.IN;
	
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

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	
	public String getContactNameOperator() {
		return contactNameOperator;
	}

	public void setContactNameOperator(String contactNameOperator) {
		this.contactNameOperator = contactNameOperator;
	}

	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectNameOperator() {
		return this.projectNameOperator;
	}

	public void setProjectNameOperator(String projectNameOperator) {
		this.projectNameOperator = projectNameOperator;
	}

	public String getProjectPhase() {
		return this.projectPhase;
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

	public void setProjectPhase(String projectPhase) {
		this.projectPhase = projectPhase;
	}

	public String getProjectPhaseOperator() {
		return this.projectPhaseOperator;
	}

	public void setProjectPhaseOperator(String projectPhaseOperator) {
		this.projectPhaseOperator = projectPhaseOperator;
	}

	public String getAmountNeeded() {
		return this.amountNeeded;
	}

	public void setAmountNeeded(String amountNeeded) {
		this.amountNeeded = amountNeeded;
	}

	public String getAmountNeededOperator() {
		return this.amountNeededOperator;
	}

	public void setAmountNeededOperator(String amountNeededOperator) {
		this.amountNeededOperator = amountNeededOperator;
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
