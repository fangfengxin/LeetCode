package problem_0287_FindDuplicateNumber;

/*
 * 287. 寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设只有一个重复的整数，找出这个重复的数。
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

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author hustffx
 */
public class FindDuplicateNumber {
    /**
     * 方法1：排序
     */
    public int findDuplicate1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }
        return 0;
    }

    /**
     * 方法2：哈希表
     */
    public int findDuplicate2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return 0;
    }

    /**
     * 方法3：二分查找
     * mid = (1 + n) / 2，接下来判断最终答案是在 [1, mid] 中还是在 [mid + 1, n] 中。
     * 我们只需要统计原数组中小于等于 mid 的个数，记为 count。
     * 如果 count > mid ，鸽巢原理，在 [1,mid] 范围内的数字个数超过了 mid ，所以一定有一个重复数字。
     * 否则的话，既然不在 [1,mid] ，那么最终答案一定在 [mid + 1, n] 中。
     */
    public int findDuplicate3(int[] nums) {
        int low = 1;
        int high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) >> 1;
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
     * 方法4：循环检测
     * 把数组元素的值看作 next 指针，数组的下标看作节点的索引。
     * 因为数组中至少有两个值一样，即有两个节点指向同一个位置，所以存在环。
     * 因而要找环的入口。
     * 参考第 142 题环形链表的解法。
     */
    public int findDuplicate4(int[] nums) {
        int fast = nums[0];
        int slow = nums[0];
        do {
            fast = nums[nums[fast]];
            slow = nums[slow];
        } while (fast != slow);
        fast = nums[0];
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return fast;
    }
}
