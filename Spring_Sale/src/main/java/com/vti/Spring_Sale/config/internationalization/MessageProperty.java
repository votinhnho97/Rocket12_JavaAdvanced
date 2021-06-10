package com.vti.Spring_Sale.config.internationalization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class MessageProperty {
	@Autowired
	private MessageSource msgSource;

	/**
	 * Lấy ra message dựa vào key, trong file property
	 * 
	 * @param key
	 * @return
	 */
	public String getMessage(String key) {
		return msgSource.getMessage(key, null, LocaleContextHolder.getLocale());
	}

	/**
	 * Nếu key không tồn tại, trả về defaulMessage
	 * @param key
	 * @param defaultMessage
	 * @return
	 */
	public String getMessage(String key, String defaultMessage) {
		return msgSource.getMessage(key, null, defaultMessage, LocaleContextHolder.getLocale());
	}
}
