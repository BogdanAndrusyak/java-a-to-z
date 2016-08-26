package andrusyak.servlets;

import andrusyak.models.Car;
import andrusyak.models.QueryCarFilter;
import andrusyak.models.User;
import andrusyak.storages.CarCriteria;
import andrusyak.storages.QueryCarFilterStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * TODO: comment.
 * Created by Bogdan on 8/25/2016.
 */
public class CarCustomFilter extends HttpServlet {
    private QueryCarFilterStorage queryStorage = QueryCarFilterStorage.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String typeBody = req.getParameter("type-body");
        String brand = req.getParameter("brand");
        String model = req.getParameter("model");

        String yearFromString = req.getParameter("yearFrom");
        String yearToString = req.getParameter("yearTo");

        String priceFromString = req.getParameter("priceFrom");
        String priceToString = req.getParameter("priceTo");

        HttpSession session = req.getSession();
        synchronized (session) {
            if (session.getAttribute("user") != null) { // if user auth
                User user = (User) session.getAttribute("user");
                doQuerySave(typeBody, brand, model, yearFromString,
                        yearToString, priceFromString, priceToString, user.getId());
                req.setAttribute("queries", queryStorage.findByUserId(user.getId()));
            }
        }

        req.setAttribute("cars", doCarCustomFilter(typeBody, brand, model, yearFromString, yearToString,
                priceFromString, priceToString));

        req.getRequestDispatcher("/WEB-INF/views/CarView.jsp").forward(req, resp);
    }

    private void doQuerySave(String typeBody, String brand, String model, String yearFrom, String yearTo,
                             String priceFrom, String priceTo, int userId) {
        queryStorage.add(new QueryCarFilter(typeBody, brand, model, yearFrom, yearTo, priceFrom, priceTo,
                new User(userId)));
    }

    private List<Car> doCarCustomFilter(String typeBody, String brand, String model, String yearFromString,
                                        String yearToString, String priceFromString, String priceToString) {

        int yearFrom = yearFromString.isEmpty() ? -1 : Integer.valueOf(yearFromString);
        int yearTo = yearToString.isEmpty() ? -1 : Integer.valueOf(yearToString);

        int priceFrom = priceFromString.isEmpty() ? -1 : Integer.valueOf(priceFromString);
        int priceTo = priceToString.isEmpty() ? -1 : Integer.valueOf(priceToString);

        CarCriteria criteria = new CarCriteria();

        if (!typeBody.isEmpty()) {
            criteria.typeBodyLike(typeBody);
        }

        if (!brand.isEmpty()) {
            criteria.brandLike(brand);
        }

        if (!model.isEmpty()) {
            criteria.modelLike(model);
        }

        if (yearFrom != -1) {
            criteria.yearFrom(yearFrom);
        }

        if (yearTo != -1) {
            criteria.yearTo(yearTo);
        }

        if (priceFrom != -1) {
            criteria.priceFrom(priceFrom);
        }

        if (priceTo != -1) {
            criteria.priceTo(priceTo);
        }

        return criteria.getResult();
    }
}
