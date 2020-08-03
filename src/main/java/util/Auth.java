package util;

import javax.servlet.http.HttpServletRequest;

public class Auth {
    public static boolean isAuthorized(HttpServletRequest request) {
        return request.getSession().getAttribute("user_id") != null;
    }

    public static String getCookie(HttpServletRequest request) {
        var userId = request.getSession().getAttribute("user_id");
        if (userId != null) {
            return userId.toString();
        }
        return "";
    }
}
