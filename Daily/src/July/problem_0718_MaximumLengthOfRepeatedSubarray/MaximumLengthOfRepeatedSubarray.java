package July.problem_0718_MaximumLengthOfRepeatedSubarray;

/*
 * 718. 最长重复子数组
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 *
 * 示例:
 * 输入:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出: 3
 * 解释: 长度最长的公共子数组是 [3, 2, 1]。
 *
 * 说明:
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 */

/**
 * @Author hustffx
 * @Date 2020/7/1 11:52
 */
public class MaximumLengthOfRepeatedSubarray {
    /**
     * 方法：动态规划
     */
    public int findLength1(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;

        int maxLen = 0;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }

                maxLen = Math.max(maxLen, dp[i][j]);
            }
        }

        return maxLen;
    }
}
