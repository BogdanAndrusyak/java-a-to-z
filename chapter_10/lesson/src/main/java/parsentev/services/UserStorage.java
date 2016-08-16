package parsentev.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import parsentev.models.Item;
import parsentev.models.User;

import java.sql.Timestamp;

/**
 * TODO: comment.
 * Created by Bogdan on 6/7/2016.
 */
public class UserStorage {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure() //configures settings from hibernate.cfg.xml
                .buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();

        Item item = new Item();
        item.setDesc("testi");
        item.setAuthor(new User(13));
        item.setCreated(new Timestamp(System.currentTimeMillis()));

        session.save(item);

        session.getTransaction().commit();
        session.close();
        factory.close();
    }
}
