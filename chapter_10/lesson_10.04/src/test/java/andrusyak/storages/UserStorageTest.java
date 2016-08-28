package andrusyak.storages;

import andrusyak.models.User;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * TODO: comment.
 * Created by Bogdan on 8/28/2016.
 */
public class UserStorageTest {
    private final UserStorage userStorage = UserStorage.getInstance();

    @Test
    public void whenAddShouldSave() throws Exception {
        User user = new User();
        user.setName("test");

        user = this.userStorage.add(user);

        assertThat(user, is(this.userStorage.findById(user.getId()).get()));
    }

    @Test
    public void whenGetAllShouldReturnAllObjects() throws Exception {
        User user = new User();
        user.setName("test");

        user = this.userStorage.add(user);

        assertTrue(this.userStorage.getAll().contains(user));
    }

    @Test
    public void whenFindByIdShouldReturnCorrectObject() throws Exception {
        User user = new User();
        user.setName("test");

        user = this.userStorage.add(user);
        User actualUser = this.userStorage.findById(user.getId()).get();

        assertThat(user, is(actualUser));
    }

    @Test
    public void whenFindByCredentialShouldReturnCorrectObject() throws Exception {
        User user = new User();
        user.setLogin("root");
        user.setPassword("test");

        user = this.userStorage.add(user);
        User result = this.userStorage.findByCredential(user.getLogin(), user.getPassword()).get();

        assertThat(user, is(result));
    }

}