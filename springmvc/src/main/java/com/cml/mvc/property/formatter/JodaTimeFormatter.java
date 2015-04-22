package com.cml.mvc.property.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.format.Formatter;

/**
 * dateTime日期格式化
 * 
 * @author 陈孟琳
 *
 *         2015年4月22日
 */
public class JodaTimeFormatter implements Formatter<DateTime> {

	private static final Log LOG = LogFactory.getLog(JodaTimeFormatter.class);

	@Override
	public String print(DateTime object, Locale locale) {
		LOG.debug("===>print:" + object);
		if (null != object) {
			return object.toString("yyyyMMdd HH");
		}
		return null;
	}

	@Override
	public DateTime parse(String text, Locale locale) throws ParseException {
		LOG.debug("===>parse:" + text);
		if (null != text) {
			try {
				return DateTimeFormat.forPattern("yyyyMMdd HHmmss")
						.parseDateTime(text);
			} catch (Exception e) {
				LOG.debug("===>parse exeception:text：" + text + ",error:"
						+ e.getMessage());
			}
		}
		return new DateTime();
	}

}
