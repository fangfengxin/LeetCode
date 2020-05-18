package May.problem_0152_MaximumProductSubarray;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaximumProductSubarrayTest {
    MaximumProductSubarray solution;
    int[] nums;
    int expected;

    @Before
    public void setUp() {
        solution = new MaximumProductSubarray();
        nums = new int[]{2, 3, -2, 4};
        expected = 6;
    }

    @Test
    public void testMaxProduct1() {
        int result = solution.maxProduct1(nums);
        assertEquals(expected, result);
    }

    @Test
    public void testMaxProduct2() {
        int result = solution.maxProduct2(nums);
        assertEquals(expected, result);
    }

    @Test
    public void testMaxProduct3() {
        int result = solution.maxProduct3(nums);
        assertEquals(expected, result);
    }
}