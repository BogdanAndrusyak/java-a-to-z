package parsentev.containers;

/**
 * TODO: comment.
 */
public class MyQueue<E> extends MyLinkedList<E> {

    public void push(E item) {
        add(item);
    }

    public E poll() {
        if (size == 0)
            return null;
        Node<E> f = first;
        first = f.next;
        size--;

        return f.item;
    }
}
