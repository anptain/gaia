package com.xairball.gaia.web.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.xairball.gaia.web.vo.SessionUser;

public abstract class AbstractController {
	
	protected Long getUserId() {
		SessionUser user = this.getUser();
		return user != null ? user.getUserId() : null;
	}

	protected SessionUser getUser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			return (SessionUser) principal;
		}
		return null;
	}
	
}
