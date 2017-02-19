package com.deep.two.test.dao;

import com.deep.two.orm.CompanyUser;
import com.deep.two.orm.InvestorUser;
import com.deep.two.orm.ResearchUser;
import com.deep.two.orm.User;

public class UserTest {

	public static User getUser() {
		User u = new User();
		u.setId("1");
		return u;
	}
	
	public static ResearchUser getResearchUser() {
		ResearchUser u = new ResearchUser();
		u.setId("1");
		u.setUser(getUser());
		return u;
	}
	
	public static CompanyUser getCompanyUser() {
		CompanyUser u = new CompanyUser();
		u.setId("1");
		u.setUser(getUser());
		return u;
	}
	
	public static InvestorUser getInvestorUser() {
		InvestorUser u = new InvestorUser();
		u.setId("1");
		u.setUser(getUser());
		return u;
	}
}
