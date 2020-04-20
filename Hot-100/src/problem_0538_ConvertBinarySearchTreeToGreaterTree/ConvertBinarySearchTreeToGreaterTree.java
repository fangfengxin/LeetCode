package problem_0538_ConvertBinarySearchTreeToGreaterTree;

/*
 * 538. 把二叉搜索树转换为累加树
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 * 例如：
 * 输入: 原始二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 */

import utils.TreeNode;

import java.util.Stack;

/**
 * @Author hustffx
 * @Date 2020/4/20 22:39
 */
public class ConvertBinarySearchTreeToGreaterTree {
    /**
     * 计算所有大于当前元素值的累计和
     */
    private int sum = 0;

    /**
     * 方法1：反向中序遍历 + 递归
     *
     * @param root
     * @return
     */
    public TreeNode convertBST1(TreeNode root) {
        return convertBST(root);
    }

    /**
     * 回溯计算累计和
     *
     * @param root
     * @return
     */
    private TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        convertBST(root.right);
        root.val += sum;
        sum = root.val;
        convertBST(root.left);
        return root;
    }

    /**
     * 方法2：反向中序遍历 + 迭代 + 栈
     */
    public TreeNode convertBST2(TreeNode root) {
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            // 当前节点到最右节点路径上的所有节点入栈
            while (node != null) {
                stack.push(node);
                node = node.right;
            }
            // 取出当前未访问节点中的最大节点
            node = stack.pop();
            sum += node.val;
            node.val = sum;
            // 转向左子树
            node = node.left;
        }
        return root;
    }

    /**
     * 方法3：反序中序 Morris 遍历（不懂）
     */
    public TreeNode convertBST3(TreeNode root) {
        int sum = 0;
        TreeNode node = root;

        while (node != null) {
            /*
             * If there is no right subtree, then we can visit this node and
             * continue traversing left.
             */
            if (node.right == null) {
                sum += node.val;
                node.val = sum;
                node = node.left;
            }
            /*
             * If there is a right subtree, then there is at least one node that
             * has a greater value than the current one. therefore, we must
             * traverse that subtree first.
             */
            else {
                TreeNode succ = getSuccessor(node);
                /*
                 * If the left subtree is null, then we have never been here before.
                 */
                if (succ.left == null) {
                    succ.left = node;
                    node = node.right;
                }
                /*
                 * If there is a left subtree, it is a link that we created on a
                 * previous pass, so we should unlink it and visit this node.
                 */
                else {
                    succ.left = null;
                    sum += node.val;
                    node.val = sum;
                    node = node.left;
                }
            }
        }

        return root;
    }

    /**
     * Get the node with the smallest value greater than this one.
     */
    private TreeNode getSuccessor(TreeNode node) {
        TreeNode succ = node.right;
        while (succ.left != null && succ.left != node) {
            succ = succ.left;
        }
        return succ;
    }
}
