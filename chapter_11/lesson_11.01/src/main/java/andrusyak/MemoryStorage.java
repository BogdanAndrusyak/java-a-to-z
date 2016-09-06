package andrusyak;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bogdan on 9/5/16.
 */
@Component
public class MemoryStorage implements Storage {
    ArrayList<User> users = new ArrayList<>();;

    public MemoryStorage() {
    }

    @Override
    public void add(User user) {
        this.users.add(user);
    }

    @Override
    public List<User> getAll() {
        return this.users;
    }
}
