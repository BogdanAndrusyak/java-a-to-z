package andrusyak;

import java.util.List;

/**
 * Created by bogdan on 9/5/16.
 */
public interface Storage {

    void add(User user);

    List<User> getAll();
}
