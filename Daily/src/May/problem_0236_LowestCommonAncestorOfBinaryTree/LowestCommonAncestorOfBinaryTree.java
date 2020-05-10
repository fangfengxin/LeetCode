package May.problem_0236_LowestCommonAncestorOfBinaryTree;

/*
 * 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：
 * “对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *      3
 *     / \
 *    5   1
 *   / \ / \
 *  6  2 0  8
 *    / \
 *   7   4
 *
 * 示例 1:
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 *
 * 示例 2:
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *
 * 说明:
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 */

import utils.TreeNode;

/**
 * @Author hustffx
 * @Date 2020/5/10 10:47
 */
public class LowestCommonAncestorOfBinaryTree {
    /**
     * 方法：递归 + DFS
     * 在当前子树root中搜索节点p和节点q的最近公共祖先
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 搜索为空或者搜索到p节点或q节点，即返回
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }

        // 分别在当前节点root左右子树中寻找p节点和q节点
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 如果在当前节点root的某一个子树中搜索不到p节点或q节点，则p和q节点一定都在另一个子树中
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        // 左右子树中搜索到非空结果，则当前节点即为最近公共祖先
        return root;
    }
}
