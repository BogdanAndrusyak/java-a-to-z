package andrusyak.storages;

import andrusyak.models.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * TODO: comment.
 * Created by Bogdan on 8/20/2016.
 */
public class CarStorage {
    private static final CarStorage instance = new CarStorage();
    private SessionFactory factory = HibernateFactory.getFactory();

    private CarStorage(){
    }

    public static CarStorage getInstance() {
        return instance;
    }

    public Car add(Car car) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(car);
            session.getTransaction().commit();
        }
        return car;
    }

    public void changeStatusSold(int carId, boolean statusSold) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("update Car set sold = :sold where id = :id");
            query.setParameter("sold", statusSold);
            query.setParameter("id", carId);
            query.executeUpdate();
        }
    }

    public List<Car> getAll() {
        List<Car> result = new ArrayList<>();
        try(Session session = factory.openSession()) {
            result.addAll(session.createQuery("from Car").list());
        }
        return result;
    }

    public Optional<Car> findById(int id) {
        Optional<Car> result = Optional.empty();
        try(Session session = factory.openSession()) {
            Car car = session.get(Car.class, id);
            if (car != null) {
                result = Optional.of(car);
            }
        }
        return result;
    }

    public List<Car> findByName(String name) {
        List<Car> result = new ArrayList<>();
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("from Car where name = :name");
            query.setParameter("name", name);
            result.addAll(query.list());
        }
        return result;
    }
}
