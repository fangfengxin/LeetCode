package problem_0114_FlattenBinaryTreeToLinkedList;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * 114. 二叉树展开为链表
 * 给定一个二叉树，原地将它展开为链表。
 *
 * 例如，给定二叉树
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 *
 * 将其展开为：
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 */
public class FlattenBinaryTreeToLinkedList {
    /**
     * 方法1：先序遍历 + 栈
     */
    public void flatten1(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode tmp = new TreeNode(0);
        while (!stack.isEmpty()) {
            // 先将右节点放到栈中，再将左节点放入栈中，模拟前序遍历
            TreeNode node = stack.pop();
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            // 将当前节点与上一节点串联起来
            tmp.left = null;
            tmp.right = node;
            tmp = tmp.right;
        }
    }

    /**
     * 方法2：先序遍历 + 队列
     */
    public void flatten2(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        // 前序遍历整棵二叉树，并将遍历的结果放入队列
        preorderTraversal(root, queue);
        TreeNode node = queue.poll();
        node.left = null;
        // 通过队列将TreeNode节点串联起来
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            tmp.left = null;
            node.right = tmp;
            node = node.right;
        }
    }

    private void preorderTraversal(TreeNode root, Queue<TreeNode> queue) {
        if (root == null) {
            return;
        }
        queue.offer(root);
        preorderTraversal(root.left, queue);
        preorderTraversal(root.right, queue);
    }

    /**
     * 方法3：后序遍历
     */
    public void flatten3(TreeNode root) {
        postorderTraversal(root);
    }

    private void postorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        if (root.left != null) {
            TreeNode node = root.left;
            while (node.right != null) {
                node = node.right;
            }
            node.right = root.right;
            root.right = root.left;
            root.left = null;
        }
    }

    /**
     * 方法4：与前序遍历相反的方向遍历（右-左-根）
     */
    public void flatten4(TreeNode root) {
        reversePreorderTraversal(root);
    }

    TreeNode node = null;

    private void reversePreorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        // 用node节点作为媒介，将遍历到的节点前后串联起来
        reversePreorderTraversal(root.right);
        reversePreorderTraversal(root.left);
        root.left = null;
        root.right = node;
        node = root;
    }
}
