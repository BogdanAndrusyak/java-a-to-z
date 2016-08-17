package andrusyak.servlets;

import andrusyak.models.Item;
import andrusyak.storage.ItemHibernateStorage;
import andrusyak.storage.ItemStorage;
import com.google.common.base.Joiner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO: comment.
 * Created by Bogdan on 8/16/2016.
 */
public class JsonController extends HttpServlet {
    private ItemStorage itemStorage = ItemHibernateStorage.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        List<Item> items = itemStorage.getAllItems();

        List values = new ArrayList();

        for (Item item : items) {
            values.add("{" +
                    "\"id\":\"" + item.getId() + "\", " +
                    "\"desc\":\"" + item.getDesc() + "\", " +
                    "\"created\":\"" + item.getCreated() + "\", " +
                    "\"done\":\"" + item.isDone() + "\" " +
                    "}");
        }

        writer.append("{\"items\":[");
        writer.append(Joiner.on(", ").join(values));
        writer.append("]}");

        writer.flush();
    }
}
