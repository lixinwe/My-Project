package com.my.project.common.utils;

public abstract class LanguageUtils {
	protected static ThreadLocal<String> LANGUAGE = new ThreadLocal<>();

	public static <T extends String> T getLanguage(){
		return (T) LANGUAGE.get();
	}
	public static void setLanguage(String Language) {
		LANGUAGE.set(Language);
	}

}
