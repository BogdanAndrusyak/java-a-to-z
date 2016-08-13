package parsentev.services;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;

/**
 * TODO: comment.
 */
public class IteratorArrayEvenTest {

    @Test
    public void whenGetNextCallShouldReturnEvenNumbers() {
        IteratorArrayEven iae = new IteratorArrayEven(new int[] {1, 2, 4});

        iae.next();
        int result = (Integer) iae.next();

        assertThat(result, is(4));
    }

    @Test
    public void whenCheckNextPositionShouldReturnContentValue() {
        IteratorArrayEven iae = new IteratorArrayEven(new int[] {1, 2});

        iae.next();
        boolean result = iae.hasNext();

        assertThat(result, is(false));
    }
}