package andrusyak.task_02;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * TODO: comment.
 * Created by Bogdan on 8/13/2016.
 */
public class ArrayTest {
    @Test
    public void whenRunMethodRotateArrayShouldReplaceCurrentArrayByRotated() throws Exception {
        int[][] values = {
                {3, 5, 6, 8},
                {7, 8, 0, 1},
                {5, 7, 3, 1},
                {5, 4, 2, 6}
        };

        int[][] expectedResult = {
                {8, 1, 1, 6},
                {6, 0, 3, 2},
                {5, 8, 7, 4},
                {3, 7, 5, 5}
        };

        Array array = new Array(values);

        array.rotateArray();

        int[][] result = array.values;
        assertThat(result, is(expectedResult));
    }

}