package July.problem_0063_UniquePathsII;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/7/6 14:26
 */
class UniquePathsIITest {
    private UniquePathsII solution;
    private int[][] obstacleGrid;
    private int expected;

    @BeforeEach
    void setUp() {
        solution = new UniquePathsII();
        obstacleGrid = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        expected = 2;
    }

    @Test
    void uniquePathsWithObstacles() {
        int result = solution.uniquePathsWithObstacles(obstacleGrid);
        assertEquals(expected, result);
    }
}