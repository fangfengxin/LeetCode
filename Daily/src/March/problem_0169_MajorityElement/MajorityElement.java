package March.problem_0169_MajorityElement;

import java.util.*;

/*
 * 给定一个大小为 n 的数组，找到其中的多数元素。
 * 多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1:
 * 输入: [3,2,3]
 * 输出: 3
 *
 * 示例 2:
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class MajorityElement {
    /*
     * 方法1：计数
     * HashMap存储每个元素的个数
     */
    public int majorityElement1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        Map.Entry<Integer, Integer> majorityElement = null;
        for (Map.Entry<Integer, Integer> entry : set) {
            if (majorityElement == null || majorityElement.getValue() < entry.getValue()) {
                majorityElement = entry;
            }
        }
        return Objects.requireNonNull(majorityElement).getKey();
    }

    /*
     * 方法2：排序（可自定义排序）
     * 排序后在 n/2 位置的元素即为所求。
     */
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /*
     * 方法3：分治法
     */
    public int majorityElement3(int[] nums) {
        return majorityElement(nums, 0, nums.length - 1);
    }

    private int majorityElement(int[] nums, int low, int high) {
        if (low == high) {
            return nums[low];
        }

        int mid = (low + high) / 2;
        int leftMajority = majorityElement(nums, low, mid);
        int rightMajority = majorityElement(nums, mid + 1, high);

        if (leftMajority == rightMajority) {
            return leftMajority;
        }

        int leftCount = 0;
        int rightCount = 0;
        for (int num : nums) {
            if (num == leftMajority) {
                leftCount++;
            }
            if (num == rightMajority) {
                rightCount++;
            }
        }

        return leftCount > rightCount ? leftMajority : rightMajority;
    }

    /*
     * 方法4：Boyer-Moore投票算法
     * 多数元素的个数 - 少数元素的个数 >= 1
     */
    public int majorityElement4(int[] nums) {
        int candidate = 0, count = 0;
        for (int num : nums) {
            if (count == 0) candidate = num;
            count += candidate == num ? 1 : -1;
        }
        return candidate;
    }
}
