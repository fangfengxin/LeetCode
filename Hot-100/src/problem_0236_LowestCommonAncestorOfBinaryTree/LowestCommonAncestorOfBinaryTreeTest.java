package problem_0236_LowestCommonAncestorOfBinaryTree;

import org.junit.Before;
import org.junit.Test;
import utils.TreeNode;

import static org.junit.Assert.assertEquals;

public class LowestCommonAncestorOfBinaryTreeTest {
    LowestCommonAncestorOfBinaryTree solution;
    TreeNode root, p, q, expected;

    @Before
    public void setUp() {
        solution = new LowestCommonAncestorOfBinaryTree();
        root = TreeNode.of(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);
        /*
         *      3
         *     / \
         *    5   1
         *   / \ / \
         *  6  2 0  8
         *    / \
         *   7   4
         */
        p = root.left;
        q = root.left.right.right;
        expected = root.left;
    }

    @Test
    public void testLowestCommonAncestor1() {
        TreeNode result = solution.lowestCommonAncestor1(root, p, q);
        assertEquals(expected.toString(), result.toString());
    }

    @Test
    public void testLowestCommonAncestor2() {
        TreeNode result = solution.lowestCommonAncestor2(root, p, q);
        assertEquals(expected.toString(), result.toString());
    }
}