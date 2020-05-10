package May.problem_0236_LowestCommonAncestorOfBinaryTree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/5/10 11:15
 */
class LowestCommonAncestorOfBinaryTreeTest {
    private LowestCommonAncestorOfBinaryTree solution;
    private TreeNode root;
    private TreeNode p;
    private TreeNode q;
    private TreeNode expected;

    @BeforeEach
    void setUp() {
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
        p = new TreeNode(5);
        q = new TreeNode(4);
        expected = p;
    }

    @Test
    void lowestCommonAncestor() {
        TreeNode result = solution.lowestCommonAncestor(root, p, q);
        assertEquals(expected.val, result.val);
    }
}