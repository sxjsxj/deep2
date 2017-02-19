/**
 * Copyright (c) 2014,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:AirtisWebDao-trunk
 * Package Name:com.travelsky.fare.airtis.dao.helper
 * File Name:DaoUtil.java
 * Date:2014-7-14 下午3:46:57
 * 
 */
package com.deep.two.dao.util;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.deep.two.util.CollectionUtil;
import com.deep.two.util.ViewException;

@Repository("daoUtil")
public class DaoUtil extends HibernateDaoSupport {
    private static final String UNCHECKED = "unchecked";

    /**
     * setSuperSessionFactory:注入sessionFactory<br/>
     * 
     * @param sessionFactory
     *            注入的sessionFactory
     */
    @Autowired
    @Qualifier("sessionFactory")
    public void setSuperSessionFactory(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }

    /**
     * 
     * queryList:根据传入的class和条件查询数据<br/>
     * 该查询方法通过反射实现对已有orm进行查询 <br/>
     * clazz为要查询的orm类型（例如：DfimTPnfpo.class）<br/>
     * 如orderList，pagination设置为null，则默认进行无序，无分页查询<br/>
     * 
     * @param criteriaUnitList
     *            SQL语句查询条件
     * @param orderList
     *            排序集合
     * @param pagination
     *            分页
     * @param clazz
     *            指定查询的class
     * @param <T>
     *            clazz类的类型
     * @return 查询到的T类型结果集
     * @throws ViewException
     *             if has error
     */
    @SuppressWarnings(UNCHECKED)
    public <T> List<T> queryList(List<CriterionUnit> criteriaUnitList, List<OrderUnit> orderList,
            Pagination pagination, Class<T> clazz) throws ViewException {
        Criterion criterion = null;
        criterion = CriterionUtil.createCriterion(criteriaUnitList);
        Criteria criteria = this.getSession().createCriteria(clazz);
        if (criterion != null) {
            criteria.add(criterion);
        }
        criteria = CriteriaUtil.createOrder(criteria, orderList);
        criteria = CriteriaUtil.createPaging(criteria, pagination);
        return criteria.list();
    }

    /**
     * 
     * queryList:根据传入的class和条件查询数据<br/>
     * 该查询方法通过反射实现对已有orm进行查询 <br/>
     * clazz为要查询的orm类型（例如：DfimTPnfpo.class）<br/>
     * 如orderList，pagination设置为null，则默认进行无序，无分页查询<br/>
     * 
     * @param criteriaUnitList
     *            SQL语句查询条件1
     * 
     * @param ctr
     *            SQL语句查询条件2
     * 
     * @param orderList
     *            排序集合
     * @param pagination
     *            分页
     * @param clazz
     *            指定查询的class
     * @param <T>
     *            clazz类的类型
     * @return 查询到的T类型结果集
     * @throws ViewException
     *             if has error
     */
    @SuppressWarnings(UNCHECKED)
    public <T> List<T> queryList(List<CriterionUnit> criteriaUnitList, Criterion ctr, List<OrderUnit> orderList,
            Pagination pagination, Class<T> clazz) throws ViewException {
        Criterion criterion = null;
        Criterion allCtr = null;
        criterion = CriterionUtil.createCriterion(criteriaUnitList);
        Criteria criteria = this.getSession().createCriteria(clazz);

        allCtr = DaoUtil.mergeCtr(criterion, ctr);

        if (allCtr != null) {
            criteria.add(allCtr);
        }
        criteria = CriteriaUtil.createOrder(criteria, orderList);
        criteria = CriteriaUtil.createPaging(criteria, pagination);
        return criteria.list();
    }

    /**
     * queryList:根据传入的class和条件查询数据 <br/>
     * 该查询方法通过反射实现对已有orm进行查询 <br/>
     * clazz为要查询的orm类型（例如：DfimTPnfpo.class）<br/>
     * 如orderList，pagination设置为null，则默认进行无序，无分页查询<br/>
     * 
     * @param criterion
     *            SQL 语句查询条件
     * @param orderList
     *            排序集合
     * @param pagination
     *            分页model
     * @param clazz
     *            指定查询的model
     * @param <T>
     *            clazz类的类型
     * @return 查询到的T类型结果集
     * 
     */
    @SuppressWarnings(UNCHECKED)
    public <T> List<T> queryList(Criterion criterion, List<OrderUnit> orderList, Pagination pagination, Class<T> clazz) {
        Criteria criteria = this.getSession().createCriteria(clazz);
        if (criterion != null) {
            criteria.add(criterion);
        }
        criteria = CriteriaUtil.createOrder(criteria, orderList);
        criteria = CriteriaUtil.createPaging(criteria, pagination);
        return criteria.list();
    }
    
    @SuppressWarnings(UNCHECKED)
    public <T> List<T> queryList(Criteria criteria, List<OrderUnit> orderList, Pagination pagination) {
        criteria = CriteriaUtil.createOrder(criteria, orderList);
        criteria = CriteriaUtil.createPaging(criteria, pagination);
        return criteria.list();
    }

    /**
     * queryList:根据传入的class和条件查询数据 <br/>
     * 
     * @param criterion
     *            SQL 语句查询条件
     * @param clazz
     *            指定查询的model
     * @param <T>
     *            指定查询的model的类型
     * @return 查询到的T类型结果集
     * 
     */
    public <T> List<T> queryList(Criterion criterion, Class<T> clazz) {
        return this.queryList(criterion, null, null, clazz);
    }

    /**
     * queryList:根据传入的class和条件查询数据 <br/>
     * 
     * @param criteriaUnitList
     *            SQL 语句查询条件
     * @param clazz
     *            指定查询的model
     * @param <T>
     *            指定查询的model的类型
     * @return 查询到的T类型结果集
     * @throws ViewException
     *             if has error
     */
    public <T> List<T> queryList(List<CriterionUnit> criteriaUnitList, Class<T> clazz) throws ViewException {
        return this.queryList(criteriaUnitList, null, null, clazz);
    }

    /**
     * uniqueQuery: 当根据查询条件可以确定返回唯一一条记录时使用<br/>
     * 
     * @param criteriaUnitList
     *            查询条件的集合
     * @param clazz
     *            POJO类
     * @param <T>
     *            泛型参数
     * @return 一条记录
     * @throws ViewException
     *             自定义异常类 <br/>
     */
    @SuppressWarnings(UNCHECKED)
    public <T> T uniqueQuery(List<CriterionUnit> criteriaUnitList, Class<T> t) throws ViewException {
        Criterion criterion = CriterionUtil.createCriterion(criteriaUnitList);
        return (T) this.getSession().createCriteria(t).add(criterion).uniqueResult();
    }

    /**
     * queryCount:根据传入的class和条件查询数据条数 <br/>
     * 
     * @param criteriaUnitList
     *            SQL 语句查询条件
     * @param clazz
     *            指定查询的model
     * @param <T>
     *            指定查询的model的类型
     * @return 查询到的数据条数
     * @throws ViewException
     *             if has error
     */
    public <T> int queryCount(List<CriterionUnit> criteriaUnitList, Class<T> clazz) throws ViewException {
        Criterion criterion = null;
        criterion = CriterionUtil.createCriterion(criteriaUnitList);
        Criteria criteria = this.getSession().createCriteria(clazz);
        if (criterion != null) {
            criteria.add(criterion);
        }
        criteria.setProjection(Projections.rowCount());
        return Integer.parseInt(criteria.uniqueResult().toString());
    }
    
    public <T> int queryCount(Criteria criteria) throws ViewException {
        criteria.setProjection(Projections.rowCount());
        return Integer.parseInt(criteria.uniqueResult().toString());
    	//return criteria.list().size();
    }

    /**
     * queryCount:根据传入的class和条件查询数据条数 <br/>
     * 
     * @param criteriaUnitList
     *            SQL 语句查询条件1
     * 
     * @param ctr
     *            SQL 语句查询条件2
     * @param clazz
     *            指定查询的model
     * @param <T>
     *            指定查询的model的类型
     * @return 查询到的数据条数
     * @throws ViewException
     *             if has error
     */
    public <T> int queryCount(List<CriterionUnit> criteriaUnitList, Criterion ctr, Class<T> clazz)
            throws ViewException {
        Criterion criterion = null;
        Criterion allctr = null;
        criterion = CriterionUtil.createCriterion(criteriaUnitList);
        Criteria criteria = this.getSession().createCriteria(clazz);
        criteria.setProjection(Projections.rowCount());

        allctr = DaoUtil.mergeCtr(criterion, ctr);

        if (allctr != null) {
            criteria.add(allctr);
        }
        return Integer.parseInt(criteria.uniqueResult().toString());
    }

    /**
     * queryCount:根据传入的class和条件查询数据条数 <br/>
     * 根据clazz指定orm类型，查询满足条件的的数据条数 <br/>
     * 
     * @param criterion
     *            SQL 语句查询条件
     * @param clazz
     *            指定查询的model
     * @param <T>
     *            指定查询的model的类型
     * @return 查询到的数据条数
     */
    public <T> int queryCount(Criterion criterion, Class<T> clazz) {
        Criteria criteria = this.getSession().createCriteria(clazz);
        criteria.setProjection(Projections.rowCount());
        if (criterion != null) {
            criteria.add(criterion);
        }
        return Integer.parseInt(criteria.uniqueResult().toString());
    }

    /**
     * insertAll:插入批量数据 <br/>
     * 
     * @param list
     *            要插入的批量对象
     * @param <T>
     *            要插入的对象的类型
     */
    public <T> void insertAll(List<T> list) {
        for (T t : list) {
            this.getHibernateTemplate().save(t);
        }
    }

    /**
     * insert:插入数据 <br/>
     * 
     * @param t
     *            要插入的对象
     * @param <T>
     *            要插入的对象的类型
     */
    public <T> void insert(T t) {
        this.getHibernateTemplate().save(t);
    }

    /**
     * query: 按照主键查询 <br/>
     * 
     * @param t
     *            泛型参数class类型
     * @param <T>
     *            泛型参数
     * @param id
     *            主键id
     * @return T类型的数据<br/>
     */
    public <T> T queryById(Class<T> t, Serializable id) {
        return this.getHibernateTemplate().get(t, id);
    }

    /**
     * update:更新数据 <br/>
     * 
     * @param t
     *            要更新的对象
     * @param <T>
     *            要更新的对象的类型
     * @return 
     */
    public <T> void update(T t) {
		this.getHibernateTemplate().update(t);
    }

    /**
     * saveOrUpdate:保存或更新数据 <br/>
     * 
     * @param t
     *            要更新的对象
     * @param <T>
     *            要更新的对象的类型
     */
    public <T> void saveOrUpdate(T t) {
        this.getHibernateTemplate().saveOrUpdate(t);
    }

    /**
     * delete:删除数据<br/>
     * 
     * @param t
     *            要删除的对象
     * @param <T>
     *            要删除的对象的类型
     */
    public <T> void delete(T t) {
        this.getHibernateTemplate().delete(t);
    }

    /**
     * 
     * deleteAll:批量删除对象<br/>
     * 
     * @param t
     *            要删除的对象集合
     * @param <T>
     *            要删除的对象集合的类型
     */
    public <T> int deleteAll(List<T> t) {
        int result = 0;
        try {
            this.getHibernateTemplate().deleteAll(t);
        } catch (Exception e) {
            result = 1;
        }
        return result;
    }

    /**
     * deleteAll:根据主键批量删除对象<br/>
     * 
     * @param pkList
     *            主键列表
     * @param <T>
     *            要删除的对象集合的类型
     * @param <E>
     *            指定要删除的对象所属的类
     * @param clazz
     *            要删除的对象所属的class
     * @throws ViewException
     *             if has error
     */
    public <T, E> void deleteAll(List<T> pkList, Class<E> clazz) throws ViewException {
        for (T t : pkList) {
            E e = uniqueQuery(CriteriaUtil.vo2CriteriaUnitList(t), clazz);
            this.getHibernateTemplate().delete(e);
        }
    }

    public <E> void deleteAllByIds(List<Serializable> ids, Class<E> clazz) throws ViewException {
        for (Serializable id : ids) {
            E e = queryById(clazz, id);
            this.getHibernateTemplate().delete(e);
        }
    }
    
    public <E> void deleteById(Serializable id, Class<E> clazz) throws ViewException {
        E e = queryById(clazz, id);
        this.getHibernateTemplate().delete(e);
    }

    /**
     * setModel将前台model的属性设置给后台model <br/>
     * t和e为同一类型对象，此方法是将t的属性值赋给e，由clazz指定类型 <br/>
     * 如果t中有属性值为null，则e中相应的属性不改变<br/>
     * 
     * @param clazz
     *            : 指定反射model
     * @param t
     *            前台传入的model
     * @param e
     *            后台要修改的 model
     * @param <T>
     *            前台传入的model的类型
     * @return 后台修改后的model
     * @throws NoSuchMethodException
     *             if has error
     * @throws InvocationTargetException
     *             if has error
     * @throws IllegalAccessException
     *             if has error
     */
    private <T> T setModel(Class<T> clazz, T t, T e) throws ViewException {
        Field[] fields = clazz.getDeclaredFields();
        Method getMethod = null;
        Method setMethod = null;
        Object value = null;
        ViewException fe = null;
        for (int i = 0; i < fields.length; i++) {
            try {
                Field field = fields[i];
                String fieldName = field.getName();
                if (clazz.getName().endsWith("DfimTBatch") && "fileNo".equals(fieldName)) {
                    continue;
                }
                if (clazz.getName().endsWith("FpubTModel") && "modelName".equals(fieldName)) {
                    continue;
                }
                if (clazz.getName().endsWith("FpubTNaviRights") && "seqNum".equals(fieldName)) {
                    continue;
                }
                String firstLetter = fieldName.substring(0, 1).toUpperCase();
                // 获得和属性对应的getXXX()方法的名字
                String getMethodName = "get" + firstLetter + fieldName.substring(1);
                // 获得和属性对应的setXXX()方法的名字
                String setMethodName = "set" + firstLetter + fieldName.substring(1);
                // 获得和属性对应的getXXX()方法
                getMethod = clazz.getMethod(getMethodName, new Class[] {});
                // 获得和属性对应的setXXX()方法
                setMethod = clazz.getMethod(setMethodName, new Class[] { field.getType() });
                // 调用原对象的getXXX()方法
                value = getMethod.invoke(t, new Object[] {});
                // 调用复制对象的setXXX()方法
                if (!(value == null || fieldName.endsWith("PK"))) {
                    setMethod.invoke(e, new Object[] { value });
                }
            } catch (IllegalAccessException ex) {
                fe = new ViewException();
                fe.initCause(ex);
                throw fe;
            } catch (NoSuchMethodException ex) {
                fe = new ViewException();
                fe.initCause(ex);
                throw fe;
            } catch (InvocationTargetException ex) {
                fe = new ViewException();
                fe.initCause(ex);
                throw fe;
            }
        }
        return e;
    }

    /**
     * 
     * updateDBObject:根据前台传入model批量修改指定model <br/>
     * 根据查询条件criteriaUnitList查询到clazz类型的数据组，然后将其全部赋值为t <br/>
     * 如果t中有属性值为null则，查询到的数据组中相应的属性保留原有值不改变 <br/>
     * 
     * @param criteriaUnitList
     *            查询条件
     * @param clazz
     *            指定反射model
     * @param t
     *            前台传入的model
     * @param <T>
     *            前台传入的model的类型
     * 
     * @throws ViewException
     *             if has error
     */
    public <T> void updateDBObject(List<CriterionUnit> criteriaUnitList, Class<T> clazz, T t) throws ViewException {
        List<T> list = this.queryList(criteriaUnitList, clazz);
        for (T e : list) {
            e = this.setModel(clazz, t, e);
            this.getHibernateTemplate().update(e);
        }
    }

    public <T> void updateDBObject(Class<T> clazz,  Serializable id, T t) throws ViewException {
        T e = this.queryById(clazz, id);
        this.getSession().clear();
        e = this.setModel(clazz, t, e);
        this.update(e);
    }

    /**
     * 
     * queryMax:查询指定属性最大值<br/>
     * 
     * @param criteriaUnitList
     *            SQL 语句查询条件
     * @param clazz
     *            要查询的orm的类型
     * @param propertyName
     *            查询的orm的中指定属性
     * @param returnClass
     *            查询结果的返回类型
     * @param <T>
     *            传入参数clazz的类型
     * @param <E>
     *            查询结果的返回类型
     * @return 后台修改后的model
     * @throws ViewException
     *             if has error
     */
    @SuppressWarnings(UNCHECKED)
    public <T, E> E queryMax(List<CriterionUnit> criteriaUnitList, Class<T> clazz, String propertyName,
            Class<E> returnClass) throws ViewException {

        Criterion criterion = null;
        criterion = CriterionUtil.createCriterion(criteriaUnitList);
        Criteria criteria = this.getSession().createCriteria(clazz);
        criteria.setProjection(Projections.max(propertyName));
        if (criterion != null) {
            criteria.add(criterion);
        }
        return (E) criteria.uniqueResult();
    }

    /**
     * 
     * queryMin:查询指定属性最大值<br/>
     * 
     * @param criteriaUnitList
     *            SQL 语句查询条件
     * @param clazz
     *            要查询的orm的类型
     * @param propertyName
     *            查询的orm的中指定属性
     * @param returnClass
     *            查询结果的返回类型
     * @param <T>
     *            传入参数clazz的类型
     * @param <E>
     *            查询结果的返回类型
     * @return 后台修改后的model
     * @throws ViewException
     *             if has error
     */
    @SuppressWarnings(UNCHECKED)
    public <T, E> E queryMin(List<CriterionUnit> criteriaUnitList, Class<T> clazz, String propertyName,
            Class<E> returnClass) throws ViewException {

        Criterion criterion = null;
        criterion = CriterionUtil.createCriterion(criteriaUnitList);
        Criteria criteria = this.getSession().createCriteria(clazz);
        criteria.setProjection(Projections.min(propertyName));
        if (criterion != null) {
            criteria.add(criterion);
        }
        return (E) criteria.uniqueResult();
    }

    /**
     * queryProperty:查询指定属性 <br/>
     * 
     * @param criteriaUnitList
     *            SQL 语句查询条件
     * @param clazz
     *            指定反射model的类型
     * @param propertyName
     *            要查询的属性名称
     * @param returnClass
     *            指定返回类型
     * @param <T>
     *            传入参数clazz的类型
     * @param <E>
     *            查询结果的返回集合的类型，既名为propertyName属性的类型
     * @return 查询结果list
     * @throws ViewException
     *             if has error
     */
    public <T, E> List<E> queryProperty(List<CriterionUnit> criteriaUnitList, Class<T> clazz, String propertyName,
            Class<E> returnClass) throws ViewException {
        return this.queryProperty(criteriaUnitList, null, null, clazz, propertyName, returnClass);
    }

    /**
     * queryProperty:查询指定属性 <br/>
     * 
     * @param criteriaUnitList
     *            SQL 语句查询条件
     * @param orderList
     *            排序条件
     * @param clazz
     *            指定反射model的类型
     * @param propertyName
     *            要查询的属性名称
     * @param returnClass
     *            指定返回类型
     * @param <T>
     *            传入参数clazz的类型
     * @param <E>
     *            查询结果的返回集合的类型，既名为propertyName属性的类型
     * @return 查询结果list
     * @throws ViewException
     *             if has error
     */
    public <T, E> List<E> queryProperty(List<CriterionUnit> criteriaUnitList, List<OrderUnit> orderList,
            Class<T> clazz, String propertyName, Class<E> returnClass) throws ViewException {
        return this.queryProperty(criteriaUnitList, orderList, null, clazz, propertyName, returnClass);
    }

    /**
     * 
     * queryProperty:查询指定属性 <br/>
     * 
     * @param criteriaUnitList
     *            SQL 语句查询条件
     * @param orderList
     *            排序条件
     * @param pagination
     *            分页条件
     * @param clazz
     *            指定反射model的类型
     * @param propertyName
     *            要查询的属性名称
     * @param returnClass
     *            指定返回类型
     * @param <T>
     *            传入参数clazz的类型
     * @param <E>
     *            查询结果的返回集合的类型，既名为propertyName属性的类型
     * @return 查询结果list
     * @throws ViewException
     *             if has error
     */
    @SuppressWarnings(UNCHECKED)
    public <T, E> List<E> queryProperty(List<CriterionUnit> criteriaUnitList, List<OrderUnit> orderList,
            Pagination pagination, Class<T> clazz, String propertyName, Class<E> returnClass) throws ViewException {
        Criterion criterion = null;
        criterion = CriterionUtil.createCriterion(criteriaUnitList);
        Criteria criteria = this.getSession().createCriteria(clazz);
        if (criterion != null) {
            criteria.add(criterion);
        }
        criteria = CriteriaUtil.createOrder(criteria, orderList);
        criteria = CriteriaUtil.createPaging(criteria, pagination);
        criteria.setProjection(Projections.property(propertyName));

        return (List<E>) criteria.list();
    }

    /**
     * 
     * queryDistinctProperty:查询指定属性 (去重去空)<br/>
     * 
     * @param criteriaUnitList
     *            SQL 语句查询条件
     * @param orderList
     *            排序条件
     * @param clazz
     *            指定反射model的类型
     * @param propertyName
     *            要查询的属性名称
     * @param returnClass
     *            指定返回类型
     * @param <T>
     *            传入参数clazz的类型
     * @param <E>
     *            查询结果的返回集合的类型，既名为propertyName属性的类型
     * @return 查询结果list
     * @throws ViewException
     *             if has error
     */
    @SuppressWarnings(UNCHECKED)
    public <T, E> List<E> queryDistinctProperty(List<CriterionUnit> criteriaUnitList, List<OrderUnit> orderList, Class<T> clazz,
            String propertyName, Class<E> returnClass) throws ViewException {
        Criterion criterion = null;
        criterion = CriterionUtil.createCriterion(criteriaUnitList);
        Criteria criteria = this.getSession().createCriteria(clazz);
        if (criterion != null) {
            criteria.add(criterion);
        }
        criteria = CriteriaUtil.createOrder(criteria, orderList);
        criteria.setProjection(Projections.distinct(Projections.property(propertyName)));
        List<E> propertylist = (List<E>) criteria.list();
        for (int i = 0; i < propertylist.size(); i++) {
            if (null == propertylist.get(i)) {
                propertylist.remove(0);
            }
        }
        return propertylist;
    }
    
    /**
     * 
     * queryDistinctProperty:查询指定属性 (去重去空)<br/>
     * 
     * @param criteriaUnitList
     *            SQL 语句查询条件
     * @param clazz
     *            指定反射model的类型
     * @param propertyName
     *            要查询的属性名称
     * @param returnClass
     *            指定返回类型
     * @param <T>
     *            传入参数clazz的类型
     * @param <E>
     *            查询结果的返回集合的类型，既名为propertyName属性的类型
     * @return 查询结果list
     * @throws ViewException
     *             if has error
     */
    public <T, E> List<E> queryDistinctProperty(List<CriterionUnit> criteriaUnitList, Class<T> clazz,
            String propertyName, Class<E> returnClass) throws ViewException {
        Criterion criterion = null;
        criterion = CriterionUtil.createCriterion(criteriaUnitList);
        Criteria criteria = this.getSession().createCriteria(clazz);
        if (criterion != null) {
            criteria.add(criterion);
        }
        criteria.setProjection(Projections.distinct(Projections.property(propertyName)));
        List<E> propertylist = (List<E>) criteria.list();
        for (int i = 0; i < propertylist.size(); i++) {
            if (null == propertylist.get(i)) {
                propertylist.remove(0);
            }
        }
        return propertylist;
    }

    /**
     * getCurrentSession: 获取当前Session <br/>
     * 
     * @return 获取当前会话<br/>
     */
    public Session getCurrentSession() {
        return this.getSession();
    }

    /**
     * getNewSession: 获取新的会话 <br/>
     * 
     * @return 创建新的会话 <br/>
     */
    public Session getNewSession() {
        return this.getSession(true);
    }

    public static Criterion mergeCtr(Criterion ctr1, Criterion ctr2) {
        if (ctr1 != null && ctr2 != null) {
            return Restrictions.and(ctr1, ctr2);
        }
        return helperForMerge(ctr1, ctr2);
    }

    public static Criterion mergeCtrUseOr(Criterion ctr1, Criterion ctr2) {
        if (ctr1 != null && ctr2 != null) {
            return Restrictions.or(ctr1, ctr2);
        }
        return helperForMerge(ctr1, ctr2);
    }

    //都用or merge
    public static Criterion mergeCtrUseDisjunction(List<Criterion> ctrs) {
        if (CollectionUtil.isEmpty(ctrs)) {
            return null;
        }
        Disjunction d = Restrictions.disjunction();
        for (Criterion ctr : ctrs) {
            if (ctr != null) {
                d.add(ctr);
            }
        }
        return d;
    }

    //都用and merge
    public static Criterion mergeCtrUseConjunction(List<Criterion> ctrs) {
        if (CollectionUtil.isEmpty(ctrs)) {
            return null;
        }
        Conjunction c = Restrictions.conjunction();
        for (Criterion ctr : ctrs) {
            if (ctr != null) {
                c.add(ctr);
            }
        }
        return c;
    }

    private static Criterion helperForMerge(Criterion ctr1, Criterion ctr2) {
        if (ctr1 == null && ctr2 != null) {
            return ctr2;
        } else if (ctr1 != null && ctr2 == null) {
            return ctr1;
        } else {
            return null;
        }
    }
}
