package com.deep.two.service.basic.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.deep.two.dao.basic.BasicProvinceAreaDAO;
import com.deep.two.orm.BasicProvinceArea;
import com.deep.two.service.AbstractService;
import com.deep.two.service.basic.BasicProvinceAreaService;


@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
public class BasicProvinceAreaServiceImpl extends AbstractService<BasicProvinceAreaDAO, BasicProvinceArea> implements BasicProvinceAreaService{
    @Autowired
    private BasicProvinceAreaDAO basicAreaDAO;

    @Override
    public BasicProvinceAreaDAO getT() {
        return this.basicAreaDAO;
    }

	@Override
	public String getPath() {
		return null;
	}
}