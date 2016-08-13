package parsentev.services;

import java.util.Iterator;

/**
 * TODO: comment.
 */
public class IteratorArray implements Iterator {

    private final int[] values;
    private int index = 0;

    public IteratorArray(int[] values) {
        this.values = values;
    }

    public boolean hasNext() {
        return values.length > index;
    }

    public Object next() {
        return values[index++];
    }
}
