package parsentev.containers;

/**
 * TODO: comment.
 */
public class MyStack<E> extends MyArrayList<E> {

    public void push(E item) {
        add(item);
    }

    public E pop() {
        E obj;
        if (size == 0) {
            obj = null;
        } else {
            obj = peek();
            elementData[size - 1] = null;
            size--;
        }

        return obj;
    }

    public E peek() {
        return (E) elementData[size - 1];
    }
}
