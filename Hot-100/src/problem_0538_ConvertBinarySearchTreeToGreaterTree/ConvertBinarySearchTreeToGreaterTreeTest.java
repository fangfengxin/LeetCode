package problem_0538_ConvertBinarySearchTreeToGreaterTree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/4/20 22:40
 */
class ConvertBinarySearchTreeToGreaterTreeTest {
    private ConvertBinarySearchTreeToGreaterTree solution;
    private TreeNode root;
    private TreeNode expected;

    @BeforeEach
    void setUp() {
        solution = new ConvertBinarySearchTreeToGreaterTree();
        root = TreeNode.of(5, 2, 13);
        expected = TreeNode.of(18, 20, 13);
    }

    @Test
    void convertBST1() {
        TreeNode result = solution.convertBST1(root);
        assertEquals(expected.toString(), result.toString());
    }

    @Test
    void convertBST2() {
        TreeNode result = solution.convertBST2(root);
        assertEquals(expected.toString(), result.toString());
    }

    @Test
    void convertBST3() {
        TreeNode result = solution.convertBST3(root);
        assertEquals(expected.toString(), result.toString());
    }
}