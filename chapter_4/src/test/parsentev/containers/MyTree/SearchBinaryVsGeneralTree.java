package parsentev.containers.MyTree;

import org.junit.Test;

/**
 * TODO: comment.
 */
public class SearchBinaryVsGeneralTree {

    // not beauty code, not in the object-oriented style. I understand (:
    @Test
    public void test() {
        long timeout;
        long timeoutGT;
        long timeoutSBT;

        // initialization SimpleGeneralTree
        timeout = System.nanoTime();

        Leaf<Integer> rootSimpleTree = new Leaf<>(5, null);
        SimpleGeneralTree<Integer> simpleGeneralTree = new SimpleGeneralTree<>(rootSimpleTree);
        simpleGeneralTree.addChild(rootSimpleTree, 4);
        simpleGeneralTree.addChild(rootSimpleTree, 1);
        simpleGeneralTree.addChild(rootSimpleTree, 6);
        Leaf<Integer> newLeaf = new Leaf<>(7, rootSimpleTree);
        rootSimpleTree.addToChildren(newLeaf);
        simpleGeneralTree.addChild(newLeaf, 13);
        simpleGeneralTree.addChild(newLeaf, 9);
        simpleGeneralTree.addChild(newLeaf, 12);
        simpleGeneralTree.addChild(newLeaf, 8);

        System.out.println("Time initialization SimpleGeneralTree: \t\t" + (System.nanoTime() - timeout));

        // initialization SimpleSearchBinaryTree
        timeout = System.nanoTime();

        SimpleSearchBinaryTree<Integer> simpleSearchBinaryTree = new SimpleSearchBinaryTree<Integer>();
        simpleSearchBinaryTree.put(5);
        simpleSearchBinaryTree.put(4);
        simpleSearchBinaryTree.put(1);
        simpleSearchBinaryTree.put(6);
        simpleSearchBinaryTree.put(7);
        simpleSearchBinaryTree.put(13);
        simpleSearchBinaryTree.put(9);
        simpleSearchBinaryTree.put(12);
        simpleSearchBinaryTree.put(8);

        System.out.println("Time initialization SimpleSearchBinaryTree: " + (System.nanoTime() - timeout));

        timeoutGT = System.nanoTime();
        for (Integer integer : simpleGeneralTree.getAllValues()) {
            System.out.print(integer + " ");
        }
        timeoutGT = System.nanoTime() - timeoutGT;

        System.out.println();

        timeoutSBT = System.nanoTime();
        for (Integer integer : simpleSearchBinaryTree.getAllValues()) {
            System.out.print(integer + " ");
        }
        timeoutSBT = System.nanoTime() - timeoutSBT;

        System.out.println("\n*****FIGHT*****");
        System.out.println("Time search all elements in SimpleGeneralTree: \t\t" + timeoutGT);
        System.out.println("Time search all elements in SimpleSearchBinaryTree: " + timeoutSBT);

        long difference = timeoutGT - timeoutSBT;
        System.out.println("*****WINNER*****: " + ( difference < 0 ? "SimpleGeneralTree" : "SimpleSearchBinaryTree"));
        System.out.println(Math.abs(difference) + " nanoseconds difference. [1 millisecond = 10^6 nanoseconds]");

    }
}