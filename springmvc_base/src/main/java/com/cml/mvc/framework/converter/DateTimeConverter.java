package com.cml.mvc.framework.converter;

import java.io.IOException;

import org.joda.time.DateTime;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.cfg.SerializerFactoryConfig;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.BasicSerializerFactory;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import com.fasterxml.jackson.databind.ser.SerializerFactory;
import com.fasterxml.jackson.databind.ser.Serializers;

/**
 * DateTime json返回日期格式化
 * 
 * @author 陈孟琳
 *
 *         2015年4月30日
 */
public class DateTimeConverter extends ObjectMapper {

	public static final String DATE_FORMATTER = "yyyyMMddHHmmss";

	public DateTimeConverter() {
	}
}
