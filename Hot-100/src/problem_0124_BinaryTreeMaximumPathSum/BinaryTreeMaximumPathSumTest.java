package problem_0124_BinaryTreeMaximumPathSum;

import org.junit.Before;
import org.junit.Test;
import utils.TreeNode;

import static org.junit.Assert.assertEquals;

public class BinaryTreeMaximumPathSumTest {
    BinaryTreeMaximumPathSum solution;
    TreeNode root;
    int expected;

    @Before
    public void setUp() {
        solution = new BinaryTreeMaximumPathSum();
        root = TreeNode.of(9, 6, -3, null, null, -6, 2, null, null, 2, null, -6, -6, -6);
        expected = 16;
    }

    @Test
    public void testMaxPathSum() {
        int result = solution.maxPathSum(root);
        assertEquals(expected, result);
    }
}