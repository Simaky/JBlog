package controller.impl;

import controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NotFoundController implements Controller {
    @Override
    public void executeGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("error_not_found.jsp").forward(request, response);
    }
}
