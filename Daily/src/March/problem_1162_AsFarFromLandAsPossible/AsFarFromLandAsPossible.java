package March.problem_1162_AsFarFromLandAsPossible;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 1162. 地图分析
 * 你现在手里有一份大小为 N x N 的『地图』（网格） grid。
 * 上面的每个『区域』（单元格）都用 0 和 1 标记好了。其中 0 代表海洋，1 代表陆地。
 * 你知道距离陆地区域最远的海洋区域是是哪一个吗？
 * 请返回该海洋区域到离它最近的陆地区域的距离。
 * 我们这里说的距离是『曼哈顿距离』（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个区域之间的距离是 |x0 - x1| + |y0 - y1| 。
 * 如果我们的地图上只有陆地或者海洋，请返回 -1。
 *
 * 示例 1：
 * 输入：
 * [[1,0,1],
 *  [0,0,0],
 *  [1,0,1]]
 * 输出：2
 * 解释：海洋区域 (1, 1) 和所有陆地区域之间的距离都达到最大，最大距离为 2。
 *
 * 示例 2：
 * 输入：
 * [[1,0,0],
 *  [0,0,0],
 *  [0,0,0]]
 * 输出：4
 * 解释：海洋区域 (2, 2) 和所有陆地区域之间的距离都达到最大，最大距离为 4。
 *
 * 提示：
 * 1 <= grid.length == grid[0].length <= 100
 * grid[i][j] 不是 0 就是 1
 */
public class AsFarFromLandAsPossible {
    /**
     * 方法1：广度优先搜索
     * 1.找到所有陆地放入队列
     * 2.BFS遍历，往上下左右四个方向
     * 3.遍历结束时，遍历层数就是海洋到陆地的最远距离
     */
    public int maxDistance1(int[][] grid) {
        int N = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        // 找到所有陆地加入队列
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        // 如果只有陆地或者海洋，返回-1
        if (queue.isEmpty() || queue.size() == N * N) {
            return -1;
        }
        int distance = -1;
        int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            distance++;
            int n = queue.size();
            // 逐一取出当前层的 n 个节点，遍历过的节点设为-1
            for (int i = 0; i < n; i++) {
                int[] node = queue.poll();
                // 将四个相邻节点加入队列
                for (int[] dir : direction) {
                    int x = node[0] + dir[0];
                    int y = node[1] + dir[1];
                    if (x < 0 || x >= N || y < 0 || y >= N || grid[x][y] == -1) {
                        continue;
                    }
                    if (grid[x][y] == 0) {
                        queue.offer(new int[]{x, y});
                        grid[x][y] = -1;
                    }
                }
            }
        }
        return distance;
    }

    /**
     * 方法2：动态规划
     */
    public int maxDistance2(int[][] grid) {
        int N = grid.length;
        int[][] dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = grid[i][j] == 1 ? 0 : N * 2;
            }
        }

        // 从左往右，从上往下
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    continue;
                }
                if (i > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                }
                if (j > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                }
            }
        }

        // 从右往左，从下往上
        for (int i = N - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    continue;
                }
                if (i < N - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                }
                if (j < N - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                res = Math.max(res, dp[i][j]);
            }
        }

        return (res == 0 || res == N * 2) ? -1 : res;
    }
}
