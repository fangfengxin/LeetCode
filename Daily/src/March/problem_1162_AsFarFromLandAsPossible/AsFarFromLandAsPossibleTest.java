package March.problem_1162_AsFarFromLandAsPossible;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AsFarFromLandAsPossibleTest {
    AsFarFromLandAsPossible solution;
    int[][] grid;
    int expected;

    @Before
    public void setUp() {
        solution = new AsFarFromLandAsPossible();
        grid = new int[][]{
                {0, 0, 1, 1, 1},
                {0, 1, 1, 0, 0},
                {0, 0, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 1}
        };
        expected = 2;
    }

    @Test
    public void testMaxDistance1() {
        int result = solution.maxDistance1(grid);
        assertEquals(expected, result);
    }

    @Test
    public void testMaxDistance2() {
        int result = solution.maxDistance2(grid);
        assertEquals(expected, result);
    }

}