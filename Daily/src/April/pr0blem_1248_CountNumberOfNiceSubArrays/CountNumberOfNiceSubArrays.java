package April.pr0blem_1248_CountNumberOfNiceSubArrays;

/*
 * 1248. 统计「优美子数组」
 * 给你一个整数数组 nums 和一个整数 k。
 * 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 * 请返回这个数组中「优美子数组」的数目。
 *
 * 示例 1：
 * 输入：nums = [1,1,2,1,1], k = 3
 * 输出：2
 * 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
 *
 * 示例 2：
 * 输入：nums = [2,4,6], k = 1
 * 输出：0
 * 解释：数列中不包含任何奇数，所以不存在优美子数组。
 *
 * 示例 3：
 * 输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * 输出：16
 *
 * 提示：
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10^5
 * 1 <= k <= nums.length
 */

/**
 * @Author hustffx
 * @Date 2020/4/21 11:44
 */
public class CountNumberOfNiceSubArrays {
    /**
     * 方法1：数学
     */
    public int numberOfSubArrays1(int[] nums, int k) {
        int n = nums.length;
        if (n < k) {
            return 0;
        }
        // 奇数值下标
        int[] odd = new int[n + 2];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 1) {
                odd[++count] = i;
            }
        }
        odd[0] = -1;
        odd[++count] = n;
        int res = 0;
        for (int i = 1; i + k <= count; i++) {
            res += (odd[i] - odd[i - 1]) * (odd[i + k] - odd[i + k - 1]);
        }
        return res;
    }

    /**
     * 方法2：滑动窗口 + 双指针
     * 滑动窗口使用双指针，数组可以分成三个部分：
     * 1. 包含 k 个奇数的区间（左右边界都是奇数）
     * 2. k 个奇数前面的偶数
     * 3. k 个奇数后面的偶数
     */
    public int numberOfSubArrays2(int[] nums, int k) {
        if (nums.length < k) {
            return 0;
        }
        int res = 0;
        // 双指针
        int left = 0;
        int right = 0;
        // 记录当前所求子数组第一个奇数及其前面所有连续偶数的总长度
        int pre = 0;
        // 记录连续子数组中奇数的个数
        int count = 0;
        while (right < nums.length) {
            // 连续子数组中奇数个数不够
            if (count < k) {
                if ((nums[right] & 1) == 1) {
                    count++;
                }
                right++;
            }
            // 连续子数组中奇数个数够了，看第一个奇数前面有多少个偶数
            if (count == k) {
                pre = 0;
                while (count == k) {
                    res++;
                    if ((nums[left] & 1) == 1) {
                        count--;
                    }
                    left++;
                    pre++;
                }
            }
            // 每次遇到 nums[right] 为偶数的时候就进行累加，相当于区间前面偶数个数 * 后面偶数个数
            else {
                res += pre;
            }
        }
        return res;
    }

    /**
     * 方法3：前缀和
     * 假设当前遍历到i,前缀和sum: sum = nums[0]+nums[1]+...+nums[j]+nums[j+1]+...+nums[i]
     * 若存在前缀和sum-k: sum-k = nums[0]+nums[1]+...+nums[j]
     * 则一定存在子序列和k：k = nums[j+1]+nums[j+2]+...+nums[i]
     * 本题中使用元素值模2的结果来计入前缀和。
     * 当前前缀和是sum，尝试查找 是否存在键值是sum-k(即前缀和是sum-k) ，若找到，即找到子序列和是k
     */
    public int numberOfSubArrays3(int[] nums, int k) {
        int res = 0;
        // 前缀和
        int sum = 0;
        // 前缀和计数数组，键为前缀和，值为前缀和出现的次数
        int[] odd = new int[nums.length + 1];
        // 初始将前缀和为0的次数设置为1，与后续情况保持一致（前缀和为sum的次数是奇数及其后连续偶数的个数）
        odd[0] = 1;
        for (int num : nums) {
            sum += (num & 1);
            // 当前前缀和是sum，尝试在map中查找 是否存在键值是sum-k(即前缀和是sum-k) ，若找到，即找到子序列和是k
            res += sum < k ? 0 : odd[sum - k];
            odd[sum]++;
        }
        return res;
    }
}
