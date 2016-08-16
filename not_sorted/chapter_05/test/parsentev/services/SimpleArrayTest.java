package parsentev.services;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * TODO: comment.
 */
public class SimpleArrayTest {

    @Test
    public void whenUpdateShouldReplaceOldValue() {
        SimpleArray<String> sa = new SimpleArray<>(4);

        sa.add("test1");
        sa.update("test2", 0);
        String result = sa.get(0);

        assertThat(result, is("test2"));
    }


    @Test
    public void whenDeleteShouldReplaceOldValueByNull() {
        SimpleArray<String> sa = new SimpleArray<>(4);

        sa.add("test1");
        sa.delete(0);
        String result = sa.get(0);

        assertNull(result);
    }
}