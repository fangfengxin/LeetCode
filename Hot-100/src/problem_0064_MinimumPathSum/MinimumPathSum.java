package problem_0064_MinimumPathSum;

/*
 * 64. 最小路径和
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 */
public class MinimumPathSum {
    /*
     * 方法1：暴力破解
     */
    public int minPathSum1(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        return minPathSum(grid, grid.length - 1, grid[0].length - 1);
    }

    private int minPathSum(int[][] grid, int row, int column) {
        if (row == 0 && column == 0) {
            return grid[0][0];
        }
        if (row == -1 || column == -1) {
            return Integer.MAX_VALUE;
        }
        return Math.min(minPathSum(grid, row, column - 1), minPathSum(grid, row - 1, column)) + grid[row][column];
    }

    /*
     * 方法2：二维动态规划
     */
    public int minPathSum2(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else if (i == 0) {
                    dp[i][j] = grid[i][j] + dp[i][j - 1];
                } else if (j == 0) {
                    dp[i][j] = grid[i][j] + dp[i - 1][j];
                } else {
                    dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }

    /*
     * 方法3：一维动态规划
     */
    public int minPathSum3(int[][] grid) {
        int[] dp = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[j] = grid[i][j];
                } else if (i == 0) {
                    dp[j] = grid[i][j] + dp[j - 1];
                } else if (j == 0) {
                    dp[j] = grid[i][j] + dp[j];
                } else {
                    dp[j] = grid[i][j] + Math.min(dp[j - 1], dp[j]);
                }
            }
        }
        return dp[grid[0].length - 1];
    }

    /*
     * 方法4：动态规划（不使用额外空间）
     */
    public int minPathSum4(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i != 0 || j != 0) {
                    if (i == 0) {
                        grid[i][j] += grid[i][j - 1];
                    } else if (j == 0) {
                        grid[i][j] += grid[i - 1][j];
                    } else {
                        grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
                    }
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
