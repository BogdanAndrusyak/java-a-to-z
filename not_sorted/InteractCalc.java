package andrusyak;

/**
 * This class runs the program.
 */
public class InteractCalc {
    private static MenuCalculator menuCalculator;
    private static ConsoleInput input;
    private static int[] range;

    public static void main(String[] args) {
        InteractCalc interactCalc = new InteractCalc();
        Calculator calculator = new EngineerCalculator();
        input = new ConsoleInput();
        menuCalculator = new MenuEngineerCalculator(input, calculator, 8);
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
            System.out.println(String.format("%s - %s.", 8, "exit"));
            int key = input.ask("Select: ", range);
            if (key == 8) {
                isExit = true;
            } else {
                menuCalculator.select(key);
            }
        } while(!isExit);
    }
}
