package com.my.project.common.utils;

import org.springframework.http.HttpHeaders;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Http tools class
 *
 * @author
 */
public class HttpContextUtils {

	public static HttpServletRequest getHttpServletRequest() {
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		if(requestAttributes == null){
			return null;
		}

		return ((ServletRequestAttributes) requestAttributes).getRequest();
	}

	public static Map<String, String> getParameterMap(HttpServletRequest request) {
		Enumeration<String> parameters = request.getParameterNames();

		Map<String, String> params = new HashMap<>(16);
		while (parameters.hasMoreElements()) {
			String parameter = parameters.nextElement();
			String value = request.getParameter(parameter);
			if (!StringUtils.isEmpty(value)) {
				params.put(parameter, value);
			}
		}

		return params;
	}

	public static String getLanguage() {
		// default language
		String defaultLanguage = "zh-CN";
		//request
		HttpServletRequest request = getHttpServletRequest();
		if(request == null){
			return defaultLanguage;
		}

		//request language
		defaultLanguage = request.getHeader(HttpHeaders.ACCEPT_LANGUAGE);

		return defaultLanguage;
	}
}
