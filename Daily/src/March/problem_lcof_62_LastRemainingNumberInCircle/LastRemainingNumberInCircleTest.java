package March.problem_lcof_62_LastRemainingNumberInCircle;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LastRemainingNumberInCircleTest {
    LastRemainingNumberInCircle solution;
    int n, m, expected;

    @Before
    public void setUp() {
        solution = new LastRemainingNumberInCircle();
        n = 5;
        m = 3;
        expected = 3;
    }

    @Test
    public void testLastRemaining1() {
        int result = solution.lastRemaining1(n, m);
        assertEquals(expected, result);
    }

    @Test
    public void testLastRemaining2() {
        int result = solution.lastRemaining2(n, m);
        assertEquals(expected, result);
    }

    @Test
    public void testLastRemaining3() {
        int result = solution.lastRemaining3(n, m);
        assertEquals(expected, result);
    }
}