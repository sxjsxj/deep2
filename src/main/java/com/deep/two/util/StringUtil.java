package com.deep.two.util;

import java.io.UnsupportedEncodingException;



/**
 * ClassName: StringUtil <br/>
 * Description: String处理工具类 <br/>
 * Date: 2014-12-17 下午2:43:29 <br/>
 * <br/>
 * 
 * @author sunxijin(邮箱)
 * 
 *         修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
 * 
 */
public final class StringUtil {

    /**
     * Creates a new instance of StringUtil.<br/>
     * Description: 私有构造方法 <br/>
     */
    private StringUtil() {

    }

    /**
     * isEmpty: 判断字符串是否为空
     * 
     * @param str
     *            输入字符串
     * @return true/false <br/>
     */
    public static boolean isEmpty(String str) {
        
        return (str == null || "".equals(str.trim()));
        
    }

    /**
     * inArray:一个字符串数组中是否包含某个字符串 <br/>
     * 
     * @param str
     *            一个字符串
     * @param strs
     *            字符串数组
     * @return str是否在strs中
     */
    public static boolean inArray(String str, String[] strs) {
        boolean flag = false;
        for (String s : strs) {
            if (str.equals(s)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    /**
     * trim: 去空格 <br/>
     * 
     * @param str
     *            需要处理的字符串
     * @return 去空格之后的字符串或null<br/>
     */
    public static String trim(String str) {
        if (str == null || "".equals(str.trim())) {
            return "";
        } else {
            return str.trim();
        }
    }
    
    public static String trim(Object obj) {
        if (obj == null || "".equals(obj.toString().trim())) {
            return "";
        } else {
            return obj.toString().trim();
        }
    }
    
    

    /**
     * getByteSize: 获取字符串的字节数<br/>
     * 
     * @param str
     *            字符串
     * @return str对应的utf8字节数
     * @throws ViewException
     *             自定义异常 <br/>
     */
    public static int getByteSize(String str) throws ViewException {
        int size = 0;
        try {
            size = str.getBytes("UTF-8").length;
        } catch (UnsupportedEncodingException e) {
            ViewException fe = new ViewException();
            fe.initCause(e);
            throw fe;
        }
        return size;
    }
    
    /**
     * replaceWhiteSpace: 除去字符串中的空格 <br/>
     * 
     * @param str 字符串
     * @return
     *            去空格后的字符串<br/>
     */
    public static String replaceWhiteSpace(String str) {
        return str.replaceAll("\\s*", "");
    }  
    
    public static String stringToHex(String s) {  
        String str = "";  
        for (int i = 0; i < s.length(); i++) {  
            int ch = (int) s.charAt(i);  
            String s4 = Integer.toHexString(ch);  
            str = str + s4;  
        }  
        return str;//0x表示十六进制  
    }  
  
    //转换十六进制编码为字符串  
    public static String hexToString(String s) {  
        if ("0x".equals(s.substring(0, 2))) {  
            s = s.substring(2);  
        }  
        byte[] baKeyword = new byte[s.length() / 2];  
        for (int i = 0; i < baKeyword.length; i++) {  
            try {  
                baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(  
                        i * 2, i * 2 + 2), 16));  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
  
        try {  
            s = new String(baKeyword, "utf-8");//UTF-16le:Not  
        } catch (Exception e1) {  
            e1.printStackTrace();  
        }  
        return s;  
    }  
}
