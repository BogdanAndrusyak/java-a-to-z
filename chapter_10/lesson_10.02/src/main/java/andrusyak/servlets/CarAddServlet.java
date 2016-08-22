package andrusyak.servlets;

import andrusyak.models.*;
import andrusyak.models.File;
import andrusyak.storages.*;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO: comment.
 * Created by Bogdan on 8/20/2016.
 */
public class CarAddServlet extends HttpServlet {
    private UserStorage userStorage = UserStorage.getInstance();
    private CarStorage carStorage = CarStorage.getInstance();
    private EngineStorage engineStorage = EngineStorage.getInstance();
    private TransmissionStorage transmissionStorage = TransmissionStorage.getInstance();
    private GearboxStorage gearboxStorage = GearboxStorage.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/CarAdd.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, String> parameters = new HashMap<>();
        Map<String, File> files = new HashMap<>();

        try {
            List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(req);
            for (FileItem item : items) {
                if (item.isFormField()) {
                    // Process regular form field (input type="text|radio|checkbox|etc", select, etc).
                    String fieldName = item.getFieldName();
                    String fieldValue = item.getString();
                    // ... (do your job here)
                    parameters.put(fieldName, fieldValue);
                } else {
                    // Process form file field (input type="file").
                    String fieldName = item.getFieldName();
                    String fileName = FilenameUtils.getName(item.getName());
                    InputStream fileContent = item.getInputStream();
                    // ... (do your job here)
                    files.put(fieldName, new File(fileName, IOUtils.toByteArray(fileContent)));
                }
            }
        } catch (FileUploadException e) {
            throw new ServletException("Cannot parse multipart request.", e);
        }

        int ownerId = Integer.valueOf(parameters.get("owner-id"));
        String brand = parameters.get("brand");
        String model = parameters.get("model");
        int year = Integer.valueOf(parameters.get("year"));
        String typeBody = parameters.get("type-body");
        String engine = parameters.get("engine");
        String transmission = parameters.get("transmission");
        String gearbox = parameters.get("gearbox");
        String description = parameters.get("description");
        int price = Integer.valueOf(parameters.get("price"));
        boolean sold = false; // todo always false
        byte[] photo = files.get("photo").getContent();

        Engine engineDb = engineStorage.add(new Engine(engine));
        Transmission transmissionDb = transmissionStorage.add(new Transmission(transmission));
        Gearbox gearboxDb = gearboxStorage.add(new Gearbox(gearbox));

        carStorage.add(new Car(description, year, photo, sold, price, brand, model, typeBody, engineDb,
                transmissionDb, gearboxDb, new User(ownerId)));

        resp.sendRedirect(String.format("%s/view", req.getContextPath()));
    }
}
