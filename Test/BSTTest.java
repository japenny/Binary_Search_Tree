import org.junit.Test;

import static org.junit.Assert.*;

public class BSTTest {

    @Test
    public void nodeInsert() {
        NodeBST<Integer> test = new NodeBST<>(5);
        test.insert(10);
        test.insert(3);
        assertEquals("3, 10, 5", test.postOrder());

        test.insert(15);
        test.insert(12);
        assertEquals("3, 12, 15, 10, 5", test.postOrder());

        test.insert(7);
        test.insert(6);
        assertEquals("5, 3, 10, 7, 6, 15, 12", test.preOrder());

        test.insert(4);
        assertEquals("4, 3, 6, 7, 12, 15, 10, 5", test.postOrder());

    }

    @Test
    public void nodeRemoveRoot() {
        NodeBST<Integer> test = new NodeBST<>(5);
        test.insert(4);
        test.removeRoot();
        assertEquals("4", test.postOrder());

        test.insert(7);
        test.insert(5);
        test.insert(6);
        test.removeRoot();
        assertEquals("6, 5, 7", test.postOrder());

        test.insert(3);
        test.removeRoot();
        assertEquals("3, 6, 5", test.postOrder());

        test.insert(0);
        test.insert(1);
        test.insert(-2);
        test.insert(2);
        test.removeRoot();
        assertEquals("-2, 2, 1, 0, 6, 3", test.postOrder());

    }

    @Test
    public void insert(){
        BST<Integer> test = new BST<Integer>(new NodeBST<>(5));
        test.getRoot().insert(4);

        test.getRoot().insert(-2);
        test.getRoot().insert(10);
        assertEquals("-2, 4, 10, 5",test.getRoot().postOrder());

        test.getRoot().insert(8);
        test.getRoot().insert(18);
        assertEquals("-2, 4, 8, 18, 10, 5",test.getRoot().postOrder());

        test.getRoot().insert(-1);
        test.getRoot().insert(7);
        assertEquals("-1, -2, 4, 7, 8, 18, 10, 5",test.getRoot().postOrder());

    }

    @Test
    public void removeRoot() {
        BST<Integer> test = new BST<Integer>(new NodeBST<>(5));
        test.getRoot().insert(4);
        test.getRoot().removeRoot();
        assertEquals("4", test.getRoot().postOrder());

        test.getRoot().insert(-2);
        test.getRoot().insert(10);
        test.getRoot().removeRoot();
        assertEquals("-2, 10",test.getRoot().preOrder());

        test.getRoot().insert(8);
        test.getRoot().insert(18);
        test.getRoot().removeRoot();
        assertEquals("10, 8, 18",test.getRoot().preOrder());

        test.getRoot().insert(-1);
        test.getRoot().insert(7);
        test.getRoot().removeRoot();
        assertEquals("7, -1, 18, 8",test.getRoot().postOrder());
    }

}