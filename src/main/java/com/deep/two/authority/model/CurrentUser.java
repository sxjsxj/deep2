/**
 * Copyright (c) 2015,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:FareUtil_v1.3.0
 * Package Name:com.travelsky.fare.fareutil.model
 * File Name:CurrentUser.java
 * Date:2015-7-22 下午4:15:30
 * 
 */
package com.deep.two.authority.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.deep.two.model.result.companyUser.CompanyUserResultModel;
import com.deep.two.model.result.investorUser.InvestorUserResultModel;
import com.deep.two.model.result.researchUser.ResearchUserResultModel;
import com.deep.two.orm.CompanyUser;
import com.deep.two.orm.InvestorUser;
import com.deep.two.orm.ResearchUser;

/**
 * ClassName: CurrentUser <br/>
 * Description: TODO <br/>
 * Date: 2015-7-22 下午4:15:30 <br/>
 * <br/>
 * 
 * @author sunxijin(邮箱)
 * 
 *         修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
 * 
 */

public class CurrentUser {
	private String id;
	private String username;
	private String password;
	private String email;
	private String telno;
	private String userType;
	private Date whenCreate;
	private Date whenLastUpdate;
	private Date whenLastLogin;
	private String status = "0";
	private String communicateStatus = "0";
	private String remark;
	private String whoCreate;
	private String whoLastUpdate;
    private List<CompanyUserResultModel> companyUserModels = new ArrayList<CompanyUserResultModel>(0);
	private List<ResearchUserResultModel> researchUserModels = new ArrayList<ResearchUserResultModel>(0);
	private List<InvestorUserResultModel> investorUserModels = new ArrayList<InvestorUserResultModel>(0);
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelno() {
		return telno;
	}
	public void setTelno(String telno) {
		this.telno = telno;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public List<CompanyUserResultModel> getCompanyUserModels() {
		return companyUserModels;
	}
	public void setCompanyUserModels(List<CompanyUserResultModel> companyUserModels) {
		this.companyUserModels = companyUserModels;
	}
	public List<ResearchUserResultModel> getResearchUserModels() {
		return researchUserModels;
	}
	public void setResearchUserModels(List<ResearchUserResultModel> researchUserModels) {
		this.researchUserModels = researchUserModels;
	}
	public List<InvestorUserResultModel> getInvestorUserModels() {
		return investorUserModels;
	}
	public void setInvestorUserModels(List<InvestorUserResultModel> investorUserModels) {
		this.investorUserModels = investorUserModels;
	}
	public String getUserType() {
		return this.userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public Date getWhenCreate() {
		return this.whenCreate;
	}
	public void setWhenCreate(Date whenCreate) {
		this.whenCreate = whenCreate;
	}
	public Date getWhenLastUpdate() {
		return this.whenLastUpdate;
	}
	public void setWhenLastUpdate(Date whenLastUpdate) {
		this.whenLastUpdate = whenLastUpdate;
	}
	public Date getWhenLastLogin() {
		return this.whenLastLogin;
	}
	public void setWhenLastLogin(Date whenLastLogin) {
		this.whenLastLogin = whenLastLogin;
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
	public String getWhoCreate() {
		return this.whoCreate;
	}
	public void setWhoCreate(String whoCreate) {
		this.whoCreate = whoCreate;
	}
	public String getWhoLastUpdate() {
		return this.whoLastUpdate;
	}
	public void setWhoLastUpdate(String whoLastUpdate) {
		this.whoLastUpdate = whoLastUpdate;
	}
	
}
