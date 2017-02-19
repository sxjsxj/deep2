package com.deep.two.util;

import java.lang.reflect.Method;

public final class MethodUtil {
	
	public static <T> boolean hasMethod(T t, String methodName, Class<?> parameterTypes) throws ViewException {
		boolean result = false;
		try {
			Method m = t.getClass().getMethod(methodName, parameterTypes);
			if (m != null) result = true;
		} catch (Exception e) {
			ViewException tmp = new ViewException();
			tmp.initCause(e);
			throw tmp;
		} 
		return result;
	}

}
