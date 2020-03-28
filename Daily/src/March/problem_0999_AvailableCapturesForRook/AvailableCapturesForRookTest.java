package March.problem_0999_AvailableCapturesForRook;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AvailableCapturesForRookTest {
    AvailableCapturesForRook solution;
    char[][] board;
    int expected;

    @Before
    public void setUp() {
        solution = new AvailableCapturesForRook();
        board = new char[][]{
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'p', 'p', '.', 'R', '.', 'p', 'B', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'B', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'}
        };
        expected = 3;
    }

    @Test
    public void numRookCaptures() {
        int result = solution.numRookCaptures(board);
        assertEquals(expected, result);
    }
}