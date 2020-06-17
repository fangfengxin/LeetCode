package June.problem_1028_RecoverTreeFromPreorderTraversal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/6/18 1:19
 */
class RecoverTreeFromPreorderTraversalTest {
    private RecoverTreeFromPreorderTraversal solution;
    private String s;
    private TreeNode expected;

    @BeforeEach
    void setUp() {
        solution = new RecoverTreeFromPreorderTraversal();
        s = "1-2--3--4-5--6--7";
        expected = TreeNode.of(1, 2, 5, 3, 4, 6, 7);
    }

    @Test
    void recoverFromPreorder() {
        TreeNode result = solution.recoverFromPreorder(s);
        assertEquals(expected.toString(), result.toString());
    }
}