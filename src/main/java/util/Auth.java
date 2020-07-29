package util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class Auth {
    public static boolean isAuthorized(HttpServletRequest request) {
        var cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("user_id")) {
                return cookie.getValue() != null;
            }
        }
        return false;
    }

    public static String getCookie(HttpServletRequest request) {
        var cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("user_id")) {
                return cookie.getValue();
            }
        }
        return "";
    }
}
