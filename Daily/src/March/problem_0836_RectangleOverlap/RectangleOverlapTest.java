package March.problem_0836_RectangleOverlap;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RectangleOverlapTest {
    RectangleOverlap solution;
    int[] rec1, rec2;
    boolean expected;

    @Before
    public void setUp() {
        solution = new RectangleOverlap();
        rec1 = new int[]{0, 0, 2, 2};
        rec2 = new int[]{1, 1, 3, 3};
        expected = true;
    }

    @Test
    public void testIsRectangleOverlap1() {
        boolean result = solution.isRectangleOverlap1(rec1, rec2);
        assertEquals(expected, result);
    }
    @Test
    public void testIsRectangleOverlap2() {
        boolean result = solution.isRectangleOverlap2(rec1, rec2);
        assertEquals(expected, result);
    }

}