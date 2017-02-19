package com.deep.two.orm;

// Generated 2016-12-27 21:27:57 by Hibernate Tools 3.4.0.CR1

/**
 * RoleResource generated by hbm2java
 */
public class RoleResource implements java.io.Serializable {

	private RoleResourceId id;
	private Role role;
	private Resource resource;
	private String enabled;

	public RoleResource() {
	}

	public RoleResource(RoleResourceId id, Role role, Resource resource) {
		this.id = id;
		this.role = role;
		this.resource = resource;
	}

	public RoleResource(RoleResourceId id, Role role, Resource resource,
			String enabled) {
		this.id = id;
		this.role = role;
		this.resource = resource;
		this.enabled = enabled;
	}

	public RoleResourceId getId() {
		return this.id;
	}

	public void setId(RoleResourceId id) {
		this.id = id;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Resource getResource() {
		return this.resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public String getEnabled() {
		return this.enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

}
