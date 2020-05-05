package May.problem_0098_ValidateBinarySearchTree;
/*
 * 98. 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 * 1. 节点的左子树只包含小于当前节点的数。
 * 2.节点的右子树只包含大于当前节点的数。
 * 3. 所有左子树和右子树自身必须也是二叉搜索树。
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
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 */

import utils.TreeNode;

import java.util.LinkedList;

/**
 * @Author hustffx
 * @Date 2020/5/5 17:30
 */
public class ValidateBinarySearchTree {
    /**
     * 保存树节点
     */
    private final LinkedList<TreeNode> stack = new LinkedList<>();
    /**
     * 保存树节点对应的下界
     */
    private final LinkedList<Integer> lowers = new LinkedList<>();
    /**
     * 保存树节点对应的上界
     */
    private final LinkedList<Integer> uppers = new LinkedList<>();

    /**
     * 方法1：递归
     */
    public boolean isValidBST1(TreeNode root) {
        return recurse(root, null, null);
    }

    /**
     * 判断当前节点 root 的值是否在 [lower, upper] 中
     *
     * @param root
     * @param lower 下界
     * @param upper 上界
     * @return
     */
    private boolean recurse(TreeNode root, Integer lower, Integer upper) {
        // 回归条件：空节点是合理的二叉搜索树
        if (root == null) {
            return true;
        }

        // 节点不为空，判断当前节点值是否在上下界内
        int val = root.val;
        // 比下界小
        if (lower != null && val <= lower) {
            return false;
        }
        // 比上界大
        if (upper != null && val >= upper) {
            return false;
        }

        // 递归
        if (!recurse(root.left, lower, val)) {
            return false;
        }
        if (!recurse(root.right, val, upper)) {
            return false;
        }

        return true;
    }

    /**
     * 方法2：迭代
     */
    public boolean isValidBST2(TreeNode root) {
        Integer val;
        Integer lower = null;
        Integer upper = null;
        update(root, lower, upper);

        // 每次从栈中取出一个节点
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            lower = lowers.pop();
            upper = uppers.pop();

            if (node == null) {
                continue;
            }

            // 节点不为空，判断当前节点值是否在上下界内
            val = node.val;
            if (lower != null && val <= lower) {
                return false;
            }
            if (upper != null && val >= upper) {
                return false;
            }

            // 比较过后继续把左子节点和右子节点加入栈中
            update(node.left, lower, val);
            update(node.right, val, upper);
        }

        return true;
    }

    /**
     * 将当前节点和节点对应的上下界存入对应的栈中
     *
     * @param root  节点
     * @param lower 下界
     * @param upper 上界
     */
    private void update(TreeNode root, Integer lower, Integer upper) {
        stack.push(root);
        lowers.push(lower);
        uppers.push(upper);
    }

    /**
     * 方法3：中序遍历
     * 左子树 -> 当前节点 -> 右子树
     * 在二叉搜索树中，中序遍历的过程应该是严格递增的。
     * 检查中序遍历的每个元素是否小于下一个元素。
     */
    public boolean isValidBST3(TreeNode root) {
        // stack存储未被访问的节点
        LinkedList<TreeNode> stack = new LinkedList<>();
        // inorder保存上一个中序遍历到的节点的值
        Integer inorder = null;

        // 中序遍历
        while (!stack.isEmpty() || root != null) {
            // 不断将当前节点的左子节点加入，直到没有剩余的左子节点
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            // 将当前子树最左节点取出
            root = stack.pop();
            // 比较节点值是否大于inorder，如果小于等于inorder，则二叉搜索树不合理
            if (inorder != null && root.val <= inorder) {
                return false;
            }

            // 更新inorder
            inorder = root.val;
            // 继续遍历当前节点的右子树
            root = root.right;
        }

        return true;
    }
}
