package com.deep.two.model;

import java.io.Serializable;
import java.util.List;

public class RecommendModel implements Serializable{
	private static final long serialVersionUID = 1L;
	private List<Serializable> idList;
	private String recommendFlag;
	private String seqNum;
	
	public List<Serializable> getIdList() {
		return idList;
	}
	public void setIdList(List<Serializable> idList) {
		this.idList = idList;
	}
	public String getSeqNum() {
		return seqNum;
	}
	public void setSeqNum(String seqNum) {
		this.seqNum = seqNum;
	}
	public String getRecommendFlag() {
		return this.recommendFlag;
	}
	public void setRecommendFlag(String recommendFlag) {
		this.recommendFlag = recommendFlag;
	}
}
