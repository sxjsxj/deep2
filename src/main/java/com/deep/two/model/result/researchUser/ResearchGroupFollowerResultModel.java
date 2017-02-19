package com.deep.two.model.result.researchUser;

import com.deep.two.authority.model.UserModel;
import com.deep.two.model.result.ResultModel;
import com.deep.two.orm.ResearchGroupFollowerId;

public class ResearchGroupFollowerResultModel implements ResultModel {
	private ResearchGroupFollowerId id;
	private UserModel userModel;
	private ResearchGroupResultModel researchGroupResultModel;
	private String followerType;
	private String content;
	private String communicateStatus;
	private String remark;
	
	public ResearchGroupFollowerId getId() {
		return id;
	}
	public void setId(ResearchGroupFollowerId id) {
		this.id = id;
	}
	public String getFollowerType() {
		return followerType;
	}
	public void setFollowerType(String followerType) {
		this.followerType = followerType;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public ResearchGroupResultModel getResearchGroupResultModel() {
		return researchGroupResultModel;
	}
	public void setResearchGroupResultModel(ResearchGroupResultModel researchGroupResultModel) {
		this.researchGroupResultModel = researchGroupResultModel;
	}
	public UserModel getUserModel() {
		return userModel;
	}
	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}
}
