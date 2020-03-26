package problem_0098_ValidateBinarySearchTree;

import org.junit.Before;
import org.junit.Test;
import utils.TreeNode;

import static org.junit.Assert.assertEquals;

public class ValidateBinarySearchTreeTest {
    ValidateBinarySearchTree solution;
    TreeNode root;
    boolean expected;

    @Before
    public void setUp() {
        solution = new ValidateBinarySearchTree();
        root = TreeNode.of(1, 1);
        expected = false;
    }

    @Test
    public void testIsValidBST1() {
        boolean result = solution.isValidBST1(root);
        assertEquals(expected, result);
    }

    @Test
    public void testIsValidBST2() {
        boolean result = solution.isValidBST2(root);
        assertEquals(expected, result);
    }

    @Test
    public void testIsValidBST3() {
        boolean result = solution.isValidBST3(root);
        assertEquals(expected, result);
    }

    @Test
    public void testIsValidBST4() {
        boolean result = solution.isValidBST4(root);
        assertEquals(expected, result);
    }

    @Test
    public void testIsValidBST5() {
        boolean result = solution.isValidBST(root);
        assertEquals(expected, result);
    }


}