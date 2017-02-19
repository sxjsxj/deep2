package com.deep.two.model.result.researchUser;

import com.deep.two.model.result.FollowerModel;
import com.deep.two.model.result.ResultModel;

public class AchievementResultModel extends FollowerModel implements ResultModel {
	private String id;
	private ResearchGroupResultModel researchGroupResultModel;
	private String logoUrl;
	private String name;
	private String domain;
	private String type;
	private String patent;
	private String patenter;
	private String amount;
	private String solution;
	private String phase;
	private String applyTo;
	private String expectedEffect;
	private Integer caseNum;
	private String caseDetail;
	private String cooperationType;
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
	public String getLogoUrl() {
		return logoUrl;
	}
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
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
	public ResearchGroupResultModel getResearchGroupResultModel() {
		return researchGroupResultModel;
	}
	public void setResearchGroupResultModel(ResearchGroupResultModel researchGroupResultModel) {
		this.researchGroupResultModel = researchGroupResultModel;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPatent() {
		return patent;
	}
	public void setPatent(String patent) {
		this.patent = patent;
	}
	public String getPatenter() {
		return patenter;
	}
	public void setPatenter(String patenter) {
		this.patenter = patenter;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getSolution() {
		return solution;
	}
	public void setSolution(String solution) {
		this.solution = solution;
	}
	public String getPhase() {
		return phase;
	}
	public void setPhase(String phase) {
		this.phase = phase;
	}
	public String getApplyTo() {
		return applyTo;
	}
	public void setApplyTo(String applyTo) {
		this.applyTo = applyTo;
	}
	public String getExpectedEffect() {
		return expectedEffect;
	}
	public void setExpectedEffect(String expectedEffect) {
		this.expectedEffect = expectedEffect;
	}
	public Integer getCaseNum() {
		return caseNum;
	}
	public void setCaseNum(Integer caseNum) {
		this.caseNum = caseNum;
	}
	public String getCaseDetail() {
		return caseDetail;
	}
	public void setCaseDetail(String caseDetail) {
		this.caseDetail = caseDetail;
	}
	public String getCooperationType() {
		return cooperationType;
	}
	public void setCooperationType(String cooperationType) {
		this.cooperationType = cooperationType;
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
