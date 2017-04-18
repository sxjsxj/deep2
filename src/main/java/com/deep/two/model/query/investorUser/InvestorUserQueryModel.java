package com.deep.two.model.query.investorUser;

import com.deep.two.dao.util.Operator;
import com.deep.two.model.query.QueryModel;

public class InvestorUserQueryModel extends QueryModel {
    private String id;
    private String idOperator = Operator.IN;

    private String name;
    private String nameOperator = Operator.LK;

    private String province;
    private String provinceOperator = Operator.IN;

    private String city;
    private String cityOperator = Operator.IN;

    private String county;
    private String countyOperator = Operator.IN;

    private String scale;
    private String scaleOperator = Operator.IN;

    private String contactName;
    private String contactNameOperator = Operator.EQ;

    private String investDomain;
    private String investDomainOperator = Operator.MULTILK;

    private String investAmount;
    private String investAmountOperator = Operator.MULTILK;

    private String investPhase;
    private String investPhaseOperator = Operator.MULTILK;

    private String investArea;
    private String investAreaOperator = Operator.IN;

    private String cooperationType;
    private String cooperationTypeOperator = Operator.MULTILK;
    
    private String recommendFlag;
    private String recommendFlagOperator = Operator.EQ;

	private String seqNum;
    private String seqNumOperator = Operator.IN;
    
    private String type;
    private String typeOperator = Operator.IN;

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

    public String getRecommendFlag() {
		return recommendFlag;
	}

	public void setRecommendFlag(String recommendFlag) {
		this.recommendFlag = recommendFlag;
	}

	public String getRecommendFlagOperator() {
		return recommendFlagOperator;
	}

	public void setRecommendFlagOperator(String recommendFlagOperator) {
		this.recommendFlagOperator = recommendFlagOperator;
	}

	public String getSeqNum() {
		return seqNum;
	}

	public void setSeqNum(String seqNum) {
		this.seqNum = seqNum;
	}

	public String getSeqNumOperator() {
		return seqNumOperator;
	}

	public void setSeqNumOperator(String seqNumOperator) {
		this.seqNumOperator = seqNumOperator;
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

    public String getInvestDomain() {
        return investDomain;
    }

    public void setInvestDomain(String investDomain) {
        this.investDomain = investDomain;
    }

    public String getInvestDomainOperator() {
        return investDomainOperator;
    }

    public void setInvestDomainOperator(String investDomainOperator) {
        this.investDomainOperator = investDomainOperator;
    }

    public String getInvestAmount() {
        return investAmount;
    }

    public void setInvestAmount(String investAmount) {
        this.investAmount = investAmount;
    }

    public String getInvestAmountOperator() {
        return investAmountOperator;
    }

    public void setInvestAmountOperator(String investAmountOperator) {
        this.investAmountOperator = investAmountOperator;
    }

    public String getInvestPhase() {
        return investPhase;
    }

    public void setInvestPhase(String investPhase) {
        this.investPhase = investPhase;
    }

    public String getInvestPhaseOperator() {
        return investPhaseOperator;
    }

    public void setInvestPhaseOperator(String investPhaseOperator) {
        this.investPhaseOperator = investPhaseOperator;
    }

    public String getInvestArea() {
        return investArea;
    }

    public void setInvestArea(String investArea) {
        this.investArea = investArea;
    }

    public String getInvestAreaOperator() {
        return investAreaOperator;
    }

    public void setInvestAreaOperator(String investAreaOperator) {
        this.investAreaOperator = investAreaOperator;
    }

    public String getCooperationType() {
        return cooperationType;
    }

    public void setCooperationType(String cooperationType) {
        this.cooperationType = cooperationType;
    }

    public String getCooperationTypeOperator() {
        return cooperationTypeOperator;
    }

    public void setCooperationTypeOperator(String cooperationTypeOperator) {
        this.cooperationTypeOperator = cooperationTypeOperator;
    }

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTypeOperator() {
		return this.typeOperator;
	}

	public void setTypeOperator(String typeOperator) {
		this.typeOperator = typeOperator;
	}

}
