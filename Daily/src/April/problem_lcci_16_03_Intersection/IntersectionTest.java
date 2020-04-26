package April.problem_lcci_16_03_Intersection;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntersectionTest {
    private Intersection solution;
    private int[] start1, end1, start2, end2;
    private double[] expected;

    @Before
    public void setUp() {
        solution = new Intersection();
        start1 = new int[]{0, 0};
        end1 = new int[]{1, 0};
        start2 = new int[]{1, 1};
        end2 = new int[]{0, -1};
        expected = new double[]{0.5, 0};
    }

    @Test
    public void testIntersection() {
        double[] result = solution.intersection(start1, end1, start2, end2);
        assertArrayEquals(expected, result, 1e-6);
    }
}