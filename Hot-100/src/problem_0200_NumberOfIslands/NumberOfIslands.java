package problem_0200_NumberOfIslands;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 200. 岛屿数量
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
 * 一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。
 * 你可以假设网格的四个边均被水包围。
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
 */
public class NumberOfIslands {
    // 相邻位置遍历数组
    private int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    /**
     * 方法1：广度优先搜索
     * 也可以使用回溯算法，原理类似
     */
    public int numIslands1(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int num = 0;

        int rows = grid.length;
        int cols = grid[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '1') {
                    num++;
                    extendIsland(grid, row, col);
                }
            }
        }
        return num;
    }

    /**
     * 标记当前岛屿的范围
     */
    private void extendIsland(char[][] grid, int row, int col) {
        grid[row][col] = '2';
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            for (int[] direction : directions) {
                int i = pos[0] + direction[0];
                int j = pos[1] + direction[1];
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
     * 方法2：并查集
     * 遍历二维网格，将竖直或水平相邻的陆地联结。
     * 最终，返回并查集数据结构中相连部分的数量。
     * 并查集详解：https://blog.csdn.net/qq_41593380/article/details/81146850
     */
    public int numIslands2(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        UnionFind unionFind = new UnionFind(grid);
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                int index1 = i * cols + j;
                if (grid[i][j] == '0') {
                    continue;
                }
                grid[i][j] = '0';
                // 查找左边陆地
                if (j > 0 && grid[i][j - 1] == '1') {
                    int index2 = index1 - 1;
                    unionFind.union(index1, index2);
                }
                // 查找上方陆地
                if (i > 0 && grid[i - 1][j] == '1') {
                    int index3 = index1 - cols;
                    unionFind.union(index1, index3);
                }
            }
        }
        return unionFind.getCount();
    }

    /**
     * 定义并查集类
     */
    static class UnionFind {
        private int count;
        private int[] parent;
        private int[] rank;

        /**
         * 通过 grid 数组初始化并查集
         *
         * @param grid 网格数组
         */
        public UnionFind(char[][] grid) {
            count = 0;
            int rows = grid.length;
            int cols = grid[0].length;
            parent = new int[rows * cols];
            rank = new int[rows * cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    int index = i * cols + j;
                    if (grid[i][j] == '1') {
                        parent[index] = index;
                        count++;
                    }
                }
            }
        }

        /**
         * 寻找根节点，并将父节点更新为根节点
         *
         * @param index 节点下标
         */
        private int findParent(int index) {
            if (parent[index] == index) {
                return index;
            }
            // 路径压缩
            parent[index] = findParent(parent[index]);
            return parent[index];
        }

        /**
         * 连接两个节点
         *
         * @param x 节点下标
         * @param y 节点下标
         */
        public void union(int x, int y) {
            int rootX = findParent(x);
            int rootY = findParent(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
                count--;
            }
        }

        /**
         * 获取并查集中相连部分的数量
         */
        public int getCount() {
            return count;
        }
    }
}
