package problem_0124_BinaryTreeMaximumPathSum;

/*
 * 124. 二叉树中的最大路径和
 * 给定一个非空二叉树，返回其最大路径和。
 *
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *
 * 示例 1:
 * 输入: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * 输出: 6
 *
 * 示例 2:
 * 输入: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 输出: 42
 */

import utils.TreeNode;

/**
 * @author hustffx
 */
public class BinaryTreeMaximumPathSum {
    /**
     * 方法：递归
     */
    public int maxPathSum(TreeNode root) {
        TreeNode res = new TreeNode(Integer.MIN_VALUE);
        maxPathSum(root, res);
        return res.val;
    }

    private int maxPathSum(TreeNode root, TreeNode res) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(maxPathSum(root.left, res), 0);
        int right = Math.max(maxPathSum(root.right, res), 0);
        res.val = Math.max(res.val, left + right + root.val);
        return root.val + Math.max(left, right);
    }
}
