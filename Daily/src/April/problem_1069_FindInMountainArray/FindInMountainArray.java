package April.problem_1069_FindInMountainArray;

/*
 * 1095. 山脉数组中查找目标值
 * （这是一个 交互式问题 ）
 * 给你一个 山脉数组 mountainArr，请你返回能够使得 mountainArr.get(index) 等于 target 最小 的下标 index 值。
 * 如果不存在这样的下标 index，就请返回 -1。
 *
 * 何为山脉数组？如果数组 A 是一个山脉数组的话，那它满足如下条件：
 * 首先，A.length >= 3
 * 其次，在 0 < i < A.length - 1 条件下，存在 i 使得：
 *   - A[0] < A[1] < ... A[i-1] < A[i]
 *   - A[i] > A[i+1] > ... > A[A.length - 1]
 *
 * 你将 不能直接访问该山脉数组，必须通过 MountainArray 接口来获取数据：
 * MountainArray.get(k) - 会返回数组中索引为k 的元素（下标从 0 开始）
 * MountainArray.length() - 会返回该数组的长度
 *
 * 注意：
 * 对 MountainArray.get 发起超过 100 次调用的提交将被视为错误答案。
 * 此外，任何试图规避判题系统的解决方案都将会导致比赛资格被取消。
 *
 * 示例 1：
 * 输入：array = [1,2,3,4,5,3,1], target = 3
 * 输出：2
 * 解释：3 在数组中出现了两次，下标分别为 2 和 5，我们返回最小的下标 2。
 *
 * 示例 2：
 * 输入：array = [0,1,2,4,2,1], target = 3
 * 输出：-1
 * 解释：3 在数组中没有出现，返回 -1。
 *
 * 提示：
 * 3 <= mountain_arr.length() <= 10000
 * 0 <= target <= 10^9
 * 0 <= mountain_arr.get(index) <= 10^9
 */

import utils.MountainArray;

/**
 * @Author hustffx
 * @Date 2020/4/29 10:31
 */
public class FindInMountainArray {
    /**
     * 方法：二分查找
     */
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int len = mountainArr.length();

        int peak = findMountainTop(mountainArr, 0, len - 1);
        if (mountainArr.get(peak) == target) {
            return peak;
        }

        int res = findSortedArray(mountainArr, target, 0, peak - 1);
        if (res != -1) {
            return res;
        }

        return findReverseArray(mountainArr, target, peak + 1, len - 1);
    }

    /**
     * 在 [left, right] 查找山顶元素的下标
     *
     * @param mountainArr
     * @param left
     * @param right
     * @return
     */
    private int findMountainTop(MountainArray mountainArr, int left, int right) {
        while (left < right) {
            int mid = (left + right) >> 1;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                // 下一轮搜索区间 [mid + 1, right]
                left = mid + 1;
            } else {
                // 下一轮搜索区间 [left, mid]
                right = mid;
            }
        }
        // left == right
        return left;
    }

    /**
     * 在升序数组 [left, right] 查找 target 元素的下标
     *
     * @param mountainArr
     * @param target
     * @param left
     * @param right
     * @return
     */
    private int findSortedArray(MountainArray mountainArr, int target, int left, int right) {
        while (left < right) {
            int mid = (left + right) >> 1;
            if (mountainArr.get(mid) < target) {
                // 下一轮搜索区间 [mid + 1, right]
                left = mid + 1;
            } else {
                // 下一轮搜索区间 [left, mid]
                right = mid;
            }
        }

        // left == right
        if (target == mountainArr.get(left)) {
            return left;
        }
        return -1;
    }

    /**
     * 在降序数组 [left, right] 查找 target 元素的下标
     *
     * @param mountainArr
     * @param target
     * @param left
     * @param right
     * @return
     */
    private int findReverseArray(MountainArray mountainArr, int target, int left, int right) {
        while (left < right) {
            // 此处 mid 向上取整
            int mid = left + (right - left + 1) / 2;
            if (mountainArr.get(mid) < target) {
                // 下一轮搜索区间 [left, mid - 1]
                right = mid - 1;
            } else {
                // 下一轮搜索区间 [mid, right]
                left = mid;
            }
        }

        // left == right
        if (target == mountainArr.get(left)) {
            return left;
        }
        return -1;
    }
}
