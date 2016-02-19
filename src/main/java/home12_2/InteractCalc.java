package home12_2;

/**
 * This class runs the program.
 */
public class InteractCalc {
    private static MenuCalculator menuCalculator;
    private static ConsoleInput input;
    private static int[] range;

    public static void main(String[] args) {
        InteractCalc interactCalc = new InteractCalc();
        Calculator calculator = new Calculator();
        input = new ConsoleInput();
        menuCalculator = new MenuCalculator(input, calculator);
        menuCalculator.fillOperations();
        range = menuCalculator.getRange();
        interactCalc.init();
    }

    /**
     * Init main loop.
     */
    public void init() {
        boolean isExit = false;
        do {
            menuCalculator.show();
            int key = input.ask("Select: ", range);
            if (key == 6) {
                isExit = true;
            } else {
                menuCalculator.select(key);
            }
        } while(!isExit);
    }
}
