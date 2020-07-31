package controller.impl;

import controller.Controller;
import model.UsersEntity;
import repository.UsersRepository;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationController implements Controller {
    @Override
    public void executePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (login.isEmpty() || email.isEmpty() || password.isEmpty()) {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

        UsersRepository usersRepository = new UsersRepository();
        UsersEntity user = usersRepository.findByEmail(email);

        if (user != null) {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

        usersRepository.createUser(login, email, password);
        user = usersRepository.findByEmail(email);

        request.getSession().setAttribute("user_id", user.getId().toString());

        response.sendRedirect("index.jsp");
    }

    @Override
    public void executeGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("registration.jsp").forward(request, response);
    }
}
