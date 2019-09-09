package com.metacub.mailsystem.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class SmtpMailSystem implements MailSystem{

	@Override
	public String sendMail() {
		
		return "Send Mail By SMTP Protocol";
	}

}
