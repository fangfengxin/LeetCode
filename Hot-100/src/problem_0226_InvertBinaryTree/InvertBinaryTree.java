package problem_0226_InvertBinaryTree;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 226. 翻转二叉树
 * 翻转一棵二叉树。
 *
 * 示例：
 * 输入：
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 */
public class InvertBinaryTree {
    /**
     * 方法1：递归
     */
    public TreeNode invertTreeRecursive(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = invertTreeRecursive(root.right);
        TreeNode left = invertTreeRecursive(root.left);
        root.left = right;
        root.right = left;
        return root;
    }

    /**
     * 方法2：迭代（自顶向下）
     */
    public TreeNode invertTreeIterative(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                continue;
            }
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
            queue.offer(node.right);
            queue.offer(node.left);
        }
        return root;
    }
}
