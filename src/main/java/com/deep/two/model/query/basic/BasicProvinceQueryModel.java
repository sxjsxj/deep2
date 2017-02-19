package com.deep.two.model.query.basic;

import com.deep.two.dao.util.Operator;
import com.deep.two.model.query.QueryModel;

// Generated 2016-8-31 21:36:25 by Hibernate Tools 3.4.0.CR1

/**
 * BasicProvince generated by hbm2java
 */
public class BasicProvinceQueryModel extends QueryModel {

	private String province;
	private String provinceOperator = Operator.IN;

	private String city;
	private String cityOperator = Operator.IN;

	private String county;
	private String countyOperator = Operator.IN;

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getProvinceOperator() {
		return this.provinceOperator;
	}

	public void setProvinceOperator(String provinceOperator) {
		this.provinceOperator = provinceOperator;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCityOperator() {
		return this.cityOperator;
	}

	public void setCityOperator(String cityOperator) {
		this.cityOperator = cityOperator;
	}

	public String getCounty() {
		return this.county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getCountyOperator() {
		return this.countyOperator;
	}

	public void setCountyOperator(String countyOperator) {
		this.countyOperator = countyOperator;
	}

}
