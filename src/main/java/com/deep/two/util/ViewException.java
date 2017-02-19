/**
 * Copyright (c) 2014,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:fare-util
 * Package Name:com.travelsky.fare.airtisfaretoolutils.exception.util
 * File Name:FareUtilException.java
 * Date:2014-7-9 下午1:35:01
 * 
 */
package com.deep.two.util;

import com.deep.two.model.result.DMLResultModel;


public class ViewException extends Exception {

    private static final long serialVersionUID = 5929383739733066440L;
    private DMLResultModel resultModel = new DMLResultModel(DMLResultModel.ERROR);

    public ViewException() {
        super();
    }

    public ViewException(String msg) {
        super(msg);
    	resultModel.getErrorList().add(msg);
    }

    public ViewException(String msg, Throwable cause) {
        super(msg, cause);
    	resultModel.getErrorList().add(msg);
    }

    public ViewException(Throwable cause) {
        super(cause);
    }

    public DMLResultModel getResultModel() {
        return resultModel;
    }

    public void setResultModel(DMLResultModel resultModel) {
        this.resultModel = resultModel;
    }
}
