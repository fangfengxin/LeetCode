package June.problem_lcof_29_SpiralMatrix;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @Author hustffx
 * @Date 2020/6/5 13:46
 */
class SpiralMatrixTest {
    private SpiralMatrix solution;
    private int[][] matrix;
    private int[] expected;

    @BeforeEach
    void setUp() {
        solution = new SpiralMatrix();
        matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        expected = new int[]{1, 2, 3, 6, 9, 8, 7, 4, 5};
    }

    @Test
    void spiralOrder() {
        int[] result = solution.spiralOrder(matrix);
        assertArrayEquals(expected, result);
    }
}