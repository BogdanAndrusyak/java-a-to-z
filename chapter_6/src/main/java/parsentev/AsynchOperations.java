package main.java.parsentev;

/**
 * TODO: comment.
 */
public class AsynchOperations {

    public static final class Calculate implements Runnable {
        private final String name;

        public Calculate(final String name) {
            this.name = name;
        }

        public void run() {
            System.out.println(String.format("%s TODO asynch", this.name));
        }
    }

    public static void main(String[] args) {
        System.out.println("start");
        new Thread(new Calculate("thread 1")).start();
        System.out.println("finish");
    }
}
