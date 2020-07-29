import controller.Controller;
import controller.impl.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = {"/", "/login", "/logout", "/registration", "/addblog"})
public class MainServlet extends HttpServlet {
    private static final Controller notFoundController = new NotFoundController();

    private final Map<String, Controller> controllerMap = new HashMap<>() {{
        put("/login", new LoginController());
        put("/logout", new LogoutController());
        put("/registration", new RegistrationController());
        put("/addblog", new AddBlogController());
        put("/deleteblog", new DeleteBlogController());
        put("/", new MainController());
    }};

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var controller = getControllerByPath(req.getServletPath());
        controller.executeGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var controller = getControllerByPath(req.getServletPath());
        controller.executePost(req, resp);

    }

    private Controller getControllerByPath(String path) {
        return controllerMap.getOrDefault(path, notFoundController);
    }
}
