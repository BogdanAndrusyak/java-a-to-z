package parsentev;

import java.lang.ref.SoftReference;
import java.util.LinkedList;
import java.util.List;

/**
 * TODO: comment.
 */
public class MemoryUsage {

    public static void main(String[] args) {
        System.out.println("start");
        info();
        List<User> list = new LinkedList<User>();
        for (int i = 0; i < 10000; i++) {
            User user = new User("test");
            System.out.println(user);
            list.add(user);
            //user = null;
        }

//        System.gc();
        System.out.println("finish");
        info();
    }

    public static void info() {
        int mb = 1024*1024;

        Runtime runtime = Runtime.getRuntime();

        System.out.println("##### Heap utilization statistics [MB] #####");

        //Print used memory
        System.out.println("Used Memory:"
                +(runtime.totalMemory() - runtime.freeMemory()) / mb);

        //Print free memory
        System.out.println("Free Memory:"
                + runtime.freeMemory() / mb);

        //Print total available memory
        System.out.println("Total Memory:" + runtime.totalMemory() / mb);

        //Print Maximum available memory
        System.out.println("Max Memory:" + runtime.maxMemory() / mb);

        System.out.println("##### -------------------------------- #####");
    }
}
