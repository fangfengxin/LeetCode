package May.problem_0105_ConstructBinaryTreeFromPreorderAndInorderTraversal;

/*
 * 105. 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 注意: 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */

import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author hustffx
 * @Date 2020/5/22 10:58
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    /**
     * 方法：递归
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;

        if (preLen != inLen) {
            throw new IllegalArgumentException("Incorrect input data.");
        }

        // 建立哈希表存储中序遍历数值与数组下标的对应，避免频繁查找数组元素
        Map<Integer, Integer> map = new HashMap<>(preLen);
        for (int i = 0; i < inLen; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(preorder, 0, preLen - 1, map, 0, inLen - 1);
    }

    /**
     * 递归地创建二叉树
     *
     * @param preorder 前序遍历序列
     * @param preLeft  前序遍历序列子区间的左边界
     * @param preRight 前序遍历序列子区间的右边界
     * @param map      中序遍历序列中数值与下标的对应关系
     * @param inLeft   中序遍历序列子区间的左边界
     * @param inRight  中序遍历序列子区间的右边界
     * @return
     */
    private TreeNode buildTree(int[] preorder, int preLeft, int preRight,
                               Map<Integer, Integer> map, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }

        // 根节点
        int rootVal = preorder[preLeft];
        TreeNode root = new TreeNode(rootVal);

        // 找到前序遍历根节点在后序比那里中的位置
        int pIndex = map.get(rootVal);

        // 递归地创建左子树和右子树
        root.left = buildTree(preorder, preLeft + 1, pIndex - inLeft + preLeft,
                map, inLeft, pIndex - 1);
        root.right = buildTree(preorder, pIndex - inLeft + preLeft + 1, preRight,
                map, pIndex + 1, inRight);

        return root;
    }
}
