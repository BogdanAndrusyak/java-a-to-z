package andrusyak.servlets;

import andrusyak.models.User;
import andrusyak.storages.UserStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

/**
 * TODO: comment.
 * Created by Bogdan on 8/20/2016.
 */
public class LoginServlet extends HttpServlet {
    private UserStorage userStorage = UserStorage.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if (login.equals("") || password.equals("")) {
            req.setAttribute("error", "Credential invalid");
            req.getRequestDispatcher("/WEB-INF/views/AuthForm.jsp").forward(req, resp);
        } else {
            Optional<User> result = this.userStorage.findByCredential(login, password);
            if(result.isPresent()) {
                User user = result.get();
                HttpSession session = req.getSession();
                synchronized (session) {
                    session.setAttribute("user", user);
                }
                resp.sendRedirect(String.format("%s/addcar", req.getContextPath()));
            } else {
                req.setAttribute("error", "Credential invalid");
                req.getRequestDispatcher("/WEB-INF/views/AuthForm.jsp").forward(req, resp);
            }
        }
    }
}
