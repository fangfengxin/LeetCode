package problem_0075_SortColors;

/*
 * 75. 颜色分类
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 注意:不能使用代码库中的排序函数来解决这道题。
 *
 * 示例:
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 *
 * 进阶：
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出 0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 */
public class SortColors {
    /*
     * 方法1：计数（两次遍历）
     */
    public void sortColors1(int[] nums) {
        int[] count = new int[3];
        for (int num : nums) {
            count[num]++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (count[0] != 0) {
                nums[i] = 0;
                count[0]--;
            } else if (count[1] != 0) {
                nums[i] = 1;
                count[1]--;
            } else {
                nums[i] = 2;
                count[2]--;
            }
        }
    }

    /*
     * 方法2：双指针（一次遍历）
     * 双指针分别指向0的最右边界和2的最左边界
     */
    public void sortColors2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int cur = 0;
        int tmp;
        while (cur <= right) {
            if (nums[cur] == 0) {
                tmp = nums[left];
                nums[left] = nums[cur];
                nums[cur] = tmp;
                left++;
                cur++;
            } else if (nums[cur] == 2) {
                tmp = nums[right];
                nums[right] = nums[cur];
                nums[cur] = tmp;
                right--;
            } else {
                cur++;
            }
        }
    }
}
