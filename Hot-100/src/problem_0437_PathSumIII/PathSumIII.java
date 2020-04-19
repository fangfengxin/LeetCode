package problem_0437_PathSumIII;

/*
 * 437. 路径总和 III
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * 找出路径和等于给定数值的路径总数。
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 *
 * 示例：
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * 返回 3。和等于 8 的路径有:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 */

import utils.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Author hustffx
 * @Date 2020/4/19 15:44
 */
public class PathSumIII {
    /**
     * 方法：前缀和 + 回溯
     * 计算当前节点为路径终点的所有路径和
     * 存储每个节点的父节点。
     * 时间复杂度 O(N logN)
     */
    public int pathSum1(TreeNode root, int sum) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Map<TreeNode, Integer> prefixSum = new HashMap<>();
        return dfs(root, sum, parent, prefixSum);
    }

    /**
     * 递归计算路径和，借助前缀和与父节点
     *
     * @param root      当前节点
     * @param sum       目标路径和
     * @param parent    存储父子节点关系的哈希表
     * @param prefixSum 存储节点与前缀和关系的哈希表
     * @return
     */
    private int dfs(TreeNode root, int sum, Map<TreeNode, TreeNode> parent, Map<TreeNode, Integer> prefixSum) {
        if (root == null) {
            return 0;
        }

        int curSum = root.val + prefixSum.getOrDefault(root, 0);

        if (root.left != null) {
            parent.put(root.left, root);
            prefixSum.put(root.left, curSum);
        }

        if (root.right != null) {
            parent.put(root.right, root);
            prefixSum.put(root.right, curSum);
        }

        int count = 0;
        TreeNode node = root;
        while (node != null) {
            int tmpSum = curSum - prefixSum.getOrDefault(node, 0);
            if (tmpSum == sum) {
                count++;
            }
            node = parent.get(node);
        }

        int leftCount = dfs(root.left, sum, parent, prefixSum);
        int rightCount = dfs(root.right, sum, parent, prefixSum);

        return count + leftCount + rightCount;
    }

    /**
     * 方法2：优化方法1
     */
    public int pathSum2(TreeNode root, int sum) {
        return pathSumCount(root, sum, new int[1000], 0);
    }

    /**
     * 递归计算路径和
     *
     * @param root
     * @param sum
     * @param path  路径数组
     * @param index 当前路径终点索引
     * @return
     */
    private int pathSumCount(TreeNode root, int sum, int[] path, int index) {
        if (root == null) {
            return 0;
        }
        path[index] = root.val;
        int count = 0;
        int tmp = 0;
        for (int i = index; i >= 0; i--) {
            tmp += path[i];
            if (tmp == sum) {
                count++;
            }
        }
        int leftCount = pathSumCount(root.left, sum, path, index + 1);
        int rightCount = pathSumCount(root.right, sum, path, index + 1);
        return count + leftCount + rightCount;
    }

    /**
     * 方法3：栈 + 回溯
     */
    public int pathSum3(TreeNode root, int sum) {
        int count = 0;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) {
                continue;
            }
            count += countPath(node, sum);
            stack.push(node.right);
            stack.push(node.left);
        }
        return count;
    }

    /**
     * 计算以当前节点为起点的目标路径和数量
     *
     * @param root
     * @param sum
     * @return
     */
    private int countPath(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int count = sum == root.val ? 1 : 0;
        return count + countPath(root.left, sum - root.val) + countPath(root.right, sum - root.val);
    }
}
