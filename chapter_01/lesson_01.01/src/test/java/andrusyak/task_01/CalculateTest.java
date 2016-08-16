package andrusyak.task_01;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CalculateTest {
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
    public void whenRunClassMethodMainShouldDisplayMessageInConsole() throws Exception {
        String expectedResult = "Hello world!\r\n";
        Calculate calculate = new Calculate();
        String[] testArray = {"test"};

        calculate.main(testArray);

        String result = outContent.toString();
        assertThat(result, is(expectedResult));
    }
}