package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Controller {
    default void executeGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new RuntimeException("Not implemented");
    }

    default void executePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new RuntimeException("Not implemented");
    }
}
