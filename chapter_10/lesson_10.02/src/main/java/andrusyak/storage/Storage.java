package andrusyak.storage;

import andrusyak.models.*;

import java.util.List;
import java.util.Optional;

/**
 * TODO: comment.
 * Created by Bogdan on 8/18/2016.
 */
public interface Storage {

    void addCarSalesPlatform(CarSalesPlatform platform);

    void addEngine(Engine engine);

    void addGearbox(Gearbox gearbox);

    void addTransmission(Transmission transmission);

    void addCar(Car car);

    List<Car> getAllCars();

    // can be more than one object with current name - List
    List<Car> findCarsByName(String name);

    List<Engine> getUnusedEngines();

    List<Gearbox> getUnusedGearboxes();

    List<Transmission> getUnusedTransmissions();
}
