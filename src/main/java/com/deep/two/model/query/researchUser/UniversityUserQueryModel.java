package com.deep.two.model.query.researchUser;

import com.deep.two.dao.util.Operator;
import com.deep.two.model.query.QueryModel;

public class UniversityUserQueryModel extends QueryModel {
    private String id;
    private String idOperator = Operator.IN;

    private String uniName;
    private String uniNameOperator = Operator.LK;

    private String uniProvince;
    private String uniProvinceOperator = Operator.IN;

    private String uniCity;
    private String uniCityOperator = Operator.IN;

    private String uniLevel;
    private String uniLevelOperator = Operator.IN;

    private String uniProject211;
    private String uniProject211Operator = Operator.EQ;

    private String uniProject985;
    private String uniProject985Operator = Operator.EQ;
    
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIdOperator() {
		return this.idOperator;
	}
	public void setIdOperator(String idOperator) {
		this.idOperator = idOperator;
	}
	public String getUniName() {
		return this.uniName;
	}
	public void setUniName(String uniName) {
		this.uniName = uniName;
	}
	public String getUniNameOperator() {
		return this.uniNameOperator;
	}
	public void setUniNameOperator(String uniNameOperator) {
		this.uniNameOperator = uniNameOperator;
	}
	public String getUniProvince() {
		return this.uniProvince;
	}
	public void setUniProvince(String uniProvince) {
		this.uniProvince = uniProvince;
	}
	public String getUniProvinceOperator() {
		return this.uniProvinceOperator;
	}
	public void setUniProvinceOperator(String uniProvinceOperator) {
		this.uniProvinceOperator = uniProvinceOperator;
	}
	public String getUniCity() {
		return this.uniCity;
	}
	public void setUniCity(String uniCity) {
		this.uniCity = uniCity;
	}
	public String getUniCityOperator() {
		return this.uniCityOperator;
	}
	public void setUniCityOperator(String uniCityOperator) {
		this.uniCityOperator = uniCityOperator;
	}
	public String getUniLevel() {
		return this.uniLevel;
	}
	public void setUniLevel(String uniLevel) {
		this.uniLevel = uniLevel;
	}
	public String getUniLevelOperator() {
		return this.uniLevelOperator;
	}
	public void setUniLevelOperator(String uniLevelOperator) {
		this.uniLevelOperator = uniLevelOperator;
	}
	public String getUniProject211() {
		return this.uniProject211;
	}
	public void setUniProject211(String uniProject211) {
		this.uniProject211 = uniProject211;
	}
	public String getUniProject211Operator() {
		return this.uniProject211Operator;
	}
	public void setUniProject211Operator(String uniProject211Operator) {
		this.uniProject211Operator = uniProject211Operator;
	}
	public String getUniProject985() {
		return this.uniProject985;
	}
	public void setUniProject985(String uniProject985) {
		this.uniProject985 = uniProject985;
	}
	public String getUniProject985Operator() {
		return this.uniProject985Operator;
	}
	public void setUniProject985Operator(String uniProject985Operator) {
		this.uniProject985Operator = uniProject985Operator;
	}

   

}
