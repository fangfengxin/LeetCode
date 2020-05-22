package May.problem_0105_ConstructBinaryTreeFromPreorderAndInorderTraversal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/5/22 11:13
 */
class ConstructBinaryTreeFromPreorderAndInorderTraversalTest {
    private ConstructBinaryTreeFromPreorderAndInorderTraversal solution;
    private int[] preorder;
    private int[] inorder;
    private TreeNode expected;

    @BeforeEach
    public void setUp() {
        solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
        preorder = new int[]{3, 9, 20, 15, 7};
        inorder = new int[]{9, 3, 15, 20, 7};
        expected = TreeNode.of(3, 9, null, null, 20, 15, 7);
    }

    @Test
    public void buildTree() {
        TreeNode result = solution.buildTree(preorder, inorder);
        assertEquals(expected.toString(), result.toString());
    }
}