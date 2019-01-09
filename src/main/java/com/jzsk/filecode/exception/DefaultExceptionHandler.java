package com.jzsk.filecode.exception;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpServerErrorException;

/**
 * 鍏叡寮傚父澶勭悊绫�
 * @author zcx 2016-12-01
 *
 */
@ControllerAdvice(basePackages = {"com.cdzhnf.wisfarmwebinterface" })
public class DefaultExceptionHandler {

	private static final Logger logger = LogManager.getLogger(DefaultExceptionHandler.class);

	@ExceptionHandler(HttpServerErrorException.class)
	@ResponseBody
	private String handleHttpServerErrorException(HttpServerErrorException exception) throws IOException {
		return exceptionMessageHandle(exception);
	}

	@ExceptionHandler(TypeMismatchException.class)
	@ResponseBody
	public String handleInvalidRequestException(TypeMismatchException exception) {
		return exceptionMessageHandle(exception);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseBody
	public String handleInvalidRequestException(HttpMessageNotReadableException exception) {
		return exceptionMessageHandle(exception);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseBody
	public String handleInvalidRequestException(IllegalArgumentException exception) {
		return exceptionMessageHandle(exception);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	public String handleInvalidRequestException(MethodArgumentNotValidException exception) {
		return exceptionMessageHandle(exception);
	}

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	@ResponseBody
	public String handleNotSupportedException(HttpRequestMethodNotSupportedException exception) {
		return exceptionMessageHandle(exception);
	}

	@ExceptionHandler(ContextRuntimeException.class)
	@ResponseBody
	private String handleContextRuntimeException(ContextRuntimeException exception) throws IOException {
		return exceptionMessageHandle(exception);
	}

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public String handleOtherException(Exception exception) {
		return exceptionMessageHandle(exception);
	}

	private String exceptionMessageHandle(Exception exception) {
		logger.error(exception.getMessage(), exception);
		return getResult(exception.getMessage());
	}

	private String getResult(String errorMsg) {
//		ReturnValues returnValues = new ReturnValues();
//		returnValues.setFlag(ReturnValues.FAIL);
//		returnValues.setMsg(errorMsg);
//		returnValues.setData("");
//		return JSON.toJSONString(returnValues);
		
		return errorMsg;
	}

}
