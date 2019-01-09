/**
 * 
 */
package com.jzsk.filecode.model.serialization;

/**
 * @author LiuYangTao
 *
 */
public class JsonResultValue<T> {

	/** 错误码 */
	private String code;
	/** 错误信息 */
	private String msg;
	/** 信息 */
	private T data;

	/**
	 * @return code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            要设置的 code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg
	 *            要设置的 msg
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * @return data
	 */
	public T getData() {
		return data;
	}

	/**
	 * @param data
	 *            要设置的 data
	 */
	public void setData(T data) {
		this.data = data;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "JsonResultValue [code=" + code + ", msg=" + msg + ", data=" + data + "]";
	}

}
