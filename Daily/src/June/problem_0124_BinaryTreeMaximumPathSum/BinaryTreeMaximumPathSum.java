package June.problem_0124_BinaryTreeMaximumPathSum;

/*
 * 124. 二叉树中的最大路径和
 * 给定一个非空二叉树，返回其最大路径和。
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *
 * 示例 1:
 * 输入: [1,2,3]
 *        1
 *       / \
 *      2   3
 * 输出: 6
 *
 * 示例 2:
 * 输入: [-10,9,20,null,null,15,7]
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出: 42
 */

import utils.TreeNode;

/**
 * @Author hustffx
 * @Date 2020/6/21 10:47
 */
public class BinaryTreeMaximumPathSum {
    /**
     * 全局最大和
     */
    private int maxPath = Integer.MIN_VALUE;

    /**
     * 方法：递归
     *
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxPath;
    }

    /**
     * DFS搜索
     *
     * @param root
     * @return
     */
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSum = Math.max(dfs(root.left), 0);
        int rightSum = Math.max(dfs(root.right), 0);

        int curMaxPath = root.val + leftSum + rightSum;
        maxPath = Math.max(maxPath, curMaxPath);

        return root.val + Math.max(leftSum, rightSum);
    }
}
