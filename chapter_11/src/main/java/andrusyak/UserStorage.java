package andrusyak;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * TODO: comment.
 * Created by Bogdan on 8/13/2016.
 */
@Component
public class UserStorage {
    private final Storage storage;

    @Autowired
    public UserStorage(Storage storage) {
        this.storage = storage;
    }

    public void add(User user) {
        this.storage.add(user);
    }
}
