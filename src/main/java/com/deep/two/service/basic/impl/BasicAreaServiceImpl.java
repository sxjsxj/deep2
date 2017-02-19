package com.deep.two.service.basic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.deep.two.dao.basic.BasicAreaDAO;
import com.deep.two.orm.BasicArea;
import com.deep.two.service.AbstractService;
import com.deep.two.service.basic.BasicAreaService;

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
public class BasicAreaServiceImpl extends AbstractService<BasicAreaDAO, BasicArea> implements BasicAreaService{
    @Autowired
    private BasicAreaDAO basicAreaDAO;

    @Override
    public BasicAreaDAO getT() {
        return this.basicAreaDAO;
    }

	@Override
	public String getPath() {
		return null;
	}
}