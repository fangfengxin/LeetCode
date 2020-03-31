package problem_0136_SingleNumber;


import java.util.Arrays;
import java.util.HashSet;

/*
 * 136. 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。
 * 找出那个只出现了一次的元素。
 *
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 *
 * 示例 2:
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class SingleNumber {
    /**
     * 方法1：两层遍历
     */
    public int singleNumber1(int[] nums) {
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            num = nums[i];
            boolean isSingle = true;
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                if (num == nums[j]) {
                    isSingle = false;
                    break;
                }
            }
            if (isSingle) {
                break;
            }
        }
        return num;
    }

    /**
     * 方法2：排序
     */
    public int singleNumber2(int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 1 || nums[0] != nums[1]) {
            return nums[0];
        }
        if (nums[nums.length - 1] != nums[nums.length - 2]) {
            return nums[nums.length - 1];
        }
        int singleNum = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] == nums[i - 1] || nums[i] == nums[i + 1]) {
                continue;
            }
            singleNum = nums[i];
            break;
        }
        return singleNum;
    }

    /**
     * 方法3：哈希表
     * 可使用 HashSet 或 HashMap
     */
    public int singleNumber3(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        int singleNum = 0;
        for (Integer num : set) {
            singleNum = num;
        }
        return singleNum;
    }

    /**
     * 方法4：异或
     * 相同的数字异或结果是0
     */
    public int singleNumber4(int[] nums) {
        int singleNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            singleNum ^= nums[i];
        }
        return singleNum;
    }
}
