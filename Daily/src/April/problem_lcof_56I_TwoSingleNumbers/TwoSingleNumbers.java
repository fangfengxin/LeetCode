package April.problem_lcof_56I_TwoSingleNumbers;

/*
 * 面试题56 - I. 数组中数字出现的次数
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 * 示例 1：
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 *
 * 示例 2：
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 *
 * 限制：2 <= nums <= 10000
 */

import java.util.HashSet;

/**
 * @Author hustffx
 * @Date 2020/4/28 10:42
 */
public class TwoSingleNumbers {
    /**
     * 方法1：哈希表
     * 不符合题目要求的空间复杂度
     */
    public int[] singleNumbers1(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        return set.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 方法2：分组异或
     * 先对所有数字进行一次异或，得到两个出现一次的数字的异或值。
     * 在异或结果中找到任意为 1 的位。
     * 根据这一位对所有的数字进行分组。
     * 在每个组内进行异或操作，得到两个数字。
     */
    public int[] singleNumbers2(int[] nums) {
        // 获取所有数的异或值ret
        int ret = 0;
        for (int num : nums) {
            ret ^= num;
        }

        // 寻找ret中处于最低位的1
        int mask = 1;
        while ((mask & ret) == 0) {
            mask <<= 1;
        }

        // 根据每个数在寻找的位置是1还是0进行分组，在组内异或
        int a = 0;
        int b = 0;
        for (int num : nums) {
            if ((mask & num) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }

        return new int[]{a, b};
    }
}
