/**
 * Copyright (c) 2014,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:FareUtil
 * Package Name:com.travelsky.fare.fareutil.model
 * File Name:Pagination.java
 * Date:2014-7-15 下午4:08:53
 * 
 */
package com.deep.two.dao.util;

/**
 * 
 * ClassName: Pagination <br/>
 * Date: 2014-9-18 下午2:14:47 <br/>
 * <br/>
 * 
 * @author Administrator(邮箱)
 * 
 *         修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
 * 
 */
public class Pagination {
    private Integer currentPage = 0;
    private Integer sumRecord;
    private Integer maxRecordPerPage;
    private Integer sumPage;

    /**
     * 
     * getSumPage:获取分页总页数 <br/>
     * 
     * @return 分页总页数
     */
    public Integer getSumPage() {
        return sumPage;
    }

    /**
     * 
     * setSumPage:设置分页总数 <br/>
     * 
     * @param sumPage
     *            分页总数
     */
    public void setSumPage(Integer sumPage) {
        this.sumPage = sumPage;
    }

    /**
     * getCurrentPage:获取当前页数<br/>
     * 
     * @return 当前页数
     */
    public Integer getCurrentPage() {
        return currentPage;
    }

    /**
     * setCurrentPage:设置当前页数<br/>
     * 
     * @param currentPage
     *            当前页数
     * @return 设置当前页数后的Pagination对象
     */
    public Pagination setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
        return this;
    }

    /**
     * getSumRecord:获取总记录条数<br/>
     * 
     * @return 总记录条数
     */
    public Integer getSumRecord() {
        return sumRecord;
    }

    /**
     * setSumRecord:设置总记录条数 <br/>
     * 
     * @param sumRecord
     *            总记录条数
     * @return 设置总记录条数后的Pagination对象
     */
    public Pagination setSumRecord(Integer sumRecord) {
        this.sumRecord = sumRecord;
        this.sumPage = generatorSumPage();
        return this;
    }

    /**
     * getMaxRecordPerPage:获取每页记录最大值<br/>
     * 
     * @return 每页九路最大值
     */
    public Integer getMaxRecordPerPage() {
        return maxRecordPerPage;
    }

    /**
     * setMaxRecordPerPage:设置每页最大记录值<br/>
     * 
     * @param maxRecordPerPage
     *            每页最大记录值
     * @return 设置每页最大记录值后的Pagination对象
     */
    public Pagination setMaxRecordPerPage(Integer maxRecordPerPage) {
        this.maxRecordPerPage = maxRecordPerPage;
        this.sumPage = generatorSumPage();
        return this;
    }

    private int generatorSumPage() {
        int countPage = 0;
        if (this.sumRecord != null && this.maxRecordPerPage != null) {
            countPage = (int) Math.ceil(Double.valueOf(this.sumRecord)
                    / Double.valueOf(this.maxRecordPerPage));
        }
        return countPage;
    }

    @Override
    public String toString() {
        return "Pagination [currentPage=" + currentPage + ", sumRecord=" + sumRecord + ", maxRecordPerPage="
                + maxRecordPerPage + "]";
    }
}
