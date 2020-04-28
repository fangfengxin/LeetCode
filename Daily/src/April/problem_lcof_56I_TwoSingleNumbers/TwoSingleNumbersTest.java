package April.problem_lcof_56I_TwoSingleNumbers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author hustffx
 * @Date 2020/4/28 10:44
 */
class TwoSingleNumbersTest {
    private TwoSingleNumbers solution;
    private int[] nums;
    private int[] expected;

    @BeforeEach
    void setUp() {
        solution = new TwoSingleNumbers();
        nums = new int[]{1, 2, 10, 4, 1, 4, 3, 3};
        expected = new int[]{2, 10};
    }

    @Test
    void singleNumbers1() {
        int[] result = solution.singleNumbers1(nums);
        assertArrayEquals(expected, result);
    }

    @Test
    void singleNumbers2() {
        int[] result = solution.singleNumbers2(nums);
        assertArrayEquals(expected, result);
    }
}