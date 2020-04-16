package problem_0337_HouseRobberIII;

/*
 * 337. 打家劫舍 III
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。
 * 这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。
 * 一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 *
 * 示例 1:
 * 输入: [3,2,3,null,3,null,1]
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 *
 * 示例 2:
 * 输入: [3,4,5,1,3,null,1]
 *      3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
 */

import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberIII {
    /**
     * 方法1：暴力递归
     * 4 个孙子节点偷的钱 + 当前节点的钱 vs. 两个子节点偷的钱
     * 哪个组合钱多，就当做当前节点能偷的最大钱数。
     */
    public int rob1(TreeNode root) {
        return getMax(root);
    }

    /**
     * 逐层递归获取可盗取的最大金额
     *
     * @param root
     * @return
     */
    private int getMax(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int money = root.val;

        money += (root.left == null) ? 0 : getMax(root.left.left) + getMax(root.left.right);
        money += (root.right == null) ? 0 : getMax(root.right.left) + getMax(root.right.right);

        return Math.max(money, getMax(root.left) + getMax(root.right));
    }

    /**
     * 方法2：记忆化递归 + 哈希表
     */
    public int rob2(TreeNode root) {
        return robMax(root, new HashMap<>());
    }

    /**
     * 通过哈希表记录递归子问题结果，获取可盗取的最大金额
     *
     * @param root
     * @param map
     * @return
     */
    private int robMax(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) {
            return 0;
        }

        if (map.containsKey(root)) {
            return map.get(root);
        }

        int money = root.val;
        money += (root.left == null) ? 0 : robMax(root.left.left, map) + robMax(root.left.right, map);
        money += (root.right == null) ? 0 : robMax(root.right.left, map) + robMax(root.right.right, map);

        int result = Math.max(money, robMax(root.left, map) + robMax(root.right, map));
        map.put(root, result);
        return result;
    }

    /**
     * 方法3：动态规划
     * 每个节点可选择偷或者不偷两种状态，根据题目意思，相连节点不能一起偷
     * 当前节点选择偷时，那么两个孩子节点就不能选择偷了
     * 当前节点选择不偷时，两个孩子节点只需要拿最多的钱出来就行(两个孩子节点偷不偷没关系
     */
    public int rob3(TreeNode root) {
        int[] result = robInternal(root);
        return Math.max(result[0], result[1]);
    }

    private int[] robInternal(TreeNode root) {
        int[] result = new int[2];
        if (root == null) {
            return result;
        }

        int[] left = robInternal(root.left);
        int[] right = robInternal(root.right);

        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = left[0] + right[0] + root.val;

        return result;
    }
}
