package problem_0101_SymmetricTree;

import org.junit.Before;
import org.junit.Test;
import utils.TreeNode;

import static org.junit.Assert.assertEquals;

public class SymmetricTreeTest {
    SymmetricTree solution;
    TreeNode root;
    boolean expected;

    @Before
    public void setUp() {
        solution = new SymmetricTree();
        root = TreeNode.of(1, 2, 3);
        expected = false;
    }

    @Test
    public void testIsSymmetricRecursive() {
        boolean result = solution.isSymmetricRecursive(root);
        assertEquals(expected, result);
    }

    @Test
    public void testIsSymmetricIterative() {
        boolean result = solution.isSymmetricIterative(root);
        assertEquals(expected, result);
    }
}