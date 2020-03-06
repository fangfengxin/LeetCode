package problem_048_RotateImage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RotateImageTest {
    private RotateImage solution;
    private int[][] matrix;
    private int[][] expected;

    @Before
    public void init() {
        solution = new RotateImage();
        matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        expected = new int[][]{
                {7, 4, 1},
                {8, 5, 2},
                {9, 6, 3}
        };
    }

    @Test
    public void testRotate1() {
        solution.rotate1(matrix);
        Assert.assertArrayEquals(expected, matrix);
    }

    @Test
    public void testRotate2() {
        solution.rotate2(matrix);
        Assert.assertArrayEquals(expected, matrix);
    }
}
