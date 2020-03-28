package March.problem_0365_WaterAndJugProblem;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;

/*
 * 365. 水壶问题
 * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。
 * 请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
 * 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
 *
 * 你允许：
 * 装满任意一个水壶
 * 清空任意一个水壶
 * 从一个水壶向另外一个水壶倒水，直到装满或者倒空
 *
 * 示例 1: (From the famous "Die Hard" example)
 * 输入: x = 3, y = 5, z = 4
 * 输出: True
 *
 * 示例 2:
 * 输入: x = 2, y = 6, z = 5
 * 输出: False
 */
public class WaterAndJugProblem {
    /*
     * 方法1：深度优先搜索
     */
    public boolean canMeasureWater1(int x, int y, int z) {
        // 存储所有的可能状态
        Stack<int[]> stack = new Stack<>();
        // 存储处理过的状态
        HashSet<Map.Entry<Integer, Integer>> visited = new HashSet<>();
        stack.push(new int[]{0, 0});
        while (!stack.isEmpty()) {
            int[] cur = stack.pop(); // 当前状态
            if (cur[0] == z || cur[1] == z || cur[0] + cur[1] == z) {
                return true;
            }
            Map.Entry<Integer, Integer> curEntry = new AbstractMap.SimpleEntry<>(cur[0], cur[1]);
            // 之前处理过这个状态，跳过
            if (visited.contains(curEntry)) {
                continue;
            }
            // 把当前处理完的这个状态加入到已经处理过的集合内
            visited.add(curEntry);
            stack.add(new int[]{0, cur[1]}); // 倒空x
            stack.add(new int[]{cur[0], 0}); // 倒空y
            stack.add(new int[]{x, cur[1]}); // 加满x
            stack.add(new int[]{cur[0], y}); // 加满y

            int total = cur[0] + cur[1];
            // x往y中倒水
            if (total < y) {
                stack.add(new int[]{0, total});
            } else {
                stack.add(new int[]{total - y, y});
            }
            // y往x中倒水
            if (total < x) {
                stack.add(new int[]{total, 0});
            } else {
                stack.add(new int[]{x, total - x});
            }
        }
        return false;
    }

    /*
     * 方法2：数学方法（gcd）
     * 最后问题其实是ax+by==z是否成立，
     * 进而转换为z是否是x与y的最大公约数的倍数。
     */
    public boolean canMeasureWater2(int x, int y, int z) {
        if (x == z || y == z || x + y <= z) {
            return x + y >= z;
        }
        return z % gcd(x, y) == 0;
    }

    private int gcd(int x, int y) {
        if (x < y) {
            int t = x;
            x = y;
            y = t;
        }
        return y == 0 ? x : gcd(y, x % y);
    }
}
