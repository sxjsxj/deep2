/**
 * Copyright (c) 2014,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:FareUtil
 * Package Name:com.travelsky.fare.fareutil.model
 * File Name:QueryListReturnVo.java
 * Date:2014-7-15 上午10:11:37
 * 
 */
package com.deep.two.model.result;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deep.two.dao.util.Pagination;

/**
 * ClassName: QueryListReturnVo <br/>
 * Description: 查询结果列表Vo <br/>
 * Date: 2014-7-15 上午10:11:37 <br/>
 * <br/>
 * 
 * @author zangling(邮箱)
 * 
 *         修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
 * @param <T>
 * 
 */

public class QueryListReturnVo<T> {
    private Map<Integer, String> validationInfo;
    private List<T> queryReturnList;
    private Pagination pagination = new Pagination();

    /**
     * Creates a new instance of QueryListReturnVo.<br/>
     * Description: 构造方法 <br/>
     */
    public QueryListReturnVo() {

    }

    /**
     * Creates a new instance of QueryListReturnVo.<br/>
     * Description: 构造方法 <br/>
     * 
     * @param queryReturnList
     *            查询列表
     */
    public QueryListReturnVo(List<T> queryReturnList) {
        this.queryReturnList = queryReturnList;
    }

    /**
     * Creates a new instance of QueryListReturnVo.<br/>
     * Description: 构造方法 <br/>
     * 
     * @param queryReturnList
     *            查询列表
     * @param pagination
     *            分页信息
     */
    public QueryListReturnVo(List<T> queryReturnList, Pagination pagination) {
        this.queryReturnList = queryReturnList;
        this.validationInfo = new HashMap<Integer, String>();
        this.pagination = pagination;
    }

    public Map<Integer, String> getValidationInfo() {
        return validationInfo;
    }

    /**
     * setQueryRerturnList: setter方法 <br/>
     * 
     * @param returnList
     *            查询列表
     * @return 查询列表Vo <br/>
     */
    public QueryListReturnVo<T> setQueryRerturnList(List<T> returnList) {
        this.queryReturnList = returnList;
        return this;
    }

    /**
     * getQueryReturnList: getter方法 <br/>
     * 
     * @return 查询列表 <br/>
     */
    public List<T> getQueryReturnList() {
        return this.queryReturnList;
    }

    /**
     * setQueryReturnList: setter方法 <br/>
     * 
     * @param queryReturnList
     *            queryReturnList <br/>
     */
    public void setQueryReturnList(List<T> queryReturnList) {
        this.queryReturnList = queryReturnList;
    }

    /**
     * getPagination: getter方法 <br/>
     * 
     * @return 分页信息<br/>
     */
    public Pagination getPagination() {
        return pagination;
    }

    /**
     * setPagination: setter方法 <br/>
     * 
     * @param pagination
     *            分页信息
     * @return 查询列表Vo <br/>
     */
    public QueryListReturnVo<T> setPagination(Pagination pagination) {
        this.pagination = pagination;
        return this;
    }

    /**
     * getCurrentPage: geter方法<br/>
     * 
     * @return 当前页<br/>
     */
    public Integer getCurrentPage() {
        if (getPagination() == null) {
            return null;
        } else {
            return getPagination().getCurrentPage();
        }
    }

    /**
     * setCurrentPage: setter方法 <br/>
     * 
     * @param currentPage
     *            当前页
     * @return 查询列表Vo <br/>
     */
    public QueryListReturnVo<T> setCurrentPage(Integer currentPage) {
        if (getPagination() != null) {
            getPagination().setCurrentPage(currentPage);
        }
        return this;
    }

    /**
     * getSumRecord: getter方法 <br/>
     * 
     * @return 总记录数<br/>
     */
    public Integer getSumRecord() {
        if (getPagination() == null) {
            return null;
        }
        return getPagination().getSumRecord();
    }

    /**
     * setSumRecord: setter方法 <br/>
     * 
     * @param sumRecord
     *            总记录数
     * @return 查询列表Vo<br/>
     */
    public QueryListReturnVo<T> setSumRecord(Integer sumRecord) {
        if (getPagination() != null) {
            getPagination().setSumRecord(sumRecord);
        }
        return this;
    }

    /**
     * getMaxRecordPerPage: getter方法<br/>
     * 
     * @return 每页最大记录数<br/>
     */
    public Integer getMaxRecordPerPage() {
        if (getPagination() == null) {
            return null;
        }
        return getPagination().getMaxRecordPerPage();
    }

    /**
     * setMaxRecordPerPage:setter方法 <br/>
     * 
     * @param maxRecordPerPage
     *            每页最大记录数
     * @return 每页最大记录数 <br/>
     */
    public QueryListReturnVo<T> setMaxRecordPerPage(Integer maxRecordPerPage) {
        if (getPagination() != null) {
            getPagination().setMaxRecordPerPage(maxRecordPerPage);
        }
        return this;
    }

    /**
     * getQueryReturnListToString: getter方法 <br/>
     * 
     * @return QueryReturnListToString <br/>
     */
    private String getQueryReturnListToString() {

        if (queryReturnList == null || queryReturnList.size() <= 0) {
            return null;
        }
        StringBuffer bf = new StringBuffer();
        for (T queryReturn : queryReturnList) {
            bf.append(queryReturn.toString()).append(",");
        }
        return "queryReturnList [List=" + bf.substring(0, bf.length() - 1).toString() + "]";
    }

    @Override
    public String toString() {
        return "QueryListReturnVo [validationInfo=" + validationInfo + ", queryReturnList="
                + this.getQueryReturnListToString() + ", pagination=" + pagination + "]";
    }

}
