package andrusyak.lesson.decorator_example;

/**
 * TODO: comment.
 * Created by Bogdan on 8/15/2016.
 */
public class Client {
    public static void main(String[] args) {
        Car car = new SimpleCar();
        System.out.println(car.getPrice());
        System.out.println(car.getDescription());

        Car carCond = new Conditioner(car);
        System.out.println(carCond.getPrice());
        System.out.println(carCond.getDescription());

        Car carMatreshka = new WoodInterior(new Conditioner(new SimpleCar()));
        System.out.println(carMatreshka.getPrice());
        System.out.println(carMatreshka.getDescription());
    }
}
