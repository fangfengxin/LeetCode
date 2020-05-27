package May.problem_0974_SubarraySumsDivisibleByK;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/5/27 10:17
 */
class SubarraySumsDivisibleByKTest {
    private SubarraySumsDivisibleByK solution;
    private int[] A;
    private int K;
    private int expected;

    @BeforeEach
    void setUp() {
        solution = new SubarraySumsDivisibleByK();
        A = new int[]{4, 5, 0, -2, -3, 1};
        K = 5;
        expected = 7;
    }

    @Test
    void subarraysDivByK1() {
        int result = solution.subarraysDivByK1(A, K);
        assertEquals(expected, result);
    }

    @Test
    void subarraysDivByK2() {
        int result = solution.subarraysDivByK2(A, K);
        assertEquals(expected, result);
    }

    @Test
    void subarraysDivByK3() {
        int result = solution.subarraysDivByK3(A, K);
        assertEquals(expected, result);
    }
}