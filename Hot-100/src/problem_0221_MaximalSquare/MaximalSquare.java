package problem_0221_MaximalSquare;

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
public class MaximalSquare {
    /**
     * 方法1：暴力破解
     * 参考第 85 题的暴力破解法
     */
    public int maximalSquare1(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        // 保存以当前数字结尾的连续 1 的个数
        int[][] width = new int[matrix.length][matrix[0].length];
        // 保存最大正方形的边长
        int maxHeight = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                // 更新 width
                width[row][col] = (matrix[row][col] == '1') ? (col == 0 ? 1 : width[row][col - 1] + 1) : 0;
                // 记录所有行中最小的值
                int minWidth = width[row][col];
                if (minWidth <= maxHeight) {
                    continue;
                }
                // 向上扩展行
                for (int i = row; i >= 0; i--) {
                    // 矩形的高
                    int height = row - i + 1;
                    // 矩形的宽
                    minWidth = Math.min(minWidth, width[i][col]);
                    // 宽比高小，后面不可能再找到正方形
                    if (height > minWidth) {
                        break;
                    }
                    // 找到一个正方形，更新 maxHeight
                    if (height == minWidth) {
                        maxHeight = Math.max(maxHeight, height);
                        break;
                    }
                }
            }
        }
        return maxHeight * maxHeight;
    }

    /**
     * 方法2：动态规划
     * dp[i][j] 表示以 matrix[i][j] 为右下角的正方形的最大边长。
     * 使用个技巧，行和列多申请一行，这样的话第一行和第一列的情况就不需要单独考虑了。
     */
    public int maximalSquare2(char[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) {
            return 0;
        }
        int cols = matrix[0].length;
        int[][] dp = new int[rows + 1][cols + 1];
        int maxSide = 0;
        // 遍历，注意下标
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i - 1][j - 1] == '0') {
                    dp[i][j] = 0;
                } else {
                    // 左边、上边、左上三个位置的最大正方形边长的最小值 + 1
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        return maxSide * maxSide;
    }
}
