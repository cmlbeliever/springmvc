package com.cml.mvc.web.user.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cml.mvc.beans.User;
import com.cml.mvc.web.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	public UserController() {
		System.out.println("init======================================");
	}

	@Resource
	private UserService userService;

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
}
