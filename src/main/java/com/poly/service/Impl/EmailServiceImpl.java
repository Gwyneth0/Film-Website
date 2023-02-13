package com.poly.service.Impl;

import javax.servlet.ServletContext;

import com.poly.service.EmailService;
import com.poly.util.SendMailUtil;

public class EmailServiceImpl implements EmailService {

	private static final String EMAIL_WELCOME_SUBJEC = "Welcome to Online Entertaiment";
	private static final String EMAIL_FORGOT_PASSWORD = "ONLINE ENTERTAIMENT - New password";

	@Override
	public void sendMail(ServletContext context, com.poly.entity.User recipient, String type) {

		String host = context.getInitParameter("host");
		String port = context.getInitParameter("port");
		String user = context.getInitParameter("user");
		String pass = context.getInitParameter("pass");

		try {
			String content = null;
			String subject = null;
			switch (type) {
			case "welcome":
				subject = EMAIL_WELCOME_SUBJEC;
				content = "Dear " + recipient.getUsername() + ", hope you have a good time!";
				break;
			case "forgot":
				subject = EMAIL_FORGOT_PASSWORD;
				content = "Dear " + recipient.getUsername() + ", your new password here: " + recipient.getPassword();
				break;
			default:
				subject = "Online Entertaiment";
				content = "Maybe this email is wrong, don't care about it";
			}
			SendMailUtil.sendEmail(host, port, user, pass, recipient.getEmail(), subject, content);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
