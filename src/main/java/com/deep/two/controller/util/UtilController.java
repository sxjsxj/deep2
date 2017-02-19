//package com.deep.two.controller.util;
//
//import java.awt.image.BufferedImage;
//import java.io.IOException;
//import java.util.Date;
//import javax.imageio.ImageIO;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
//import com.travelsky.fare.fareutil.commontools.ImageUtil;
//import com.travelsky.fare.fareutil.commontools.JSONUtil;
//import com.travelsky.fare.fareutil.exception.FareUtilException;
//import com.travelsky.fare.fareutil.model.DMLReturnVo;
//
///**
// * 
// * ClassName: UtilController <br/>
// * Description: 工具Controller <br/>
// * Date: 2014-12-19 下午2:52:59 <br/>
// * <br/>
// * 
// * @author lijunc(邮箱)
// * 
// *         修改记录
// * @version 产品版本信息 yyyy-mm-dd 姓名(邮箱) 修改信息<br/>
// * 
// */
//@Scope("singleton")
//@Controller
//@RequestMapping("util")
//public class UtilController {
//    /**
//     * processInfo:Description <br/>
//     * 
//     * @param dmlReturnVo
//     *            参数DMLReturnVo
//     * @return String 返回空字符串
//     * @throws FareUtilException
//     *             异常
//     */
//    @RequestMapping("processInfo")
//    @ResponseBody
//    public synchronized String processInfo(@RequestParam("str") String str, HttpServletRequest request)
//    // @ModelAttribute("com.travelsky.fare.airtisweb.web.controller.util.DMLReturnVo")
//    // DMLReturnVo dmlReturnVo)
//            throws FareUtilException {
//        String dmlReturnVoSeqStr = "dmlReturVo" + this.createUniqueSeq();
//        request.getSession().setAttribute(dmlReturnVoSeqStr,
//                JSONUtil.jsonToModel(str, DMLReturnVo.class, null));
//        return dmlReturnVoSeqStr;
//    }
//
//    /**
//     * createUniqueSeq: 创建唯一的序号<br/>
//     * 
//     * @return 唯一的序号<br/>
//     */
//    private synchronized String createUniqueSeq() {
//        return String.valueOf(new Date().getTime());
//    }
//
//    /**
//     * getMoreInfo:更多信息 <br/>
//     * 
//     * @return ModelAndView 返回页面
//     */
//    @RequestMapping("getMoreInfo")
//    @ResponseBody
//    public ModelAndView getMoreInfo(@RequestParam("dmlReturnVoSeqStr") String dmlReturnVoSeqStr,
//            HttpServletRequest request) {
//        ModelAndView modelAndView = new ModelAndView("trafficweb.moreInfo");
//        modelAndView.addObject("dmlReturnVo", request.getSession().getAttribute(dmlReturnVoSeqStr));
//        return modelAndView;
//    }
//
//    /**
//     * processDetailInfo:TODO Description <br/>
//     * 
//     * @param str
//     *            字符串
//     * @return String 返回详细信息的索引值
//     */
//    @RequestMapping("processDetailInfo")
//    @ResponseBody
//    public String processDetailInfo(@RequestParam("str") String str, HttpServletRequest request) {
//        String detailSeqStr = "detailSeq" + this.createUniqueSeq();
//        request.getSession().setAttribute(detailSeqStr, str);
//        return detailSeqStr;
//    }
//
//    /**
//     * getDetailInfo: 详细信息页面 <br/>
//     * 
//     * @param str
//     *            字符串
//     * @return ModelAndView 返回页面
//     */
//    @RequestMapping("getDetailInfo")
//    @ResponseBody
//    public ModelAndView getDetailInfo(@RequestParam("detailSeqStr") String detailSeqStr,
//            HttpServletRequest request) {
//        ModelAndView modelAndView = new ModelAndView("trafficweb.detailInfo");
//        modelAndView.addObject("detail", request.getSession().getAttribute(detailSeqStr));
//        return modelAndView;
//    }
//
//
//    /**
//     * getRandomString: 获取随机字符串 <br/>
//     * 
//     * @return ModelAndView 返回页面
//     */
//    @RequestMapping("getRandomString")
//    @ResponseBody
//    public String getRandomString() {
//        ImageUtil iu = new ImageUtil();
//        return iu.getRandomString(4);
//    }
//
//    /**
//     * getImage: 获取验证码图片 <br/>
//     * 
//     * @return ModelAndView 返回页面
//     */
//    @RequestMapping("getImage")
//    @ResponseBody
//    public ModelAndView getImage(@RequestParam("checkCode") String checkCode, HttpServletRequest request,
//            HttpServletResponse response) {
//        ImageUtil iu = new ImageUtil();
//        BufferedImage image = iu.createImage(75, 25, checkCode);
//
//        // 禁止缓存
//        response.setHeader("Pragma", "No-cache");
//        response.setHeader("Cache-Control", "No-cache");
//        response.setDateHeader("Expires", 0);
//        // 指定生成的响应是图片
//        response.setContentType("image/jpeg");
//        //ModelAndView modelAndView = new ModelAndView("trafficweb.loginpage");
//        request.getSession().setAttribute("checkCode", checkCode);
//        try {
//            ImageIO.write(image, "JPEG", response.getOutputStream());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }// 将内存中的图片通过流动形式输出到客户端
//        return null;
//    }
//}
