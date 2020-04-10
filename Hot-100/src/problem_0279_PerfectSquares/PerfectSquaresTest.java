package problem_0279_PerfectSquares;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PerfectSquaresTest {
    private PerfectSquares solution;
    private int n;
    private int expected;

    @Before
    public void setUp() {
        solution = new PerfectSquares();
        n = 12;
        expected = 3;
    }

    @Test
    public void testNumSquares1() {
        int result = solution.numSquares1(n);
        assertEquals(expected, result);
    }

    @Test
    public void testNumSquares2() {
        int result = solution.numSquares2(n);
        assertEquals(expected, result);
    }

    @Test
    public void testNumSquares3() {
        int result = solution.numSquares3(n);
        assertEquals(expected, result);
    }

    @Test
    public void testNumSquares4() {
        int result = solution.numSquares4(n);
        assertEquals(expected, result);
    }
}