package April.problem_lcci_01_07_RotateMatrix;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class RotateMatrixTest {
    RotateMatrix solution;
    int[][] matrix;
    int[][] expected;

    @Before
    public void setUp() {
        solution = new RotateMatrix();
        matrix = new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        expected = new int[][]{
                {15, 13, 2, 5},
                {14, 3, 4, 1},
                {12, 6, 8, 9},
                {16, 7, 10, 11}
        };
    }

    @Test
    public void testRotate() {
        solution.rotate(matrix);
        assertArrayEquals(expected, matrix);
    }
}