package April.problem_lcof_51_ReversePairsInArray;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author hustffx
 * @Date 2020/4/24 10:22
 */
class ReversePairsInArrayTest {
    private ReversePairsInArray solution;
    private int[] nums;
    private int expected;

    @BeforeEach
    void setUp() {
        solution = new ReversePairsInArray();
        nums = new int[]{7, 5, 6, 4};
        expected = 5;
    }

    @Test
    void reversePairs1() {
        int result = solution.reversePairs1(nums);
        assertEquals(expected, result);
    }

    @Test
    void reversePairs2() {
        int result = solution.reversePairs2(nums);
        assertEquals(expected, result);
    }

    @Test
    void reversePairs3() {
        int result = solution.reversePairs3(nums);
        assertEquals(expected, result);
    }
}