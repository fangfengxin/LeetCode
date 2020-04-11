package problem_0283_MoveZeroes;

/*
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        // 双指针，一个指向当前元素，一个指向当前已经放到相对位置的最后一个非零元素的下一位
        for (int cur = 0, lastNonZero = 0; cur < nums.length; cur++) {
            if (nums[cur] != 0) {
                int tmp = nums[cur];
                nums[cur] = nums[lastNonZero];
                nums[lastNonZero] = tmp;
                lastNonZero++;
            }
        }
    }
}
