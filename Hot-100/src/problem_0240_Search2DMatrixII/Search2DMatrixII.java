package problem_0240_Search2DMatrixII;

/*
 * 240. 搜索二维矩阵 II
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。
 * 该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 * 示例:
 * 现有矩阵 matrix 如下：
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * 给定 target = 20，返回 false。
 */


public class Search2DMatrixII {
    /**
     * 方法1：二分搜索矩阵
     */
    public boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        for (int[] rows : matrix) {
            if (rows[0] > target) {
                break;
            }
            if (rows[rows.length - 1] < target) {
                continue;
            }
            if (binarySearch(rows, target)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 二分搜索数组中是否包含 target
     *
     * @param nums   待搜索数组
     * @param target 搜索目标值
     */
    private boolean binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    /**
     * 方法2：类比二叉搜索树
     * 从矩阵左下角开始遍历
     * 当前元素大于 target 就向上搜索
     * 当前元素小于 target 就向右搜索
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col < matrix[0].length) {
            int cur = matrix[row][col];
            if (cur > target) {
                row--;
            } else if (cur < target) {
                col++;
            } else {
                return true;
            }
        }
        return false;
    }
}
