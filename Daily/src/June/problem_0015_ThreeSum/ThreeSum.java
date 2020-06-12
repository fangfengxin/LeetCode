package June.problem_0015_ThreeSum;

/*
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 请你找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例：
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author hustffx
 * @Date 2020/6/12 10:42
 */
public class ThreeSum {
    /**
     * 方法：排序 + 双指针
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        // 排序
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            // 从小到大搜索，跳过重复值
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 调用子函数，简化问题
            List<List<Integer>> tmp = twoSum(nums, i + 1, n - 1, -nums[i], nums[i]);
            res.addAll(tmp);
        }

        return res;
    }

    /**
     * 寻找数组中和为 target 的两个数
     *
     * @param nums
     * @param start
     * @param end
     * @param target
     * @param value
     * @return
     */
    private List<List<Integer>> twoSum(int[] nums, int start, int end, int target, int value) {
        List<List<Integer>> res = new ArrayList<>();

        while (start < end) {
            int sum = nums[start] + nums[end];

            if (sum == target) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(value);
                tmp.add(nums[start]);
                tmp.add(nums[end]);
                res.add(tmp);

                while (start < end && nums[start] == nums[start + 1]) {
                    start++;
                }
                start++;

                while (start < end && nums[end] == nums[end - 1]) {
                    end--;
                }
                end--;
            } else if (sum < target) {
                start++;
            } else {
                end--;
            }
        }

        return res;
    }
}
