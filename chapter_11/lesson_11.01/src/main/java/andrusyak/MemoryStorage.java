package andrusyak;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by bogdan on 9/5/16.
 */
@Component
public class MemoryStorage implements Storage {
    ArrayList<User> users;

    public MemoryStorage() {
        this.users = new ArrayList<>();
    }

    @Override
    public void add(User user) {
        this.users.add(user);
    }
}
