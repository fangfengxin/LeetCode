package March.problem_lcci_10_01_SortedMerge;

import java.util.Arrays;

/*
 * 面试题 10.01. 合并排序的数组
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。
 * 编写一个方法，将 B 合并入 A 并排序。
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 *
 * 示例:
 * 输入:
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 * 输出: [1,2,2,3,5,6]
 *
 * 说明: A.length == n + m
 */
public class SortedMerge {
    /**
     * 方法1：直接合并后排序
     */
    public void merge1(int[] A, int m, int[] B, int n) {
        System.arraycopy(B, 0, A, m, n);
        Arrays.sort(A);
    }

    /**
     * 方法2：逆向双指针
     */
    public void merge2(int[] A, int m, int[] B, int n) {
        while (m > 0 || n > 0) {
            if (m > 0 && n > 0) { // 对比选出较大的数放在 m + n - 1 的位置，并将选出此数的指针向前移动
                A[m + n - 1] = A[m - 1] > B[n - 1] ? A[m-- - 1] : B[n-- - 1];
            } else if (n > 0) { // 如果 n 不为 0，则 B 没遍历完，直接全移到 A 中相同的位置
                A[n - 1] = B[n-- - 1];
            } else { // 如果 m 不为 0，则 A 没遍历完，都已经在 A 中不用再管
                break;
            }
        }
    }
}
