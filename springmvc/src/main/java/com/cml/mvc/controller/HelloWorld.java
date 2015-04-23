package com.cml.mvc.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope(value = "prototype")
public class HelloWorld {

	Log log = LogFactory.getLog(HelloWorld.class);

	private String names;

	@ResponseBody
	@RequestMapping(name = "/hello")
	public String hello() {
		return "index";
	}

	@ResponseBody
	@RequestMapping("/times")
	public DateTime getTime(@RequestParam DateTime time, Integer id,
			ModelAndView model) {
		log.debug("==========>getTime,time:" + time);
		log.debug("==========>getTime,id:" + id);
		model.setViewName("time");
		model.addObject("time", time);
		return time;
	}

	@ResponseBody
	@RequestMapping("/test")
	public String test(@RequestParam(defaultValue = "hhh") String name) {

		System.out.println("hello world:" + Thread.currentThread().getId()
				+ "," + names);
		names = "哈哈：changen";
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("name", "result name" + name);

		return "xxx";

	}

	@RequestMapping("/hello1")
	@ResponseBody
	public ResponseEntity<String> hello1(@RequestParam String name)
			throws Exception {
		System.out.println("handler:=====>" + name);
		throw new Exception("sssssssssssssss");
		// return new ResponseEntity<String>("哈哈", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler
	public @ResponseBody String handle(IllegalStateException e) {
		return "IllegalStateException handled!";
	}

}
