package com.deep.two.service.authority.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.deep.two.dao.util.CriterionUnit;
import com.deep.two.dao.util.DaoUtil;
import com.deep.two.mail.Mail;
import com.deep.two.mail.SendMailUtil;
import com.deep.two.orm.User;
import com.deep.two.service.authority.EmailService;
import com.deep.two.util.RandomUtil;
import com.deep.two.util.StringUtil;
import com.deep.two.util.ViewException;

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
public class EmailServiceImpl implements EmailService {
	private static Map<String, String> codeMap = new ConcurrentHashMap<String, String>(26);
	private static Map<String, Long> dateMap = new ConcurrentHashMap<String, Long>(26);
	
	@Autowired
	@Qualifier("daoUtil")
    private DaoUtil daoUtil;
	
	@Autowired
	private SendMailUtil sendMailUtil;
	
	@Override
	public boolean sendEmail(String to) throws ViewException {
		if (StringUtil.isEmpty(to)) return false;
		// 校验邮箱是否已注册
		checkEmail(to);
		try {
			Mail mail = new Mail();
			mail.setReceiver(to);
			String code = RandomUtil.getRandomString(6);
			mail.setMessage(getContent(code));
			sendMailUtil.send(mail);
			codeMap.put(to, code);
			dateMap.put(to, new Date().getTime());
		} catch (MessagingException e) {
			ViewException ve = new ViewException("邮件发送失败！");
            throw ve;
		}
		return true;
	}

	private void checkEmail(String to) throws ViewException {
		List<CriterionUnit> cuList = new ArrayList<CriterionUnit>();
        cuList.add(new CriterionUnit("email", to));
        int count = daoUtil.queryCount(cuList, User.class);
        if (count == 0) {
        	ViewException ve = new ViewException("该邮箱还没有注册.");
            throw ve;
        }
	}
	
	private String getContent(String code) throws ViewException {
		Resource resource = new ClassPathResource("properties/email.html"); 
		StringBuffer sb = new StringBuffer("");
		try {
			BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));
			String line = null;
			while((line=br.readLine()) != null) {
				sb.append(line);
			}
			br.close();
		} catch (Exception e) {
			ViewException ve = new ViewException("邮件模板不存在！");
	        throw ve;
		}
		return (sb.toString().replaceFirst("XXXXXX", code));
	}

	@Override
	public boolean validateCode(String to, String code)  throws ViewException{
		boolean result = false;
		try{
			if (StringUtil.isEmpty(to)) return false;
			if (StringUtil.isEmpty(code)) return false;
			if(codeMap.containsKey(to)) {
				String validateCode = codeMap.get(to);
				if (!validateCode.equals(code)) {
					result = false;
					ViewException ve = new ViewException("验证失败！");
			        throw ve;
				}
				long nowD = new Date().getTime();
				long beginD = dateMap.get(to);
				if(nowD-beginD > 5*60*1000) {
					result = false;
					ViewException ve = new ViewException("验证码已过期，请重新验证！");
			        throw ve;
				} 
			}
		} catch(Exception e){
			ViewException ve = new ViewException("验证失败！");
	        throw ve;
		}
		return result;
	}

}
