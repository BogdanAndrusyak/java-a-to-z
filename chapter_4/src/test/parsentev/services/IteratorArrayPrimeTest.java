package parsentev.services;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;

/**
 * TODO: comment.
 */
public class IteratorArrayPrimeTest {

    @Test
    public void whenGetNextCallShouldReturnPrimeNumbers() {
        IteratorArrayPrime iap = new IteratorArrayPrime(new int[] {4, 5, 7});

        iap.next();
        int result = (Integer) iap.next();

        assertThat(result, is(7));
    }

    @Test
    public void whenCheckNextPositionShouldReturnContentValue() {
        IteratorArrayPrime iap = new IteratorArrayPrime(new int[] {5, 6});

        iap.next();
        boolean result = iap.hasNext();

        assertThat(result, is(false));
    }
}