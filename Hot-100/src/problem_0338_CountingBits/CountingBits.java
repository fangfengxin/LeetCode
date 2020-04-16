package problem_0338_CountingBits;

/*
 * 338. 比特位计数
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * 示例 1:
 * 输入: 2
 * 输出: [0,1,1]
 *
 * 示例 2:
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 *
 * 进阶:
 * 1. 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
 * 2. 要求算法的空间复杂度为O(n)。
 * 3. 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
 */

public class CountingBits {
    /**
     * 方法1：直接解法
     */
    public int[] countBits1(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = countOnes(i);
        }
        return res;
    }

    /**
     * 计算数值 num 的二进制中 1 的个数
     *
     * @param num
     * @return
     */
    private int countOnes(int num) {
        int count = 0;
        while (num != 0) {
            count += (num % 2 == 1) ? 1 : 0;
            num /= 2;
        }
        return count;
    }

    /**
     * 方法2：动态规划 + 最高有效位
     * 利用已有计数结果来生成新的计数结果
     * P(x+b) = P(x) + 1, b = 2^m > x
     */
    public int[] countBits2(int num) {
        int[] res = new int[num + 1];
        int b = 1;
        // [0, b) 已经计算完毕
        while (b <= num) {
            int i = 0;
            while (i < b && i + b <= num) {
                res[i + b] = res[i] + 1;
                i++;
            }
            b <<= 1;
        }
        return res;
    }

    /**
     * 方法3：动态规划 + 最低有效位
     * P(x) = P(x/2) + (x mod 2)
     */
    public int[] countBits3(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            res[i] = res[i>>1] + (i & 1);
        }
        return res;
    }
}
