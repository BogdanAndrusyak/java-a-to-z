package andrusyak.controllers;

import andrusyak.models.*;
import andrusyak.storages.CarStorage;
import andrusyak.storages.EngineStorage;
import andrusyak.storages.GearboxStorage;
import andrusyak.storages.TransmissionStorage;
import org.apache.commons.fileupload.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Locale;

/**
 * Created by bogdan on 9/13/16.
 */
@Controller
@RequestMapping(value = "/car")
public class CarController {
    private final CarStorage carStorage;
    private final EngineStorage engineStorage;
    private final TransmissionStorage transmissionStorage;
    private final GearboxStorage gearboxStorage;

    @Autowired
    public CarController(CarStorage carStorage, EngineStorage engineStorage, TransmissionStorage transmissionStorage, GearboxStorage gearboxStorage) {
        this.carStorage = carStorage;
        this.engineStorage = engineStorage;
        this.transmissionStorage = transmissionStorage;
        this.gearboxStorage = gearboxStorage;
    }

    @RequestMapping(value = "/viewall", method = RequestMethod.GET)
    public String viewAll(ModelMap modelMap) {
        modelMap.addAttribute("cars", carStorage.getAll());
        return "CarView";
    }

    @RequestMapping(value = "/viewadd", method = RequestMethod.GET)
    public String viewAdd(ModelMap modelMap) {

        CarAddForm carAddForm = new CarAddForm();

        modelMap.addAttribute("carAddForm", carAddForm);
        return "CarAdd";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@Valid CarAddForm carAddForm,
                      @RequestParam("image") MultipartFile image) {

        User user = carAddForm.getUser();
        Engine engine = carAddForm.getEngine();
        Transmission transmission = carAddForm.getTransmission();
        Gearbox gearbox = carAddForm.getGearbox();
        Car car = carAddForm.getCar();

        this.engineStorage.add(engine);
        this.transmissionStorage.add(transmission);
        this.gearboxStorage.add(gearbox);

        // not good realization, but only for example
        car.setEngine(engine);
        car.setTransmission(transmission);
        car.setGearbox(gearbox);
        car.setOwner(user);

        try {
            car.setPhoto(image.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.carStorage.add(car);
        return "redirect:/car/viewall.do";
    }

    @RequestMapping(value = "changestatus", method = RequestMethod.POST)
    public String changeStatus(@RequestAttribute("car-id") int carId, @RequestAttribute("sold") boolean sold) {
        this.carStorage.changeStatusSold(carId, sold);
        return "redirect:/car/viewall.do";
    }
}
