package parsentev.containers.MyTree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * TODO: comment.
 */
public class SimpleSearchBinaryTree<E extends Comparable<E>> {

    private Entry<E> root;

    public void put(E e) {
        Entry<E> t = root;
        if (t == null)
            root = new Entry<>(e, null);
        else {
            int cmp;
            Entry<E> parent;

            do {
                parent = t;
                cmp = e.compareTo(t.getValue());
                if (cmp < 0)
                    t = t.left;
                else if (cmp > 0)
                    t = t.right;
                else { // todo realize when cmp == 0
                    t.setValue(e);
                    return;
                }


            } while(t != null);

            Entry<E> eEntry = new Entry<>(e, parent);
            if (cmp < 0)
                parent.left = eEntry;
            else
                parent.right = eEntry;
        }
    }

    public List<E> getAllValues() {
        List<E> elements = new ArrayList<>();
        PrivateEntryIterator<E> privateEntryIterator = new PrivateEntryIterator<>(getFirstEntry());

        while (privateEntryIterator.hasNext()) {
            elements.add(privateEntryIterator.next().getValue());
        }

        return elements;
    }

    Entry<E> getFirstEntry() {
        Entry<E> p = root;
        if (p != null)
            while (p.left != null)
                p = p.left;
        return p;
    }

    private class PrivateEntryIterator<E> implements Iterator<Entry<E>> {
        Entry<E> next;

        public PrivateEntryIterator(Entry<E> first) {
            this.next = first;
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public Entry<E> next() {
            Entry<E> e = next;
            if (e == null)
                throw new NoSuchElementException();
            next = successor(e);
            return e;
        }

        private Entry<E> successor(Entry<E> t) {
            if (t == null)
                return null;
            else if (t.right != null) {
                Entry<E> p = t.right;
                while (p.left != null)
                    p = p.left;
                return p;
            } else {
                Entry<E> p = t.parent;
                Entry<E> ch = t;
                while (p != null && ch == p.right) {
                    ch = p;
                    p = p.parent;
                }
                return p;
            }
        }
    }

    class Entry<E> {
        E value;
        Entry<E> parent;
        Entry<E> left;
        Entry<E> right;

        Entry(E value, Entry<E> parent) {
            this.value = value;
            this.parent = parent;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }
    }
}