package July.problem_0112_PathSum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/7/7 13:19
 */
class PathSumTest {

    private PathSum solution;
    private TreeNode root;
    private int sum;
    private boolean expected;

    @BeforeEach
    void setUp() {
        solution = new PathSum();
        root = TreeNode.of(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1);
        sum = 22;
        expected = true;
    }

    @Test
    void hasPathSum() {
        boolean result = solution.hasPathSum(root, sum);
        assertEquals(expected, result);
    }
}