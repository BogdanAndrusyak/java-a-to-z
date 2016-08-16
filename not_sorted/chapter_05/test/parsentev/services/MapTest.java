package parsentev.services;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * TODO: comment.
 */
public class MapTest {

    public static final class User {
        public String name;

        public User(String name) {
            this.name = name;
        }

        @Override
        public int hashCode() {
            return name != null ? name.hashCode() : 0;
        }

        /*@Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            User user = (User) o;

            return name != null ? name.equals(user.name) : user.name == null;
        }*/
    }

    @Test
    public void map() {
        User first = new User("Petr");
        User second = new User("Petr");

        Set<User> set = new HashSet<>();
        set.add(first);
        set.add(second);
        System.out.println(set.size());

        for (User user : set) {
            System.out.println(user);
        }
        //assertThat(first, is(second));
    }
}
