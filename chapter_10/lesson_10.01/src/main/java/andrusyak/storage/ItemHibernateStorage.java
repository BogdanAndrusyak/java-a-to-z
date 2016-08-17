package andrusyak.storage;

import andrusyak.models.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: comment.
 * Created by Bogdan on 8/16/2016.
 */
public class ItemHibernateStorage implements ItemStorage {
    private static final ItemHibernateStorage instance = new ItemHibernateStorage();
    private final SessionFactory factory = HibernateFactory.getFactory();

    private ItemHibernateStorage() {
    }

    public static ItemHibernateStorage getInstance() {
        return instance;
    }

    @Override
    public void addItem(Item item) {
        try(Session session = factory.openSession()) {
            session.beginTransaction(); // todo need every time do this?
            session.save(item);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<Item> getAllItems() {
        List<Item> result = new ArrayList<>();
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            result.addAll(session.createQuery("from Item").list());
            session.getTransaction().commit();
        }
        return result;
    }

    @Override
    public void updateItem(Item item) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(item);
            session.getTransaction().commit();
        }
    }

    @Override
    public void updateDoneOnly(Item item) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("update Item set done = :done where id = :id");
            query.setParameter("done", item.isDone());
            query.setParameter("id", item.getId());

            query.executeUpdate();

            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteItem(int id) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(new Item(id));
            session.getTransaction().commit();
        }
    }
}
