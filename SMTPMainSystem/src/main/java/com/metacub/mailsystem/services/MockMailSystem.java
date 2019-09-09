package com.metacub.mailsystem.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class MockMailSystem implements MailSystem{

	@Override
	public String sendMail() {
		return 	"send by Mock mail Protcol";		
	}

	
}
