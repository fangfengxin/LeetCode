package April.problem_0200_NumberOfIslands;

/*
 * 200. 岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * 示例 1:
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 *
 * 示例 2:
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 输出: 3
 * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 */

import java.util.HashSet;
import java.util.LinkedList;

/**
 * @Author hustffx
 * @Date 2020/4/20 11:04
 */
public class NumberOfIslands {
    /**
     * 并查集数组，存储父节点位置
     */
    private int[] parent;

    /**
     * 方法1：BFS
     */
    public int numIslands1(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        int num = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    num++;
                    expandIsland(grid, row, col);
                }
            }
        }

        return num;
    }

    /**
     * 寻找当前的陆地范围进行标记
     *
     * @param grid
     * @param row
     * @param col
     */
    private void expandIsland(char[][] grid, int row, int col) {
        // 经过的陆地标记为2
        grid[row][col] = '2';
        // 相邻位置数组
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        // BFS
        LinkedList<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            for (int[] direction : directions) {
                int i = node[0] + direction[0];
                int j = node[1] + direction[1];
                if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
                    continue;
                }
                if (grid[i][j] == '1') {
                    grid[i][j] = '2';
                    queue.offer(new int[]{i, j});
                }
            }
        }
    }

    /**
     * 方法2：DFS
     */
    public int numIslands2(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    num++;
                    dfs(grid, i, j);
                }
            }
        }

        return num;
    }

    /**
     * 扩展岛屿范围
     *
     * @param grid
     * @param i 横坐标
     * @param j 纵坐标
     */
    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] == '1') {
            grid[i][j] = '2';
            dfs(grid, i - 1, j);
            dfs(grid, i + 1, j);
            dfs(grid, i, j - 1);
            dfs(grid, i, j + 1);
        }
    }

    /**
     * 方法3：带路径压缩的并查集
     */
    public int numIslands3(char[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        // 初始化并查集
        parent = new int[m * n];
        for (int i = 0; i < m * n; i++) {
            parent[i] = i;
        }
        // 相邻位置数组
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }
                int index1 = i * n + j;
                for (int[] direction : directions) {
                    int x = i + direction[0];
                    int y = j + direction[1];
                    if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == '0') {
                        continue;
                    }
                    int index2 = x * n + y;
                    union(index1, index2);
                }
            }
        }
        // 存储连通集根节点
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    set.add(find(i * n + j));
                }
            }
        }
        return set.size();
    }

    /**
     * 寻找当前元素所在连通集的根节点。
     * 将路径上的节点的父节点都更改为最终找到的结果，实现路径压缩。
     *
     * @param index 当前元素下标
     * @return
     */
    private int find(int index) {
        if (index != parent[index]) {
            parent[index] = find(parent[index]);
        }
        return parent[index];
    }

    /**
     * 合并两个连通集
     *
     * @param index1 连通集元素1
     * @param index2 连通集元素2
     */
    private void union(int index1, int index2) {
        int p1 = find(index1);
        int p2 = find(index2);
        // 本身就在一个连通集
        if (p1 == p2) {
            return;
        }
        // 将连通集合并
        parent[p1] = p2;
    }
}
