package com.deep.two.orm;

// Generated 2016-12-27 21:27:57 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * BasicProvince generated by hbm2java
 */
public class BasicProvince implements java.io.Serializable {

	private String id;
	private String province;
	private String city;
	private String county;
	private Date whenCreate;
	private String whoCreate;
	private Date whenLastUpdate;
	private String whoLastUpdate;

	public BasicProvince() {
	}

	public BasicProvince(String id) {
		this.id = id;
	}

	public BasicProvince(String id, String province, String city,
			String county, Date whenCreate, String whoCreate,
			Date whenLastUpdate, String whoLastUpdate) {
		this.id = id;
		this.province = province;
		this.city = city;
		this.county = county;
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

	public String getCounty() {
		return this.county;
	}

	public void setCounty(String county) {
		this.county = county;
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
