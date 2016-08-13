package parsentev.templates;

/**
 * TODO: comment.
 */
public interface Template {
    /**
     * Hello world, ${name}.
     * @param template
     * @param data
     * @return
     */
    String[] generate(String template, Object[] data);
}
