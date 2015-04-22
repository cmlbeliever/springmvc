package com.cml.mvc.property.editor;

import org.joda.time.DateTime;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

public class BasePropertyEditor implements PropertyEditorRegistrar {

	public void registerCustomEditors(PropertyEditorRegistry registry) {
		System.out.println("=========注册");
		registry.registerCustomEditor(DateTime.class,
				new JodaTimePropertyEditor());
	}

}
