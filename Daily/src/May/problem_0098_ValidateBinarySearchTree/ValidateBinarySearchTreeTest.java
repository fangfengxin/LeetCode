package May.problem_0098_ValidateBinarySearchTree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/5/5 17:32
 */
class ValidateBinarySearchTreeTest {
    private ValidateBinarySearchTree solution;
    private TreeNode root;
    private boolean expected;

    @BeforeEach
    void setUp() {
        solution = new ValidateBinarySearchTree();
        root = TreeNode.of(5, 1, 4, null, null, 3, 6);
        expected = false;
    }

    @Test
    void isValidBST1() {
        boolean result = solution.isValidBST1(root);
        assertEquals(expected, result);
    }

    @Test
    void isValidBST2() {
        boolean result = solution.isValidBST2(root);
        assertEquals(expected, result);
    }

    @Test
    void isValidBST3() {
        boolean result = solution.isValidBST3(root);
        assertEquals(expected, result);
    }
}