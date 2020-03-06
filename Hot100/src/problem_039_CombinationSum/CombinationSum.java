package problem_039_CombinationSum;

import java.util.*;

/*
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 *
 * 示例 1:
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 *
 * 示例 2:
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */
public class CombinationSum {
    /*
     * 方法：回溯+剪枝
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // 排序是为了剪枝
        dfs(candidates, target, new ArrayList<>(), result);
        new ArrayList<>();
        return result;
    }

    /**
     * @param candidates 无重复元素的数组
     * @param residue    剩余数值
     * @param path       存储路径上的数值
     * @param result     结果集
     */
    public void dfs(int[] candidates, int residue, List<Integer> path, List<List<Integer>> result) {
        if (residue < 0) return;
        if (residue == 0) {
            ArrayList<Integer> tmp = new ArrayList<>(path);
            tmp.sort((o1, o2) -> o1 - o2);
            if (!result.contains(tmp)) {
                result.add(tmp);
            }
            return;
        }
        for (int candidate : candidates) {
            if (candidate <= residue) {
                path.add(candidate);
                dfs(candidates, residue - candidate, path, result);
                path.remove(path.size() - 1); // 因为path全局共用，所以需要移除最后一个path的最终一个元素，最终达到每添加一个path后清空的效果
            }
        }
    }
}
