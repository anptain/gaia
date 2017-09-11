package com.xairball.gaia.web.vo;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class SessionUser extends org.springframework.security.core.userdetails.User {
	private static final long serialVersionUID = -4591798819031403408L;
	private Long userId;

	public SessionUser(Long userId, String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		this.userId = userId;
	}

	public Long getUserId() {
		return userId;
	}
}
