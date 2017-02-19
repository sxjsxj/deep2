package com.deep.two.model.query.researchUser;

import com.deep.two.dao.util.Operator;
import com.deep.two.model.query.QueryModel;

public class OrganizationUserQueryModel extends QueryModel {

    private String id;
    private String idOperator = Operator.IN;

    private String orgName;
    private String orgNameOperator = Operator.LK;

    private String orgProvince;
    private String orgProvinceOperator = Operator.IN;

    private String orgCity;
    private String orgCityOperator = Operator.IN;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdOperator() {
        return idOperator;
    }

    public void setIdOperator(String idOperator) {
        this.idOperator = idOperator;
    }

	public String getOrgProvince() {
		return this.orgProvince;
	}

	public void setOrgProvince(String orgProvince) {
		this.orgProvince = orgProvince;
	}

	public String getOrgProvinceOperator() {
		return this.orgProvinceOperator;
	}

	public void setOrgProvinceOperator(String orgProvinceOperator) {
		this.orgProvinceOperator = orgProvinceOperator;
	}

	public String getOrgCityOperator() {
		return this.orgCityOperator;
	}

	public void setOrgCityOperator(String orgCityOperator) {
		this.orgCityOperator = orgCityOperator;
	}

	public String getOrgCity() {
		return this.orgCity;
	}

	public void setOrgCity(String orgCity) {
		this.orgCity = orgCity;
	}

	public String getOrgNameOperator() {
		return this.orgNameOperator;
	}

	public void setOrgNameOperator(String orgNameOperator) {
		this.orgNameOperator = orgNameOperator;
	}

	public String getOrgName() {
		return this.orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

}
