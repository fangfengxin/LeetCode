package March.problem_1103_DistributeCandiesToPeople;

/*
 * 1103. 分糖果 II
 * 排排坐，分糖果。
 * 我们买了一些糖果 candies，打算把它们分给排好队的 n = num_people 个小朋友。
 * 给第一个小朋友 1 颗糖果，第二个小朋友 2 颗，依此类推，直到给最后一个小朋友 n 颗糖果。
 * 然后，我们再回到队伍的起点，给第一个小朋友 n + 1 颗糖果，第二个小朋友 n + 2 颗，依此类推，直到给最后一个小朋友 2 * n 颗糖果。
 * 重复上述过程（每次都比上一次多给出一颗糖果，当到达队伍终点后再次从队伍起点开始），直到我们分完所有的糖果。
 * 注意，就算我们手中的剩下糖果数不够（不比前一次发出的糖果多），这些糖果也会全部发给当前的小朋友。
 * 返回一个长度为 num_people、元素之和为 candies 的数组，以表示糖果的最终分发情况（即 ans[i] 表示第 i 个小朋友分到的糖果数）。
 *
 * 示例 1：
 * 输入：candies = 7, num_people = 4
 * 输出：[1,2,3,1]
 * 解释：
 * 第一次，ans[0] += 1，数组变为 [1,0,0,0]。
 * 第二次，ans[1] += 2，数组变为 [1,2,0,0]。
 * 第三次，ans[2] += 3，数组变为 [1,2,3,0]。
 * 第四次，ans[3] += 1（因为此时只剩下 1 颗糖果），最终数组变为 [1,2,3,1]。
 *
 * 示例 2：
 * 输入：candies = 10, num_people = 3
 * 输出：[5,2,3]
 * 解释：
 * 第一次，ans[0] += 1，数组变为 [1,0,0]。
 * 第二次，ans[1] += 2，数组变为 [1,2,0]。
 * 第三次，ans[2] += 3，数组变为 [1,2,3]。
 * 第四次，ans[0] += 4，最终数组变为 [5,2,3]。
 *
 * 提示：
 * 1 <= candies <= 10^9
 * 1 <= num_people <= 1000
 */
public class DistributeCandiesToPeople {
    /**
     * 方法1：暴力破解
     */
    public int[] distributeCandies1(int candies, int num_people) {
        int[] res = new int[num_people];
        int count = 0;
        while (candies > 0) {
            count++;
            int distribute = Math.min(count, candies);
            int people = (count - 1) % num_people;
            res[people] += distribute;
            candies -= distribute;
        }
        return res;
    }

    /**
     * 方法2：等差数列求和
     * 剩余糖果数量为： remaining = C - p * (p + 1) / 2
     * 0 <= remaining < p + 1
     * 共可以分发完整糖果份数： p = floor(sqrt(2 * C + 1 / 4 ) - 1 / 2)
     * 1.完整分发糖果的回合：
     * 一个回合表示给每个人都分发一份完整的糖果。
     * 将 p 份完整的糖果分发给 N 个人。
     * 共可以分发的回合数： time = p / N。
     * 每人获得糖果数： res[i] = (i + 1) * time + N * time * (time - 1) / 2
     * 2.不完整分发糖果的回合：
     * 最后一个回合可能不完整，因为有可能只是一部分人收到了糖果。
     * 收到完整糖果的人数： count = p % N
     * 收到的完整糖果数量是： res[i] += (i + 1) + N * time
     * 最后一份不完整糖果数量是： res[count] += remaining
     */
    public int[] distributeCandies2(int candies, int num_people) {
        // 完整糖果的份数
        int p = (int) (Math.sqrt(2 * candies + 0.25) - 0.5);
        // 剩余不完整糖果的数量
        int remaining = candies - p * (p + 1) / 2;
        // 完整分发完整糖果的回合数
        int time = p / num_people;
        // 最后一回合分发完整糖果的份数
        int count = p % num_people;
        // 计算每个人获得的糖果数量
        int[] res = new int[num_people];
        for (int i = 0; i < num_people; i++) {
            res[i] += (i + 1) * time + num_people * time * (time - 1) / 2;
            if (i < count) {
                res[i] += i + 1 + num_people * time;
            }
            if (i == count) {
                res[i] += remaining;
            }
        }
        return res;
    }
}
