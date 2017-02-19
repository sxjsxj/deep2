package com.deep.two.model.query.companyUser;

import com.deep.two.dao.util.Operator;
import com.deep.two.model.query.QueryModel;

public class CompanyUserQueryModel extends QueryModel {
    private String id;
    private String idOperator = Operator.IN;

    private String name;
    private String nameOperator = Operator.LK;

    private String domain;
    private String domainOperator = Operator.IN;

    private String province;
    private String provinceOperator = Operator.IN;

    private String city;
    private String cityOperator = Operator.IN;

    private String county;
    private String countyOperator = Operator.IN;

    private String scale;
    private String scaleOperator = Operator.IN;

    private String nature;
    private String natureOperator = Operator.IN;

    private String contactName;
    private String contactNameOperator = Operator.EQ;
    
    private String productValue;
    private String productValueOperator = Operator.IN;

    private String status;
	private String statusOperator = Operator.IN;

	private String communicateStatus;
	private String communicateStatusOperator = Operator.IN;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameOperator() {
        return nameOperator;
    }

    public void setNameOperator(String nameOperator) {
        this.nameOperator = nameOperator;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getDomainOperator() {
        return domainOperator;
    }

    public void setDomainOperator(String domainOperator) {
        this.domainOperator = domainOperator;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getProvinceOperator() {
        return provinceOperator;
    }

    public void setProvinceOperator(String provinceOperator) {
        this.provinceOperator = provinceOperator;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityOperator() {
        return cityOperator;
    }

    public void setCityOperator(String cityOperator) {
        this.cityOperator = cityOperator;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCountyOperator() {
        return countyOperator;
    }

    public void setCountyOperator(String countyOperator) {
        this.countyOperator = countyOperator;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getScaleOperator() {
        return scaleOperator;
    }

    public void setScaleOperator(String scaleOperator) {
        this.scaleOperator = scaleOperator;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getNatureOperator() {
        return natureOperator;
    }

    public void setNatureOperator(String natureOperator) {
        this.natureOperator = natureOperator;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactNameOperator() {
        return contactNameOperator;
    }

    public void setContactNameOperator(String contactNameOperator) {
        this.contactNameOperator = contactNameOperator;
    }

	public String getProductValue() {
		return this.productValue;
	}

	public void setProductValue(String productValue) {
		this.productValue = productValue;
	}

	public String getProductValueOperator() {
		return this.productValueOperator;
	}

	public void setProductValueOperator(String productValueOperator) {
		this.productValueOperator = productValueOperator;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusOperator() {
		return this.statusOperator;
	}

	public void setStatusOperator(String statusOperator) {
		this.statusOperator = statusOperator;
	}

	public String getCommunicateStatus() {
		return this.communicateStatus;
	}

	public void setCommunicateStatus(String communicateStatus) {
		this.communicateStatus = communicateStatus;
	}

	public String getCommunicateStatusOperator() {
		return this.communicateStatusOperator;
	}

	public void setCommunicateStatusOperator(String communicateStatusOperator) {
		this.communicateStatusOperator = communicateStatusOperator;
	}

}
