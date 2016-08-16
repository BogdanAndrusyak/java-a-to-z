package parsentev.Iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * TODO: comment.
 */
public class IteratorTest {
    public static void main(String[] args) {
        List<Iterator<Integer>> list = new ArrayList<Iterator<Integer>>();
        list.add(Arrays.asList(1, 2).iterator());
        list.add(Arrays.asList(3, 4).iterator());

        //Iterator<Integer> one = convert(list.iterator());
    }

    /*public static Iterator convert(Iterator iterator) {
        Iterator result = new Iterator() {
            public boolean hasNext() {
                return false;
            }

            public Object next() {
                return iterator.next();
            }
        }
    }*/
}
