package May.problem_0084_LargestRectangleInHistogram;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author hustffx
 * @Date 2020/5/30 16:17
 */
class LargestRectangleInHistogramTest {
    private LargestRectangleInHistogram solution;
    private int[] heights;
    private int expected;

    @BeforeEach
    void setUp() {
        solution = new LargestRectangleInHistogram();
        heights = new int[]{2, 1, 5, 6, 2, 3};
        expected = 10;
    }

    @Test
    void largestRectangleArea() {
        int result = solution.largestRectangleArea(heights);
        assertEquals(expected, result);
    }
}