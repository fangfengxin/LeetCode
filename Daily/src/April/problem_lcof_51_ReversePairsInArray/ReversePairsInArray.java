package April.problem_lcof_51_ReversePairsInArray;

/*
 * 面试题51. 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 *
 * 示例 1:
 * 输入: [7,5,6,4]
 * 输出: 5
 *
 * 限制：0 <= 数组长度 <= 50000
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

/**
 * @Author hustffx
 * @Date 2020/4/24 10:21
 */
public class ReversePairsInArray {
    /**
     * 方法1：暴力破解（超时）
     */
    public int reversePairs1(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 方法2：分治法（借助归并排序统计）
     * 利用「归并排序」计算逆序对，是非常经典的做法；
     * 关键在于「合并两个有序数组」的步骤，利用数组的部分有序性，一下子计算出一个数之前或者之后元素的逆序的个数；
     * 前面「分」的时候什么都不做，「合」的过程中计算「逆序对」的个数；
     * 「排序」的工作是必要的，正是因为「排序」才能在下一轮利用顺序关系加快逆序数的计算，也能避免重复计算；
     * 在代码实现上，只需要在「归并排序」代码的基础上，加上「逆序对」个数的计算，计算公式需要自己在草稿纸上推导。
     */
    public int reversePairs2(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }

        int[] copy = new int[n];
        for (int i = 0; i < n; i++) {
            copy[i] = nums[i];
        }

        int[] tmp = new int[n];
        return reversePairs(copy, 0, n - 1, tmp);
    }

    /**
     * 计算逆序数对数并排序
     *
     * @param nums
     * @param start
     * @param end
     * @param tmp
     * @return
     */
    private int reversePairs(int[] nums, int start, int end, int[] tmp) {
        if (start == end) {
            return 0;
        }

        int mid = (start + end) >> 1;
        int leftCount = reversePairs(nums, start, mid, tmp);
        int rightCount = reversePairs(nums, mid + 1, end, tmp);

        // 如果整个数组已经有序，则无需合并
        if (nums[mid] <= nums[mid + 1]) {
            return leftCount + rightCount;
        }

        int crossCount = mergeCount(nums, start, mid, end, tmp);
        return leftCount + rightCount + crossCount;
    }

    /**
     * 归并的过程中计算逆序数，其中nums[start..mid]有序，nums[mid+1..right]有序。
     *
     * @param nums
     * @param start
     * @param mid
     * @param end
     * @param tmp
     * @return
     */
    private int mergeCount(int[] nums, int start, int mid, int end, int[] tmp) {
        for (int i = start; i <= end; i++) {
            tmp[i] = nums[i];
        }

        int i = start;
        int j = mid + 1;

        int count = 0;
        for (int k = start; k <= end; k++) {
            if (i > mid) {
                nums[k] = tmp[j];
                j++;
            } else if (j > end) {
                nums[k] = tmp[i];
                i++;
            } else if (tmp[i] <= tmp[j]) {
                nums[k] = tmp[i];
                i++;
            } else {
                nums[k] = tmp[j];
                j++;
                // 在 j 指向的元素归并回去的时候，计算逆序对的个数
                count += mid - i + 1;
            }
        }
        return count;
    }

    /**
     * 方法3：树形数组
     * 用树状数组解决逆序数问题，也是一个经典的做法。
     * 树状数组是一种实现了高效查询「前缀和」与「单点更新」操作的数据结构。
     * 具体的做法是：
     * 先离散化，将所有的数组元素映射到 0、1、2、3... ，这是为了节约树状数组的空间；
     * 从后向前扫描，边统计边往树状数组里面添加元素，这个过程是「动态的」。
     */
    public int reversePairs3(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }

        // 离散化，节约树形数组法的空间
        // 使用二分搜索树是为了去掉重复元素
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }

        // 把排名存在哈希表中方便查询
        HashMap<Integer, Integer> map = new HashMap<>();
        int rankIndex = 1;
        for (Integer num : set) {
            map.put(num, rankIndex);
            rankIndex++;
        }

        int count = 0;
        // 在树形数组中完成前缀和的计算
        // 规则：从后向前，先给对应的排名+1，再查询前缀和
        FenwickTree fenwickTree = new FenwickTree(map.size());

        for (int i = n - 1; i >= 0; i--) {
            int rank = map.get(nums[i]);
            fenwickTree.update(rank, 1);
            count += fenwickTree.query(rank - 1);
        }

        return count;
    }

    static class FenwickTree {
        private final int[] tree;
        private final int length;

        public FenwickTree(int length) {
            tree = new int[length + 1];
            this.length = length;
        }

        public void update(int i, int delta) {
            while (i <= length) {
                tree[i] += delta;
                i += lowbit(i);
            }
        }

        /**
         * 计算最低非零位。奇数返回1，偶数返回本身
         */
        private int lowbit(int x) {
            return x & (-x);
        }

        public int query(int i) {
            int sum = 0;
            while (i > 0) {
                sum += tree[i];
                i -= lowbit(i);
            }
            return sum;
        }
    }
}
