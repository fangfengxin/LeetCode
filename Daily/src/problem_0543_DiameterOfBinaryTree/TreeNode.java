package problem_0543_DiameterOfBinaryTree;

import java.util.ArrayDeque;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    static TreeNode addAll(int... vals) {
        if (vals.length == 0)
            throw new IllegalArgumentException("参数不能为空");
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        TreeNode root = new TreeNode(vals[0]);
        int index = 1;
        queue.addLast(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.removeFirst();
            if (index < vals.length && vals[index] != -1) {
                TreeNode node = new TreeNode(vals[index++]);
                treeNode.left = node;
                queue.addLast(node);
            }
            if (index < vals.length && vals[index] != -1) {
                TreeNode node = new TreeNode(vals[index++]);
                treeNode.right = node;
                queue.addLast(node);
            }
        }
        return root;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(this);
        while (!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();
            sb.append(node.val);
            if (node.left != null) {
                queue.addLast(node.left);
            }
            if (node.right != null) {
                queue.addLast(node.right);
            }
        }
        return sb.toString();
    }
}
