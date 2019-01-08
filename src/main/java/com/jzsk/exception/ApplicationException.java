/*
 * ApplicationException.java
 * 
 * 2017
 * 
 * DuLei
 */
package com.jzsk.exception;

/**
 * @author DuLei
 *
 */
@SuppressWarnings("serial")
public class ApplicationException extends Exception {

	/** MessageCode */
	private String messageCode;

	/**
	 * 鏋勯�犲嚱鏁�
	 * 
	 * @param messageCode
	 * @param message
	 */
	public ApplicationException(String messageCode, String message) {
		super(message);
		this.messageCode = messageCode;
	}

	/**
	 * 鏋勯�犲嚱鏁�
	 * 
	 * @param messageCode
	 * @param message
	 */
	public ApplicationException(String messageCode, String message, Throwable throwable) {
		super(message, throwable);
		this.messageCode = messageCode;
	}

	/**
	 * @return messageCode
	 */
	public String getMessageCode() {
		return messageCode;
	}
}
