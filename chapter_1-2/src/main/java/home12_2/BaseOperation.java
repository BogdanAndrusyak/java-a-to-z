package home12_2;

/**
 * Base abstract class of all operations.
 */
public abstract class BaseOperation {
    /** Name of operation. */
    private final String name;

    /**
     * Default constructor.
     * @param name Name of operation.
     */
    public BaseOperation(String name) {
        this.name = name;
    }

    /**
     * Define a unique key.
     * @return Key.
     */
    abstract int getKey();

    /**
     * Execute operation.
     * @param input Input system.
     * @param calculator Calculator.
     * @param reUse The parameter is used only for operation 'use last result'.
     */
    abstract void execute(ConsoleInput input, Calculator calculator, boolean reUse);

    /**
     * Print information about what operation should to do.
     * @return Information.
     */
    public String info() {
        return String.format("%s - %s.", this.getKey(), this.name);
    }
}
