package problem_0560_SubArraySumEqualsK;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/4/21 15:45
 */
class SubArraySumEqualsKTest {
    private SubArraySumEqualsK solution;
    private int[] nums;
    private int k;
    private int expected;

    @BeforeEach
    void setUp() {
        solution = new SubArraySumEqualsK();
        nums = new int[]{1, 1, 1};
        k = 2;
        expected = 2;
    }

    @Test
    void subarraySum1() {
        int result = solution.subarraySum1(nums, k);
        assertEquals(expected, result);
    }

    @Test
    void subarraySum2() {
        int result = solution.subarraySum2(nums, k);
        assertEquals(expected, result);
    }

    @Test
    void subarraySum3() {
        int result = solution.subarraySum3(nums, k);
        assertEquals(expected, result);
    }
}