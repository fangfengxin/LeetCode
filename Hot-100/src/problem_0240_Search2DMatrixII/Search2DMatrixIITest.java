package problem_0240_Search2DMatrixII;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Search2DMatrixIITest {
    private Search2DMatrixII solution;
    private int[][] matrix;
    private int target;

    @Before
    public void setUp() {
        solution = new Search2DMatrixII();
        matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        target = 20;
    }

    @Test
    public void testSearchMatrix1() {
        boolean result = solution.searchMatrix1(matrix, target);
        assertFalse(result);
    }

    @Test
    public void testSearchMatrix2() {
        boolean result = solution.searchMatrix2(matrix, target);
        assertFalse(result);
    }
}