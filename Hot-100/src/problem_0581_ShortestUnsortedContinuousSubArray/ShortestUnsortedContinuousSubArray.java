package problem_0581_ShortestUnsortedContinuousSubArray;

/*
 * 581. 最短无序连续子数组
 * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * 你找到的子数组应是最短的，请输出它的长度。
 *
 * 示例:
 * 输入: [2, 6, 4, 8, 10, 9, 15]
 * 输出: 5
 * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 *
 * 说明 :
 * 1. 输入的数组长度范围在 [1, 10,000]。
 * 2. 输入的数组可能包含重复元素 ，所以升序的意思是<=。
 */

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author hustffx
 * @Date 2020/4/21 16:28
 */
public class ShortestUnsortedContinuousSubArray {
    /**
     * 方法1：暴力破解
     * 对每个元素，找到它右边的每一个比它小的元素，更新无序数组边界
     */
    public int findUnsortedSubArray1(int[] nums) {
        // 找到最左边和最右边不在正确位置的元素下标
        int left = nums.length;
        int right = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    left = Math.min(left, i);
                    right = Math.max(right, j);
                }
            }
        }

        return left < right ? right - left + 1 : 0;
    }

    /**
     * 方法2：排序
     */
    public int findUnsortedSubArray2(int[] nums) {
        int[] copy = nums.clone();
        Arrays.sort(copy);

        int left = nums.length;
        int right = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != copy[i]) {
                left = Math.min(left, i);
                right = Math.max(right, i);
            }
        }

        return left < right ? right - left + 1 : 0;
    }

    /**
     * 方法3：栈
     * 从头遍历 nums 数组，如果遇到的数字大小一直是升序的，我们就不断把对应的下标压入栈中，这么做的目的是因为这些元素在目前都是处于正确的位置上。
     * 一旦我们遇到前面的数比后面的数大，也就是 nums[j] 比栈顶元素小，我们可以知道 nums[j] 一定不在正确的位置上。
     * 为了找到 nums[j] 的正确位置，我们不断将栈顶元素弹出，直到栈顶元素比 nums[j] 小。
     * 我们假设栈顶元素对应的下标为 k ，那么我们知道 nums[j] 的正确位置下标应该是 k + 1 。
     */
    public int findUnsortedSubArray3(int[] nums) {
        Stack<Integer> stack = new Stack<>();

        // 找左边界
        int left = nums.length;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                left = Math.min(left, stack.pop());
            }
            stack.push(i);
        }

        stack.clear();

        // 找右边界
        int right = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                right = Math.max(right, stack.pop());
            }
            stack.push(i);
        }

        return left < right ? right - left + 1 : 0;
    }

    /**
     * 方法4：不使用额外空间
     * 无序子数组中最小元素的正确位置可以决定左边界，最大元素的正确位置可以决定右边界。
     * 因此，首先我们需要找到原数组在哪个位置开始不是升序的。我们从头开始遍历数组，一旦遇到降序的元素，我们记录最小元素为 min 。
     * 类似的，我们逆序扫描数组 nums，当数组出现升序的时候，我们记录最大元素为 max。
     * 然后，我们再次遍历 nums 数组并通过与其他元素进行比较，来找到 min 和 max 在原数组中的正确位置。
     * 我们只需要从头开始找到第一个大于 min 的元素，从尾开始找到第一个小于 max的元素，它们之间就是最短无序子数组。
     */
    public int findUnsortedSubArray4(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int min = nums[n - 1];
        int left = 0;
        int right = -1;
        for (int i = 0; i < n; i++) {
            if (max > nums[i]) {
                right = i;
            } else {
                max = nums[i];
            }
            if (min < nums[n - 1 - i]) {
                left = n - 1 - i;
            } else {
                min = nums[n - 1 - i];
            }
        }
        return left < right ? right - left + 1 : 0;
    }
}
