/**
 * Copyright (c) 2014,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:fare-util
 * Package Name:com.travelsky.fare.fareutil.model
 * File Name:UnitList.java
 * Date:2014-10-24 上午10:47:17
 * 
 */
package com.deep.two.dao.util;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: UnitList <br/>
 * Description: 辅助工具类 <br/>
 * Date: 2014-10-24 上午10:47:17 <br/>
 * <br/>
 * 
 * @author zangling(邮箱)
 * 
 *         修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
 * @param <T> 泛型参数
 */

public class UnitList<T> {
    /**
     * list: 内部数据结构.
     */
    private List<T> list = new ArrayList<T>();

    /**
     * getList: 获取内部的list结构 <br/>
     * 
     * @return list <br/>
     */
    public List<T> getList() {
        return list;
    }

    /**
     * setList: setter方法 <br/>
     * 
     * @param list
     *            list <br/>
     */
    public void setList(List<T> list) {
        this.list = list;
    }

    /**
     * addEle: 添加T类型的元素 <br/>
     * 
     * @param t
     *            要添加的元素
     * @return UnitList<br/>
     */
    public UnitList<T> addEle(T t) {
        if (t != null) {
            list.add(t);
        }
        return this;
    }

    /**
     * removeEle: 移除一个T类型的元素 <br/>
     * 
     * @param t
     *            移除的元素
     * @return UnitList <br/>
     */
    public UnitList<T> removeEle(T t) {
        if (t != null) {
            list.remove(t);
        }
        return this;
    }

    /**
     * clear: 清空list <br/>
     * 
     * @return UnitList <br/>
     */
    public UnitList<T> clear() {
        list.clear();
        return this;
    }
    
    
    /**
     * isEmpty:判断List中是否存在值 <br/>
     * @return
     *            有值：true ；无值：false；<br/>
     */
    public boolean isEmpty(){
        return list==null||list.size()==0;
    }
    
    public UnitList<T> add(List<T> t) {
        if (t != null) {
            list.addAll(t);
        }
        return this;
    }    
}
