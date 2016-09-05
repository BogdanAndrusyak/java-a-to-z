package andrusyak;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by bogdan on 9/5/16.
 */
@Configuration
public class AppContext {
    @Bean
    MemoryStorage memoryStorage() {
        return new MemoryStorage();
    }

    @Bean
    UserStorage userStorage() {
        return new UserStorage(memoryStorage());
    }
}
