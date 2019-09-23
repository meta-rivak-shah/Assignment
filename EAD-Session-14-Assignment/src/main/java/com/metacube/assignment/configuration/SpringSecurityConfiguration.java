package com.metacube.assignment.configuration;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * This class represents the Spring Security Configuration
 * @author rivak
 * Dated 09/23/2019
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
    DataSource dataSource;
	
    @Autowired
	public SpringSecurityConfiguration(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}

	//Enable jdbc authentication
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource);
    }

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http.authorizeRequests().antMatchers("/welcome").hasAnyRole("USER", "ADMIN")
         .antMatchers("/getUser").hasAnyRole("USER", "ADMIN")
         .antMatchers("/updateUser").hasAnyRole("USER", "ADMIN")
         .antMatchers("/getAdmin").hasAnyRole("ADMIN")
         .antMatchers("/updateAdmin").hasAnyRole("ADMIN")
         .anyRequest().authenticated().and().formLogin().loginPage("/login")
         .permitAll().defaultSuccessUrl("/welcome").failureUrl("/login?error=true").
         and().logout().permitAll();

     http.csrf().disable();
	}

}
