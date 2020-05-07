package May.problem_0572_SubtreeOfAnotherTree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.TreeNode;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author hustffx
 * @Date 2020/5/7 18:40
 */
class SubtreeOfAnotherTreeTest {
    private SubtreeOfAnotherTree solution;
    private TreeNode s;
    private TreeNode t;
    private boolean expected;

    @BeforeEach
    void setUp() {
        solution = new SubtreeOfAnotherTree();
        s = TreeNode.of(3, 4, 5, 1, 2, null, null, null, null, 0);
        t = TreeNode.of(4, 1, 2);
        expected = false;
    }

    @Test
    void isSubtree() {
        boolean result = solution.isSubtree(s, t);
        assertEquals(expected, result);
    }
}
