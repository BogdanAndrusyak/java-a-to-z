package andrusyak;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by bogdan on 9/6/16.
 */
public class UserStorageTest {
    @Test
    public void whenAddUserStorageShouldSafeIt() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        UserStorage storage = (UserStorage) context.getBean("memoryUserStorage");

        storage.add(new User());

        assertFalse(storage.getAll().isEmpty());
    }
}