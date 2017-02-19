/**
 * Copyright (c) 2015,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:FareUtil
 * Package Name:com.travelsky.fare.fareutil.commontools
 * File Name:JSONUtil.java
 * Date:2015-2-3 下午5:23:55
 * 
 */
package com.deep.two.util;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;


 /**
 * ClassName: JSONUtil <br/>
 * Description: TODO <br/>
 * Date: 2015-2-3 下午5:23:55 <br/>
 * <br/>
 * 
 * @author sunxijin(邮箱)
 * 
 * 修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
 * 
 */

public final class JSONUtil {
    /*默认的日期格式*/
    private static final String DEFAULT_FORMAT = "yyyy-MM-dd";
    
    /**
     * getJSONStr: 获取一个对象的JSON字符串 <br/>
     * 
     * @param obj 待转换对象
     * @param str 字符串
     * @return json字符串
     * @throws ViewException
     *             异常<br/>
     */
    public static String modelToJson(Object obj, String str) throws ViewException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(JsonMethod.FIELD, Visibility.ANY);
        mapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.configure(SerializationConfig.Feature.AUTO_DETECT_FIELDS, true);
        mapper.configure(SerializationConfig.Feature.AUTO_DETECT_GETTERS, false);
        mapper.configure(SerializationConfig.Feature.AUTO_DETECT_IS_GETTERS, false);
        //mapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);
        DateFormat dateFormat = null;
        if (StringUtil.isEmpty(str)) {
            dateFormat = new SimpleDateFormat(DEFAULT_FORMAT);
        } else {
            dateFormat = new SimpleDateFormat(str);
        }
        
        mapper.writer(dateFormat);
        mapper.setSerializationConfig(mapper.getSerializationConfig().withDateFormat(dateFormat));
        String jsonStr = "";
        try {
            if (obj != null) {
                jsonStr = mapper.writeValueAsString(obj);
                jsonStr = jsonStr.replaceAll("\"", "'");
            }
            return jsonStr;
        } catch (JsonGenerationException e) {
            ViewException fe = new ViewException();
            fe.initCause(e);
            throw fe;
        } catch (JsonMappingException e) {
            ViewException fe = new ViewException();
            fe.initCause(e);
            throw fe;
        } catch (IOException e) {
            ViewException fe = new ViewException();
            fe.initCause(e);
            throw fe;
        }
    }
    
    public static <T> T jsonToModel(String jsonStr, Class<T> clazz, String str) throws ViewException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(JsonMethod.FIELD, Visibility.ANY);
        mapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.configure(SerializationConfig.Feature.AUTO_DETECT_FIELDS, true);
        mapper.configure(SerializationConfig.Feature.AUTO_DETECT_GETTERS, false);
        mapper.configure(SerializationConfig.Feature.AUTO_DETECT_IS_GETTERS, false);
        //mapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);
        DateFormat dateFormat = null;
        if (StringUtil.isEmpty(str)) {
            dateFormat = new SimpleDateFormat(DEFAULT_FORMAT);
        } else {
            dateFormat = new SimpleDateFormat(str);
        }
        mapper.writer(dateFormat);
        mapper.setSerializationConfig(mapper.getSerializationConfig().withDateFormat(dateFormat));
        T t = null;
        try {
            if (jsonStr != null) {
                t = mapper.readValue(jsonStr, clazz);
            }
            return t;
        } catch (JsonGenerationException e) {
            ViewException fe = new ViewException();
            fe.initCause(e);
            throw fe;
        } catch (JsonMappingException e) {
            ViewException fe = new ViewException();
            fe.initCause(e);
            throw fe;
        } catch (IOException e) {
            ViewException fe = new ViewException();
            fe.initCause(e);
            throw fe;
        }
    }
    
    public static List<Long> convertToLong(List<String> list) {
        List<Long> longList = new ArrayList<Long>();
        for(String str : list) {
            longList.add(Long.parseLong(str));
        }
        return longList;
    }
}
