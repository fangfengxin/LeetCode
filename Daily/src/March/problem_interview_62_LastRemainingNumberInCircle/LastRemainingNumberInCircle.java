package March.problem_interview_62_LastRemainingNumberInCircle;

import java.util.ArrayList;

/*
 * 面试题62. 圆圈中最后剩下的数字
 * 0, 1, ..., n-1 这 n 个数字排成一个圆圈，
 * 从数字 0 开始，每次从这个圆圈里删除第 m 个数字。
 * 求出这个圆圈里剩下的最后一个数字。
 *
 * 示例 1：
 * 输入: n = 5, m = 3
 * 输出: 3
 * 解释：
 * 0、1、2、3、4这5个数字组成一个圆圈，
 * 从数字0开始每次删除第3个数字，
 * 则删除的前4个数字依次是2、0、4、1，
 * 因此最后剩下的数字是3。
 *
 * 示例 2：
 * 输入: n = 10, m = 17
 * 输出: 2
 *
 * 限制：
 * 1 <= n <= 10^5
 * 1 <= m <= 10^6
 */
public class LastRemainingNumberInCircle {
    /**
     * 方法1：模拟链表
     * 在链表中不断删除元素直到只剩一个元素
     */
    public int lastRemaining1(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while (n > 1) {
            index = (index + m - 1) % n;
            list.remove(index);
            n--;
        }
        return list.get(0);
    }

    /**
     * 方法2：约瑟夫环问题（数学 + 递归）
     * 首先，长度为 n 的序列会先删除第 m % n 个元素，然后剩下一个长度为 n - 1 的序列。
     * 那么，我们可以递归地求解 f(n - 1, m)，就可以知道对于剩下的 n - 1 个元素，最终会留下第几个元素。
     * 由于我们删除了第 m % n 个元素，将序列的长度变为 n - 1。当我们知道了 f(n - 1, m) 对应的答案 x 之后，
     * 我们也就可以知道，长度为 n 的序列最后一个删除的元素，应当是从 m % n 开始数的第 x 个元素。
     * 因此有 f(n - 1, m) = (m % n + x) % n = (m + x) % n。
     */
    public int lastRemaining2(int n, int m) {
        return f(n, m);
    }

    private int f(int n, int m) {
        if (n == 1) {
            return 0;
        }
        return (m + f(n - 1, m)) % n;
    }

    /**
     * 方法3：约瑟夫环问题（数学 + 迭代）
     * 每轮都是上一轮被删结点的下一个结点开始数 m 个。
     * 一步步倒推是哪个元素留到最后。
     */
    public int lastRemaining3(int n, int m) {
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = (res + m) % i;
        }
        return res;
    }
}
