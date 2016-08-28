package andrusyak.storages;

import andrusyak.models.Car;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * TODO: comment.
 * Created by Bogdan on 8/28/2016.
 */
public class CarStorageTest {
    private final CarStorage carStorage = CarStorage.getInstance();

    @Test
    public void whenAddShouldSave() throws Exception {
        Car car = new Car();
        car.setBrand("Ford");

        car = this.carStorage.add(car);

        assertThat(car, is(this.carStorage.findById(car.getId()).get()));
    }

    @Test
    public void whenChangeStatusSoldShouldChangeStatusForCar() throws Exception {
        Car car = new Car();
        car.setBrand("Ford");
        car.setSold(false);
        boolean expectedResult = true;

        car = this.carStorage.add(car);
        this.carStorage.changeStatusSold(car.getId(), expectedResult);

        assertThat(this.carStorage.findById(car.getId()).get().isSold(), is(expectedResult));
    }

    @Test
    public void whenGetAllShouldReturnAllObjects() throws Exception {
        Car car = new Car();
        car.setBrand("Ford");

        this.carStorage.add(car);

        assertTrue(this.carStorage.getAll().contains(car));
    }

    @Test
    public void whenFindByIdShouldReturnCorrectObject() throws Exception {
        Car car = new Car();
        car.setBrand("Ford");

        car = this.carStorage.add(car);
        Car actualCar = this.carStorage.findById(car.getId()).get();

        assertThat(car, is(actualCar));
    }
}