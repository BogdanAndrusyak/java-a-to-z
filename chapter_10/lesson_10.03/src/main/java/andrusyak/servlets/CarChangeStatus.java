package andrusyak.servlets;

import andrusyak.storages.CarStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * TODO: comment.
 * Created by Bogdan on 8/22/2016.
 */
public class CarChangeStatus extends HttpServlet {
    CarStorage carStorage = CarStorage.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int carId = Integer.valueOf(req.getParameter("car-id"));
        boolean statusSold = Boolean.valueOf(req.getParameter("sold"));

        carStorage.changeStatusSold(carId, statusSold);

        resp.sendRedirect(String.format("%s/view", req.getContextPath()));
    }
}
