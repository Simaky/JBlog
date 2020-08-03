package controller.impl;

import controller.Controller;
import model.UsersEntity;
import repository.UsersRepository;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController implements Controller {
    @Override
    public void executePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (email.isEmpty() || password.isEmpty()) {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

        UsersRepository usersRepository = new UsersRepository();
        UsersEntity user = usersRepository.findByEmail(email);

        if (user == null || !password.equals(user.getPassword())) {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

        request.getSession().setAttribute("user_id", user.getId().toString());

        response.sendRedirect("index.jsp");
    }
}
