package andrusyak.models;

import java.util.List;

/**
 * TODO: comment.
 * Created by Bogdan on 8/18/2016.
 */

public class CarSalesPlatform {
    private int id;
    private String name;

    private List<Car> cars;

    public CarSalesPlatform() {
    }

    public CarSalesPlatform(int id) {
        this.id = id;
    }

    public CarSalesPlatform(String name) {
        this.name = name;
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

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
