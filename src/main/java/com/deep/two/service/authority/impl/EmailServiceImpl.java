package com.deep.two.service.authority.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
	private static Map<String, String> map = new ConcurrentHashMap<String, String>(26);
	@Autowired
	@Qualifier("daoUtil")
    private DaoUtil daoUtil;
	
	@Override
	public boolean sendEmail(String to) throws ViewException {
		if (StringUtil.isEmpty(to)) return false;
		// 校验邮箱是否已注册
		checkEmail(to);
		try {
			Mail mail = new Mail();
			mail.setReceiver(to);
			mail.setSubject("忘记密码:");
			String code = RandomUtil.getRandomString(6);
			mail.setMessage(code);
			SendMailUtil.send(mail);
			map.put(to, code);
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

	@Override
	public boolean validateCode(String to, String code)  throws ViewException{
		try{
			if (StringUtil.isEmpty(to)) return false;
			if (StringUtil.isEmpty(code)) return false;
			if(map.containsKey(to)) {
				String validateCode = map.get(to);
				if (validateCode.equals(code)) {
					return true;
				} else {
					ViewException ve = new ViewException("验证失败！");
			        throw ve;
				}
			}
		} catch(Exception e){
			ViewException ve = new ViewException("验证失败！");
	        throw ve;
		}
		return false;
	}

}
