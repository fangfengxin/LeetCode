package problem_0406_QueueReconStructionByHeight;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @Author hustffx
 * @Date 2020/4/19 13:26
 */
class QueueReconstructionByHeightTest {
    private QueueReconstructionByHeight solution;
    private int[][] people;
    private int[][] expected;

    @BeforeEach
    void setUp() {
        solution = new QueueReconstructionByHeight();
        people = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        expected = new int[][]{{5, 0}, {7, 0}, {5, 2}, {6, 1}, {4, 4}, {7, 1}};
    }

    @Test
    void reconstructQueue() {
        int[][] result = solution.reconstructQueue(people);
        assertArrayEquals(expected, result);
    }
}