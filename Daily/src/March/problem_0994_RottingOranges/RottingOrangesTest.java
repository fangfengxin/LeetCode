package March.problem_0994_RottingOranges;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RottingOrangesTest {
    RottingOranges solution;
    int[][] grid;
    int expected;

    @Before
    public void setUp() {
        solution = new RottingOranges();

        /*grid = new int[][]{
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        expected = 4;*/

        grid = new int[][]{
                {2, 1, 1},
                {0, 1, 1},
                {1, 0, 1}
        };
        expected = -1;
    }

    @Test
    public void testOrangesRotting() {
        int result = solution.orangesRotting(grid);
        assertEquals(expected, result);
    }
}