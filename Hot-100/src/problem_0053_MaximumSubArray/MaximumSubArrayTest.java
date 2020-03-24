package problem_0053_MaximumSubArray;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MaximumSubArrayTest {
    private MaximumSubArray solution;
    private int[] nums;
    private int expected;

    @Before
    public void init() {
        solution = new MaximumSubArray();
        nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        expected = 6;
    }

    @Test
    public void testMaxSubarray1() {
        int result = solution.maxSubArray1(nums);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testMaxSubarray2() {
        int result = solution.maxSubArray2(nums);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testMaxSubarray3() {
        int result = solution.maxSubArray3(nums);
        Assert.assertEquals(expected, result);
    }
}
