package parsentev.containers;

import java.util.Iterator;

/**
 * TODO: comment.
 */
public class SimpleSetOnLinkedList<E> {
    private MyLinkedList<E> list;

    public SimpleSetOnLinkedList() {
        this.list = new MyLinkedList<>();
    }

    public void add(E e) {
        boolean added = false;

        for (int index = 0; index < list.size; index++) {
            E elementFromList = list.get(index);
            if (e.hashCode() == elementFromList.hashCode() && (e == elementFromList || e.equals(elementFromList))) {
                list.set(index, e);
                added = true;
            }
        }

        if (!added) {
            list.add(e);
        }
    }

    public Iterator<E> iterator() {
        return list.iterator();
    }
}
