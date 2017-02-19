package com.deep.two.orm;

// Generated 2016-12-27 21:27:57 by Hibernate Tools 3.4.0.CR1

/**
 * TechRequirementFollowerId generated by hbm2java
 */
public class TechRequirementFollowerId implements java.io.Serializable {

	private String userId;
	private String requirementId;
	private String relationType;

	public TechRequirementFollowerId() {
	}

	public TechRequirementFollowerId(String userId, String requirementId,
			String relationType) {
		this.userId = userId;
		this.requirementId = requirementId;
		this.relationType = relationType;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRequirementId() {
		return this.requirementId;
	}

	public void setRequirementId(String requirementId) {
		this.requirementId = requirementId;
	}

	public String getRelationType() {
		return this.relationType;
	}

	public void setRelationType(String relationType) {
		this.relationType = relationType;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TechRequirementFollowerId))
			return false;
		TechRequirementFollowerId castOther = (TechRequirementFollowerId) other;

		return ((this.getUserId() == castOther.getUserId()) || (this
				.getUserId() != null && castOther.getUserId() != null && this
				.getUserId().equals(castOther.getUserId())))
				&& ((this.getRequirementId() == castOther.getRequirementId()) || (this
						.getRequirementId() != null
						&& castOther.getRequirementId() != null && this
						.getRequirementId()
						.equals(castOther.getRequirementId())))
				&& ((this.getRelationType() == castOther.getRelationType()) || (this
						.getRelationType() != null
						&& castOther.getRelationType() != null && this
						.getRelationType().equals(castOther.getRelationType())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUserId() == null ? 0 : this.getUserId().hashCode());
		result = 37
				* result
				+ (getRequirementId() == null ? 0 : this.getRequirementId()
						.hashCode());
		result = 37
				* result
				+ (getRelationType() == null ? 0 : this.getRelationType()
						.hashCode());
		return result;
	}

}
