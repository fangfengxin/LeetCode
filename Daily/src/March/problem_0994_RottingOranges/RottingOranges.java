package March.problem_0994_RottingOranges;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 994. 腐烂的橘子
 * 在给定的网格中，每个单元格可以有以下三个值之一：
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
 * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
 *
 * 示例 1：
 * 输入：
 * [[2,1,1],
 *  [1,1,0],
 *  [0,1,1]]
 * 输出：4
 *
 * 示例 2：
 * 输入：
 * [[2,1,1],
 *  [0,1,1],
 *  [1,0,1]]
 * 输出：-1
 * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
 *
 * 示例 3：
 * 输入：[[0,2]]
 * 输出：0
 * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
 *
 * 提示：
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * grid[i][j] 仅为 0、1 或 2
 */
public class RottingOranges {
    /**
     * 方法：多源广度优先搜索
     */
    public int orangesRotting(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        // 将所有腐烂橘子所在格子放入队列
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        // 广度优先搜索
        int level = -1;
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] node = queue.poll();
                for (int[] dir : direction) {
                    int x = node[0] + dir[0];
                    int y = node[1] + dir[1];
                    if (x < 0 || x >= M || y < 0 || y >= N || grid[x][y] != 1) {
                        continue;
                    }
                    queue.offer(new int[]{x, y});
                    grid[x][y] = 2;
                }
            }
        }
        // 最后格子中还有新鲜橘子时，返回 -1
        for (int[] row : grid) {
            for (int col : row) {
                if (col == 1) {
                    return -1;
                }
            }
        }
        // 当格子中原本全是空的时，应返回 0
        return level == -1 ? 0 : level;
    }
}
