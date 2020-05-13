package May.problem_0102_BinaryTreeLevelOrderTraversal;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author hustffx
 * @Date 2020/5/13 9:48
 */
public class BinaryTreeLevelOrderTraversal {
    /**
     * 方法1：迭代
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        List<Integer> level = new ArrayList<>();

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }

                level.add(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }

            if (!level.isEmpty()) {
                res.add(new ArrayList<>(level));
                level.clear();
            }
        }

        return res;
    }

    /**
     * 方法2：递归
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        levelOrder(root, 0, res);
        return res;
    }

    private void levelOrder(TreeNode node, int level, List<List<Integer>> res) {
        if (node == null) {
            return;
        }

        if (res.size() == level) {
            res.add(new ArrayList<>());
        }

        res.get(level).add(node.val);

        levelOrder(node.left, level + 1, res);
        levelOrder(node.right, level + 1, res);
    }
}
