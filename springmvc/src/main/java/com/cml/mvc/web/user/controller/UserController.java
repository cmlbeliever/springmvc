package com.cml.mvc.web.user.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cml.mvc.beans.User;
import com.cml.mvc.web.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserService userService;

	@RequestMapping("/addUser")
	public void addUser() {

		System.out.println("ccccc");

		User user = new User();
		user.setName("测试：" + System.currentTimeMillis());

		userService.addUser(user);
		System.out.println("ddddd");

	}
}
