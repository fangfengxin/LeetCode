package problem_0064_MinimumPathSum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumPathSumTest {
    MinimumPathSum solution;
    int[][] grid;
    int expected;

    @Before
    public void setUp() {
        solution = new MinimumPathSum();
        grid = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        expected = 7;
    }

    @Test
    public void testMinPathSum1() {
        int result = solution.minPathSum1(grid);
        assertEquals(expected, result);
    }

    @Test
    public void testMinPathSum2() {
        int result = solution.minPathSum2(grid);
        assertEquals(expected, result);
    }

    @Test
    public void testMinPathSum3() {
        int result = solution.minPathSum3(grid);
        assertEquals(expected, result);
    }

    @Test
    public void testMinPathSum4() {
        int result = solution.minPathSum4(grid);
        assertEquals(expected, result);
    }
}