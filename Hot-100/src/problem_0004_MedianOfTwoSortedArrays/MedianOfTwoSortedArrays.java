package problem_0004_MedianOfTwoSortedArrays;

/*
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 则中位数是 2.0
 *
 * 示例 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 则中位数是 (2 + 3)/2 = 2.5
 */
public class MedianOfTwoSortedArrays {
    /*
     * 方法1：暴力破解
     * 首先将两个有序数组归并，再求中位数。
     * 但是时间复杂度达到了O(m+n)。
     */
    public double findMedian1(int[] nums1, int[] nums2) {
        double result;
        int m = 0, n = 0, size = nums1.length + nums2.length;
        int[] nums = new int[size];
        while (m < nums1.length || n < nums2.length) {
            if (m < nums1.length && n < nums2.length) {
                if (nums1[m] < nums2[n]) {
                    nums[m + n] = nums1[m];
                    m++;
                } else {
                    nums[m + n] = nums2[n];
                    n++;
                }
            } else if (m < nums1.length) {
                nums[m + n] = nums1[m];
                m++;
            } else {
                nums[m + n] = nums2[n];
                n++;
            }
        }
        if (size % 2 == 0) {
            result = (nums[size / 2 - 1] + nums[size / 2]) / 2.0;
        } else {
            result = nums[size / 2];
        }
        return result;
    }

    /*
     * 方法2：寻找第(m+n)/2小的数
     */
    public double findMedian2(int[] nums1, int[] nums2) {
        double result = 0;
        int count = nums1.length + nums2.length;
        /*if (count % 2 == 0) {
            result = (getkth(nums1, nums2, count / 2) + getkth(nums1, nums2, count / 2 + 1)) / 2.0;
        } else {
            result = getkth(nums1, nums2, count / 2 + 1);
        }*/
        // 合并奇数和偶数的情况
        result = (getkth(nums1, nums2, (count + 1) / 2) + getkth(nums1, nums2, count / 2 + 1)) / 2.0;
        return result;
    }

    public int getkth(int[] nums1, int[] nums2, int k) {
        int start1 = 0, start2 = 0, len1 = nums1.length, len2 = nums2.length;
        while (len1 != 0 && len2 != 0) {
            // 每次排除某一个数组的前k/2个元素
            if (k == 1) return Math.min(nums1[start1], nums2[start2]);
            int i = Math.min(len1, k / 2);
            int j = Math.min(len2, k / 2);
            if (nums1[start1 + i - 1] < nums2[start2 + j - 1]) {
                start1 += i;
                len1 -= i;
                k -= i;
            } else {
                start2 += j;
                len2 -= j;
                k -= j;

            }
        }
        if (len1 == 0) return nums2[start2 + k - 1];
        if (len2 == 0) return nums1[start1 + k - 1];
        throw new IllegalArgumentException("No k-th element");
    }

    /*
     * 方法3：二分法
     * 将两个数组进行切分，数值小的部分组合到一起，数值大的部分也组合到一起。
     * 中位数就跟基本切割成两半时两部分的最小值和最大值有关。
     */
    public double findMedian3(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (nums1.length > nums2.length)
            return findMedian3(nums2, nums1); // 保证数组1的长度不比数组2大
        int halfLen = (m + n + 1) / 2; // 数值小的部分包含的元素个数
        int iMin = 0, iMax = m; // 数组1划分位置的动态范围
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i != m && j != 0 && nums2[j - 1] > nums1[i]) {
                iMin = i + 1;
            } else if (i != 0 && j != n && nums1[i - 1] > nums2[j]) {
                iMax = i - 1;
            } else {
                int low, high;
                if (i == 0) {
                    low = nums2[j - 1];
                } else if (j == 0) {
                    low = nums1[i - 1];
                } else {
                    low = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((m + n) % 2 == 0) {
                    if (i == m) {
                        high = nums2[j];
                    } else if (j == n) {
                        high = nums1[i];
                    } else {
                        high = Math.min(nums1[i], nums2[j]);
                    }
                    return (low + high) / 2.0;
                } else {
                    return low;
                }
            }
        }
        throw new IllegalArgumentException("逻辑有误");
    }
}
