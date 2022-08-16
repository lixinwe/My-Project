package com.my.project.common.security.password;

/**
 * password tools class
 *
 * @author
 */
public class PasswordUtils {
    private static PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    /**
     * encoder
     * @param str  string
     * @return     return encoder string
     */
    public static String encode(String str){
        return passwordEncoder.encode(str);
    }


    /**
     * Compare passwords for equality
     * @param str  enable password
     * @param  password  Encrypted password
     * @return     true：success    false：fail
     */
    public static boolean matches(String str, String password){
        return passwordEncoder.matches(str, password);
    }


    public static void main(String[] args) {
        String str = "admin";
        String password = encode(str);

        System.out.println(password);
        System.out.println(matches(str, password));
    }

}
