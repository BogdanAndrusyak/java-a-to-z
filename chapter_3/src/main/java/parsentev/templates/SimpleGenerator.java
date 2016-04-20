package parsentev.templates;

import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TODO: comment.
 */
public class SimpleGenerator implements Template {

    private static final String fieldStart = "\\$\\{";
    private static final String fieldEnd = "\\}";

    private static final String regex = fieldStart + "([^}]+)" + fieldEnd;
    private static final Pattern pattern = Pattern.compile(regex);

    /**
     * Magic...
     * @param template
     * @param data
     * @return
     */
    public String[] generate(String template, Object[] data) {
        if (!(data instanceof String[])) {
            throw new IllegalArgumentException("Wrong parameter data.");
        }

        String[] results = new String[data.length];

        for (int i = 0; i < results.length; i++) {
            results[i] = template;
        }

        Matcher m = pattern.matcher(template);

        while (m.find()) {
            for (int i = 0; i < results.length; i++) {
                results[i] = results[i].replaceFirst(regex, (String) data[i]);
            }
        }
        return results;
    }
}
