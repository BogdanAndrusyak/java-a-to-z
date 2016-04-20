package parsentev;

/**
 * TODO: comment.
 */
public class Deadlock {
    static class Friend {
        private final String name;
        public Friend(String name) {
            this.name = name;
        }
        public String getName() {
            return this.name;
        }
        public synchronized void bow(Friend bower) {
            System.out.format("%s: %s"
                            + "  has bowed to me!%n",
                    this.name, bower.getName());
            bower.bowBack(this);
        }
        public synchronized void bowBack(Friend bower) {
            System.out.format("%s: %s"
                            + " has bowed back to me!%n",
                    this.name, bower.getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final Friend alphonse =
                new Friend("Alphonse");
        final Friend gaston =
                new Friend("Gaston");
        Thread thread1 = new Thread(new Runnable() {
            public void run() { alphonse.bow(gaston); }
        });
        Thread thread2 = new Thread(new Runnable() {
            public void run() { gaston.bow(alphonse); }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}