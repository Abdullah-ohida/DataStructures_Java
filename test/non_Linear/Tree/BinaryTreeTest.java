package non_Linear.Tree;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void givenABinaryTree_WhenAddingElements_ThenTreeContainsThoseElements() {
        BinaryTree tree = new BinaryTree();

        BinaryTree binaryTree = tree.createBinaryTree(tree);

        assertTrue(binaryTree.containsNode(6));
        assertTrue(binaryTree.containsNode(4));


        assertFalse(binaryTree.containsNode(1));
    }

    @Test
    public void givenABinaryTree_WhenDeletingElements_ThenTreeDoesNotContainThoseElements() {
        BinaryTree tree = new BinaryTree();

        BinaryTree binaryTree = tree.createBinaryTree(tree);

        assertTrue(binaryTree.containsNode(9));
        binaryTree.delete(9);
        assertFalse(binaryTree.containsNode(9));
    }
}