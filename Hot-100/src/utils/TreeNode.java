package utils;

import java.util.LinkedList;
import java.util.Queue;

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

    @Override
    public String toString() {
        return Integer.toString(val);
    }
}
