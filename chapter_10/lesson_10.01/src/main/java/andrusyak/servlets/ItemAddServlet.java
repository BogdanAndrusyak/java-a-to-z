package andrusyak.servlets;

import andrusyak.models.Item;
import andrusyak.storage.ItemHibernateStorage;
import andrusyak.storage.ItemStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * TODO: comment.
 * Created by Bogdan on 8/16/2016.
 */
public class ItemAddServlet extends HttpServlet {
    private ItemStorage itemStorage = ItemHibernateStorage.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String desc = req.getParameter("desc");
        if(!desc.equals("")) {
            itemStorage.addItem(new Item(desc));
        }
        resp.sendRedirect(String.format("%s/view", req.getContextPath()));
    }
}
