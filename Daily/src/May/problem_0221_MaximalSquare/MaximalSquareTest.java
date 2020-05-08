package May.problem_0221_MaximalSquare;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author hustffx
 * @date 2020/5/8 10:09
 */
class MaximalSquareTest {
    private MaximalSquare solution;
    private char[][] matrix;
    private int expected;

    @BeforeEach
    void setUp() {
        solution = new MaximalSquare();
        matrix = new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        expected = 4;
    }

    @Test
    void maximalSquare() {
        int result = solution.maximalSquare(matrix);
        assertEquals(expected, result);
    }
}