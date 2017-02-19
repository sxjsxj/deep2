/**
 * Copyright (c) 2015,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:TrafficWebAuthorityService
 * Package Name:com.travelsky.fare.service.authority.model
 * File Name:ButtonModel.java
 * Date:2015-7-21 下午7:16:54
 * 
 */
package com.deep.two.authority.model;

/**
 * ClassName: ButtonModel <br/>
 * Description: TODO <br/>
 * Date: 2015-7-21 下午7:16:54 <br/>
 * <br/>
 * 
 * @author sunxijin(邮箱)
 * 
 *         修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
 * 
 */

public class ButtonModel {
    private String id;
    private boolean hidden;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    @Override
    public String toString() {
        return "ButtonModel [id=" + id + ", hidden=" + hidden + "]";
    }

}
