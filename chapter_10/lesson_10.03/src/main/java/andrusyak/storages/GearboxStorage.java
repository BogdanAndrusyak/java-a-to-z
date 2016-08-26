package andrusyak.storages;

import andrusyak.models.Gearbox;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: comment.
 * Created by Bogdan on 8/20/2016.
 */
public class GearboxStorage {
    private static final GearboxStorage instance = new GearboxStorage();
    private SessionFactory factory = HibernateFactory.getFactory();

    private GearboxStorage(){
    }

    public static GearboxStorage getInstance() {
        return instance;
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
}
