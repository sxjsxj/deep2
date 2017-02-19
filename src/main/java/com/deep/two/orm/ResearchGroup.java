package com.deep.two.orm;

// Generated 2016-12-27 21:27:57 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * ResearchGroup generated by hbm2java
 */
public class ResearchGroup implements java.io.Serializable {

	private String id;
	private ResearchUser researchUser;
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
	private String seqNum;
	private String recommendFlag;
	private Date whenCreate;
	private String whoCreate;
	private Date whenLastUpdate;
	private String whoLastUpdate;
	private String removeFlag;
	private Set<ResearchGroupFollower> researchGroupFollowers = new HashSet<ResearchGroupFollower>(
			0);
	private Set<Achievement> achievements = new HashSet<Achievement>(0);

	public ResearchGroup() {
	}

	public ResearchGroup(String id, ResearchUser researchUser) {
		this.id = id;
		this.researchUser = researchUser;
	}

	public ResearchGroup(String id, ResearchUser researchUser, String logoUrl,
			String name, String domain, String introduction, Integer teamSize,
			String field, String experience, String achievement,
			String leaderUrl, String leaderName, String leaderTel,
			String leaderEmail, String leaderDepart, String leaderTitle,
			String leaderPosition, String leaderIntro, String leaderAchieve,
			String teamOthers, String attachUrl, String status,
			String communicateStatus, String remark, Integer concernNumber,
			Integer scanNumber, String seqNum, String recommendFlag,
			Date whenCreate, String whoCreate, Date whenLastUpdate,
			String whoLastUpdate, String removeFlag,
			Set<ResearchGroupFollower> researchGroupFollowers,
			Set<Achievement> achievements) {
		this.id = id;
		this.researchUser = researchUser;
		this.logoUrl = logoUrl;
		this.name = name;
		this.domain = domain;
		this.introduction = introduction;
		this.teamSize = teamSize;
		this.field = field;
		this.experience = experience;
		this.achievement = achievement;
		this.leaderUrl = leaderUrl;
		this.leaderName = leaderName;
		this.leaderTel = leaderTel;
		this.leaderEmail = leaderEmail;
		this.leaderDepart = leaderDepart;
		this.leaderTitle = leaderTitle;
		this.leaderPosition = leaderPosition;
		this.leaderIntro = leaderIntro;
		this.leaderAchieve = leaderAchieve;
		this.teamOthers = teamOthers;
		this.attachUrl = attachUrl;
		this.status = status;
		this.communicateStatus = communicateStatus;
		this.remark = remark;
		this.concernNumber = concernNumber;
		this.scanNumber = scanNumber;
		this.seqNum = seqNum;
		this.recommendFlag = recommendFlag;
		this.whenCreate = whenCreate;
		this.whoCreate = whoCreate;
		this.whenLastUpdate = whenLastUpdate;
		this.whoLastUpdate = whoLastUpdate;
		this.removeFlag = removeFlag;
		this.researchGroupFollowers = researchGroupFollowers;
		this.achievements = achievements;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ResearchUser getResearchUser() {
		return this.researchUser;
	}

	public void setResearchUser(ResearchUser researchUser) {
		this.researchUser = researchUser;
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

	public String getIntroduction() {
		return this.introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public Integer getTeamSize() {
		return this.teamSize;
	}

	public void setTeamSize(Integer teamSize) {
		this.teamSize = teamSize;
	}

	public String getField() {
		return this.field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getExperience() {
		return this.experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getAchievement() {
		return this.achievement;
	}

	public void setAchievement(String achievement) {
		this.achievement = achievement;
	}

	public String getLeaderUrl() {
		return this.leaderUrl;
	}

	public void setLeaderUrl(String leaderUrl) {
		this.leaderUrl = leaderUrl;
	}

	public String getLeaderName() {
		return this.leaderName;
	}

	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}

	public String getLeaderTel() {
		return this.leaderTel;
	}

	public void setLeaderTel(String leaderTel) {
		this.leaderTel = leaderTel;
	}

	public String getLeaderEmail() {
		return this.leaderEmail;
	}

	public void setLeaderEmail(String leaderEmail) {
		this.leaderEmail = leaderEmail;
	}

	public String getLeaderDepart() {
		return this.leaderDepart;
	}

	public void setLeaderDepart(String leaderDepart) {
		this.leaderDepart = leaderDepart;
	}

	public String getLeaderTitle() {
		return this.leaderTitle;
	}

	public void setLeaderTitle(String leaderTitle) {
		this.leaderTitle = leaderTitle;
	}

	public String getLeaderPosition() {
		return this.leaderPosition;
	}

	public void setLeaderPosition(String leaderPosition) {
		this.leaderPosition = leaderPosition;
	}

	public String getLeaderIntro() {
		return this.leaderIntro;
	}

	public void setLeaderIntro(String leaderIntro) {
		this.leaderIntro = leaderIntro;
	}

	public String getLeaderAchieve() {
		return this.leaderAchieve;
	}

	public void setLeaderAchieve(String leaderAchieve) {
		this.leaderAchieve = leaderAchieve;
	}

	public String getTeamOthers() {
		return this.teamOthers;
	}

	public void setTeamOthers(String teamOthers) {
		this.teamOthers = teamOthers;
	}

	public String getAttachUrl() {
		return this.attachUrl;
	}

	public void setAttachUrl(String attachUrl) {
		this.attachUrl = attachUrl;
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

	public Set<ResearchGroupFollower> getResearchGroupFollowers() {
		return this.researchGroupFollowers;
	}

	public void setResearchGroupFollowers(
			Set<ResearchGroupFollower> researchGroupFollowers) {
		this.researchGroupFollowers = researchGroupFollowers;
	}

	public Set<Achievement> getAchievements() {
		return this.achievements;
	}

	public void setAchievements(Set<Achievement> achievements) {
		this.achievements = achievements;
	}

}
