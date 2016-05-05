package parsentev.store;

import parsentev.services.SimpleArray;

/**
 * TODO: comment.
 */
public class UserStore<T extends Base> implements Store<T> {
    private final SimpleArray<T> Store = new SimpleArray<>(10);

    @Override
    public void add(T value) {
        Store.add(value);
    }

    @Override
    public void update(T newValue) {
        for (int index = 0; index != Store.getAll().length; index++) {
            if(newValue.getId() == Store.get(index).getId()) {
                Store.update(newValue, index);
            }
        }
    }

    @Override
    public void delete(String id) {
        for (int index = 0; index != Store.getAll().length; index++) {
            if(id.equals(Store.get(index).getId())) {
                Store.delete(index);
            }
        }
    }

    @Override
    public T get(String id) {
        T result = null;
        for (int index = 0; index != Store.getAll().length; index++) {
            if(id.equals(Store.get(index).getId())) {
                result = Store.get(index);
            }
        }
        return result;
    }


}
