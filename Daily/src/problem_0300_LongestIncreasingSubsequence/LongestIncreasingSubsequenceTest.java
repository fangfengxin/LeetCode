package problem_0300_LongestIncreasingSubsequence;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LongestIncreasingSubsequenceTest {
    LongestIncreasingSubsequence solution;
    int[] nums;
    int expected;

    @Before
    public void setUp() {
        solution = new LongestIncreasingSubsequence();
        nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        expected = 4;
    }

    @Test
    public void testLengthOfLIS1() {
        int result = solution.lengthOfLIS1(nums);
        assertEquals(expected, result);
    }
    @Test
    public void testLengthOfLIS2() {
        int result = solution.lengthOfLIS2(nums);
        assertEquals(expected, result);
    }

}