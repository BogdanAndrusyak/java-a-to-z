package home12_2;

/**
 * TODO: comment.
 */
public class MenuEngineerCalculator extends MenuCalculator {
    /**
     * Default constructor.
     *
     * @param input      Input.
     * @param calculator Calculator.
     * @param size Menu size.
     */
    public MenuEngineerCalculator(ConsoleInput input, Calculator calculator, int size) {
        super(input, calculator, size);
    }

    @Override
    public void fillOperations() {
        super.fillOperations();

        operations[6] = new BaseOperation("calculate sin") {
            @Override
            int getKey() {
                return 6;
            }

            @Override
            void execute(ConsoleInput input, Calculator calculator, boolean reUse) {
                if (calculator instanceof EngineerCalculator) {
                    EngineerCalculator engineerCalculator = (EngineerCalculator) calculator;

                    double degrees = Double.valueOf(input.ask("Please enter the degrees: "));

                    engineerCalculator.sin(degrees);
                    engineerCalculator.setLastOperation(this.getKey());
                    System.out.println("Result: " + engineerCalculator.getResult());
                } else {
                    throw new IllegalArgumentException("Incorrect object 'calculator'.");
                }
            }
        };

        operations[7] = new BaseOperation("calculate cos") {
            @Override
            int getKey() {
                return 7;
            }

            @Override
            void execute(ConsoleInput input, Calculator calculator, boolean reUse) {
                if (calculator instanceof EngineerCalculator) {
                    EngineerCalculator engineerCalculator = (EngineerCalculator) calculator;

                    double degrees = Double.valueOf(input.ask("Please enter the degrees: "));

                    engineerCalculator.cos(degrees);
                    engineerCalculator.setLastOperation(this.getKey());
                    System.out.println("Result: " + engineerCalculator.getResult());
                } else {
                    throw new IllegalArgumentException("Incorrect object 'calculator'.");
                }
            }
        };
    }
}
