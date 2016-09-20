package andrusyak.storages;

import andrusyak.models.Transmission;
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
public class TransmissionStorage {
    private SessionFactory factory = HibernateFactory.getFactory();

    public TransmissionStorage(){
    }

    public Transmission add(Transmission transmission) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(transmission);
            session.getTransaction().commit();
        }
        return transmission;
    }

    public List<Transmission> getUnused() {
        List<Transmission> result = new ArrayList<>();
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            result.addAll(session.createQuery("select transmission from Car car right join car.transmission transmission where car.transmission is null").list());
        }
        return result;
    }

    public Optional<Transmission> findById(int id) {
        Optional<Transmission> result = Optional.empty();
        try(Session session = factory.openSession()) {
            Transmission transmission = session.get(Transmission.class, id);
            if (transmission != null) {
                result = Optional.of(transmission);
            }
        }
        return result;
    }
}
