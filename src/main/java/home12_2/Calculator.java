package home12_2;

/**
 * Perform operations and storage result.
 */
public class Calculator {
    /** Result of the operation. */
    private double result;
    /** ID of last operation. */
    private int lastOperation = 0;

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
    public void div(double first, double second) {
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

    public int getLastOperation() {
        return this.lastOperation;
    }

    public void setLastOperation(int lastOperation) {
        this.lastOperation = lastOperation;
    }
}
