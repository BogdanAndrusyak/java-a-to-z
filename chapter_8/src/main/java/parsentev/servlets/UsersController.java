package parsentev.servlets;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * TODO: comment.
 * Created by Bogdan on 4/20/2016.
 */
public class UsersController extends HttpServlet{
    private static final Logger Log = LoggerFactory.getLogger(UsersController.class);
    private List<String> users = new CopyOnWriteArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", UserStorage.getInstance().getUsers());
        req.getRequestDispatcher("/WEB-INF/views/UsersView.jsp").forward(req, resp); // dispatcher - webapp directory
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        UserStorage.getInstance().add(new User(req.getParameter("login"), req.getParameter("email")));
        resp.sendRedirect(String.format("%s/", req.getContextPath()));
    }
}
