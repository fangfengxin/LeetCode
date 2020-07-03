package July.problem_0108_ConvertSortedArrayToBinarySearchTree;

/*
 * 108. 将有序数组转换为二叉搜索树
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例: 给定有序数组: [-10,-3,0,5,9],
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */

import utils.TreeNode;

/**
 * @Author hustffx
 * @Date 2020/7/3 16:33
 */
public class ConvertSortedArrayToBinarySearchTree {
    /**
     * 方法：根据中序遍历构造BST
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    /**
     * 递归构建BST
     *
     * @param nums
     * @param start
     * @param end
     * @return
     */
    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        // 选择中间位置作为根节点
        int mid = start + (end - start + 1) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = sortedArrayToBST(nums, start, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, end);

        return root;
    }
}
