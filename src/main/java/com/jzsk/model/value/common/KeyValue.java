/**
 * 
 */
package com.jzsk.model.value.common;

/**
 * @author LiuYangTao
 *
 */
public class KeyValue {

	/** Key */
	private String Key;
	/** value */
	private Object value;

	/**
	 * @param key
	 * @param value
	 */
	public KeyValue(){
	}
	/**
	 * @param key
	 * @param value
	 */
	public KeyValue(String key,Object value){
		this.Key = key;
		this.value = value;
	}

	/**
	 * @param key
	 * @param value
	 */
	public KeyValue(int key,Object value){
		this.Key = String.valueOf(key);
		this.value = value;
	}
	/**
	 * @return key
	 */
	public String getKey() {
		return Key;
	}

	/**
	 * @param key
	 *            要设置的 key
	 */
	public void setKey(String key) {
		Key = key;
	}

	/**
	 * @return value
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * @param value
	 *            要设置的 value
	 */
	public void setValue(Object value) {
		this.value = value;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "KeyValue [Key=" + Key + ", value=" + value + "]";
	}
}
