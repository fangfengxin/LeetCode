package problem_0617_MergeTwoBinaryTrees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/4/21 17:52
 */
class MergeTwoBinaryTreesTest {
    private MergeTwoBinaryTrees solution;
    private TreeNode t1;
    private TreeNode t2;
    private TreeNode expected;

    @BeforeEach
    void setUp() {
        solution = new MergeTwoBinaryTrees();
        t1 = TreeNode.of(1, 3, 2, 5);
        t2 = TreeNode.of(2, 1, 3, null, 4, null, 7);
        expected = TreeNode.of(3, 4, 5, 5, 4, null, 7);
    }

    @Test
    void mergeTrees1() {
        TreeNode result = solution.mergeTrees1(t1, t2);
        assertEquals(expected, result);
    }

    @Test
    void mergeTrees2() {
        TreeNode result = solution.mergeTrees2(t1, t2);
        assertEquals(expected, result);
    }
}