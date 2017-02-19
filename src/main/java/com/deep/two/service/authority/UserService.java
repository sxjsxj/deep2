package com.deep.two.service.authority;

import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.deep.two.authority.model.CurrentUser;
import com.deep.two.authority.model.PasswordModel;
import com.deep.two.authority.model.UserModel;
import com.deep.two.dao.util.Pagination;
import com.deep.two.model.ApproveModel;
import com.deep.two.model.CompanyUserModel;
import com.deep.two.model.InvestorUserModel;
import com.deep.two.model.ResearchUserModel;
import com.deep.two.model.query.authority.UserQueryModel;
import com.deep.two.model.result.DMLResultModel;
import com.deep.two.model.result.QueryListReturnVo;
import com.deep.two.orm.User;
import com.deep.two.util.ViewException;

public interface UserService {

    DMLResultModel insert(UserModel userModel, CurrentUser user) throws ViewException;
    
    DMLResultModel insertResearchUser(ResearchUserModel researchUser, CurrentUser user) throws ViewException;

    UserModel getDetail(String id) throws ViewException;

    DMLResultModel update(UserModel userModel, CurrentUser user) throws ViewException;
    
    DMLResultModel updateEmailTel(UserModel userModel, CurrentUser user) throws ViewException;

    DMLResultModel delete(List<String> idList) throws ViewException;
    
    QueryListReturnVo<UserModel> query(UserQueryModel model, Pagination pagination) throws ViewException;

    DMLResultModel changePassword(PasswordModel model, CurrentUser user) throws ViewException;
  
    DMLResultModel recoveryPassword(List<String> userIdList, CurrentUser userModel) throws ViewException;
    
    DMLResultModel resetPassword(UserModel userModel, CurrentUser cu) throws ViewException;

    User queryById(String id) throws ViewException;
    
    void approve(ApproveModel am, CurrentUser user) throws ViewException;

	DMLResultModel insertInvestorUser(InvestorUserModel model, CurrentUser user) throws ViewException;

	DMLResultModel insertCompanyUser(CompanyUserModel model, CurrentUser currentUser) throws ViewException;
}
