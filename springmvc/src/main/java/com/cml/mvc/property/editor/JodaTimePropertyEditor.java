package com.cml.mvc.property.editor;

import java.beans.PropertyEditorSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;

import com.cml.mvc.property.formatter.JodaTimeFormatter;

/**
 * jodaTime日期格式转换
 * 
 * @author 陈孟琳
 *
 *         2015年4月22日
 */
public class JodaTimePropertyEditor extends PropertyEditorSupport {

	private static final Log LOG = LogFactory
			.getLog(JodaTimePropertyEditor.class);

	@Override
	public String getAsText() {
		
		System.out.println("=====getAsText============");

		LOG.debug("===>getAsText:" + getValue());

		Object obj = getValue();
		if (null != obj) {
			return ((DateTime) obj).toString();
		}
		return null;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if (null != text) {
			setValue(new DateTime(text));
		}
		LOG.debug("===>setAsText:" + text);
	}
}
