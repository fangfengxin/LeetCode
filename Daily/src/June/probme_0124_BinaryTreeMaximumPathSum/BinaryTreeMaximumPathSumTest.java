package June.probme_0124_BinaryTreeMaximumPathSum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/6/21 11:12
 */
class BinaryTreeMaximumPathSumTest {
    private BinaryTreeMaximumPathSum solution;
    private TreeNode root;
    private int expected;

    @BeforeEach
    void setUp() {
        solution = new BinaryTreeMaximumPathSum();
        root = TreeNode.of(-10, 9, 20, null, null, 15, 7);
        expected = 42;
    }

    @Test
    void maxPathSum() {
        int result = solution.maxPathSum(root);
        assertEquals(expected, result);
    }
}