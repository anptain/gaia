package com.xairball.gaia.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private GaiaAuthenticationSuccessHandler authenticationSuccessHandler;
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/libs/**", "/css/**", "/js/**", "/images/**", "/webjars/**",
				"/**/favicon.ico");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/", "/register**", "/captcha**").permitAll().anyRequest().authenticated()
				.and().formLogin().loginPage("/login").successHandler(authenticationSuccessHandler).permitAll().and().logout().permitAll();
		http.csrf().disable();
		
		//http.addFilterBefore(new CaptchaAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
	}
}