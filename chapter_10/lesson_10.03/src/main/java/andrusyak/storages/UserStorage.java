package andrusyak.storages;

import andrusyak.models.User;
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
public class UserStorage {
    private static final UserStorage instance = new UserStorage();
    private static SessionFactory factory = HibernateFactory.getFactory();

    private UserStorage() {
    }

    public static UserStorage getInstance() {
        return instance;
    }

    public User add(User user) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        }
        return user;
    }

    public List<User> getAll() {
        List<User> result = new ArrayList<>();
        try(Session session = factory.openSession()) {
            result.addAll(session.createQuery("from User").list());
        }
        return result;
    }

    public Optional<User> findByCredential(String login, String password) {
        Optional<User> result = Optional.empty();
        try(Session session = factory.openSession()) {
            Query query = session.createQuery("from User where login = :login and password = :password");
            query.setParameter("login", login);
            query.setParameter("password", password);
            result = query.uniqueResultOptional();
        }
        return result;
    }
}
