package com.deep.two.model.result.companyUser;

import com.deep.two.authority.model.UserModel;
import com.deep.two.model.result.ResultModel;
import com.deep.two.orm.FundRequirementFollowerId;

public class FundRequirementFollowerResultModel  implements ResultModel {
	
	private FundRequirementFollowerId id;
	private UserModel userModel;
	private FundRequirementResultModel fundRequirementResultModel;
	private String followerType;
	private String content;
	private String communicateStatus;
	private String remark;
	public FundRequirementFollowerId getId() {
		return id;
	}
	public void setId(FundRequirementFollowerId id) {
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
	public FundRequirementResultModel getFundRequirementResultModel() {
		return fundRequirementResultModel;
	}
	public void setFundRequirementResultModel(FundRequirementResultModel fundRequirementResultModel) {
		this.fundRequirementResultModel = fundRequirementResultModel;
	}
}
