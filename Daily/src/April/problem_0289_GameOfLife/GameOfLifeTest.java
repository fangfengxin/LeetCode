package April.problem_0289_GameOfLife;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class GameOfLifeTest {
    GameOfLife solution;
    int[][] board, expected;

    @Before
    public void setUp() {
        solution = new GameOfLife();
        board = new int[][]{
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        expected = new int[][]{
                {0, 0, 0},
                {1, 0, 1},
                {0, 1, 1},
                {0, 1, 0}
        };
    }

    @Test
    public void testGameOfLife1() {
        solution.gameOfLife1(board);
        assertArrayEquals(expected, board);
    }

    @Test
    public void testGameOfLife2() {
        solution.gameOfLife2(board);
        assertArrayEquals(expected, board);
    }
}