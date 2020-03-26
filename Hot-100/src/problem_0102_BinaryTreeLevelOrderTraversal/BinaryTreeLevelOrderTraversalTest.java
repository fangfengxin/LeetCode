package problem_0102_BinaryTreeLevelOrderTraversal;

import org.junit.Before;
import org.junit.Test;
import utils.TreeNode;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class BinaryTreeLevelOrderTraversalTest {
    BinaryTreeLevelOrderTraversal solution;
    TreeNode root;
    List<List<Integer>> expected;

    @Before
    public void setUp() {
        solution = new BinaryTreeLevelOrderTraversal();
        root = TreeNode.of(3, 9, 20, null, null, 15, 7);
        expected = List.of(List.of(3), List.of(9, 20), List.of(15, 7));
    }

    @Test
    public void testLevelOrderRecursive() {
        List<List<Integer>> result = solution.levelOrderRecursive(root);
        assertEquals(expected, result);
    }

    @Test
    public void testLevelOrderIterative() {
        List<List<Integer>> result = solution.levelOrderIterative(root);
        assertEquals(expected, result);
    }
}