package April.problem_0199_BinaryTreeRightSideView;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.TreeNode;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/4/22 8:51
 */
class BinaryTreeRightSideViewTest {
    private BinaryTreeRightSideView solution;
    private TreeNode root;
    private List<Integer> expected;

    @BeforeEach
    void setUp() {
        solution = new BinaryTreeRightSideView();
        root = TreeNode.of(1, 2, 3, null, 5, null, 4);
        expected = List.of(1, 3, 4);
    }

    @Test
    void rightSideView() {
        List<Integer> result = solution.rightSideView(root);
        assertEquals(expected, result);
    }
}