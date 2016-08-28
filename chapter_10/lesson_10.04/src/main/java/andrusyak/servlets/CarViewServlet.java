package andrusyak.servlets;

import andrusyak.models.User;
import andrusyak.storages.CarStorage;
import andrusyak.storages.QueryCarFilterStorage;

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
public class CarViewServlet extends HttpServlet{
    private final CarStorage carStorage = CarStorage.getInstance();
    private final QueryCarFilterStorage queryStorage = QueryCarFilterStorage.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        synchronized (session) {
            if (session.getAttribute("user") != null) { // if user auth
                User user = (User) session.getAttribute("user");
                req.setAttribute("queries", queryStorage.findByUserId(user.getId()));
            }
        }

        req.setAttribute("cars", carStorage.getAll());
        req.getRequestDispatcher("/WEB-INF/views/CarView.jsp").forward(req, resp);
    }
}
