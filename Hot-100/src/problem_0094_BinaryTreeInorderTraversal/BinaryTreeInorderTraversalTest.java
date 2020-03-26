package problem_0094_BinaryTreeInorderTraversal;

import org.junit.Before;
import org.junit.Test;
import utils.TreeNode;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class BinaryTreeInorderTraversalTest {
    BinaryTreeInorderTraversal solution;
    TreeNode root;
    List<Integer> expected;

    @Before
    public void setUp() {
        solution = new BinaryTreeInorderTraversal();
        root = TreeNode.of(1, null, 2, 3);
        expected = List.of(1, 3, 2);
    }

    @Test
    public void testInorderTraversalRecursive() {
        List<Integer> result = solution.inorderTraversalRecursive(root);
        assertEquals(expected, result);
    }

    @Test
    public void testInorderTraversalIterative() {
        List<Integer> result = solution.inorderTraversalIterative(root);
        assertEquals(expected, result);
    }
}