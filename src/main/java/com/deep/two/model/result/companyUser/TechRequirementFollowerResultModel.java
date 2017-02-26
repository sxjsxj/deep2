package com.deep.two.model.result.companyUser;

import com.deep.two.authority.model.UserModel;
import com.deep.two.model.result.ResultModel;
import com.deep.two.orm.TechRequirementFollowerId;

public class TechRequirementFollowerResultModel  implements ResultModel {
	private TechRequirementFollowerId id;
	private UserModel userModel;
	private TechRequirementResultModel techRequirementResultModel;
	private String followerType;
	private String content;
	private String communicateStatus;
	private String remark;
	private String removeFlag;
	
	public String getRemoveFlag() {
		return this.removeFlag;
	}
	public void setRemoveFlag(String removeFlag) {
		this.removeFlag = removeFlag;
	}
	public TechRequirementFollowerId getId() {
		return id;
	}
	public void setId(TechRequirementFollowerId id) {
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
	public UserModel getUserModel() {
		return userModel;
	}
	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}
	public TechRequirementResultModel getTechRequirementResultModel() {
		return techRequirementResultModel;
	}
	public void setTechRequirementResultModel(TechRequirementResultModel techRequirementResultModel) {
		this.techRequirementResultModel = techRequirementResultModel;
	}
	
}
