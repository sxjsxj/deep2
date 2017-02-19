package com.deep.two.util;

import java.util.Random;

public class RandomUtil {
	
	public static String getRandomString(int length) {
		String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";// 含有字符和数字的字符串
		Random random = new Random();// 随机类初始化
		StringBuffer sb = new StringBuffer();// StringBuffer类生成，为了拼接字符串

		for (int i = 0; i < length; ++i) {
			int number = random.nextInt(62);// [0,62)
			sb.append(str.charAt(number));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(getRandomString(6));// 调用随机生成字符串的方法，并打印出来
	}
}
