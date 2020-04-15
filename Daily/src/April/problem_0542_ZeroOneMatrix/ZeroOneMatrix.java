package April.problem_0542_ZeroOneMatrix;

/*
 * 542. 01 矩阵
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 * 两个相邻元素间的距离为 1 。
 *
 * 示例 1:
 * 输入:
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 输出:
 * 0 0 0
 * 0 1 0
 * 0 0 0
 *
 * 示例 2:
 * 输入:
 * 0 0 0
 * 0 1 0
 * 1 1 1
 * 输出:
 * 0 0 0
 * 0 1 0
 * 1 2 1
 *
 * 注意:
 * 1. 给定矩阵的元素个数不超过 10000。
 * 2. 给定矩阵中至少有一个元素是 0。
 * 3. 矩阵中的元素只在四个方向上相邻: 上、下、左、右。
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {
    /**
     * 方法1：多源BFS
     * 以值为 0 的点作为源点
     */
    public int[][] updateMatrix1(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return null;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        // 结果矩阵
        int[][] res = new int[rows][cols];
        // 用于多源 BFS 的队列
        Queue<int[]> queue = new LinkedList<>();
        // 使用哈希表存储已经访问过的点
        boolean[][] visited = new boolean[rows][cols];
        // 将等于 0 的源点入队
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == 0) {
                    queue.offer(new int[]{row, col});
                    visited[row][col] = true;
                }
            }
        }
        // 在四个方向上进行 BFS
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        // BFS
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
                for (int[] direction : directions) {
                    int x = node[0] + direction[0];
                    int y = node[1] + direction[1];
                    if (x < 0 || x >= rows || y < 0 || y >= cols || visited[x][y]) {
                        continue;
                    }
                    // 更新距离值
                    res[x][y] = level;
                    queue.offer(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
        return res;
    }

    /**
     * 方法2：动态规划
     */
    public int[][] updateMatrix2(int[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) {
            return null;
        }
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        // 将矩阵填充为一个较大值
        for (int i = 0; i < rows; i++) {
            Arrays.fill(dp[i], rows + cols);
        }
        // 将矩阵中的 0 对应距离设置为 0
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == 0) {
                    dp[row][col] = 0;
                }
            }
        }
        // dp 从左上到右下
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (row > 0) {
                    dp[row][col] = Math.min(dp[row][col], dp[row - 1][col] + 1);
                }
                if (col > 0) {
                    dp[row][col] = Math.min(dp[row][col], dp[row][col - 1] + 1);
                }
            }
        }
        // dp 从右下到左上
        for (int row = rows - 1; row >= 0; row--) {
            for (int col = cols - 1; col >= 0; col--) {
                if (row < rows - 1) {
                    dp[row][col] = Math.min(dp[row][col], dp[row + 1][col] + 1);
                }
                if (col < cols - 1) {
                    dp[row][col] = Math.min(dp[row][col], dp[row][col + 1] + 1);
                }
            }
        }
        return dp;
    }
}
