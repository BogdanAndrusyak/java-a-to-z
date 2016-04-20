package parsentev.containers;

import java.util.Iterator;

/**
 * TODO: comment.
 */
public class SimpleSetOnArrayList<E>{
    private MyArrayList<E> array;

    public SimpleSetOnArrayList() {
        this.array = new MyArrayList<>();
    }

    public void add(E e) {
        boolean added = false;

        for (int index = 0; index < array.size; index++ ) {
            E elementFromArray = array.get(index);

            if (e.hashCode() == elementFromArray.hashCode() && (e == elementFromArray || e.equals(elementFromArray))) {
                array.set(index, e);
                added = true;
            }
        }

        if (!added) {
            array.add(e);
        }

    }

    public Iterator<E> iterator() {
        return array.iterator();
    }
}
