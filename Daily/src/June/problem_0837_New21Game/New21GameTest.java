package June.problem_0837_New21Game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/6/3 10:47
 */
class New21GameTest {
    private New21Game solution;
    private int N, K, W;
    private double expected;

    @BeforeEach
    void setUp() {
        solution = new New21Game();
        N = 21;
        K = 17;
        W = 10;
        expected = 0.73278;
    }

    @Test
    void new21Game() {
        double result = solution.new21Game(N, K, W);
        assertEquals(expected, result, 1e-5);
    }
}