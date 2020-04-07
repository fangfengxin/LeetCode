package problem_0221_MaximalSquare;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaximalSquareTest {
    MaximalSquare solution;
    char[][] matrix;
    int expected;

    @Before
    public void setUp() {
        solution = new MaximalSquare();
        matrix = new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        expected = 4;
    }

    @Test
    public void testMaximalSquare1() {
        int result = solution.maximalSquare1(matrix);
        assertEquals(expected, result);
    }

    @Test
    public void testMaximalSquare2() {
        int result = solution.maximalSquare2(matrix);
        assertEquals(expected, result);
    }
}