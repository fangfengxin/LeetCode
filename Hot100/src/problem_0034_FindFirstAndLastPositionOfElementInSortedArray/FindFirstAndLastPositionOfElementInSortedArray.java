package problem_0034_FindFirstAndLastPositionOfElementInSortedArray;

/*
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。
 * 找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 *
 * 示例 2：
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    /*
     * 方法1：线性查找
     */
    public int[] searchRange1(int[] nums, int target) {
        /*if (nums == null || nums.length == 0) return new int[]{-1, -1};
        int first = 0, last = nums.length - 1;
        while (first < nums.length && nums[first++] != target) ;
        while (last >= 0 && nums[last--] != target) ;
        first = (nums[first - 1] != target) ? -1 : first - 1;
        last = (nums[last + 1] != target) ? -1 : last + 1;
        return new int[]{first, last};*/

        int first = -1, last, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (count == 0) {
                    first = i;
                }
                count++;
            }
        }
        last = (count == 0) ? (first + count) : (first + count - 1);
        return new int[]{first, last};
    }

    /*
     * 方法2：二分查找
     */
    public int[] searchRange2(int[] nums, int target) {
        return searchRange(nums, target, 0, nums.length);
    }

    public int[] searchRange(int[] nums, int target, int start, int end) {
        if (nums == null || nums.length == 0 || start > end) return new int[]{-1, -1};
        if (start == end) {
            if (start < nums.length && nums[start] == target) {
                return new int[]{start, end};
            } else {
                return new int[]{-1, -1};
            }
        }
        int mid = (start + end) / 2;
        if (nums[mid] < target) {
            return searchRange(nums, target, mid + 1, end);
        } else if (nums[mid] > target) {
            return searchRange(nums, target, start, mid - 1);
        } else {
            int[] arr1 = searchRange(nums, target, start, mid - 1);
            int[] arr2 = searchRange(nums, target, mid + 1, end);
            start = (arr1[0] == -1) ? mid : arr1[0];
            end = (arr2[1] == -1) ? mid : arr2[1];
            return new int[]{start, end};
        }
    }
}
