package June.problem_0209_MinimumSizeSubarraySum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/6/28 18:15
 */
class MinimumSizeSubarraySumTest {
    private MinimumSizeSubarraySum solution;
    private int s;
    private int[] nums;
    private int expected;

    @BeforeEach
    void setUp() {
        solution = new MinimumSizeSubarraySum();
        s = 7;
        nums = new int[]{2, 3, 1, 2, 4, 3};
        expected = 2;
    }

    @Test
    void minSubArrayLen1() {
        int result = solution.minSubArrayLen1(s, nums);
        assertEquals(expected, result);
    }

    @Test
    void minSubArrayLen2() {
        int result = solution.minSubArrayLen2(s, nums);
        assertEquals(expected, result);
    }
}