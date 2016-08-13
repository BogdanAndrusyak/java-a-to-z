package parsentev.store;

/**
 * TODO: comment.
 */
public interface Store<T extends Base> {

    void add(T value);

    void update(T newValue);

    void delete(String id);

    T get(String id);
}
