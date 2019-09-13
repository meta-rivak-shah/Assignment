package com.metacube.metaparking.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.metacube.metaparking.filter.Myfilter;

@Configuration
public class Config {

	@Bean
	public FilterRegistrationBean<Myfilter> validationFilter() {
		FilterRegistrationBean<Myfilter> registrationBean = new FilterRegistrationBean<>();

		registrationBean.setFilter(new Myfilter());
		registrationBean.addUrlPatterns("/Vehicleform",
				"/FriendList", "/Profile", "/GatePass", "/frndProfile",
				"/takeGatePass", "/finalCompleted" , "/editProfile");

		return registrationBean;
	}
}
