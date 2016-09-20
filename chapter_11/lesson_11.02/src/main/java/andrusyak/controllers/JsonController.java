package andrusyak.controllers;

import com.google.common.base.Joiner;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by bogdan on 9/14/16.
 */
@Controller
public class JsonController {

    @RequestMapping(value = "/json", method = RequestMethod.GET)
    public @ResponseBody StringBuilder getJson() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("{");
        stringBuilder.append(Joiner.on(", ").join(getYears(), getTypesBody(), getEngines(), getTransmissions(), getGearboxes()));
        stringBuilder.append("}");

       return stringBuilder;
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
