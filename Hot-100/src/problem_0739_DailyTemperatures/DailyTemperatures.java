package problem_0739_DailyTemperatures;

/*
 * 739. 每日温度
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * 提示：气温列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 */

import java.util.Stack;

/**
 * @Author hustffx
 * @Date 2020/4/21 20:25
 */
public class DailyTemperatures {
    /**
     * 方法1：暴力破解
     */
    public int[] dailyTemperatures1(int[] T) {
        int n = T.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (T[i] == 100) {
                continue;
            }
            for (int j = i + 1; j < n; j++) {
                if (T[j] > T[i]) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }

    /**
     * 方法2：逆序遍历，减少遍历次数
     * 根据已经计算过的数据可以很快地跳到需要的位置
     */
    public int[] dailyTemperatures2(int[] T) {
        int n = T.length;
        int[] res = new int[n];
        // 逆序遍历
        for (int i = n - 2; i >= 0; i--) {
            // 利用已有解果进行跳跃
            for (int j = i + 1; j < n; j += res[j]) {
                if (T[i] < T[j]) {
                    res[i] = j - i;
                    break;
                } else if (res[j] == 0) {
                    res[i] = 0;
                    break;
                }
            }
        }
        return res;
    }

    /**
     * 方法3：栈
     * 遍历整个数组，如果栈不空，且当前数字大于栈顶元素，那么如果直接入栈的话就不是 递减栈 ，所以需要取出栈顶元素，
     * 由于当前数字大于栈顶元素的数字，而且一定是第一个大于栈顶元素的数，直接求出下标差就是二者的距离。
     * 继续看新的栈顶元素，直到当前数字小于等于栈顶元素停止，然后将数字入栈，这样就可以一直保持递减栈，
     * 且每个数字和第一个大于它的数的距离也可以算出来。
     */
    public int[] dailyTemperatures3(int[] T) {
        int n = T.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int index = stack.pop();
                res[index] = i - index;
            }
            stack.push(i);
        }
        return res;
    }
}
