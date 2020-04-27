package problem_0104_MaximumDepthOfBinaryTree;
/*
 * 104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 */

import utils.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author fengxin.fang
 */
public class MaximumDepthOfBinaryTree {
    /**
     * 方法1：递归
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    /**
     * 方法2：迭代
     * 深度优先，先序遍历，用栈
     * 广度优先，层次遍历，用队列
     */
    public int maxDepthIteration(TreeNode root) {
        int maxDepth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        HashMap<TreeNode, Integer> map = new HashMap<>();
        queue.offer(root);
        map.put(root, 1);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int curDepth = map.get(node);
            maxDepth = Math.max(maxDepth, curDepth);
            if (node.left != null) {
                queue.offer(node.left);
                map.put(node.left, curDepth + 1);
            }
            if (node.right != null) {
                queue.offer(node.right);
                map.put(node.right, curDepth + 1);
            }
        }
        return maxDepth;
    }
}
