package andrusyak.storages;

import andrusyak.models.QueryCarFilter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: comment.
 * Created by Bogdan on 8/26/2016.
 */
public class QueryCarFilterStorage {
    private final static QueryCarFilterStorage instance = new QueryCarFilterStorage();
    private SessionFactory factory = HibernateFactory.getFactory();

    private QueryCarFilterStorage() {
    }

    public static QueryCarFilterStorage getInstance() {
        return instance;
    }

    public QueryCarFilter add(QueryCarFilter query) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(query);
            session.getTransaction().commit();
        }
        return query;
    }

    public List<QueryCarFilter> getAll() {
        List<QueryCarFilter> result = new ArrayList<>();
        try(Session session = factory.openSession()) {
            result.addAll(session.createQuery("from QueryCarFilter").list());
        }
        return result;
    }

    public List<QueryCarFilter> findByUserId(int userId) {
        List<QueryCarFilter> result =  new ArrayList<>();
        try(Session session = factory.openSession()) {
            Query query = session.createQuery("from QueryCarFilter as q where q.user.id = :id");
            query.setParameter("id", userId);
            result.addAll(query.list());
        }
        return result;
    }
}
