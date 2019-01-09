package com.jzsk.filecode.exception;

/**
 * 
 * Created by zcx on 2016骞�12鏈�1鏃�
 */
public class ContextRuntimeException extends RuntimeException {
	
	private static final long serialVersionUID = -7140290757686393916L;

	
    public ContextRuntimeException() {
        super();
    }

    public ContextRuntimeException(String message) {
        super(message);
    }

    public ContextRuntimeException(Throwable cause) {
        super(cause);
    }

    public ContextRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
   
  
}
