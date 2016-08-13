package andrusyak;

import org.springframework.stereotype.Component;

/**
 * TODO: comment.
 * Created by Bogdan on 8/13/2016.
 */
@Component
public class MemoryStorage implements Storage {
    @Override
    public void add(User user) {
        System.out.println("store to memory");
    }
}
