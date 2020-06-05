package June.problem_lcof_29_SpiralMatrix;

/*
 * 面试题29. 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 *
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * 限制：
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 */

/**
 * @Author hustffx
 * @Date 2020/6/5 13:45
 */
public class SpiralMatrix {
    public int[] spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) {
            return new int[0];
        }

        int cols = matrix[0].length;
        if (cols == 0) {
            return new int[0];
        }

        boolean[][] visited = new boolean[rows][cols];

        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;

        int total = rows * cols;
        int[] order = new int[total];
        int row = 0;
        int col = 0;

        for (int i = 0; i < total; i++) {
            order[i] = matrix[row][col];
            visited[row][col] = true;

            int[] direction = directions[directionIndex];
            int m = row + direction[0];
            int n = col + direction[1];

            if (m < 0 || m >= rows || n < 0 || n >= cols || visited[m][n]) {
                directionIndex = (directionIndex + 1) % 4;
            }

            row += directions[directionIndex][0];
            col += directions[directionIndex][1];
        }

        return order;
    }
}
