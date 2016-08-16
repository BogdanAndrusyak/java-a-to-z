package andrusyak.lesson.decorator_example;

/**
 * TODO: comment.
 * Created by Bogdan on 8/15/2016.
 */
public abstract class CarDecorator implements Car {
    protected final Car car;

    public CarDecorator(Car car) {
        this.car  = car;
    }

    @Override
    public int getPrice() {
        return this.car.getPrice();
    }

    @Override
    public String getDescription() {
        return this.car.getDescription();
    }
}
