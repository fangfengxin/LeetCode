package April.problem_0542_ZeroOneMatrix;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ZeroOneMatrixTest {
    private ZeroOneMatrix solution;
    private int[][] matrix;
    private int[][] expected;

    @Before
    public void setUp() {
        solution = new ZeroOneMatrix();
        matrix = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };
        expected = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {1, 2, 1}
        };
    }

    @Test
    public void testUpdateMatrix1() {
        int[][] result = solution.updateMatrix1(matrix);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testUpdateMatrix2() {
        int[][] result = solution.updateMatrix2(matrix);
        assertArrayEquals(expected, result);
    }
}