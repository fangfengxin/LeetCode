package April.problem_0202_HappyNumber;

/*
 * 202. 快乐数
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程，
 * 直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
 * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
 *
 * 示例：
 * 输入：19
 * 输出：true
 * 解释：
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 */

import java.util.HashSet;

/**
 * @Author hustffx
 * @Date 2020/4/30 15:33
 */
public class HappyNumber {
    /**
     * 计算数值 n 的每一位数字的平方和
     *
     * @param n
     * @return
     */
    private int bitSquareSum(int n) {
        int sum = 0;
        int cur;
        while (n > 0) {
            cur = n % 10;
            sum += cur * cur;
            n /= 10;
        }
        return sum;
    }

    /**
     * 方法1：哈希表 + 循环检测
     */
    public boolean isHappy1(int n) {
        HashSet<Integer> set = new HashSet<>();
        set.add(n);
        while (n != 1) {
            n = bitSquareSum(n);
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
        }
        return true;
    }

    /**
     * 方法2：快慢指针
     */
    public boolean isHappy2(int n) {
        int fast = n;
        int slow = n;
        do {
            fast = bitSquareSum(fast);
            fast = bitSquareSum(fast);
            slow = bitSquareSum(slow);
        } while (fast != slow);
        return slow == 1;
    }

    /**
     * 方法3：数学
     */
    public boolean isHappy3(int n) {
        while (n != 1) {
            if (n == 4 || n == 16 || n == 37 || n == 58 || n == 89 || n == 145 || n == 42 || n == 20) {
                return false;
            }
            n = bitSquareSum(n);
        }
        return true;
    }
}
