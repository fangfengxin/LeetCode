package problem_0236_LowestCommonAncestorOfBinaryTree;

import utils.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

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
public class LowestCommonAncestorOfBinaryTree {
    /**
     * 方法1：递归
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        return lowestCommonAncestor(root, p, q);
    }

    private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 当前节点是空或是节点 p 或是节点 q，返回当前节点
        if (root == null || root == p || root == q) {
            return root;
        }
        // 在左子树中寻找 p 和 q 的最近公共祖先
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 在右子树中寻找 p 和 q 的最近公共祖先
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 左子树中没有找到，一定在右子树中
        if (left == null) {
            return right;
        }
        // 右子树中没有找到，一定在左子树中
        if (right == null) {
            return left;
        }
        // 左右子树都找到了，则节点 p 和 q 分别在当前节点的左右子树中，最近公共祖先即为当前节点
        return root;
    }

    /**
     * 方法2：找到两条路径找到分叉点
     * 寻找路径的话，一开始不知道该向左还是向右，所以采取遍历整个树，直到找到了 p 和 q。
     * 然后从 p 和 q 开始，通过 hashMap 存储的每个节点的父节点，就可以倒着遍历回去确定路径。
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        // 存储节点及其父节点，便于逆路径遍历
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        // 借助栈实现中序遍历
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        parent.put(root, null);
        // 遍历树的所有节点，指直到找到 p 和 q
        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                stack.push(node.left);
                parent.put(node.left, node);
            }
            if (node.right != null) {
                stack.push(node.right);
                parent.put(node.right, node);
            }
        }
        // 存储 p 到 root 路径上的所有节点
        HashSet<TreeNode> path = new HashSet<>();
        while (p != null) {
            path.add(p);
            p = parent.get(p);
        }
        // 逆路径遍历 q 到 root 的路径，判断节点是否在 path 中
        while (q != null) {
            if (path.contains(q)) {
                break;
            }
            q = parent.get(q);
        }
        return q;
    }
}
