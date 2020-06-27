package June.problem_0041_FirstMissingPositive;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/6/27 12:29
 */
class FirstMissingPositiveTest {
    private FirstMissingPositive solution;
    private int[] nums;
    private int expected;

    @BeforeEach
    void setUp() {
        solution = new FirstMissingPositive();
        nums = new int[]{3, 4, -1, 1};
        expected = 2;
    }

    @Test
    void firstMissingPositive1() {
        int result = solution.firstMissingPositive1(nums);
        assertEquals(expected, result);
    }

    @Test
    void firstMissingPositive2() {
        int result = solution.firstMissingPositive2(nums);
        assertEquals(expected, result);
    }
}