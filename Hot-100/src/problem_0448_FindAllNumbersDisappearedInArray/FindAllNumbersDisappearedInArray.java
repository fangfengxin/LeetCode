package problem_0448_FindAllNumbersDisappearedInArray;

/*
 * 448. 找到所有数组中消失的数字
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 *
 * 示例:
 * 输入: [4,3,2,7,8,2,3,1]
 * 输出: [5,6]
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @Author hustffx
 * @Date 2020/4/20 17:03
 */
public class FindAllNumbersDisappearedInArray {
    /**
     * 方法1：计数
     */
    public List<Integer> findDisappearedNumbers1(int[] nums) {
        int[] count = new int[nums.length];
        for (int num : nums) {
            count[num - 1]++;
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (count[i] == 0) {
                res.add(i + 1);
            }
        }
        return res;
    }

    /**
     * 方法2：原地修改
     * 扫描两遍数组，第一次将所有数字做标记，第二次根据标记信息找出缺失的数字。
     * 数组中的每个值 num 都有一个对应的数组下标 num-1
     * 因为每个 arr[i]都对应下标 arr[i]-1，我们将 arr[i] 对应的下标中的数组值置为负，在不损失信息的情况下做了标记。
     */
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] *= -1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
