/**
 * Copyright (c) 2014,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:FareUtil
 * Package Name:com.travelsky.fare.fareutil.commontools
 * File Name:DateUtil.java
 * Date:2014-7-21 下午3:53:34
 * 
 */
package com.deep.two.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.Date;


/**
 * ClassName: CopyUtil <br/>
 * Description: 对象拷贝工具类 <br/>
 * Date: 2014-11-24 下午5:01:36 <br/>
 * <br/>
 * 
 * @author Administrator(邮箱)
 * 
 *         修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
 * 
 */
public final class CopyUtil {

	/**
	 * Creates a new instance of CopyUtil.<br/>
	 * Description: 私有构造方法<br/>
	 */
	private CopyUtil() {

	}

	/**
	 * copyModel:将前台model的属性设置给后台model （不同类型对象，但结构相同） <br/>
	 * 
	 * @param t
	 *            前台传入的model
	 * @param clazz
	 *            指定的反射model类
	 * @param <T>
	 *            前台传入的model的类型
	 * @param <E>
	 *            指定的反射model类的类型
	 * @return E copy后产生的新对象
	 * @throws ViewException
	 *             异常信息
	 * 
	 */
	public static <T, E> E copyModel(T t, Class<E> clazz)
			throws ViewException {
		E e = null;
		String get = "get";
		String set = "set";
		try {
			e = clazz.newInstance();
			Field[] fields = clazz.getDeclaredFields();
			Field[] tFields = t.getClass().getDeclaredFields();
			Field[] eFields = clazz.getDeclaredFields();
			String tFieldName = "";
			Class<?> tClazz = null;
			Class<?> eClazz = null;
			/* 获取t中的PK class 以及PK的名称 */
			for (int i = 0; i < tFields.length; i++) {
				Field tField = tFields[i];
				if (tField.getName().endsWith("PK")) {
					tFieldName = tField.getName();
					tClazz = tField.getType();
					break;
				}
			}
			// 获取clazz对象中的 PK 的class
			for (int i = 0; i < eFields.length; i++) {
				Field eField = eFields[i];
				if (eField.getName().endsWith("PK")) {
					eClazz = eField.getType();
					break;
				}
			}
			StringBuffer getTMethodName = new StringBuffer(get);
			if (tFieldName != null && tFieldName.length() > 0) {
				if (tFieldName.length() > 1) {
					getTMethodName.append(
							tFieldName.substring(0, 1).toUpperCase()).append(
							tFieldName.substring(1));
				} else {
					getTMethodName.append(tFieldName.substring(0, 1)
							.toUpperCase());
				}
			}
			Method getTPKMethod = t.getClass().getMethod(
					getTMethodName.toString(), new Class[] {});
			Object tPkValue = null;
			if (getTPKMethod.invoke(t, new Object[] {}) == null) {
				tPkValue = tClazz.newInstance();
			} else {
				tPkValue = getTPKMethod.invoke(t, new Object[] {});
			}

			Object ePkValue = new Object();
			if (eClazz != null) {
				ePkValue = eClazz.newInstance();
			}
			Field[] tPkFields = tPkValue.getClass().getDeclaredFields();
			for (int i = 0; i < tPkFields.length; i++) {
				Field tPkField = tPkFields[i];
				String tPkFieldName = tPkField.getName();
				String tPkFirstLetter = tPkFieldName.substring(0, 1)
						.toUpperCase();
				String getTPKMethodName = get + tPkFirstLetter
						+ tPkFieldName.substring(1);
				String setTPKMethodName = set + tPkFirstLetter
						+ tPkFieldName.substring(1);
				Method getPKMethod = tPkValue.getClass().getMethod(
						getTPKMethodName, new Class[] {});
				Method setPKMethod = ePkValue.getClass().getMethod(
						setTPKMethodName, new Class[] { tPkField.getType() });
				Object pkValue = getPKMethod.invoke(tPkValue, new Object[] {});
				setPKMethod.invoke(ePkValue, new Object[] { pkValue });
			}
			for (int i = 0; i < fields.length; i++) {
				Field field = fields[i];
				String fieldName = field.getName();
				String firstLetter = null;
				String getMethodName = null;
				String setMethodName = null;
				if (fieldName.endsWith("PK")) {
					firstLetter = tFieldName.substring(0, 1).toUpperCase();
					String firstLetter2 = fieldName.substring(0, 1)
							.toUpperCase();
					/* 获得和属性对应的getXXX()方法的名字 */
					getMethodName = get + firstLetter + tFieldName.substring(1);
					/* 获得和属性对应的setXXX()方法的名字 */
					setMethodName = set + firstLetter2 + fieldName.substring(1);
				} else {
					firstLetter = fieldName.substring(0, 1).toUpperCase();
					/* 获得和属性对应的getXXX()方法的名字 */
					getMethodName = get + firstLetter + fieldName.substring(1);
					/* 获得和属性对应的setXXX()方法的名字 */
					setMethodName = set + firstLetter + fieldName.substring(1);
				}
				/* 获得和属性对应的getXXX()方法 */
				Method getMethod = t.getClass().getMethod(getMethodName,
						new Class[] {});
				/* 获得和属性对应的setXXX()方法 */
				Method setMethod = clazz.getMethod(setMethodName,
						new Class[] { field.getType() });

				/* 如果调用setPK方法则将查询到的pk对象直接赋值 */
				if (setMethodName.endsWith("PK")) {
					setMethod.invoke(e, new Object[] { ePkValue });
				} else {
					/* 调用原对象的getXXX()方法 */
					Object value = getMethod.invoke(t, new Object[] {});
					setMethod.invoke(e, new Object[] { value });
				}
			}

		} catch (NoSuchMethodException ne) {
			ViewException fe = new ViewException();
			fe.initCause(ne);
			throw fe;
		} catch (IllegalAccessException ie) {
			ViewException fe = new ViewException();
			fe.initCause(ie);
			throw fe;
		} catch (InvocationTargetException ie) {
			ViewException fe = new ViewException();
			fe.initCause(ie);
			throw fe;
		} catch (InstantiationException ie) {
			ViewException fe = new ViewException();
			fe.initCause(ie);
			throw fe;
		}
		return e;
	}

	public static <T, E> E copyProperty(T t,Class<E> clazz) throws ViewException  {
		return copyPropertyDetail(t,null,clazz);
	}
	
	public static <T, E> E copyProperty(T t,E e,Class<E> clazz) throws ViewException  {
		return copyPropertyDetail(t,e,clazz);
	}
	
	/**
	 * 
	 * copyProperty:copy属性 <br/>
	 * 
	 * @param t 被拷贝对象
	 * @param clazz 拷出对象类型
	 * @return E 拷出对象
	 * @throws ViewException
	 *           if has error
	 */
	private static <T, E> E copyPropertyDetail(T t,E e,Class<E> clazz) throws ViewException  {
	
		
		Field[] tFields = t.getClass().getDeclaredFields();
		try {
			if (e==null){
				e = clazz.newInstance();
			}
			for (int i = 0; i < tFields.length; i++) {
				Field tField = tFields[i];
				String name = tField.getName();
				/* 获取set方法的名字 */
				String firstLetter = name.substring(0, 1).toUpperCase();
				String setMethodName = "set" + firstLetter + name.substring(1);
				Method setTMethod= t.getClass().getMethod(setMethodName,
						new Class[] { tField.getType() });
				/* 获取get方法的名字 */
				String getMethodName = null;
				if (tField.getType().getName().endsWith("boolean")) {
					getMethodName = "is" + firstLetter + name.substring(1);
				} else {
					getMethodName = "get" + firstLetter + name.substring(1);
				}
				Method getTMethod = t.getClass().getMethod(getMethodName,
						new Class[] {});
				if (checkField(e.getClass(), tField)
						&& checkMethod(e.getClass(), setTMethod)
						&& checkMethod(e.getClass(), getTMethod)) {
					Object value =  getTMethod.invoke(t, new Object[] {});
					if(value != null) {
						Method setEMethod= clazz.getMethod(setMethodName,
								new Class[] { tField.getType() });
						setEMethod.invoke(e, new Object[] {value});
					}
				}
			}
		} catch (SecurityException ie) {
			ViewException fe = new ViewException();
			fe.initCause(ie);
			throw fe;
		} catch (NoSuchMethodException ie) {
			ViewException fe = new ViewException();
			fe.initCause(ie);
			throw fe;
		} catch (IllegalAccessException ie) {
			ViewException fe = new ViewException();
			fe.initCause(ie);
			throw fe;
		} catch (InvocationTargetException ie) {
			ViewException fe = new ViewException();
			fe.initCause(ie);
			throw fe;
		} catch (InstantiationException ie) {
			ViewException fe = new ViewException();
			fe.initCause(ie);
			throw fe;
		}
		return e;
	}

	private static boolean checkField(Class<?> clazz, Field field) {
		String fieldName = field.getName();
		Field[] fields1 = clazz.getDeclaredFields();
		Class<?> cc = clazz.getSuperclass();
		Field[] fields2 = cc.getDeclaredFields();
		Field[] fields = new Field[fields1.length+fields2.length];
		
		System.arraycopy(fields1, 0, fields, 0, fields1.length);
		System.arraycopy(fields2, 0, fields, fields1.length, fields2.length);
		for (int i = 0; i < fields.length; i++) {
			Field tField = fields[i];
			String tFieldName = tField.getName();
			if (tFieldName.equals(fieldName)
					&& tField.getType().equals(field.getType())) {
				return true;
			}
		}
		return false;
	}

	
	private static boolean checkMethod(Class<?> clazz, Method method) {

		Method[] methods1 = clazz.getDeclaredMethods();
		Class<?> cc = clazz.getSuperclass();
		Method[] methods2 = cc.getDeclaredMethods();
		Method[] methods = new Method[methods1.length+methods2.length];
		
		System.arraycopy(methods1, 0, methods, 0, methods1.length);
		System.arraycopy(methods2, 0, methods, methods1.length, methods2.length);
		for (int i = 0; i < methods.length; i++) {
			Method tMethod = methods[i];
			if (tMethod.getName().equals(method.getName())
					&& tMethod.getReturnType().equals(method.getReturnType())) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * copy: 对象深拷贝 （同一类型对象赋值拷贝） <br/>
	 * 
	 * @param t
	 *            拷贝的原始对象
	 * @param <T>
	 *            原始对象的拷贝对象
	 * @return 原始对象的拷贝对象
	 * @throws ViewException
	 *             自定义异常信息 <br/>
	 */
	public static <T> Object copy(T t) throws ViewException {
		Object objectCopy = null;
		try {
			Class<?> classType = t.getClass();
			objectCopy = classType.getConstructor(new Class[] {}).newInstance(
					new Object[] {});
			/* 获得对象的所有成员变量 */
			Field[] fields = classType.getDeclaredFields();
			for (Field field : fields) {
				Object value = getPropertyValue(t, field);
				Class<?> type = field.getType();
				if (value == null) {
					continue;
				}
				if (type.isPrimitive() || type.getName().endsWith("String")
						|| type.getName().endsWith("Long")
						|| type.getName().endsWith("Boolean")
						|| type.getName().endsWith("Short")
						|| type.getName().endsWith("Integer")
						|| type.getName().endsWith("Character")
						|| type.getName().endsWith("Float")
						|| type.getName().endsWith("Double")
						|| type.getName().endsWith("Byte")) {
					setProperty(objectCopy, field, value);
				} else if (value instanceof Timestamp
						|| type == Timestamp.class) {
					Date d = new Date(((Timestamp) value).getTime());
					setProperty(objectCopy, field, d);
				} else if (value instanceof Date || type == Date.class) {
					Date d = (Date) (((Date) value).clone());
					setProperty(objectCopy, field, d);
				} else {
					Object temp = copy(value);
					setProperty(objectCopy, field, temp);
				}
			}
		} catch (NoSuchMethodException e) {
			ViewException fe = new ViewException();
			fe.initCause(e);
			throw fe;
		} catch (IllegalAccessException e) {
			ViewException fe = new ViewException();
			fe.initCause(e);
			throw fe;
		} catch (InvocationTargetException e) {
			ViewException fe = new ViewException();
			fe.initCause(e);
			throw fe;
		} catch (InstantiationException e) {
			ViewException fe = new ViewException();
			fe.initCause(e);
			throw fe;
		}
		return objectCopy;
	}

	/**
	 * 
	 * setProperty:更改某对象的一个属性值 <br/>
	 * 
	 * @param 要被更改属性的对象
	 * @param field
	 *            要被更改值的属性
	 * @param value
	 *            要赋的属性值
	 * @throws NoSuchMethodException
	 *             异常
	 * @throws IllegalAccessException
	 *             异常
	 * @throws InvocationTargetException
	 *             异常
	 */
	private static void setProperty(Object objectCopy, Field field, Object value)
			throws NoSuchMethodException, IllegalAccessException,
			InvocationTargetException {
		/* 获取成员变量的名字，此处为id，name,age */
		String name = field.getName();
		/* 获取set方法的名字 */
		String firstLetter = name.substring(0, 1).toUpperCase();
		String setMethodName = "set" + firstLetter + name.substring(1);

		/* 获取set方法对象 */
		Method setMethod = objectCopy.getClass().getMethod(setMethodName,
				new Class[] { field.getType() });
		/*
		 * 注意set方法需要传入参数类型 调用set方法将这个值复制到新的对象中去
		 */
		setMethod.invoke(objectCopy, new Object[] { value });
	}

	/**
	 * getPropertyValue:获取对象指定属性值<br/>
	 * 
	 * @param object
	 *            指定对象
	 * @param field
	 *            要获取的属性
	 * @return Object 返回对象
	 * @throws NoSuchMethodException
	 *             异常
	 * @throws IllegalAccessException
	 *             异常
	 * @throws InvocationTargetException
	 *             异常
	 */
	private static Object getPropertyValue(Object object, Field field)
			throws NoSuchMethodException, IllegalAccessException,
			InvocationTargetException {
		String name = field.getName();
		/* 获取get和set方法的名字 */
		String firstLetter = name.substring(0, 1).toUpperCase();
		String getMethodName = null;
		if (field.getType().getName().endsWith("boolean")) {
			getMethodName = "is" + firstLetter + name.substring(1);
		} else {
			getMethodName = "get" + firstLetter + name.substring(1);
		}
		Method getMethod = object.getClass().getMethod(getMethodName,
				new Class[] {});
		return getMethod.invoke(object, new Object[] {});
	}
}
