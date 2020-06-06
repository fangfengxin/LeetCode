package June.problem_0128_LongestConsecutiveSequence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/6/6 9:55
 */
class LongestConsecutiveSequenceTest {
    private LongestConsecutiveSequence solution;
    private int[] nums;
    private int expected;

    @BeforeEach
    void setUp() {
        solution = new LongestConsecutiveSequence();
        nums = new int[]{100, 4, 200, 1, 3, 2};
        expected = 4;
    }

    @Test
    void longestConsecutive() {
        int result = solution.longestConsecutive(nums);
        assertEquals(expected, result);
    }
}