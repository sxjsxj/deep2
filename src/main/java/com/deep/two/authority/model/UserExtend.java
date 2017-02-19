/**
 * Copyright (c) 2014,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:airtisweb-service-authority
 * Package Name:com.travelsky.fare.airtisweb.service.authority.impl
 * File Name:UserExtend.java
 * Date:2014-8-20 下午3:41:54
 * 
 */
package com.deep.two.authority.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;

import com.deep.two.model.result.companyUser.CompanyUserResultModel;
import com.deep.two.model.result.investorUser.InvestorUserResultModel;
import com.deep.two.model.result.researchUser.ResearchUserResultModel;

public class UserExtend implements UserDetails {
    
	private String id;
	private String username;
	private String password;
	private String email;
	private String telno;
	private String userType;
	private Date whenCreate;
	private Date whenLastUpdate;
	private Date whenLastLogin;
	private String status = "0";
	private String communicateStatus = "0";
	private String remark;
	private String whoCreate;
	private String whoLastUpdate;
    private Boolean enabled = true;
    private Boolean isSys = false;
    private Boolean accountNonLocked = true;
    private Boolean passwordNonExpired = true;
    private Boolean accountNonExpired = true;
    
    private List<CompanyUserResultModel> companyUserModels = new ArrayList<CompanyUserResultModel>(0);
	private List<ResearchUserResultModel> researchUserModels = new ArrayList<ResearchUserResultModel>(0);
	private List<InvestorUserResultModel> investorUserModels = new ArrayList<InvestorUserResultModel>(0);

    /**
	 * 用户所拥有的权限列表
	 */
    private Set<GrantedAuthority> authorities;
    
    public UserExtend() {
        
    }
    
    public UserExtend(String username, String password, Set<GrantedAuthority> authorities) {
        this(username, password, true, true, true, true, authorities);
    }

    public UserExtend(String userName, String password, boolean enabled, boolean accountNonExpired,
            boolean credentialsNonExpired, boolean accountNonLocked, Set<GrantedAuthority> authorities) {
        Assert.notNull(userName, "用户名不能为空！");

        this.username = userName;
        this.password = password;
        this.enabled = enabled;
        this.accountNonExpired = accountNonExpired;
        this.passwordNonExpired = credentialsNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }


    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.passwordNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof UserExtend) {
            return telno.equals(((UserExtend) obj).telno);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return telno.hashCode();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelno() {
        return telno;
    }

    public void setTelno(String telno) {
        this.telno = telno;
    }

	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Date getWhenCreate() {
		return this.whenCreate;
	}

	public void setWhenCreate(Date whenCreate) {
		this.whenCreate = whenCreate;
	}

	public Date getWhenLastUpdate() {
		return this.whenLastUpdate;
	}

	public void setWhenLastUpdate(Date whenLastUpdate) {
		this.whenLastUpdate = whenLastUpdate;
	}

	public Date getWhenLastLogin() {
		return this.whenLastLogin;
	}

	public void setWhenLastLogin(Date whenLastLogin) {
		this.whenLastLogin = whenLastLogin;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCommunicateStatus() {
		return this.communicateStatus;
	}

	public void setCommunicateStatus(String communicateStatus) {
		this.communicateStatus = communicateStatus;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getWhoCreate() {
		return this.whoCreate;
	}

	public void setWhoCreate(String whoCreate) {
		this.whoCreate = whoCreate;
	}

	public String getWhoLastUpdate() {
		return this.whoLastUpdate;
	}

	public void setWhoLastUpdate(String whoLastUpdate) {
		this.whoLastUpdate = whoLastUpdate;
	}

	public Boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Boolean getIsSys() {
		return this.isSys;
	}

	public void setIsSys(Boolean isSys) {
		this.isSys = isSys;
	}

	public Boolean getAccountNonLocked() {
		return this.accountNonLocked;
	}

	public void setAccountNonLocked(Boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public Boolean getPasswordNonExpired() {
		return this.passwordNonExpired;
	}

	public void setPasswordNonExpired(Boolean passwordNonExpired) {
		this.passwordNonExpired = passwordNonExpired;
	}

	public Boolean getAccountNonExpired() {
		return this.accountNonExpired;
	}

	public void setAccountNonExpired(Boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public List<CompanyUserResultModel> getCompanyUserModels() {
		return this.companyUserModels;
	}

	public void setCompanyUserModels(List<CompanyUserResultModel> companyUserModels) {
		this.companyUserModels = companyUserModels;
	}

	public List<ResearchUserResultModel> getResearchUserModels() {
		return this.researchUserModels;
	}

	public void setResearchUserModels(
			List<ResearchUserResultModel> researchUserModels) {
		this.researchUserModels = researchUserModels;
	}

	public List<InvestorUserResultModel> getInvestorUserModels() {
		return this.investorUserModels;
	}

	public void setInvestorUserModels(
			List<InvestorUserResultModel> investorUserModels) {
		this.investorUserModels = investorUserModels;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAuthorities(Set<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

}
