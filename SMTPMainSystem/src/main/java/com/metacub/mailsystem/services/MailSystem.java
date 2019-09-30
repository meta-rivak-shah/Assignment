package com.metacub.mailsystem.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public interface MailSystem {

	String sendMail();
}
