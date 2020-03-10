package problem_0062_UniquePaths;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UniquePathsTest {
    UniquePaths solution;
    int m, n, expected;

    @Before
    public void setUp() {
        solution = new UniquePaths();
        m = 10;
        n = 10;
        expected = 48620;
    }

    @Test
    public void testUniquePaths1() {
        int result = solution.uniquePaths1(m, n);
        assertEquals(expected, result);
    }

    @Test
    public void testUniquePaths2() {
        int result = solution.uniquePaths2(m, n);
        assertEquals(expected, result);
    }
}