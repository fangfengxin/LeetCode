package May.problem_0287_FindDuplicateNumber;

/*
 * 287. 寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），
 * 可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 *
 * 示例 1:
 * 输入: [1,3,4,2,2]
 * 输出: 2
 *
 * 示例 2:
 * 输入: [3,1,3,4,2]
 * 输出: 3
 *
 * 说明：
 * 1. 不能更改原数组（假设数组是只读的）。
 * 2. 只能使用额外的 O(1) 的空间。
 * 3. 时间复杂度小于 O(n^2) 。
 * 4. 数组中只有一个重复的数字，但它可能不止重复出现一次。
 */

/**
 * @Author hustffx
 * @Date 2020/5/26 13:13
 */
public class FindDuplicateNumber {
    /**
     * 方法1：二分查找
     * 根据小于mid的个数来缩小搜索范围
     */
    public int findDuplicate1(int[] nums) {
        int low = 1;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }

            if (count > mid) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    /**
     * 方法2：循环检测 + 快慢指针
     */
    public int findDuplicate2(int[] nums) {
        int fast = 0;
        int slow = 0;

        do {
            fast = nums[nums[fast]];
            slow = nums[slow];
        } while (fast != slow);

        fast = 0;

        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }

        return fast;
    }
}
