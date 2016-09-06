package andrusyak;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by bogdan on 9/6/16.
 */
public class ImportUser {
    private static final Input input = new Input();

    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml")) {
            UserStorage storage = (UserStorage) context.getBean("jdbcUserStorage");
            System.out.println("Add new User");
            storage.add(new User(input.ask("Enter name: ")));
        }
    }
}
