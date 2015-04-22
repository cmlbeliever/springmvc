package com.cml.mvc.base;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

import com.cml.mvc.property.editor.JodaTimePropertyEditor;

public class BaseWebBindingInital implements WebBindingInitializer {
	private static final Log LOG = LogFactory
			.getLog(BaseWebBindingInital.class);

	@Override
	public void initBinder(WebDataBinder binder, WebRequest request) {
		binder.registerCustomEditor(DateTime.class,
				new JodaTimePropertyEditor());
		LOG.debug("BaseWebBindingInital->initBinder=====>sessionId:"
				+ request.getSessionId());
	}

}
