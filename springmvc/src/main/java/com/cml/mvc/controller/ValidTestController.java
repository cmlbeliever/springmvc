package com.cml.mvc.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cml.mvc.model.User;

@Controller
public class ValidTestController {

	Log log = LogFactory.getLog(ValidTestController.class);

	@RequestMapping("/user")
	public String testUser(@Valid @ModelAttribute("user") User user,
			BindingResult result) {
		user.setBirthday(new DateTime());
		log.debug("用户信息校验：" + user);
		log.debug("用户信息校验：" + result.hasErrors());
		log.debug("用户信息校验：" + result.getAllErrors());
		return "user";
	}
}
