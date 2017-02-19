/**
 * Copyright (c) 2015,TravelSky. 
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * 
 * Project Name:FareUtil
 * Package Name:com.travelsky.fare.fareutil.commontools
 * File Name:ImageUtil.java
 * Date:2015-3-3 下午2:32:58
 * 
 */
package com.deep.two.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * ClassName: ImageUtil <br/>
 * Description: TODO <br/>
 * Date: 2015-3-3 下午2:32:58 <br/>
 * <br/>
 * 
 * @author sunxijin(邮箱)
 * 
 *         修改记录
 * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
 * 
 */

public class ImageUtil {
    private Random random = new Random();
    private int lineSize = 20;// 干扰线数量
    private String randString = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";// 随机产生的字符串

    /**
     * Creates a new instance of ImageUtil.<br/>
     * Description: 构造器<br/>
     */
    public ImageUtil() {

    }
    
    /**
     * getRandomString: 随机生成字符串<br/>
     * 
     * @param size
     *            字符串长度
     * @param g
     * @return 随机生成字符串<br/>
     */
    public String getRandomString(int size) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < size; i++) {
            String temp = String.valueOf(randString.charAt(random.nextInt(randString.length())));
            sb.append(temp).append("_");
        }
     return sb.toString().substring(0, size*2-1);
        
    }
    

    /**
     * createImage: 生成Image<br/>
     * 
     * @param width 宽度
     * @param height 高度
     * @param checkCode 字符串
     * @return
     *            <br/>
     */
    public BufferedImage createImage(int width, int height, String checkCode) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
        Graphics2D g = image.createGraphics();
        // 定义字体样式
        Font myFont = new Font("Times New Roman",Font.ROMAN_BASELINE, 18);
        // 设置字体
        g.setFont(myFont);
        g.setColor(getRandomColor(200, 250));
        // 绘制背景
        g.fillRect(0, 0, width, height);
        g.setColor(getRandomColor(200, 250));
        drawRandomLines(g);
        drawRandomString(checkCode, g);
        g.dispose();
        return image;
    }
    /**
     * 生成随机颜色
     * 
     * @param fc
     *            前景色
     * @param bc
     *            背景色
     * @return Color对象，此Color对象是RGB形式的。
     */
    private Color getRandomColor(int fc, int bc) {
        if(fc > 255)
            fc = 255;
        if(bc > 255)
            bc = 255;
        int r = fc + random.nextInt(bc-fc);
        int g = fc + random.nextInt(bc-fc);
        int b = fc + random.nextInt(bc-fc);
        return new Color(r,g,b);
    }

    /**
     * 绘制干扰线
     * 
     * @param g
     *            Graphics2D对象，用来绘制图像
     * @param nums
     *            干扰线的条数
     */
    private void drawRandomLines(Graphics2D g) {
        for (int i = 0; i < lineSize; i++) {
            g.setColor(getRandomColor(160, 200));
            int x1 = random.nextInt(30);
            int y1 = random.nextInt(30);
            int x2 = random.nextInt(80);
            int y2 = random.nextInt(30);
            g.drawLine(x1, y1, x1+x2, y1+y2);
        }
    }

    /**
     * drawRandomString: 绘制随机字符串 <br/>
     * 
     * @param str
     * @param g
     *            <br/>
     */
    private void drawRandomString(String str, Graphics2D g) {
        String[] ss = str.split("_");
        for(int i = 0; i < ss.length; i++) {
            Color color = new Color(random.nextInt(20), random.nextInt(20), random.nextInt(20));
            g.setColor(color);
            // 想文字旋转一定的角度
            AffineTransform trans = new AffineTransform();
            trans.rotate(random.nextInt(15) * 3.14 / 180, 15 * i + 8, 7);
            // 缩放文字
            float scaleSize = random.nextFloat() + 0.8f;
            if (scaleSize > 1f)
                scaleSize = 1f;
            trans.scale(scaleSize, scaleSize);
            g.setTransform(trans);
            g.drawString(ss[i], 15 * i + 10, 18);
        }
    }
}
