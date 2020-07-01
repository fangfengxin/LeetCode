package July.problem_0718_MaximumLengthOfRepeatedSubarray;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/7/1 11:54
 */
class MaximumLengthOfRepeatedSubarrayTest {
    private MaximumLengthOfRepeatedSubarray solution;
    private int[] A;
    private int[] B;
    private int expected;

    @BeforeEach
    void setUp() {
        solution = new MaximumLengthOfRepeatedSubarray();
        A = new int[]{1, 2, 3, 2, 1};
        B = new int[]{3, 2, 1, 4, 7};
        expected = 3;
    }

    @Test
    void findLength1() {
        int result = solution.findLength1(A, B);
        assertEquals(expected, result);
    }
}