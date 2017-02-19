/**
 * Copyright (c) 2016,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:DeepTwoWeb
 * Package Name:com.deep.two.model.query
 * File Name:DDMLResultModel.java
 * Date:2016-5-12 下午4:48:34
 * 
 */
package com.deep.two.model.result;

import java.util.ArrayList;
import java.util.List;

public class DMLResultModel {
    public static final int SUCCESS = 0;
    public static final int WARNING = 1;
    public static final int ERROR = 2;
    // 0success 1warning 2error
    private int status;
    private List<String> infoList = new ArrayList<String>();
    private List<String> warningList = new ArrayList<String>();
    private List<String> errorList = new ArrayList<String>();

    public DMLResultModel() {
    }
    
    public static DMLResultModel getSucessResultModel() {
    	return new DMLResultModel(SUCCESS);
    }

    public DMLResultModel(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<String> getInfoList() {
        return infoList;
    }

    public List<String> getWarningList() {
    	this.setStatus(this.WARNING);
        return warningList;
    }

    public List<String> getErrorList() {
    	this.setStatus(ERROR);
        return errorList;
    }

    public void setInfoList(List<String> infoList) {
        this.infoList = infoList;
    }

    public void setWarningList(List<String> warningList) {
        this.warningList = warningList;
    }

    public void setErrorList(List<String> errorList) {
        this.errorList = errorList;
    }

	@Override
    public String toString() {
        return "DMLResutlModel [status=" + status + ", infoList=" + this.getInfoList().toString() + ", warningList="
                + this.getWarningList().toString() + ", errorList=" + this.getErrorList().toString() + "]";
    }
}
