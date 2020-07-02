package July.problem_0378_KthSmallestElementInSortedMatrix;

/*
 * 378. 有序矩阵中第K小的元素
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 *
 * 示例：
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 * 返回 13。
 *
 * 提示：你可以假设 k 的值永远是有效的，1 ≤ k ≤ n^2 。
 */

/**
 * @Author hustffx
 * @Date 2020/7/2 11:20
 */
public class KthSmallestElementInSortedMatrix {
    /**
     * 方法：二分查找
     */
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;

        int low = matrix[0][0];
        int high = matrix[n - 1][n - 1];

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (check(matrix, mid, k)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    /**
     * 计算小于等于 mid 的元素个数是否不小于 k
     *
     * @param matrix
     * @param mid
     * @param k
     * @return
     */
    private boolean check(int[][] matrix, int mid, int k) {
        int n = matrix.length;

        int i = n - 1;
        int j = 0;
        int count = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                count += i + 1;
                j++;
            } else {
                i--;
            }
        }

        return count >= k;
    }
}
