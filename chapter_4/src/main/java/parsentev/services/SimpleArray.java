package parsentev.services;

/**
 * TODO: comment.
 */
public class SimpleArray<T> extends SimpleList<T> {

    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    public void update(T newValue, int position) {
        this.objects[position] = newValue;
    }

    public void delete(int position) {
        this.objects[position] = null;
    }

    public Object[] getAll() {
        return this.objects;
    }
}
