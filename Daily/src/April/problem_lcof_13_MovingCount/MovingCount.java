package April.problem_lcof_13_MovingCount;

/*
 * 面试题13. 机器人的运动范围
 * 地上有一个 m 行 n 列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为 3+5+3+7=18。
 * 但它不能进入方格 [35, 38]，因为 3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 * 示例 1：
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 *
 * 示例 1：
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 *
 * 提示：
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 */
public class MovingCount {
    /**
     * 方法：DFS / BFS
     */
    public int movingCount(int m, int n, int k) {
        return dfs(m, n, k, 0, 0, 0, 0, new boolean[m][n]);
    }

    private int dfs(int m, int n, int k, int i, int j, int si, int sj, boolean[][] visited) {
        if (i < 0 || i >= m || j < 0 || j >= n || k < si + sj || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        return 1 + dfs(m, n, k, i + 1, j, (i + 1) % 10 == 0 ? si - 8 : si + 1, sj, visited)
                + dfs(m, n, k, i, j + 1, si, (j + 1) % 10 == 0 ? sj - 8 : sj + 1, visited);
    }
}
