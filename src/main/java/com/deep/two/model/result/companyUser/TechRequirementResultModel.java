package com.deep.two.model.result.companyUser;

import com.deep.two.model.result.FollowerModel;
import com.deep.two.model.result.ResultModel;

public class TechRequirementResultModel extends FollowerModel implements ResultModel {
	private String id;
	private CompanyUserResultModel companyUserResultModel;
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
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getCooperationType() {
		return cooperationType;
	}
	public void setCooperationType(String cooperationType) {
		this.cooperationType = cooperationType;
	}
	public String getSimilarProduct() {
		return similarProduct;
	}
	public void setSimilarProduct(String similarProduct) {
		this.similarProduct = similarProduct;
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
