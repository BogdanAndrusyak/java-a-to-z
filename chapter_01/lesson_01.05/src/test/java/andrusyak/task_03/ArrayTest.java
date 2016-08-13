package andrusyak.task_03;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * TODO: comment.
 * Created by Bogdan on 8/13/2016.
 */
public class ArrayTest {
    @Test
    public void whenRunMethodRemoveDuplicatesShouldRemoveDuplicates() throws Exception {
        String[] values = {"First", "First", "Second", "Third", "Second"};
        String[] expectedResult = {"First", "Second", "Third", "", ""};

        Array array = new Array(values);

        array.removeDuplicates();

        String[] result = array.values;
        assertThat(result, is(expectedResult));
    }

}