package problem_0094_BinaryTreeInorderTraversal;

import org.junit.Before;
import org.junit.Test;
import tools.TreeNode;

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
    public void testInorderTraversal1() {
        List<Integer> result = solution.inorderTraversal1(root);
        assertEquals(expected, result);
    }

    @Test
    public void testInorderTraversal2() {
        List<Integer> result = solution.inorderTraversal2(root);
        assertEquals(expected, result);
    }
}