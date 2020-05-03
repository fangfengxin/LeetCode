package May.problem_0053_MaximumSubArray;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author hustffx
 * @Date 2020/5/3 15:47
 */
class MaximumSubArrayTest {
    private MaximumSubArray solution;
    private int[] nums;
    private int expected;

    @BeforeEach
    void setUp() {
        solution = new MaximumSubArray();
        nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        expected = 6;
    }

    @Test
    void maxSubArray1() {
        int result = solution.maxSubArray1(nums);
        assertEquals(expected, result);
    }

    @Test
    void maxSubArray2() {
        int result = solution.maxSubArray2(nums);
        assertEquals(expected, result);
    }

    @Test
    void maxSubArray3() {
        int result = solution.maxSubArray3(nums);
        assertEquals(expected, result);
    }
}