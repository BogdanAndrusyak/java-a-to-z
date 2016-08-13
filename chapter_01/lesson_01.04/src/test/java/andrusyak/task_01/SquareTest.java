package andrusyak.task_01;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * TODO: comment.
 * Created by Bogdan on 8/13/2016.
 */
public class SquareTest {
    // use to read from the console.
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }
    // end

    @Test
    public void whenRunMethodCalculateShouldReturnValueOfTheFunction() throws Exception {
        int a=1, b=1, c=2;
        int x = 1;
        float expectedResult = 4;

        Square square = new Square(a, b, c);
        float result = square.calculate(x);

        assertThat(result, is(expectedResult));
    }

    @Test
    public void whenRunMethodShowShouldDisplayTheFunctionValueInTheRange() throws Exception {
        int a=1, b=1, c=2;
        int start = 0, finish = 2, step = 1;
        String expectedResult = "2.0\r\n4.0\r\n8.0\r\n";

        Square square = new Square(a, b, c);
        square.show(start, finish, step);

        assertThat(outContent.toString(), is(expectedResult));
    }
}