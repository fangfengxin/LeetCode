package problem_004_MedianOfTwoSortedArrays.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import problem_004_MedianOfTwoSortedArrays.code.MedianOfTwoSortedArrays;

public class MedianOfTwoSortedArraysTest {
    private MedianOfTwoSortedArrays solution;
    private int[] nums1;
    private int[] nums2;
    private double expected;

    @Before
    public void init() {
        solution = new MedianOfTwoSortedArrays();
        nums1 = new int[]{4, 5};
        nums2 = new int[]{1, 2, 3};
        expected = 3;
    }

    @Test
    public void testFindMedian1() {
        double result = solution.findMedian1(nums1, nums2);
        Assert.assertEquals(expected, result, 0);
    }

    @Test
    public void testFindMedian2() {
        double result = solution.findMedian2(nums1, nums2);
        Assert.assertEquals(expected, result, 0);
    }

    @Test
    public void testFindMedian3() {
        double result = solution.findMedian3(nums1, nums2);
        Assert.assertEquals(expected, result, 0);
    }
}
