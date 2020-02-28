package problem_001_TwoSum;

import java.util.HashMap;

/*
 * 给定一个整数数组 nums 和一个目标值 target，
 * 请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。
 * 但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoSum {
    /*
     * 方法1：暴力破解
     * 遍历每个元素 x ，并查找是否存在一个元素的值与 target - x 相等。
     */
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /*
     * 方法2：两遍哈希法
     * 首先遍历数组，将数组转换为元素和索引对应的键值对HashMap，
     * 再次遍历数组，使用HashMap的containsKey方法快速查找是否存在 target - x 这个键，
     * 存在则获取两个索引并返回。
     */
    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            int j;
            if (map.containsKey(num) && (j = map.get(num)) != i) {
                return new int[]{i, j};
            }
        }
        throw new IllegalArgumentException("Np two sum solution");
    }

    /*
     * 方法3：一遍哈希法
     * 在一次遍历中，先确定HashMap中是否存在 target - x 这个键，
     * 不存在则将当前元素与索引加入HashMap，
     * 存在则获取两个索引并返回。
     */
    public int[] twoSum3(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int temp;
        for (int i = 0; i < nums.length; i++) {
            temp = target - nums[i];
            if (map.containsKey(temp)) {
                return new int[]{map.get(temp), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
