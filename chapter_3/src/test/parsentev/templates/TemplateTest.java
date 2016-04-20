package parsentev.templates;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

/**
 * TODO: comment.
 */
public class TemplateTest {
    @Test
    public void whenTakeTextWithDataShouldReplaceParamsToData() {
        // assign
        Template template = new SimpleGenerator();
        String text = "Hello, ${name}.";
        String[] data = new String[] {"Petr"};
        String[] checked = {"Hello, Petr."};

        // act
        String[] result = template.generate(text, data);

        // action
        Assert.assertThat(result, is(checked));
    }

    @Test
    public void whenTakeArrayOfTextWithDataShouldReplaceParamsToData() {
        // assign
        Template template = new SimpleGenerator();
        String text = "Hello, ${name}.";
        String[] data = new String[] {"Petr", "Maria"};
        String[] checked = {"Hello, Petr.", "Hello, Maria."};

        // act
        String[] result = template.generate(text, data);

        // action
        Assert.assertThat(result, is(checked));
    }
}