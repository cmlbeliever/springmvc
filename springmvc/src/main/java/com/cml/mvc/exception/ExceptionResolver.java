package com.cml.mvc.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionResolver {

	@ExceptionHandler
	public @ResponseBody String handleBusinessException(Exception ex) {
		System.out.println("报错啦。。。");
		ex.printStackTrace();
		return "Handled BusinessException"+ex.getMessage();
	}

}
