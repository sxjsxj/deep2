package com.deep.two.orm;

// Generated 2016-12-27 21:27:57 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * BasicUniversity generated by hbm2java
 */
public class BasicUniversity implements java.io.Serializable {

	private String id;
	private String name;
	private String department;
	private String province;
	private String city;
	private String level;
	private String nature;
	private String project211;
	private String project985;
	private String nationalPriority;
	private String address;
	private String introduction;
	private Date whenCreate;
	private String whoCreate;
	private Date whenLastUpdate;
	private String whoLastUpdate;

	public BasicUniversity() {
	}

	public BasicUniversity(String id) {
		this.id = id;
	}

	public BasicUniversity(String id, String name, String department,
			String province, String city, String level, String nature,
			String project211, String project985, String nationalPriority,
			String address, String introduction, Date whenCreate,
			String whoCreate, Date whenLastUpdate, String whoLastUpdate) {
		this.id = id;
		this.name = name;
		this.department = department;
		this.province = province;
		this.city = city;
		this.level = level;
		this.nature = nature;
		this.project211 = project211;
		this.project985 = project985;
		this.nationalPriority = nationalPriority;
		this.address = address;
		this.introduction = introduction;
		this.whenCreate = whenCreate;
		this.whoCreate = whoCreate;
		this.whenLastUpdate = whenLastUpdate;
		this.whoLastUpdate = whoLastUpdate;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getNature() {
		return this.nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public String getProject211() {
		return this.project211;
	}

	public void setProject211(String project211) {
		this.project211 = project211;
	}

	public String getProject985() {
		return this.project985;
	}

	public void setProject985(String project985) {
		this.project985 = project985;
	}

	public String getNationalPriority() {
		return this.nationalPriority;
	}

	public void setNationalPriority(String nationalPriority) {
		this.nationalPriority = nationalPriority;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIntroduction() {
		return this.introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
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

}
