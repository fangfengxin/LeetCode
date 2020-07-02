package July.problem_0378_KthSmallestElementInSortedMatrix;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/7/2 11:46
 */
class KthSmallestElementInSortedMatrixTest {
    private KthSmallestElementInSortedMatrix solution;
    private int[][] matrix;
    private int k;
    private int expected;

    @BeforeEach
    void setUp() {
        solution = new KthSmallestElementInSortedMatrix();
        matrix = new int[][]{
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        k = 8;
        expected = 13;
    }

    @Test
    void kthSmallest() {
        int result = solution.kthSmallest(matrix, k);
        assertEquals(expected, result);
    }
}