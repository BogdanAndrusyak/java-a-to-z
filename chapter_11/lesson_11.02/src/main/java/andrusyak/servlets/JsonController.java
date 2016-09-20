package andrusyak.servlets;

import com.google.common.base.Joiner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * TODO: comment.
 * Created by Bogdan on 8/21/2016.
 */
public class JsonController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());


        writer.append("{");
        writer.append(Joiner.on(", ").join(getYears(), getTypesBody(), getEngines(), getTransmissions(), getGearboxes()));
        writer.append("}");

        writer.flush();
    }

    private String getYears() {
        List<String> yearsResult = new ArrayList<>();

        for(Integer year : IntStream.range(1960, 2017).toArray()) {
            yearsResult.add(String.format("\"%s\"", year));
        }

        String result = "\"years\":[" +
                Joiner.on(", ").join(yearsResult) +
                "]";

        return result;
    }

    private String getTypesBody() {
        String result = "\"types\":[" +
                Joiner.on(", ").join("\"Coupe\"", "\"Hatchback\"", "\"Sedan\"", "\"Minivan\"", "\"SUV\"", "\"Truck\"",
                        "\"Wagon\"", "\"Convertible\"") +
                "]";

        return result;
    }

    private String getEngines() {
        String result = "\"engines\":[" +
                Joiner.on(", ").join("\"Petrol\"", "\"Diesel\"", "\"Hybrid\"", "\"Electro\"", "\"Gas\"") +
                "]";
        return result;
    }

    private String getTransmissions() {
        String result = "\"transmissions\":[" +
                Joiner.on(", ").join("\"Manual\"", "\"Automatic\"") +
                "]";
        return result;
    }

    private String getGearboxes() {
        String result = "\"gearboxes\":[" +
                Joiner.on(", ").join("\"Bevel\"", "\"Helical\"", "\"Spur\"", "\"Worm\"", "\"Planetary\"") +
                "]";
        return result;
    }
}
