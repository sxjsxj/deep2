package com.deep.two.util;

import java.util.List;

public final class ListUtil {

	public static <T> String toSplitString(List<T> tList, String split) {
		String s = "";
		if (tList.isEmpty()) {
			return "";
		} else {
			for (T t : tList) {
				s = s + t.toString() + split;
			}
			return s.substring(0, s.length() - 1);
		}
	}
}
