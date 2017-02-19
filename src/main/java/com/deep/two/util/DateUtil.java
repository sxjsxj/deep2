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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;



/**
 * ClassName: DateUtil <br/>
 * Description: 时间工具类-提供各种工具对时间进行格式转换 <br/>
 * Date: 2014-9-18 上午10:30:32 <br/>
 * <br/>
 * 
 * @author zangling(邮箱)
 * 
 *         修改记录
 * @version 产品版本信息 2014-08-01 臧凌(zangl@) 创建本类<br/>
 * 
 */
public final class DateUtil {

    /* 默认的日期格式 */
    public static final String DEFAULT_FORMAT = "yyyy-MM-dd";

    public static final String YYYYMMDD_FORMAT = "yyyyMMdd";

    /**
     * Creates a new instance of DateUtil.<br/>
     * Description: 私有构造方法 <br/>
     */
    private DateUtil() {

    }

    /**
     * getFormatDateTime:将给定的Date类型的参数转化成String以便其他程序处理 <br/>
     * 
     * @param date
     *            需要转换的原始时间
     * @param format
     *            转换格式
     * @return 返回给定格式的Date转换值 <br/>
     */
    public static String getFormatDateTime(Date date, String format) {
        SimpleDateFormat sdf;
        if (format == null || format.equalsIgnoreCase("")) {
            sdf = new SimpleDateFormat(DEFAULT_FORMAT);
        } else {
            sdf = new SimpleDateFormat(format);
        }
        return sdf.format(date);
    }

    /**
     * getNow:将返回一个只有年/月/日的 <br/>
     * 本方法用在AirTis中需要直接使用当天日期（不含时间）的场合。<br/>
     * 
     * @return Date 返回当前日期（只包含年/月/日）
     * @throws ViewException
     *             自定义异常信息 <br/>
     */
    public static Date getNow() throws ViewException {
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_FORMAT);
        return DateUtil.getStrToDate(sdf.format(new Date()), "");
    }

    /**
     * getLastestDate: 获取最新的日期 <br/>
     * 
     * @return 9999-12-31日期
     * @throws ViewException
     *             自定义异常信息 <br/>
     */
    public static Date getLastestDate() throws ViewException {
        return DateUtil.getStrToDate("9999-12-31", "");
    }

    /**
     * convertDate:将各种各样的Date类型转换成 DEFAULT_FORMAT 的格式 “yyyy-MM-dd” <br/>
     * 使用在AirTis中，如果原始时间不确定是哪个时间格式，但是要求转换成标准的不加时间的格式时<br/>
     * 由于使用了标准的format串，因此不会有异常，所以在这里对异常进行了捕获后并未处理<br/>
     * 
     * @param date
     *            需要转换的原始时间
     * @return 转换后的标准格式时间
     * @throws ViewException
     */
    public static Date convertDate(Date date) throws ViewException {
        Date returnDate = null;
        if (date != null) {
            returnDate = DateUtil.getStrToDate(DateUtil.getFormatDateTime(date, DEFAULT_FORMAT), DEFAULT_FORMAT);
        }
        return returnDate;
    }

    /**
     * convertDate:将各种各样的Date类型转换成指定格式 <br/>
     * 如果不确定原始时间是哪种格式，又需要使用特定的Date格式时候，可以用此方法指定格式进行转换<br/>
     * 
     * @param date
     *            需要转换的原始时间
     * @param format
     *            指定的转换格式
     * @return 返回给定格式的Date转换值
     * @throws ViewException
     *             自定义异常信息 <br/>
     */
    public static Date convertDate(Date date, String format) throws ViewException {
        String dFormat = "";
        if (format == null || "".equals(format)) {
            dFormat = format;
        }
        if (date == null) {
            return null;
        } else {
            return DateUtil.getStrToDate(DateUtil.getFormatDateTime(date, dFormat), dFormat);
        }
    }

    /**
     * getStrToDate:将原始的字符串用指定的格式转换成特定的Date类型 <br/>
     * 如果原始的时间数据是String类，需要将其转换成标准的Date类型时使用<br/>
     * 
     * @param date
     *            需要转换的原始时间
     * @param format
     *            指定的转换格式
     * @return 返回给定格式的Date转换值
     * @throws ViewException
     *             自定义异常信息 <br/>
     */
    public static Date getStrToDate(String date, String format) throws ViewException {
        SimpleDateFormat sdf;
        Date d = null;
        if (date != null) {
            if (format == null || format.equalsIgnoreCase("")) {
                sdf = new SimpleDateFormat(DEFAULT_FORMAT);
            } else {
                sdf = new SimpleDateFormat(format);
            }
            try {
                d = sdf.parse(date);
            } catch (ParseException e) {
                ViewException fe = new ViewException();
                fe.initCause(e);
                throw fe;
            }
        }
        return d;
    }

    /**
     * calDate:将指定的原始时间进行加减天数，然后转换为指定格式 <br/>
     * 适用于需要加减天数，并且原始时间格式为String，并且返回值为String的情况<br/>
     * 
     * @param date
     *            需要计算的原始时间（String类型）
     * @param format
     *            指定的转换格式
     * @param add
     *            增减天数（可指定负数）
     * @return 返回原始时间的计算结果，并进行转换后的值（String格式）
     * @throws ViewException
     *             自定义异常信息 <br/>
     */
    public static String calDate(String date, String format, int add) throws ViewException {
        Calendar cl = new GregorianCalendar();
        cl.setTime(DateUtil.getStrToDate(date, format));
        cl.add(Calendar.DAY_OF_YEAR, add);
        return DateUtil.getFormatDateTime(cl.getTime(), format);
    }

    /**
     * calDateByDay:将指定的原始时间进行加减月，然后转换为指定格式 <br/>
     * 
     * @param date
     *            需要计算的原始时间（Date类型）
     * @param format
     *            指定的转换格式
     * @param add
     *            增减月数（可指定负数）
     * @return Date格式
     * @throws ViewException
     *             自定义异常信息 <br/>
     */
    public static Date calDateByDay(Date date, String format, int add) throws ViewException {
        Calendar cl = new GregorianCalendar();
        cl.setTime(DateUtil.convertDate(date, format));
        cl.add(Calendar.DAY_OF_YEAR, add);
        return DateUtil.convertDate(cl.getTime(), format);
    }
    
    public static Date calDateByDay(Date date, int add) throws ViewException {
        return DateUtil.calDateByDay(date,"",add);
    }

    /**
     * calDateByMonth:将指定的原始时间进行加减月，然后转换为指定格式 <br/>
     * 
     * @param date
     *            需要计算的原始时间（Date类型）
     * @param format
     *            指定的转换格式
     * @param add
     *            增减月数（可指定负数）
     * @return Date格式
     * @throws ViewException
     *             自定义异常信息 <br/>
     */
    public static Date calDateByMonth(Date date, String format, int add) throws ViewException {
        Calendar cl = new GregorianCalendar();
        cl.setTime(DateUtil.convertDate(date, format));
        cl.add(Calendar.MONTH, add);
        return DateUtil.convertDate(cl.getTime(), format);
    }

    /**
     * calDateByMonth:将指定的原始时间进行加减年，然后转换为指定格式 <br/>
     * 
     * @param date
     *            需要计算的原始时间（Date类型）
     * @param format
     *            指定的转换格式
     * @param add
     *            增减年数（可指定负数）
     * @return Date格式
     * @throws ViewException
     *             自定义异常信息 <br/>
     */
    public static Date calDateByYear(Date date, String format, int add) throws ViewException {
        Calendar cl = new GregorianCalendar();
        cl.setTime(DateUtil.convertDate(date, format));
        cl.add(Calendar.YEAR, add);
        return DateUtil.convertDate(cl.getTime(), format);
    }

    /**
     * calDate:将指定的原始时间进行加减天数，然后转换为指定格式 <br/>
     * 适用于需要加减天数，并且原始时间格式为Date，并且返回值为String的情况<br/>
     * 
     * @param date
     *            需要计算的原始时间（Date类型）
     * @param format
     *            指定的转换格式
     * @param add
     *            增减天数（可指定负数）
     * @return 返回原始时间的计算结果，并进行转换后的值（String格式）
     * @throws ViewException
     *             自定义异常信息 <br/>
     */
    public static String calDate(Date date, String format, int add) throws ViewException {
        Calendar cl = new GregorianCalendar();
        cl.setTime(DateUtil.getStrToDate(DateUtil.getFormatDateTime(date, format), format));
        cl.add(Calendar.DAY_OF_YEAR, add);
        return DateUtil.getFormatDateTime(cl.getTime(), format);
    }

    /**
     * getDateCalDate:将指定的原始时间进行加减天数，然后转换为指定格式 <br/>
     * 适用于需要加减天数，并且原始时间格式为Date，并且返回值为Date的情况<br/>
     * 
     * @param date
     *            需要计算的原始时间（Date类型）
     * @param format
     *            指定的转换格式
     * @param add
     *            增减天数（可指定负数）
     * @return 返回原始时间的计算结果，并进行转换后的值（Date格式）
     * @throws ViewException
     *             自定义异常信息 <br/>
     */
    public static Date getDateCalDate(Date date, String format, int add) throws ViewException {
        Calendar cl = new GregorianCalendar();
        cl.setTime(DateUtil.getStrToDate(DateUtil.getFormatDateTime(date, format), format));
        cl.add(Calendar.DAY_OF_YEAR, add);
        return DateUtil.getStrToDate(DateUtil.getFormatDateTime(cl.getTime(), format), format);
    }

    /**
     * dateIsSame:如果两个参数不都为null，则判断他们是否相等（仅仅对年/月/日部分进行相等判断） <br/>
     * 适用于仅仅判断两个Date类型的日期是否相等的情况下（不对日期进行判断）<br/>
     * 
     * @param travelEffdate
     *            时间参数1
     * @param salEffDate
     *            时间参数2
     * @return 两个参数的日期部分是否相等
     * @throws ViewException
     *             当两个参数中有一个为null则报错<br/>
     */
    public static boolean dateIsSame(Date travelEffdate, Date salEffDate) throws ViewException {
        if (travelEffdate != null && salEffDate != null) {
            return DateUtil.getFormatDateTime(travelEffdate, "").equals(DateUtil.getFormatDateTime(salEffDate, ""));
        } else {
            throw new ViewException(" travelDateSaleDateIsSame 方法中中两个时间参数中有一个有空值！！");
        }
    }

    /**
     * 
     * isDateCross:判断两对时间是否有交集<br/>
     * 用于时间交集的判断<br/>
     * 
     * @param oldEffdate
     *            第一对日期中的开始时间
     * @param oldDiscdate
     *            第一对日期中的结束时间
     * @param newEffDate
     *            第二对日期中的开始时间
     * @param newDiscDate
     *            第二对日期中的结束时间
     * @return 两对时间有交集 true，没有交集 false
     * @throws ViewException
     *             如果四个日期中有一个日期为null则报错<br/>
     */
    public static boolean isDateCross(Date oldEffdate, Date oldDiscdate, Date newEffDate, Date newDiscDate)
            throws ViewException {
        if (oldEffdate != null && oldDiscdate != null && newEffDate != null && newDiscDate != null) {
            // 如果新运价的旅行开始时间 > 旧运价的旅行截止时间 没有交集
            if (Integer.valueOf(DateUtil.getFormatDateTime(newEffDate, YYYYMMDD_FORMAT)) > Integer.valueOf(DateUtil
                    .getFormatDateTime(oldDiscdate, YYYYMMDD_FORMAT))) {
                return false;
            }
            // 如果旧运价的开始时间 > 新运价的截止时间 没有交集
            else {
                return !(Integer.valueOf(DateUtil.getFormatDateTime(newDiscDate, YYYYMMDD_FORMAT)) < Integer
                        .valueOf(DateUtil.getFormatDateTime(oldEffdate, YYYYMMDD_FORMAT)));
            }
        } else {
            throw new ViewException(" travelDateIsCross 方法中四个时间中有一个有空值！！");
        }
    }
    
  

    /**
     * getMaxDate:两个日期中取大 <br/>
     * 
     * @param date1
     *            日期1
     * @param date2
     *            日期2
     * @return 日期大的值（时间晚）
     */
    public static Date getMaxDate(Date date1, Date date2) {
        if (date1.after(date2)) {
            return date1;
        } else {
            return date2;
        }
    }

    /**
     * getMaxDate:两个日期中取小 <br/>
     * 
     * @param date1
     *            日期1
     * @param date2
     *            日期2
     * @return 日期小的值（时间早）
     */
    public static Date getMinDate(Date date1, Date date2) {
        if (date1.after(date2)) {
            return date2;
        } else {
            return date1;
        }
    }

    /**
     * 校验日期字符串是否符合指定格式
     * 
     * @param dateStr
     *            日期字符串
     * @param formatStr
     *            格式串
     * @return flag true匹配成功 false匹配失败
     */
    public static boolean matchFormat(String dateStr, String formatStr) {
        SimpleDateFormat sdf = null;
        boolean flag = true;
        if (StringUtil.isEmpty(formatStr)) {
            sdf = new SimpleDateFormat(DEFAULT_FORMAT);
        } else {
            sdf = new SimpleDateFormat(formatStr);
        }
        try {
            sdf.parse(dateStr);
        } catch (ParseException e) {
            flag = false;
        }
        return flag;
    }


    /**
     * 
     * getLastDayOfMonth:获取指定月份的最后一天 <br/>
     * 
     * @param year
     *            年
     * @param month
     *            月
     * @return 返回yyyy-MM-dd格式的日期<br/>
     * @throws ViewException
     *             工具类异常<br/>
     */
    public static Date getLastDayOfMonth(int year, int month) throws ViewException {
        String lastDayOfMonth = DateUtil.getLastDayOfMonthStr(year, month);
        return DateUtil.getStrToDate(lastDayOfMonth, "");
    }

    /**
     * 
     * getLastDayOfMonth:获取指定月份的最后一天 <br/>
     * 
     * @param year
     *            年
     * @param month
     *            月
     * @return 返回yyyy-MM-dd格式的日期<br/>
     * @throws ViewException
     *             工具类异常<br/>
     */
    public static Date getLastDayOfMonth(String year, String month) throws ViewException {
        
        int yearIntValue = Integer.parseInt(year);
        int monthIntValue = Integer.parseInt(month);
        String lastDayOfMonth = DateUtil.getLastDayOfMonthStr(yearIntValue, monthIntValue);
        return DateUtil.getStrToDate(lastDayOfMonth, "");
    }

    /**
     * 
     * getLastDayOfMonthStr:获取指定月份的最后一天 <br/>
     * 
     * @param year
     *            年
     * @param month
     *            月
     * @return 返回yyyy-MM-dd格式的日期的字符串<br/>
     */
    private static String getLastDayOfMonthStr(int year, int month) {
        Calendar cal = Calendar.getInstance();
        // 设置年份
        cal.set(Calendar.YEAR, year);
        // 设置月份
        cal.set(Calendar.MONTH, month - 1);
        // 获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        // 设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        // 格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String lastDayOfMonth = sdf.format(cal.getTime());

        return lastDayOfMonth;
    }
}
