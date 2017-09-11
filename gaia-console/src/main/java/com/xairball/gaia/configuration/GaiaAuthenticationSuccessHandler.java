package com.xairball.gaia.configuration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xairball.gaia.web.vo.JsonResult;

@Component
public class GaiaAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
			throws IOException, ServletException {
		// if ("application/json".equals(request.getHeader("Content-Type"))) {
		/*
		 * USED if you want to AVOID redirect to LoginSuccessful.htm in JSON
		 * authentication
		 */
		response.setContentType("application/json;charset=UTF-8");
		JsonResult result = JsonResult.buildSuccessResult("登录成功");
		response.getWriter().print(objectMapper.writeValueAsString(result));
		response.getWriter().flush();
		// } else {
		// super.onAuthenticationSuccess(request, response, auth);
		// }
	}
}
