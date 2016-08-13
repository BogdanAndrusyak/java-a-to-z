package parsentev.containers;

import java.util.Iterator;

/**
 * TODO: comment.
 */
public class MyLinkedList<E> implements SimpleContainer<E> {
    protected int size = 0;

    protected Node<E> first;

    protected Node<E> last;

    public MyLinkedList() {
    }

    @Override
    public void add(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    public void set(int index, E element) {
        Node<E> x;

        if (index < (size >> 1)) {
            x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
        } else {
            x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
        }

        x.item = element;
    }

    @Override
    public E get(int index) {
        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x.item;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x.item;
        }
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
                return get(cursor++);
            }
        };
    }

    protected static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
