package problem_0461_HammingDistance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/4/20 17:45
 */
class HammingDistanceTest {
    private HammingDistance solution;
    private int x;
    private int y;
    private int expected;

    @BeforeEach
    void setUp() {
        solution = new HammingDistance();
        x = 1;
        y = 4;
        expected = 2;
    }

    @Test
    void hammingDistance1() {
        int result = solution.hammingDistance1(x, y);
        assertEquals(expected, result);
    }

    @Test
    void hammingDistance2() {
        int result = solution.hammingDistance2(x, y);
        assertEquals(expected, result);
    }

    @Test
    void hammingDistance3() {
        int result = solution.hammingDistance3(x, y);
        assertEquals(expected, result);
    }
}