package March.problem_0543_DiameterOfBinaryTree;

import org.junit.Before;
import org.junit.Test;
import utils.TreeNode;

import static org.junit.Assert.assertEquals;

public class DiameterOfBinaryTreeTest {
    DiameterOfBinaryTree solution;
    TreeNode root;
    int expected;

    @Before
    public void setUp() {
        solution = new DiameterOfBinaryTree();
        root = TreeNode.of(1, 2, 3, 4, 5);
        expected = 3;
    }

    @Test
    public void testDiameterOfBinaryTree() {
        int result = solution.diameterOfBinaryTree(root);
        assertEquals(expected, result);
    }
}