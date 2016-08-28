package andrusyak.storages;

import andrusyak.models.Car;
import andrusyak.models.Engine;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * TODO: comment.
 * Created by Bogdan on 8/28/2016.
 */
public class EngineStorageTest {
    private final CarStorage carStorage = CarStorage.getInstance();
    private final EngineStorage engineStorage = EngineStorage.getInstance();

    @Test
    public void whenAddShouldSave() throws Exception {
        Engine engine = new Engine();
        engine.setName("test");

        engine = this.engineStorage.add(engine);

        assertThat(engine, is(this.engineStorage.findById(engine.getId()).get()));
    }

    @Test
    public void whenGetUnusedShouldReturnCorrectObjects() throws Exception {
        Engine usedEngine = new Engine();
        usedEngine.setName("used");
        Engine unusedEngine = new Engine();
        unusedEngine.setName("unused");
        Car car = new Car();
        car.setEngine(usedEngine);

        this.engineStorage.add(usedEngine);
        this.engineStorage.add(unusedEngine);
        this.carStorage.add(car);

        assertTrue(this.engineStorage.getUnused().contains(unusedEngine));
        assertFalse(this.engineStorage.getUnused().contains(usedEngine));
    }

    @Test
    public void whenFindByIdShouldReturnCorrectObject() throws Exception {
        Engine engine = new Engine();
        engine.setName("test");

        engine = this.engineStorage.add(engine);
        Engine actualResult = this.engineStorage.findById(engine.getId()).get();

        assertThat(actualResult, is(engine));
    }
}