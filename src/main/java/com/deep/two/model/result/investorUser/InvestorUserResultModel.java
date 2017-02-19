package com.deep.two.model.result.investorUser;

import com.deep.two.authority.model.UserModel;
import com.deep.two.model.result.FollowerModel;
import com.deep.two.model.result.ResultModel;

public class InvestorUserResultModel extends FollowerModel implements ResultModel {
	private String id;
	private UserModel userModel;
	private String type;
	private String logoUrl;
	private String name;
	private String province;
	private String city;
	private String county;
	private Integer scale;
	private String address;
	private String introduction;
	private String contactName;
	private String contactTel;
	private String contactEmail;
	private String contactTitle;
	private String investDomain;
	private String investAmount;
	private String investPhase;
	private String investArea;
	private String investType;
	private String investExperience;
	private String investOutline;
	private String fundType;
	private String attachUrl;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLogoUrl() {
		return logoUrl;
	}
	public UserModel getUserModel() {
		return userModel;
	}
	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
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
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public Integer getScale() {
		return scale;
	}
	public void setScale(Integer scale) {
		this.scale = scale;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
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
	public String getContactTitle() {
		return contactTitle;
	}
	public void setContactTitle(String contactTitle) {
		this.contactTitle = contactTitle;
	}
	public String getInvestDomain() {
		return investDomain;
	}
	public void setInvestDomain(String investDomain) {
		this.investDomain = investDomain;
	}
	public String getInvestAmount() {
		return investAmount;
	}
	public void setInvestAmount(String investAmount) {
		this.investAmount = investAmount;
	}
	public String getInvestPhase() {
		return investPhase;
	}
	public void setInvestPhase(String investPhase) {
		this.investPhase = investPhase;
	}
	public String getInvestArea() {
		return investArea;
	}
	public void setInvestArea(String investArea) {
		this.investArea = investArea;
	}
	public String getInvestType() {
		return investType;
	}
	public void setInvestType(String investType) {
		this.investType = investType;
	}
	public String getInvestExperience() {
		return investExperience;
	}
	public void setInvestExperience(String investExperience) {
		this.investExperience = investExperience;
	}
	public String getInvestOutline() {
		return investOutline;
	}
	public void setInvestOutline(String investOutline) {
		this.investOutline = investOutline;
	}
	public String getFundType() {
		return fundType;
	}
	public void setFundType(String fundType) {
		this.fundType = fundType;
	}
	public String getAttachUrl() {
		return attachUrl;
	}
	public void setAttachUrl(String attachUrl) {
		this.attachUrl = attachUrl;
	}
}
