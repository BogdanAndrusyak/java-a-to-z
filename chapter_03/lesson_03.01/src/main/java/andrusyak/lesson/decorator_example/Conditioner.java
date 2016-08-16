package andrusyak.lesson.decorator_example;

/**
 * TODO: comment.
 * Created by Bogdan on 8/15/2016.
 */
public class Conditioner extends CarDecorator {

    public Conditioner(Car car) {
        super(car);
    }

    @Override
    public int getPrice() {
        return car.getPrice() + 20000;
    }

    @Override
    public String getDescription() {
        return car.getDescription() + " added option conditioner";
    }
}
