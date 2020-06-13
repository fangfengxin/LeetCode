package June.problem_0070_ClimbingStairs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/6/13 11:17
 */
class ClimbingStairsTest {
    private ClimbingStairs solution;
    private int n;
    private int expected;

    @BeforeEach
    void setUp() {
        solution = new ClimbingStairs();
        n = 3;
        expected = 3;
    }

    @Test
    void climbStairs() {
        int result = solution.climbStairs(n);
        assertEquals(expected, result);
    }
}