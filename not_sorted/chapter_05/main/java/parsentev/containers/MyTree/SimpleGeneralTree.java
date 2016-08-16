package parsentev.containers.MyTree;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: comment.
 */
public class SimpleGeneralTree<E> {

    private Leaf<E> root;

    public SimpleGeneralTree(Leaf<E> root) {
        this.root = root;
    }

    public void addChild(Leaf<E> leaf, E e) {
        leaf.addToChildren(new Leaf<E>(e, leaf));
    }

    // analog method getChildren from technical task maybe
    public List<E> getAllValues() {
        ArrayList list = new ArrayList();
        return traverse(root,list);
    }

    private List<E> traverse(Leaf<E> leaf, List<E> list) {
        list.add(leaf.getValue());

        for (Leaf<E> child : leaf.getChildren())
            traverse(child, list);
        return list;
    }

    public boolean balanced() {
        return balancedTraverse(this.root, true);
    }

    private boolean balancedTraverse(Leaf<E> leaf, Boolean isBalanced) {

        for (Leaf child : leaf.getChildren()) {
            if (child.getChildren().size() > 2) {
                isBalanced = false;
                break;
            }

            balancedTraverse(child, isBalanced);
        }
        return isBalanced;
    }
}
