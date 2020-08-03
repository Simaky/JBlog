package controller.impl;

import controller.Controller;
import repository.BlogsRepository;
import util.Auth;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddBlogController implements Controller {
    @Override
    public void executePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String text = request.getParameter("text");

        if (title.isEmpty() || text.isEmpty()) {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

        var userId = Auth.getCookie(request);
        if (userId.isEmpty()) {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

        BlogsRepository blogsRepository = new BlogsRepository();
        blogsRepository.createBlog(title, text, userId);

        response.sendRedirect("index.jsp");
    }

    @Override
    public void executeGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("addblog.jsp").forward(request, response);
    }
}
