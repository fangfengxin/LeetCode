package March.problem_0695_MaxAreaOfIsland;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxAreaOfIslandTest {
    MaxAreaOfIsland solution;
    int[][] grid;
    int expected;

    @Before
    public void setUp() {
        solution = new MaxAreaOfIsland();
        grid = new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        expected = 6;
    }

    @Test
    public void testMaxAreaOfIsland1() {
        int result = solution.maxAreaOfIsland1(grid);
        assertEquals(expected, result);
    }

    @Test
    public void testMaxAreaOfIsland2() {
        int result = solution.maxAreaOfIsland2(grid);
        assertEquals(expected, result);
    }
}