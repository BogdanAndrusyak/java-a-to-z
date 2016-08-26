package andrusyak.storages;

import andrusyak.models.Transmission;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: comment.
 * Created by Bogdan on 8/20/2016.
 */
public class TransmissionStorage {
    private static final TransmissionStorage instance = new TransmissionStorage();
    private SessionFactory factory = HibernateFactory.getFactory();

    private TransmissionStorage(){
    }

    public static TransmissionStorage getInstance() {
        return instance;
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
}
