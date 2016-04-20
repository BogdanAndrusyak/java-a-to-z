package parsentev.services;

import java.lang.reflect.ParameterizedType;

/**
 * TODO: comment.
 */
// abstract because type of instance can get only in header of subclass.
public abstract class SimpleList<T> {

    Object[] objects;
    int index = 0;

    public SimpleList(int size) {
        this.objects = new Object[size];
        Class<T> t =(Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

        try {
            T value = t.newInstance();
            System.out.printf("string " + value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected SimpleList() {
    }

    public <K> K print(K value) {
        System.out.println(value);
        return value;
    }

    public void add(T value) {
        this.objects[index++] = value;
    }

    public T get(int position) {
        return (T) this.objects[position];
    }
}
