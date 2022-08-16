package com.my.project.common.exception;


import com.my.project.common.utils.LanguageUtils;
import com.my.project.common.utils.MessageUtils;
import com.my.project.common.utils.SpringContextUtils;
import lombok.Data;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;

/**
 * custom exception class
 *
 * @author
 */
@Data
public class MyException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private static MessageSource messageSource;
	static {
		messageSource = SpringContextUtils.getBean(MessageSource.class);
	}
    private int code;
	private String msg;
	private static String codeCoverMsg(int code,String... params){
		//
		if("en-US".equals(LanguageUtils.getLanguage())){

			return messageSource.getMessage(String.valueOf(code), params, Locale.ENGLISH);
		} else if("zh-CN".equals(LanguageUtils.getLanguage())){

			return messageSource.getMessage(String.valueOf(code), params, Locale.CHINESE);
		} else {

			return messageSource.getMessage(String.valueOf(code), params, LocaleContextHolder.getLocale());
		}

	}
	private static String codeCoverMsg(String code,String... params){
		//
		if("En".equals(LanguageUtils.getLanguage())){

			return messageSource.getMessage(String.valueOf(code), params, Locale.ENGLISH);
		} else if("Cn".equals(LanguageUtils.getLanguage())){

			return messageSource.getMessage(String.valueOf(code), params, Locale.CHINESE);
		} else {

			return messageSource.getMessage(String.valueOf(code), params, LocaleContextHolder.getLocale());
		}

	}
	public MyException(int code) {
		super(codeCoverMsg(code));
		this.msg = super.getMessage();
		this.code = code;
	}

	public MyException(int code, String... params) {
		super(codeCoverMsg(code,params));
		this.msg = super.getMessage();
		this.code = code;
	}

	public MyException(int code, Throwable e) {
		super(e);
		this.code = code;
		this.msg = MessageUtils.getMessage(code);
	}

	public MyException(int code, Throwable e, String... params) {
		super(codeCoverMsg(code,params), e);
		this.msg = super.getMessage();
		this.code = code;
	}

	public MyException(String msg) {
		super(msg);
		this.code = ErrorCode.INTERNAL_SERVER_ERROR;
		this.msg = msg;
	}

	public MyException(String msg, Throwable e) {
		super(codeCoverMsg(msg),e);
		this.code = ErrorCode.INTERNAL_SERVER_ERROR;
		this.msg = msg;
	}


	public static class MessageException extends MyException{
		public MessageException(int code, Throwable e) {
			super(code, e);
		}

		public MessageException(int code) {
			super(code);
		}
		public MessageException(String msg){
			super(msg);
		}
	}

}
