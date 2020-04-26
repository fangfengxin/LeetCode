package April.problem_0046_Permutations;

/*
 * 46. 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author hustffx
 * @Date 2020/4/25 10:48
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (depth == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, depth + 1, path, used, res);
            path.removeLast();
            used[i] = false;
        }
    }
}
