package com.deep.two.mail;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailUtil {
	
	public static void send(Mail mail)throws MessagingException {
		Properties props = new Properties();
		// 开启debug调试
		props.setProperty("mail.debug", "true");
		// 发送服务器需要身份验证
		props.setProperty("mail.smtp.auth", "true");
		// 设置邮件服务器主机名
		props.setProperty("mail.host", "smtp.sina.com");
		// 发送邮件协议名称
		props.setProperty("mail.transport.protocol", "smtp");
		
		// 设置环境信息
		Session session = Session.getInstance(props);
		
		// 创建邮件对象
		Message msg = new MimeMessage(session);
		msg.setSubject(mail.getSubject());
		// 设置邮件内容
		msg.setText(mail.getMessage());
		// 设置发件人
		msg.setFrom(new InternetAddress("sxj_19891101@sina.com"));
		
		Transport transport = session.getTransport();
		// 连接邮件服务器
		transport.connect("sxj_19891101@sina.com", "sxj100001jmn");
		// 发送邮件
		transport.sendMessage(msg, new Address[] {new InternetAddress(mail.getReceiver())});
		// 关闭连接
		transport.close();
	}
}