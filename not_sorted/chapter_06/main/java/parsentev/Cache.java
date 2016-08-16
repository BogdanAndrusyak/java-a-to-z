package parsentev;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
/**
 * TODO: comment.
 */
public class Cache {

    public static void main(String[] args) {
        WeakReference<User> weekUser = new WeakReference<User>(new User("test"));
        SoftReference<User> softUser = new SoftReference<User>(new User("test"));
        System.gc();
        System.out.println(weekUser.get());
        System.out.println(softUser.get());
    }
}
