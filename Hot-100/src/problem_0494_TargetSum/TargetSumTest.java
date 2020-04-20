package problem_0494_TargetSum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/4/20 18:10
 */
class TargetSumTest {
    private TargetSum solution;
    private int[] nums;
    private int S;
    private int expected;

    @BeforeEach
    void setUp() {
        solution = new TargetSum();
        nums = new int[]{1, 1, 1, 1, 1};
        S = 3;
        expected = 5;
    }

    @Test
    void findTargetSumWays1() {
        int result = solution.findTargetSumWays1(nums, S);
        assertEquals(expected, result);
    }

    @Test
    void findTargetSumWays2() {
        int result = solution.findTargetSumWays2(nums, S);
        assertEquals(expected, result);
    }

    @Test
    void findTargetSumWays3() {
        int result = solution.findTargetSumWays3(nums, S);
        assertEquals(expected, result);
    }
}