package andrusyak.servlets;

import andrusyak.storages.CarStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * TODO: comment.
 * Created by Bogdan on 8/20/2016.
 */
public class CarViewServlet extends HttpServlet{
    private final CarStorage carStorage = CarStorage.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("cars", carStorage.getAll());
        req.getRequestDispatcher("/WEB-INF/views/CarView.jsp").forward(req, resp);
    }
}
