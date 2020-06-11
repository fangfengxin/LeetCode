package June.problem_0739_DailyTemperatures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @Author hustffx
 * @Date 2020/6/11 10:51
 */
class DailyTemperaturesTest {
    private DailyTemperatures solution;
    private int[] T;
    private int[] expected;

    @BeforeEach
    void setUp() {
        solution = new DailyTemperatures();
        T = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        expected = new int[]{1, 1, 4, 2, 1, 1, 0, 0};
    }

    @Test
    void dailyTemperatures() {
        int[] result = solution.dailyTemperatures(T);
        assertArrayEquals(expected, result);
    }
}