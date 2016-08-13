package andrusyak;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static junit.framework.TestCase.assertNotNull;

/**
 * TODO: comment.
 * Created by Bogdan on 8/13/2016.
 */
public class UserStorageTest {
    @Test
    public void whenAddUserToStorageShouldSafeIt() throws Exception {
        MemoryStorage memory = new MemoryStorage();
        UserStorage storage = new UserStorage(memory);
        storage.add(new User());
    }

    @Test
    public void whenLoadContextShouldGetBeans() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        UserStorage storage = context.getBean(UserStorage.class); // can use id or .class
        storage.add(new User());
        assertNotNull(storage);
    }
}