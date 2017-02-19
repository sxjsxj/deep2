/**
 * Copyright (c) 2016,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:DeepTwoWeb
 * Package Name:com.deep.two.model
 * File Name:QueryModel.java
 * Date:2016-4-22 上午11:30:28
 * 
 */
package com.deep.two.model.query;

import java.util.Date;

import com.deep.two.dao.util.Operator;

 /**
 * ClassName: QueryModel <br/>
 * Description: TODO <br/>
 * Date: 2016-4-22 上午11:30:28 <br/>
 * <br/>
 * 
 * @author sunxijin(邮箱)
 * 
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
 * 
 */

public class QueryModel {
	private String removeFlag;
	private String removeFlagOperator = Operator.EQ;
	
	private String status;
	private String statusOperator = Operator.IN;

	private String communicateStatus;
	private String communicateStatusOperator = Operator.IN;
			
	private String whoCreate;
    private String whoCreateOperator = Operator.EQ;

	private Date whenCreate;
    private String whenCreateOperator = Operator.EQ;
	
	private String whoLastUpdate;
    private String whoLastUpdateOperator = Operator.EQ;

	private Date whenLastUpdate;
    private String whenLastUpdateOperator = Operator.EQ;
	public String getWhoCreate() {
		return this.whoCreate;
	}
	public void setWhoCreate(String whoCreate) {
		this.whoCreate = whoCreate;
	}
	public String getWhoCreateOperator() {
		return this.whoCreateOperator;
	}
	public void setWhoCreateOperator(String whoCreateOperator) {
		this.whoCreateOperator = whoCreateOperator;
	}
	public Date getWhenCreate() {
		return this.whenCreate;
	}
	public void setWhenCreate(Date whenCreate) {
		this.whenCreate = whenCreate;
	}
	public String getWhenCreateOperator() {
		return this.whenCreateOperator;
	}
	public void setWhenCreateOperator(String whenCreateOperator) {
		this.whenCreateOperator = whenCreateOperator;
	}
	public String getWhoLastUpdate() {
		return this.whoLastUpdate;
	}
	public void setWhoLastUpdate(String whoLastUpdate) {
		this.whoLastUpdate = whoLastUpdate;
	}
	public String getWhoLastUpdateOperator() {
		return this.whoLastUpdateOperator;
	}
	public void setWhoLastUpdateOperator(String whoLastUpdateOperator) {
		this.whoLastUpdateOperator = whoLastUpdateOperator;
	}
	public Date getWhenLastUpdate() {
		return this.whenLastUpdate;
	}
	public void setWhenLastUpdate(Date whenLastUpdate) {
		this.whenLastUpdate = whenLastUpdate;
	}
	public String getWhenLastUpdateOperator() {
		return this.whenLastUpdateOperator;
	}
	public void setWhenLastUpdateOperator(String whenLastUpdateOperator) {
		this.whenLastUpdateOperator = whenLastUpdateOperator;
	}
	public String getRemoveFlag() {
		return this.removeFlag;
	}
	public void setRemoveFlag(String removeFlag) {
		this.removeFlag = removeFlag;
	}
	public String getRemoveFlagOperator() {
		return this.removeFlagOperator;
	}
	public void setRemoveFlagOperator(String removeFlagOperator) {
		this.removeFlagOperator = removeFlagOperator;
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

