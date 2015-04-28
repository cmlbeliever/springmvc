package com.cml.mvc.framework.base;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.PropertyAccessException;
import org.springframework.validation.BindingErrorProcessor;
import org.springframework.validation.BindingResult;

/**
 * 绑定错误信息处理类<br/>
 * (1)字段miss错误信息：fieldName+".miss"<br/>
 * (2)转换错误信息：fieldName+".parse.invalid"<br/>
 * 
 * @author 陈孟琳
 *
 *         2015年4月28日
 */
public class DefaultBindErrorProcess implements BindingErrorProcessor {

	private static Log log = LogFactory.getLog(DefaultBindErrorProcess.class);

	public static final String SUFFIX_MISSING = ".miss";
	public static final String SUFFIX_PARSE_INVALID = ".parse.invalid";

	private boolean rejectOnError;

	@Override
	public void processMissingFieldError(String missingField,
			BindingResult bindingResult) {
		if (rejectOnError) {
			bindingResult.reject(missingField + SUFFIX_MISSING);
		}
	}

	@Override
	public void processPropertyAccessException(PropertyAccessException ex,
			BindingResult bindingResult) {

		if (rejectOnError) {
			bindingResult.reject(ex.getPropertyName() + SUFFIX_PARSE_INVALID);
		}

		log.debug("processPropertyAccessException==>proName:["
				+ ex.getPropertyName() + "],value=[" + ex.getValue() + "]");

	}

	public boolean isRejectOnError() {
		return rejectOnError;
	}

	public void setRejectOnError(boolean rejectOnError) {
		this.rejectOnError = rejectOnError;
	}

}
