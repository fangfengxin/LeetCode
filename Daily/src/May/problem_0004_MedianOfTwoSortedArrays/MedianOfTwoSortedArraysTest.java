package May.problem_0004_MedianOfTwoSortedArrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/5/24 10:42
 */
class MedianOfTwoSortedArraysTest {
    private MedianOfTwoSortedArrays solution;
    private int[] nums1;
    private int[] nums2;
    private double expected;

    @BeforeEach
    void setUp() {
        solution = new MedianOfTwoSortedArrays();
        nums1 = new int[]{1, 2};
        nums2 = new int[]{3, 4};
        expected = 2.5;
    }

    @Test
    void findMedianSortedArrays() {
        double result = solution.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, result, 1e-6);
    }
}