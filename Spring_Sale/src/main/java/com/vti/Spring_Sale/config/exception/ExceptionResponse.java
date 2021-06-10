package com.vti.Spring_Sale.config.exception;

import org.springframework.http.HttpStatus;

public class ExceptionResponse {
	private String userMessage;
	private String internalMessage;
	private HttpStatus code;
	private String moreInfo;

	public ExceptionResponse(String userMessage, String internalMessage, HttpStatus code, String moreInfo) {
		super();
		this.userMessage = userMessage;
		this.internalMessage = internalMessage;
		this.code = code;
		this.moreInfo = moreInfo;
	}

	public String getUserMessage() {
		return userMessage;
	}

	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}

	public String getInternalMessage() {
		return internalMessage;
	}

	public void setInternalMessage(String internalMessage) {
		this.internalMessage = internalMessage;
	}

	public HttpStatus getCode() {
		return code;
	}

	public void setCode(HttpStatus code) {
		this.code = code;
	}

	public String getMoreInfo() {
		return moreInfo;
	}

	public void setMoreInfo(String moreInfo) {
		this.moreInfo = moreInfo;
	}

}
