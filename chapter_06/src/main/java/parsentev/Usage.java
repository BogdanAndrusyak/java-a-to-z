package parsentev;

/**
 * TODO: comment.
 */
public class Usage {
    public static final class Counter {
        long count = 0;
        static String name = "String";
        // lock = this
        public synchronized void add(long value) {
            this.count += value;
        }

        // lock = Class
        public static synchronized void echo() {
            System.out.println(name);
        }
    }

    public static final class CounterThread extends Thread {
        protected final Counter counter;

        public CounterThread(final Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            counter.add(1);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();
        Thread threadA = new CounterThread(counter);
        Thread threadB = new CounterThread(counter);

        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join();
        System.out.println(counter.count);

    }
}
