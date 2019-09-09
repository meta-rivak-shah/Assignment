package com.metacub.mailsystem.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.metacub.mailsystem.services.MockMailSystem;
import com.metacub.mailsystem.services.SmtpMailSystem;

/**
 * Configuration class
 * @author Rivak
 *
 */
//@Configuration
public class mailConfig {
	
	@Bean
	//@Primary
	@Qualifier("mockMail")
	public MockMailSystem mockMailSender()
	{
		return new MockMailSystem();
	}
	
	@Bean
	//@Primary
	@Qualifier("smtpMail")
	public SmtpMailSystem  smtpMailSender()
	{
		return new SmtpMailSystem();
	}

}