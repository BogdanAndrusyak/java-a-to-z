package andrusyak.task_01;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * TODO: comment.
 * Created by Bogdan on 8/13/2016.
 */
public class TriangleTest {
    @Test
    public void whenRunMethodCalculateAreaShouldReturnArea() throws Exception {
        Point first = new Point(1, 3);
        Point second = new Point(1, 2);
        Point third = new Point(4, 7);

        double expectedResult = 1.5;

        Triangle triangle = new Triangle(first, second, third);
        double result = triangle.calculateArea();

        assertThat(result, is(expectedResult));
    }

}