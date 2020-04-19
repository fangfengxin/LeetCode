package problem_0416_PartitionEqualSubsetSum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/4/19 14:05
 */
class PartitionEqualSubsetSumTest {
    private PartitionEqualSubsetSum solution;
    private int[] nums;
    private boolean expected;

    @BeforeEach
    void setUp() {
        solution = new PartitionEqualSubsetSum();
        nums = new int[]{1, 5, 11, 5};
        expected = true;
    }

    @Test
    void canPartition1() {
        boolean result = solution.canPartition1(nums);
        assertEquals(expected, result);
    }

    @Test
    void canPartition2() {
        boolean result = solution.canPartition2(nums);
        assertEquals(expected, result);
    }
}