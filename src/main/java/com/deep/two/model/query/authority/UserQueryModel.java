package com.deep.two.model.query.authority;

import com.deep.two.dao.util.Operator;
import com.deep.two.model.query.QueryModel;

public class UserQueryModel extends QueryModel {
	private String id;
	private String idOperator = Operator.IN;

	private String email;
	private String emailOperator = Operator.LK;

	private String telno;
	private String telnoOperator = Operator.LK;

	private String userType;
	private String userTypeOperator = Operator.IN;

	private String status;
	private String statusOperator = Operator.IN;

	private String communicateStatus;
	private String communicateStatusOperator = Operator.IN;

	private String remark;
	private String remarkOperator = Operator.LK;

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

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailOperator() {
		return this.emailOperator;
	}

	public void setEmailOperator(String emailOperator) {
		this.emailOperator = emailOperator;
	}

	public String getTelno() {
		return this.telno;
	}

	public void setTelno(String telno) {
		this.telno = telno;
	}

	public String getTelnoOperator() {
		return this.telnoOperator;
	}

	public void setTelnoOperator(String telnoOperator) {
		this.telnoOperator = telnoOperator;
	}

	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserTypeOperator() {
		return this.userTypeOperator;
	}

	public void setUserTypeOperator(String userTypeOperator) {
		this.userTypeOperator = userTypeOperator;
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

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemarkOperator() {
		return this.remarkOperator;
	}

	public void setRemarkOperator(String remarkOperator) {
		this.remarkOperator = remarkOperator;
	}
}
