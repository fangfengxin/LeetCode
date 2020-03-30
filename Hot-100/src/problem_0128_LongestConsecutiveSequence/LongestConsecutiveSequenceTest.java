package problem_0128_LongestConsecutiveSequence;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestConsecutiveSequenceTest {
    LongestConsecutiveSequence solution;
    int[] nums;
    int expected;

    @Before
    public void setUp() {
        solution = new LongestConsecutiveSequence();
        nums = new int[]{1, 2, 0, 1};
        expected = 3;
    }

    @Test
    public void testLongestConsecutive1() {
        int result = solution.longestConsecutive1(nums);
        assertEquals(expected, result);
    }

    @Test
    public void testLongestConsecutive2() {
        int result = solution.longestConsecutive2(nums);
        assertEquals(expected, result);
    }

    @Test
    public void testLongestConsecutive3() {
        int result = solution.longestConsecutive3(nums);
        assertEquals(expected, result);
    }
}