package com.deep.two.service.basic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.deep.two.dao.basic.BasicProvinceDAO;
import com.deep.two.orm.BasicProvince;
import com.deep.two.service.AbstractService;
import com.deep.two.service.basic.BasicProvinceService;

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
public class BasicProvinceServiceImpl extends AbstractService<BasicProvinceDAO, BasicProvince> implements BasicProvinceService{
    @Autowired
    private BasicProvinceDAO basicAreaDAO;

    @Override
    public BasicProvinceDAO getT() {
        return this.basicAreaDAO;
    }

	@Override
	public String getPath() {
		return null;
	}
}