package andrusyak.storages;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * TODO: comment.
 * Created by Bogdan on 8/18/2016.
 */
public class HibernateFactory {
    private static final SessionFactory factory = new Configuration()
            .configure()
            .buildSessionFactory();

    private HibernateFactory() {
    }

    public static SessionFactory getFactory() {
        return factory;
    }
}
