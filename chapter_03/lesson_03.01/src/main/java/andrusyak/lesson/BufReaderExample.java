package andrusyak.lesson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * TODO: comment.
 * Created by Bogdan on 8/15/2016.
 */
public class BufReaderExample {
    public static void main(String[] args) throws IOException {
        char c;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter symbols, 'q' - exit");
        do {
            c = (char) br.read();
            System.out.println(c);
        } while (c != 'q');
    }
}
