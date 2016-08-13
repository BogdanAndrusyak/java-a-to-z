package parsentev.services;

import org.junit.Test;

import java.util.*;
import java.util.Stack;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;

/**
 * TODO: comment.
 */
public class SimpleListTest {

    public class A { }
    public class B extends A { }
    public class C extends B { }

    @Test
    public void whenCreateContainerShouldReturnTheSameType() {
        Stack simple = new Stack(4);

        simple.add("test");
        String result = simple.get(0);

        assertThat(result,  is("test"));
    }

    public void showList() {
        List<String> list = new ArrayList<>(100);
        List<? super Integer> numbers = new LinkedList<>();
        numbers.add(1);

    }

    @Test
    public void showSet() {
        Set<String> set = new HashSet<>();
        set.add("first");
        set.add("second");
        set.add("zero");
        set.add("third");
        System.out.println(set);

        for(String value : set) {
            System.out.println(value + " " + value.hashCode());
        }
    }
}