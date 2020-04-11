package April.problem_0887_SuperEggDrop;

/*
 * 887. 鸡蛋掉落
 * 你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。
 * 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
 * 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
 * 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。
 * 你的目标是确切地知道 F 的值是多少。
 * 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
 *
 * 示例 1：
 * 输入：K = 1, N = 2
 * 输出：2
 * 解释：
 * 鸡蛋从 1 楼掉落。如果它碎了，我们肯定知道 F = 0 。
 * 否则，鸡蛋从 2 楼掉落。如果它碎了，我们肯定知道 F = 1 。
 * 如果它没碎，那么我们肯定知道 F = 2 。
 * 因此，在最坏的情况下我们需要移动 2 次以确定 F 是多少。
 *
 * 示例 2：
 * 输入：K = 2, N = 6
 * 输出：3
 *
 * 示例 3：
 * 输入：K = 3, N = 14
 * 输出：4
 *
 * 提示：
 * 1 <= K <= 100
 * 1 <= N <= 10000
 */

import java.util.HashMap;

public class SuperEggDrop {
    /**
     * 方法1：动态规划 + 二分查找
     * 参考：https://www.bilibili.com/video/BV1KE41137PK?from=search&seid=17973611971894816621
     * 把求解 F 的过程认为是用最好的算法，即使是在最坏的运气下，为了准确得到结果，找到 F 这个值的实验的次数最少是多少。
     * 题目中只有一个限制：鸡蛋的个数。
     * 1. 如果鸡蛋无穷多，相等于没有限制，由于 F 是一个确定的整数值，可以使用二分查找去做，二分查找是最好的算法；
     * 2. 如果只有 1 个鸡蛋：由于一定要测出 F 值，只能从底层到高层，一层一层尝试去仍，直到这个鸡蛋破碎为止，破碎位置的楼层高度 - 1−1，就是 F 值。
     * 那么，如果鸡蛋的个数有若干个，该怎么利用好这些鸡蛋，还能保证运气最坏的情况下实验次数最少，这就相当复杂了。
     * dp[i][j] 表示 i 层楼梯 j 个鸡蛋需要的最小实验次数（注意：代码中的方法参数顺序相反）。
     * 设在楼层 k 扔鸡蛋：
     * 1. 如果鸡蛋碎了，后续实验就在 k 层以下做，鸡蛋减少 1 个，需要计算 dp[k-1][j-1]；
     * 2. 如果鸡蛋没碎，后续实验就在 k 层以上做，鸡蛋数量不变，需要计算 dp[i-k][j]。
     * 最坏情况下，是两个子问题的较大者。
     * k 的取值在 1 <= k <= i，对于每个 k 都对应了一组值的最大值，我们需要取这些 k 下的最小值。
     * 状态转移方程为：dp[i][j] = 1 + min{max(dp[k-1][j-1], dp[i-k][j])}
     * 观察到 dp[k-1][j-1] 是一个关于 k 单增的离散函数，dp[i-k][j] 是一个关于 k 单减的离散函数，
     * 所以我们需要找到两个离散函数交点附近的两个整数，比较函数值的最大值，取最小的那一个作为结果。
     */
    public int superEggDrop(int K, int N) {
        return dp(K, N, new HashMap<>());
    }

    private int dp(int k, int n, HashMap<Integer, Integer> map) {
        if (map.containsKey(n * 100 + k)) {
            return map.get(n * 100 + k);
        }
        int res = 0;
        if (n == 0) {
            res = 0;
        } else if (k == 1) {
            res = n;
        } else {
            int low = 1;
            int high = n;
            while (low + 1 < high) {
                int mid = (low + high) / 2;
                int t1 = dp(k - 1, mid - 1, map);
                int t2 = dp(k, n - mid, map);
                if (t1 < t2) {
                    low = mid;
                } else if (t1 > t2) {
                    high = mid;
                } else {
                    low = high = mid;
                }
            }
            res = 1 + Math.min(Math.max(dp(k - 1, low - 1, map), dp(k, n - low, map)),
                    Math.max(dp(k - 1, high - 1, map), dp(k, n - high, map)));
        }
        map.put(n * 100 + k, res);
        return res;
    }
}
