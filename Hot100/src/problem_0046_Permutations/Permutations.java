package problem_0046_Permutations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
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
public class Permutations {
    /*
     * 方法：回溯
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        generatePermutations(list, 0, res);
        // 对结果排序
        res.sort((o1, o2) -> {
            for (int i = 0; i < o1.size(); i++) {
                if (!o1.get(i).equals(o2.get(i))) {
                    return o1.get(i) - o2.get(i);
                }
            }
            return 0;
        });
        return res;
    }

    private void generatePermutations(List<Integer> list, int next, List<List<Integer>> res) {
        if (next == list.size()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = next; i < list.size(); i++) {
            Collections.swap(list, next, i);
            generatePermutations(list, next + 1, res);
            Collections.swap(list, next, i);
        }
    }
}
