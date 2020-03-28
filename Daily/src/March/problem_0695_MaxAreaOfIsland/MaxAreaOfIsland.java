package March.problem_0695_MaxAreaOfIsland;

import java.util.LinkedList;

/*
 * 695. 岛屿的最大面积
 * 给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。你可以假设二维矩阵的四个边缘都被水包围着。
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
 *
 * 示例 1:
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 对于上面这个给定矩阵应返回 6。注意答案不应该是11，因为岛屿只能包含水平或垂直的四个方向的‘1’。
 *
 * 示例 2:
 * [[0,0,0,0,0,0,0,0]]
 * 对于上面这个给定的矩阵, 返回 0。
 *
 * 注意: 给定的矩阵 grid 的长度和宽度都不超过 50。
 */
public class MaxAreaOfIsland {
    /*
     * 方法1：深度优先搜索
     */
    public int maxAreaOfIsland1(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, dfs(grid, i, j));
                }
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0) {
            return 0;
        }
        // 当前土地计算后设置为0，防止重复计数
        grid[i][j] = 0;
        return 1 + dfs(grid, i - 1, j) + dfs(grid, i + 1, j) + dfs(grid, i, j - 1) + dfs(grid, i, j + 1);
    }

    /*
     * 方法2：深度优先搜索+栈
     */
    public int maxAreaOfIsland2(int[][] grid) {
        int res = 0;
        LinkedList<int[]> stack = new LinkedList<>();
        int[][] moveIndexArray = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int cur = 0;
                stack.push(new int[]{i, j});
                while (!stack.isEmpty()) {
                    int[] pop = stack.pop();
                    int curI = pop[0];
                    int curJ = pop[1];
                    if (curI < 0 || curJ < 0 || curI >= grid.length || curJ >= grid[curI].length || grid[curI][curJ] == 0) {
                        continue;
                    }
                    cur++;
                    grid[curI][curJ] = 0;
                    for (int[] moveIndex : moveIndexArray) {
                        stack.push(new int[]{curI + moveIndex[0], curJ + moveIndex[1]});
                    }
                }
                res = Math.max(res, cur);
            }
        }
        return res;
    }
}
