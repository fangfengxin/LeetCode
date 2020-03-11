package problem_1013_PartitionArrayIntoThreePartsWithEqualSum;

import java.util.Arrays;

/*
 * 给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
 * 形式上，如果可以找出索引 i + 1 < j 且满足 (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1]) 就可以将数组三等分。
 *
 * 示例 1：
 * 输出：[0,2,1,-6,6,-7,9,1,2,0,1]
 * 输出：true
 * 解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
 *
 * 示例 2：
 * 输入：[0,2,1,-6,6,7,9,-1,2,0,1]
 * 输出：false
 *
 * 示例 3：
 * 输入：[3,3,6,5,-2,2,5,1,-9,4]
 * 输出：true
 * 解释：3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
 *  
 * 提示：
 * 3 <= A.length <= 50000
 * -10^4 <= A[i] <= 10^4
 */
public class PartitionArrayIntoThreePartsWithEqualSum {
    /*
     * 方法1：暴力破解
     */
    public boolean canThreePartsEqualSum1(int[] A) {
        for (int i = 0; i < A.length - 2; i++) {
            for (int j = i + 2; j < A.length; j++) {
                int index1 = i, index2 = j;
                int sum1 = 0, sum2 = 0, sum3 = 0;
                for (int k = index1 + 1; k < index2; k++) {
                    sum2 += A[k];
                }
                while (index1 >= 0) {
                    sum1 += A[index1--];
                }
                while (index2 < A.length) {
                    sum3 += A[index2++];
                }
                if (sum1 == sum2 && sum2 == sum3) {
                    return true;
                }
            }
        }
        return false;
    }

    /*
     * 方法2：双指针
     */
    public boolean canThreePartsEqualSum2(int[] A) {
        int total = 0;
        for (int i : A) {
            total += i;
        }
        if (total % 3 != 0) {
            return false;
        }
        int leftSum = A[0], rightSum = A[A.length - 1];
        int left = 0, right = A.length - 1;

        /*while (left + 1 < right && leftSum != total / 3) {
            leftSum += A[++left];
        }
        if (leftSum != total / 3) {
            return false;
        }
        while (left + 1 < right && rightSum != total / 3) {
            rightSum += A[--right];
        }
        if (rightSum != total / 3) {
            return false;
        }
        return left + 1 < right;*/

        while (left + 1 < right) {
            if (leftSum == total / 3 && rightSum == total / 3) {
                return true;
            }
            if (leftSum != total / 3) {
                leftSum += A[++left];
            }
            if (rightSum != total / 3) {
                rightSum += A[--right];
            }
        }
        return false;
    }
}
