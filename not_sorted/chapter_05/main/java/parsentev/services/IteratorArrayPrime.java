package parsentev.services;

import java.util.Iterator;

/**
 * TODO: comment.
 */
public class IteratorArrayPrime implements Iterator {
    private final int[] values;
    private int index = 0;

    public IteratorArrayPrime(final int[] values) {
        this.values = values;
    }

    public boolean hasNext() {
        boolean has = false;

        for (int i = index; i < values.length; i++) {
            if (!isComposite(values[i])) {
                has = true;
                break;
            }
        }

        return has;
    }

    public Object next() {
        int result = 0;
        boolean exist = false;

        do {
            if (!isComposite(values[index])) {
                result = values[index++];
                break;
            } else {
                index++;
            }
        } while(!exist);

        return result;
    }

    private boolean isComposite(int number) {
        boolean isComposite = false;

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                isComposite = true;
                break;
            }
        }

        return isComposite;
    }
}
