package andrusyak.task_02;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * TODO: comment.
 * Created by Bogdan on 8/13/2016.
 */
public class NumberTest {
    @Test
    public void calculateFactorial() throws Exception {
        Number number = new Number(5);
        int expectedResult = 120;

        int result = number.calculateFactorial();

        assertThat(result, is(expectedResult));
    }

}