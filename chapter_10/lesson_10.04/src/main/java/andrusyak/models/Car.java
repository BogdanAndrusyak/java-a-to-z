package andrusyak.models;

import java.io.File;
import org.apache.commons.codec.binary.Base64;

/**
 * TODO: comment.
 * Created by Bogdan on 8/18/2016.
 */
public class Car {
    private int id;
    private String desc;
    private int year;
    private byte[] photo;
    private boolean sold;
    private int price;
    private String brand;
    private String model;
    private String typeBody;
    private Engine engine;
    private Transmission transmission;
    private Gearbox gearbox;
    private User owner;

    public Car() {
    }

    // for create
    public Car(String desc, int year, byte[] photo, boolean sold, int price, String brand, String model,
               String typeBody, Engine engine, Transmission transmission, Gearbox gearbox, User owner) {
        this.desc = desc;
        this.year = year;
        this.photo = photo;
        this.sold = sold;
        this.price = price;
        this.brand = brand;
        this.model = model;
        this.typeBody = typeBody;
        this.engine = engine;
        this.transmission = transmission;
        this.gearbox = gearbox;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTypeBody() {
        return typeBody;
    }

    public void setTypeBody(String typeBody) {
        this.typeBody = typeBody;
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

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getByteArrayString() {
        return new String(new Base64().encode(this.photo));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        return id == car.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
