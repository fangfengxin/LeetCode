package March.problem_0892_SurfaceAreaOf3DShapes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SurfaceAreaOf3DShapesTest {
    SurfaceAreaOf3DShapes solution;
    int[][] grid;
    int expected;

    @Before
    public void setUp() {
        solution = new SurfaceAreaOf3DShapes();
        grid = new int[][]{{2, 2, 2}, {2, 1, 2}, {2, 2, 2}};
        expected = 46;
    }

    @Test
    public void testSurfaceArea() {
        int result = solution.surfaceArea(grid);
        assertEquals(expected, result);
    }
}