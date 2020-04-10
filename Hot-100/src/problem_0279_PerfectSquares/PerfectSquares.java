package problem_0279_PerfectSquares;

/*
 * 279. 完全平方数
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）
 * 使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 示例 1:
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 *
 * 示例 2:
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 */

import java.util.*;

public class PerfectSquares {
    /**
     * 方法1：回溯
     */
    public int numSquares1(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        return numSquaresDFS(n, map);
    }


    private int numSquaresDFS(int n, HashMap<Integer, Integer> map) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int count = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            count = Math.min(count, numSquaresDFS(n - i * i, map) + 1);
        }
        map.put(n, count);
        return count;
    }

    /**
     * 方法2：动态规划
     */
    public int numSquares2(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    /**
     * 方法3：BFS
     */
    public int numSquares3(int n) {
        // 队列用于广度优先搜索
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        // 哈希表存储访问过的解
        HashSet<Integer> visited = new HashSet<>();
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int j = 1; j * j <= cur; j++) {
                    int next = cur - j * j;
                    if (next == 0) {
                        return level;
                    }
                    if (!visited.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
        }
        return -1;
    }

    /**
     * 方法4：数学方法
     * 四平方和定理：任何正整数都能表示成四个平方数的和，少于四个平方和的可以补零。
     * 三平方和定理：如果一个整数 n 可以被表示为三个数的平方和，那么 n != 4^a*(8*b+7)。
     */
    public int numSquares4(int n) {
        // 判断是否是 1
        if (isSquare(n)) {
            return 1;
        }
        int tmp = n;

        // 判断是否是 4
        while (tmp % 4 == 0) {
            tmp /= 4;
        }
        if (tmp % 8 == 7) {
            return 4;
        }

        // 判断是否是 2
        for (int i = 1; i * i < n; i++) {
            if (isSquare(n - i * i)) {
                return 2;
            }
        }

        return 3;
    }

    private boolean isSquare(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }
}
