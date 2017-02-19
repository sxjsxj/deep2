/**
 * Copyright (c) 2014,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:FareUtitl
 * Package Name:com.travelsky.fare.fareutil.dao
 * File Name:CriteriaUntl.java
 * Date:2014-7-10 下午1:51:38
 * 
 */
package com.deep.two.dao.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import com.deep.two.util.ViewException;


public final class CriteriaUtil {

    /**
     * 
     * Description:工具类构造方法私有化，防止new对象 <br/>
     */
    private CriteriaUtil() {
    }

    public static Criteria createOrder(Criteria criteria, List<OrderUnit> orderList) {
        if (orderList == null || orderList.isEmpty()) {
            return criteria;
        }
        for (OrderUnit orderUnit : orderList) {
            if (orderUnit.getOrderType() == OrderUnit.ASC) {
                criteria.addOrder(Order.asc(orderUnit.getKey()));
            }
            if (orderUnit.getOrderType() == OrderUnit.DESC) {
                criteria.addOrder(Order.desc(orderUnit.getKey()));
            }
        }
        return criteria;
    }

    public static Criteria createPaging(Criteria criteria, Pagination pagination) {
        if (pagination == null || pagination.getCurrentPage() == null 
                || pagination.getCurrentPage() <= 0
                || pagination.getMaxRecordPerPage() == null
                || pagination.getMaxRecordPerPage() <= 0) {
            return criteria;
        }
        return criteria.setFirstResult((pagination.getCurrentPage() - 1) * pagination.getMaxRecordPerPage())
                .setMaxResults(pagination.getMaxRecordPerPage());
    }
    
    public static <T> List<CriterionUnit> vo2CriteriaUnitList(T t) throws ViewException {
        List<CriterionUnit> cuList = new ArrayList<CriterionUnit>();
        if (t == null) {
        	return cuList;
        }
        Class<?> clazz = t.getClass();
        Class<?> spClazz  = clazz.getSuperclass();
        cuList.addAll(getByClass(clazz, t));
        cuList.addAll(getByClass(spClazz, t));
        return cuList;
    }

   private static <T> List<CriterionUnit>  getByClass(Class<?> clazz, T t) throws ViewException {
       List<CriterionUnit> cuList = new ArrayList<CriterionUnit>();
	   Field[] fields = clazz.getDeclaredFields();
       for (Field field : fields) {
           field.setAccessible(true);
           String fieldName = field.getName();
           if (fieldName.endsWith("Operator")) {
               continue;
           }
           String tmp = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
           String getMethodName = "get" + tmp;
           String getOperatorName = "get" + tmp + "Operator";
           try {
               
               if (fieldName.endsWith("IdQueryModel") || fieldName.endsWith("PkQueryModel")) {
               	Object obj1 = clazz.getMethod(getMethodName).invoke(t);
               	if (obj1 != null) {
               		cuList.addAll(vo2CriteriaUnitList(obj1, true));
               	}
               } else {
               	Object obj1 = clazz.getMethod(getMethodName).invoke(t);
               	Object obj2 = clazz.getMethod(getOperatorName).invoke(t);
               	if (obj2 == null) {
               		obj2 = Operator.EQ;
               	}
           		if (obj1 != null && !obj1.toString().equals("")) { 
               		cuList.add(new CriterionUnit(fieldName, obj2.toString(), obj1.toString()));
               	}
               }
           } catch (Exception e) {
               ViewException fe = new ViewException();
               fe.initCause(e);
               throw fe;
           }
       }
       return cuList;
   }
    
    public static <T> List<CriterionUnit> vo2CriteriaUnitList(T t, boolean isPk) throws ViewException {
    	 List<CriterionUnit> cuList = new ArrayList<CriterionUnit>();
         if (t == null) {
         	return cuList;
         }
         Class<?> clazz = t.getClass();
         Field[] fields = clazz.getDeclaredFields();
         for (Field field : fields) {
             field.setAccessible(true);
             String fieldName = field.getName();
             if (fieldName.endsWith("Operator")) {
                 continue;
             }
             String tmp = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
             String getMethodName = "get" + tmp;
             String getOperatorName = "get" + tmp + "Operator";

             try {
                 	Object obj1 = clazz.getMethod(getMethodName).invoke(t);
                 	Object obj2 = clazz.getMethod(getOperatorName).invoke(t);
                 	if (obj2 == null) {
                 		obj2 = Operator.EQ;
                 	}
                 	if(isPk) {
	                	if (obj1 != null && !obj1.toString().equals("")) { 
	                		cuList.add(new CriterionUnit("id."+fieldName, obj2.toString(), obj1.toString()));
	                	}
                	} else {
                		if (obj1 != null && !obj1.toString().equals("")) { 
	                		cuList.add(new CriterionUnit(fieldName, obj2.toString(), obj1.toString()));
	                	}
                	}
             } catch (Exception e) {
                 ViewException fe = new ViewException();
                 fe.initCause(e);
                 throw fe;
             }
         }
         return cuList;
    }
}
