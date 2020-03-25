package problem_0096_UniqueBinarySearchTrees;

/*
 * 96. 不同的二叉搜索树
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 示例:
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
public class UniqueBinarySearchTrees {
    /*
     * 方法：动态规划
     * 给定一个有序序列 1 ... n，为了根据序列构建一棵二叉搜索树，
     * 遍历每个数字 i，将该数字作为树根，1 ... (i-1) 序列将成为左子树，(i+1) ... n 序列将成为右子树。
     * 于是，我们可以递归地从子序列构建子树。由于根各自不同，每棵二叉树都保证是独特的。
     * 定义两个函数：
     * 1. G(n): 长度为 n 的序列的不同二叉搜索树个数。
     * 2. F(i,n): 长度为 n 的以 i 为根的不同二叉搜索树个数 (1 <= i <= n)。
     * 可推出 G(0）= G(1) = 1，G(n) = F(1,n) + ... + F(n,n)，F(i,n) = G(i-1)G(n-i)
     * 则 G(n) = G(0)G(n-1) + G(1)G(n-2) + ... + G(n-1)G(0)
     */
    public int numTrees(int n) {
        int[] nums = new int[n + 1];
        nums[0] = 1;
        nums[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                nums[i] += nums[j - 1] * nums[i - j];
            }
        }
        return nums[n];
    }
}
