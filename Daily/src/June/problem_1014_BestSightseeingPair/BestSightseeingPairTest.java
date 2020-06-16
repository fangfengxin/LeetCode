package June.problem_1014_BestSightseeingPair;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/6/17 0:22
 */
class BestSightseeingPairTest {
    private BestSightseeingPair solution;
    private int[] A;
    private int expected;

    @BeforeEach
    void setUp() {
        solution = new BestSightseeingPair();
        A = new int[]{8, 1, 5, 2, 6};
        expected = 11;
    }

    @Test
    void maxScoreSightseeingPair() {
        int result = solution.maxScoreSightseeingPair(A);
        assertEquals(expected, result);
    }
}