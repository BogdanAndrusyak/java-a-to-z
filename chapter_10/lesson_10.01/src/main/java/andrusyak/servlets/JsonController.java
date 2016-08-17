package andrusyak.servlets;

import andrusyak.models.Item;
import andrusyak.storage.ItemHibernateStorage;
import andrusyak.storage.ItemStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
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

        writer.append("{\"items\":[");
        for (int i = 0; i < items.size() - 1; i++) {
            writer.append("{" +
                        "\"id\":\"" + items.get(i).getId() + "\", " +
                        "\"desc\":\"" + items.get(i).getDesc() + "\", " +
                        "\"created\":\"" + items.get(i).getCreated() + "\", " +
                        "\"done\":\"" + items.get(i).isDone() + "\" " +
                    "}, ");
        }

        // for last element - feature, without coma
        int lastElement = items.size() - 1;
        writer.append("{" +
                "\"id\":\"" + items.get(lastElement).getId() + "\", " +
                "\"desc\":\"" + items.get(lastElement).getDesc() + "\", " +
                "\"created\":\"" + items.get(lastElement).getCreated() + "\", " +
                "\"done\":\"" + items.get(lastElement).isDone() + "\" " +
                "} ");

        writer.append("]}");

        writer.flush();
    }
}
