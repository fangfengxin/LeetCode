package May.problem_0004_MedianOfTwoSortedArrays;

/*
 * 4. 寻找两个正序数组的中位数
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 则中位数是 2.0
 *
 * 示例 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 则中位数是 (2 + 3)/2 = 2.5
 */

/**
 * @Author hustffx
 * @Date 2020/5/24 10:41
 */
public class MedianOfTwoSortedArrays {
    /**
     * 方法：二分查找
     * 在两个数组中寻找分割线，数值小的部分组合到一起，数值大的部分也组合到一起。
     * 中位数就跟基本分割成两半时两部分的最小值和最大值有关。
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }

        int m = nums1.length;
        int n = nums2.length;

        // 分割线左边的所有元素需要满足的个数（左侧与右侧个数相等或多一个）
        int totalLeft = (m + n + 1) / 2;

        // 在 nums1[0, m] 查找适当的分割线，使得 nums[i-1] <= nums2[j] && nums2[j-1] <= nums1[i]
        int left = 0;
        int right = m;

        while (left < right) {
            int i = left + (right - left + 1) / 2;
            int j = totalLeft - i;

            if (nums1[i - 1] > nums2[j]) {
                // 下一轮搜索区间 [left, i-1]
                right = i - 1;
            } else {
                // 下一轮搜索区间 [i, right]
                left = i;
            }
        }

        // 获取分割线附近的四个值
        int nums1Left = left == 0 ? Integer.MIN_VALUE : nums1[left - 1];
        int nums1Right = left == m ? Integer.MAX_VALUE : nums1[left];
        int nums2Left = left == totalLeft ? Integer.MIN_VALUE : nums2[totalLeft - left - 1];
        int nums2Right = left == totalLeft - n ? Integer.MAX_VALUE : nums2[totalLeft - left];

        // 根据数组长度和分情况获得中位数
        if ((m + n) % 2 == 1) {
            return Math.max(nums1Left, nums2Left);
        } else {
            return (Math.max(nums1Left, nums2Left) + Math.min(nums1Right, nums2Right)) / 2.0;
        }
    }
}
