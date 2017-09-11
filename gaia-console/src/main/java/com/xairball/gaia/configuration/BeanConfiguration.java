package com.xairball.gaia.configuration;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xairball.gaia.dao.UserDao;
import com.xairball.gaia.model.User;
import com.xairball.gaia.web.vo.SessionUser;


@Configuration
public class BeanConfiguration {
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
	
	@Bean
	public ObjectMapper objectMapper(){
		return new ObjectMapper();
	}
	
	@Bean
	public UserDetailsService userDetailsService(final UserDao userDao) {
		return new UserDetailsService() {
			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				User user = userDao.selectByUsername(username);
				if (user == null) {
					throw new UsernameNotFoundException("");
				}
				// authorities.add(new
				// SimpleGrantedAuthority(user.getRole().name()));
				return new SessionUser(user.getId(), user.getUsername(), user.getPassword(), new ArrayList<GrantedAuthority>());
			}
		};
	}
}
