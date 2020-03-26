package problem_0098_ValidateBinarySearchTree;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * 98. 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 示例 1:
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 *
 * 示例 2:
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,null,null,4,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 */
public class ValidateBinarySearchTree {
    /*
     * 方法1：前序 + 递归
     */
    public boolean isValidBST1(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, Integer lower, Integer upper) {
        /*if (root == null) {
            return true;
        }
        if (lower != null && root.val <= lower) {
            return false;
        }
        if (upper != null && root.val >= upper) {
            return false;
        }
        if (!isValidBST(root.left, lower, root.val)) {
            return false;
        }
        if (!isValidBST(root.right, root.val, upper)) {
            return false;
        }
        return true;*/

        return (root == null)
                || (lower == null || root.val > lower)
                && (upper == null || root.val < upper)
                && isValidBST(root.left, lower, root.val)
                && isValidBST(root.right, root.val, upper);
    }

    /*
     * 方法2：前序 + 栈
     */
    public boolean isValidBST2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> lower = new Stack<>();
        Stack<Integer> upper = new Stack<>();

        TreeNode node = root;
        Integer low = null;
        Integer up = null;

        stack.push(node);
        lower.push(low);
        upper.push(up);

        while (!stack.isEmpty()) {
            node = stack.pop();
            low = lower.pop();
            up = upper.pop();

            if (node == null) {
                continue;
            }

            if (low != null && node.val <= low) {
                return false;
            }

            if (up != null && node.val >= up) {
                return false;
            }

            stack.push(node.right);
            lower.push(node.val);
            upper.push(up);

            stack.push(node.left);
            lower.push(low);
            upper.push(node.val);
        }
        return true;
    }

    /*
     * 方法3：广度优先 + 队列
     */
    public boolean isValidBST3(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> lower = new LinkedList<>();
        Queue<Integer> upper = new LinkedList<>();

        TreeNode node = root;
        Integer low = null;
        Integer up = null;

        queue.offer(node);
        lower.offer(low);
        upper.offer(up);

        while (!queue.isEmpty()) {
            node = queue.poll();
            low = lower.poll();
            up = upper.poll();

            if (node == null) {
                continue;
            }

            if (low != null && node.val <= low) {
                return false;
            }

            if (up != null && node.val >= up) {
                return false;
            }

            queue.offer(node.right);
            lower.offer(node.val);
            upper.offer(up);

            queue.offer(node.left);
            lower.offer(low);
            upper.offer(node.val);
        }
        return true;
    }

    /*
     * 方法4：中序 + 栈
     */
    public boolean isValidBST4(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        Integer lastVal = null;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (lastVal != null && lastVal >= node.val) {
                return false;
            }
            lastVal = node.val;
            node = node.right;
        }
        return true;
    }

    /*
     * 方法5：中序 + 递归
     */
    long lastVal = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        /*if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (root.val <= lastVal) {
            return false;
        }
        lastVal = root.val;
        if (!isValidBST(root.right)) {
            return false;
        }
        return true;*/

        return (root == null)
                || isValidBST(root.left)
                && lastVal < (lastVal = root.val)
                && isValidBST(root.right);
    }
}
