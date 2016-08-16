package andrusyak.lesson.decorator_example;

/**
 * TODO: comment.
 * Created by Bogdan on 8/15/2016.
 */
public class WoodInterior extends CarDecorator {
    public WoodInterior(Car car) {
        super(car);
    }

    public int getPrice() {
        return car.getPrice() + 30000;
    }

    @Override
    public String getDescription() {
        return car.getDescription() + " added wood interior";
    }
}
