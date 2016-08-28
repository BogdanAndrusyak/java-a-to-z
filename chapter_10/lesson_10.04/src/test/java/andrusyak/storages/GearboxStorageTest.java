package andrusyak.storages;

import andrusyak.models.Car;
import andrusyak.models.Gearbox;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * TODO: comment.
 * Created by Bogdan on 8/28/2016.
 */
public class GearboxStorageTest {
    private final CarStorage carStorage = CarStorage.getInstance();
    private final GearboxStorage gearboxStorage = GearboxStorage.getInstance();

    @Test
    public void whenAddShouldSave() throws Exception {
        Gearbox gearbox = new Gearbox();
        gearbox.setName("test");

        gearbox = this.gearboxStorage.add(gearbox);

        assertThat(gearbox, is(this.gearboxStorage.findById(gearbox.getId()).get()));
    }

    @Test
    public void whenGetUnusedShouldReturnCorrectObjects() throws Exception {
        Gearbox usedGearbox = new Gearbox();
        usedGearbox.setName("used");
        Gearbox unusedGearbox = new Gearbox();
        unusedGearbox.setName("unused");
        Car car = new Car();
        car.setGearbox(usedGearbox);

        this.gearboxStorage.add(usedGearbox);
        this.gearboxStorage.add(unusedGearbox);
        this.carStorage.add(car);

        assertTrue(this.gearboxStorage.getUnused().contains(unusedGearbox));
        assertFalse(this.gearboxStorage.getUnused().contains(usedGearbox));
    }

    @Test
    public void whenFindByIdShouldReturnCorrectObject() throws Exception {
        Gearbox gearbox = new Gearbox();
        gearbox.setName("test");

        gearbox = this.gearboxStorage.add(gearbox);
        Gearbox actualResult = this.gearboxStorage.findById(gearbox.getId()).get();

        assertThat(actualResult, is(gearbox));
    }
}