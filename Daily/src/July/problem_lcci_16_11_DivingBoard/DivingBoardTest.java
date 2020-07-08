package July.problem_lcci_16_11_DivingBoard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @Author hustffx
 * @Date 2020/7/8 20:01
 */
class DivingBoardTest {
    private DivingBoard solution;
    private int shorter;
    private int longer;
    private int k;
    private int[] expected;

    @BeforeEach
    void setUp() {
        solution = new DivingBoard();
        shorter = 1;
        longer = 2;
        k = 3;
        expected = new int[]{3, 4, 5, 6};
    }

    @Test
    void divingBoard() {
        int[] result = solution.divingBoard(shorter, longer, k);
        assertArrayEquals(expected, result);
    }
}