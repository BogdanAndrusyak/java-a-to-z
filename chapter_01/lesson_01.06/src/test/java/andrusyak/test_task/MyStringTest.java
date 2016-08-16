package andrusyak.test_task;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * TODO: comment.
 * Created by Bogdan on 8/13/2016.
 */
public class MyStringTest {
    @Test
    public void contains() throws Exception {
        String origin = "I'm cool programmer.";
        String subContains = "coo";
        String subNotContains = "coot";

        MyString myString = new MyString();

        assertThat(myString.contains(origin, subContains), is(true));
        assertThat(myString.contains(origin, subNotContains), is(false));
    }

}