package com.deep.two.model.result;

import java.util.Date;

public class FollowerModel {
	private String seqNum = "0";
	private String recommendFlag = "0";
	private String logoUrl;
	/**
	 * 是否已经“寻求合作”
	 */
	private String cooperateFlag = "false";
	/**
	 * 是否已经“收藏”
	 */
	private String collectFlag = "false";
	
	/**
	 * 是否被逻辑删除
	 */
	private String removeFlag = "0";
	
	private String whoLastUpdate;
	private Date whenCreate;
	private String whoCreate;
	private Date whenLastUpdate;
	
	public String getCooperateFlag() {
		return this.cooperateFlag;
	}
	public void setCooperateFlag(String cooperateFlag) {
		this.cooperateFlag = cooperateFlag;
	}
	public String getCollectFlag() {
		return this.collectFlag;
	}
	public void setCollectFlag(String collectFlag) {
		this.collectFlag = collectFlag;
	}
	public String getRemoveFlag() {
		return this.removeFlag;
	}
	public void setRemoveFlag(String removeFlag) {
		this.removeFlag = removeFlag;
	}
	public String getWhoLastUpdate() {
		return this.whoLastUpdate;
	}
	public void setWhoLastUpdate(String whoLastUpdate) {
		this.whoLastUpdate = whoLastUpdate;
	}
	public Date getWhenCreate() {
		return this.whenCreate;
	}
	public void setWhenCreate(Date whenCreate) {
		this.whenCreate = whenCreate;
	}
	public String getWhoCreate() {
		return this.whoCreate;
	}
	public void setWhoCreate(String whoCreate) {
		this.whoCreate = whoCreate;
	}
	public Date getWhenLastUpdate() {
		return this.whenLastUpdate;
	}
	public void setWhenLastUpdate(Date whenLastUpdate) {
		this.whenLastUpdate = whenLastUpdate;
	}
	public String getSeqNum() {
		return this.seqNum;
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
	public String getLogoUrl() {
		return this.logoUrl;
	}
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}
}
