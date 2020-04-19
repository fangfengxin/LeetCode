package problem_0437_PathSumIII;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/4/19 15:45
 */
class PathSumIIITest {
    private PathSumIII solution;
    private TreeNode root;
    private int sum;
    private int expected;

    @BeforeEach
    void setUp() {
        solution = new PathSumIII();
        root = TreeNode.of(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1);
        sum = 22;
        expected = 3;
    }

    @Test
    void pathSum1() {
        int result = solution.pathSum1(root, sum);
        assertEquals(expected, result);
    }

    @Test
    void pathSum2() {
        int result = solution.pathSum2(root, sum);
        assertEquals(expected, result);
    }

    @Test
    void pathSum3() {
        int result = solution.pathSum3(root, sum);
        assertEquals(expected, result);
    }
}