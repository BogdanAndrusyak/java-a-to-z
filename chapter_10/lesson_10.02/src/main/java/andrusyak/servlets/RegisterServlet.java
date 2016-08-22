package andrusyak.servlets;

import andrusyak.models.User;
import andrusyak.storages.UserStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * TODO: comment.
 * Created by Bogdan on 8/20/2016.
 */
public class RegisterServlet extends HttpServlet {
    private UserStorage userStorage = UserStorage.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if (name.equals("") || login.equals("") || password.equals("")) {
            req.setAttribute("error", "Please fill all fields.");
            req.getRequestDispatcher("/WEB-INF/views/AuthForm.jsp").forward(req, resp);
        } else {
            User user = userStorage.add(new User(name, login, password));

            HttpSession session = req.getSession();
            synchronized (session) {
                session.setAttribute("user", user);
            }

            resp.sendRedirect(String.format("%s/addcar", req.getContextPath()));
        }
    }
}
