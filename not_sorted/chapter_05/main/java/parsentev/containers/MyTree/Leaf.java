package parsentev.containers.MyTree;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: comment.
 */
public class Leaf<E> {
    private E value;
    private Leaf<E> parent;
    private List<Leaf<E>> children = new ArrayList<>();

    public Leaf(E value, Leaf<E> parent) {
        this.value = value;
        this.parent = parent;
    }

    public void addToChildren(Leaf<E> leaf) {
        children.add(leaf);
    }

    public List<Leaf<E>> getChildren() {
        return this.children;
    }

    public E getValue() {
        return this.value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public Leaf<E> getParent() {
        return parent;
    }
}
