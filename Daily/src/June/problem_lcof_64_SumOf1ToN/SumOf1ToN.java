package June.problem_lcof_64_SumOf1ToN;

/*
 * 面试题64. 求1+2+…+n
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 * 示例 ：
 * 输入: n = 9
 * 输出: 45
 *
 * 限制：1 <= n <= 10000
 */

/**
 * @Author hustffx
 * @Date 2020/6/2 12:53
 */
public class SumOf1ToN {
    /**
     * 方法：递归 + 利用逻辑运算符的短路特性
     */
    public int sumNums(int n) {
        boolean x = (n > 1) && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
