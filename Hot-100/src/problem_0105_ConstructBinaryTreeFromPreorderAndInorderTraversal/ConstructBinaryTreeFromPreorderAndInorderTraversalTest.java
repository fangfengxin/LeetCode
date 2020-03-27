package problem_0105_ConstructBinaryTreeFromPreorderAndInorderTraversal;

import org.junit.Before;
import org.junit.Test;
import utils.TreeNode;

import static org.junit.Assert.assertEquals;

public class ConstructBinaryTreeFromPreorderAndInorderTraversalTest {
    ConstructBinaryTreeFromPreorderAndInorderTraversal solution;
    int[] preorder, inorder;
    TreeNode expected;

    @Before
    public void setUp() {
        solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
        preorder = new int[]{3, 9, 20, 15, 7};
        inorder = new int[]{9, 3, 15, 20, 7};
        expected = TreeNode.of(3, 9, null, null, 20, 15, 7);
    }

    @Test
    public void testBuildTree() {
        TreeNode result = solution.buildTree(preorder, inorder);
        assertEquals(expected.toString(), result.toString());
    }
}