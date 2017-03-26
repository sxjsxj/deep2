package com.deep.two.orm;

// Generated 2016-12-27 21:27:57 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * CompanyUser generated by hbm2java
 */
public class CompanyUser implements java.io.Serializable {

	private String id;
	private User user;
	private String logoUrl;
	private String name;
	private String domain;
	private String province;
	private String city;
	private String county;
	private String scale;
	private String productValue;
	private String nature;
	private String address;
	private String introduction;
	private String contactName;
	private String contactTel;
	private String contactEmail;
	private String contactTitle;
	private String attachUrl;
	private Date whenCreate;
	private String whoCreate;
	private Date whenLastUpdate;
	private String whoLastUpdate;
	private String status;
	private String communicateStatus;
	private String removeFlag;
	private String attachName;
	private Set<TechRequirement> techRequirements = new HashSet<TechRequirement>(
			0);
	private Set<FundRequirement> fundRequirements = new HashSet<FundRequirement>(
			0);

	public CompanyUser() {
	}

	public CompanyUser(String id, User user) {
		this.id = id;
		this.user = user;
	}

	public CompanyUser(String id, User user, String logoUrl, String name,
			String domain, String province, String city, String county,
			String scale, String productValue, String nature, String address,
			String introduction, String contactName, String contactTel,
			String contactEmail, String contactTitle, String attachUrl,
			Date whenCreate, String whoCreate, Date whenLastUpdate,
			String whoLastUpdate, String status, String communicateStatus,
			String removeFlag, String attachName,
			Set<TechRequirement> techRequirements,
			Set<FundRequirement> fundRequirements) {
		this.id = id;
		this.user = user;
		this.logoUrl = logoUrl;
		this.name = name;
		this.domain = domain;
		this.province = province;
		this.city = city;
		this.county = county;
		this.scale = scale;
		this.productValue = productValue;
		this.nature = nature;
		this.address = address;
		this.introduction = introduction;
		this.contactName = contactName;
		this.contactTel = contactTel;
		this.contactEmail = contactEmail;
		this.contactTitle = contactTitle;
		this.attachUrl = attachUrl;
		this.whenCreate = whenCreate;
		this.whoCreate = whoCreate;
		this.whenLastUpdate = whenLastUpdate;
		this.whoLastUpdate = whoLastUpdate;
		this.status = status;
		this.communicateStatus = communicateStatus;
		this.removeFlag = removeFlag;
		this.attachName = attachName;
		this.techRequirements = techRequirements;
		this.fundRequirements = fundRequirements;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getLogoUrl() {
		return this.logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
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

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return this.county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getScale() {
		return this.scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public String getProductValue() {
		return this.productValue;
	}

	public void setProductValue(String productValue) {
		this.productValue = productValue;
	}

	public String getNature() {
		return this.nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIntroduction() {
		return this.introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
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

	public String getContactTitle() {
		return this.contactTitle;
	}

	public void setContactTitle(String contactTitle) {
		this.contactTitle = contactTitle;
	}

	public String getAttachUrl() {
		return this.attachUrl;
	}

	public void setAttachUrl(String attachUrl) {
		this.attachUrl = attachUrl;
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
	public Set<TechRequirement> getTechRequirements() {
		return this.techRequirements;
	}

	public void setTechRequirements(Set<TechRequirement> techRequirements) {
		this.techRequirements = techRequirements;
	}

	public Set<FundRequirement> getFundRequirements() {
		return this.fundRequirements;
	}

	public void setFundRequirements(Set<FundRequirement> fundRequirements) {
		this.fundRequirements = fundRequirements;
	}

}
