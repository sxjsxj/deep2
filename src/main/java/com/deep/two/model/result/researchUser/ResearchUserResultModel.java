package com.deep.two.model.result.researchUser;

import com.deep.two.authority.model.UserModel;
import com.deep.two.model.result.ResultModel;

public class ResearchUserResultModel implements ResultModel {
	private String id;
	private UserModel userModel;
	private String type;
	private String uniName;
	private String uniDepartment;
	private String uniProvince;
	private String uniCity;
	private String uniLevel;
	private String uniNature;
	private Integer uniProject211;
	private Integer uniProject985;
	private Integer uniNationalPriority;
	private String orgName;
	private String orgProvince;
	private String orgCity;
	private String orgCounty;
	private String address;
	private String introduction;
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
	public String getUniName() {
		return uniName;
	}
	public void setUniName(String uniName) {
		this.uniName = uniName;
	}
	public String getUniDepartment() {
		return uniDepartment;
	}
	public void setUniDepartment(String uniDepartment) {
		this.uniDepartment = uniDepartment;
	}
	public String getUniProvince() {
		return uniProvince;
	}
	public void setUniProvince(String uniProvince) {
		this.uniProvince = uniProvince;
	}
	public String getUniCity() {
		return uniCity;
	}
	public void setUniCity(String uniCity) {
		this.uniCity = uniCity;
	}
	public String getUniLevel() {
		return uniLevel;
	}
	public UserModel getUserModel() {
		return userModel;
	}
	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}
	public void setUniLevel(String uniLevel) {
		this.uniLevel = uniLevel;
	}
	public String getUniNature() {
		return uniNature;
	}
	public void setUniNature(String uniNature) {
		this.uniNature = uniNature;
	}
	public Integer getUniProject211() {
		return uniProject211;
	}
	public void setUniProject211(Integer uniProject211) {
		this.uniProject211 = uniProject211;
	}
	public Integer getUniProject985() {
		return uniProject985;
	}
	public void setUniProject985(Integer uniProject985) {
		this.uniProject985 = uniProject985;
	}
	public Integer getUniNationalPriority() {
		return uniNationalPriority;
	}
	public void setUniNationalPriority(Integer uniNationalPriority) {
		this.uniNationalPriority = uniNationalPriority;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getOrgProvince() {
		return orgProvince;
	}
	public void setOrgProvince(String orgProvince) {
		this.orgProvince = orgProvince;
	}
	public String getOrgCity() {
		return orgCity;
	}
	public void setOrgCity(String orgCity) {
		this.orgCity = orgCity;
	}
	public String getOrgCounty() {
		return orgCounty;
	}
	public void setOrgCounty(String orgCounty) {
		this.orgCounty = orgCounty;
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
}
