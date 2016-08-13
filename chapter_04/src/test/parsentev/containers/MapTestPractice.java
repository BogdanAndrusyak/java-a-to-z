package parsentev.containers;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO: comment.
 * Когда добавляются два одинаковых объекта в качестве ключа в карту и если:
 * 1) Ни hashcode ни equals не переопределены - добавятся оба в карту
 * 2) Переопределен только hashcode - также добавятся оба
 * 3) Переопределены и hashcode и equals - сначала добавится один(первый), а другой заменит его
 *
 * все заключается в реализации метода put в карте, что-то вроде этого:
 *  // если ключ уже существует, то-есть его hashcode функция и equals совпадают то выполнится замена
 *  if (e.hash == hash && (e.key == key || key.equals(e.key))) {
 *      V oldValue = e.value;
 *      e.value = value;
 *      return oldValue;
 *  }
 *
 *  //иначе добавить елемент в качестве нового
 *
 *  ------------------------------------------
 *  Как вычисляется hash функция в HashMap java 8
 *
 *  static final int hash(Object key) {
 *      int h;
 *      return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
 *  }
 *  ------------------------------------------
 */
public class MapTestPractice {

    private class User {
        private final String name;
        private int children;
        private final Calendar birthday;

        public User(final String name, int children, final Calendar birthday) {
            this.name = name;
            this.children = children;
            this.birthday = birthday;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            User user = (User) o;

            if (children != user.children) return false;
            if (name != null ? !name.equals(user.name) : user.name != null) return false;
            return birthday != null ? birthday.equals(user.birthday) : user.birthday == null;

        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + children;
            result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
            return result;
        }
    }

    @Test
    public void whenAddTwoSimilarObjects() {
        Map<User, Object> map = new HashMap<>();

        map.put(new User("Petr", 2, new GregorianCalendar(1996, 12, 4)), "first");
        map.put(new User("Petr", 2, new GregorianCalendar(1996, 12, 4)), "first");

        System.out.println(map);
    }
}
