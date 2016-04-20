package home12_2;

import java.util.Scanner;

/**
 * Input system.
 */
public class ConsoleInput {

    private final Scanner scanner = new Scanner(System.in);

    /**
     * Ask question the user and get an answer.
     * @param question Question.
     * @return Answer.
     */
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    /**
     * Checking for correct answer. Using in menu.
     * @param question Question.
     * @param range The range of correct values.
     * @return Answer.
     */
    public int ask(String question, int[] range) {
        int key = -1;
        try {
            key = Integer.valueOf(this.ask(question));
            boolean exist = false;
            for(int value : range) {
                if(value == key) {
                    exist = true;
                    break;
                }
            }
            if(!exist) {
                throw new MenuOutException();
            }
        } catch (MenuOutException moe) {
            System.out.println("Please select key from menu.");
        }
        return key;
    }
}
