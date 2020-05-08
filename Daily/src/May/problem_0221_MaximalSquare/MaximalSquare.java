package May.problem_0221_MaximalSquare;

/*
 * 221. 最大正方形
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * 示例:
 * 输入:
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * 输出: 4
 */

/**
 * @author hustffx
 * @date 2020/5/8 10:09
 */
public class MaximalSquare {
    /**
     * 方法：动态规划
     */
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        // 保存最大边长
        int maxSide = 0;
        // 保存以当前位置为右下角的最大正方形的边长
        int[][] dp = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                }

                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    // 左边、上边、左上三个位置的最大正方形边长的最小值 + 1
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }

                maxSide = Math.max(maxSide, dp[i][j]);
            }
        }

        return maxSide * maxSide;
    }
}
