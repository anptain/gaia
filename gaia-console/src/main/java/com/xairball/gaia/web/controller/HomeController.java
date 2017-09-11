package com.xairball.gaia.web.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xairball.gaia.exception.BadCaptchaException;
import com.xairball.gaia.model.User;
import com.xairball.gaia.service.UserService;
import com.xairball.gaia.web.vo.JsonResult;

@Controller
public class HomeController extends AbstractController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	public String index(@Valid User user,BindingResult br) {
		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(String error, Model model, HttpSession session) {
		Object expcetion = session.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
		if (error != null && expcetion != null) {
			if (expcetion instanceof BadCredentialsException) {
				model.addAttribute("loginMsg", "用户名或密码错误");
			}
			if (expcetion instanceof BadCaptchaException) {
				model.addAttribute("loginMsg", "验证码输入错误");
			}
		}
		return "login";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register() {
		return "register";
	}
	@ResponseBody
	@RequestMapping("/test")
	public JsonResult test(){
		return JsonResult.buildDefeatResult("你好");
	}
	
}
