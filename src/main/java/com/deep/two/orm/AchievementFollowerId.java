package com.deep.two.orm;

// Generated 2016-12-27 21:27:57 by Hibernate Tools 3.4.0.CR1

/**
 * AchievementFollowerId generated by hbm2java
 */
public class AchievementFollowerId implements java.io.Serializable {

	private String userId;
	private String achievementId;
	private String relationType;

	public AchievementFollowerId() {
	}

	public AchievementFollowerId(String userId, String achievementId,
			String relationType) {
		this.userId = userId;
		this.achievementId = achievementId;
		this.relationType = relationType;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAchievementId() {
		return this.achievementId;
	}

	public void setAchievementId(String achievementId) {
		this.achievementId = achievementId;
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
		if (!(other instanceof AchievementFollowerId))
			return false;
		AchievementFollowerId castOther = (AchievementFollowerId) other;

		return ((this.getUserId() == castOther.getUserId()) || (this
				.getUserId() != null && castOther.getUserId() != null && this
				.getUserId().equals(castOther.getUserId())))
				&& ((this.getAchievementId() == castOther.getAchievementId()) || (this
						.getAchievementId() != null
						&& castOther.getAchievementId() != null && this
						.getAchievementId()
						.equals(castOther.getAchievementId())))
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
				+ (getAchievementId() == null ? 0 : this.getAchievementId()
						.hashCode());
		result = 37
				* result
				+ (getRelationType() == null ? 0 : this.getRelationType()
						.hashCode());
		return result;
	}

}
