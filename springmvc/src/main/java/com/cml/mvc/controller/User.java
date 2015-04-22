package com.cml.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class User extends MultiActionController {
	public ModelAndView add(HttpServletRequest request,
			HttpServletResponse resp, String name) {
		System.out.println("===============" + name + ","
				+ request.getParameter("name"));
		return new ModelAndView("time");
	}
}
