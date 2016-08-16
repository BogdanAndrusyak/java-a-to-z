package parsentev.services;

import java.util.Iterator;

/**
 * TODO: comment.
 */
public class IteratorArrayEven implements Iterator {

    private final int[] values;
    private int index = 0;

    public IteratorArrayEven(final int[] values) {
        this.values = values;
    }

    public boolean hasNext() {
        boolean has = false;

        for (int i = index; i < values.length; i++) {
            has = values[i] % 2 == 0 ? true : false;
            if(has) {
                break;
            }
        }

        return has;
    }

    public Object next() {
        int result = 0;
        boolean exist;

        // todo. unstable code..??
        do {
            if (exist = values[index] % 2 == 0) {
                result = values[index++];
                exist = true;
            } else {
                index++;
            }
        } while (!exist);

        return result;
    }
}
