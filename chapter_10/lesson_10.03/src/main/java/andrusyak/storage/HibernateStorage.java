package andrusyak.storage;

import andrusyak.models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * TODO: comment.
 * Created by Bogdan on 8/18/2016.
 */
public class HibernateStorage implements Storage {
    private static final HibernateStorage instance = new HibernateStorage();
    private final SessionFactory factory = HibernateFactory.getFactory();

    private HibernateStorage() {
    }

    public static HibernateStorage getInstance() {
        return instance;
    }

    @Override
    public void addCarSalesPlatform(CarSalesPlatform platform) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(platform);
            session.getTransaction().commit();
        }
    }

    @Override
    public void addEngine(Engine engine) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(engine);
            session.getTransaction().commit();
        }
    }

    @Override
    public void addGearbox(Gearbox gearbox) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(gearbox);
            session.getTransaction().commit();
        }
    }

    @Override
    public void addTransmission(Transmission transmission) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(transmission);
            session.getTransaction().commit();
        }
    }

    @Override
    public void addCar(Car car) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(car);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Car> getAllCars() {
        List<Car> result = new ArrayList<>();
        try(Session session = factory.openSession()) {
            result.addAll(session.createQuery("from Car").list());
        }
        return result;
    }

    @Override
    public Optional<Car> findCarById(int id) {
        Optional<Car> result = Optional.empty();
        try(Session session = factory.openSession()) {
            Car car = session.get(Car.class, id);
            if (car != null) {
                result = Optional.of(car);
            }
        }
        return result;
    }

    @Override
    public List<Car> findCarsByName(String name) {
        List<Car> result = new ArrayList<>();
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("from Car where name = :name");
            query.setParameter("name", name);
            result.addAll(query.list());
        }
        return result;
    }

    @Override
    public List<Car> findCarsBySalesPlatformId(int id) {
        List<Car> result = new ArrayList<>();
        try(Session session = factory.openSession()) {
            Query query = session.createQuery(
                    "select car from Car car where car.platform.id = :id"
            );
            query.setParameter("id", id);
            result = query.list();
        }
        return result;
    }

    @Override
    public List<Engine> getUnusedEngines() {
        List<Engine> result = new ArrayList<>();
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            result.addAll(session.createQuery("select engine from Car car right join car.engine engine where car.engine is null").list());
        }
        return result;
    }

    @Override
    public List<Gearbox> getUnusedGearboxes() {
        List<Gearbox> result = new ArrayList<>();
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            result.addAll(session.createQuery("select gearbox from Car car right join car.gearbox gearbox where car.gearbox is null").list());
        }
        return result;
    }

    @Override
    public List<Transmission> getUnusedTransmissions() {
        List<Transmission> result = new ArrayList<>();
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            result.addAll(session.createQuery("select transmission from Car car right join car.transmission transmission where car.transmission is null").list());
        }
        return result;
    }


}
