package problem_0078_Subsets;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*
 * 78. 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class Subsets {
    /*
     * 方法1：深度优先搜索（回溯）
     */
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        getSubsets(res, nums, 0, new ArrayList<>());
        return res;
    }

    private void getSubsets(List<List<Integer>> res, int[] nums, int next, List<Integer> path) {
        if (next == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        getSubsets(res, nums, next + 1, path);
        path.add(nums[next]);
        getSubsets(res, nums, next + 1, path);
        path.remove(path.size() - 1);
    }

    /*
     * 方法2：生成二进制掩码
     */
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = (int) Math.pow(2, nums.length); i < (int) Math.pow(2, nums.length + 1); i++) {
            String bitmask = Integer.toBinaryString(i).substring(1);
            for (int j = 0; j < nums.length; j++) {
                if (bitmask.charAt(j) == '1') {
                    list.add(nums[j]);
                }
            }
            res.add(new ArrayList<>(list));
            list.clear();
        }
        return res;
    }
}
