package parsentev.services;

import org.junit.Test;

import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * TODO: comment.
 */
public class TreeTest {

    public static final class User {
        public String name;

        public User(String name) {
            this.name = name;
        }
    }

    @Test
    public void add() {
        TreeSet<User> users = new TreeSet<>(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.name.compareTo(o2.name);
            }
        });

        users.add(new User("Petr"));
        users.add(new User("Arsentev"));

        TreeMap treeMap;

        for(User user : users) {
            System.out.println(user.name);
        }
    }
}
