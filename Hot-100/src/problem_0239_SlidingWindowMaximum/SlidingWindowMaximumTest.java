package problem_0239_SlidingWindowMaximum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SlidingWindowMaximumTest {
    SlidingWindowMaximum solution;
    int[] nums;
    int k;
    int[] expected;

    @Before
    public void setUp() {
        solution = new SlidingWindowMaximum();
        nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        k = 3;
        expected = new int[]{3, 3, 5, 5, 6, 7};
    }

    @Test
    public void testMaxSlidingWindow1() {
        int[] result = solution.maxSlidingWindow1(nums, k);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testMaxSlidingWindow2() {
        int[] result = solution.maxSlidingWindow2(nums, k);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testMaxSlidingWindow3() {
        int[] result = solution.maxSlidingWindow3(nums, k);
        assertArrayEquals(expected, result);
    }
}