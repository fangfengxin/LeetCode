package utils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树
 *
 * @author hustffx
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode of(Integer... values) {
        TreeNode head = new TreeNode(0);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);
        int index = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (index < values.length) {
                if (values[index] != null) {
                    node.left = new TreeNode(values[index]);
                    queue.offer(node.left);
                }
                index++;
                if (index == 1) {
                    continue;
                }
            }
            if (index < values.length) {
                if (values[index] != null) {
                    node.right = new TreeNode(values[index]);
                    queue.offer(node.right);
                }
                index++;
            }
        }
        return head.left;
    }

    /**
     * 返回前序遍历字符串
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(this);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) {
                continue;
            }
            sb.append(node.val);
            sb.append(' ');
            stack.push(node.right);
            stack.push(node.left);
        }
        return sb.toString().strip();
    }
}
