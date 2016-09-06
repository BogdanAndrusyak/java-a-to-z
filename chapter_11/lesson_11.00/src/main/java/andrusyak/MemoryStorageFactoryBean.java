package andrusyak;

import org.springframework.beans.factory.FactoryBean;

/**
 * Created by bogdan on 9/6/16.
 */
public class MemoryStorageFactoryBean implements FactoryBean<MemoryStorage> {
    @Override
    public MemoryStorage getObject() throws Exception {
        return new MemoryStorage();
    }

    @Override
    public Class<?> getObjectType() {
        return MemoryStorage.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
