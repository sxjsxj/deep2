package com.deep.two.orm;

// Generated 2016-12-27 21:27:57 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TechRequirement generated by hbm2java
 */
public class TechRequirement implements java.io.Serializable {

	private String id;
	private CompanyUser companyUser;
	private String name;
	private String domain;
	private String contactName;
	private String contactTel;
	private String contactEmail;
	private String amount;
	private String duration;
	private String type;
	private String detail;
	private String cooperationType;
	private String similarProduct;
	private String attachUrl;
	private String sequenceNumber;
	private String status;
	private String communicateStatus;
	private String remark;
	private Integer concernNumber;
	private Integer scanNumber;
	private String seqNum;
	private String recommendFlag;
	private String logoUrl;
	private Date whenCreate;
	private String whoCreate;
	private Date whenLastUpdate;
	private String whoLastUpdate;
	private String removeFlag;
	private String attachName;
	private Set<TechRequirementFollower> techRequirementFollowers = new HashSet<TechRequirementFollower>(
			0);

	public TechRequirement() {
	}

	public TechRequirement(String id, CompanyUser companyUser) {
		this.id = id;
		this.companyUser = companyUser;
	}

	public TechRequirement(String id, CompanyUser companyUser, String name,
			String domain, String contactName, String contactTel,
			String contactEmail, String amount, String duration, String type,
			String detail, String cooperationType, String similarProduct,
			String attachUrl, String sequenceNumber, String status,
			String communicateStatus, String remark, Integer concernNumber,
			Integer scanNumber, String seqNum, String recommendFlag,
			String logoUrl, Date whenCreate, String whoCreate,
			Date whenLastUpdate, String whoLastUpdate, String removeFlag,
			String attachName,
			Set<TechRequirementFollower> techRequirementFollowers) {
		this.id = id;
		this.companyUser = companyUser;
		this.name = name;
		this.domain = domain;
		this.contactName = contactName;
		this.contactTel = contactTel;
		this.contactEmail = contactEmail;
		this.amount = amount;
		this.duration = duration;
		this.type = type;
		this.detail = detail;
		this.cooperationType = cooperationType;
		this.similarProduct = similarProduct;
		this.attachUrl = attachUrl;
		this.sequenceNumber = sequenceNumber;
		this.status = status;
		this.communicateStatus = communicateStatus;
		this.remark = remark;
		this.concernNumber = concernNumber;
		this.scanNumber = scanNumber;
		this.seqNum = seqNum;
		this.recommendFlag = recommendFlag;
		this.logoUrl = logoUrl;
		this.whenCreate = whenCreate;
		this.whoCreate = whoCreate;
		this.whenLastUpdate = whenLastUpdate;
		this.whoLastUpdate = whoLastUpdate;
		this.removeFlag = removeFlag;
		this.attachName = attachName;
		this.techRequirementFollowers = techRequirementFollowers;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public CompanyUser getCompanyUser() {
		return this.companyUser;
	}

	public void setCompanyUser(CompanyUser companyUser) {
		this.companyUser = companyUser;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDomain() {
		return this.domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getContactName() {
		return this.contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactTel() {
		return this.contactTel;
	}

	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}

	public String getContactEmail() {
		return this.contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getAmount() {
		return this.amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getDuration() {
		return this.duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getCooperationType() {
		return this.cooperationType;
	}

	public void setCooperationType(String cooperationType) {
		this.cooperationType = cooperationType;
	}

	public String getSimilarProduct() {
		return this.similarProduct;
	}

	public void setSimilarProduct(String similarProduct) {
		this.similarProduct = similarProduct;
	}

	public String getAttachUrl() {
		return this.attachUrl;
	}

	public void setAttachUrl(String attachUrl) {
		this.attachUrl = attachUrl;
	}

	public String getSequenceNumber() {
		return this.sequenceNumber;
	}

	public void setSequenceNumber(String sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCommunicateStatus() {
		return this.communicateStatus;
	}

	public void setCommunicateStatus(String communicateStatus) {
		this.communicateStatus = communicateStatus;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getConcernNumber() {
		return this.concernNumber;
	}

	public void setConcernNumber(Integer concernNumber) {
		this.concernNumber = concernNumber;
	}

	public Integer getScanNumber() {
		return this.scanNumber;
	}

	public void setScanNumber(Integer scanNumber) {
		this.scanNumber = scanNumber;
	}

	public String getSeqNum() {
		return this.seqNum;
	}

	public void setSeqNum(String seqNum) {
		this.seqNum = seqNum;
	}

	public String getRecommendFlag() {
		return this.recommendFlag;
	}

	public void setRecommendFlag(String recommendFlag) {
		this.recommendFlag = recommendFlag;
	}

	public String getLogoUrl() {
		return this.logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	public Date getWhenCreate() {
		return this.whenCreate;
	}

	public void setWhenCreate(Date whenCreate) {
		this.whenCreate = whenCreate;
	}

	public String getWhoCreate() {
		return this.whoCreate;
	}

	public void setWhoCreate(String whoCreate) {
		this.whoCreate = whoCreate;
	}

	public Date getWhenLastUpdate() {
		return this.whenLastUpdate;
	}

	public void setWhenLastUpdate(Date whenLastUpdate) {
		this.whenLastUpdate = whenLastUpdate;
	}

	public String getWhoLastUpdate() {
		return this.whoLastUpdate;
	}

	public void setWhoLastUpdate(String whoLastUpdate) {
		this.whoLastUpdate = whoLastUpdate;
	}

	public String getRemoveFlag() {
		return this.removeFlag;
	}

	public void setRemoveFlag(String removeFlag) {
		this.removeFlag = removeFlag;
	}

	public String getAttachName() {
		return this.attachName;
	}
	public void setAttachName(String attachName) {
		this.attachName = attachName;
	}
	public Set<TechRequirementFollower> getTechRequirementFollowers() {
		return this.techRequirementFollowers;
	}

	public void setTechRequirementFollowers(
			Set<TechRequirementFollower> techRequirementFollowers) {
		this.techRequirementFollowers = techRequirementFollowers;
	}

}
