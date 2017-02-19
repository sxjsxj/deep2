package com.deep.two.service.authority;

import java.util.List;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.deep.two.authority.model.CurrentUser;
import com.deep.two.authority.model.ResourceModel;
import com.deep.two.authority.model.ResourceQueryVO;
import com.deep.two.dao.util.Pagination;
import com.deep.two.model.result.DMLResultModel;
import com.deep.two.model.result.QueryListReturnVo;
import com.deep.two.util.ViewException;

public interface ResourceService {
    
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    List<ResourceModel> queryAll() throws ViewException;
    
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    DMLResultModel insert(ResourceModel resourceModel, CurrentUser user) throws ViewException; 

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    ResourceModel getDetail(String id) throws ViewException;

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    DMLResultModel update(ResourceModel resourceModel, CurrentUser user) throws ViewException;

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    DMLResultModel delete(List<String> idList) throws ViewException;
    
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    QueryListReturnVo<ResourceModel> query(ResourceQueryVO queryVO, Pagination pagination) throws ViewException;
}
