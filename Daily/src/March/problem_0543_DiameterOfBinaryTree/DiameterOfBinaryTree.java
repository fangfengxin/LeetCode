package March.problem_0543_DiameterOfBinaryTree;

/*
 * 给定一棵二叉树，你需要计算它的直径长度。
 * 一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 *
 * 示例 :
 * 给定二叉树
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 */
public class DiameterOfBinaryTree {
    /*
     * 方法：深度优先遍历
     */
    public int diameterOfBinaryTree(TreeNode root) {
        TreeNode res = new TreeNode(1);
        depth(root, res);
        return res.val - 1;
    }

    private int depth(TreeNode root, TreeNode res) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left, res);
        int right = depth(root.right, res);
        res.val = Math.max(res.val, left + right + 1);
        return Math.max(left, right) + 1;
    }
}
