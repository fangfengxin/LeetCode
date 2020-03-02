package problem_031_NextPermutation;

import java.util.Arrays;

/*
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class NextPermutation {
    /*
     * 方法：一遍扫描
     * 从数组末端开始扫描，找到第一个破坏数组降序排列的元素。
     * 通过交换找到的元素与右侧稍大的元素，然后将当前索引右侧元素升序排列，得到下一个字典序排列。
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        while (i > 0 && nums[i - 1] >= nums[i]) {
            i--;
        }
        int j = i;
        if (i > 0) {
            while (j < nums.length && nums[i - 1] < nums[j]) {
                j++;
            }
            j = (j < nums.length) ? j - 1 : nums.length - 1;
            int tmp = nums[i - 1];
            nums[i - 1] = nums[j];
            nums[j] = tmp;
            Arrays.sort(nums, i, nums.length);
        } else {
            Arrays.sort(nums);
        }
    }
}
