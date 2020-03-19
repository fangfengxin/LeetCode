package problem_0084_LargestRectangleInHistogram;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LargestRectangleInHistogramTest {
    LargestRectangleInHistogram solution;
    int[] heights;
    int expected;

    @Before
    public void setUp() {
        solution = new LargestRectangleInHistogram();
        heights = new int[]{2, 1, 5, 6, 2, 3};
        expected = 10;
    }

    @Test
    public void largestRectangleArea1() {
        int result = solution.largestRectangleArea1(heights);
        assertEquals(expected, result);
    }

    @Test
    public void largestRectangleArea2() {
        int result = solution.largestRectangleArea2(heights);
        assertEquals(expected, result);
    }

    @Test
    public void largestRectangleArea3() {
        int result = solution.largestRectangleArea3(heights);
        assertEquals(expected, result);
    }
}