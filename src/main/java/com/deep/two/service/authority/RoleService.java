package com.deep.two.service.authority;

import java.util.List;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.deep.two.authority.model.CurrentUser;
import com.deep.two.authority.model.RoleModel;
import com.deep.two.authority.model.RoleQueryVO;
import com.deep.two.dao.util.Pagination;
import com.deep.two.model.result.DMLResultModel;
import com.deep.two.model.result.QueryListReturnVo;
import com.deep.two.util.ViewException;

public interface RoleService {
    
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public List<RoleModel> queryAll() throws ViewException;

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    DMLResultModel insert(RoleModel roleModel, CurrentUser user) throws ViewException;

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    RoleModel getDetail(String id) throws ViewException;

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    DMLResultModel update(RoleModel roleModel, CurrentUser user) throws ViewException;

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    DMLResultModel delete(List<String> idList) throws ViewException;
    
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    QueryListReturnVo<RoleModel> query(RoleQueryVO queryVO, Pagination pagination) throws ViewException;
}
