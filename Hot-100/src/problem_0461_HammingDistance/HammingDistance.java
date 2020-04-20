package problem_0461_HammingDistance;

/*
 * 461. 汉明距离
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 * 注意： 0 ≤ x, y < 231.
 *
 * 示例:
 * 输入: x = 1, y = 4
 * 输出: 2
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 *
 * 上面的箭头指出了对应二进制位不同的位置。
 */

/**
 * @Author hustffx
 * @Date 2020/4/20 17:42
 */
public class HammingDistance {
    /**
     * 方法1：异或 + 移位
     * 也可以不使用异或，在移位过程中按位比较每一位是否相同
     */
    public int hammingDistance1(int x, int y) {
        int num = x ^ y;
        int count = 0;
        while (num != 0) {
            if ((num & 1) == 1) {
                count++;
            }
            num >>= 1;
        }
        return count;
    }

    /**
     * 方法2：Java内置的位计数功能
     */
    public int hammingDistance2(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    /**
     * 方法3：布赖恩·克尼根算法
     * 方法1中遇到一个1后每次移动1位，需要多次才能抵达下一个1的位置。
     * 方法3中的算法每次直接去掉最右边的1，很快就运算到0的状态。
     * n = n & (n-1)
     * 例如：
     *       n = 10001000，
     *     n-1 = 10000111，
     * n&(n-1) = 10000000。
     */
    public int hammingDistance3(int x, int y) {
        int n = x ^ y;
        int count = 0;
        while (n != 0) {
            count++;
            n &= n - 1;
        }
        return count;
    }
}
