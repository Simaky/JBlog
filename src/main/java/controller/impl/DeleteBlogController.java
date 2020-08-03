package controller.impl;

import controller.Controller;
import repository.BlogsRepository;
import util.Auth;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteBlogController implements Controller {
    @Override
    public void executePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String blogID = request.getParameter("blog_id");
        BlogsRepository blogsRepository = new BlogsRepository();

        if (blogID == null || blogID.isEmpty()) {
            request.getRequestDispatcher("error_not_found.jsp").forward(request, response);
            return;
        }

        blogsRepository.deleteBlogByID(blogID);
        response.sendRedirect("index.jsp");
    }
}
