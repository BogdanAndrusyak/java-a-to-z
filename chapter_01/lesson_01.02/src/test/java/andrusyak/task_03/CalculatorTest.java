package andrusyak.task_03;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CalculatorTest {
    @Test
    public void whenRunMethodAddShouldSaveInResultSum() throws Exception {
        double first = 2d;
        double second = 3d;
        double expectedResult = 5d;

        Calculator calculator = new Calculator();
        calculator.add(first, second);

        double result = calculator.getResult();
        assertThat(result, is(expectedResult));
    }

    @Test
    public void whenRunMethodSubtractShouldSaveInResultDifference() throws Exception {
        double first = 5d;
        double second = 3d;
        double expectedResult = 2d;

        Calculator calculator = new Calculator();
        calculator.subtract(first, second);

        double result = calculator.getResult();
        assertThat(result, is(expectedResult));
    }

    @Test(expected=IllegalArgumentException.class)
    public void whenRunMethodDivWithSecondArgZeroShouldThrowException() throws Exception {
        double first = 6d;
        double second = 0d;

        Calculator calculator = new Calculator();
        calculator.div(first, second);
    }

    @Test
    public void whenRunMethodDivShouldSaveInResultQuotient() throws Exception {
        double first = 6d;
        double second = 3d;
        double expectedResult = 2d;

        Calculator calculator = new Calculator();
        calculator.div(first, second);

        double result = calculator.getResult();
        assertThat(result, is(expectedResult));
    }

    @Test
    public void whenRunMethodMultipleShouldSaveInResultProduct() throws Exception {
        double first = 2d;
        double second = 3d;
        double expectedResult = 6d;

        Calculator calculator = new Calculator();
        calculator.multiple(first, second);

        double result = calculator.getResult();
        assertThat(result, is(expectedResult));
    }
}