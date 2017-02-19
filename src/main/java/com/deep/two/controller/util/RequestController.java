//package com.deep.two.controller.util;
//
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//import org.hibernate.id.IdentifierGenerator;
//import org.hibernate.id.UUIDHexGenerator;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
//import com.travelsky.fare.fareutil.commontools.StringUtil;
//import com.travelsky.fare.fareutil.exception.FareUtilException;
//
//@Controller("requestController")
//@RequestMapping("/request")
//public class RequestController {
//	private static Map<String, String> map = new ConcurrentHashMap<String, String>();
//	private static IdentifierGenerator gen = new UUIDHexGenerator();
//	
//	@RequestMapping("/requestList")
//	public ModelAndView requestList() throws FareUtilException {
//		ModelAndView modelAndView = new ModelAndView("farestarweb.requestList");
//		return modelAndView;
//	}
//	
//	@RequestMapping("/generateJsonRequest")
//	@ResponseBody
//	public String generateJsonRequest(@RequestParam(required=false, value="str") String str) throws FareUtilException {
//	    String key = (String) gen.generate(null, null);
//	    map.put(key, str);
//		return key;
//	}
//	
//	@RequestMapping("/jsonRequest")
//	@ResponseBody
//	public ModelAndView jsonRequest(@RequestParam(required=false, value="key") String key) throws FareUtilException {
//		ModelAndView modelAndView = new ModelAndView("farestarweb.jsonRequest");
//		//str = str.replaceAll("\"", "'");
//		if (StringUtil.isEmpty(key)) {
//			modelAndView.addObject("jsonStr", "");
//		} else {
//			String str = getMap().get(key);
//			modelAndView.addObject("jsonStr", str);
//		}
//		return modelAndView;
//	}
//	
//	@RequestMapping("/xmlRequest")
//	@ResponseBody
//	public ModelAndView xmlRequest(@RequestParam(required=false, value="str") String str) throws FareUtilException {
//		ModelAndView modelAndView = new ModelAndView("farestarweb.xmlRequest");
//		return modelAndView;
//	}
//
//	public Map<String, String> getMap() {
//		return map;
//	}
//}
