package andrusyak.models;

/**
 * TODO: comment.
 * Created by Bogdan on 8/18/2016.
 */
public class Car {
    private int id;
    private String name;

    private Engine engine;
    private Transmission transmission;
    private Gearbox gearbox;

    private CarSalesPlatform platform;

    public Car() {
    }

    // Each machine must on sale - not good realization, I think, - but not for shop:)
    public Car(String name, Engine engine, Transmission transmission, Gearbox gearbox, CarSalesPlatform platform) {
        this.name = name;
        this.engine = engine;
        this.transmission = transmission;
        this.gearbox = gearbox;
        this.platform = platform;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public Gearbox getGearbox() {
        return gearbox;
    }

    public void setGearbox(Gearbox gearbox) {
        this.gearbox = gearbox;
    }

    public CarSalesPlatform getPlatform() {
        return platform;
    }

    public void setPlatform(CarSalesPlatform platform) {
        this.platform = platform;
    }
}
