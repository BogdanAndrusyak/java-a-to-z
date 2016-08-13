package andrusyak.task_01;

import andrusyak.task_01.Array;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * TODO: comment.
 * Created by Bogdan on 8/13/2016.
 */
public class ArrayTest {
    @Test
    public void whenRunMethodBubbleSortShouldReplaceCurrentArrayBySorted() throws Exception {
        int[] values = {5, 3, 7, 9, 0, 2};
        int[] expectedResult = {0, 2, 3, 5, 7, 9};

        Array array = new Array(values);

        array.bubbleSort();

        int[] result =  array.values;
        assertThat(result, is(expectedResult));
    }

}