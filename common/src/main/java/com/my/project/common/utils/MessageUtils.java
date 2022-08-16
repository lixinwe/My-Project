package com.my.project.common.utils;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

/**
 * internationalization
 *
 * @author
 */
public class MessageUtils {
    private static MessageSource messageSource;
    static {
        messageSource = (MessageSource) SpringContext.getBean("messageSource");
    }

    public static String getMessage(int code){
        return getMessage(code, new String[0]);
    }

    public static String getMessage(int code, String... params){
        return messageSource.getMessage(code+"", params, LocaleContextHolder.getLocale());
    }
}
