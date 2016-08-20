package andrusyak;

import andrusyak.models.*;
import andrusyak.storage.HibernateStorage;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * I understand that the test is rude, needed test more components, but is just an example.
 * If needed to write a complete test - I will do.
 * Created by Bogdan on 8/18/2016.
 */
public class LittleTest {
    @Test
    public void storageTest() {
        HibernateStorage storage = HibernateStorage.getInstance();

        CarSalesPlatform platform = new CarSalesPlatform("Shop");
        Engine engine = new Engine("PowerEngine");
        Gearbox gearbox = new Gearbox("Default GearBox");
        Transmission transmission = new Transmission("Default Transmission");

        String carName = "Renault12";
        Car car = new Car(carName, engine, transmission, gearbox, platform);

        // todo required tests for this code
        storage.addCarSalesPlatform(platform);
        storage.addEngine(engine);
        storage.addGearbox(gearbox);
        storage.addTransmission(transmission);

        // for this code - this current test
        storage.addCar(car);

        // check
        List<Car> resultList = storage.findCarsByName(carName);
        assertThat(resultList.isEmpty(), is(false));
    }
    @Test
    public void test() {

        HibernateStorage.getInstance().findCarsBySalesPlatformId(1);
    }
}
