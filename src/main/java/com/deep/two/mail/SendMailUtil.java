package com.deep.two.mail;

import java.util.Properties;

import javax.annotation.Resource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.stereotype.Component;

@Component
public class SendMailUtil {
	@Resource(name = "mailProperties")
	private Properties properties;
	
	public void send(Mail mail)throws MessagingException {
		Properties props = new Properties();
		// 开启debug调试
		props.setProperty("mail.debug", properties.getProperty("mail.debug"));
		// 发送服务器需要身份验证
		props.setProperty("mail.smtp.auth", properties.getProperty("mail.smtp.auth"));
		// 设置邮件服务器主机名
		props.setProperty("mail.host", properties.getProperty("mail.host"));
		// 发送邮件协议名称
		props.setProperty("mail.transport.protocol", properties.getProperty("mail.transport.protocol"));
		
		// 设置环境信息
		Session session = Session.getInstance(props);
		
		// 创建邮件对象
		Message msg = new MimeMessage(session);
		msg.setSubject(properties.getProperty("mail.subject"));
		// 设置邮件内容
		msg.setText(mail.getMessage());
		msg.setContent(mail.getMessage(), "text/html;charset=UTF-8");
		// 设置发件人
		msg.setFrom(new InternetAddress(properties.getProperty("mail.sender.username")));
		
		Transport transport = session.getTransport();
		// 连接邮件服务器
		transport.connect(properties.getProperty("mail.sender.username"), properties.getProperty("mail.sender.password"));
		// 发送邮件
		transport.sendMessage(msg, new Address[] {new InternetAddress(mail.getReceiver())});
		// 关闭连接
		transport.close();
	}
}