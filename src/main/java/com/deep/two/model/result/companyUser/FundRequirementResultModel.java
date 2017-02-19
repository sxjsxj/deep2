package com.deep.two.model.result.companyUser;

import com.deep.two.model.result.FollowerModel;
import com.deep.two.model.result.ResultModel;

public class FundRequirementResultModel  extends FollowerModel implements ResultModel {
	private String id;
	private CompanyUserResultModel companyUserResultModel;
	private String name;
	private String domain;
	private String contactName;
	private String contactTel;
	private String contactEmail;
	private String projectName;
	private String projectTeam;
	private String projectIntro;
	private String projectPhase;
	private String projectProspect;
	private String amountNeeded;
	private String attachUrl;
	private String sequenceNumber;
	private String status;
	private String communicateStatus;
	private String remark;
	private Integer concernNumber;
	private Integer scanNumber;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public CompanyUserResultModel getCompanyUserResultModel() {
		return companyUserResultModel;
	}
	public void setCompanyUserResultModel(CompanyUserResultModel companyUserResultModel) {
		this.companyUserResultModel = companyUserResultModel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactTel() {
		return contactTel;
	}
	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectTeam() {
		return projectTeam;
	}
	public void setProjectTeam(String projectTeam) {
		this.projectTeam = projectTeam;
	}
	public String getProjectIntro() {
		return projectIntro;
	}
	public void setProjectIntro(String projectIntro) {
		this.projectIntro = projectIntro;
	}
	public String getProjectPhase() {
		return projectPhase;
	}
	public void setProjectPhase(String projectPhase) {
		this.projectPhase = projectPhase;
	}
	public String getProjectProspect() {
		return projectProspect;
	}
	public void setProjectProspect(String projectProspect) {
		this.projectProspect = projectProspect;
	}
	public String getAmountNeeded() {
		return amountNeeded;
	}
	public void setAmountNeeded(String amountNeeded) {
		this.amountNeeded = amountNeeded;
	}
	public String getAttachUrl() {
		return attachUrl;
	}
	public void setAttachUrl(String attachUrl) {
		this.attachUrl = attachUrl;
	}
	public String getSequenceNumber() {
		return sequenceNumber;
	}
	public void setSequenceNumber(String sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCommunicateStatus() {
		return communicateStatus;
	}
	public void setCommunicateStatus(String communicateStatus) {
		this.communicateStatus = communicateStatus;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getConcernNumber() {
		return concernNumber;
	}
	public void setConcernNumber(Integer concernNumber) {
		this.concernNumber = concernNumber;
	}
	public Integer getScanNumber() {
		return scanNumber;
	}
	public void setScanNumber(Integer scanNumber) {
		this.scanNumber = scanNumber;
	}
	
}
