package com.deep.two.model.query.basic;

import com.deep.two.dao.util.Operator;
import com.deep.two.model.query.QueryModel;

public class BasicUniversityQueryModel extends QueryModel {
    private String name;
    private String nameOperator = Operator.LK;

    private String province;
    private String provinceOperator = Operator.EQ;

    private String city;
    private String cityOperator = Operator.EQ;

    private String level;
    private String levelOperator = Operator.IN;

    private String project211;
    private String project211Operator = Operator.EQ;

    private String project985;
    private String project985Operator = Operator.EQ;

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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLevelOperator() {
        return levelOperator;
    }

    public void setLevelOperator(String levelOperator) {
        this.levelOperator = levelOperator;
    }

    public String getProject211() {
        return project211;
    }

    public void setProject211(String project211) {
        this.project211 = project211;
    }

    public String getProject211Operator() {
        return project211Operator;
    }

    public void setProject211Operator(String project211Operator) {
        this.project211Operator = project211Operator;
    }

    public String getProject985() {
        return project985;
    }

    public void setProject985(String project985) {
        this.project985 = project985;
    }

    public String getProject985Operator() {
        return project985Operator;
    }

    public void setProject985Operator(String project985Operator) {
        this.project985Operator = project985Operator;
    }

}
