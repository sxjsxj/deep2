package com.deep.two.test.service;

import org.junit.Test;
import com.deep.two.service.authority.EmailService;
import com.deep.two.test.BaseTest;
import com.deep.two.util.SpringContextUtil;
import com.deep.two.util.ViewException;

public class MailServiceTest extends BaseTest {
	
	@Test
	public void sendMail() throws ViewException {
		EmailService emailService = SpringContextUtil.getBean(EmailService.class);
		emailService.sendEmail("906842430@qq.com");
	}
}
