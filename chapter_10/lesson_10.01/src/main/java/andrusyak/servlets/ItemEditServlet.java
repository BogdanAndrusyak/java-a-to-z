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
public class ItemEditServlet extends HttpServlet {
    private ItemStorage itemStorage = ItemHibernateStorage.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        boolean done = req.getParameter("done").equals("true") ? true : false;

        itemStorage.updateDoneOnly(new Item(id, done));

//        resp.sendRedirect(String.format("%s/view", req.getContextPath()));
    }
}
