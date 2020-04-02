package April.problem_0289_GameOfLife;

import java.util.Arrays;

/*
 * 289. 生命游戏
 * 生命游戏，简称为生命，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。
 * 每个细胞都具有一个初始状态：1 即为活细胞（live），或 0 即为死细胞（dead）。
 * 每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 *  1. 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 *  2. 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 *  3. 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 *  4. 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * 根据当前状态，写一个函数来计算面板上所有细胞的下一个（一次更新后的）状态。
 * 下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
 *
 * 示例：
 * 输入：
 * [
 *   [0,1,0],
 *   [0,0,1],
 *   [1,1,1],
 *   [0,0,0]
 * ]
 * 输出：
 * [
 *   [0,0,0],
 *   [1,0,1],
 *   [0,1,1],
 *   [0,1,0]
 * ]
 *  
 * 进阶：
 *  1. 你可以使用原地算法解决本题吗？
 *     请注意，面板上所有格子需要同时被更新：你不能先更新某些格子，然后使用它们的更新后的值再更新其他格子。
 *  2. 本题中，我们使用二维数组来表示面板。
 *     原则上，面板是无限的，但当活细胞侵占了面板边界时会造成问题。你将如何解决这些问题？
 */
public class GameOfLife {
    /**
     * 方法1：复制原数组进行模拟
     */
    public void gameOfLife1(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        // 邻居数组
        int[] neighbour = {-1, 0, 1};
        // 复制面板
        int[][] copyBoard = new int[rows][];
        for (int i = 0; i < rows; i++) {
            copyBoard[i] = Arrays.copyOf(board[i], cols);
        }
        // 遍历面板中每个细胞
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 统计当前细胞相邻8个位置的活细胞数量
                int live = 0;
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        if (neighbour[x] == 0 && neighbour[y] == 0) {
                            continue;
                        }
                        // 计算相邻位置坐标
                        int r = i + neighbour[x];
                        int c = j + neighbour[y];
                        if (r < 0 || r >= rows || c < 0 || c >= cols) {
                            continue;
                        }
                        if (copyBoard[r][c] == 1) {
                            live++;
                        }
                    }
                }
                // 规则1、3
                if (copyBoard[i][j] == 1 && (live < 2 || live > 3)) {
                    board[i][j] = 0;
                }
                // 规则4
                if (copyBoard[i][j] == 0 && live == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }

    /**
     * 方法2：定义复合状态
     * -1表示活细胞死亡
     * 2表示死细胞复活
     */
    public void gameOfLife2(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        // 邻居数组
        int[] neighbours = {-1, 0, 1};
        // 遍历面板中的每一个细胞
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // 统计当前细胞周围的活细胞数量
                int live = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (neighbours[i] == 0 && neighbours[j] == 0) {
                            continue;
                        }
                        // 相邻位置的坐标
                        int r = row + neighbours[i];
                        int c = col + neighbours[j];
                        if (r < 0 || r >= rows || c < 0 || c >= cols) {
                            continue;
                        }
                        if (board[r][c] == 1 || board[r][c] == -1) {
                            live++;
                        }
                    }
                }
                // 规则1、3
                if (board[row][col] == 1 && (live < 2 || live > 3)) {
                    // -1 代表这个细胞过去是活的现在死了
                    board[row][col] = -1;
                }
                // 规则4
                if (board[row][col] == 0 && live == 3) {
                    // 2 代表这个细胞过去是死的现在活了
                    board[row][col] = 2;
                }
            }
        }
        // 遍历面板获得一次更新后的状态
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                board[row][col] = board[row][col] > 0 ? 1 : 0;
            }
        }
    }
}
