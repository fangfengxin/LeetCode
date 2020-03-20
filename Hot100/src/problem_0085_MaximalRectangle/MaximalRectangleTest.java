package problem_0085_MaximalRectangle;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaximalRectangleTest {
    MaximalRectangle solution;
    char[][] matrix;
    int expected;

    @Before
    public void setUp() {
        solution = new MaximalRectangle();
        matrix = new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        expected = 6;
    }

    @Test
    public void testMaximalRectangle1() {
        int result = solution.maximalRectangle1(matrix);
        assertEquals(expected, result);
    }
    @Test
    public void testMaximalRectangle2() {
        int result = solution.maximalRectangle2(matrix);
        assertEquals(expected, result);
    }

}