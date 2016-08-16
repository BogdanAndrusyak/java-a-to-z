package andrusyak.task_03;

/**
 * Perform operations and storage result.
 */
public class Calculator {
    /** Result of the operation. */
    protected double result;

    /**
     * Add two numbers.
     * @param first First number.
     * @param second Second number.
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Subtract two numbers.
     * @param first First number.
     * @param second Second number.
     */
    public void subtract(double first, double second) {
        this.result = first - second;
    }

    /**
     * Divide two numbers.
     * @param first First number.
     * @param second Second number.
     */
    public void div(double first, double second) throws IllegalArgumentException {
        if(second == 0d)
            throw new IllegalArgumentException("Argument 'second' is 0");
        else
            this.result = first / second;
    }

    /**
     * Multiply two numbers.
     * @param first First number.
     * @param second Second number.
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }

    public double getResult() {
        return this.result;
    }
}
