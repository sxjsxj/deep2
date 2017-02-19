package com.deep.two.model;

import java.io.Serializable;
import java.util.List;

public class ApproveModel implements Serializable{
	private static final long serialVersionUID = 1L;
	private List<Serializable> idList;
	private String status;
	private String communicateStatus;
	private String remark;
	
	public List<Serializable> getIdList() {
		return idList;
	}
	public void setIdList(List<Serializable> idList) {
		this.idList = idList;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCommunicateStatus() {
		return communicateStatus;
	}
	public void setCommunicateStatus(String communicateStatus) {
		this.communicateStatus = communicateStatus;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
