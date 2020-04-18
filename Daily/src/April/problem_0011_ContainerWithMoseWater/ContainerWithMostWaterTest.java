package April.problem_0011_ContainerWithMoseWater;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/4/18 11:20
 */
class ContainerWithMostWaterTest {
    private ContainerWithMostWater solution;
    private int[] height;
    private int expected;

    @BeforeEach
    void setUp() {
        solution = new ContainerWithMostWater();
        height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        expected = 49;
    }

    @Test
    void maxArea() {
        int result = solution.maxArea(height);
        assertEquals(expected, result);
    }
}