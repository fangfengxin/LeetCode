package May.problem_0069_SqrtX;

/*
 * 69. x 的平方根
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 * 输入: 4
 * 输出: 2
 *
 * 示例 2:
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 */

/**
 * @Author hustffx
 * @Date 2020/5/9 10:41
 */
public class SqrtX {
    /**
     * 方法1：二分查找
     */
    public int mySqrt1(int x) {
        int left = 0;
        int right = x;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if ((long) mid * mid <= x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }

    /**
     * 方法2：牛顿迭代法
     * 找 y = f(x) = x^2 − C 的零点。
     * 我们任取一个 x_0 作为初始值，在每一步的迭代中，我们找到函数图像上的点 (x_i, f(x_i))，
     * 过该点作一条斜率为该点导数 f'(x_i) 的直线，与横轴的交点记为 x_{i+1}。
     * x_{i+1} 相较于 x_i 而言距离零点更近。在经过多次迭代后，我们就可以得到一个距离零点非常接近的交点。
     */
    public int mySqrt2(int x) {
        if (x == 0) {
            return 0;
        }

        double x0 = x;

        // 牛顿迭代
        while (true) {
            double x1 = 0.5 * (x0 + x / x0);
            if (Math.abs(x0 - x1) < 1e-7) {
                break;
            }
            x0 = x1;
        }

        return (int) x0;
    }
}
