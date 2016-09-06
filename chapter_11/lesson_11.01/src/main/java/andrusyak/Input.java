package andrusyak;

import java.util.Scanner;

/**
 * Created by bogdan on 9/6/16.
 */
public class Input {
    private final Scanner scanner = new Scanner(System.in);

    public String ask(String question) {
        System.out.print("Please enter a name of new User: ");
        return scanner.nextLine();
    }
}
