/**
 * Copyright (c) 2014,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:FareUtitl
 * Package Name:com.travelsky.fare.fareutil.model
 * File Name:OrderUnit.java
 * Date:2014-7-10 下午1:39:45
 * 
 */
package com.deep.two.dao.util;

public class OrderUnit {

    public static final int ASC = 0;
    public static final int DESC = 1;
    // 排序所根据的属性
    private String key;
    // 排序，0为asc，1为desc
    private int orderType;

    /**
     * Creates a new instance of OrderUnit.<br/>
     * @param key 排序所按照的属性
     */
    public OrderUnit(String key) {
        this.key = key;
        this.orderType = ASC;
    }

    /**
     * 
     * Creates a new instance of OrderUnit.<br/>
     * 
     * @param key
     *            排序所按照的属性
     * @param orderType
     *            升序或者降序排序
     */
    public OrderUnit(String key, int orderType) {
        this.key = key;
        this.orderType = orderType;
    }

    /**
     * getKey:获取所按照排序的属性 <br/>
     * 
     * @return 排序属性 值
     */
    public String getKey() {
        return key;
    }

    /**
     * 
     * setKey:set排序属性值对应orm中的属性<br/>
     * 
     * @param key
     *            orm中规范的属性
     * @return 设置后的该OrderUnit对象
     */
    public OrderUnit setKey(String key) {
        this.key = key;
        return this;
    }

    /**
     * getOrderType:获取排序升降序 <br/>
     * 
     * @return 升序或者降序
     */
    public int getOrderType() {
        return orderType;
    }

    /**
     * setOrderType:设置排序升降序<br/>
     * 
     * @param orderType
     *            asc or desc
     * @return 设置后的该OrderUnit对象
     */
    public OrderUnit setOrderType(int orderType) {
        this.orderType = orderType;
        return this;
    }

    @Override
    public String toString() {
        return "OrderUnit [key=" + key + ", orderType=" + orderType + "]";
    }
}
