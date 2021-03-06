package com.deep.two.orm;

// Generated 2016-12-27 21:27:57 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * BasicProvinceArea generated by hbm2java
 */
public class BasicProvinceArea implements java.io.Serializable {

	private String id;
	private String province;
	private String area;
	private String hot;
	private Integer order;
	private Date whenCreate;
	private String whoCreate;
	private Date whenLastUpdate;
	private String whoLastUpdate;

	public BasicProvinceArea() {
	}

	public BasicProvinceArea(String id) {
		this.id = id;
	}

	public BasicProvinceArea(String id, String province, String area,
			String hot, Integer order, Date whenCreate, String whoCreate,
			Date whenLastUpdate, String whoLastUpdate) {
		this.id = id;
		this.province = province;
		this.area = area;
		this.hot = hot;
		this.order = order;
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

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getHot() {
		return this.hot;
	}

	public void setHot(String hot) {
		this.hot = hot;
	}

	public Integer getOrder() {
		return this.order;
	}

	public void setOrder(Integer order) {
		this.order = order;
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
