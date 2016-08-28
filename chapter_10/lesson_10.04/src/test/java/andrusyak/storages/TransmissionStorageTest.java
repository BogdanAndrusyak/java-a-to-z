package andrusyak.storages;

import andrusyak.models.Car;
import andrusyak.models.Transmission;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * TODO: comment.
 * Created by Bogdan on 8/28/2016.
 */
public class TransmissionStorageTest {
    private final CarStorage carStorage = CarStorage.getInstance();
    private final TransmissionStorage transmissionStorage = TransmissionStorage.getInstance();

    @Test
    public void whenAddShouldSave() throws Exception {
        Transmission transmission = new Transmission();
        transmission.setName("test");

        transmission = this.transmissionStorage.add(transmission);

        assertThat(transmission, is(this.transmissionStorage.findById(transmission.getId()).get()));
    }

    @Test
    public void whenGetUnusedShouldReturnCorrectObjects() throws Exception {
        Transmission usedTransmission = new Transmission();
        usedTransmission.setName("used");
        Transmission unusedTransmission = new Transmission();
        unusedTransmission.setName("unused");
        Car car = new Car();
        car.setTransmission(usedTransmission);

        this.transmissionStorage.add(usedTransmission);
        this.transmissionStorage.add(unusedTransmission);
        this.carStorage.add(car);

        assertTrue(this.transmissionStorage.getUnused().contains(unusedTransmission));
        assertFalse(this.transmissionStorage.getUnused().contains(usedTransmission));
    }

    @Test
    public void whenFindByIdShouldReturnCorrectObject() throws Exception {
        Transmission transmission = new Transmission();
        transmission.setName("test");

        transmission = this.transmissionStorage.add(transmission);
        Transmission actualResult = this.transmissionStorage.findById(transmission.getId()).get();

        assertThat(actualResult, is(transmission));
    }
}