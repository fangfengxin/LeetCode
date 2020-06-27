package June.problem_0041_FirstMissingPositive;

/*
 * 41. 缺失的第一个正数
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 *
 * 示例 1:
 * 输入: [1,2,0]
 * 输出: 3
 *
 * 示例 2:
 * 输入: [3,4,-1,1]
 * 输出: 2
 *
 * 示例 3:
 * 输入: [7,8,9,11,12]
 * 输出: 1
 *
 * 提示：你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
 */

import java.util.HashSet;

/**
 * @Author hustffx
 * @Date 2020/6/27 12:22
 */
public class FirstMissingPositive {
    /**
     * 方法1：哈希表
     */
    public int firstMissingPositive1(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int i = 1;
        while (set.contains(i)) {
            i++;
        }

        return i;
    }

    /**
     * 方法2：使用负号进行标记
     */
    public int firstMissingPositive2(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }

        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);

            if (num <= n && nums[num - 1] > 0) {
                nums[num - 1] *= -1;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        return n + 1;
    }
}
