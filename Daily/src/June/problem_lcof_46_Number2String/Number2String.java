package June.problem_lcof_46_Number2String;

/*
 * 面试题46. 把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 * 示例:
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *
 * 提示：0 <= num < 2^31
 */

import java.util.ArrayList;

/**
 * @Author hustffx
 * @Date 2020/6/9 11:04
 */
public class Number2String {
    /**
     * 方法1：动态规划
     */
    public int translateNum1(int num) {
        ArrayList<Integer> list = new ArrayList<>();
        while (num > 0) {
            list.add(0, num % 10);
            num /= 10;
        }

        // 为减少空间消耗，使用滚动数组的形式完成动态规划
        // 当前数字前两位的情况
        int s1 = 0;
        // 当前数字前一位的情况
        int s2 = 1;
        // 当前数字的情况
        int s3 = 1;

        for (int i = 1; i < list.size(); i++) {
            s1 = s2;
            s2 = s3;

            int sum = list.get(i - 1) * 10 + list.get(i);

            if (sum > 9 && sum < 26) {
                s3 = s1 + s2;
            } else {
                s3 = s2;
            }
        }

        return s3;
    }

    /**
     * 方法2：DFS
     */
    public int translateNum2(int num) {
        return translateNum(num);
    }

    private int translateNum(int num) {
        if (num < 10) {
            return 1;
        }

        int sum = num % 100;
        return translateNum(num / 10) + ((sum < 26 && sum > 9) ? translateNum(num / 100) : 0);
    }
}
