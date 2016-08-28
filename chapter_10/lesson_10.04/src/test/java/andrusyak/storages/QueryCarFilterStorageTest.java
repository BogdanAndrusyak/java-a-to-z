package andrusyak.storages;

import andrusyak.models.QueryCarFilter;
import andrusyak.models.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * TODO: comment.
 * Created by Bogdan on 8/28/2016.
 */
public class QueryCarFilterStorageTest {
    private final UserStorage userStorage = UserStorage.getInstance();
    private final QueryCarFilterStorage queryStorage = QueryCarFilterStorage.getInstance();

    @Test
    public void whenAddShouldSave() throws Exception {
        QueryCarFilter query = new QueryCarFilter();
        query.setBrand("test");

        query = this.queryStorage.add(query);

        assertThat(query, is(this.queryStorage.findById(query.getId()).get()));
    }

    @Test
    public void whenGetAllShouldReturnAllObjects() throws Exception {
        QueryCarFilter query = new QueryCarFilter();
        query.setBrand("test");

        query = this.queryStorage.add(query);

        assertTrue(this.queryStorage.getAll().contains(query));
    }

    @Test
    public void whenFindByIdShouldReturnCorrectObject() throws Exception {
        QueryCarFilter query = new QueryCarFilter();
        query.setBrand("test");

        query = this.queryStorage.add(query);
        QueryCarFilter actualResult = this.queryStorage.findById(query.getId()).get();

        assertThat(query, is(actualResult));
    }

    @Test
    public void whenFindByUserIdShouldReturnCorrectObject() throws Exception {
        User user = new User();
        user.setName("root");
        QueryCarFilter query = new QueryCarFilter();
        query.setBrand("test");
        query.setUser(user);

        user = this.userStorage.add(user);
        query = this.queryStorage.add(query);

        List<QueryCarFilter> actualResult = this.queryStorage.findByUserId(user.getId());

        assertTrue(actualResult.contains(query));
    }

}