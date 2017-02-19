package com.deep.two.service.basic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.deep.two.dao.basic.BasicResearchFieldDAO;
import com.deep.two.orm.BasicResearchField;
import com.deep.two.service.AbstractService;
import com.deep.two.service.basic.BasicResearchFieldService;

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
public class BasicResearchFieldServiceImpl extends AbstractService<BasicResearchFieldDAO, BasicResearchField> implements BasicResearchFieldService{
    @Autowired
    private BasicResearchFieldDAO basicAreaDAO;

    @Override
    public BasicResearchFieldDAO getT() {
        return this.basicAreaDAO;
    }

	@Override
	public String getPath() {
		return null;
	}
}