package problem_0070_ClimbingStairs;

/*
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 * 输入：2
 * 输出：2
 * 解释： 有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 *
 * 示例 2：
 * 输入：3
 * 输出：3
 * 解释： 有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 */

import java.util.LinkedList;

/**
 * @author hustffx
 */
public class ClimbingStairs {
    /**
     * 方法1：动态规划
     */
    public int climbStairs1(int n) {
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i] = 1;
            } else if (i == 1) {
                dp[i] = 2;
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[n - 1];
    }

    /**
     * 方法2：斐波那契数
     */
    public int climbStairs2(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    /**
     * 方法3：优化动态规划
     */
    public int climbStairs3(int n) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                list.addLast(1);
            } else if (i == 1) {
                list.addLast(2);
            } else {
                list.addLast(list.get(i - 2) + list.get(i - 1));
            }
        }
        return list.getLast();
    }
}
