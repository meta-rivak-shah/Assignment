package com.metacub.mailsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metacub.mailsystem.services.MailSystem;

@RestController
public class Controller {

	
	@Autowired
	@Qualifier("smtpMail")
	private MailSystem mail;	
	
	
	/**
	 * the function is used to set mail type doing configuraion file
	 * @param mail
	 */
//	@Autowired
//	@Qualifier("smtpMail")
//	public void getMailTypeByMock(MailSystem mail) {
//		this.mail = mail;
//	}	
	
	/**
	 * the function is used to set mail type doing By smtpMailSystem class  Name Functionality file
	 * @param mail
	 */
//	@Autowired
//	public void getMailTypeByMock(MailSystem smtpMailSystem) {
//		this.mail = smtpMailSystem;
//	}
	
	/**
	 * the function is used to set mail type doing By mockMailSystem Class Name Functionality file
	 * @param mail
	 */
//	
//	@Autowired
//	public void getMailTypeByMock(MailSystem mockMailSystem) {
//		this.mail = mockMailSystem;
//	}
	
	
	
	@RequestMapping("/sendmail")
	public String helloWorld() {
		return this.mail.sendMail();
	}
	
	
}
