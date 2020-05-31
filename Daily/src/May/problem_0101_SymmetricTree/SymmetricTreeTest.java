package May.problem_0101_SymmetricTree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.TreeNode;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author hustffx
 * @Date 2020/5/31 16:43
 */
class SymmetricTreeTest {
    private SymmetricTree solution;
    private TreeNode root;
    private boolean expected;

    @BeforeEach
    void setUp() {
        solution = new SymmetricTree();
        root = TreeNode.of(1, 2, 2, 3, 4, 4, 3);
        expected = true;
    }

    @Test
    void isSymmetric1() {
        boolean result = solution.isSymmetric1(root);
        assertEquals(expected, result);
    }

    @Test
    void isSymmetric2() {
        boolean result = solution.isSymmetric2(root);
        assertEquals(expected, result);
    }
}