package May.problem_0560_SubarraySumEqualsK;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author hustffx
 * @Date 2020/5/15 18:51
 */
class SubarraySumEqualsKTest {
    private SubarraySumEqualsK solution;
    private int[] nums;
    private int k;
    private int expected;

    @BeforeEach
    void setUp() {
        solution = new SubarraySumEqualsK();
        nums = new int[]{1, 1, 1};
        k = 2;
        expected = 2;
    }

    @Test
    void subarraySum() {
        int result = solution.subarraySum(nums, k);
        assertEquals(expected, result);
    }
}