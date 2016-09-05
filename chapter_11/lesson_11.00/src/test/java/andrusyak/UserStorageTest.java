package andrusyak;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by bogdan on 9/5/16.
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
        UserStorage storage = context.getBean(UserStorage.class);
        storage.add(new User());
        assertNotNull(storage);
    }

    @Test
    public void configureContextOnlyWithJava() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppContext.class);
        UserStorage storage = context.getBean(UserStorage.class);
        storage.add(new User());
        assertNotNull(storage);
    }
}