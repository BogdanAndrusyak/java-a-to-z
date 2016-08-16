package andrusyak.lesson.decorator_example;

/**
 * TODO: comment.
 * Created by Bogdan on 8/15/2016.
 */
public class SimpleCar implements Car {
    @Override
    public int getPrice() {
        return 100000;
    }

    @Override
    public String getDescription() {
        return "Simple car";
    }
}
