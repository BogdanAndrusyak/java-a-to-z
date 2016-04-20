package parsentev;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * TODO: comment.
 */
public class NonBlock {

    private volatile boolean blockCustomer = true; // thread stack

    public void doSomething() throws InterruptedException {
        while (this.blockCustomer) { // while не if щоб додатково перевірити
            System.out.println(String.format("%s usefull work", Thread.currentThread().getId()));
        }
    }

    public void changeBlock(boolean enable) {
            System.out.println(String.format("%s enable", Thread.currentThread().getId()));
            this.blockCustomer = enable;
        }

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                /*
                1. read
                2. increment
                3. write
                 */
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
            }
        }.start();

        List<String> syncList = Collections.synchronizedList(new ArrayList<String>());
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<String>(); // разница только когда пробегаем по массиву
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(); // 16 локов

    }
}
