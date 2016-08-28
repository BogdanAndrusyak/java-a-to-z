package andrusyak.storages;

import andrusyak.models.Engine;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * TODO: comment.
 * Created by Bogdan on 8/20/2016.
 */
public class EngineStorage {
    private static final EngineStorage instance = new EngineStorage();
    private SessionFactory factory = HibernateFactory.getFactory();

    private EngineStorage(){
    }

    public static EngineStorage getInstance() {
        return instance;
    }

    public Engine add(Engine engine) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(engine);
            session.getTransaction().commit();
        }
        return engine;
    }

    public List<Engine> getUnused() {
        List<Engine> result = new ArrayList<>();
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            result.addAll(session.createQuery("select engine from Car car right join car.engine engine where car.engine is null").list());
        }
        return result;
    }

    public Optional<Engine> findById(int id) {
        Optional<Engine> result = Optional.empty();
        try(Session session = factory.openSession()) {
            Engine engine = session.get(Engine.class, id);
            if (engine != null) {
                result = Optional.of(engine);
            }
        }
        return result;
    }
}
