package problem_0104_MaximumDepthOfBinaryTree;

import org.junit.Before;
import org.junit.Test;
import utils.TreeNode;

import static org.junit.Assert.assertEquals;

public class MaximumDepthOfBinaryTreeTest {
    MaximumDepthOfBinaryTree solution;
    TreeNode root;
    int expected;

    @Before
    public void setUp() {
        solution = new MaximumDepthOfBinaryTree();
        root = TreeNode.of(3, 9, 20, null, null, 15, 7);
        expected = 3;
    }

    @Test
    public void testMaxDepth() {
        int result = solution.maxDepth(root);
        assertEquals(expected, result);
    }

    @Test
    public void testMaxDepthIteration() {
        int result = solution.maxDepthIteration(root);
        assertEquals(expected, result);
    }
}