package parsentev.containers;

import java.util.Iterator;

/**
 * TODO: comment.
 */
public class MyArrayList<E> implements SimpleContainer<E> {
    protected static final int DEFAULT_CAPACITY = 10;

    protected Object[] elementData;

    protected int size = 0;

    public MyArrayList() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }

    }

    public void set(int index, E element) {
        this.elementData[index] = element;
    }

    @Override
    public void add(E e) {
        elementData[size++] = e;
    }

    @Override
    public E get(int index) {
        return (E) elementData[index];
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private int cursor = 0;

            @Override
            public boolean hasNext() {
                return cursor != size;
            }

            @Override
            public E next() {
                return (E) elementData[cursor++];
            }
        };
    }
}
