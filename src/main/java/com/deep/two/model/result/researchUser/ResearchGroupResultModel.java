package com.deep.two.model.result.researchUser;

import com.deep.two.model.result.FollowerModel;
import com.deep.two.model.result.ResultModel;

public class ResearchGroupResultModel extends FollowerModel implements ResultModel {
	private String id;
	private ResearchUserResultModel researchUserResultModel;
	private String logoUrl;
	private String name;
	private String domain;
	private String introduction;
	private Integer teamSize;
	private String field;
	private String experience;
	private String achievement;
	private String leaderUrl;
	private String leaderName;
	private String leaderTel;
	private String leaderEmail;
	private String leaderDepart;
	private String leaderTitle;
	private String leaderPosition;
	private String leaderIntro;
	private String leaderAchieve;
	private String teamOthers;
	private String attachUrl;
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
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public Integer getTeamSize() {
		return teamSize;
	}
	public void setTeamSize(Integer teamSize) {
		this.teamSize = teamSize;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getAchievement() {
		return achievement;
	}
	public void setAchievement(String achievement) {
		this.achievement = achievement;
	}
	public String getLeaderUrl() {
		return leaderUrl;
	}
	public void setLeaderUrl(String leaderUrl) {
		this.leaderUrl = leaderUrl;
	}
	public String getLeaderName() {
		return leaderName;
	}
	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}
	public String getLeaderTel() {
		return leaderTel;
	}
	public void setLeaderTel(String leaderTel) {
		this.leaderTel = leaderTel;
	}
	public String getLeaderEmail() {
		return leaderEmail;
	}
	public void setLeaderEmail(String leaderEmail) {
		this.leaderEmail = leaderEmail;
	}
	public String getLeaderDepart() {
		return leaderDepart;
	}
	public void setLeaderDepart(String leaderDepart) {
		this.leaderDepart = leaderDepart;
	}
	public String getLeaderTitle() {
		return leaderTitle;
	}
	public void setLeaderTitle(String leaderTitle) {
		this.leaderTitle = leaderTitle;
	}
	public String getLeaderPosition() {
		return leaderPosition;
	}
	public void setLeaderPosition(String leaderPosition) {
		this.leaderPosition = leaderPosition;
	}
	public String getLeaderIntro() {
		return leaderIntro;
	}
	public void setLeaderIntro(String leaderIntro) {
		this.leaderIntro = leaderIntro;
	}
	public String getLeaderAchieve() {
		return leaderAchieve;
	}
	public void setLeaderAchieve(String leaderAchieve) {
		this.leaderAchieve = leaderAchieve;
	}
	public String getTeamOthers() {
		return teamOthers;
	}
	public void setTeamOthers(String teamOthers) {
		this.teamOthers = teamOthers;
	}
	public String getAttachUrl() {
		return attachUrl;
	}
	public void setAttachUrl(String attachUrl) {
		this.attachUrl = attachUrl;
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
	public ResearchUserResultModel getResearchUserResultModel() {
		return researchUserResultModel;
	}
	public void setResearchUserResultModel(ResearchUserResultModel researchUserResultModel) {
		this.researchUserResultModel = researchUserResultModel;
	}
}
