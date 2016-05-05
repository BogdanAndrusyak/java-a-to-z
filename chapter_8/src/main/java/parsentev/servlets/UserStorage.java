package parsentev.servlets;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * TODO: comment.
 * Created by Bogdan on 4/23/2016.
 */
public class UserStorage {
    private static final UserStorage  instance = new UserStorage();
    private List<User> users = new CopyOnWriteArrayList<>();

    private UserStorage() {
    }

    public static UserStorage getInstance() {
        return instance;
    }

    public void add(User user) {
        this.users.add(user);
    }

    public List<User> getUsers() {
        return this.users;
    }
}
