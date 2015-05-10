package com.cml.mvc.web.user.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cml.mvc.beans.User;
import com.cml.mvc.framework.util.ErrorsUtil;
import com.cml.mvc.web.user.bean.UserLoginBean;
import com.cml.mvc.web.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserService userService;

	@RequestMapping("/login")
	public ModelAndView login(@Valid @ModelAttribute("user") UserLoginBean login, BindingResult result,
			ModelAndView model) {

		if (result.hasErrors()) {
			System.out.println("错误信息：" + ErrorsUtil.getAllErrors(result));
		} else {
			try {
				Subject subject = SecurityUtils.getSubject();
				subject.login(new UsernamePasswordToken(login.getUsername(),
						login.getPassword(), login.isRemember()));
			} catch (AuthenticationException e) {
				result.reject("用户名或密码错误");
			}

		}

		model.setViewName("forward:/login.jsp");

		return model;
	}

	@RequestMapping("tiles")
	public String tileTest() {
		return "jsp/admin/login";
	}

	@ResponseBody
	@RequestMapping("addUser")
	public User addUser() {

		System.out.println("ccccc");

		User user = new User();
		user.setName("测试：" + System.currentTimeMillis());

		userService.addUser(user);
		System.out.println("ddddd");

		return user;

	}

	@ResponseBody
	@RequestMapping("queryUser")
	public List<User> queryUser() {
		System.out.println(userService.getUsers());
		return userService.getUsers();

	}
}
