package problem_0226_InvertBinaryTree;

import org.junit.Before;
import org.junit.Test;
import utils.TreeNode;

import static org.junit.Assert.assertEquals;

public class InvertBinaryTreeTest {
    InvertBinaryTree solution;
    TreeNode root, expected;

    @Before
    public void setUp() {
        solution = new InvertBinaryTree();
        root = TreeNode.of(4, 2, 7, 1, 3, 6, 9);
        expected = TreeNode.of(4, 7, 2, 9, 6, 3, 1);
    }

    @Test
    public void testInvertTreeRecursive() {
        TreeNode result = solution.invertTreeRecursive(root);
        assertEquals(expected.toString(), result.toString());
    }

    @Test
    public void testInvertTreeIterative() {
        TreeNode result = solution.invertTreeIterative(root);
        assertEquals(expected.toString(), result.toString());
    }
}