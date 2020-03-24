package problem_0094_BinaryTreeInorderTraversal;

import java.util.Stack;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    static TreeNode of(Integer... values) {
        TreeNode head = new TreeNode(0);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        int index = 0;
        while (!stack.isEmpty() && index < values.length) {
            TreeNode node = stack.pop();
            if (values[index] != null) {
                node.left = new TreeNode(values[index]);
                stack.push(node.left);
            } else if (values[++index] != null) {
                node.right = new TreeNode(values[index]);
                stack.push(node.right);
            }
            index++;
        }
        return head.left;
    }

    @Override
    public String toString() {
        return Integer.toString(val);
    }
}
