/**
 * RequestUtility.java
 */
package com.jzsk.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jzsk.model.serialization.JsonResultValue;
import com.jzsk.model.value.GetCondValue;

/**
 * @author LiuYangTao
 *
 */
public class RequestUtility {

	/** 请求方式-POST */
	public static final String REQUEST_METHOD_POST = "post";
	/** 请求方式-GET */
	public static final String REQUEST_METHOD_GET = "get";
	/** URL参数 */
	public static final String PARAM_URL_PATH = "param_url_path";
	/** 发送数组参数 */
	public static final String PARAM_ARRAY = "param_array";

	/**
	 * 生成Map参数
	 * 
	 * @param getCondValue
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Map<String, Object> generateParams(GetCondValue getCondValue) {
		// 请求参数
		Map<String, Object> params = new HashMap<>();

		Class clazz = getCondValue.getClass();
		Class cazzSuper = clazz.getSuperclass();
		if (cazzSuper != Object.class) {
			Field[] fields = cazzSuper.getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				try {
					params.put(field.getName(), field.get(getCondValue));
				} catch (IllegalArgumentException e) {
					// 什么也不做
				} catch (IllegalAccessException e) {
					// 什么也不做
				}
			}
		}
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			try {
				params.put(field.getName(), field.get(getCondValue));
			} catch (IllegalArgumentException e) {
				// 什么也不做
			} catch (IllegalAccessException e) {
				// 什么也不做
			}
		}

		return params;
	}

	/**
	 * 请求方法
	 * 
	 * @param url 请求地址
	 * @param params 请求参数Map
	 * @param typeReference 返回类
	 * @param requestMethod 请求方法
	 * @return JsonResultValue
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public JsonResultValue sendReq(String url, Map<String, Object> params, TypeReference typeReference, String requestMethod) throws Exception {
		if (params == null) {
			params = new HashMap<>();
		}
		if (!REQUEST_METHOD_POST.equals(requestMethod) && !REQUEST_METHOD_GET.equals(requestMethod)) {
			throw new IllegalArgumentException();
		}
		return sendRequest(url, params, typeReference, requestMethod);
	}

	/**
	 * json转对象
	 * 
	 * @param json
	 * @param typeReference
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public <T> T jsonToObject(String json, TypeReference typeReference) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		// 忽略沒有的属性
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		// 视空字符传为null
		mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
		return mapper.readValue(json, typeReference);
	}

	/**
	 * 
	 * 发送请求请求
	 * 
	 * @param url 发送请求的URL
	 * @param param Map字符串
	 * @param requestMethod 请求类型
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	@SuppressWarnings("rawtypes")
	private JsonResultValue sendRequest(String url, Map<String, Object> params, TypeReference typeReference, String requestMethod) throws Exception {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			String paramStrUrl = url + toUrlParams(params, requestMethod);
			String paramStrJson = toJsonParams(params, requestMethod);
			URL realUrl = new URL(paramStrUrl);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
			conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			if (REQUEST_METHOD_POST.equals(requestMethod)) {
				// 发送POST请求必须设置如下两行
				conn.setDoOutput(true);
				conn.setDoInput(true);
				// 获取URLConnection对象对应的输出流
				out = new PrintWriter(conn.getOutputStream());
				out.print(paramStrJson);
				// flush输出流的缓冲
				out.flush();
			} else if (REQUEST_METHOD_GET.equals(requestMethod)) {
				// 建立实际的连接
				conn.connect();
			}
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送请求出现异常！" + e);
			throw e;
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				throw ex;
			}
		}
		return jsonToObject(result, typeReference);
	}

	/**
	 * 拼装参数（URL）
	 * 
	 * @param map
	 * @param requestMethod 请求类型
	 * @return
	 */
	private String toUrlParams(Map<String, Object> params, String requestMethod) {
		String paramsStr = "";
		if (params.containsKey(PARAM_URL_PATH)) {
			paramsStr += "/" + params.get(PARAM_URL_PATH);
		}
		if (params.size() > 0) {
			String paramsStrT = "";
			if (REQUEST_METHOD_GET.equals(requestMethod)) {
				for (String key : params.keySet()) {
					if (PARAM_URL_PATH.equals(key) || PARAM_ARRAY.equals(key)) {
						continue;
					}
					Object value = params.get(key);
					if (value == null || StringUtility.isEmptyAfterTrim(String.valueOf(value))) {
						continue;
					}
					if (StringUtility.isEmptyAfterTrim(paramsStrT)) {
						paramsStrT += "?";
					} else {
						paramsStrT += "&";
					}
					paramsStrT += key + "=" + value;
				}
			}
			paramsStr += paramsStrT;
		}
		return paramsStr;
	}

	/**
	 * 拼装参数（POST）
	 * 
	 * @param map
	 * @param requestMethod 请求类型
	 * @return
	 */
	private String toJsonParams(Map<String, Object> params, String requestMethod) throws Exception {
		String paramsStr = "";
		if (REQUEST_METHOD_POST.equals(requestMethod)) {
			if (params.containsKey(PARAM_ARRAY)) {
				paramsStr += Arrays.toString((Object[]) params.get(PARAM_ARRAY));
			} else {
				Map<String, Object> paramsTemp = new HashMap<>();
				for (String key : params.keySet()) {
					Object value = params.get(key);
					if (value == null || StringUtility.isEmptyAfterTrim(String.valueOf(value))) {
						continue;
					} else {
						paramsTemp.put(key, value);
					}
				}
				if (paramsTemp.size() > 0) {
					ObjectMapper mapper = new ObjectMapper();
					paramsStr = mapper.writeValueAsString(paramsTemp);
				}
			}
		}
		return paramsStr;
	}
}
