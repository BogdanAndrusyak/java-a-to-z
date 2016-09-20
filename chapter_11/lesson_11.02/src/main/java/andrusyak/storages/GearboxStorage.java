package andrusyak.storages;

import andrusyak.models.Gearbox;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * TODO: comment.
 * Created by Bogdan on 8/20/2016.
 */
@Component
public class GearboxStorage {
    private SessionFactory factory = HibernateFactory.getFactory();

    public GearboxStorage(){
    }

    public Gearbox add(Gearbox gearbox) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(gearbox);
            session.getTransaction().commit();
        }
        return gearbox;
    }

    public List<Gearbox> getUnused() {
        List<Gearbox> result = new ArrayList<>();
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            result.addAll(session.createQuery("select gearbox from Car car right join car.gearbox gearbox where car.gearbox is null").list());
        }
        return result;
    }

    public Optional<Gearbox> findById(int id) {
        Optional<Gearbox> result = Optional.empty();
        try(Session session = factory.openSession()) {
            Gearbox gearbox = session.get(Gearbox.class, id);
            if (gearbox != null) {
                result = Optional.of(gearbox);
            }
        }
        return result;
    }
}
